package com.taobao.accs.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
public class MsgDistributeService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            ALog.i("MsgDistributeService", "onStartCommand", new Object[]{"action", intent.getAction()});
            if (TextUtils.isEmpty(intent.getAction()) || !TextUtils.equals(intent.getAction(), Constants.ACTION_SEND)) {
                d.a(getApplicationContext(), intent);
                return 2;
            }
            AccsRequest accsRequest = (AccsRequest) intent.getSerializableExtra(Constants.KEY_SEND_REQDATA);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra("appKey");
            intent = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            if (TextUtils.isEmpty(intent)) {
                intent = stringExtra2;
            }
            ACCSManager.getAccsInstance(getApplicationContext(), stringExtra2, intent).sendRequest(getApplicationContext(), accsRequest, stringExtra, false);
            return 2;
        } catch (Intent intent2) {
            ALog.e("MsgDistributeService", "onStartCommand", intent2, new Object[0]);
        }
    }
}
