package com.xunlei.downloadprovider.vod.subtitle;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.download.Downloads.Impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SubtitleManager */
public class g {
    public static final String a = "g";
    public static String b = "com.android.providers.downloads";
    private static final String[] l = new String[]{"ass", "sub", "srt", "ssa", "smi", "sami"};
    private static final String[] m = new String[]{"〇", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    public final l c;
    public final Handler d;
    public final Context e;
    public DownloadManager f = null;
    public b g;
    public c h;
    public a i;
    public SubtitleManifest j;
    public BroadcastReceiver k = new p(this);

    /* compiled from: SubtitleManager */
    public interface a {
        void a(String str);
    }

    /* compiled from: SubtitleManager */
    public interface b {
        void a(SubtitleManifest subtitleManifest);
    }

    /* compiled from: SubtitleManager */
    public interface c {
        void a(SubtitleManifest subtitleManifest);
    }

    public g(Context context) {
        this.e = context;
        this.c = VolleyRequestManager.getRequestQueue();
        this.d = new Handler();
    }

    public static JSONObject a(String str, String str2, int i, SubtitleInfo subtitleInfo, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("m_cid", str);
            jSONObject.put("m_name", str2);
            jSONObject.put("m_duration", i);
            jSONObject.put("s_cid", subtitleInfo.getScid());
            jSONObject.put("s_duration", subtitleInfo.getsDuration());
            jSONObject.put("s_name", subtitleInfo.getDisplayName());
            jSONObject.put("s_languages", subtitleInfo.getFileLanguange());
            jSONObject.put("s_ext", subtitleInfo.getFileExtension());
            jSONObject.put("use_duration", i2);
        } catch (String str3) {
            str3.printStackTrace();
        }
        return jSONObject;
    }

