package com.example.tugaspam3.platform

import kotlinx.coroutines.flow.Flow

interface DeviceInfo {
    val brand: String
    val model: String
    val osVersion: String
    fun getFullInfo(): String
}

interface NetworkMonitor {
    val isOnline: Flow<Boolean>
}

interface BatteryInfo {
    val level: Int
    val isCharging: Boolean
}
