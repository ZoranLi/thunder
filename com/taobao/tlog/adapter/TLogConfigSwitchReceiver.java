package com.taobao.tlog.adapter;

import android.content.Context;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;

public class TLogConfigSwitchReceiver {
    private static final String TAG = "TLogConfigSwitchReceiver";

    final class AnonymousClass1 implements OrangeConfigListener {
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context) {
            this.val$context = context;
        }

        public final void onConfigUpdate(java.lang.String r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r11 = this;
            r0 = com.taobao.orange.OrangeConfig.getInstance();
            r12 = r0.getConfigs(r12);
            if (r12 == 0) goto L_0x0169;
        L_0x000a:
            r0 = r11.val$context;
            r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0);
            r0 = r0.edit();
            r1 = "tlog_destroy";
            r1 = r12.get(r1);
            r1 = (java.lang.String) r1;
            r2 = "tlog_switch";
            r2 = r12.get(r2);
            r2 = (java.lang.String) r2;
            r3 = "tlog_level";
            r3 = r12.get(r3);
            r3 = (java.lang.String) r3;
            r4 = "tlog_module";
            r4 = r12.get(r4);
            r4 = (java.lang.String) r4;
            r5 = "tlog_endtime";
            r5 = r12.get(r5);
            r5 = (java.lang.String) r5;
            r6 = "tlog_pull";
            r12 = r12.get(r6);
            r12 = (java.lang.String) r12;
            r6 = com.taobao.tao.log.TLogInitializer.getTLogControler();
            if (r6 != 0) goto L_0x004b;
        L_0x004a:
            return;
        L_0x004b:
            r7 = new java.lang.StringBuilder;
            r8 = "The tlogDestroy is : ";
            r7.<init>(r8);
            r7.append(r1);
            r8 = "  tlogSwitch is : ";
            r7.append(r8);
            r7.append(r2);
            r8 = "  tlogLevel is : ";
            r7.append(r8);
            r7.append(r3);
            r8 = "  tlogModule is : ";
            r7.append(r8);
            r7.append(r4);
            r7 = android.text.TextUtils.isEmpty(r1);
            if (r7 != 0) goto L_0x0168;
        L_0x0073:
            r7 = "true";
            r1 = r7.equalsIgnoreCase(r1);
            r7 = 1;
            r8 = 0;
            if (r1 == 0) goto L_0x008c;
        L_0x007d:
            com.taobao.tao.log.TLogInitializer.delete();
            r6.openLog(r8);
            r6.destroyLog(r7);
            r12 = "tlog_switch";
            r0.putBoolean(r12, r8);
            return;
        L_0x008c:
            r6.destroyLog(r8);
            r1 = android.text.TextUtils.isEmpty(r2);
            if (r1 != 0) goto L_0x0167;
        L_0x0095:
            r1 = "true";
            r1 = r1.equalsIgnoreCase(r2);
            if (r1 == 0) goto L_0x00a6;
        L_0x009d:
            r6.openLog(r7);
            r1 = "tlog_switch";
            r0.putBoolean(r1, r7);
            goto L_0x00b6;
        L_0x00a6:
            r1 = "false";
            r1 = r1.equalsIgnoreCase(r2);
            if (r1 == 0) goto L_0x00b6;
        L_0x00ae:
            r6.openLog(r8);
            r1 = "tlog_switch";
            r0.putBoolean(r1, r8);
        L_0x00b6:
            r1 = android.text.TextUtils.isEmpty(r3);
            if (r1 != 0) goto L_0x0166;
        L_0x00bc:
            r6.setLogLevel(r3);
            r1 = "tlog_level";
            r0.putString(r1, r3);
            r1 = android.text.TextUtils.isEmpty(r4);
            if (r1 != 0) goto L_0x0165;
        L_0x00ca:
            r1 = com.taobao.tao.log.TLogUtils.makeModule(r4);
            r6.setModuleFilter(r1);
            r1 = "tlog_module";
            r0.putString(r1, r4);
            r1 = android.text.TextUtils.isEmpty(r5);
            if (r1 != 0) goto L_0x012a;
        L_0x00dc:
            r1 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x00ea }
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ NumberFormatException -> 0x00ea }
            r1 = r1 * 1000;
            r4 = (long) r1;
            r7 = r2 + r4;
            goto L_0x00ee;
        L_0x00ea:
            r7 = java.lang.System.currentTimeMillis();
        L_0x00ee:
            r1 = java.lang.System.currentTimeMillis();
            r3 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
            r9 = r1 + r3;
            r1 = java.lang.System.currentTimeMillis();
            r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
            if (r3 <= 0) goto L_0x010c;
        L_0x00ff:
            r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
            if (r1 >= 0) goto L_0x010c;
        L_0x0103:
            r6.setEndTime(r7);
            r1 = "tlog_endtime";
            r0.putLong(r1, r7);
            goto L_0x013a;
        L_0x010c:
            r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
            if (r1 < 0) goto L_0x0119;
        L_0x0110:
            r6.setEndTime(r9);
            r1 = "tlog_endtime";
            r0.putLong(r1, r9);
            goto L_0x013a;
        L_0x0119:
            r1 = java.lang.System.currentTimeMillis();
            r6.setEndTime(r1);
            r1 = "tlog_endtime";
            r2 = java.lang.System.currentTimeMillis();
            r0.putLong(r1, r2);
            goto L_0x013a;
        L_0x012a:
            r1 = java.lang.System.currentTimeMillis();
            r6.setEndTime(r1);
            r1 = "tlog_endtime";
            r2 = java.lang.System.currentTimeMillis();
            r0.putLong(r1, r2);
        L_0x013a:
            r1 = android.text.TextUtils.isEmpty(r12);
            if (r1 != 0) goto L_0x0156;
        L_0x0140:
            r1 = "true";
            r1 = r12.equals(r1);
            if (r1 == 0) goto L_0x0151;
        L_0x0148:
            r1 = com.taobao.tao.log.TaskManager.getInstance();
            r2 = r11.val$context;
            r1.queryTraceStatus(r2);
        L_0x0151:
            r1 = "tlog_pull";
            r0.putString(r1, r12);
        L_0x0156:
            r12 = "tlog_version";
            r1 = r11.val$context;
            r1 = com.taobao.tao.log.TLogUtils.getAppBuildVersion(r1);
            r0.putString(r12, r1);
            r0.apply();
            return;
        L_0x0165:
            return;
        L_0x0166:
            return;
        L_0x0167:
            return;
        L_0x0168:
            return;
        L_0x0169:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.tlog.adapter.TLogConfigSwitchReceiver.1.onConfigUpdate(java.lang.String):void");
        }
    }

    public static void init(Context context) {
        OrangeConfig.getInstance().registerListener(new String[]{"remote_debuger_android"}, new AnonymousClass1(context));
    }
}
