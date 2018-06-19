package com.igexin.sdk.a;

import android.content.Context;
import com.igexin.b.a.c.a;
import java.io.File;
import java.io.IOException;

public class c {
    private String a;

    public c(Context context) {
        if (context != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/push.pid");
            this.a = stringBuilder.toString();
        }
    }

    public void a() {
        if (!(c() || this.a == null)) {
            try {
                new File(this.a).createNewFile();
            } catch (IOException e) {
                StringBuilder stringBuilder = new StringBuilder("SdkPushSwitch | switchOn, create file = ");
                stringBuilder.append(this.a);
                stringBuilder.append(" exception, ");
                stringBuilder.append(e.toString());
                a.b(stringBuilder.toString());
            }
        }
    }

    public void b() {
        if (c() && this.a != null && !new File(this.a).delete()) {
            StringBuilder stringBuilder = new StringBuilder("SdkPushSwitch | switchOff, delete file = ");
            stringBuilder.append(this.a);
            stringBuilder.append(" failed !!!!!!!!!!!!");
            a.b(stringBuilder.toString());
        }
    }

    public boolean c() {
        return this.a != null ? new File(this.a).exists() : false;
    }
}
