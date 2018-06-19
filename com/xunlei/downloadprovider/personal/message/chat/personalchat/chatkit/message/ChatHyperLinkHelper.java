package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import com.xunlei.downloadprovider.R;

public final class ChatHyperLinkHelper {

    public static class NoUnderlineSpan extends UnderlineSpan {
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public static class a extends ClickableSpan {
        private Context a;
        private String b;
        private b c;

        public a(Context context, String str, b bVar) {
            this.a = context;
            this.b = str;
            this.c = bVar;
        }

        public static void a(View view) {
            view.setTag(R.id.tag_key_has_already_long_clicked, "longClicked");
        }

        public final void onClick(View view) {
            if ((view.getTag(R.id.tag_key_has_already_long_clicked) != null ? 1 : null) != null) {
                view.setTag(R.id.tag_key_has_already_long_clicked, null);
                return;
            }
            if (this.c != null) {
                this.c.onClick(this.b);
            }
        }
    }

    public interface b {
        void onClick(String str);
    }
}
