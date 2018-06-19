package org.android.agoo.message;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.BaseIntentService;
import org.android.agoo.service.SendMessage.Stub;

/* compiled from: Taobao */
public abstract class MessageReceiverService extends Service {
    Stub a = new Stub() {
        public int doSend(Intent intent) throws RemoteException {
            BaseIntentService.runIntentInService(MessageReceiverService.this.getApplicationContext(), intent, MessageReceiverService.this.getIntentServiceClassName(MessageReceiverService.this.getApplicationContext()));
            return null;
        }
    };

    public abstract String getIntentServiceClassName(Context context);

    public IBinder onBind(Intent intent) {
        ALog.d("MessageReceiverService", "Message receiver aidl was binded {}", new Object[]{intent.getAction()});
        if (AgooConstants.BINDER_MSGRECEIVER_ACTION.equals(intent.getAction()) != null) {
            return this.a;
        }
        return this.a;
    }

    public void onCreate() {
        super.onCreate();
    }
}
