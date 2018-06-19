package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.util.e;

class bp extends BroadcastReceiver {
    final /* synthetic */ XMPushService a;

    bp(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals("com.xiaomi.metoknlp.geofencing.state_change_protected", intent.getAction())) {
            String stringExtra = intent.getStringExtra("Describe");
            String stringExtra2 = intent.getStringExtra("State");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (!this.a.a(stringExtra2, stringExtra, context)) {
                    stringExtra2 = "Unknown";
                    StringBuilder stringBuilder = new StringBuilder(" updated geofence statue about geo_id:");
                    stringBuilder.append(stringExtra);
                    stringBuilder.append(" falied. current_statue:");
                    stringBuilder.append(stringExtra2);
                    b.a(stringBuilder.toString());
                }
                e.a(new bq(this, context, stringExtra, stringExtra2));
                StringBuilder stringBuilder2 = new StringBuilder("ownresilt结果:state= ");
                stringBuilder2.append(stringExtra2);
                stringBuilder2.append("\n describe=");
                stringBuilder2.append(stringExtra);
                b.c(stringBuilder2.toString());
            }
        }
    }
}
