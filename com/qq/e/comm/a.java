package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.qq.e.comm.constants.Constants.PLUGIN;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private String a;
    private com.qq.e.comm.managers.setting.a b;

    public a(String str, com.qq.e.comm.managers.setting.a aVar) {
        this.a = str;
        this.b = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.qq.e.comm.util.AdError a(int r4) {
        /*
        r0 = 2001; // 0x7d1 float:2.804E-42 double:9.886E-321;
        switch(r4) {
            case 300: goto L_0x01b0;
            case 301: goto L_0x01a8;
            case 302: goto L_0x01a0;
            case 303: goto L_0x0198;
            default: goto L_0x0005;
        };
    L_0x0005:
        switch(r4) {
            case 403: goto L_0x018e;
            case 404: goto L_0x0184;
            case 405: goto L_0x017a;
            case 406: goto L_0x0170;
            default: goto L_0x0008;
        };
    L_0x0008:
        switch(r4) {
            case 500: goto L_0x0166;
            case 501: goto L_0x015c;
            case 502: goto L_0x0152;
            default: goto L_0x000b;
        };
    L_0x000b:
        r1 = 2002; // 0x7d2 float:2.805E-42 double:9.89E-321;
        switch(r4) {
            case 600: goto L_0x0148;
            case 601: goto L_0x013e;
            case 602: goto L_0x0134;
            case 603: goto L_0x012c;
            case 604: goto L_0x0124;
            default: goto L_0x0010;
        };
    L_0x0010:
        switch(r4) {
            case 606: goto L_0x011a;
            case 607: goto L_0x0110;
            case 608: goto L_0x0106;
            default: goto L_0x0013;
        };
    L_0x0013:
        switch(r4) {
            case 700: goto L_0x00fc;
            case 701: goto L_0x00f2;
            default: goto L_0x0016;
        };
    L_0x0016:
        switch(r4) {
            case 2001: goto L_0x01b0;
            case 2002: goto L_0x00ea;
            default: goto L_0x0019;
        };
    L_0x0019:
        r2 = 4001; // 0xfa1 float:5.607E-42 double:1.977E-320;
        switch(r4) {
            case 4001: goto L_0x00e2;
            case 4002: goto L_0x0134;
            case 4003: goto L_0x0166;
            case 4004: goto L_0x0148;
            case 4005: goto L_0x011a;
            case 4006: goto L_0x0110;
            default: goto L_0x001e;
        };
    L_0x001e:
        switch(r4) {
            case 4008: goto L_0x00d8;
            case 4009: goto L_0x0106;
            default: goto L_0x0021;
        };
    L_0x0021:
        switch(r4) {
            case 5001: goto L_0x0152;
            case 5002: goto L_0x00fc;
            case 5003: goto L_0x00f2;
            case 5004: goto L_0x015c;
            case 5005: goto L_0x00ce;
            case 5006: goto L_0x00c4;
            case 5007: goto L_0x017a;
            case 5008: goto L_0x0170;
            case 5009: goto L_0x00ba;
            default: goto L_0x0024;
        };
    L_0x0024:
        switch(r4) {
            case 107034: goto L_0x00b0;
            case 107035: goto L_0x00a6;
            default: goto L_0x0027;
        };
    L_0x0027:
        switch(r4) {
            case 109506: goto L_0x00ce;
            case 109507: goto L_0x00ba;
            default: goto L_0x002a;
        };
    L_0x002a:
        switch(r4) {
            case 200101: goto L_0x01a8;
            case 200102: goto L_0x01a0;
            case 200103: goto L_0x0198;
            default: goto L_0x002d;
        };
    L_0x002d:
        switch(r4) {
            case 200201: goto L_0x012c;
            case 200202: goto L_0x0124;
            default: goto L_0x0030;
        };
    L_0x0030:
        switch(r4) {
            case 400101: goto L_0x0092;
            case 400102: goto L_0x007e;
            case 400103: goto L_0x006a;
            case 400104: goto L_0x0056;
            default: goto L_0x0033;
        };
    L_0x0033:
        switch(r4) {
            case 400: goto L_0x018e;
            case 800: goto L_0x004c;
            case 3001: goto L_0x018e;
            case 3003: goto L_0x013e;
            case 4011: goto L_0x0184;
            case 107030: goto L_0x00c4;
            default: goto L_0x0036;
        };
    L_0x0036:
        r0 = new com.qq.e.comm.util.AdError;
        r1 = 6000; // 0x1770 float:8.408E-42 double:2.9644E-320;
        r2 = new java.lang.StringBuilder;
        r3 = "未知错误，详细码：";
        r2.<init>(r3);
        r2.append(r4);
        r4 = r2.toString();
        r0.<init>(r1, r4);
        return r0;
    L_0x004c:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4012; // 0xfac float:5.622E-42 double:1.982E-320;
        r1 = "内容接口调用顺序错误，调用点击接口前未调用曝光接口";
        r0.<init>(r4, r1);
        return r0;
    L_0x0056:
        r0 = new com.qq.e.comm.util.AdError;
        r1 = new java.lang.StringBuilder;
        r3 = "传入的参数有错误，详细码：";
        r1.<init>(r3);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r2, r4);
        return r0;
    L_0x006a:
        r0 = new com.qq.e.comm.util.AdError;
        r1 = new java.lang.StringBuilder;
        r3 = "传入的参数有错误，详细码：";
        r1.<init>(r3);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r2, r4);
        return r0;
    L_0x007e:
        r0 = new com.qq.e.comm.util.AdError;
        r1 = new java.lang.StringBuilder;
        r3 = "传入的参数有错误，详细码：";
        r1.<init>(r3);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r2, r4);
        return r0;
    L_0x0092:
        r0 = new com.qq.e.comm.util.AdError;
        r1 = new java.lang.StringBuilder;
        r3 = "传入的参数有错误，详细码：";
        r1.<init>(r3);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r2, r4);
        return r0;
    L_0x00a6:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4013; // 0xfad float:5.623E-42 double:1.9827E-320;
        r1 = "使用支持视频素材的原生模板广告位前，请升级您的SDK";
        r0.<init>(r4, r1);
        return r0;
    L_0x00b0:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5010; // 0x1392 float:7.02E-42 double:2.4753E-320;
        r1 = "广告样式校验失败，请检查广告位与接口使用是否一致";
        r0.<init>(r4, r1);
        return r0;
    L_0x00ba:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5009; // 0x1391 float:7.019E-42 double:2.475E-320;
        r1 = "广告请求量或者消耗等超过小时限额，请一小时后再请求广告";
        r0.<init>(r4, r1);
        return r0;
    L_0x00c4:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5006; // 0x138e float:7.015E-42 double:2.4733E-320;
        r1 = "包名校验错误，当前App的包名和广点通移动联盟官网注册的媒体包名不一致，因此无广告返回";
        r0.<init>(r4, r1);
        return r0;
    L_0x00ce:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5005; // 0x138d float:7.013E-42 double:2.473E-320;
        r1 = "广告请求量或者消耗等超过日限额，请明天再请求广告";
        r0.<init>(r4, r1);
        return r0;
    L_0x00d8:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4008; // 0xfa8 float:5.616E-42 double:1.98E-320;
        r1 = "设备方向不适合展示广告";
        r0.<init>(r4, r1);
        return r0;
    L_0x00e2:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = "传入的参数有错误";
        r0.<init>(r2, r4);
        return r0;
    L_0x00ea:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = "内部错误";
        r0.<init>(r1, r4);
        return r0;
    L_0x00f2:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5003; // 0x138b float:7.01E-42 double:2.472E-320;
        r1 = "视频素材播放错误";
        r0.<init>(r4, r1);
        return r0;
    L_0x00fc:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5002; // 0x138a float:7.009E-42 double:2.4713E-320;
        r1 = "视频素材下载错误";
        r0.<init>(r4, r1);
        return r0;
    L_0x0106:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4009; // 0xfa9 float:5.618E-42 double:1.9807E-320;
        r1 = "开屏广告的自定义跳过按钮尺寸小于3x3dp";
        r0.<init>(r4, r1);
        return r0;
    L_0x0110:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4006; // 0xfa6 float:5.614E-42 double:1.979E-320;
        r1 = "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口";
        r0.<init>(r4, r1);
        return r0;
    L_0x011a:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4005; // 0xfa5 float:5.612E-42 double:1.9787E-320;
        r1 = "开屏广告容器的高度低于400dp";
        r0.<init>(r4, r1);
        return r0;
    L_0x0124:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = "内部错误，详细码：200202";
        r0.<init>(r1, r4);
        return r0;
    L_0x012c:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = "内部错误，详细码：200201";
        r0.<init>(r1, r4);
        return r0;
    L_0x0134:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4002; // 0xfa2 float:5.608E-42 double:1.9773E-320;
        r1 = "Manifest文件中Activity/Service/Permission的声明有问题";
        r0.<init>(r4, r1);
        return r0;
    L_0x013e:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 3003; // 0xbbb float:4.208E-42 double:1.4837E-320;
        r1 = "网络类型错误，当前设备的网络类型不符合开屏广告的加载条件";
        r0.<init>(r4, r1);
        return r0;
    L_0x0148:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4004; // 0xfa4 float:5.611E-42 double:1.978E-320;
        r1 = "开屏广告容器不可见";
        r0.<init>(r4, r1);
        return r0;
    L_0x0152:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5001; // 0x1389 float:7.008E-42 double:2.471E-320;
        r1 = "服务端数据错误";
        r0.<init>(r4, r1);
        return r0;
    L_0x015c:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5004; // 0x138c float:7.012E-42 double:2.4723E-320;
        r1 = "没有广告";
        r0.<init>(r4, r1);
        return r0;
    L_0x0166:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4003; // 0xfa3 float:5.61E-42 double:1.9777E-320;
        r1 = "广告位错误";
        r0.<init>(r4, r1);
        return r0;
    L_0x0170:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5008; // 0x1390 float:7.018E-42 double:2.4743E-320;
        r1 = "图片加载错误";
        r0.<init>(r4, r1);
        return r0;
    L_0x017a:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 5007; // 0x138f float:7.016E-42 double:2.474E-320;
        r1 = "资源加载错误";
        r0.<init>(r4, r1);
        return r0;
    L_0x0184:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 4011; // 0xfab float:5.62E-42 double:1.9817E-320;
        r1 = "开屏广告拉取超时";
        r0.<init>(r4, r1);
        return r0;
    L_0x018e:
        r0 = new com.qq.e.comm.util.AdError;
        r4 = 3001; // 0xbb9 float:4.205E-42 double:1.4827E-320;
        r1 = "网络异常";
        r0.<init>(r4, r1);
        return r0;
    L_0x0198:
        r4 = new com.qq.e.comm.util.AdError;
        r1 = "初始化错误，详细码：200103";
        r4.<init>(r0, r1);
        goto L_0x01b7;
    L_0x01a0:
        r4 = new com.qq.e.comm.util.AdError;
        r1 = "初始化错误，详细码：200102";
        r4.<init>(r0, r1);
        goto L_0x01b7;
    L_0x01a8:
        r4 = new com.qq.e.comm.util.AdError;
        r1 = "初始化错误，详细码：200101";
        r4.<init>(r0, r1);
        goto L_0x01b7;
    L_0x01b0:
        r4 = new com.qq.e.comm.util.AdError;
        r1 = "初始化错误";
        r4.<init>(r0, r1);
    L_0x01b7:
        r0 = r4;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.a(int):com.qq.e.comm.util.AdError");
    }

    public static JSONObject a(PM pm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
        jSONObject.putOpt(SocializeProtocolConstants.PROTOCOL_KEY_PV, Integer.valueOf(pm.getPluginVersion()));
        return jSONObject;
    }

    public static JSONObject a(SM sm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (sm != null) {
            jSONObject.putOpt("suid", sm.getSuid());
            jSONObject.putOpt("sid", sm.getSid());
        }
        return jSONObject;
    }

    public static JSONObject a(APPStatus aPPStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aPPStatus != null) {
            jSONObject.putOpt(com.alipay.sdk.sys.a.i, aPPStatus.getAPPName());
            jSONObject.putOpt("appkey", aPPStatus.getAPPID());
            jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
            jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
        }
        return jSONObject;
    }

    public static JSONObject a(DeviceStatus deviceStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
            jSONObject.putOpt("dn", deviceStatus.getDataNet());
            jSONObject.putOpt(DispatchConstants.LATITUDE, deviceStatus.getLat());
            jSONObject.putOpt(DispatchConstants.LONGTITUDE, deviceStatus.getLng());
            for (Entry entry : deviceStatus.getLacAndCeilId().entrySet()) {
                jSONObject.putOpt((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public static boolean a(Context context) {
        try {
            if (b(context)) {
                if (a(context, Class.forName(CustomPkgConstants.getADActivityName()))) {
                    if (b(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.e("Exception While check SDK Env", th);
            return false;
        }
    }

    public static boolean a(Context context, File file, File file2) {
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) >= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(CustomPkgConstants.getAssetPluginDir());
                stringBuilder.append(File.separator);
                stringBuilder.append(CustomPkgConstants.getAssetPluginName());
                String stringBuilder2 = stringBuilder.toString();
                String str = PLUGIN.ASSET_PLUGIN_SIG;
                StringBuilder stringBuilder3 = new StringBuilder("559#####");
                stringBuilder3.append(str);
                StringUtil.writeTo(stringBuilder3.toString(), file2);
                if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                    return FileUtil.copyTo(assets.open(stringBuilder2), file);
                }
                InputStream open = assets.open(stringBuilder2);
                OutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes();
                byte[] bArr = new byte[1024];
                int length = bytes.length;
                boolean z = false;
                boolean z2 = z;
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        boolean z3 = z2;
                        z2 = z;
                        int i = 0;
                        while (i < read) {
                            boolean z4 = z2 + 1;
                            if (z2 >= true) {
                                boolean z5 = z3 + 1;
                                bArr[i] = (byte) (bArr[i] ^ bytes[z3 % length]);
                                z3 = z5;
                            }
                            i++;
                            z2 = z4;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        z = z2;
                        z2 = z3;
                    } else {
                        open.close();
                        fileOutputStream.close();
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
        }
        return false;
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[0]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s] is required in AndroidManifest.xml", new Object[]{clsArr[0].getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.e("Exception while checking required activities", th);
                return false;
            }
        }
        return true;
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        Exception e;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return bArr;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return bArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        } catch (Exception e5) {
            e4 = e5;
            gZIPOutputStream = null;
            e4.printStackTrace();
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    private static boolean b(Context context) {
        String[] strArr = new String[]{MsgConstant.PERMISSION_INTERNET, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, MsgConstant.PERMISSION_ACCESS_WIFI_STATE, MsgConstant.PERMISSION_READ_PHONE_STATE, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE};
        int i = 0;
        while (i < 5) {
            try {
                if (context.checkCallingOrSelfPermission(strArr[i]) == -1) {
                    GDTLogger.e(String.format("Permission %s is required in AndroidManifest.xml", new Object[]{strArr[i]}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.e("Check required Permissions error", th);
                return false;
            }
        }
        return true;
    }

    private static boolean b(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Class cls = clsArr[0];
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e(String.format("Service[%s] is required in AndroidManifest.xml", new Object[]{cls.getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.e("Exception while checking required services", th);
                return false;
            }
        }
        return true;
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        Exception e;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            while (true) {
                try {
                    int read = gZIPInputStream.read(bArr2);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        bArr2 = byteArrayOutputStream.toByteArray();
                        try {
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            return bArr2;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return bArr2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        } catch (Exception e4) {
            e = e4;
            gZIPInputStream = null;
            try {
                e.printStackTrace();
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        return null;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e222) {
                        e222.printStackTrace();
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = null;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public String a() {
        return this.a;
    }

    public com.qq.e.comm.managers.setting.a b() {
        return this.b;
    }
}
