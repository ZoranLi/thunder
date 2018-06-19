package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.d;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent$IChatDateHeaderMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.MessagesList;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.PullToRefreshMessagesList;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.k;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.g;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.h;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.j;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.l;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.m;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.n;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.BaseMessageCenterFragment;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DialogContentFragment extends BaseMessageCenterFragment implements d, b, a {
    private a a = null;
    private PullToRefreshMessagesList b = null;
    private MessagesList c = null;
    private k<IChatMessage> d = null;
    private ChatDialogHeader e = null;
    private c f = null;
    private ChatDialogContentTopAlertViewContainer g = null;
    private XLAlertDialog h = null;
    private ErrorBlankView i = null;

    public static DialogContentFragment a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("chat_dialog_id", i);
        bundle.putString("chat_dialog_from", str);
        i = new DialogContentFragment();
        i.setArguments(bundle);
        return i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_personal_chat_content, null);
    }

    public final void a(@Nullable Bundle bundle) {
        super.a(bundle);
        this.a.a(getArguments());
        bundle = getView();
        this.b = (PullToRefreshMessagesList) bundle.findViewById(R.id.messagesList);
        this.c = (MessagesList) this.b.getRefreshableView();
        a(false);
        this.e = (ChatDialogHeader) bundle.findViewById(R.id.header);
        this.f = new c(getContext());
        this.g = (ChatDialogContentTopAlertViewContainer) bundle.findViewById(R.id.top_alert_view_container);
        this.h = new XLAlertDialog(getActivity());
        this.i = (ErrorBlankView) bundle.findViewById(R.id.error_view);
        this.i.setBackgroundColor(getResources().getColor(R.color.dialog_content_background));
        this.i.setVisibility(8);
        this.b.setOnRefreshListener(this);
        this.e.setOnHeaderClickListener(this);
        this.c.setOnTouchListener(new g(this));
        this.c.addOnLayoutChangeListener(new h(this));
        this.f.b = null;
        this.f.setOnDismissListener(new j(this));
        Context activity = getActivity();
        String valueOf = String.valueOf(com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a().a.userId());
        com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.d bVar = new com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.b();
        com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a a = new com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a().a(1, l.class, (int) R.layout.personal_chat_message_item_sent_text, h.class, (int) R.layout.personal_chat_message_item_received_text, bVar).a(1001, m.class, (int) R.layout.personal_chat_message_item_sent_video_website_comment_reply, i.class, (int) R.layout.personal_chat_message_item_received_video_website_comment_reply, bVar).a(1003, n.class, (int) R.layout.personal_chat_message_item_sent_video_website_comment_reply, j.class, (int) R.layout.personal_chat_message_item_received_video_website_comment_reply, bVar).a(1002, com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.k.class, (int) R.layout.personal_chat_message_item_sent_video_website_comment_reply, g.class, (int) R.layout.personal_chat_message_item_received_video_website_comment_reply, bVar);
        a.b = R.layout.personal_chat_message_item_date_header;
        this.d = new k(activity, valueOf, a, new k(this));
        this.d.f = 300000;
        this.d.e = new com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a.a();
        this.d.g = new l(this);
        this.c.setAdapter(this.d);
        this.a.b();
    }

    public final void k() {
        super.k();
        this.a.a();
    }

    public final void l() {
        super.l();
        this.a.c();
    }

    public final void m() {
        super.m();
        this.a.d();
    }

    public boolean onBackPressed() {
        this.a.e();
        return true;
    }

    public final void a(IChatDialog iChatDialog) {
        this.e.setChatDialog(iChatDialog);
        this.e.setFrom(this.a.f());
        iChatDialog = this.e;
        iChatDialog.b.setText(iChatDialog.a.getTitle());
    }

    public final void b(IChatDialog iChatDialog) {
        this.g.setChatDialog(iChatDialog);
        this.g.setFrom(this.a.f());
        iChatDialog = this.g;
        if (iChatDialog.b != null) {
            if (iChatDialog.b.isFollow()) {
                iChatDialog.removeAllViews();
                iChatDialog.setVisibility(8);
            } else {
                iChatDialog.a = new ChatDialogFollowAlertView(iChatDialog.getContext());
                iChatDialog.a.setOnAlertViewCloseListener(iChatDialog);
                iChatDialog.a.setChatDialog(iChatDialog.b);
                iChatDialog.a.setFrom(iChatDialog.c);
                iChatDialog.setSingleAlertView(iChatDialog.a);
                iChatDialog.setVisibility(0);
            }
        }
    }

    public final void a() {
        this.d.notifyDataSetChanged();
    }

    public final void a(List<IChatMessage> list, boolean z) {
        k kVar = this.d;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (kVar.a((IChatMessage) it.next())) {
                it.remove();
            }
        }
        int size = kVar.a.size();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                boolean a;
                IChatMessage iChatMessage = (IChatMessage) list.get(i);
                IChatMessage iChatMessage2 = (IChatMessage) list.get(i);
                IChatMessage iChatMessage3 = null;
                if (i != 0) {
                    iChatMessage3 = (IChatMessage) list.get(i - 1);
                } else if (!kVar.a.isEmpty()) {
                    c cVar = (c) kVar.a.get(0);
                    if ((cVar.a instanceof IChatMessage) && com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.j.a((IChatMessage) cVar.a) == PushResult.OFFLINE_DOWNLOAD_DONE) {
                        if (!kVar.a(DateFormatter.a(iChatMessage2), ((IChatMessageContent$IChatDateHeaderMessageContent) ((IChatMessage) cVar.a).messageContent()).date())) {
                            kVar.a.remove(0);
                            kVar.notifyItemRemoved(0);
                        }
                    } else {
                        new StringBuilder("wtf, firstMessage is not DateHeaderMessage. firstMessage.getSimpleName: ").append(cVar.a.getClass().getSimpleName());
                    }
                }
                if (iChatMessage2 != null) {
                    if (iChatMessage3 != null) {
                        a = kVar.a(DateFormatter.a(iChatMessage2), DateFormatter.a(iChatMessage3));
                        if (a) {
                            kVar.a.add(0, kVar.b(iChatMessage3));
                        }
                        kVar.a.add(0, new c(kVar, iChatMessage));
                    }
                }
                a = false;
                if (a) {
                    kVar.a.add(0, kVar.b(iChatMessage3));
                }
                kVar.a.add(0, new c(kVar, iChatMessage));
            }
            kVar.a.add(0, kVar.b((IChatMessage) list.get(list.size() - 1)));
        }
        list = kVar.a.size() - size;
        kVar.notifyDataSetChanged();
        if (kVar.c != null && z && (kVar.c instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) kVar.c).scrollToPositionWithOffset(list - 1, 0);
        }
    }

    public final void a(IChatMessage iChatMessage) {
        k kVar = this.d;
        if (!kVar.a(iChatMessage)) {
            int size = kVar.a.size();
            int i = size - 1;
            Date a = DateFormatter.a(iChatMessage);
            boolean z = false;
            if (kVar.a.isEmpty()) {
                z = true;
            } else if (kVar.a.size() > i) {
                if (i >= 0) {
                    if (((c) kVar.a.get(i)).a instanceof IChatMessage) {
                        z = kVar.a(a, DateFormatter.a((IChatMessage) ((c) kVar.a.get(i)).a));
                    }
                }
            }
            if (z) {
                kVar.a.add(kVar.b(iChatMessage));
            }
            kVar.a.add(new c(kVar, iChatMessage));
            kVar.notifyItemRangeInserted(size, z ? 2 : 1);
            if (kVar.c != null) {
                kVar.c.scrollToPosition(kVar.a.size() - 1);
            }
        }
    }

    public final void b(IChatMessage iChatMessage) {
        k kVar = this.d;
        int a = kVar.a(String.valueOf(iChatMessage.messageId()));
        if (a >= 0) {
            kVar.a.set(a, new c(kVar, iChatMessage));
            kVar.notifyItemChanged(a);
        }
    }

    public final void b() {
        if (this.d.getItemCount() > 0) {
            this.c.smoothScrollToPosition(this.d.getItemCount() - 1);
        }
    }

    public final void d() {
        this.b.onRefreshComplete();
    }

    public final void a(String str) {
        ClipboardManager clipboardManager = (ClipboardManager) getActivity().getSystemService("clipboard");
        str = ClipData.newPlainText(str, str);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(str);
        }
    }

    public final void e() {
        XLToast.showToast(BrothersApplication.getApplicationInstance(), getString(R.string.personal_chat_dialog_message_copied));
    }

    public final void i() {
        getActivity().onBackPressed();
    }

    public final void j() {
        this.a.h();
    }

    public final void c(IChatDialog iChatDialog) {
        if (!this.f.isShowing()) {
            c cVar = this.f;
            cVar.a = iChatDialog;
            cVar.a();
            this.f.c = this.a.f();
            this.f.showAsDropDown(this.e, (int) ((((float) AndroidConfig.getScreenWidth()) - getResources().getDimension(R.dimen.personal_chat_more_operation_width)) - 20.0f), 0);
            a(getActivity(), 0.6f);
        }
    }

    public final void c() {
        if (this.f.isShowing()) {
            this.f.dismiss();
        }
    }

    public final void a(PullToRefreshBase pullToRefreshBase) {
        IChatMessage iChatMessage;
        for (c cVar : this.d.a) {
            if ((cVar.a instanceof IChatMessage) && ((IChatMessage) cVar.a).creatorType() != 3 && ((IChatMessage) cVar.a).creatorType() != 0) {
                iChatMessage = (IChatMessage) cVar.a;
                break;
            }
        }
        iChatMessage = null;
        this.a.a(iChatMessage);
    }

    public final void a(IChatUser iChatUser, From from) {
        e.a(getActivity(), iChatUser, from);
    }

    public final void a(boolean z) {
        if (z) {
            this.b.setMode(Mode.PULL_FROM_START);
        } else {
            this.b.setMode(Mode.DISABLED);
        }
    }

    public final void f() {
        this.b.setVisibility(8);
        this.i.setErrorType(0);
        this.i.a(null, null);
        this.i.setVisibility(0);
    }

    public final void g() {
        this.b.setVisibility(0);
        this.i.setVisibility(8);
    }

    public final k<IChatMessage> h() {
        return this.d;
    }

    public final void c(IChatMessage iChatMessage) {
        this.h.setCancelable(true);
        this.h.setTitle((CharSequence) "提示");
        this.h.setMessage((CharSequence) "是否重新发送？");
        this.h.setCancelButtonText((CharSequence) "取消");
        this.h.setConfirmButtonText((CharSequence) "确认");
        this.h.setOnClickCancelButtonListener(new m(this));
        this.h.setOnClickConfirmButtonListener(new n(this, iChatMessage));
        this.h.show();
    }

    public static void a(Activity activity, float f) {
        LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f;
        activity.getWindow().addFlags(2);
        activity.getWindow().setAttributes(attributes);
    }
}
