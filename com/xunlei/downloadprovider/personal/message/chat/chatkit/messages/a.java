package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent$IChatDateHeaderMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter.Template;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.ChatHyperLinkHelper.NoUnderlineSpan;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: MessageHolders */
public final class a {
    Class<? extends a<IChatMessage, IChatMessageContent$IChatDateHeaderMessageContent>> a = f.class;
    public int b = R.layout.item_date_header;
    List<e> c = new ArrayList();
    d d;

    /* compiled from: MessageHolders */
    public interface d<MESSAGE extends IChatMessage> {
        boolean a(MESSAGE message, int i);
    }

    /* compiled from: MessageHolders */
    private static class e<TYPE extends IChatMessage, CONTENT extends IChatMessageContent> {
        int a;
        h<TYPE, CONTENT> b;
        h<TYPE, CONTENT> c;

        private e(int i, h<TYPE, CONTENT> hVar, h<TYPE, CONTENT> hVar2) {
            this.a = i;
            this.b = hVar;
            this.c = hVar2;
        }
    }

    /* compiled from: MessageHolders */
    interface g {
        void a(n nVar);
    }

    /* compiled from: MessageHolders */
    private class h<T extends IChatMessage, Z extends IChatMessageContent> {
        Class<? extends a<? extends T, ? extends Z>> a;
        int b;
        final /* synthetic */ a c;

        h(a aVar, Class<? extends a<? extends T, ? extends Z>> cls, int i) {
            this.c = aVar;
            this.a = cls;
            this.b = i;
        }
    }

    /* compiled from: MessageHolders */
    public static abstract class a<MESSAGE extends IChatMessage, CONTENT extends IChatMessageContent> extends com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c<MESSAGE> {
        protected Context a = null;
        protected com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.k.a<MESSAGE> b = null;
        boolean c;
        protected com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a d;
        protected ImageView e;
        protected MESSAGE f = null;

        public abstract void a(CONTENT content);

        public a(Context context, View view) {
            super(context, view);
            this.a = context;
            this.e = (ImageView) view.findViewById(R.id.messageUserAvatar);
        }

        @CallSuper
        public void a(MESSAGE message) {
            this.f = message;
        }

