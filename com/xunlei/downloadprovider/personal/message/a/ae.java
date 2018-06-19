package com.xunlei.downloadprovider.personal.message.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: MessageItemViewHolder */
public abstract class ae extends ViewHolder {
    public abstract void a(MessageInfo messageInfo);

    public ae(View view) {
        super(view);
    }

    protected final <T extends View> T c() {
        return this.itemView.findViewById(R.id.message_center_content_container);
    }

    static void a(String str, ImageView imageView) {
        b.a();
        b.a(str, imageView, R.drawable.xllive_avatar_default, R.drawable.xllive_avatar_default, R.drawable.xllive_avatar_default);
    }
}
