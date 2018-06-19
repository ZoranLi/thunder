package com.xunlei.downloadprovider.personal.user.account.ui;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.b.e;

/* compiled from: UserAccountMemberActivity */
final class x implements MessageListener {
    final /* synthetic */ UserAccountMemberActivity a;

    x(UserAccountMemberActivity userAccountMemberActivity) {
        this.a = userAccountMemberActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                if (message.arg1 == null) {
                    this.a.a();
                    return;
                }
                break;
            case 101:
                long j = message.getData().getLong("flowtotal");
                long j2 = message.getData().getLong("flowused");
                message = "";
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.a.a(e.a(j2, 2)));
                    stringBuilder.append("/");
                    stringBuilder.append(this.a.a(e.a(j, 2)));
                    message = stringBuilder.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (j == 0) {
                    this.a.l.setText(R.string.user_highspeed_default);
                    break;
                } else {
                    this.a.l.setText(message);
                    return;
                }
            default:
                break;
        }
    }
}
