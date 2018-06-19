package com.xunlei.downloadprovider.personal.message.chat.personalchat;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: IDialogListContract */
public interface d {

    /* compiled from: IDialogListContract */
    public interface a extends a {
        void a(IChatDialog iChatDialog);

        void a(com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar);

        void b(com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* compiled from: IDialogListContract */
    public interface b<T extends a> extends b<T> {
        void a(IChatDialog iChatDialog);

        boolean a(int i, String str);

        boolean a(IChatDialog iChatDialog, String str);

        void b();

        void c();

        void d();

        void o_();

        void p_();
    }
}
