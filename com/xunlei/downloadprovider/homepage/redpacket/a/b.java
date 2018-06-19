package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* compiled from: RedPacketModel */
public final class b {
    public String a;
    public boolean b;
    public float c;
    public int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            String optString = jSONObject.optString("result");
            boolean optBoolean = jSONObject.optBoolean("is_new");
            int optInt = jSONObject.optInt("error_code");
            String optString2 = jSONObject.optString("error_text");
            String optString3 = jSONObject.optString("error");
            bVar.a = optString;
            bVar.b = optBoolean;
            bVar.d = optInt;
            bVar.j = optString2;
            bVar.k = optString3;
            jSONObject = jSONObject.optJSONObject("newbie_info");
            if (jSONObject != null) {
                optString = jSONObject.optString(AgooConstants.MESSAGE_ID);
                float optLong = (float) jSONObject.optLong("amount");
                String optString4 = jSONObject.optString(SocializeProtocolConstants.CREATE_AT);
                optString2 = jSONObject.optString("invitee");
                optString3 = jSONObject.optString("inviter");
                jSONObject = jSONObject.optString("peer_id");
                bVar.f = optString;
                bVar.c = optLong;
                bVar.e = optString4;
                bVar.g = optString2;
                bVar.h = optString3;
                bVar.i = jSONObject;
            }
        }
        return bVar;
    }
}
