package com.xunlei.downloadprovider.homepage.youliao.data;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.youliao.YouliaoVideoFragment;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.xllib.android.b;

/* compiled from: YouliaoNetDataSource */
public final class d extends e {
    public int a = 1;
    public boolean b = false;
    private a c = new a();

    d() {
    }

    public static String a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?size=20&page=");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.homepage.youliao.data.d r16, org.json.JSONObject r17, com.xunlei.downloadprovider.search.b.b r18, boolean r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r17;
        r1 = 1;
        if (r0 != 0) goto L_0x000e;
    L_0x0005:
        r0 = new com.xunlei.downloadprovider.homepage.youliao.data.c;	 Catch:{ JSONException -> 0x01c8 }
        r0.<init>();	 Catch:{ JSONException -> 0x01c8 }
        r0.d = r1;	 Catch:{ JSONException -> 0x01c8 }
        goto L_0x01cf;	 Catch:{ JSONException -> 0x01c8 }
    L_0x000e:
        r2 = new com.xunlei.downloadprovider.homepage.youliao.data.c;	 Catch:{ JSONException -> 0x01c8 }
        r2.<init>();	 Catch:{ JSONException -> 0x01c8 }
        r3 = "result";	 Catch:{ JSONException -> 0x01c8 }
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01c8 }
        r2.a = r3;	 Catch:{ JSONException -> 0x01c8 }
        r3 = "card_list";	 Catch:{ JSONException -> 0x01c8 }
        r3 = r0.optJSONArray(r3);	 Catch:{ JSONException -> 0x01c8 }
        r4 = 0;	 Catch:{ JSONException -> 0x01c8 }
        if (r3 == 0) goto L_0x01a6;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0024:
        r5 = r3.length();	 Catch:{ JSONException -> 0x01c8 }
        if (r5 <= 0) goto L_0x01a6;	 Catch:{ JSONException -> 0x01c8 }
    L_0x002a:
        r5 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x01c8 }
        r5.<init>();	 Catch:{ JSONException -> 0x01c8 }
        r6 = r4;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0030:
        r7 = r3.length();	 Catch:{ JSONException -> 0x01c8 }
        if (r6 >= r7) goto L_0x01a4;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0036:
        r7 = r3.getJSONObject(r6);	 Catch:{ JSONException -> 0x01c8 }
        r8 = new com.xunlei.downloadprovider.homepage.youliao.data.YouliaoVideo;	 Catch:{ JSONException -> 0x01c8 }
        r8.<init>();	 Catch:{ JSONException -> 0x01c8 }
        r9 = "ext_data";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x01c8 }
        r8.setServerParams(r9);	 Catch:{ JSONException -> 0x01c8 }
        r9 = "res_from";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x01c8 }
        r8.setServerResFrom(r9);	 Catch:{ JSONException -> 0x01c8 }
        r9 = "res_id";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x01c8 }
        r8.setVideoId(r9);	 Catch:{ JSONException -> 0x01c8 }
        r9 = "res_info";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r7.getJSONObject(r9);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "comment_count";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optInt(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setCommentCount(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "dynamic_url";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optString(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setDynamicPosterUrl(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "cover_url";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optString(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setPosterUrl(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "duration";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optInt(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setDuration(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = r8.getLikeInfo();	 Catch:{ JSONException -> 0x01c8 }
        r11 = "fav_count";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optInt(r11);	 Catch:{ JSONException -> 0x01c8 }
        r10.setLikeCount(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = "have_fav";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optBoolean(r11);	 Catch:{ JSONException -> 0x01c8 }
        r10.setLiked(r11);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "gcid";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optString(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setGcid(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "play_count";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optInt(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setPlayCount(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "play_url";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optString(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setPlayUrl(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "poster_height";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optInt(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setPosterHeight(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "poster_width";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optInt(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setPosterWidth(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "share_count";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optInt(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setShareCount(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = "title";	 Catch:{ JSONException -> 0x01c8 }
        r10 = r9.optString(r10);	 Catch:{ JSONException -> 0x01c8 }
        r8.setTitle(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x01c8 }
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ JSONException -> 0x01c8 }
        r10 = r10 / r12;	 Catch:{ JSONException -> 0x01c8 }
        r12 = "upline_time";	 Catch:{ JSONException -> 0x01c8 }
        r12 = r9.optLong(r12);	 Catch:{ JSONException -> 0x01c8 }
        r14 = r10 - r12;	 Catch:{ JSONException -> 0x01c8 }
        r10 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;	 Catch:{ JSONException -> 0x01c8 }
        r12 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));	 Catch:{ JSONException -> 0x01c8 }
        if (r12 >= 0) goto L_0x00f4;	 Catch:{ JSONException -> 0x01c8 }
    L_0x00ef:
        r10 = "new";	 Catch:{ JSONException -> 0x01c8 }
        r8.setRecommendTag(r10);	 Catch:{ JSONException -> 0x01c8 }
    L_0x00f4:
        r10 = "user_info";	 Catch:{ JSONException -> 0x01c8 }
        r7 = r7.getJSONObject(r10);	 Catch:{ JSONException -> 0x01c8 }
        r10 = r8.getPublisherInfo();	 Catch:{ JSONException -> 0x01c8 }
        r11 = "kind";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r7.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r10.setUserKind(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = "nick_name";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r7.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r10.setPublisherName(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = "uid";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r7.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r10.setPublisherId(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = "portrait_url";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r7.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r10.setAvatarUrl(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = "location_info";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r9.getJSONObject(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.length();	 Catch:{ JSONException -> 0x01c8 }
        if (r11 <= 0) goto L_0x0185;	 Catch:{ JSONException -> 0x01c8 }
    L_0x012e:
        r11 = "lat";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optDouble(r11);	 Catch:{ JSONException -> 0x01c8 }
        r8.setVideoLatitude(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = "lng";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optDouble(r11);	 Catch:{ JSONException -> 0x01c8 }
        r8.setVideoLongitude(r11);	 Catch:{ JSONException -> 0x01c8 }
        r11 = "location_name";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        if (r11 == 0) goto L_0x0160;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0148:
        r11 = "location_name";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r12 = "null";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r11.equals(r12);	 Catch:{ JSONException -> 0x01c8 }
        if (r11 != 0) goto L_0x0160;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0156:
        r11 = "location_name";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r9.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r8.setVideoAddress(r9);	 Catch:{ JSONException -> 0x01c8 }
        goto L_0x0185;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0160:
        r11 = "city_name";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        if (r11 == 0) goto L_0x0180;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0168:
        r11 = "city_name";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r9.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r12 = "null";	 Catch:{ JSONException -> 0x01c8 }
        r11 = r11.equals(r12);	 Catch:{ JSONException -> 0x01c8 }
        if (r11 != 0) goto L_0x0180;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0176:
        r11 = "city_name";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r9.optString(r11);	 Catch:{ JSONException -> 0x01c8 }
        r8.setVideoAddress(r9);	 Catch:{ JSONException -> 0x01c8 }
        goto L_0x0185;	 Catch:{ JSONException -> 0x01c8 }
    L_0x0180:
        r9 = "";	 Catch:{ JSONException -> 0x01c8 }
        r8.setVideoAddress(r9);	 Catch:{ JSONException -> 0x01c8 }
    L_0x0185:
        r9 = "pub_extra";	 Catch:{ JSONException -> 0x01c8 }
        r7 = r7.getJSONObject(r9);	 Catch:{ JSONException -> 0x01c8 }
        r9 = "v_url";	 Catch:{ JSONException -> 0x01c8 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x01c8 }
        r10.setVUrl(r9);	 Catch:{ JSONException -> 0x01c8 }
        r9 = "v_status";	 Catch:{ JSONException -> 0x01c8 }
        r7 = r7.optInt(r9, r4);	 Catch:{ JSONException -> 0x01c8 }
        r10.setVStatus(r7);	 Catch:{ JSONException -> 0x01c8 }
        r5.add(r8);	 Catch:{ JSONException -> 0x01c8 }
        r6 = r6 + 1;	 Catch:{ JSONException -> 0x01c8 }
        goto L_0x0030;	 Catch:{ JSONException -> 0x01c8 }
    L_0x01a4:
        r2.b = r5;	 Catch:{ JSONException -> 0x01c8 }
    L_0x01a6:
        r3 = r2.a;	 Catch:{ JSONException -> 0x01c8 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ JSONException -> 0x01c8 }
        if (r3 == 0) goto L_0x01af;	 Catch:{ JSONException -> 0x01c8 }
    L_0x01ae:
        goto L_0x01b7;	 Catch:{ JSONException -> 0x01c8 }
    L_0x01af:
        r3 = "ok";	 Catch:{ JSONException -> 0x01c8 }
        r4 = r2.a;	 Catch:{ JSONException -> 0x01c8 }
        r4 = r3.endsWith(r4);	 Catch:{ JSONException -> 0x01c8 }
    L_0x01b7:
        if (r4 == 0) goto L_0x01d0;	 Catch:{ JSONException -> 0x01c8 }
    L_0x01b9:
        if (r19 != 0) goto L_0x01d0;	 Catch:{ JSONException -> 0x01c8 }
    L_0x01bb:
        r3 = r16;	 Catch:{ JSONException -> 0x01c8 }
        r3 = r3.c;	 Catch:{ JSONException -> 0x01c8 }
        r4 = new com.xunlei.downloadprovider.homepage.youliao.data.b;	 Catch:{ JSONException -> 0x01c8 }
        r4.<init>(r3, r0);	 Catch:{ JSONException -> 0x01c8 }
        com.xunlei.common.concurrent.XLThreadPool.execute(r4);	 Catch:{ JSONException -> 0x01c8 }
        goto L_0x01d0;
    L_0x01c8:
        r0 = new com.xunlei.downloadprovider.homepage.youliao.data.c;
        r0.<init>();
        r0.d = r1;
    L_0x01cf:
        r2 = r0;
    L_0x01d0:
        r0 = r18;
        r0.a(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.youliao.data.d.a(com.xunlei.downloadprovider.homepage.youliao.data.d, org.json.JSONObject, com.xunlei.downloadprovider.search.b.b, boolean):void");
    }

    static /* synthetic */ String a() {
        if (YouliaoVideoFragment.a == -1.0d || YouliaoVideoFragment.b == -1.0d) {
            return b.g(BrothersApplication.getApplicationInstance());
        }
        StringBuilder stringBuilder = new StringBuilder("Latitude:");
        stringBuilder.append(YouliaoVideoFragment.a);
        stringBuilder.append(",Longitude:");
        stringBuilder.append(YouliaoVideoFragment.b);
        return stringBuilder.toString();
    }
}
