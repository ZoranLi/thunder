package com.xunlei.downloadprovider.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.a.j;
import com.xunlei.downloadprovider.d.b.o;
import com.xunlei.downloadprovider.homepage.p;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RedPointCloudConfigure */
public class i extends j {
    private static final String b = "i";
    private static i c;
    public ArrayList<o> a;
    private ArrayList<a> d = new ArrayList();

    /* compiled from: RedPointCloudConfigure */
    public interface a {
        void a(i iVar);
    }

    private i() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/configuration/android/discover_tab?timestamp=");
        stringBuilder.append(System.currentTimeMillis());
        super("red_points.json", stringBuilder.toString());
    }

    public static i a() {
        if (c == null) {
            synchronized (i.class) {
                if (c == null) {
                    c = new i();
                }
            }
        }
        return c;
    }

    protected final void a(boolean z, JSONObject jSONObject) {
        ArrayList arrayList;
        i iVar = this;
        JSONObject jSONObject2 = jSONObject;
        super.a(z, jSONObject);
        long j = 0;
        SharedPreferences sharedPreferences;
        if (jSONObject2 != null) {
            try {
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject2.getJSONArray("redpoints");
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    int i = 0;
                    while (i < length) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
                        o oVar = new o();
                        if (oVar.w == null) {
                            oVar.w = new ArrayList();
                        }
                        if (!d.a(oVar.w)) {
                            oVar.w.clear();
                        }
                        String string = jSONObject3.getString("bus_name");
                        oVar.a = string;
                        oVar.B = jSONObject3.optInt("bus_id", 0);
                        oVar.b = jSONObject3.optString("icon");
                        oVar.c = jSONObject3.optString("cof_text");
                        oVar.d = jSONObject3.optString("pic_url");
                        oVar.e = jSONObject3.optString("jump_url");
                        oVar.f = jSONObject3.optString("jump_key");
                        oVar.g = jSONObject3.optString("game_jump_url", "http://mou.niu.xunlei.com/scoremall/gamecenter/index.html?from=download_in");
                        if (oVar.g.trim().equals("")) {
                            oVar.g = "http://mou.niu.xunlei.com/scoremall/gamecenter/index.html?from=download_in";
                        }
                        oVar.j = jSONObject3.optString("download_center_game_entry_name", "游戏中心");
                        oVar.o = jSONObject3.getString("start_time");
                        oVar.p = jSONObject3.getString("end_time");
                        oVar.h = jSONObject3.optString("game_start_time");
                        oVar.i = jSONObject3.optString("game_end_time");
                        oVar.q = jSONObject3.optString(c.e);
                        oVar.r = jSONObject3.optInt("display");
                        oVar.k = jSONObject3.optInt("game_display");
                        oVar.s = jSONObject3.optInt("level");
                        oVar.t = jSONObject3.optInt("phase");
                        oVar.u = jSONObject3.optInt("status");
                        oVar.v = jSONObject3.optInt("red_point", -1);
                        a();
                        oVar.z = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0).getLong(String.valueOf(oVar.B), j);
                        a();
                        oVar.n = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0).getLong("dlgamecenter", j);
                        oVar.x = DateUtil.getMillFromDate_yyyy_MM_dd_HH_mm_ss(oVar.o);
                        oVar.y = DateUtil.getMillFromDate_yyyy_MM_dd_HH_mm_ss(oVar.p);
                        oVar.l = DateUtil.getMillFromDate_yyyy_MM_dd_HH_mm_ss(oVar.h);
                        oVar.m = DateUtil.getMillFromDate_yyyy_MM_dd_HH_mm_ss(oVar.i);
                        oVar.A = jSONObject3.optInt(Impl.COLUMN_GROUP_ID, 0);
                        oVar.C = jSONObject3.optString("content_pic_url");
                        oVar.D = jSONObject3.optString("content_skip_url");
                        oVar.E = jSONObject3.optString("content_skip_page_title");
                        if (!("0x10810179".equals(AndroidConfig.getPartnerId()) && (string.equals("game_center") || string.equals("e_commerce")))) {
                            if (string.equals("local_service") || string.equals("game_center")) {
                                JSONArray optJSONArray;
                                if (string.equals("game_center")) {
                                    optJSONArray = jSONObject3.optJSONArray("game_center_sub_list");
                                } else {
                                    optJSONArray = jSONObject3.optJSONArray("local_service_sub_list");
                                }
                                if (optJSONArray != null) {
                                    int length2 = optJSONArray.length();
                                    for (int i2 = 0; i2 < length2; i2++) {
                                        JSONObject jSONObject4 = (JSONObject) optJSONArray.get(i2);
                                        if (jSONObject4 != null) {
                                            com.xunlei.downloadprovider.d.b.o.a aVar = new com.xunlei.downloadprovider.d.b.o.a();
                                            aVar.a = jSONObject4.optString("sub_name");
                                            aVar.b = jSONObject4.optString("sub_icon_pic_url");
                                            aVar.c = jSONObject4.optString("sub_jump_title");
                                            aVar.d = jSONObject4.optString("sub_jump_url");
                                            aVar.e = oVar;
                                            oVar.w.add(aVar);
                                        }
                                    }
                                }
                            }
                            if (string.equals("e_commerce")) {
                                oVar.A = Integer.MAX_VALUE;
                            }
                            a();
                            String str = oVar.a;
                            int i3 = oVar.B;
                            if (!TextUtils.isEmpty(str) && i3 > 0) {
                                SharedPreferences sharedPreferences2 = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0);
                                if (sharedPreferences2 != null) {
                                    int i4 = sharedPreferences2.getInt(str, 0);
                                    StringBuilder stringBuilder = new StringBuilder("saveBusIdByName: busName --> ");
                                    stringBuilder.append(str);
                                    stringBuilder.append(", busId --> ");
                                    stringBuilder.append(i3);
                                    stringBuilder.append(", savedBusId --> ");
                                    stringBuilder.append(i4);
                                    stringBuilder.append(", ");
                                    stringBuilder.append(str);
                                    stringBuilder.append(" is exits --> ");
                                    stringBuilder.append(sharedPreferences2.contains(str));
                                    if (!sharedPreferences2.contains(str)) {
                                        sharedPreferences2.edit().putInt(str, i3).apply();
                                    } else if (i4 > 0 && i4 != i3) {
                                        sharedPreferences2.edit().remove(String.valueOf(i4)).apply();
                                        sharedPreferences2.edit().putInt(str, i3).apply();
                                    }
                                }
                            }
                            arrayList2.add(oVar);
                        }
                        i++;
                        j = 0;
                    }
                }
                arrayList = arrayList2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    iVar.a = arrayList;
                    if (!DateUtil.isTheSameDay(BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0).getLong("report_red_point_status_time", 0), System.currentTimeMillis()) && b()) {
                        StatEvent build = HubbleEventBuilder.build(p.a, p.b);
                        a(build, "choiceness", "top_collect");
                        a(build, "classify", "top_class");
                        a(build, "short_movie", "top_video");
                        a(build, "fun_pic", "top_fun");
                        a(build, "recommend", "foot_home");
                        a(build, "search", "foot_search");
                        a(build, "find", "foot_find");
                        a(build, "user_center", "foot_personal");
                        p.a(build);
                        sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong("report_red_point_status_time", System.currentTimeMillis()).apply();
                        }
                    }
                    e();
                    return;
                }
            }
            if (!z) {
                e();
            }
        }
        arrayList = null;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                iVar.a = arrayList;
                StatEvent build2 = HubbleEventBuilder.build(p.a, p.b);
                a(build2, "choiceness", "top_collect");
                a(build2, "classify", "top_class");
                a(build2, "short_movie", "top_video");
                a(build2, "fun_pic", "top_fun");
                a(build2, "recommend", "foot_home");
                a(build2, "search", "foot_search");
                a(build2, "find", "foot_find");
                a(build2, "user_center", "foot_personal");
                p.a(build2);
                sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("report_red_point_status_time", System.currentTimeMillis()).apply();
                }
                e();
                return;
            }
        }
        if (z) {
            e();
        }
    }

    private void e() {
        a(new j(this));
    }

    public final void a(a aVar) {
        if (aVar != null && !this.d.contains(aVar)) {
            this.d.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null && !d.a(this.d) && this.d.contains(aVar)) {
            this.d.remove(aVar);
        }
    }

    public final boolean b() {
        return !d.a(this.a);
    }

    public final o d(String str) {
        if (!TextUtils.isEmpty(str) && b()) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                o oVar = (o) it.next();
                if (oVar != null && !TextUtils.isEmpty(oVar.a) && oVar.a.equals(str)) {
                    return oVar;
                }
            }
        }
        return null;
    }

    public final void a(long j, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (b()) {
                str = d(str);
                if (str != null && j <= str.y) {
                    if (j >= str.x) {
                        str.z = j;
                        SharedPreferences sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong(String.valueOf(str.B), j).apply();
                        }
                    }
                }
            }
        }
    }

    public static boolean c() {
        return BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0).getBoolean("defdlgamecenterdone", false);
    }

    public static void d() {
        SharedPreferences sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(String.valueOf("defdlgamecenterdone"), true).apply();
        }
    }

    public final boolean e(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (b()) {
                str = d(str);
                if (str == null || str.a() == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private void a(StatEvent statEvent, String str, String str2) {
        statEvent.add(str2, d(str) != null ? "point" : "0");
    }
}
