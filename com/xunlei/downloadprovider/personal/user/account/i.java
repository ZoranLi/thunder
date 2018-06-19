package com.xunlei.downloadprovider.personal.user.account;

import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.ActivityCompat;
import com.xunlei.downloadprovider.ad.c.b.g;
import com.xunlei.downloadprovider.personal.user.account.a.b;

/* compiled from: SetAccountPortraitHelper */
final class i implements b {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    i(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public final void a(int i) {
        if (i == 0) {
            if (g.a(this.b.c, "android.permission.CAMERA")) {
                this.b.b(this.a);
            } else {
                h hVar = this.b;
                if (VERSION.SDK_INT >= 23) {
                    ActivityCompat.requestPermissions(hVar.b, new String[]{"android.permission.CAMERA"}, 1001);
                }
            }
        }
        if (i == 1) {
            i = this.b;
            String str = this.a;
            Intent intent = new Intent("android.intent.action.PICK", null);
            intent.setDataAndType(Media.EXTERNAL_CONTENT_URI, "image/*");
            i.b.startActivityForResult(intent, 2);
            i.d = "album";
            k.a(str, i.d);
        }
    }
}
