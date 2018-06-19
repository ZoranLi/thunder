package com.ali.auth.third.core.j;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class b {
    public static String a(Context context, String str) {
        Exception e;
        String str2 = "";
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            int available = openFileInput.available();
            if (available > 0) {
                byte[] bArr = new byte[available];
                openFileInput.read(bArr);
                String str3 = new String(bArr, "UTF-8");
                try {
                    openFileInput.close();
                    return str3;
                } catch (Exception e2) {
                    e = e2;
                    str2 = str3;
                    e.printStackTrace();
                    return str2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return str2;
        }
        return str2;
    }

    public static void a(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            openFileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
