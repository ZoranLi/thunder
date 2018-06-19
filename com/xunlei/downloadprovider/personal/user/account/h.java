package com.xunlei.downloadprovider.personal.user.account;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.user.account.a.b;
import com.xunlei.xllib.android.e;
import com.xunlei.xllib.android.e.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: SetAccountPortraitHelper */
public final class h {
    public final int a = 1001;
    final Activity b;
    Context c;
    public String d;
    private File e;

    public h(Activity activity, Context context) {
        this.b = activity;
        this.c = context;
        if (e.b() != null) {
            context = new StringBuilder();
            context.append(Environment.getExternalStorageDirectory());
            context.append("/xunlei/picture");
            activity = new File(context.toString());
            if (!(activity.exists() == null && activity.mkdir() == null)) {
                this.e = new File(activity, b());
                return;
            }
        }
        context = new StringBuilder();
        context.append(a.a());
        context.append("/xunlei/picture");
        activity = new File(context.toString());
        if (!(activity.exists() == null && activity.mkdir() == null)) {
            this.e = new File(activity, b());
        }
    }

    public final void a(String str) {
        Context context = this.b;
        b iVar = new i(this, str);
        str = context.getString(R.string.user_account_portrait_photograph);
        CharSequence string = context.getString(R.string.user_account_portrait_gallery);
        Dialog a = a.a(context, R.layout.alert_notitle_noicon_twice);
        a.findViewById(R.id.cancel).setOnClickListener(new e(a, iVar));
        TextView textView = (TextView) a.findViewById(R.id.item_first);
        textView.setText(str);
        textView.setOnClickListener(new f(a, iVar));
        TextView textView2 = (TextView) a.findViewById(R.id.item_second);
        textView2.setText(string);
        textView2.setOnClickListener(new g(a, iVar));
        a.show();
    }

    public final void b(String str) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (VERSION.SDK_INT >= 24) {
            intent.setFlags(1);
            intent.putExtra("output", FileProvider.getUriForFile(this.b, ApkHelper.AUTHORITIES, this.e));
        } else {
            intent.putExtra("output", Uri.fromFile(this.e));
        }
        this.b.startActivityForResult(intent, 1);
        this.d = "photo";
        k.a(str, this.d);
    }

    private Uri a() {
        return VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(this.b, ApkHelper.AUTHORITIES, this.e) : Uri.fromFile(this.e);
    }

    private void a(boolean z, Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (z && VERSION.SDK_INT >= true) {
            intent.setFlags(1);
        }
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 1000);
        intent.putExtra("outputY", 1000);
        intent.putExtra("output", Uri.fromFile(this.e));
        intent.putExtra("outputFormat", CompressFormat.PNG.toString());
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("return-data", null);
        intent.putExtra("noFaceDetection", true);
        this.b.startActivityForResult(intent, 3);
    }

    private static String b() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss", Locale.CHINA);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(simpleDateFormat.format(date));
        stringBuilder.append(".png");
        return stringBuilder.toString();
    }

    public final void a(String str, ImageView imageView, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str.trim())) {
                Glide.with(imageView.getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.ic_default_avatar).error(R.drawable.ic_default_avatar).dontAnimate().into(new j(this, imageView, z));
            }
        }
    }

    public final void a(int i, int i2, Intent intent, String str) {
        switch (i) {
            case 1:
                if (i2 != -1) {
                    k.a(str, this.d, "cancel");
                    return;
                } else {
                    a(1, a());
                    return;
                }
            case 2:
                switch (i2) {
                    case -1:
                        if (intent != null) {
                            if (VERSION.SDK_INT >= 24) {
                                a(false, m.a(this.c, intent.getData()));
                                return;
                            } else {
                                a(false, intent.getData());
                                return;
                            }
                        }
                        break;
                    case 0:
                        k.a(str, this.d, "cancel");
                        break;
                    default:
                        break;
                }
                return;
            case 3:
                switch (i2) {
                    case -1:
                        try {
                            i = BitmapFactory.decodeStream(this.b.getContentResolver().openInputStream(a()));
                            i2 = new StringBuilder("photo size == ");
                            i2.append(i.getByteCount());
                            i2.append(">>>>");
                            i2.append(i.getByteCount() / 1024);
                            i2.append("kb");
                            LoginHelper.a().a(i, this.d);
                            if (com.xunlei.xllib.android.b.a(this.c) != 0) {
                                XLToast.showToast(this.c, "头像上传中");
                            }
                            LoginHelper.a().b();
                            return;
                        } catch (int i3) {
                            i3.printStackTrace();
                            return;
                        }
                    case 0:
                        k.a(str, this.d, "cancel");
                        break;
                    default:
                        break;
                }
            default:
                break;
        }
    }
}
