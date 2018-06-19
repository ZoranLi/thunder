package com.xunlei.downloadprovider.comment.entity;

import com.alipay.sdk.cons.b;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommentsInfoList */
public final class f {
    public String a;
    public int b;
    public int c;
    public int d;
    public ArrayList<CommentInfo> e;

    public static f a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (jSONObject.length() > 0) {
                f fVar = new f();
                fVar.a = jSONObject.getString(b.c);
                fVar.c = jSONObject.getInt("rcount");
                jSONObject = jSONObject.getJSONArray("conmments");
                int length = jSONObject.length();
                ArrayList arrayList = new ArrayList(length);
                fVar.e = arrayList;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    CommentInfo parseFrom = CommentInfo.parseFrom(jSONObject.getJSONObject(i));
                    if (parseFrom.getBaseCommentInfo().isPreview()) {
                        i2++;
                    }
                    arrayList.add(parseFrom);
                    i++;
                }
                fVar.d = i2;
                return fVar;
            }
        }
        return null;
    }
}
