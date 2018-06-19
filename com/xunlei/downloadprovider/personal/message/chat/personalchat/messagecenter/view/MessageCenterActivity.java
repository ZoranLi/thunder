package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.m;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.e;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.info.MessageCenterDispatchInfo;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.view.PersonalChatStrangersActivity;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.publiser.visitors.VisitActivity;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import java.io.Serializable;

public class MessageCenterActivity extends BaseMessageCenterActivity implements a<b>, com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b<b>, e.b {
    private e.a a = null;
    private XRecyclerView c = null;
    private i d = null;
    private c e = null;
    private TitleBar f = null;

    public final /* synthetic */ void b(Object obj) {
        this.a.a((b) obj);
    }

    public final /* synthetic */ void c(Object obj) {
        this.a.b((b) obj);
    }

    public static void a(Context context, MessageCenterDispatchInfo messageCenterDispatchInfo) {
        a(context, new Intent(), messageCenterDispatchInfo);
    }

    public static void a(Context context, Intent intent, MessageCenterDispatchInfo messageCenterDispatchInfo) {
        messageCenterDispatchInfo.buildIntent(intent);
        a(context, intent);
    }

    public static void a(Context context, Intent intent) {
        intent.setClass(context, MessageCenterActivity.class);
        context.startActivity(intent);
    }

    protected final void a(Bundle bundle) {
        super.a(bundle);
        setContentView(R.layout.activity_message_center);
        this.a = new com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b.b(this, new m());
        this.a.a(getIntent());
        this.f = new TitleBar((Activity) this);
        this.f.mTitle.setText("消息");
        this.c = (XRecyclerView) findViewById(R.id.pull_to_refresh_recycler_view);
        this.c.setPullRefreshEnabled(com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c());
        this.c.setLoadingMoreEnabled(com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c());
        bundle = new LinearLayoutManager(this, 1, false);
        ItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        this.c.setLayoutManager(bundle);
        this.c.setItemAnimator(defaultItemAnimator);
        this.c.addItemDecoration(new n());
        this.e = new c(this);
        this.d = new i();
        this.d.a = new com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a.a();
        this.d.a((a) this);
        this.d.a((com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b) this);
        this.c.setAdapter(this.d);
        this.f.mLeft.setOnClickListener(new h(this));
        this.c.setLoadingListener(new i(this));
        this.a.b();
        i();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a.a(intent);
        i();
    }

    protected final void g() {
        super.g();
        this.a.e();
    }

    protected final void h() {
        super.h();
        this.a.f();
    }

    protected final void r_() {
        super.r_();
        this.a.g();
    }

    public final boolean a(IChatDialog iChatDialog, String str) {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b();
        return com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.a(this, iChatDialog, str);
    }

    public final boolean a(int i, String str) {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b();
        return com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.a(this, i, str);
    }

    public final void o_() {
        this.d.notifyDataSetChanged();
    }

    public final void b() {
        this.c.b();
    }

    public final void c() {
        this.c.a();
    }

    public final void p_() {
        XLToast.showToast(BrothersApplication.getApplicationInstance(), getString(R.string.personal_chat_dialogs_delete_dialog_fail));
    }

    public final void a(IChatDialog iChatDialog) {
        if (!this.e.isShowing()) {
            this.e.a = new j(this, iChatDialog);
            c.a();
            this.e.show();
        }
    }

    public final void d() {
        if (this.e.isShowing()) {
            this.e.dismiss();
        }
    }

    private void i() {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b.a aVar = new com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b.a();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("message_center_dispatch_info");
            if (serializableExtra instanceof MessageCenterDispatchInfo) {
                aVar.a = (MessageCenterDispatchInfo) serializableExtra;
                if (aVar.a.getTo() != 4) {
                    LoginHelper.a();
                    z = l.c();
                } else if (com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c() && com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a().b) {
                    z = true;
                }
            }
        }
        if (z && this != null) {
            if (intent != null) {
                String from = aVar.a.getFrom();
                int to = aVar.a.getTo();
                if (to != 6) {
                    switch (to) {
                        case 1:
                            a(MessageType.COMMENT, from);
                            return;
                        case 2:
                            a(MessageType.STAR, from);
                            break;
                        case 3:
                            a(MessageType.FOLLOW, from);
                            return;
                        case 4:
                            if (!a(aVar.a.getChatDialogId(), "push_click")) {
                                return;
                            }
                            break;
                        default:
                            break;
                    }
                    return;
                }
                a(MessageType.VISIT, from);
            }
        }
    }

    public final void f() {
        PersonalChatStrangersActivity.a((Context) this);
    }

    public final void a(MessageType messageType, String str) {
        if (messageType == MessageType.VISIT) {
            VisitActivity.a(this, LoginHelper.a().g.c(), str);
        } else {
            MessageCenterStableActivity.a(this, messageType);
        }
    }

    public void onBackPressed() {
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, MessageInfo.USER, null);
        }
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
        finish();
    }
}
