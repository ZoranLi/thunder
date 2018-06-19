package com.xunlei.downloadprovider.d;

import com.xunlei.downloadprovider.d.a.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CommentConfigure */
public class b extends i {
    private static String a = "CommentConfigure.json";
    private static volatile b b;
    private p[] c = new p[4];

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    private b() {
        super(a, "http://api-shoulei-ssl.xunlei.com/configuration/global/get_cfg?config_type=comment");
        this.c[0] = new p("m1", "厉害了word哥");
        this.c[1] = new p("m2", "听说评论了就有女朋友");
        this.c[2] = new p("m3", "滴，老湿基打卡");
        this.c[3] = new p("m4", "一点也不好看，我只看了十几遍");
    }

    public final p[] d(String str) {
        if (this.k != null) {
            if (this.k.length() > 0) {
                if (!this.k.has(str)) {
                    return this.c;
                }
                str = this.k.optJSONArray(str);
                if (str == null) {
                    return this.c;
                }
                if (str.length() < 4) {
                    return null;
                }
                p[] pVarArr = new p[4];
                for (int i = 0; i < 4; i++) {
                    JSONArray optJSONArray = str.optJSONArray(i);
                    if (optJSONArray == null) {
                        return null;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject((int) (Math.random() * ((double) optJSONArray.length())));
                    p pVar = new p();
                    pVar.a = optJSONObject.optString(AgooConstants.MESSAGE_ID);
                    pVar.b = optJSONObject.optString("comment");
                    pVarArr[i] = pVar;
                }
                return pVarArr;
            }
        }
        return this.c;
    }
}
