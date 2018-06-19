package com.umeng.socialize;

import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.umeng.socialize.PlatformConfig.APPIDPlatform;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class UmengTool {
    private static final char[] HEX_CHAR = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$url;

        AnonymousClass1(String str, Context context) {
            this.val$url = str;
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface = new Intent();
            dialogInterface.setAction("android.intent.action.VIEW");
            dialogInterface.setData(Uri.parse(this.val$url));
            this.val$context.startActivity(dialogInterface);
        }
    }

    public static void getSignature(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            Toast.makeText(context, "应用程序的包名不能为空！", 0).show();
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            String signatureDigest = getSignatureDigest(packageInfo);
            StringBuilder stringBuilder = new StringBuilder("包名：");
            stringBuilder.append(packageName);
            stringBuilder.append("\n签名:");
            stringBuilder.append(signatureDigest.toLowerCase());
            stringBuilder.append("\nfacebook keyhash:");
            stringBuilder.append(facebookHashKey(packageInfo));
            showDialog(context, stringBuilder.toString());
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static String getCertificateSHA1Fingerprint(PackageInfo packageInfo) {
        CertificateFactory instance;
        X509Certificate x509Certificate;
        InputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        try {
            instance = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            e.printStackTrace();
            instance = null;
        }
        try {
            x509Certificate = (X509Certificate) instance.generateCertificate(byteArrayInputStream);
        } catch (CertificateException e2) {
            e2.printStackTrace();
            x509Certificate = null;
        }
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (CertificateEncodingException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String toHexString = Integer.toHexString(bArr[i]);
            int length = toHexString.length();
            if (length == 1) {
                StringBuilder stringBuilder2 = new StringBuilder("0");
                stringBuilder2.append(toHexString);
                toHexString = stringBuilder2.toString();
            }
            if (length > 2) {
                toHexString = toHexString.substring(length - 2, length);
            }
            stringBuilder.append(toHexString.toUpperCase());
            if (i < bArr.length - 1) {
                stringBuilder.append(':');
            }
        }
        return stringBuilder.toString();
    }

    private static java.lang.String facebookHashKey(android.content.pm.PackageInfo r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = r2.signatures;	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r0 = r2.length;	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        if (r0 <= 0) goto L_0x001e;	 Catch:{ NoSuchAlgorithmException -> 0x001e }
    L_0x0005:
        r0 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r2 = r2[r0];	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r1 = "SHA";	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r2 = r2.toByteArray();	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r1.update(r2);	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r2 = r1.digest();	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        r2 = android.util.Base64.encodeToString(r2, r0);	 Catch:{ NoSuchAlgorithmException -> 0x001e }
        return r2;
    L_0x001e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.UmengTool.facebookHashKey(android.content.pm.PackageInfo):java.lang.String");
    }

    public static void showDialog(Context context, String str) {
        new Builder(context).setTitle("友盟Debug模式自检").setMessage(str).setPositiveButton("关闭", null).show();
    }

    public static void showDialogWithURl(Context context, String str, String str2) {
        new Builder(context).setTitle("友盟Debug模式自检").setMessage(str).setPositiveButton("关闭", null).setNeutralButton("解决方案", new AnonymousClass1(str2, context)).show();
    }

    public static void getREDICRECT_URL(Context context) {
        showDialog(context, getStrRedicrectUrl());
    }

    public static String getStrRedicrectUrl() {
        return ((APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.SINA)).redirectUrl;
    }

    public static String getSignatureDigest(PackageInfo packageInfo) {
        if (packageInfo.signatures.length <= 0) {
            return "";
        }
        packageInfo = packageInfo.signatures[0];
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return toHexString(messageDigest.digest(packageInfo.toByteArray()));
    }

    private static String toHexString(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr[i2] = HEX_CHAR[(b >>> 4) & 15];
            cArr[i2 + 1] = HEX_CHAR[b & 15];
        }
        return new String(cArr);
    }

    public static String checkWxBySelf(Context context) {
        PackageManager packageManager;
        NameNotFoundException e;
        String signatureDigest;
        Class cls;
        String packageName = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(MMessageActV2.DEFAULT_ENTRY_CLASS_NAME);
        String stringBuilder2 = stringBuilder.toString();
        PackageInfo packageInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 64);
            } catch (NameNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                signatureDigest = getSignatureDigest(packageInfo);
                cls = Class.forName(stringBuilder2);
                if (cls == null) {
                    context = new StringBuilder("请检查微信后台注册签名：");
                    context.append(signatureDigest.toLowerCase());
                    context.append("\n包名：");
                    context.append(packageName);
                    context.append("\n没有配置微信回调activity或配置不正确");
                    return context.toString();
                }
                if (Config.isUmengWx.booleanValue()) {
                    if (cls.getSuperclass() != null) {
                        return "WXEntryActivity配置不正确，您使用的是精简版，请使WXEntryActivity继承com.umeng.weixin.callback.WXCallbackActivity";
                    }
                    if (!cls.getSuperclass().toString().contains("com.umeng.weixin")) {
                        return "WXEntryActivity配置不正确，您使用的是精简版，请使WXEntryActivity继承com.umeng.weixin.callback.WXCallbackActivity";
                    }
                } else if (cls.getSuperclass() != null) {
                    return "WXEntryActivity配置不正确，您使用的是完整版，请使WXEntryActivity继承com.umeng.socialize.weixin.view.WXCallbackActivity";
                } else {
                    if (!cls.getSuperclass().toString().contains("com.umeng.socialize")) {
                        return "WXEntryActivity配置不正确，您使用的是完整版，请使WXEntryActivity继承com.umeng.socialize.weixin.view.WXCallbackActivity";
                    }
                }
                try {
                    packageManager.getActivityInfo(new ComponentName(context.getPackageName(), stringBuilder2), null);
                    context = new StringBuilder("请检查微信后台注册签名：");
                    context.append(signatureDigest.toLowerCase());
                    context.append("\n包名：");
                    context.append(packageName);
                    context.append("\nActivity微信配置正确");
                    return context.toString();
                } catch (Context context2) {
                    context2.printStackTrace();
                    context2 = new StringBuilder("请检查微信后台注册签名：");
                    context2.append(signatureDigest.toLowerCase());
                    context2.append("\n包名：");
                    context2.append(packageName);
                    context2.append("\n没有配置微信回调activity没有在Manifest中配置");
                    return context2.toString();
                }
            }
        } catch (NameNotFoundException e3) {
            e = e3;
            packageManager = null;
            e.printStackTrace();
            signatureDigest = getSignatureDigest(packageInfo);
            cls = Class.forName(stringBuilder2);
            if (cls == null) {
                if (Config.isUmengWx.booleanValue()) {
                    if (cls.getSuperclass() != null) {
                        return "WXEntryActivity配置不正确，您使用的是完整版，请使WXEntryActivity继承com.umeng.socialize.weixin.view.WXCallbackActivity";
                    }
                    if (cls.getSuperclass().toString().contains("com.umeng.socialize")) {
                        return "WXEntryActivity配置不正确，您使用的是完整版，请使WXEntryActivity继承com.umeng.socialize.weixin.view.WXCallbackActivity";
                    }
                } else if (cls.getSuperclass() != null) {
                    return "WXEntryActivity配置不正确，您使用的是精简版，请使WXEntryActivity继承com.umeng.weixin.callback.WXCallbackActivity";
                } else {
                    if (cls.getSuperclass().toString().contains("com.umeng.weixin")) {
                        return "WXEntryActivity配置不正确，您使用的是精简版，请使WXEntryActivity继承com.umeng.weixin.callback.WXCallbackActivity";
                    }
                }
                packageManager.getActivityInfo(new ComponentName(context2.getPackageName(), stringBuilder2), null);
                context2 = new StringBuilder("请检查微信后台注册签名：");
                context2.append(signatureDigest.toLowerCase());
                context2.append("\n包名：");
                context2.append(packageName);
                context2.append("\nActivity微信配置正确");
                return context2.toString();
            }
            context2 = new StringBuilder("请检查微信后台注册签名：");
            context2.append(signatureDigest.toLowerCase());
            context2.append("\n包名：");
            context2.append(packageName);
            context2.append("\n没有配置微信回调activity或配置不正确");
            return context2.toString();
        }
        signatureDigest = getSignatureDigest(packageInfo);
        try {
            cls = Class.forName(stringBuilder2);
            if (cls == null) {
                context2 = new StringBuilder("请检查微信后台注册签名：");
                context2.append(signatureDigest.toLowerCase());
                context2.append("\n包名：");
                context2.append(packageName);
                context2.append("\n没有配置微信回调activity或配置不正确");
                return context2.toString();
            }
            if (Config.isUmengWx.booleanValue()) {
                if (cls.getSuperclass() != null) {
                    return "WXEntryActivity配置不正确，您使用的是精简版，请使WXEntryActivity继承com.umeng.weixin.callback.WXCallbackActivity";
                }
                if (cls.getSuperclass().toString().contains("com.umeng.weixin")) {
                    return "WXEntryActivity配置不正确，您使用的是精简版，请使WXEntryActivity继承com.umeng.weixin.callback.WXCallbackActivity";
                }
            } else if (cls.getSuperclass() != null) {
                return "WXEntryActivity配置不正确，您使用的是完整版，请使WXEntryActivity继承com.umeng.socialize.weixin.view.WXCallbackActivity";
            } else {
                if (cls.getSuperclass().toString().contains("com.umeng.socialize")) {
                    return "WXEntryActivity配置不正确，您使用的是完整版，请使WXEntryActivity继承com.umeng.socialize.weixin.view.WXCallbackActivity";
                }
            }
            packageManager.getActivityInfo(new ComponentName(context2.getPackageName(), stringBuilder2), null);
            context2 = new StringBuilder("请检查微信后台注册签名：");
            context2.append(signatureDigest.toLowerCase());
            context2.append("\n包名：");
            context2.append(packageName);
            context2.append("\nActivity微信配置正确");
            return context2.toString();
        } catch (Context context22) {
            context22.printStackTrace();
            context22 = new StringBuilder("请检查微信后台注册签名：");
            context22.append(signatureDigest.toLowerCase());
            context22.append("\n包名：");
            context22.append(packageName);
            context22.append("\n没有配置微信回调activity或配置不正确");
            return context22.toString();
        }
    }

    public static void checkWx(Context context) {
        showDialog(context, checkWxBySelf(context));
    }

    public static String checkSinaBySelf(Context context) {
        String packageName = context.getPackageName();
        try {
            context = context.getPackageManager().getPackageInfo(packageName, 64);
        } catch (Context context2) {
            context2.printStackTrace();
            context2 = null;
        }
        context2 = getSignatureDigest(context2);
        StringBuilder stringBuilder;
        try {
            if (Class.forName("com.sina.weibo.sdk.share.WbShareTransActivity") == null) {
                stringBuilder = new StringBuilder("请检查sina后台注册签名：");
                stringBuilder.append(context2.toLowerCase());
                stringBuilder.append("\n包名：");
                stringBuilder.append(packageName);
                stringBuilder.append("\n回调地址：");
                stringBuilder.append(getStrRedicrectUrl());
                stringBuilder.append("\n没有配置新浪回调activity或配置不正确");
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder("请检查sina后台注册签名：");
            stringBuilder.append(context2.toLowerCase());
            stringBuilder.append("\n包名：");
            stringBuilder.append(packageName);
            stringBuilder.append("\n回调地址：");
            stringBuilder.append(getStrRedicrectUrl());
            stringBuilder.append("新浪配置正确");
            return stringBuilder.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            stringBuilder = new StringBuilder("请检查sina后台注册签名：");
            stringBuilder.append(context2.toLowerCase());
            stringBuilder.append("\n包名：");
            stringBuilder.append(packageName);
            stringBuilder.append("\n回调地址：");
            stringBuilder.append(getStrRedicrectUrl());
            stringBuilder.append("没有配置新浪回调activity或配置不正确");
            return stringBuilder.toString();
        }
    }

    public static void checkSina(Context context) {
        showDialog(context, checkSinaBySelf(context));
    }

    public static void checkAlipay(Context context) {
        String packageName = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(".apshare.ShareEntryActivity");
        try {
            if (Class.forName(stringBuilder.toString()) == null) {
                showDialog(context, "没有配置支付宝回调activity或配置不正确");
            } else {
                showDialog(context, "支付宝配置正确");
            }
        } catch (ClassNotFoundException e) {
            showDialog(context, "没有配置支付宝回调activity或配置不正确");
            e.printStackTrace();
        }
    }

    @android.annotation.TargetApi(9)
    public static java.lang.String checkFBByself(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        r1 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0086 }
        r2 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x0086 }
        r3 = "com.umeng.facebook.FacebookActivity";	 Catch:{ NameNotFoundException -> 0x0086 }
        r1.<init>(r2, r3);	 Catch:{ NameNotFoundException -> 0x0086 }
        r2 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0086 }
        r3 = 0;	 Catch:{ NameNotFoundException -> 0x0086 }
        r2.getActivityInfo(r1, r3);	 Catch:{ NameNotFoundException -> 0x0086 }
        r1 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0083 }
        r2 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x0083 }
        r4 = "com.umeng.facebook.FacebookContentProvider";	 Catch:{ NameNotFoundException -> 0x0083 }
        r1.<init>(r2, r4);	 Catch:{ NameNotFoundException -> 0x0083 }
        r2 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0083 }
        r2.getProviderInfo(r1, r3);	 Catch:{ NameNotFoundException -> 0x0083 }
        r1 = r5.getPackageManager();	 Catch:{ Exception -> 0x0080 }
        r2 = r5.getPackageName();	 Catch:{ Exception -> 0x0080 }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0080 }
        r1 = r1.getApplicationInfo(r2, r3);	 Catch:{ Exception -> 0x0080 }
        if (r1 == 0) goto L_0x0044;	 Catch:{ Exception -> 0x0080 }
    L_0x0037:
        r1 = r1.metaData;	 Catch:{ Exception -> 0x0080 }
        r2 = "com.facebook.sdk.ApplicationId";	 Catch:{ Exception -> 0x0080 }
        r1 = r1.get(r2);	 Catch:{ Exception -> 0x0080 }
        if (r1 != 0) goto L_0x0044;	 Catch:{ Exception -> 0x0080 }
    L_0x0041:
        r5 = "没有在AndroidManifest中配置facebook的appid";	 Catch:{ Exception -> 0x0080 }
        return r5;
    L_0x0044:
        r1 = r5.getResources();
        r2 = "facebook_app_id";
        r3 = "string";
        r4 = r5.getPackageName();
        r1 = r1.getIdentifier(r2, r3, r4);
        if (r1 > 0) goto L_0x0059;
    L_0x0056:
        r0 = "没有找到facebook_app_id，facebook的id必须写在string文件中且名字必须用facebook_app_id";
        goto L_0x007f;
    L_0x0059:
        r1 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x007b }
        r5 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x007b }
        r2 = 64;	 Catch:{ NameNotFoundException -> 0x007b }
        r5 = r1.getPackageInfo(r5, r2);	 Catch:{ NameNotFoundException -> 0x007b }
        r1 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x007b }
        r2 = "facebook 配置正确，请检查fb后台签名:";	 Catch:{ NameNotFoundException -> 0x007b }
        r1.<init>(r2);	 Catch:{ NameNotFoundException -> 0x007b }
        r5 = facebookHashKey(r5);	 Catch:{ NameNotFoundException -> 0x007b }
        r1.append(r5);	 Catch:{ NameNotFoundException -> 0x007b }
        r5 = r1.toString();	 Catch:{ NameNotFoundException -> 0x007b }
        r0 = r5;
        goto L_0x007f;
    L_0x007b:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x007f:
        return r0;
    L_0x0080:
        r5 = "没有在AndroidManifest中配置facebook的appid";
        return r5;
    L_0x0083:
        r5 = "没有在AndroidManifest.xml中配置com.umeng.facebook.FacebookContentProvider,请阅读友盟官方文档";
        return r5;
    L_0x0086:
        r5 = "没有在AndroidManifest.xml中配置com.umeng.facebook.FacebookActivity,请阅读友盟官方文档";
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.UmengTool.checkFBByself(android.content.Context):java.lang.String");
    }

    public static java.lang.String checkQQByself(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "com.tencent.tauth.AuthActivity";
        r1 = "com.tencent.connect.common.AssistActivity";
        r2 = com.umeng.socialize.Config.isUmengQQ;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x0010;
    L_0x000c:
        r0 = "com.umeng.qq.tencent.AuthActivity";
        r1 = "com.umeng.qq.tencent.AssistActivity";
    L_0x0010:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x00df }
        r3 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x00df }
        r2.<init>(r3, r0);	 Catch:{ NameNotFoundException -> 0x00df }
        r3 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00df }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x00df }
        r3.getActivityInfo(r2, r4);	 Catch:{ NameNotFoundException -> 0x00df }
        r0 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0.<init>(r2, r1);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2.getActivityInfo(r0, r4);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0 = "android.permission.WRITE_EXTERNAL_STORAGE";	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0 = r2.checkPermission(r0, r3);	 Catch:{ NameNotFoundException -> 0x00c3 }
        if (r0 != 0) goto L_0x003e;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x003d:
        r4 = 1;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x003e:
        if (r4 == 0) goto L_0x00c0;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x0040:
        r0 = new android.content.Intent;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0.<init>();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = "android.intent.action.VIEW";	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0.setAction(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = "android.intent.category.DEFAULT";	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0.addCategory(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = "android.intent.category.BROWSABLE";	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0.addCategory(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = com.umeng.socialize.bean.SHARE_MEDIA.QQ;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = com.umeng.socialize.PlatformConfig.getPlatform(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = (com.umeng.socialize.PlatformConfig.APPIDPlatform) r2;	 Catch:{ NameNotFoundException -> 0x00c3 }
        if (r2 == 0) goto L_0x00bd;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x005e:
        r3 = r2.appId;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ NameNotFoundException -> 0x00c3 }
        if (r3 != 0) goto L_0x00bd;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x0066:
        r3 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r4 = "tencent";	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3.<init>(r4);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r2.appId;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3.append(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = ":";	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3.append(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r3.toString();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = android.net.Uri.parse(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0.setData(r2);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3 = 64;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r0 = r2.queryIntentActivities(r0, r3);	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r0.size();	 Catch:{ NameNotFoundException -> 0x00c3 }
        if (r2 <= 0) goto L_0x00ba;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x0092:
        r0 = r0.iterator();	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x0096:
        r2 = r0.hasNext();	 Catch:{ NameNotFoundException -> 0x00c3 }
        if (r2 == 0) goto L_0x00b7;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x009c:
        r2 = r0.next();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = (android.content.pm.ResolveInfo) r2;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3 = r2.activityInfo;	 Catch:{ NameNotFoundException -> 0x00c3 }
        if (r3 == 0) goto L_0x0096;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x00a6:
        r2 = r2.activityInfo;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r2.packageName;	 Catch:{ NameNotFoundException -> 0x00c3 }
        r3 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x00c3 }
        r2 = r2.equals(r3);	 Catch:{ NameNotFoundException -> 0x00c3 }
        if (r2 == 0) goto L_0x0096;	 Catch:{ NameNotFoundException -> 0x00c3 }
    L_0x00b4:
        r5 = "qq配置正确";	 Catch:{ NameNotFoundException -> 0x00c3 }
        return r5;
    L_0x00b7:
        r5 = "qq配置不正确，AndroidManifest中AuthActivity的data中要加入自己的qq应用id";
        return r5;
    L_0x00ba:
        r5 = "qq配置不正确，AndroidManifest中AuthActivity的data中要加入自己的qq应用id";
        return r5;
    L_0x00bd:
        r5 = "qq配置不正确，没有检测到qq的id配置";
        return r5;
    L_0x00c0:
        r5 = "qq 权限配置不正确，缺少android.permission.WRITE_EXTERNAL_STORAGE";
        return r5;
    L_0x00c3:
        r5 = new java.lang.StringBuilder;
        r0 = "没有在AndroidManifest.xml中检测到";
        r5.<init>(r0);
        r5.append(r1);
        r0 = ",请加上";
        r5.append(r0);
        r5.append(r1);
        r0 = ",详细信息请查看官网文档.";
        r5.append(r0);
        r5 = r5.toString();
        return r5;
    L_0x00df:
        r5 = new java.lang.StringBuilder;
        r1 = "没有在AndroidManifest.xml中检测到";
        r5.<init>(r1);
        r5.append(r0);
        r1 = ",请加上";
        r5.append(r1);
        r5.append(r0);
        r0 = ",并配置<data android:scheme=\"tencentappid\" />,详细信息请查看官网文档.";
        r5.append(r0);
        r5 = r5.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.UmengTool.checkQQByself(android.content.Context):java.lang.String");
    }

    public static java.lang.String checkVKByself(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getPackageName();
        r3 = r3.getPackageManager();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0011;
    L_0x000e:
        r3 = "包名为空";
        return r3;
    L_0x0011:
        r1 = 64;
        r3 = r3.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = getCertificateSHA1Fingerprint(r3);	 Catch:{ NameNotFoundException -> 0x0032 }
        r0 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0032 }
        r1 = "你使用的签名：";	 Catch:{ NameNotFoundException -> 0x0032 }
        r0.<init>(r1);	 Catch:{ NameNotFoundException -> 0x0032 }
        r1 = ":";	 Catch:{ NameNotFoundException -> 0x0032 }
        r2 = "";	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = r3.replace(r1, r2);	 Catch:{ NameNotFoundException -> 0x0032 }
        r0.append(r3);	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = r0.toString();	 Catch:{ NameNotFoundException -> 0x0032 }
        return r3;
    L_0x0032:
        r3 = "签名获取失败";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.UmengTool.checkVKByself(android.content.Context):java.lang.String");
    }

    public static java.lang.String checkLinkin(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageName();
        r2.getPackageManager();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r2 = "包名为空";
        return r2;
    L_0x0010:
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0031 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0031 }
        r0 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0031 }
        r1 = "领英 配置正确，请检查领英后台签名:";	 Catch:{ NameNotFoundException -> 0x0031 }
        r0.<init>(r1);	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = facebookHashKey(r2);	 Catch:{ NameNotFoundException -> 0x0031 }
        r0.append(r2);	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = r0.toString();	 Catch:{ NameNotFoundException -> 0x0031 }
        return r2;
    L_0x0031:
        r2 = "签名获取失败";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.UmengTool.checkLinkin(android.content.Context):java.lang.String");
    }

    public static java.lang.String checkKakao(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageName();
        r2.getPackageManager();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r2 = "包名为空";
        return r2;
    L_0x0010:
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0031 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0031 }
        r0 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0031 }
        r1 = "kakao 配置正确，请检查kakao后台签名:";	 Catch:{ NameNotFoundException -> 0x0031 }
        r0.<init>(r1);	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = facebookHashKey(r2);	 Catch:{ NameNotFoundException -> 0x0031 }
        r0.append(r2);	 Catch:{ NameNotFoundException -> 0x0031 }
        r2 = r0.toString();	 Catch:{ NameNotFoundException -> 0x0031 }
        return r2;
    L_0x0031:
        r2 = "签名获取失败";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.UmengTool.checkKakao(android.content.Context):java.lang.String");
    }

    public static void checkQQ(Context context) {
        showDialog(context, checkQQByself(context));
    }

    public static void checkFacebook(Context context) {
        showDialog(context, checkFBByself(context));
    }

    public static void checkVK(Context context) {
        showDialog(context, checkVKByself(context));
    }
}
