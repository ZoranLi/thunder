package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.view;

import android.app.Activity;
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
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.BaseMessageCenterActivity;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.n;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.c;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;

public class PersonalChatStrangersActivity extends BaseMessageCenterActivity implements a<b>, com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b<b>, com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.b {
    private com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.a a = null;
    private XRecyclerView c = null;
    private c d = null;
    private com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.c e = null;
    private TitleBar f = null;
    private ErrorBlankView g = null;

    public final /* synthetic */ void b(Object obj) {
        this.a.a((b) obj);
    }

    public final /* synthetic */ void c(Object obj) {
        this.a.b((b) obj);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, PersonalChatStrangersActivity.class));
    }

    protected final void a(Bundle bundle) {
        super.a(bundle);
        setContentView(R.layout.activity_personal_chat_strangers);
        this.a = new com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.b.a(this, new com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.b());
        this.f = new TitleBar((Activity) this);
        this.f.mTitle.setText("打招呼");
        this.g = (ErrorBlankView) findViewById(R.id.error_view);
        this.c = (XRecyclerView) findViewById(R.id.pull_to_refresh_recycler_view);
        this.c.setPullRefreshEnabled(com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c());
        this.c.setLoadingMoreEnabled(com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c());
        bundle = new LinearLayoutManager(this, 1, false);
        ItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        this.c.setLayoutManager(bundle);
        this.c.setItemAnimator(defaultItemAnimator);
        this.c.addItemDecoration(new n());
        this.e = new com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.c(this);
        this.d = new c();
        this.d.a = new com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a.a();
        this.d.a((a) this);
        this.d.a((com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b) this);
        this.c.setAdapter(this.d);
        this.f.mLeft.setOnClickListener(new b(this));
        this.c.setLoadingListener(new c(this));
        this.a.b();
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
            this.e.a = new d(this, iChatDialog);
            com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a();
            this.e.show();
        }
    }

    public final void d() {
        if (this.e.isShowing()) {
            this.e.dismiss();
        }
    }

    public final void f() {
        this.c.setVisibility(8);
        this.g.setErrorType(0);
        this.g.a(null, null);
        this.g.setVisibility(0);
    }

    public final void i() {
        this.c.setVisibility(0);
        this.g.setVisibility(8);
    }
}
