package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.MessageInput;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.MessageInput.a;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.MessageInput.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.d;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.BaseMessageCenterFragment;

public class DialogTransmitterFragment extends BaseMessageCenterFragment implements a, b, d {
    private c a = null;
    private MessageInput b;
    private InputMethodManager c = null;

    public boolean onBackPressed() {
        return true;
    }

    public static DialogTransmitterFragment a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("chat_dialog_id", Integer.valueOf(i));
        bundle.putString("chat_dialog_from", str);
        i = new DialogTransmitterFragment();
        i.setArguments(bundle);
        return i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_personal_chat_transimitter, null);
    }

    public final void a(@Nullable Bundle bundle) {
        super.a(bundle);
        this.a.a(getArguments());
        this.b = (MessageInput) getView().findViewById(R.id.input);
        this.c = (InputMethodManager) getActivity().getSystemService("input_method");
        this.b.setInputListener(this);
        this.b.getInputEditText().setOnClickListener(new p(this));
        this.a.b();
    }

    public final boolean a(CharSequence charSequence) {
        if ((r.a().a(getActivity(), LoginFrom.PERSONAL_COMMUNITY_CHAT, new o(this, charSequence)) ^ 1) == 0 || this.a.a(charSequence.toString()) == null) {
            return null;
        }
        return true;
    }

    public final void a() {
        this.b.getInputEditText().setHint(R.string.personal_chat_disabled);
    }

    public final void b() {
        this.b.getInputEditText().setKeyListener(null);
    }

    public final void a(@StringRes int i) {
        XLToast.showToast(BrothersApplication.getApplicationInstance(), getString(i));
    }

    public final void a(String str) {
        XLToast.showToast(BrothersApplication.getApplicationInstance(), str);
    }

    public final void c() {
        if (this.mActivity.getCurrentFocus() != null && this.mActivity.getCurrentFocus().getWindowToken() != null && this.mActivity.getWindow().getAttributes().softInputMode != 2 && getActivity().getCurrentFocus() != null) {
            this.c.hideSoftInputFromWindow(this.b.getInputEditText().getWindowToken(), 0);
        }
    }

    public final void m() {
        super.m();
        this.a.d();
    }
}
