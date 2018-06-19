package com.xunlei.downloadprovider.homepage.photoarticle.a;

import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: PhotoArticleNetworkHelper */
public final class a extends e {
    private static a a = new a();

    /* compiled from: PhotoArticleNetworkHelper */
    public static class a {
        String a;
        public VideoUserInfo b;
        public PhotoArticleInfo c;

        public final boolean a() {
            return ITagManager.SUCCESS.equalsIgnoreCase(this.a);
        }

        public static com.xunlei.downloadprovider.homepage.photoarticle.a.a.a a(org.json.JSONObject r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = 0;
            if (r4 == 0) goto L_0x0046;
        L_0x0003:
            r1 = r4.length();
            if (r1 != 0) goto L_0x000a;
        L_0x0009:
            goto L_0x0046;
        L_0x000a:
            r1 = new com.xunlei.downloadprovider.homepage.photoarticle.a.a$a;	 Catch:{ JSONException -> 0x0045 }
            r1.<init>();	 Catch:{ JSONException -> 0x0045 }
            r2 = "result";	 Catch:{ JSONException -> 0x0045 }
            r2 = r4.getString(r2);	 Catch:{ JSONException -> 0x0045 }
            r1.a = r2;	 Catch:{ JSONException -> 0x0045 }
            r2 = "ok";	 Catch:{ JSONException -> 0x0045 }
            r3 = r1.a;	 Catch:{ JSONException -> 0x0045 }
            r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x0045 }
            if (r2 != 0) goto L_0x0022;	 Catch:{ JSONException -> 0x0045 }
        L_0x0021:
            return r1;	 Catch:{ JSONException -> 0x0045 }
        L_0x0022:
            r2 = "user_info";	 Catch:{ JSONException -> 0x0045 }
            r2 = r4.getJSONObject(r2);	 Catch:{ JSONException -> 0x0045 }
            r2 = com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo.parseFrom(r2);	 Catch:{ JSONException -> 0x0045 }
            r1.b = r2;	 Catch:{ JSONException -> 0x0045 }
            r2 = "info";	 Catch:{ JSONException -> 0x0045 }
            r4 = r4.getJSONObject(r2);	 Catch:{ JSONException -> 0x0045 }
            r4 = com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo.a(r4);	 Catch:{ JSONException -> 0x0045 }
            r1.c = r4;	 Catch:{ JSONException -> 0x0045 }
            r4 = r1.b;	 Catch:{ JSONException -> 0x0045 }
            if (r4 == 0) goto L_0x0044;	 Catch:{ JSONException -> 0x0045 }
        L_0x003e:
            r4 = r1.c;	 Catch:{ JSONException -> 0x0045 }
            if (r4 != 0) goto L_0x0043;
        L_0x0042:
            goto L_0x0044;
        L_0x0043:
            return r1;
        L_0x0044:
            return r0;
        L_0x0045:
            return r0;
        L_0x0046:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.photoarticle.a.a.a.a(org.json.JSONObject):com.xunlei.downloadprovider.homepage.photoarticle.a.a$a");
        }
    }

    public static a a() {
        return a;
    }
}
