package com.sina.weibo.sdk.statistic;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

class WBAgentHandler {
    private static int MAX_CACHE_SIZE = 5;
    private static CopyOnWriteArrayList<PageLog> mActivePages;
    private static WBAgentHandler mInstance;
    private static Timer mLogTimer;
    private static Map<String, PageLog> mPages;
    private static Timer mTimer;

    public static synchronized WBAgentHandler getInstance() {
        WBAgentHandler wBAgentHandler;
        synchronized (WBAgentHandler.class) {
            if (mInstance == null) {
                mInstance = new WBAgentHandler();
            }
            wBAgentHandler = mInstance;
        }
        return wBAgentHandler;
    }

    private WBAgentHandler() {
        mActivePages = new CopyOnWriteArrayList();
        mPages = new HashMap();
        LogUtil.i(WBAgent.TAG, "init handler");
    }

    public void onPageStart(String str) {
        if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
            PageLog pageLog = new PageLog(str);
            pageLog.setType(LogType.FRAGMENT);
            synchronized (mPages) {
                mPages.put(str, pageLog);
            }
            String str2 = WBAgent.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(", ");
            stringBuilder.append(pageLog.getStartTime() / 1000);
            LogUtil.d(str2, stringBuilder.toString());
        }
    }

    public void onPageEnd(String str) {
        if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
            if (mPages.containsKey(str)) {
                PageLog pageLog = (PageLog) mPages.get(str);
                pageLog.setDuration(System.currentTimeMillis() - pageLog.getStartTime());
                synchronized (mActivePages) {
                    mActivePages.add(pageLog);
                }
                synchronized (mPages) {
                    mPages.remove(str);
                }
                String str2 = WBAgent.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(", ");
                stringBuilder.append(pageLog.getStartTime() / 1000);
                stringBuilder.append(", ");
                stringBuilder.append(pageLog.getDuration() / 1000);
                LogUtil.d(str2, stringBuilder.toString());
            } else {
                LogUtil.e(WBAgent.TAG, "please call onPageStart before onPageEnd");
            }
            if (mActivePages.size() >= MAX_CACHE_SIZE) {
                synchronized (mActivePages) {
                    saveActivePages(mActivePages);
                    mActivePages.clear();
                }
            }
        }
    }

    public void onResume(Context context) {
        if (LogReport.getPackageName() == null) {
            LogReport.setPackageName(context.getPackageName());
        }
        if (mTimer == null) {
            mTimer = timerTask(context, 500, StatisticConfig.getUploadInterval());
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        checkNewSession(context, currentTimeMillis);
        if (StatisticConfig.ACTIVITY_DURATION_OPEN != null) {
            context = new PageLog(name, currentTimeMillis);
            context.setType(LogType.ACTIVITY);
            synchronized (mPages) {
                mPages.put(name, context);
            }
        }
        context = WBAgent.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(", ");
        stringBuilder.append(currentTimeMillis / 1000);
        LogUtil.d(context, stringBuilder.toString());
    }

    public void onPause(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        String str = WBAgent.TAG;
        StringBuilder stringBuilder = new StringBuilder("update last page endtime:");
        stringBuilder.append(currentTimeMillis / 1000);
        LogUtil.i(str, stringBuilder.toString());
        PageLog.updateSession(context, null, Long.valueOf(0), Long.valueOf(currentTimeMillis));
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            if (mPages.containsKey(name)) {
                PageLog pageLog = (PageLog) mPages.get(name);
                pageLog.setDuration(currentTimeMillis - pageLog.getStartTime());
                synchronized (mActivePages) {
                    mActivePages.add(pageLog);
                }
                synchronized (mPages) {
                    mPages.remove(name);
                }
                String str2 = WBAgent.TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(name);
                stringBuilder2.append(", ");
                stringBuilder2.append(pageLog.getStartTime() / 1000);
                stringBuilder2.append(", ");
                stringBuilder2.append(pageLog.getDuration() / 1000);
                LogUtil.d(str2, stringBuilder2.toString());
            } else {
                LogUtil.e(WBAgent.TAG, "please call onResume before onPause");
            }
            if (mActivePages.size() >= MAX_CACHE_SIZE) {
                synchronized (mActivePages) {
                    saveActivePages(mActivePages);
                    mActivePages.clear();
                }
            }
        }
        checkAppStatus(context);
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        EventLog eventLog = new EventLog(str, str2, map);
        eventLog.setType(LogType.EVENT);
        synchronized (mActivePages) {
            mActivePages.add(eventLog);
        }
        if (map == null) {
            map = WBAgent.TAG;
            StringBuilder stringBuilder = new StringBuilder("event--- page:");
            stringBuilder.append(str);
            stringBuilder.append(" ,event name:");
            stringBuilder.append(str2);
            LogUtil.d(map, stringBuilder.toString());
        } else {
            String str3 = WBAgent.TAG;
            StringBuilder stringBuilder2 = new StringBuilder("event--- page:");
            stringBuilder2.append(str);
            stringBuilder2.append(" ,event name:");
            stringBuilder2.append(str2);
            stringBuilder2.append(" ,extend:");
            stringBuilder2.append(map.toString());
            LogUtil.d(str3, stringBuilder2.toString());
        }
        if (mActivePages.size() >= MAX_CACHE_SIZE) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    public void uploadAppLogs(final Context context) {
        long currentTimeMillis = System.currentTimeMillis() - LogReport.getTime(context);
        if (LogReport.getTime(context) <= 0 || currentTimeMillis >= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            WBAgentExecutor.execute(new Runnable() {
                public void run() {
                    LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
                }
            });
            return;
        }
        timerTask(context, StatisticConfig.MIN_UPLOAD_INTERVAL - currentTimeMillis, 0);
    }

    public void onStop(Context context) {
        checkAppStatus(context);
    }

    private void checkAppStatus(Context context) {
        if (isBackground(context) != null) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    private boolean isBackground(Context context) {
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                StringBuilder stringBuilder;
                if (runningAppProcessInfo.importance == 400) {
                    context = WBAgent.TAG;
                    stringBuilder = new StringBuilder("后台:");
                    stringBuilder.append(runningAppProcessInfo.processName);
                    LogUtil.i(context, stringBuilder.toString());
                    return true;
                }
                context = WBAgent.TAG;
                stringBuilder = new StringBuilder("前台:");
                stringBuilder.append(runningAppProcessInfo.processName);
                LogUtil.i(context, stringBuilder.toString());
                return false;
            }
        }
        return false;
    }

    public void onKillProcess() {
        LogUtil.i(WBAgent.TAG, "save applogs and close timer and shutdown thread executor");
        synchronized (mActivePages) {
            saveActivePages(mActivePages);
        }
        mInstance = null;
        closeTimer();
        WBAgentExecutor.shutDownExecutor();
    }

    private void checkNewSession(Context context, long j) {
        if (PageLog.isNewSession(context, j)) {
            PageLog pageLog = new PageLog(context);
            pageLog.setType(LogType.SESSION_END);
            PageLog pageLog2 = new PageLog(context, j);
            pageLog2.setType(LogType.SESSION_START);
            synchronized (mActivePages) {
                if (pageLog.getEndTime() > 0) {
                    mActivePages.add(pageLog);
                } else {
                    LogUtil.d(WBAgent.TAG, "is a new install");
                }
                mActivePages.add(pageLog2);
            }
            context = WBAgent.TAG;
            j = new StringBuilder("last session--- starttime:");
            j.append(pageLog.getStartTime());
            j.append(" ,endtime:");
            j.append(pageLog.getEndTime());
            LogUtil.d(context, j.toString());
            context = WBAgent.TAG;
            j = new StringBuilder("is a new session--- starttime:");
            j.append(pageLog2.getStartTime());
            LogUtil.d(context, j.toString());
            return;
        }
        LogUtil.i(WBAgent.TAG, "is not a new session");
    }

    private synchronized void saveActivePages(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        copyOnWriteArrayList = LogBuilder.getPageLogs(copyOnWriteArrayList);
        WBAgentExecutor.execute(new Runnable() {
            public void run() {
                LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), copyOnWriteArrayList, true);
            }
        });
    }

    private synchronized String getLogsInMemory() {
        String str;
        str = "";
        if (mActivePages.size() > 0) {
            String pageLogs;
            synchronized (mActivePages) {
                pageLogs = LogBuilder.getPageLogs(mActivePages);
                mActivePages.clear();
            }
            str = pageLogs;
        }
        return str;
    }

    private Timer timerTask(final Context context, long j, long j2) {
        Timer timer = new Timer();
        TimerTask anonymousClass3 = new TimerTask() {
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        };
        if (j2 == 0) {
            timer.schedule(anonymousClass3, j);
        } else {
            timer.schedule(anonymousClass3, j, j2);
        }
        return timer;
    }

    private void closeTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void registerApptoAd(final Context context, final String str, Map<String, String> map) {
        try {
            final AdEventLog adEventLog = new AdEventLog();
            adEventLog.setType(LogType.APP_AD_START);
            if (isFirstStartBoolean(context)) {
                adEventLog.setmEvent_id("1");
            }
            adEventLog.setmImei(MD5.hexdigest(AidTask.getImei(context)));
            adEventLog.setmStart_time(System.currentTimeMillis());
            adEventLog.setmExtend(map);
            map = Utility.getAid(context, str);
            if (TextUtils.isEmpty(map)) {
                map = new TimerTask() {
                    public void run() {
                        adEventLog.setmAid(Utility.getAid(context, str));
                        WBAgentHandler.this.uploadAdlog(context, adEventLog);
                    }
                };
                context = new Timer();
                mLogTimer = context;
                context.schedule(map, 5000);
                return;
            }
            adEventLog.setmAid(map);
            uploadAdlog(context, adEventLog);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void uploadAdlog(final Context context, AdEventLog adEventLog) {
        mActivePages.add(adEventLog);
        WBAgentExecutor.execute(new Runnable() {
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        });
    }

    public static boolean isFirstStartBoolean(Context context) {
        context = context.getSharedPreferences(WBConstants.THIRD_APP_IS_FIRST, 0);
        boolean z = context.getBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, true);
        if (z) {
            context = context.edit();
            context.putBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, false);
            context.commit();
        }
        return z;
    }
}
