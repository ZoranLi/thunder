package com.xunlei.downloadprovider.launch.e;

import android.content.Context;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.analytics.c.d;
import com.xunlei.downloadprovider.d.a.f;
import java.io.File;
import org.json.JSONObject;

/* compiled from: HubbleGuidData */
public final class a {
    public String a;
    public String b;
    public String c;

    a() {
    }

    public static a a(Context context) {
        a aVar = new a();
        try {
            context = f.a(new File(context.getFilesDir(), ".mainiconfig"));
            if (context != null) {
                try {
                    JSONObject jSONObject = new JSONObject(context);
                    if (jSONObject.has("imei") != null) {
                        aVar.a = jSONObject.optString("imei");
                    }
                    if (jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_MAC) != null) {
                        aVar.b = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
                    }
                    if (jSONObject.has(d.a) != null) {
                        aVar.c = jSONObject.optString(d.a);
                    }
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        } catch (Context context22) {
            context22.printStackTrace();
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("HubbleGuidData{mImeiInFile='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", mMacInFile='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", mGuidInFile='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
