package com.zaneschepke.wireguardautotunnel.desktop.wifi

import com.zaneschepke.wireguardautotunnel.core.wifi.WifiAuthorization

enum class MacWifiNamePrompt {
    Allow,

    Denied,

    ServicesOff,
}

fun macWifiNamePrompt(status: WifiAuthorization?): MacWifiNamePrompt? =
    when (status) {
        // Null means the helper has not reported yet. Keep the card up until it has a grant.
        null,
        WifiAuthorization.NotDetermined,
        WifiAuthorization.Unsupported -> MacWifiNamePrompt.Allow
        WifiAuthorization.Denied,
        WifiAuthorization.Restricted -> MacWifiNamePrompt.Denied
        WifiAuthorization.ServicesOff -> MacWifiNamePrompt.ServicesOff
        WifiAuthorization.AuthorizedAlways,
        WifiAuthorization.AuthorizedWhenInUse -> null
    }
