package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.r;
import org.apache.thrift.a;

public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        a aiVar = new ai();
        aiVar.c(r.V.W);
        aiVar.b(c.a(context).c());
        aiVar.d(context.getPackageName());
        aiVar.a("data", str);
        aiVar.a(MiPushClient.generatePacketID());
        ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.i, null);
    }
}
