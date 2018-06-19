package com.qiniu.android.c;

import com.qiniu.android.d.d;
import com.qiniu.android.d.e;
import com.qiniu.android.d.f;
import com.qiniu.android.d.g;
import com.qiniu.android.http.a;
import com.qiniu.android.http.h;
import com.qiniu.android.http.i;
import com.qiniu.android.http.l;
import com.qiniu.android.http.o;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.DownloadManager;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import okhttp3.aa;
import okhttp3.af;
import okhttp3.ag;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResumeUploader */
final class k implements Runnable {
    private final long a;
    private final String b;
    private final q c;
    private final x d;
    private final a e;
    private final a f;
    private final byte[] g;
    private final String[] h;
    private final e i;
    private final long j;
    private final String k;
    private RandomAccessFile l = null;
    private File m;
    private long n;
    private s o;

    k(a aVar, a aVar2, File file, String str, s sVar, q qVar, x xVar, String str2) {
        this.e = aVar;
        this.f = aVar2;
        this.m = file;
        this.k = str2;
        this.a = file.length();
        this.b = str;
        str2 = new StringBuilder("UpToken ");
        str2.append(sVar.b);
        this.i = new e().a("Authorization", str2.toString());
        this.c = new l(this, qVar);
        if (xVar == null) {
            xVar = x.a();
        }
        this.d = xVar;
        this.g = new byte[aVar2.d];
        this.h = new String[((int) (((this.a + DownloadManager.MAX_BYTES_OVER_MOBILE) - 1) / DownloadManager.MAX_BYTES_OVER_MOBILE))];
        this.j = file.lastModified();
        this.o = sVar;
    }

    private static boolean a(org.json.JSONObject r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "ctx";	 Catch:{ Exception -> 0x000c }
        r1.getString(r0);	 Catch:{ Exception -> 0x000c }
        r0 = "crc32";	 Catch:{ Exception -> 0x000c }
        r1.getLong(r0);	 Catch:{ Exception -> 0x000c }
        r1 = 1;
        return r1;
    L_0x000c:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.c.k.a(org.json.JSONObject):boolean");
    }

    public final void run() {
        long a = a();
        try {
            this.l = new RandomAccessFile(this.m, "r");
            a(a, 0, this.f.k.a(this.o.b, this.f.l, null));
        } catch (Exception e) {
            e.printStackTrace();
            this.c.a(this.b, o.a(e, this.o), null);
        }
    }

    private void a(String str, byte[] bArr, int i, l lVar, h hVar, p pVar) {
        ag a;
        ag agVar;
        byte[] bArr2 = bArr;
        a aVar = this.e;
        e eVar = this.i;
        s sVar = this.o;
        long j = this.a;
        String a2 = aVar.a != null ? aVar.a.a() : str;
        if (bArr2 == null || bArr2.length <= 0) {
            a = ag.a(null, new byte[0], 0);
        } else {
            aa a3 = aa.a("application/octet-stream");
            if (eVar != null) {
                Object obj = eVar.a.get("Content-Type");
                if (obj != null) {
                    a3 = aa.a(obj.toString());
                }
            }
            a = ag.a(a3, bArr2, i);
        }
        ag agVar2 = a;
        if (lVar == null) {
            if (pVar == null) {
                agVar = agVar2;
                aVar.a(new af.a().a(a2).a("POST", agVar), eVar, sVar, j, hVar);
            }
        }
        ag iVar = new i(agVar2, lVar, j, pVar);
        aVar.a(new af.a().a(a2).a("POST", agVar), eVar, sVar, j, hVar);
    }

