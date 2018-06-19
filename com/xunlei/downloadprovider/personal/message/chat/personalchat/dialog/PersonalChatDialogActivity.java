package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b.e;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view.DialogContentFragment;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view.DialogTransmitterFragment;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.BaseMessageCenterActivity;

public class PersonalChatDialogActivity extends BaseMessageCenterActivity {
    private DialogContentFragment a = null;
    private DialogTransmitterFragment c = null;
    private e d = null;
    private int e = 0;
    private String f;

    public static void a(Context context, Intent intent, int i, String str) {
        if (i != 0) {
            if (((aa) p.a(aa.class)).a(i) != null) {
                intent.setClass(context, PersonalChatDialogActivity.class);
                intent.putExtra("chat_dialog_id", i);
                intent.putExtra("chat_dialog_from", str);
                context.startActivity(intent);
                if ((context instanceof BaseActivity) != null) {
                    ((BaseActivity) context).overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
                    return;
                }
                return;
            }
        }
        intent = new StringBuilder("尝试启动聊天界面失败，ChatDialog不存在. dialogId: ");
        intent.append(i);
        throw new IllegalArgumentException(intent.toString());
    }

    protected final void a(Bundle bundle) {
        super.a(bundle);
        setContentView(R.layout.activity_personal_chat);
        bundle = getIntent();
        boolean z = false;
        if (bundle != null) {
            this.e = bundle.getIntExtra("chat_dialog_id", 0);
            this.f = bundle.getStringExtra("chat_dialog_from");
            if (TextUtils.isEmpty(this.f) != null) {
                this.f = "unknown";
            }
            bundle = new StringBuilder("parseIntent mDialogId: ");
            bundle.append(this.e);
            bundle.append(" from: ");
            bundle.append(this.f);
        }
        this.a = (DialogContentFragment) getSupportFragmentManager().findFragmentById(R.id.chat_content_fragment);
        this.c = (DialogTransmitterFragment) getSupportFragmentManager().findFragmentById(R.id.chat_transmitter_fragment);
        this.d = new e();
        bundle = getSupportFragmentManager().beginTransaction();
        StringBuilder stringBuilder = new StringBuilder("mDialogContentFragment == null: ");
        if (this.a == null) {
            z = true;
        }
        stringBuilder.append(z);
        if (this.a == null) {
            this.a = DialogContentFragment.a(this.e, this.f);
            bundle.add((int) R.id.chat_content_fragment, this.a);
        }
        if (this.c == null) {
            this.c = DialogTransmitterFragment.a(this.e, this.f);
            bundle.add((int) R.id.chat_transmitter_fragment, this.c);
        }
        a aVar = new a(new com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.a(), this.a, this.d);
        f fVar = new f(this.c, this.d);
        bundle.commit();
        b.b().e();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    protected final void r_() {
        super.r_();
        b.b().f();
    }

    public void onBackPressed() {
        if (this.a.onBackPressed() && this.c.onBackPressed()) {
            finish();
        }
    }
}
