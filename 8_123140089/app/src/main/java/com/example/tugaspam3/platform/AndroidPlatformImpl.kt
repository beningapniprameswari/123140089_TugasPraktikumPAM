package com.example.tugaspam3.platform

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.BatteryManager
import android.os.Build
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

/**
 * Implementasi Android untuk DeviceInfo
 */
class AndroidDeviceInfo : DeviceInfo {
    override val brand: String = Build.MANUFACTURER
    override val model: String = Build.MODEL
    override val osVersion: String = Build.VERSION.RELEASE
    
    override fun getFullInfo(): String = "$brand $model (Android $osVersion)"
}

/**
 * Implementasi Android untuk NetworkMonitor
 */
class AndroidNetworkMonitor(context: Context) : NetworkMonitor {
    private val connectivityManager = 
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override val isOnline: Flow<Boolean> = callbackFlow {
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                launch { send(true) }
            }

            override fun onLost(network: Network) {
                launch { send(false) }
            }

            override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
                val hasInternet = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                launch { send(hasInternet) }
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        
        connectivityManager.registerNetworkCallback(request, callback)

        // Kirim status awal
        val currentNetwork = connectivityManager.activeNetwork
        val caps = connectivityManager.getNetworkCapabilities(currentNetwork)
        send(caps?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false)

        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }.distinctUntilChanged()
}

/**
 * Implementasi Android untuk BatteryInfo (Bonus)
 */
class AndroidBatteryInfo(private val context: Context) : BatteryInfo {
    private val batteryIntent: Intent?
        get() = context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))

    override val level: Int
        get() {
            val level = batteryIntent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
            val scale = batteryIntent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
            return if (level != -1 && scale != -1) (level * 100 / scale.toFloat()).toInt() else -1
        }

    override val isCharging: Boolean
        get() {
            val status = batteryIntent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
            return status == BatteryManager.BATTERY_STATUS_CHARGING || 
                   status == BatteryManager.BATTERY_STATUS_FULL
        }
}
