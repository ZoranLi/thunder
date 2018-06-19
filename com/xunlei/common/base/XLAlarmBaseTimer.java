package com.xunlei.common.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

public class XLAlarmBaseTimer {
    public static final String MY_ALARM_TIMER_ACTION_BASE = "com.xunlei.xlkdemo.timer.action_";
    public static final String MY_ALARM_TIMER_ID = "alarm_timer_id";
    public static final String MY_ALARM_TIMER_INTENT_CATEGORY = "com.xunlei.xlkdemo.timer.CATEGORY";
    private static boolean mInited = false;
    private static XLAlarmBaseTimer mTimer;
    private Context mContext = null;
    private Map<String, TimerItem> mTimerCollection = new HashMap();
    private BroadcastReceiver mTimerRecever = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            context = new StringBuilder();
            context.append(intent.getAction());
            context.append(intent.getIntExtra(XLAlarmBaseTimer.MY_ALARM_TIMER_ID, 0));
            TimerItem timerItem = (TimerItem) XLAlarmBaseTimer.this.mTimerCollection.get(context.toString());
            if (timerItem != null) {
                timerItem.tick();
                if (timerItem.isLoop() == null) {
                    XLAlarmBaseTimer.mTimer.unRegisterTimer(timerItem.getTimerId());
                    return;
                }
                if (VERSION.SDK_INT >= 19) {
                    timerItem.start();
                }
            }
        }
    };

    public static class TimerItem {
        private int mExpireTime = 0;
        private TimerListener mListener = null;
        private boolean mLoop = false;
        private PendingIntent mPendingIntent = null;
        private int mTimerId = 0;

        public TimerItem(int i, int i2, boolean z, TimerListener timerListener) {
            this.mTimerId = i;
            this.mExpireTime = i2;
            this.mLoop = z;
            this.mListener = timerListener;
        }

        public static String getAction(int i) {
            StringBuilder stringBuilder = new StringBuilder(XLAlarmBaseTimer.MY_ALARM_TIMER_ACTION_BASE);
            stringBuilder.append(String.valueOf(i));
            return stringBuilder.toString();
        }

        public int getTimerId() {
            return this.mTimerId;
        }

        public void start() {
            Intent intent = new Intent(XLAlarmBaseTimer.MY_ALARM_TIMER_ACTION_BASE);
            intent.addCategory(XLAlarmBaseTimer.MY_ALARM_TIMER_INTENT_CATEGORY);
            intent.putExtra(XLAlarmBaseTimer.MY_ALARM_TIMER_ID, this.mTimerId);
            this.mPendingIntent = PendingIntent.getBroadcast(XLAlarmBaseTimer.mTimer.mContext, this.mTimerId, intent, 134217728);
            AlarmManager alarmManager = (AlarmManager) XLAlarmBaseTimer.mTimer.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (VERSION.SDK_INT < 19) {
                alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) this.mExpireTime), (long) this.mExpireTime, this.mPendingIntent);
                return;
            }
            alarmManager.setExact(0, System.currentTimeMillis() + ((long) this.mExpireTime), this.mPendingIntent);
        }

        public void kill() {
            ((AlarmManager) XLAlarmBaseTimer.mTimer.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.mPendingIntent);
        }

        public void tick() {
            if (this.mListener != null) {
                this.mListener.onTimerTick(this.mTimerId);
            }
        }

        public boolean isLoop() {
            return this.mLoop;
        }

        public int getExpireTime() {
            return this.mExpireTime;
        }
    }

    public interface TimerListener {
        void onTimerTick(int i);
    }

    private XLAlarmBaseTimer() {
    }

    public static void init(Context context) {
        if (!mInited) {
            mInited = true;
            XLAlarmBaseTimer xLAlarmBaseTimer = new XLAlarmBaseTimer();
            mTimer = xLAlarmBaseTimer;
            xLAlarmBaseTimer.mContext = context;
            context = new IntentFilter();
            context.addCategory(MY_ALARM_TIMER_INTENT_CATEGORY);
            context.addAction(MY_ALARM_TIMER_ACTION_BASE);
            context.setPriority(Integer.MAX_VALUE);
            mTimer.mContext.registerReceiver(mTimer.mTimerRecever, context);
        }
    }

    public static void unInit() {
        if (mInited) {
            mInited = false;
            mTimer.mContext.unregisterReceiver(mTimer.mTimerRecever);
        }
    }

    public static synchronized XLAlarmBaseTimer getInstance() {
        XLAlarmBaseTimer xLAlarmBaseTimer;
        synchronized (XLAlarmBaseTimer.class) {
            xLAlarmBaseTimer = mTimer;
        }
        return xLAlarmBaseTimer;
    }

    public synchronized void registerTimer(int i, int i2, boolean z, TimerListener timerListener) {
        TimerItem timerItem = new TimerItem(i, i2, z, timerListener);
        this.mTimerCollection.put(TimerItem.getAction(i), timerItem);
        timerItem.start();
    }

    public synchronized void unRegisterTimer(int i) {
        TimerItem timerItem = (TimerItem) this.mTimerCollection.get(TimerItem.getAction(i));
        if (timerItem != null) {
            timerItem.kill();
            this.mTimerCollection.remove(TimerItem.getAction(i));
        }
    }

    public void clearAllTimer() {
        for (String str : this.mTimerCollection.keySet()) {
            ((TimerItem) this.mTimerCollection.get(str)).kill();
        }
        this.mTimerCollection.clear();
    }
}
