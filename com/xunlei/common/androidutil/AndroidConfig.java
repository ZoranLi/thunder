package com.xunlei.common.androidutil;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import com.igexin.sdk.PushConsts;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.xllib.android.a;
import com.xunlei.xllib.android.d;
import com.xunlei.xllib.android.f;
import com.xunlei.xllib.b.g;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class AndroidConfig {
    private static final String DEFAULT_IMEI = "000000000000000";
    public static final int XL_ACCOUNT_APPID = 40;
    public static final String XL_PRODUCT_ID = "37";
    private static Context mContext = null;
    private static String sHubbleDeviceId = null;
    private static String sImei = null;
    private static String sMac = null;
    private static volatile PackageConfig sPackageConfig = null;
    private static String sPeerId = null;
    private static int sScreenHeight = 0;
    private static int sScreenWidth = 0;
    public static final int sVersionCode = 11100;
    public static final String sVersionName = "5.60.2.5510";

    private static class PackageConfig {
        private static final String CONFIG_NAME = "thunder_package_config.json";
        static final String DEFAULT_PID = "0x10800001";
        static final String DEFAULT_PNAME = "XLWXguanwang";
        String mChannelId;
        String mChannelName;
        boolean mUpdate;

        private PackageConfig() {
            this.mChannelId = DEFAULT_PID;
            this.mChannelName = DEFAULT_PNAME;
            this.mUpdate = true;
        }

        boolean loadConfigure(Context context) {
            InputStreamReader inputStreamReader;
            IOException e;
            Throwable th;
            try {
                context = context.getAssets().open(CONFIG_NAME);
            } catch (Context context2) {
                context2.printStackTrace();
                context2 = null;
            }
            if (context2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    inputStreamReader = new InputStreamReader(context2);
                    try {
                        char[] cArr = new char[1024];
                        while (true) {
                            int read = inputStreamReader.read(cArr, 0, 1024);
                            if (read > 0) {
                                stringBuilder.append(cArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                            }
                            context2.close();
                            context2 = new JSONObject(stringBuilder.toString());
                            parse(context2);
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            try {
                                context2.close();
                            } catch (Context context22) {
                                context22.printStackTrace();
                            }
                            throw th;
                        }
                    }
                    try {
                        context22.close();
                    } catch (Context context222) {
                        context222.printStackTrace();
                    }
                } catch (IOException e5) {
                    e = e5;
                    inputStreamReader = null;
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    context222.close();
                    context222 = new JSONObject(stringBuilder.toString());
                    parse(context222);
                    return true;
                } catch (Throwable th3) {
                    inputStreamReader = null;
                    th = th3;
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    context222.close();
                    throw th;
                }
                try {
                    context222 = new JSONObject(stringBuilder.toString());
                } catch (Context context2222) {
                    context2222.printStackTrace();
                    context2222 = null;
                }
                parse(context2222);
            }
            return true;
        }

        private void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mChannelId = jSONObject.optString(PushConsts.KEY_SERVICE_PIT, DEFAULT_PID);
                this.mChannelName = jSONObject.optString("pname", DEFAULT_PNAME);
                this.mUpdate = jSONObject.optBoolean("update", true);
            }
        }
    }

    public static String getProductId() {
        return "37";
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getPackageName() {
        return mContext.getPackageName();
    }

    public static String getShouleiMemberDeviceId() {
        return ThunderReport.getShouleiMemberDeviceId();
    }

    public static String getHubbleDeviceGUID() {
        return getHubbleDeviceGUID(mContext);
    }

    public static String getHubbleDeviceGUID(Context context) {
        if (context != null) {
            sHubbleDeviceId = ThunderReport.getHubbleDeviceId(context);
        }
        return sHubbleDeviceId == null ? "" : sHubbleDeviceId;
    }

    @Deprecated
    public static String getPeerid() {
        if (TextUtils.isEmpty(sPeerId) && mContext != null) {
            Context context = mContext;
            String str = null;
            Object a = f.a(context);
            if (TextUtils.isEmpty(a) || a.equals("02:00:00:00:00:00")) {
                a = "";
                Object b = f.b(context);
                if (!TextUtils.isEmpty(b)) {
                    String toUpperCase = b.replaceAll("[^0-9a-fA-F]", "").toUpperCase();
                    if (toUpperCase.length() >= 12) {
                        a = toUpperCase.substring(toUpperCase.length() - 12);
                    } else {
                        a = g.a(toUpperCase.getBytes()).substring(0, 12).toUpperCase();
                    }
                }
            }
            if (!TextUtils.isEmpty(a)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a.replaceAll("[^0-9a-fA-F]", "").toUpperCase());
                stringBuilder.append("004V");
                str = stringBuilder.toString();
            }
            if (TextUtils.isEmpty(str)) {
                str = "0000000000000000004V";
            }
            sPeerId = str;
        }
        return sPeerId;
    }

    public static String getMacAddress() {
        String c = a.c(mContext);
        return !TextUtils.isEmpty(c) ? c.toUpperCase() : c;
    }

    public static String getMAC() {
        if (TextUtils.isEmpty(sMac) && mContext != null) {
            sMac = getMacAddress();
        }
        return sMac;
    }

    public static String getIMEI(Context context) {
        context = a.b(context);
        return TextUtils.isEmpty(context) ? DEFAULT_IMEI : context;
    }

    public static String getIMEI() {
        if (mContext != null && (TextUtils.isEmpty(sImei) || DEFAULT_IMEI.equals(sImei))) {
            sImei = getIMEI(mContext);
        }
        if (TextUtils.isEmpty(sImei)) {
            return DEFAULT_IMEI;
        }
        return sImei;
    }

    private static PackageConfig getPackageConfig(Context context) {
        if (sPackageConfig == null) {
            synchronized (AndroidConfig.class) {
                if (sPackageConfig == null) {
                    PackageConfig packageConfig = new PackageConfig();
                    sPackageConfig = packageConfig;
                    packageConfig.loadConfigure(context);
                }
            }
        }
        return sPackageConfig;
    }

    public static boolean isPackageUpdatable(Context context) {
        return getPackageConfig(context).mUpdate;
    }

    public static String getPartnerName(Context context) {
        return context != null ? getPackageConfig(context).mChannelName : "";
    }

    public static String getPartnerId(Context context) {
        return context != null ? getPackageConfig(context).mChannelId : "";
    }

    public static String getPartnerId() {
        return getPartnerId(mContext);
    }

    public static int getAndroidVersion() {
        return VERSION.SDK_INT;
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    public static String getPhoneBrand() {
        return Build.BRAND;
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getDisplay() {
        return Build.DISPLAY;
    }

    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public static String getHardware() {
        return Build.HARDWARE;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static String getProuduct() {
        return Build.PRODUCT;
    }

    public static String getTags() {
        return Build.TAGS;
    }

    public static int getScreenWidth() {
        if (sScreenWidth == 0) {
            sScreenWidth = d.a(mContext);
        }
        return sScreenWidth;
    }

    public static int getScreenHeight() {
        if (sScreenHeight == 0) {
            sScreenHeight = d.b(mContext);
        }
        return sScreenHeight;
    }

    public static int[] getRealScreenSize() {
        Point e = d.e(mContext);
        return new int[]{e.x, e.y};
    }

    public static void hiddenInput(Context context, View view) {
        if ((context instanceof Context) && (view instanceof View)) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static String getUserAgent() {
        String webViewUserAgent = getWebViewUserAgent();
        return TextUtils.isEmpty(webViewUserAgent) ? getSystemUserAgent() : webViewUserAgent;
    }

    private static String getWebViewUserAgent() {
        if (VERSION.SDK_INT >= 17) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(WebSettings.getDefaultUserAgent(mContext));
                stringBuilder.append(" iThunder");
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String getSystemUserAgent() {
        return System.getProperty("http.agent");
    }
}