    public static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        if (i < 10) {
            stringBuilder.append(m[i % 10]);
        } else if (i == 10) {
            stringBuilder.append("十");
        } else if (i < 20) {
            stringBuilder.append("十");
            stringBuilder.append(m[i % 10]);
        } else {
            while (i > 0) {
                stringBuilder.append(m[i % 10]);
                i /= 10;
            }
            stringBuilder.reverse();
        }
        return stringBuilder.toString();
    }

    public static boolean a(Context context) {
        try {
            context = context.getPackageManager().getApplicationEnabledSetting(b);
            if (VERSION.SDK_INT > 18) {
                if (context == 2 || context == 3 || context == 4) {
                    return false;
                }
                return true;
            } else if (context == 2 || context == 3) {
                return false;
            } else {
                return true;
            }
        } catch (Context context2) {
            context2.printStackTrace();
            return false;
        }
    }

    public static int a(SubtitleManifest subtitleManifest) {
        if (subtitleManifest != null) {
            if (subtitleManifest.getListCount() > 0) {
                int listCount = subtitleManifest.getListCount();
                List subtitleList = subtitleManifest.getSubtitleList();
                int i = 0;
                for (listCount--; listCount >= 0; listCount--) {
                    if (!((SubtitleInfo) subtitleList.get(listCount)).isDownload()) {
                        subtitleList.remove(listCount);
                        i++;
                    }
                }
                subtitleManifest.setLocalSubCount(0);
                subtitleManifest = new StringBuilder("excluded ");
                subtitleManifest.append(i);
                subtitleManifest.append(" local files");
                return i;
            }
        }
        return 0;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str = str.toLowerCase();
        for (CharSequence equals : l) {
            if (TextUtils.equals(equals, str)) {
                return true;
            }
        }
        return false;
    }

    public final int b(String str) {
        int i = -1;
        if (this.j != null) {
            if (this.j.getListCount() > 0) {
                int listCount = this.j.getListCount();
                List subtitleList = this.j.getSubtitleList();
                for (int i2 = 0; i2 < listCount; i2++) {
                    if (TextUtils.equals(str, ((SubtitleInfo) subtitleList.get(i2)).getScid())) {
                        i = i2;
                        break;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public final String a(Uri uri) {
        uri = this.e.getContentResolver().query(uri, null, null, null, null);
        String str = null;
        if (uri != null) {
            uri.moveToFirst();
            int columnIndex = uri.getColumnIndex(Impl._DATA);
            if (columnIndex >= 0) {
                str = uri.getString(columnIndex);
            }
            uri.close();
        }
        return str;
    }

    public final SubtitleManifest a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        File a = a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".manifest");
        File file = new File(a, stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(".manifest");
        File file2 = new File(a, stringBuilder2.toString());
        if (TextUtils.isEmpty(str) != null || file.exists() == null) {
            if (TextUtils.isEmpty(str2) != null || file2.exists() == null) {
                return null;
            }
            file = file2;
        }
        if (System.currentTimeMillis() - file.lastModified() > 604800000) {
            file.delete();
            return null;
        }
        try {
            str = new ObjectInputStream(new FileInputStream(file));
            try {
                str2 = (SubtitleManifest) str.readObject();
                try {
                    str.close();
                } catch (String str3) {
                    str3.printStackTrace();
                }
            } catch (IOException e) {
                str2 = e;
                new StringBuilder("deserializeManifestData IO error=>").append(str2.getMessage());
                str2.printStackTrace();
                if (str3 != null) {
                    str3.close();
                }
                str2 = null;
                return str2;
            } catch (ClassNotFoundException e2) {
                str2 = e2;
                try {
                    new StringBuilder("deserializeManifestData class error=>").append(str2.getMessage());
                    str2.printStackTrace();
                    if (str3 != null) {
                        try {
                            str3.close();
                        } catch (String str32) {
                            str32.printStackTrace();
                        }
                    }
                    str2 = null;
                    return str2;
                } catch (Throwable th) {
                    str2 = th;
                    if (str32 != null) {
                        try {
                            str32.close();
                        } catch (String str322) {
                            str322.printStackTrace();
                        }
                    }
                    throw str2;
                }
            }
        } catch (IOException e3) {
            str2 = e3;
            str322 = null;
            new StringBuilder("deserializeManifestData IO error=>").append(str2.getMessage());
            str2.printStackTrace();
            if (str322 != null) {
                str322.close();
            }
            str2 = null;
            return str2;
        } catch (ClassNotFoundException e4) {
            str2 = e4;
            str322 = null;
            new StringBuilder("deserializeManifestData class error=>").append(str2.getMessage());
            str2.printStackTrace();
            if (str322 != null) {
                str322.close();
            }
            str2 = null;
            return str2;
        } catch (Throwable th2) {
            str2 = th2;
            str322 = null;
            if (str322 != null) {
                str322.close();
            }
            throw str2;
        }
        return str2;
    }

    public final File a() {
        File file = new File(b(), "manifest");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File b() {
        File file = new File(this.e.getExternalCacheDir(), "subtitles");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final java.io.File b(android.net.Uri r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = 1;
        r1 = 0;
        if (r9 != 0) goto L_0x0006;
    L_0x0004:
        r2 = r1;
        goto L_0x002c;
    L_0x0006:
        r2 = r9.toString();
        r3 = "UTF-8";
        r2 = com.xunlei.xllib.b.k.b(r2, r3);
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0004;
    L_0x0017:
        r3 = java.io.File.separator;
        r3 = r2.lastIndexOf(r3);
        if (r3 < 0) goto L_0x0004;
    L_0x001f:
        r4 = r2.length();
        r4 = r4 - r0;
        if (r3 < r4) goto L_0x0027;
    L_0x0026:
        goto L_0x0004;
    L_0x0027:
        r3 = r3 + r0;
        r2 = r2.substring(r3);
    L_0x002c:
        r3 = new java.io.File;
        r4 = r8.b();
        r3.<init>(r4, r2);
        r2 = r3.exists();
        if (r2 == 0) goto L_0x003c;
    L_0x003b:
        return r3;
    L_0x003c:
        r2 = 0;
        r4 = r8.e;	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0077, all -> 0x0074 }
        r4 = r4.getContentResolver();	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0077, all -> 0x0074 }
        r9 = r4.openInputStream(r9);	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0077, all -> 0x0074 }
        r3.createNewFile();	 Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006e, all -> 0x006c }
        r4 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006e, all -> 0x006c }
        r4.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006e, all -> 0x006c }
        r5 = 1444; // 0x5a4 float:2.023E-42 double:7.134E-321;
        r5 = new byte[r5];	 Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0068 }
    L_0x0053:
        r6 = r9.read(r5);	 Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0068 }
        r7 = -1;	 Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0068 }
        if (r6 == r7) goto L_0x005e;	 Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0068 }
    L_0x005a:
        r4.write(r5, r2, r6);	 Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0068 }
        goto L_0x0053;
    L_0x005e:
        if (r9 == 0) goto L_0x0063;
    L_0x0060:
        r9.close();	 Catch:{ IOException -> 0x0066 }
    L_0x0063:
        r4.close();	 Catch:{ IOException -> 0x0066 }
    L_0x0066:
        r0 = r2;
        goto L_0x0096;
    L_0x0068:
        r2 = move-exception;
        goto L_0x007a;
    L_0x006a:
        r2 = move-exception;
        goto L_0x008b;
    L_0x006c:
        r0 = move-exception;
        goto L_0x009c;
    L_0x006e:
        r2 = move-exception;
        r4 = r1;
        goto L_0x007a;
    L_0x0071:
        r2 = move-exception;
        r4 = r1;
        goto L_0x008b;
    L_0x0074:
        r0 = move-exception;
        r9 = r1;
        goto L_0x009c;
    L_0x0077:
        r2 = move-exception;
        r9 = r1;
        r4 = r9;
    L_0x007a:
        r2.printStackTrace();	 Catch:{ all -> 0x009a }
        if (r9 == 0) goto L_0x0082;
    L_0x007f:
        r9.close();	 Catch:{ IOException -> 0x0096 }
    L_0x0082:
        if (r4 == 0) goto L_0x0096;	 Catch:{ IOException -> 0x0096 }
    L_0x0084:
        r4.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x0096;
    L_0x0088:
        r2 = move-exception;
        r9 = r1;
        r4 = r9;
    L_0x008b:
        r2.printStackTrace();	 Catch:{ all -> 0x009a }
        if (r9 == 0) goto L_0x0093;
    L_0x0090:
        r9.close();	 Catch:{ IOException -> 0x0096 }
    L_0x0093:
        if (r4 == 0) goto L_0x0096;
    L_0x0095:
        goto L_0x0084;
    L_0x0096:
        if (r0 == 0) goto L_0x0099;
    L_0x0098:
        return r1;
    L_0x0099:
        return r3;
    L_0x009a:
        r0 = move-exception;
        r1 = r4;
    L_0x009c:
        if (r9 == 0) goto L_0x00a1;
    L_0x009e:
        r9.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x00a1:
        if (r1 == 0) goto L_0x00a6;	 Catch:{ IOException -> 0x00a6 }
    L_0x00a3:
        r1.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x00a6:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.vod.subtitle.g.b(android.net.Uri):java.io.File");
    }

    static /* synthetic */ void a(g gVar, SubtitleManifest subtitleManifest) {
        if (subtitleManifest != null) {
            if (subtitleManifest.getListCount() > 0) {
                gVar.j = subtitleManifest;
                if (subtitleManifest != null) {
                    if (subtitleManifest.getListCount() > 0) {
                        int listCount = subtitleManifest.getListCount();
                        List subtitleList = subtitleManifest.getSubtitleList();
                        int i = 0;
                        for (listCount--; listCount >= 0; listCount--) {
                            if (!a(((SubtitleInfo) subtitleList.get(listCount)).getFileExtension())) {
                                subtitleList.remove(listCount);
                                i++;
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder("excluded ");
                        stringBuilder.append(i);
                        stringBuilder.append(" unsupported files");
                    }
                }
                subtitleManifest.preProcessSubTitleInfo(new n(gVar));
                if (gVar.h != null) {
                    gVar.d.post(new o(gVar, subtitleManifest));
                }
            }
        }
    }
}
