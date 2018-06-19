package com.xunlei.downloadprovider.ad.c.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.c.a.b;
import com.xunlei.downloadprovider.ad.c.a.g;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.b.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.b.j;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReportNotDownloadTask */
public class i extends g implements b {
    private static final String a = "i";
    private static final long b = TimeUnit.DAYS.toMillis((long) (new Random(LoginHelper.a().g.c()).nextInt(31) + 30));
    private static final long c = TimeUnit.DAYS.toMillis(1);

    public final void a() {
        f.d();
        new StringBuilder("CYCLE_LENGTH：").append(b);
        LoginHelper.a();
        if (l.c()) {
            c cVar;
            String str;
            com.xunlei.downloadprovider.personal.message.chat.c jVar;
            JSONObject jSONObject;
            switch (h.a().e()) {
                case 0:
                    g();
                    break;
                case 1:
                case 2:
                    g();
                    if (h.a().e() != 4) {
                        cVar = new c();
                        str = d.a().t.a;
                        jVar = new j(this);
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put(SocializeConstants.TENCENT_UID, LoginHelper.a().g.c());
                            jSONObject.put("place", str);
                            XLThreadPool.execute(new com.xunlei.downloadprovider.personal.message.chat.personalchat.b.g(cVar, jSONObject, jVar));
                            break;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            jVar.a(com.xunlei.downloadprovider.personal.message.chat.b.a(-1000, "build body fail"));
                            break;
                        }
                    }
                    break;
                case 3:
                    cVar = new c();
                    str = d.a().t.a;
                    jVar = new k(this);
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put(SocializeConstants.TENCENT_UID, LoginHelper.a().g.c());
                        jSONObject.put("place", str);
                        XLThreadPool.execute(new j(cVar, jSONObject, jVar));
                        break;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        jVar.a(com.xunlei.downloadprovider.personal.message.chat.b.a(-1000, "build body fail"));
                        break;
                    }
                default:
                    return;
            }
            c();
        }
    }

    protected final long b() {
        SharedPreferences sharedPreferences = h.a().a;
        StringBuilder stringBuilder = new StringBuilder("key_report_not_download_time");
        stringBuilder.append(LoginHelper.a().g.c());
        return sharedPreferences.getLong(stringBuilder.toString(), 0);
    }

    protected final void c() {
        new StringBuilder("recordLatelyExecuteTime currentTime: ").append(System.currentTimeMillis());
        h a = h.a();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = a.a.edit();
        StringBuilder stringBuilder = new StringBuilder("key_report_not_download_time");
        stringBuilder.append(LoginHelper.a().g.c());
        edit.putLong(stringBuilder.toString(), currentTimeMillis).apply();
    }

    protected final long d() {
        int e = h.a().e();
        if (e != 2) {
            if (e != 3) {
                return b;
            }
        }
        return c;
    }

    private static void g() {
        if (com.xunlei.downloadprovider.h.f.b(BrothersApplication.getApplicationInstance(), "created_download_task", false)) {
            h.a().a(4);
        } else {
            h.a().a(1);
        }
    }
}
