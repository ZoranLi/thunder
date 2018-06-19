package com.tencent.mm.opensdk.openapi;

import android.content.Context;

public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" should not be instantiated");
        throw new RuntimeException(stringBuilder.toString());
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, false);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("createWXAPI, appId = ");
        stringBuilder.append(str);
        stringBuilder.append(", checkSignature = ");
        stringBuilder.append(z);
        return new WXApiImplV10(context, str, z);
    }
}
