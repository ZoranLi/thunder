package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.alibaba.sdk.android.feedback.util.j;
import com.alibaba.sdk.android.feedback.xblink.i.b;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import java.io.File;

class v implements OnClickListener {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            u uVar;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File file = new File(j.a);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
                uVar = this.a;
                stringBuilder = new StringBuilder();
                stringBuilder.append(j.a);
                stringBuilder.append(File.separator);
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(System.currentTimeMillis());
                stringBuilder.append(b.a(stringBuilder2.toString()));
                uVar.f = stringBuilder.toString();
                intent.putExtra("output", Uri.fromFile(new File(this.a.f)));
                this.a.a(0, intent);
                if (this.a.a instanceof Activity) {
                    ((Activity) this.a.a).startActivityForResult(intent, CONFIGID.RECORD_WIDTH);
                    if (this.a.g != null) {
                        this.a.g.b();
                    }
                }
                return;
            }
            file.mkdirs();
            uVar = this.a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(j.a);
            stringBuilder.append(File.separator);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(System.currentTimeMillis());
            stringBuilder.append(b.a(stringBuilder2.toString()));
            uVar.f = stringBuilder.toString();
            intent.putExtra("output", Uri.fromFile(new File(this.a.f)));
            this.a.a(0, intent);
            if (this.a.a instanceof Activity) {
                ((Activity) this.a.a).startActivityForResult(intent, CONFIGID.RECORD_WIDTH);
                if (this.a.g != null) {
                    this.a.g.b();
                }
            }
            return;
        }
        if (i == 1) {
            this.a.a(1, new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI));
            if (this.a.g != null) {
                this.a.g.b();
            }
        }
    }
}
