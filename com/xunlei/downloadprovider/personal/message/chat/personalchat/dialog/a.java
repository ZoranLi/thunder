package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.k;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import java.util.List;

/* compiled from: IDialogContract */
public interface a {

    /* compiled from: IDialogContract */
    public interface a extends com.xunlei.downloadprovider.personal.message.chat.personalchat.a {
        void a();

        void a(int i, IChatMessage iChatMessage);

        void a(Bundle bundle);

        void a(@Nullable IChatMessage iChatMessage);

        void b(IChatMessage iChatMessage);

        void c();

        void c(IChatMessage iChatMessage);

        void d();

        void e();

        String f();

        void g();

        void h();
    }

    /* compiled from: IDialogContract */
    public interface b extends com.xunlei.downloadprovider.personal.message.chat.personalchat.b<a> {
        void a();

        void a(IChatDialog iChatDialog);

        void a(IChatMessage iChatMessage);

        void a(IChatUser iChatUser, From from);

        void a(String str);

        void a(List<IChatMessage> list, boolean z);

        void a(boolean z);

        void b();

        void b(IChatDialog iChatDialog);

        void b(IChatMessage iChatMessage);

        void c();

        void c(IChatDialog iChatDialog);

        void c(IChatMessage iChatMessage);

        void d();

        void e();

        void f();

        void g();

        k<IChatMessage> h();
    }

    /* compiled from: IDialogContract */
    public interface c extends com.xunlei.downloadprovider.personal.message.chat.personalchat.a {
        void a();

        void a(Bundle bundle);

        boolean a(IChatMessage iChatMessage);

        boolean a(String str);

        void c();

        void d();
    }

    /* compiled from: IDialogContract */
    public interface d extends com.xunlei.downloadprovider.personal.message.chat.personalchat.b<c> {
        void a();

        void a(@StringRes int i);

        void a(String str);

        void b();

        void c();
    }
}
