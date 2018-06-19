package com.taobao.agoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.b;
import java.util.HashSet;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
public class BaseNotifyClickActivity extends Activity {
    private static final String TAG = "accs.BaseNotifyClickActivity";
    private static final String TAOBAO_PACKAGE_NAME = "com.taobao.taobao";
    private static Set<INotifyListener> notifyListeners;
    private AgooFactory agooFactory;
    private String msgSource;
    private NotifManager notifyManager;

    /* compiled from: Taobao */
    public interface INotifyListener {
        String getMsgSource();

        String parseMsgFromIntent(Intent intent);
    }

    public void onMessage(Intent intent) {
    }

    public static void addNotifyListener(INotifyListener iNotifyListener) {
        if (notifyListeners == null) {
            notifyListeners = new HashSet();
        }
        notifyListeners.add(iNotifyListener);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ALog.i(TAG, "onCreate", new Object[0]);
        buildMessage(getIntent());
    }

    public void onStart() {
        super.onStart();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ALog.i(TAG, "onNewIntent", new Object[0]);
        buildMessage(intent);
    }

    private void buildMessage(Intent intent) {
        ThreadPoolExecutorFactory.execute(new a(this, intent));
    }

    private String parseMsgByThirdPush(Intent intent) {
        String parseMsgFromIntent;
        if (notifyListeners == null || notifyListeners.size() <= 0) {
            ALog.e(TAG, "no impl, try use default impl to parse intent!", new Object[0]);
            INotifyListener bVar = new b();
            parseMsgFromIntent = bVar.parseMsgFromIntent(intent);
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                bVar = new c();
                parseMsgFromIntent = bVar.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent) != null) {
                b.a("accs", "error", "parse 3push error", 0.0d);
            } else {
                this.msgSource = bVar.getMsgSource();
                StringBuilder stringBuilder = new StringBuilder("parse 3push default ");
                stringBuilder.append(this.msgSource);
                b.a("accs", "error", stringBuilder.toString(), 0.0d);
            }
        } else {
            parseMsgFromIntent = null;
            for (INotifyListener iNotifyListener : notifyListeners) {
                CharSequence parseMsgFromIntent2 = iNotifyListener.parseMsgFromIntent(intent);
                if (!TextUtils.isEmpty(parseMsgFromIntent2)) {
                    this.msgSource = iNotifyListener.getMsgSource();
                    parseMsgFromIntent = parseMsgFromIntent2;
                    break;
                }
                CharSequence charSequence = parseMsgFromIntent2;
            }
        }
        ALog.i(TAG, "parseMsgByThirdPush", new Object[]{"result", parseMsgFromIntent, "msgSource", this.msgSource});
        return parseMsgFromIntent;
    }

    private void reportClickNotifyMsg(Intent intent) {
        String stringExtra;
        try {
            stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_REPORT);
            intent = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = stringExtra;
            msgDO.extData = intent;
            msgDO.messageSource = stringExtra2;
            msgDO.reportStr = stringExtra3;
            msgDO.msgStatus = "8";
            intent = TAG;
            StringBuilder stringBuilder = new StringBuilder("reportClickNotifyMsg messageId:");
            stringBuilder.append(stringExtra);
            stringBuilder.append(" source:");
            stringBuilder.append(stringExtra2);
            stringBuilder.append(" reportStr:");
            stringBuilder.append(stringExtra3);
            stringBuilder.append(" status:");
            stringBuilder.append(msgDO.msgStatus);
            ALog.i(intent, stringBuilder.toString(), new Object[0]);
            this.notifyManager.report(msgDO, null);
        } catch (Intent intent2) {
            stringExtra = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("reportClickNotifyMsg exception: ");
            stringBuilder2.append(intent2);
            ALog.e(stringExtra, stringBuilder2.toString(), new Object[0]);
        }
    }
}