    private void a(long j, int i, String str) {
        long j2 = j;
        if (j2 == this.a) {
            m mVar = new m(r8, i, str, j2);
            p pVar = r8.d.e;
            String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", new Object[]{g.a(r8.d.b), g.a(r8.m.getName())});
            String str2 = "";
            if (r8.b != null) {
                str2 = String.format("/key/%s", new Object[]{g.a(r8.b)});
            }
            String str3 = "";
            if (r8.d.a.size() != 0) {
                String[] strArr = new String[r8.d.a.size()];
                Iterator it = r8.d.a.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    int i3 = i2 + 1;
                    Iterator it2 = it;
                    strArr[i2] = String.format(Locale.ENGLISH, "%s/%s", new Object[]{entry.getKey(), g.a((String) entry.getValue())});
                    i2 = i3;
                    it = it2;
                }
                StringBuilder stringBuilder = new StringBuilder("/");
                stringBuilder.append(f.a(strArr, "/"));
                str3 = stringBuilder.toString();
            }
            str2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", new Object[]{Long.valueOf(r8.a), format, str2, str3});
            byte[] bytes = f.a(r8.h, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
            a(String.format("%s%s", new Object[]{str, str2}), bytes, bytes.length, null, mVar, pVar);
            return;
        }
        long j3 = r8.a - j2;
        if (j3 >= ((long) r8.f.d)) {
            j3 = (long) r8.f.d;
        }
        int i4 = (int) j3;
        n nVar = new n(r8, j2);
        o oVar = new o(r8, str, i, j2, i4);
        long j4 = DownloadManager.MAX_BYTES_OVER_MOBILE;
        j3 = j2 % DownloadManager.MAX_BYTES_OVER_MOBILE;
        p pVar2;
        if (j3 == 0) {
            long j5 = r8.a - j2;
            if (j5 < DownloadManager.MAX_BYTES_OVER_MOBILE) {
                j4 = j5;
            }
            int i5 = (int) j4;
            pVar2 = r8.d.e;
            format = String.format(Locale.ENGLISH, "/mkblk/%d", new Object[]{Integer.valueOf(i5)});
            try {
                r8.l.seek(j2);
                r8.l.read(r8.g, 0, i4);
                r8.n = d.a(r8.g, i4);
                a(String.format("%s%s", new Object[]{str, format}), r8.g, i4, nVar, oVar, pVar2);
                return;
            } catch (Exception e) {
                r8.c.a(r8.b, o.a(e, r8.o), null);
                return;
            }
        }
        Object obj = r8.h[(int) (j2 / DownloadManager.MAX_BYTES_OVER_MOBILE)];
        pVar2 = r8.d.e;
        int i6 = (int) j3;
        format = String.format(Locale.ENGLISH, "/bput/%s/%d", new Object[]{obj, Integer.valueOf(i6)});
        try {
            r8.l.seek(j2);
            r8.l.read(r8.g, 0, i4);
            r8.n = d.a(r8.g, i4);
            a(String.format("%s%s", new Object[]{str, format}), r8.g, i4, nVar, oVar, pVar2);
        } catch (Exception e2) {
            r8.c.a(r8.b, o.a(e2, r8.o), null);
        }
    }

    private long a() {
        if (this.f.a == null) {
            return 0;
        }
        byte[] a = this.f.a.a(this.k);
        if (a == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(a));
            long optLong = jSONObject.optLong("offset", 0);
            long optLong2 = jSONObject.optLong("modify_time", 0);
            long optLong3 = jSONObject.optLong("size", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong != 0 && optLong2 == this.j && optLong3 == this.a && optJSONArray != null) {
                if (optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.h[i] = optJSONArray.optString(i);
                    }
                    return optLong;
                }
            }
            return 0;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    static /* synthetic */ void e(k kVar) {
        if (kVar.f.a != null) {
            kVar.f.a.b(kVar.k);
        }
    }

    static /* synthetic */ boolean a(o oVar, JSONObject jSONObject) {
        return (oVar.a == 200 && oVar.e == null && (oVar.e() != null || a(jSONObject) != null)) ? true : null;
    }

    static /* synthetic */ boolean b(o oVar, JSONObject jSONObject) {
        return (oVar.a >= 500 || oVar.a < 200 || oVar.e() != null || a(jSONObject) != null) ? null : true;
    }

    static /* synthetic */ void a(k kVar, long j) {
        if (kVar.f.a != null) {
            if (j != 0) {
                Locale locale = Locale.ENGLISH;
                String str = "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}";
                r2 = new Object[4];
                int i = 0;
                r2[0] = Long.valueOf(kVar.a);
                r2[1] = Long.valueOf(j);
                r2[2] = Long.valueOf(kVar.j);
                j = kVar.h;
                int length = j.length;
                StringBuilder stringBuilder = new StringBuilder((j[0].length() + 3) * length);
                while (i < length) {
                    if (i > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append('\"');
                    stringBuilder.append(j[i]);
                    stringBuilder.append('\"');
                    i++;
                }
                r2[3] = stringBuilder.toString();
                kVar.f.a.a(kVar.k, String.format(locale, str, r2).getBytes());
            }
        }
    }
}
