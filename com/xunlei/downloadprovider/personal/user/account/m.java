package com.xunlei.downloadprovider.personal.user.account;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.h.a.a.a;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper.Entrance;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity$From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/* compiled from: UserAccountUtil */
public final class m {
    private static String[] a = new String[]{"Mi Note 2"};

    public static boolean a() {
        String str = Build.MODEL;
        for (String equals : a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String a(int i, int i2) {
        if (i != 0) {
            if (i2 != 0) {
                String[] strArr = new String[]{"魔羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座"};
                int i3 = i - 1;
                if (i2 < new int[]{20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22}[i3]) {
                    i = i3;
                } else if (i == 12) {
                    i = 0;
                }
                return strArr[i];
            }
        }
        return "";
    }

    public static boolean a(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "location";	 Catch:{ Exception -> 0x001f }
        r3 = r3.getSystemService(r1);	 Catch:{ Exception -> 0x001f }
        r3 = (android.location.LocationManager) r3;	 Catch:{ Exception -> 0x001f }
        if (r3 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x001f }
    L_0x000b:
        return r0;	 Catch:{ Exception -> 0x001f }
    L_0x000c:
        r1 = "gps";	 Catch:{ Exception -> 0x001f }
        r1 = r3.isProviderEnabled(r1);	 Catch:{ Exception -> 0x001f }
        r2 = "network";	 Catch:{ Exception -> 0x001f }
        r3 = r3.isProviderEnabled(r2);	 Catch:{ Exception -> 0x001f }
        if (r1 == 0) goto L_0x001e;
    L_0x001a:
        if (r3 == 0) goto L_0x001e;
    L_0x001c:
        r3 = 1;
        return r3;
    L_0x001e:
        return r0;
    L_0x001f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.user.account.m.a(android.content.Context):boolean");
    }

    public static boolean a(String str) {
        if (!(str == null || str.isEmpty() || Pattern.compile("[a-zA-Z0-9_-]+@\\w+\\.[a-z]+(\\.[a-z]+)?").matcher(str).matches() || Pattern.compile("^(13\\w|15[0,2,8,9,1,7]|188|187)(\\d{8}|\\*{4}\\d{4})$").matcher(str).matches() || str.equals("子账号") || str.equals("子账号:1") || str.equals("子账号:2") || str.equals("子账号：1"))) {
            if (str.equals("子账号：2") == null) {
                return null;
            }
        }
        return true;
    }

    public static int b(String str) {
        try {
            return str.getBytes("utf-8").length;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i) {
        if (b(str) <= i) {
            return str;
        }
        try {
            Object obj = new byte[i];
            System.arraycopy(str.getBytes("utf-8"), 0, obj, 0, i);
            return new String(obj);
        } catch (int i2) {
            i2.printStackTrace();
            return str;
        }
    }

    public static void b(Context context) {
        OnClickListener nVar = new n(context);
        XLAlertDialog xLAlertDialog = new XLAlertDialog(context);
        xLAlertDialog.setTitle("权限申请");
        xLAlertDialog.setMessage("在设置-应用-迅雷-权限中开启相机权限，以正常使用拍照功能");
        xLAlertDialog.setCancelButtonText("取消");
        xLAlertDialog.setConfirmButtonText("设置");
        xLAlertDialog.setOnClickConfirmButtonListener(nVar);
        xLAlertDialog.show();
    }

    public static boolean a(String str, String str2) {
        return ((TextUtils.isEmpty(str) || str.equals("省份") != null) && !(TextUtils.isEmpty(str2) == null && str2.equals("城市") == null)) ? null : true;
    }

    public static int c(String str) {
        try {
            str = new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (String str2) {
            str2.printStackTrace();
            str2 = null;
        }
        if (str2 == null) {
            return 0;
        }
        Calendar instance = Calendar.getInstance();
        if (instance.before(str2)) {
            return 0;
        }
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        instance.setTime(str2);
        str2 = instance.get(1);
        int i4 = instance.get(2);
        int i5 = instance.get(5);
        i -= str2;
        if (i2 <= i4 && (i2 != i4 || i3 < i5)) {
            i--;
        }
        return i;
    }

    public static String b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!TextUtils.isEmpty(str) && d(str)) {
            stringBuilder.append(str);
        }
        if (TextUtils.isEmpty(str2) == null) {
            stringBuilder.append(" ");
            stringBuilder.append(str2.replace("市", ""));
        }
        return stringBuilder.toString().trim();
    }

    private static boolean d(String str) {
        if (str != null) {
            if (str.length() != 0) {
                String[] strArr = new String[]{"北京", "重庆", "天津", "上海", "澳门", "香港"};
                for (int i = 0; i < 6; i++) {
                    if (str.contains(strArr[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static Uri a(Context context, Uri uri) {
        if (uri.getAuthority() != null) {
            try {
                uri = context.getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                context = e;
                uri = null;
                try {
                    context.printStackTrace();
                    if (uri != null) {
                        try {
                            uri.close();
                        } catch (Context context2) {
                            context2.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    context2 = th;
                    if (uri != null) {
                        try {
                            uri.close();
                        } catch (Uri uri2) {
                            uri2.printStackTrace();
                        }
                    }
                    throw context2;
                }
            } catch (Throwable th2) {
                context2 = th2;
                uri2 = null;
                if (uri2 != null) {
                    uri2.close();
                }
                throw context2;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(uri2);
                decodeStream.compress(CompressFormat.JPEG, 100, new ByteArrayOutputStream());
                context2 = Uri.parse(Media.insertImage(context2.getContentResolver(), decodeStream, "Title", null));
                if (uri2 != null) {
                    try {
                        uri2.close();
                    } catch (Uri uri22) {
                        uri22.printStackTrace();
                    }
                }
                return context2;
            } catch (FileNotFoundException e2) {
                context2 = e2;
                context2.printStackTrace();
                if (uri22 != null) {
                    uri22.close();
                }
                return null;
            }
        }
        return null;
    }

    public static final void a(Context context, VideoUserInfo videoUserInfo, PublisherActivity$From publisherActivity$From) {
        a(context, Long.parseLong(videoUserInfo.getUid()), videoUserInfo.getKind(), videoUserInfo.getNickname(), videoUserInfo.getPortraitUrl(), publisherActivity$From);
    }

    public static final void a(Context context, long j, String str, String str2, String str3, PublisherActivity$From publisherActivity$From) {
        VisitorNetworkHelper.a().a(j);
        a(context, j, str, str2, str3, publisherActivity$From, false);
    }

    public static final void b(Context context, long j, String str, String str2, String str3, PublisherActivity$From publisherActivity$From) {
        VisitorNetworkHelper.a().a(j);
        a(context, j, str, str2, str3, publisherActivity$From, true);
    }

    public static final void a(Context context, long j, String str, String str2, String str3, PublisherActivity$From publisherActivity$From, CommentInfo commentInfo) {
        VisitorNetworkHelper a = VisitorNetworkHelper.a();
        long userId = commentInfo.getUserId();
        String relateGcid = commentInfo.getRelateGcid();
        String sourceId = commentInfo.getSourceId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(commentInfo.getId());
        a.a(userId, Entrance.COMMENT, relateGcid, sourceId, stringBuilder.toString(), commentInfo.getContent());
        a(context, j, str, str2, str3, publisherActivity$From, true);
    }

    public static final void a(Context context, long j, String str, String str2, String str3, PublisherActivity$From publisherActivity$From, String str4, String str5) {
        VisitorNetworkHelper.a().a(j, Entrance.PER_SPACE_VISIT, str4, str5, str5, "");
        a(context, j, str, str2, str3, publisherActivity$From, false);
    }

    private static final void a(Context context, long j, String str, String str2, String str3, PublisherActivity$From publisherActivity$From, boolean z) {
        PublisherActivity.a(context, publisherActivity$From, j, str2, str, str3, z);
    }

    public static void a(ImageView imageView, boolean z, String str) {
        if (z) {
            imageView.setImageResource(true);
            imageView.setVisibility(0);
        } else if ("rad".equals(str)) {
            imageView.setImageResource(true);
            imageView.setVisibility(0);
        } else if ("yl_daren".equals(str)) {
            imageView.setImageResource(true);
            imageView.setVisibility(0);
        } else if ("yl_nanshen".equals(str)) {
            imageView.setImageResource(true);
            imageView.setVisibility(0);
        } else if ("yl_nvshen".equals(str)) {
            imageView.setImageResource(true);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(true);
        }
    }

    public static void a(String str, ImageView imageView) {
        str = Glide.with(imageView.getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder((int) R.drawable.ic_default_avatar).error((int) R.drawable.ic_default_avatar).dontAnimate();
        str.transform(new a(r0));
        str.into(imageView);
    }
}
