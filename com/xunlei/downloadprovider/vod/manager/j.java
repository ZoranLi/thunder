package com.xunlei.downloadprovider.vod.manager;

import com.qiniu.android.b.c;
import com.qiniu.android.c.q;
import com.qiniu.android.c.s;
import com.qiniu.android.c.t;
import com.qiniu.android.c.u;
import com.qiniu.android.c.x;
import com.qiniu.android.http.o;
import com.xunlei.downloadprovider.contentpublish.a.a;
import com.xunlei.downloadprovider.contentpublish.a.b;
import com.xunlei.downloadprovider.contentpublish.a.d;
import com.xunlei.downloadprovider.contentpublish.a.f;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e$b;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VideoPublishManager */
public class j extends e {
    private static final String b = "j";
    private static int c = 1;
    private static int d = 2;
    private static int f = 3;
    public c a = new c();

    static /* synthetic */ void a(j jVar, String str, String str2, long j, long j2, String str3, String str4, e$b com_xunlei_downloadprovider_member_payment_a_e_b) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gcid", str);
            jSONObject.put("path", str2);
            jSONObject.put("size", j);
            jSONObject.put("createTime", j2);
            jSONObject.put("title", str3);
            jSONObject.put("tag", str4);
            jSONArray.put(jSONObject);
            str = jSONArray.toString();
            str2 = new HashMap();
            str2.put("files", str);
            str2.put("uploadMethod", "jq");
            jVar.a.a("http://api.tw06.xlmc.sandai.net/api/file/commit", "1.2", str2, new n(jVar, com_xunlei_downloadprovider_member_payment_a_e_b));
        } catch (j jVar2) {
            jVar2.getMessage();
            if (com_xunlei_downloadprovider_member_payment_a_e_b != null) {
                new StringBuilder("commitUpload exception : ").append(jVar2.getMessage());
                com_xunlei_downloadprovider_member_payment_a_e_b.a(f);
            }
        }
    }

    static /* synthetic */ void a(String str, String str2, String str3, a aVar) {
        String str4;
        JSONObject jSONObject;
        o a;
        Object obj;
        String str5 = str2;
        String str6 = str3;
        a aVar2 = aVar;
        b bVar = new b(c.a);
        t tVar = bVar.a;
        q dVar = new d(bVar, aVar2);
        x xVar = new x("", true, new com.xunlei.downloadprovider.contentpublish.a.e(bVar, aVar2), new f(bVar, aVar2, str5));
        File file = new File(str);
        s a2 = s.a(str3);
        if (str6 != null) {
            if (!str6.equals("")) {
                str4 = null;
                if (str4 == null) {
                    jSONObject = null;
                    a = o.a(null, -4, "", "", "", "", "", "", 80, 0, 0, str4, a2, 0);
                } else {
                    jSONObject = null;
                    if (a2 != s.a) {
                        if (a2 == null) {
                            a = file.length() != 0 ? o.a(null, -6, "", "", "", "", "", "", 80, 0, 0, "file or data size is zero", a2, 0) : jSONObject;
                        }
                    }
                    a = o.a("invalid token");
                }
                if (a == null) {
                    dVar.a(str5, a, jSONObject);
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    tVar.a.k.a(str6, new u(tVar, file, str5, a2, dVar, xVar));
                }
            }
        }
        str4 = "no token";
        if (str4 == null) {
            jSONObject = null;
            if (a2 != s.a) {
                if (a2 == null) {
                    if (file.length() != 0) {
                    }
                }
            }
            a = o.a("invalid token");
        } else {
            jSONObject = null;
            a = o.a(null, -4, "", "", "", "", "", "", 80, 0, 0, str4, a2, 0);
        }
        if (a == null) {
            obj = null;
        } else {
            dVar.a(str5, a, jSONObject);
            obj = 1;
        }
        if (obj == null) {
            tVar.a.k.a(str6, new u(tVar, file, str5, a2, dVar, xVar));
        }
    }
}
