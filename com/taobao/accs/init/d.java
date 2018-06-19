package com.taobao.accs.init;

import android.text.TextUtils;
import com.alibaba.analytics.utils.AppInfoUtil;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import java.util.Map;

/* compiled from: Taobao */
final class d implements IAppReceiver {
    d() {
    }

    public final void onUnbindUser(int i) {
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder = new StringBuilder("onUnbindUser, errorCode:");
            stringBuilder.append(i);
            ALog.d("Launcher_InitAccs", stringBuilder.toString(), new Object[0]);
        }
    }

    public final void onUnbindApp(int i) {
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder = new StringBuilder("onUnbindApp,  errorCode:");
            stringBuilder.append(i);
            ALog.d("Launcher_InitAccs", stringBuilder.toString(), new Object[0]);
        }
    }

    public final void onSendData(String str, int i) {
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder = new StringBuilder("onSendData,  dataId:");
            stringBuilder.append(str);
            stringBuilder.append(" errorCode:");
            stringBuilder.append(i);
            ALog.d("Launcher_InitAccs", stringBuilder.toString(), new Object[0]);
        }
    }

    public final void onData(String str, String str2, byte[] bArr) {
        if (ALog.isPrintLog(Level.D)) {
            String str3 = "Launcher_InitAccs";
            StringBuilder stringBuilder = new StringBuilder("onData,  userId:");
            stringBuilder.append(str);
            stringBuilder.append("dataId:");
            stringBuilder.append(str2);
            stringBuilder.append(" dataLen:");
            stringBuilder.append(bArr == null ? null : bArr.length);
            ALog.d(str3, stringBuilder.toString(), new Object[0]);
        }
    }

    public final void onBindUser(String str, int i) {
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder = new StringBuilder("onBindUser, userId:");
            stringBuilder.append(str);
            stringBuilder.append(" errorCode:");
            stringBuilder.append(i);
            ALog.d("Launcher_InitAccs", stringBuilder.toString(), new Object[0]);
        }
        if (i == 300) {
            ACCSManager.bindApp(Launcher_InitAccs.mContext, AppInfoUtil.getAppkey(), Launcher_InitAccs.mTtid, null);
        }
    }

    public final void onBindApp(int i) {
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder = new StringBuilder("onBindApp,  errorCode:");
            stringBuilder.append(i);
            ALog.d("Launcher_InitAccs", stringBuilder.toString(), new Object[0]);
        }
        if (i == 200) {
            if (TextUtils.isEmpty(Launcher_InitAccs.mUserId) == 0) {
                ACCSManager.bindUser(Launcher_InitAccs.mContext, Launcher_InitAccs.mUserId, Launcher_InitAccs.mForceBindUser);
                Launcher_InitAccs.mForceBindUser = false;
            } else if (ALog.isPrintLog(Level.D) != 0) {
                StringBuilder stringBuilder2 = new StringBuilder("onBindApp,  bindUser userid :");
                stringBuilder2.append(Launcher_InitAccs.mUserId);
                ALog.d("Launcher_InitAccs", stringBuilder2.toString(), new Object[0]);
            }
        }
    }

    public final String getService(String str) {
        return (String) Launcher_InitAccs.a.get(str);
    }

    public final Map<String, String> getAllServices() {
        return Launcher_InitAccs.a;
    }
}