        protected final void a(TextView textView, com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.ChatHyperLinkHelper.b bVar) {
            Context context = this.a;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            CharSequence text = textView.getText();
            if (text instanceof Spannable) {
                Spannable spannable = (Spannable) textView.getText();
                URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, text.length(), URLSpan.class);
                if (uRLSpanArr.length != 0) {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(text);
                    for (URLSpan uRLSpan : uRLSpanArr) {
                        spannableStringBuilder.setSpan(new com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.ChatHyperLinkHelper.a(context, uRLSpan.getURL(), bVar), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 17);
                    }
                    textView.setText(spannableStringBuilder);
                }
            }
            bVar = textView.getText();
            if (bVar instanceof Spannable) {
                ((Spannable) textView.getText()).setSpan(new NoUnderlineSpan(), 0, bVar.length(), 17);
            }
        }
    }

    /* compiled from: MessageHolders */
    public static abstract class b<MESSAGE extends IChatMessage, CONTENT extends IChatMessageContent> extends a<MESSAGE, CONTENT> implements g {
        protected TextView g;
        protected ViewGroup h;

        public void a(CONTENT content) {
        }

        public b(Context context, View view) {
            super(context, view);
            this.g = (TextView) view.findViewById(R.id.messageTime);
            this.h = (ViewGroup) view.findViewById(R.id.bubble);
        }

        public void a(MESSAGE message) {
            super.a((IChatMessage) message);
            if (this.g != null) {
                this.g.setText(DateFormatter.a(new Date((long) (message.createdAt() * 1000)), Template.TIME));
            }
            if (this.h != null) {
                this.h.setSelected(this.c);
            }
            if (this.e != null) {
                int i = 0;
                int i2 = (this.d == null || message.sender().avatarUrl() == null) ? 0 : 1;
                ImageView imageView = this.e;
                if (i2 == 0) {
                    i = 8;
                }
                imageView.setVisibility(i);
                if (i2 != 0) {
                    this.d.a(this.e, message.sender().avatarUrl(), R.drawable.ic_default_avatar_new);
                }
            }
            if (this.e != null) {
                this.e.setOnClickListener(new b(this, message));
            }
            if (this.h != null) {
                this.h.setOnLongClickListener(new c(this, message));
            }
        }

        public void a(n nVar) {
            if (this.g != null) {
                this.g.setTextColor(nVar.n);
                this.g.setTextSize(0, (float) nVar.o);
                this.g.setTypeface(this.g.getTypeface(), nVar.p);
            }
            if (this.e != null) {
                this.e.getLayoutParams().width = nVar.g;
                this.e.getLayoutParams().height = nVar.h;
            }
        }
    }

    /* compiled from: MessageHolders */
    public static abstract class c<MESSAGE extends IChatMessage, CONTENT extends IChatMessageContent> extends a<MESSAGE, CONTENT> implements g {
        protected TextView g;
        protected ImageView h;
        protected ViewGroup i;

        public void a(CONTENT content) {
        }

        public c(Context context, View view) {
            super(context, view);
            this.g = (TextView) view.findViewById(R.id.messageTime);
            this.h = (ImageView) view.findViewById(R.id.messageSendStatusIcon);
            this.i = (ViewGroup) view.findViewById(R.id.bubble);
        }

        public void a(MESSAGE message) {
            super.a((IChatMessage) message);
            if (this.g != null) {
                this.g.setText(DateFormatter.a(DateFormatter.a((IChatMessage) message), Template.TIME));
            }
            if (this.e != null) {
                int i = (this.d == null || message.sender().avatarUrl() == null) ? 0 : 1;
                this.e.setVisibility(i != 0 ? 0 : 8);
                if (i != 0) {
                    this.d.a(this.e, message.sender().avatarUrl(), R.drawable.ic_default_avatar_new);
                }
            }
            if (this.i != null) {
                this.i.setSelected(this.c);
            }
            if (this.e != null) {
                this.e.setOnClickListener(new e(this, message));
            }
            if (this.i != null) {
                this.i.setOnLongClickListener(new f(this, message));
            }
            if (this.h != null) {
                switch (message.messageStatus()) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                        this.h.setVisibility(4);
                        break;
                    case 4:
                        this.h.setImageResource(R.drawable.icon_personal_chat_dialog_message_send_fail);
                        this.h.setVisibility(0);
                        break;
                    default:
                        break;
                }
            }
            if (this.h != null) {
                this.h.setOnClickListener(new d(this, message));
            }
        }

        public void a(n nVar) {
            if (this.g != null) {
                this.g.setTextColor(nVar.t);
                this.g.setTextSize(0, (float) nVar.u);
                this.g.setTypeface(this.g.getTypeface(), nVar.v);
            }
            if (this.e != null) {
                this.e.getLayoutParams().width = nVar.i;
                this.e.getLayoutParams().height = nVar.j;
            }
        }
    }

    /* compiled from: MessageHolders */
    public static class f extends a<IChatMessage, IChatMessageContent$IChatDateHeaderMessageContent> implements g {
        protected TextView g;
        protected String h;
        protected com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter.a i;

        public final /* synthetic */ void a(IChatMessageContent iChatMessageContent) {
            IChatMessageContent$IChatDateHeaderMessageContent iChatMessageContent$IChatDateHeaderMessageContent = (IChatMessageContent$IChatDateHeaderMessageContent) iChatMessageContent;
            if (this.g != null) {
                CharSequence charSequence = null;
                if (this.i != null) {
                    charSequence = this.i.b(iChatMessageContent$IChatDateHeaderMessageContent.date());
                }
                TextView textView = this.g;
                if (charSequence == null) {
                    charSequence = DateFormatter.a(iChatMessageContent$IChatDateHeaderMessageContent.date(), this.h);
                }
                textView.setText(charSequence);
            }
        }

        public f(Context context, View view) {
            super(context, view);
            this.g = (TextView) view.findViewById(R.id.messageText);
        }

        public final void a(IChatMessage iChatMessage) {
            super.a(iChatMessage);
        }

        public final void a(n nVar) {
            if (this.g != null) {
                this.g.setTextColor(nVar.y);
                this.g.setTextSize(0, (float) nVar.z);
                this.g.setTypeface(this.g.getTypeface(), nVar.A);
                this.g.setPadding(nVar.w, nVar.w, nVar.w, nVar.w);
                this.g.setBackgroundDrawable(nVar.c());
            }
            this.h = nVar.x;
            this.h = this.h == null ? Template.STRING_DAY_MONTH_YEAR.get() : this.h;
        }
    }

    /* compiled from: MessageHolders */
    public static class i<MESSAGE extends IChatMessage, CONTENT extends IChatMessageContent> extends b<MESSAGE, CONTENT> {
        protected TextView i;

        public i(Context context, View view) {
            super(context, view);
            this.i = (TextView) view.findViewById(R.id.messageText);
        }

        public final void a(n nVar) {
            super.a(nVar);
            if (this.i != null) {
                this.i.setTextColor(nVar.k);
                this.i.setTextSize(0, (float) nVar.l);
                this.i.setTypeface(this.i.getTypeface(), nVar.m);
                this.i.setAutoLinkMask(nVar.d);
                this.i.setLinkTextColor(nVar.e);
            }
            if (this.h != null) {
                this.h.setBackgroundDrawable(nVar.d());
            }
        }

        public void a(MESSAGE message) {
            super.a((IChatMessage) message);
            if (this.i != null) {
                this.i.setOnLongClickListener(new g(this, message));
            }
        }
    }

    /* compiled from: MessageHolders */
    public static class j<MESSAGE extends IChatMessage, CONTENT extends IChatMessageContent> extends c<MESSAGE, CONTENT> {
        protected TextView j;

        public j(Context context, View view) {
            super(context, view);
            this.j = (TextView) view.findViewById(R.id.messageText);
        }

        public final void a(n nVar) {
            super.a(nVar);
            if (this.j != null) {
                this.j.setTextColor(nVar.q);
                this.j.setTextSize(0, (float) nVar.r);
                this.j.setTypeface(this.j.getTypeface(), nVar.s);
                this.j.setAutoLinkMask(nVar.d);
                this.j.setLinkTextColor(nVar.f);
            }
            if (this.i != null) {
                this.i.setBackgroundDrawable(nVar.b());
            }
        }

        public void a(MESSAGE message) {
            super.a((IChatMessage) message);
            if (this.j != null) {
                this.j.setOnLongClickListener(new h(this, message));
            }
        }
    }

    public final <TYPE extends IChatMessage, CONTENT extends IChatMessageContent> a a(int i, @NonNull Class<? extends a<TYPE, CONTENT>> cls, @LayoutRes int i2, @NonNull Class<? extends a<TYPE, CONTENT>> cls2, @LayoutRes int i3, @NonNull d dVar) {
        if (i == 0) {
            throw new IllegalArgumentException("content type must be greater or less than '0'!");
        }
        this.c.add(new e(i, new h(this, cls, i2), new h(this, cls2, i3)));
        this.d = dVar;
        return this;
    }

    static void a(com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c cVar, Object obj, boolean z, com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a aVar, com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.k.a aVar2, com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter.a aVar3) {
        boolean z2 = obj instanceof IChatMessage;
        if (z2) {
            if (j.a((IChatMessage) obj) == PushResult.OFFLINE_DOWNLOAD_DONE) {
                ((f) cVar).i = aVar3;
            } else {
                a aVar4 = (a) cVar;
                aVar4.c = z;
                aVar4.d = aVar;
                aVar4.b = aVar2;
            }
        }
        cVar.a(obj);
        if ((cVar instanceof a) && z2) {
            ((a) cVar).a(((IChatMessage) obj).messageContent());
        }
    }

    static com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c a(Context context, ViewGroup viewGroup, h hVar, n nVar) {
        return a(context, viewGroup, hVar.b, hVar.a, nVar);
    }

    static <HOLDER extends com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c> com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c a(Context context, ViewGroup viewGroup, @LayoutRes int i, Class<HOLDER> cls, n nVar) {
        viewGroup = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        try {
            cls = cls.getDeclaredConstructor(new Class[]{Context.class, View.class});
            cls.setAccessible(true);
            com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c cVar = (com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c) cls.newInstance(new Object[]{context, viewGroup});
            if (!((cVar instanceof g) == null || nVar == null)) {
                ((g) cVar).a(nVar);
            }
            return cVar;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }
}
