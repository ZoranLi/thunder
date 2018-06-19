package com.taobao.accs.antibrush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService.ExtHeaderType;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class AntiBrush {
    private static final String ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    public static final int STATUS_BRUSH = 419;
    private static final String TAG = "AntiBrush";
    private static String mHost = null;
    private static volatile boolean mIsInCheckCodeActivity = false;
    private static ScheduledFuture<?> mTimeoutTask;
    private BroadcastReceiver mAntiAttackReceiver = null;
    private Context mContext;

    /* compiled from: Taobao */
    public static class AntiReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Context equalsIgnoreCase;
            try {
                intent = intent.getStringExtra("Result");
                String str = AntiBrush.TAG;
                StringBuilder stringBuilder = new StringBuilder("anti onReceive result: ");
                stringBuilder.append(intent);
                ALog.e(str, stringBuilder.toString(), new Object[0]);
                equalsIgnoreCase = intent.equalsIgnoreCase("success");
            } catch (Exception e) {
                equalsIgnoreCase = e;
                ALog.e(AntiBrush.TAG, "anti onReceive", equalsIgnoreCase, new Object[0]);
            } finally {
                AntiBrush.onResult(GlobalClientInfo.getContext(), context);
            }
        }
    }

    public boolean checkAntiBrush(URL url, Map<Integer, String> map) {
        boolean z = true;
        if (map != null) {
            try {
                if (UtilityImpl.isForeground(this.mContext)) {
                    String str = (String) map.get(Integer.valueOf(ExtHeaderType.TYPE_STATUS.ordinal()));
                    if ((TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue()) == STATUS_BRUSH) {
                        String str2 = (String) map.get(Integer.valueOf(ExtHeaderType.TYPE_LOCATION.ordinal()));
                        if (!TextUtils.isEmpty(str2)) {
                            str = TAG;
                            StringBuilder stringBuilder = new StringBuilder("start anti bursh location:");
                            stringBuilder.append(str2);
                            ALog.e(str, stringBuilder.toString(), new Object[0]);
                            handleantiBrush(str2);
                            str = null;
                            if (mTimeoutTask != null) {
                                mTimeoutTask.cancel(true);
                                mTimeoutTask = null;
                            }
                            mTimeoutTask = ThreadPoolExecutorFactory.schedule(new a(this), 60000, TimeUnit.MILLISECONDS);
                            if (url != null) {
                                str = url.getHost();
                            }
                            mHost = str;
                            if (TextUtils.isEmpty(GlobalClientInfo.c) == null && TextUtils.isEmpty(b.a(mHost)) != null) {
                                ALog.e(TAG, "cookie invalid, clear", new Object[0]);
                                UtilityImpl.clearCookie(this.mContext);
                            }
                            return z;
                        }
                    }
                }
            } catch (Throwable th) {
                url = th;
                z = false;
                ALog.e(TAG, "checkAntiBrush error", url, new Object[0]);
                return z;
            }
        }
        z = false;
        try {
            ALog.e(TAG, "cookie invalid, clear", new Object[0]);
            UtilityImpl.clearCookie(this.mContext);
        } catch (Throwable th2) {
            url = th2;
            ALog.e(TAG, "checkAntiBrush error", url, new Object[0]);
            return z;
        }
        return z;
    }

    public AntiBrush(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static void onResult(Context context, boolean z) {
        mIsInCheckCodeActivity = false;
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", 104);
        intent.putExtra(Constants.KEY_ANTI_BRUSH_RET, z);
        d.a(context, intent);
        if (mTimeoutTask) {
            mTimeoutTask.cancel(true);
            mTimeoutTask = false;
        }
        if (mHost) {
            UtilityImpl.storeCookie(context, b.a(mHost));
        }
    }

    private void handleantiBrush(String str) {
        if (mIsInCheckCodeActivity) {
            ALog.e(TAG, "handleantiBrush return", new Object[]{"mIsInCheckCodeActivity", Boolean.valueOf(mIsInCheckCodeActivity)});
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
            intent.putExtra("Location", str);
            ALog.e(TAG, "handleAntiBrush:", new Object[0]);
            this.mContext.startActivity(intent);
            mIsInCheckCodeActivity = true;
            if (this.mAntiAttackReceiver == null) {
                this.mAntiAttackReceiver = new AntiReceiver();
            }
            this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION));
        } catch (String str2) {
            ALog.e(TAG, "handleantiBrush", str2, new Object[0]);
        }
    }
}
