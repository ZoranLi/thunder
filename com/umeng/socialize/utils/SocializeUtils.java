package com.umeng.socialize.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import com.umeng.socialize.Config;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class SocializeUtils {
    protected static final String TAG = "SocializeUtils";
    public static Set<Uri> deleteUris = new HashSet();
    private static Pattern mDoubleByte_Pattern;
    private static int smDip;

    public static String getAppkey(Context context) {
        if (context == null) {
            return "";
        }
        CharSequence charSequence = SocializeConstants.APPKEY;
        if (TextUtils.isEmpty(charSequence)) {
            try {
                context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (context != null) {
                    context = context.metaData.get("UMENG_APPKEY");
                    if (context != null) {
                        context = context.toString();
                        return context;
                    }
                    Log.e("com.umeng.socialize", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
                }
            } catch (Context context2) {
                Log.e("com.umeng.socialize", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", context2);
            }
        }
        context2 = charSequence;
        return context2;
    }

    public static void safeCloseDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Dialog dialog2) {
                Log.e(TAG, "dialog dismiss error", dialog2);
            }
        }
    }

    public static void openApplicationMarket(Context context, String str) throws Exception {
        if (Config.isJumptoAppStore) {
            StringBuilder stringBuilder = new StringBuilder("market://details?id=");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        }
    }

    public static void safeShowDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                if (!dialog.isShowing()) {
                    dialog.show();
                }
            } catch (Dialog dialog2) {
                Log.e(TAG, "dialog show error", dialog2);
            }
        }
    }

    public static android.os.Bundle parseUrl(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0019 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x0019 }
        r1 = r0.getQuery();	 Catch:{ MalformedURLException -> 0x0019 }
        r1 = decodeUrl(r1);	 Catch:{ MalformedURLException -> 0x0019 }
        r0 = r0.getRef();	 Catch:{ MalformedURLException -> 0x0019 }
        r0 = decodeUrl(r0);	 Catch:{ MalformedURLException -> 0x0019 }
        r1.putAll(r0);	 Catch:{ MalformedURLException -> 0x0019 }
        return r1;
    L_0x0019:
        r1 = new android.os.Bundle;
        r1.<init>();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.SocializeUtils.parseUrl(java.lang.String):android.os.Bundle");
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }

    public static int countContentLength(String str) {
        str = str.trim();
        int i = 0;
        while (getDoubleBytePattern().matcher(str).find()) {
            i++;
        }
        str = str.length() - i;
        if (str % 2 != 0) {
            return i + ((str + 1) / 2);
        }
        return i + (str / 2);
    }

    private static Pattern getDoubleBytePattern() {
        if (mDoubleByte_Pattern == null) {
            mDoubleByte_Pattern = Pattern.compile("[^\\x00-\\xff]");
        }
        return mDoubleByte_Pattern;
    }

    public static int[] getFloatWindowSize(Context context) {
        if (context == null) {
            return new int[2];
        }
        ResContainer resContainer = ResContainer.get(context);
        context = context.getResources();
        return new int[]{(int) context.getDimension(resContainer.dimen("umeng_socialize_pad_window_width")), (int) context.getDimension(resContainer.dimen("umeng_socialize_pad_window_height"))};
    }

    public static boolean isFloatWindowStyle(Context context) {
        if (context != null && SocializeConstants.SUPPORT_PAD) {
            if (smDip == 0) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                if (width <= height) {
                    height = width;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                smDip = (int) ((((float) height) / displayMetrics.density) + PayBaseConstants.HALF_OF_FLOAT);
            }
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3 && smDip >= 550) {
                return true;
            }
        }
        return false;
    }

    public static Uri insertImage(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (new File(str).exists()) {
                try {
                    context = Media.insertImage(context.getContentResolver(), str, "umeng_social_shareimg", null);
                    if (TextUtils.isEmpty(context) != null) {
                        return null;
                    }
                    return Uri.parse(context);
                } catch (Context context2) {
                    Log.e("com.umeng.socialize", "", context2);
                    return null;
                } catch (Context context22) {
                    Log.e("com.umeng.socialize", "", context22);
                    return null;
                }
            }
        }
        return null;
    }

    public static int dip2Px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public static Map<String, String> jsonToMap(String str) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.keys();
            while (str.hasNext()) {
                String str2 = (String) str.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.get(str2));
                hashMap.put(str2, stringBuilder.toString());
            }
        } catch (String str3) {
            String str4 = NotificationCompat.CATEGORY_SOCIAL;
            StringBuilder stringBuilder2 = new StringBuilder("jsontomap fail=");
            stringBuilder2.append(str3);
            Log.e(str4, stringBuilder2.toString());
        }
        return hashMap;
    }

    public static byte[] File2byte(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            file = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    file.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    file.close();
                    return file.toByteArray();
                }
            }
        } catch (File file2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(UmengText.FILE_TO_BINARY_ERROR);
            stringBuilder.append(file2.getMessage());
            Log.um(stringBuilder.toString());
            return null;
        } catch (File file22) {
            file22.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> bundleTomap(Bundle bundle) {
        if (bundle != null) {
            if (!bundle.isEmpty()) {
                Set<String> keySet = bundle.keySet();
                Map<String, String> hashMap = new HashMap();
                for (String str : keySet) {
                    if (str.equals(WbAuthConstants.EXTRA_USER_ICON)) {
                        hashMap.put("icon_url", bundle.getString(str));
                    }
                    hashMap.put(str, bundle.getString(str));
                }
                return hashMap;
            }
        }
        return null;
    }

    public static Bundle mapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, (String) map.get(str));
        }
        return bundle;
    }

    public static boolean assertBinaryInvalid(byte[] bArr) {
        return (bArr == null || bArr.length <= null) ? null : 1;
    }

    public static boolean isToday(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(System.currentTimeMillis()));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date(j));
        if (instance2.get(1) == instance.get(1) && instance2.get(6) - instance.get(6) == 0) {
            return true;
        }
        return 0;
    }
}
