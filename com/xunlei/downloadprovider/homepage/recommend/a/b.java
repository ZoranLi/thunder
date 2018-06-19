package com.xunlei.downloadprovider.homepage.recommend.a;

import android.text.TextUtils;
import com.android.volley.n.a;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.per.model.d;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CounterNetWorkHelper */
public final class b extends e {
    public static void a(int i, String str, com.android.volley.n.b<JSONObject> bVar, a aVar) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/counter/fetch_like_video_user");
        stringBuilder.append("?video_id=");
        stringBuilder.append(str);
        stringBuilder.append("&page_size=3");
        if (!TextUtils.isEmpty(null)) {
            stringBuilder.append("&start_key=");
            stringBuilder.append(null);
        }
        if (i != -1) {
            stringBuilder.append("&res_type=");
            stringBuilder.append(i);
        }
        new StringBuilder("getLikeUsersForVideo url=").append(stringBuilder);
        XLThreadPool.execute(new o(stringBuilder, bVar, aVar));
    }

    public static void a(String str, String str2, com.android.volley.n.b<List<w>> bVar, a aVar) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/counter/fetch_user_like_video");
        stringBuilder.append("?user_id=");
        stringBuilder.append(str);
        stringBuilder.append("&page_size=20");
        if (TextUtils.isEmpty(str2) == null) {
            stringBuilder.append("&start_key=");
            stringBuilder.append(str2);
        }
        new StringBuilder("getLikeVideosForUser url=").append(stringBuilder);
        XLThreadPool.execute(new p(stringBuilder, bVar, aVar));
    }

    private static List<w> c(JSONObject jSONObject) {
        String optString = jSONObject.optString("result");
        if (optString != null) {
            if (optString.contentEquals(ITagManager.SUCCESS)) {
                List<w> arrayList = new ArrayList(20);
                jSONObject = jSONObject.optJSONArray("data");
                if (jSONObject != null && jSONObject.length() > 0) {
                    int length = jSONObject.length();
                    int i = 0;
                    while (i < length) {
                        try {
                            arrayList.add(w.a(jSONObject.optJSONObject(i)));
                            i++;
                        } catch (JSONObject jSONObject2) {
                            new StringBuilder("like video response=>").append(jSONObject2.getMessage());
                            arrayList = null;
                        }
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    public static void a(int i, e$d<Boolean, List<d>> com_xunlei_downloadprovider_member_payment_a_e_d_java_lang_Boolean__java_util_List_com_xunlei_downloadprovider_publiser_per_model_d) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/counter/fetch_user_like");
        stringBuilder.append("?res_type=8&page_size=20");
        stringBuilder.append("&cursor=");
        stringBuilder.append(i);
        new StringBuilder("getLikeVideosForUser url=").append(stringBuilder);
        XLThreadPool.execute(new s(stringBuilder, com_xunlei_downloadprovider_member_payment_a_e_d_java_lang_Boolean__java_util_List_com_xunlei_downloadprovider_publiser_per_model_d));
    }

    private static List<d> d(JSONObject jSONObject) {
        List<d> arrayList = new ArrayList(20);
        jSONObject = jSONObject.optJSONArray("data");
        if (jSONObject == null || jSONObject.length() <= 0) {
            return arrayList;
        }
        int length = jSONObject.length();
        int i = 0;
        while (i < length) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(i);
                Object dVar = new d();
                if (optJSONObject != null) {
                    dVar.a = optJSONObject.optLong("praise_time") * 1000;
                    dVar.d = optJSONObject.optInt("cursor");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("cinecism_info");
                    if (optJSONObject2 != null) {
                        if (optJSONObject2.length() != 0) {
                            dVar.b = CinecismInfo.a(optJSONObject2);
                            if (dVar.b != null) {
                                optJSONObject = optJSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
                                if (optJSONObject != null) {
                                    if (optJSONObject.length() != 0) {
                                        dVar.c = VideoUserInfo.parseFrom(optJSONObject);
                                        arrayList.add(dVar);
                                        i++;
                                    }
                                }
                                throw new JSONException("Invalid json site_info");
                            }
                        }
                    }
                    throw new JSONException("Invalid json site_info");
                }
                dVar = null;
                arrayList.add(dVar);
                i++;
            } catch (JSONObject jSONObject2) {
                new StringBuilder("like video response=>").append(jSONObject2.getMessage());
                return null;
            }
        }
        return arrayList;
    }

    private static org.json.JSONObject b(java.lang.String r2, int r3, java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "res_id";	 Catch:{ JSONException -> 0x0019 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0019 }
        r2 = "res_type";	 Catch:{ JSONException -> 0x0019 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0019 }
        r2 = "gcid";	 Catch:{ JSONException -> 0x0019 }
        r0.put(r2, r4);	 Catch:{ JSONException -> 0x0019 }
        r2 = "peer_id";	 Catch:{ JSONException -> 0x0019 }
        r0.put(r2, r5);	 Catch:{ JSONException -> 0x0019 }
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.a.b.b(java.lang.String, int, java.lang.String, java.lang.String):org.json.JSONObject");
    }

    private static org.json.JSONObject b(java.lang.String r2, int r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "res_id";	 Catch:{ JSONException -> 0x001e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x001e }
        r2 = "res_type";	 Catch:{ JSONException -> 0x001e }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x001e }
        r2 = "gcid";	 Catch:{ JSONException -> 0x001e }
        r0.put(r2, r4);	 Catch:{ JSONException -> 0x001e }
        r2 = "peer_id";	 Catch:{ JSONException -> 0x001e }
        r0.put(r2, r5);	 Catch:{ JSONException -> 0x001e }
        r2 = "share_type";	 Catch:{ JSONException -> 0x001e }
        r0.put(r2, r6);	 Catch:{ JSONException -> 0x001e }
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.a.b.b(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):org.json.JSONObject");
    }

    private static org.json.JSONObject b(java.lang.String r2, int r3, java.lang.String r4, java.lang.String r5, int r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "res_id";	 Catch:{ JSONException -> 0x0023 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0023 }
        r2 = "res_type";	 Catch:{ JSONException -> 0x0023 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0023 }
        r2 = "gcid";	 Catch:{ JSONException -> 0x0023 }
        r0.put(r2, r4);	 Catch:{ JSONException -> 0x0023 }
        r2 = "peer_id";	 Catch:{ JSONException -> 0x0023 }
        r0.put(r2, r5);	 Catch:{ JSONException -> 0x0023 }
        r2 = "reason";	 Catch:{ JSONException -> 0x0023 }
        r0.put(r2, r6);	 Catch:{ JSONException -> 0x0023 }
        r2 = "memo";	 Catch:{ JSONException -> 0x0023 }
        r0.put(r2, r7);	 Catch:{ JSONException -> 0x0023 }
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.a.b.b(java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String):org.json.JSONObject");
    }

    private static org.json.JSONObject b(java.lang.String r2, int r3, java.lang.String r4, java.lang.String r5, int r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "res_id";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0037 }
        r2 = "res_type";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0037 }
        r2 = "gcid";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r4);	 Catch:{ JSONException -> 0x0037 }
        r2 = "peer_id";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r5);	 Catch:{ JSONException -> 0x0037 }
        r2 = "length";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r6);	 Catch:{ JSONException -> 0x0037 }
        r2 = "page_name";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r7);	 Catch:{ JSONException -> 0x0037 }
        r2 = "play_type";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r8);	 Catch:{ JSONException -> 0x0037 }
        r2 = "tag";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r9);	 Catch:{ JSONException -> 0x0037 }
        r2 = "play_time";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r10);	 Catch:{ JSONException -> 0x0037 }
        r2 = "res_from";	 Catch:{ JSONException -> 0x0037 }
        r0.put(r2, r11);	 Catch:{ JSONException -> 0x0037 }
    L_0x0037:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.a.b.b(java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String):org.json.JSONObject");
    }
}
