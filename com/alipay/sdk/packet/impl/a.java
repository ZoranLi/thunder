package com.alipay.sdk.packet.impl;

import com.alipay.sdk.packet.d;
import com.qihoo360.replugin.RePlugin;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d {
    protected final JSONObject a() throws JSONException {
        return d.a("cashier", RePlugin.PLUGIN_NAME_MAIN);
    }
}
