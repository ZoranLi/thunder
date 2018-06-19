package com.xunlei.downloadprovider.personal.a.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.personal.a.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UserGridModel */
public class h {
    public static int a = 0;
    private static final String n = "h";
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public int k;
    public String l;
    public String m;

    public static List<h> a(JSONArray jSONArray) {
        List<h> arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    Object optString = optJSONObject.optString("start_time");
                    String optString2 = optJSONObject.optString("end_time");
                    if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
                        arrayList.add(a(optJSONObject));
                    } else if (!TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
                        try {
                            if (System.currentTimeMillis() / 1000 >= Long.valueOf(optString).longValue()) {
                                arrayList.add(a(optJSONObject));
                            }
                        } catch (NumberFormatException e) {
                            e.toString();
                        }
                    } else if (!TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                        try {
                            long longValue = Long.valueOf(optString).longValue();
                            long longValue2 = Long.valueOf(optString2).longValue();
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            if (currentTimeMillis >= longValue && currentTimeMillis <= longValue2) {
                                arrayList.add(a(optJSONObject));
                            }
                        } catch (NumberFormatException e2) {
                            e2.toString();
                        }
                    } else {
                        try {
                            if (System.currentTimeMillis() / 1000 <= Long.valueOf(optString2).longValue()) {
                                arrayList.add(a(optJSONObject));
                            }
                        } catch (NumberFormatException e22) {
                            e22.toString();
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static h a(JSONObject jSONObject) {
        h hVar = new h();
        if (jSONObject != null) {
            String optString = jSONObject.optString("keyword");
            String optString2 = jSONObject.optString("icon_title");
            String optString3 = jSONObject.optString("icon_desc");
            String optString4 = jSONObject.optString("icon_url");
            String optString5 = jSONObject.optString("redirect_url");
            String optString6 = jSONObject.optString("redirect_client_key");
            String optString7 = jSONObject.optString("redirect_type");
            hVar.c = optString;
            hVar.d = optString2;
            hVar.e = optString3;
            hVar.f = optString4;
            hVar.g = optString5;
            hVar.h = optString6;
            hVar.i = optString7;
            if ("score_center".equals(optString)) {
                hVar.b = 2;
                new StringBuilder("userGridModel.getJumpUrl() = ").append(hVar.g);
                a.a = hVar.g;
            } else if ("dl_center".equals(optString)) {
                hVar.b = 3;
            } else {
                hVar.b = 1;
            }
            if ("help_feedback".equals(optString)) {
                a.b = hVar.g;
            }
            if ("share_packet".equals(optString)) {
                j.a = hVar.g;
                j.b = hVar.d;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("redot");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("enable");
                optString4 = optJSONObject.optString("start_time");
                optString2 = optJSONObject.optString("end_time");
                hVar.l = optString4;
                hVar.m = optString2;
                hVar.k = optInt;
                a a = a.a();
                StringBuilder stringBuilder = new StringBuilder("key_grid_red_point_start_time");
                stringBuilder.append(optString);
                optString5 = a.b(stringBuilder.toString(), "");
                StringBuilder stringBuilder2 = new StringBuilder("key_grid_red_point_end_time");
                stringBuilder2.append(optString);
                optString6 = a.b(stringBuilder2.toString(), "");
                if (!(TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2) || (optString4.equals(optString5) && optString2.equals(optString6)))) {
                    stringBuilder = new StringBuilder("key_grid_red_point_clicked");
                    stringBuilder.append(optString);
                    a.a(stringBuilder.toString(), 0);
                }
                stringBuilder = new StringBuilder("key_grid_red_point_start_time");
                stringBuilder.append(optString);
                a.a(stringBuilder.toString(), optString4);
                StringBuilder stringBuilder3 = new StringBuilder("key_grid_red_point_end_time");
                stringBuilder3.append(optString);
                a.a(stringBuilder3.toString(), optString2);
            }
            jSONObject = jSONObject.optJSONObject("over_write");
            if (jSONObject != null) {
                a.a.a(hVar, jSONObject);
            }
        }
        return hVar;
    }
}
