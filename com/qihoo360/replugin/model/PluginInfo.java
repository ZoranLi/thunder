package com.qihoo360.replugin.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.qihoo360.loader2.ab;
import com.qihoo360.loader2.at;
import com.qihoo360.loader2.e;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.b;
import com.qihoo360.replugin.g;
import com.taobao.accs.common.Constants;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginInfo implements Parcelable, Serializable, Cloneable {
    public static final Creator<PluginInfo> CREATOR = new a();
    public static final int FRAMEWORK_VERSION_UNKNOWN = 0;
    public static final String[] QUERY_COLUMNS = new String[]{c.e, "low", "high", "ver", "type", "v5type", "path", "v5index", "v5offset", "v5length", "v5md5"};
    private static final Pattern REGEX = Pattern.compile("^([^-]+)-([0-9]+)-([0-9]+)-([0-9]+).jar$");
    private static final String TAG = "PluginInfo";
    public static final int TYPE_BUILTIN = 2;
    public static final int TYPE_EXTRACTED = 11;
    public static final int TYPE_NOT_INSTALL = 10;
    public static final int TYPE_PN_INSTALLED = 1;
    public static final int TYPE_PN_JAR = 3;
    public static final Comparator<PluginInfo> VERSION_COMPARATOR = new b();
    private static final long serialVersionUID = -6531475023210445876L;
    private boolean mIsPendingCover;
    private transient JSONObject mJson;
    private String mJsonText;
    private PluginInfo mParentInfo;
    private PluginInfo mPendingCover;
    private PluginInfo mPendingDelete;
    private PluginInfo mPendingUpdate;

    public int describeContents() {
        return 0;
    }

    private PluginInfo(JSONObject jSONObject) {
        initPluginInfo(jSONObject);
    }

    private PluginInfo(String str, int i, int i2, int i3) {
        this.mJson = new JSONObject();
        b.a(this.mJson, c.e, str);
        b.a(this.mJson, "low", Integer.valueOf(i));
        b.a(this.mJson, "high", Integer.valueOf(i2));
        b.a(this.mJson, "ver", Integer.valueOf(i3));
    }

    private PluginInfo(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        if (i <= 0) {
            i = e.a;
        }
        if (i2 <= 0) {
            i2 = e.a;
        }
        this.mJson = new JSONObject();
        b.a(this.mJson, "pkgname", str);
        b.a(this.mJson, "ali", str2);
        b.a(this.mJson, c.e, makeName(str, str2));
        b.a(this.mJson, "low", Integer.valueOf(i));
        b.a(this.mJson, "high", Integer.valueOf(i2));
        setVersion(i3);
        setPath(str3);
        setType(i4);
    }

    private void initPluginInfo(JSONObject jSONObject) {
        this.mJson = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("upinfo");
        if (optJSONObject != null) {
            this.mPendingUpdate = new PluginInfo(optJSONObject);
        }
        optJSONObject = jSONObject.optJSONObject("delinfo");
        if (optJSONObject != null) {
            this.mPendingDelete = new PluginInfo(optJSONObject);
        }
        optJSONObject = jSONObject.optJSONObject("coverinfo");
        if (optJSONObject != null) {
            this.mPendingCover = new PluginInfo(optJSONObject);
        }
        this.mIsPendingCover = jSONObject.optBoolean("cover");
    }

    private String makeName(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return TextUtils.isEmpty(str) == null ? str : "";
        } else {
            return str2;
        }
    }

    public static PluginInfo parseFromPackageInfo(PackageInfo packageInfo, String str) {
        int i;
        int i2;
        String str2;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str3 = packageInfo.packageName;
        Bundle bundle = applicationInfo.metaData;
        int i3 = 0;
        if (bundle != null) {
            String string = bundle.getString("com.qihoo360.plugin.name");
            int i4 = bundle.getInt("com.qihoo360.plugin.version.low");
            i = bundle.getInt("com.qihoo360.plugin.version.high");
            i2 = bundle.getInt("com.qihoo360.plugin.version.ver");
            int i5 = i4;
            str2 = string;
            i3 = i5;
        } else {
            str2 = null;
            i = 0;
            i2 = i;
        }
        if (i3 <= 0) {
            i3 = e.a;
        }
        PluginInfo pluginInfo = new PluginInfo(str3, str2, i3, i <= 0 ? e.a : i, i2 <= 0 ? packageInfo.versionCode : i2, str, 10);
        pluginInfo.setFrameworkVersionByMeta(bundle);
        return pluginInfo;
    }

    public static PluginInfo parseFromJsonText(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("pkgname") == null || jSONObject.has("type") == null || jSONObject.has("ver") == null) {
                return null;
            }
            return new PluginInfo(jSONObject);
        } catch (String str2) {
            if (com.qihoo360.replugin.b.c.a) {
                str2.printStackTrace();
            }
            return null;
        }
    }

    public String getName() {
        return this.mJson.optString(c.e);
    }

    public String getPackageName() {
        return this.mJson.optString("pkgname");
    }

    public String getAlias() {
        return this.mJson.optString("ali");
    }

    public int getVersion() {
        return this.mJson.optInt("ver");
    }

    public String getPath() {
        return this.mJson.optString("path");
    }

    public void setPath(String str) {
        b.a(this.mJson, "path", str);
    }

    public boolean isUsed() {
        if (isPnPlugin()) {
            return isDexExtracted();
        }
        if (getParentInfo() != null) {
            return getParentInfo().isUsed();
        }
        return this.mJson.optBoolean("used");
    }

    public void setIsUsed(boolean z) {
        b.a(this.mJson, "used", Boolean.valueOf(z));
    }

    public long getVersionValue() {
        return this.mJson.optLong("verv");
    }

    public boolean isDexExtracted() {
        File dexFile = getDexFile();
        if (dexFile.exists()) {
            if (dexFile.exists()) {
                long e;
                if (dexFile.isDirectory()) {
                    e = com.qihoo360.replugin.utils.c.e(dexFile);
                } else {
                    e = dexFile.length();
                }
                if (e > 0) {
                    return true;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(dexFile);
            stringBuilder.append(" does not exist");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return false;
    }

    public File getApkFile() {
        String apkDir = getApkDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(makeInstalledFileName());
        stringBuilder.append(ShareConstants.JAR_SUFFIX);
        return new File(apkDir, stringBuilder.toString());
    }

    public String getApkDir() {
        File dir;
        Context a = g.a();
        if (isPnPlugin()) {
            dir = a.getDir("plugins_v3", 0);
        } else if (getIsPendingCover()) {
            dir = a.getDir("p_c", 0);
        } else {
            dir = a.getDir("p_a", 0);
        }
        return dir.getAbsolutePath();
    }

    @NonNull
    private File getDexDir(File file, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(makeInstalledFileName());
        stringBuilder.append(str);
        File file2 = new File(file, stringBuilder.toString());
        if (file2.exists() == null) {
            file2.mkdir();
        }
        return file2;
    }

    public File getExtraDexDir() {
        return getDexDir(getDexParentDir(), "_ed");
    }

    public File getExtraOdexDir() {
        return getDexDir(getDexParentDir(), "_eod");
    }

    public File getDexParentDir() {
        Context a = g.a();
        if (VERSION.SDK_INT > 25) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getApkDir());
            stringBuilder.append(File.separator);
            stringBuilder.append(ShareConstants.ANDROID_O_DEX_OPTIMIZE_PATH);
            stringBuilder.append(File.separator);
            stringBuilder.append(at.b());
            return new File(stringBuilder.toString());
        } else if (isPnPlugin()) {
            return a.getDir("plugins_v3_odex", 0);
        } else {
            if (getIsPendingCover()) {
                return a.getDir("p_c", 0);
            }
            return a.getDir("p_od", 0);
        }
    }

    public File getDexFile() {
        if (VERSION.SDK_INT > 25) {
            File dexParentDir = getDexParentDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(makeInstalledFileName());
            stringBuilder.append(ShareConstants.ODEX_SUFFIX);
            return new File(dexParentDir, stringBuilder.toString());
        }
        dexParentDir = getDexParentDir();
        stringBuilder = new StringBuilder();
        stringBuilder.append(makeInstalledFileName());
        stringBuilder.append(ShareConstants.DEX_SUFFIX);
        return new File(dexParentDir, stringBuilder.toString());
    }

    public File getNativeLibsDir() {
        File dir;
        Context a = g.a();
        if (isPnPlugin()) {
            dir = a.getDir("plugins_v3_libs", 0);
        } else if (getIsPendingCover()) {
            dir = a.getDir("p_c", 0);
        } else {
            dir = a.getDir("p_n", 0);
        }
        return new File(dir, makeInstalledFileName());
    }

    public int getType() {
        return this.mJson.optInt("type");
    }

    public void setType(int i) {
        b.a(this.mJson, "type", Integer.valueOf(i));
    }

    public boolean isNeedUpdate() {
        return this.mPendingUpdate != null;
    }

    public PluginInfo getPendingUpdate() {
        return this.mPendingUpdate;
    }

    public void setPendingUpdate(PluginInfo pluginInfo) {
        this.mPendingUpdate = pluginInfo;
        if (pluginInfo != null) {
            b.a(this.mJson, "upinfo", pluginInfo.getJSON());
        } else {
            this.mJson.remove("upinfo");
        }
    }

    public boolean isNeedUninstall() {
        return this.mPendingDelete != null;
    }

    public PluginInfo getPendingDelete() {
        return this.mPendingDelete;
    }

    public void setPendingDelete(PluginInfo pluginInfo) {
        this.mPendingDelete = pluginInfo;
        if (pluginInfo != null) {
            b.a(this.mJson, "delinfo", pluginInfo.getJSON());
        } else {
            this.mJson.remove("delinfo");
        }
    }

    public boolean isNeedCover() {
        return this.mPendingCover != null;
    }

    public PluginInfo getPendingCover() {
        return this.mPendingCover;
    }

    public void setPendingCover(PluginInfo pluginInfo) {
        this.mPendingCover = pluginInfo;
        if (pluginInfo != null) {
            b.a(this.mJson, "coverinfo", pluginInfo.getJSON());
        } else {
            this.mJson.remove("coverinfo");
        }
    }

    public boolean getIsPendingCover() {
        return this.mIsPendingCover;
    }

    public void setIsPendingCover(boolean z) {
        this.mIsPendingCover = z;
        if (this.mIsPendingCover) {
            b.a(this.mJson, "cover", Boolean.valueOf(this.mIsPendingCover));
        } else {
            this.mJson.remove("cover");
        }
    }

    public int getLowInterfaceApi() {
        return this.mJson.optInt("low", e.a);
    }

    public int getHighInterfaceApi() {
        return this.mJson.optInt("high", e.a);
    }

    public int getFrameworkVersion() {
        return this.mJson.optInt("frm_ver", 0);
    }

    public void setFrameworkVersion(int i) {
        b.a(this.mJson, "frm_ver", Integer.valueOf(i));
    }

    public void setFrameworkVersionByMeta(Bundle bundle) {
        int i = RePlugin.getConfig().h;
        bundle = bundle != null ? bundle.getInt("com.qihoo360.framework.ver", i) : null;
        if (bundle <= null) {
            bundle = i;
        }
        setFrameworkVersion(bundle);
    }

    public JSONObject getJSON() {
        return this.mJson;
    }

    public String makeInstalledFileName() {
        if (!isPnPlugin()) {
            if (getType() != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getPackageName().toLowerCase());
                stringBuilder.append(getLowInterfaceApi());
                stringBuilder.append(getHighInterfaceApi());
                stringBuilder.append(getVersion());
                stringBuilder.append(SocializeProtocolConstants.PROTOCOL_KEY_AK);
                return Integer.toString(stringBuilder.toString().hashCode() - 88);
            }
        }
        return formatName();
    }

    public void update(PluginInfo pluginInfo) {
        setVersion(pluginInfo.getVersion());
        setPath(pluginInfo.getPath());
        setType(pluginInfo.getType());
        setPackageName(pluginInfo.getPackageName());
        setAlias(pluginInfo.getAlias());
    }

    public PluginInfo getParentInfo() {
        return this.mParentInfo;
    }

    public void setParentInfo(PluginInfo pluginInfo) {
        this.mParentInfo = pluginInfo;
    }

    static PluginInfo createByJO(JSONObject jSONObject) {
        PluginInfo pluginInfo = new PluginInfo(jSONObject);
        return TextUtils.isEmpty(pluginInfo.getName()) != null ? null : pluginInfo;
    }

    private void setPackageName(String str) {
        if (!TextUtils.equals(str, getPackageName())) {
            b.a(this.mJson, "pkgname", str);
        }
    }

    private void setAlias(String str) {
        if (!TextUtils.equals(str, getAlias())) {
            b.a(this.mJson, "ali", str);
        }
    }

    private void setVersion(int i) {
        b.a(this.mJson, "ver", Integer.valueOf(i));
        b.a(this.mJson, "verv", Long.valueOf(buildCompareValue()));
    }

    private PluginInfo(Parcel parcel) {
        JSONObject jSONObject;
        Throwable e;
        String str;
        StringBuilder stringBuilder;
        try {
            parcel = parcel.readString();
            try {
                jSONObject = new JSONObject(parcel);
            } catch (JSONException e2) {
                e = e2;
                if (com.qihoo360.replugin.b.c.a) {
                    str = TAG;
                    stringBuilder = new StringBuilder("PluginInfo: mJson error! s=");
                    stringBuilder.append(parcel);
                    com.qihoo360.replugin.b.c.b(str, stringBuilder.toString(), e);
                }
                jSONObject = new JSONObject();
                initPluginInfo(jSONObject);
            }
        } catch (JSONException e3) {
            e = e3;
            parcel = null;
            if (com.qihoo360.replugin.b.c.a) {
                str = TAG;
                stringBuilder = new StringBuilder("PluginInfo: mJson error! s=");
                stringBuilder.append(parcel);
                com.qihoo360.replugin.b.c.b(str, stringBuilder.toString(), e);
            }
            jSONObject = new JSONObject();
            initPluginInfo(jSONObject);
        }
        initPluginInfo(jSONObject);
    }

    public Object clone() {
        Object obj;
        ClassNotFoundException e;
        IOException e2;
        JSONException e3;
        this.mJsonText = this.mJson != null ? this.mJson.toString() : null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
            obj = (PluginInfo) new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
            if (obj != null) {
                try {
                    if (!TextUtils.isEmpty(this.mJsonText)) {
                        obj.mJson = new JSONObject(this.mJsonText);
                        JSONObject optJSONObject = obj.mJson.optJSONObject("upinfo");
                        if (optJSONObject != null) {
                            obj.mPendingUpdate = new PluginInfo(optJSONObject);
                        }
                        optJSONObject = obj.mJson.optJSONObject("delinfo");
                        if (optJSONObject != null) {
                            obj.mPendingDelete = new PluginInfo(optJSONObject);
                        }
                        optJSONObject = obj.mJson.optJSONObject("coverinfo");
                        if (optJSONObject != null) {
                            obj.mPendingCover = new PluginInfo(optJSONObject);
                        }
                    }
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    return obj;
                } catch (IOException e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    return obj;
                } catch (JSONException e6) {
                    e3 = e6;
                    e3.printStackTrace();
                    return obj;
                }
            }
        } catch (ClassNotFoundException e7) {
            e = e7;
            obj = null;
            e.printStackTrace();
            return obj;
        } catch (IOException e8) {
            e2 = e8;
            obj = null;
            e2.printStackTrace();
            return obj;
        } catch (JSONException e9) {
            e3 = e9;
            obj = null;
            e3.printStackTrace();
            return obj;
        }
        return obj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mJson.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PInfo { ");
        toContentString(stringBuilder);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    private void toContentString(StringBuilder stringBuilder) {
        stringBuilder.append('<');
        stringBuilder.append(getName());
        stringBuilder.append(':');
        stringBuilder.append(getVersion());
        stringBuilder.append('(');
        stringBuilder.append(getFrameworkVersion());
        stringBuilder.append(')');
        stringBuilder.append("> ");
        if (this.mParentInfo != null) {
            stringBuilder.append("[HAS_PARENT] ");
        }
        if (getType() == 2) {
            stringBuilder.append("[BUILTIN] ");
        } else if (isPnPlugin()) {
            stringBuilder.append("[P-N] ");
        } else {
            stringBuilder.append("[APK] ");
        }
        if (isDexExtracted()) {
            stringBuilder.append("[DEX_EXTRACTED] ");
        }
        if (RePlugin.isPluginRunning(getName())) {
            stringBuilder.append("[RUNNING] ");
        }
        String[] runningProcessesByPlugin = RePlugin.getRunningProcessesByPlugin(getName());
        if (runningProcessesByPlugin != null) {
            stringBuilder.append("processes=");
            stringBuilder.append(Arrays.toString(runningProcessesByPlugin));
            stringBuilder.append(' ');
        }
        if (this.mJson != null) {
            stringBuilder.append("js=");
            stringBuilder.append(this.mJson);
            stringBuilder.append(' ');
        }
        stringBuilder.append("dex=");
        stringBuilder.append(getDexFile());
        stringBuilder.append(' ');
        stringBuilder.append("nlib=");
        stringBuilder.append(getNativeLibsDir());
    }

    public int hashCode() {
        return this.mJson.hashCode();
    }

    public boolean equals(java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        if (r3 != r4) goto L_0x0008;
    L_0x0006:
        r4 = 1;
        return r4;
    L_0x0008:
        r1 = r3.getClass();
        r2 = r4.getClass();
        if (r1 == r2) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r4 = (com.qihoo360.replugin.model.PluginInfo) r4;
        r4 = r4.mJson;	 Catch:{ Exception -> 0x0026 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0026 }
        r1 = r3.mJson;	 Catch:{ Exception -> 0x0026 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0026 }
        r4 = r4.equals(r1);	 Catch:{ Exception -> 0x0026 }
        return r4;
    L_0x0026:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.model.PluginInfo.equals(java.lang.Object):boolean");
    }

    public static final String format(String str, int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(i2);
        stringBuilder.append("-");
        stringBuilder.append(i3);
        return stringBuilder.toString();
    }

    public static final PluginInfo build(File file) {
        StringBuilder stringBuilder;
        Matcher matcher = REGEX.matcher(file.getName());
        if (matcher != null) {
            if (matcher.matches()) {
                MatchResult toMatchResult = matcher.toMatchResult();
                if (toMatchResult != null) {
                    if (toMatchResult.groupCount() == 4) {
                        PluginInfo pluginInfo = new PluginInfo(toMatchResult.group(1), Integer.parseInt(toMatchResult.group(2)), Integer.parseInt(toMatchResult.group(3)), Integer.parseInt(toMatchResult.group(4)), 1, 0, file.getPath(), -1, -1, -1, null);
                        if (com.qihoo360.replugin.b.c.a) {
                            stringBuilder = new StringBuilder("PluginInfo.build: found plugin, name=");
                            stringBuilder.append(pluginInfo.getName());
                            stringBuilder.append(" low=");
                            stringBuilder.append(pluginInfo.getLowInterfaceApi());
                            stringBuilder.append(" high=");
                            stringBuilder.append(pluginInfo.getHighInterfaceApi());
                            stringBuilder.append(" ver=");
                            stringBuilder.append(pluginInfo.getVersion());
                            com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
                        }
                        return pluginInfo;
                    }
                }
                if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder = new StringBuilder("PluginInfo.build: skip, no match2, file=");
                    stringBuilder.append(file.getAbsolutePath());
                    com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
                }
                return null;
            }
        }
        if (com.qihoo360.replugin.b.c.a) {
            stringBuilder = new StringBuilder("PluginInfo.build: skip, no match1, file=");
            stringBuilder.append(file.getAbsolutePath());
            com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
        }
        return null;
    }

    public static final PluginInfo buildFromBuiltInJson(JSONObject jSONObject) {
        Object optString = jSONObject.optString(Constants.KEY_ELECTION_PKG);
        Object optString2 = jSONObject.optString(c.e);
        Object optString3 = jSONObject.optString("path");
        if (!(TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString))) {
            if (!TextUtils.isEmpty(optString3)) {
                PluginInfo pluginInfo = new PluginInfo(optString, optString2, jSONObject.optInt("low", e.a), jSONObject.optInt("high", e.a), jSONObject.optInt("ver"), optString3, 2);
                jSONObject = jSONObject.optInt("frm");
                if (jSONObject <= null) {
                    jSONObject = RePlugin.getConfig().h;
                }
                pluginInfo.setFrameworkVersion(jSONObject);
                return pluginInfo;
            }
        }
        if (com.qihoo360.replugin.b.c.a) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("buildFromBuiltInJson: Invalid json. j=");
            stringBuilder.append(jSONObject);
            com.qihoo360.replugin.b.c.a(str, stringBuilder.toString());
        }
        return null;
    }

    public static final PluginInfo buildV5(String str, int i, int i2, int i3, int i4, String str2, int i5, int i6, int i7, String str3) {
        return new PluginInfo(str, i, i2, i3, 3, i4, str2, i5, i6, i7, str3);
    }

    public static final PluginInfo build(Cursor cursor) {
        return new PluginInfo(cursor.getString(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getString(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getString(10));
    }

    public static final PluginInfo build(String str, int i, int i2, int i3) {
        return new PluginInfo(str, i, i2, i3);
    }

    private PluginInfo(String str, int i, int i2, int i3, int i4, int i5, String str2, int i6, int i7, int i8, String str3) {
        this(str, str, i, i2, i3, str2, i4);
        b.a(this.mJson, "v5type", Integer.valueOf(i5));
        b.a(this.mJson, "v5index", Integer.valueOf(i6));
        b.a(this.mJson, "v5offset", Integer.valueOf(i7));
        b.a(this.mJson, "v5length", Integer.valueOf(i8));
        b.a(this.mJson, "v5md5", str3);
    }

    private String formatName() {
        return format(getName(), getLowInterfaceApi(), getHighInterfaceApi(), getVersion());
    }

    final void to(MatrixCursor matrixCursor) {
        matrixCursor.newRow().add(getName()).add(Integer.valueOf(getLowInterfaceApi())).add(Integer.valueOf(getHighInterfaceApi())).add(Integer.valueOf(getVersion())).add(Integer.valueOf(getType())).add(Integer.valueOf(getV5Type())).add(getPath()).add(Integer.valueOf(getV5Index())).add(Integer.valueOf(getV5Offset())).add(Integer.valueOf(getV5Length())).add(getV5MD5());
    }

    public final void to(Intent intent) {
        intent.putExtra(c.e, getName());
        intent.putExtra("low", getLowInterfaceApi());
        intent.putExtra("high", getHighInterfaceApi());
        intent.putExtra("ver", getVersion());
        intent.putExtra("type", getType());
        intent.putExtra("v5type", getV5Type());
        intent.putExtra("path", getPath());
        intent.putExtra("v5index", getV5Index());
        intent.putExtra("v5offset", getV5Offset());
        intent.putExtra("v5length", getV5Length());
        intent.putExtra("v5md5", getV5MD5());
    }

    public final boolean deleteObsolote(Context context) {
        if (getType() != 1 || TextUtils.isEmpty(getPath()) != null) {
            return true;
        }
        context = new File(getPath()).delete();
        ab.a(getNativeLibsDir());
        return context;
    }

    public final boolean canReplaceForPn(PluginInfo pluginInfo) {
        if (getType() != 1 && pluginInfo.getType() == 1 && getName().equals(pluginInfo.getName()) && getLowInterfaceApi() == pluginInfo.getLowInterfaceApi() && getHighInterfaceApi() == pluginInfo.getHighInterfaceApi() && getVersion() == pluginInfo.getVersion()) {
            return true;
        }
        return null;
    }

    public final boolean match() {
        RePlugin.getConfig();
        boolean z = com.qihoo360.replugin.b.c.a;
        return true;
    }

    private final long buildCompareValue() {
        return ((((long) (getHighInterfaceApi() & 32767)) << 48) | (((long) (getLowInterfaceApi() & 65535)) << 32)) | ((long) getVersion());
    }

    public boolean isPnPlugin() {
        int type = getType();
        if (!(type == 1 || type == 3)) {
            if (type != 2) {
                return false;
            }
        }
        return true;
    }

    public int getV5Type() {
        return this.mJson.optInt("v5type", 0);
    }

    public int getV5Index() {
        return this.mJson.optInt("v5index", -1);
    }

    public int getV5Offset() {
        return this.mJson.optInt("v5offset", -1);
    }

    public int getV5Length() {
        return this.mJson.optInt("v5length", -1);
    }

    public String getV5MD5() {
        return this.mJson.optString("v5md5");
    }
}
