package com.duiba.maila.sdk;

import android.content.Context;

public final class s {
    public static boolean a(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == null;
        } catch (Context context2) {
            context2.printStackTrace();
            return false;
        }
    }
}
