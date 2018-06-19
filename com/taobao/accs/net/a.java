package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;

/* compiled from: Taobao */
public class a extends g {
    private PendingIntent c;
    private AlarmManager d;

    public a(Context context) {
        super(context);
        try {
            this.d = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        } catch (Context context2) {
            ALog.e("AlarmHeartBeatMgr", "AlarmHeartBeatMgr", context2, new Object[0]);
        }
    }

    protected void a(int i) {
        if (this.d == null) {
            this.d = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        if (this.d == null) {
            ALog.e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
            return;
        }
        if (this.c == null) {
            Intent intent = new Intent();
            intent.setPackage(this.a.getPackageName());
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            this.c = PendingIntent.getBroadcast(this.a, 0, intent, 0);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.add(13, i);
        this.d.set(0, instance.getTimeInMillis(), this.c);
    }
}
