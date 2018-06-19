package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.j;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.alibaba.sdk.android.feedback.xblink.i.b;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import java.io.File;

class x implements OnClickListener {
    final /* synthetic */ u a;

    x(u uVar) {
        this.a = uVar;
    }

    public void onClick(View view) {
        Intent intent;
        if (this.a.h[0].equals(view.getTag())) {
            g.a("WXPhoto", "start to open system camera.");
            if (ContextCompat.checkSelfPermission(FeedbackAPI.mContext, "android.permission.CAMERA") != 0) {
                Toast.makeText(FeedbackAPI.mContext, "Camera Permission Denied", 0).show();
                return;
            }
            u uVar;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
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
                if (this.a.a instanceof Activity) {
                    ((Activity) this.a.a).startActivityForResult(intent, CONFIGID.RECORD_WIDTH);
                    if (this.a.g != null) {
                        this.a.g.b();
                    }
                }
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
            if (this.a.a instanceof Activity) {
                ((Activity) this.a.a).startActivityForResult(intent, CONFIGID.RECORD_WIDTH);
                if (this.a.g != null) {
                    this.a.g.b();
                }
            }
        } else if (this.a.h[1].equals(view.getTag())) {
            g.a("WXPhoto", "start to pick photo from system album.");
            intent = new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI);
            if (this.a.a instanceof Activity) {
                ((Activity) this.a.a).startActivityForResult(intent, CONFIGID.RECORD_HEIGHT);
            }
            if (this.a.g != null) {
                this.a.g.b();
            }
        } else {
            g.e("WXPhoto", "take photo cancel, and callback.");
            this.a.e.b(new m());
        }
    }
}
