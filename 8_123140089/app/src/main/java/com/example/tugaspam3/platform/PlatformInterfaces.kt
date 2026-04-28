package com.example.tugaspam3.platform

import kotlinx.coroutines.flow.Flow

/**
 * Interface untuk mendapatkan informasi perangkat (Expect/Actual Pattern)
 */
interface DeviceInfo {
    val brand: String
    val model: String
    val osVersion: String
    fun getFullInfo(): String
}

/**
 * Interface untuk memantau status jaringan (Expect/Actual Pattern)
 */
interface NetworkMonitor {
    val isOnline: Flow<Boolean>
}

/**
 * Interface untuk mendapatkan informasi baterai (Bonus)
 */
interface BatteryInfo {
    val level: Int
    val isCharging: Boolean
}
