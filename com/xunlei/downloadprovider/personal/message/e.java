package com.xunlei.downloadprovider.personal.message;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.a.ae;
import com.xunlei.downloadprovider.personal.message.a.af;
import com.xunlei.downloadprovider.personal.message.a.ag;
import com.xunlei.downloadprovider.personal.message.a.an;
import com.xunlei.downloadprovider.personal.message.a.av;
import com.xunlei.downloadprovider.personal.message.a.ax;
import com.xunlei.downloadprovider.personal.message.a.az;
import com.xunlei.downloadprovider.personal.message.a.bb;
import com.xunlei.downloadprovider.personal.message.a.s;
import com.xunlei.downloadprovider.personal.message.a.y;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageItemAdapter */
public final class e extends Adapter<ae> {
    final List<MessageInfo> a = new ArrayList(1);
    private final a b;

    /* compiled from: MessageItemAdapter */
    public interface a {
        void a(int i, Object obj, boolean z);
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ae aeVar = (ae) viewHolder;
        i = (this.a == null || this.a.size() <= i) ? 0 : (MessageInfo) this.a.get(i);
        aeVar.a(i);
    }

    public e(a aVar) {
        this.b = aVar;
    }

    public final int getItemCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public final int getItemViewType(int i) {
        if (i >= this.a.size()) {
            return -1;
        }
        return ((MessageInfo) this.a.get(i)).getType();
    }

    public final void a(MessageInfo messageInfo) {
        if (!(this.a == null || this.a.size() == 0)) {
            if (messageInfo != null) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    if (this.a.get(size) == messageInfo) {
                        break;
                    }
                    size--;
                }
                size = -1;
                if (size >= 0) {
                    this.a.remove(size);
                    notifyItemRemoved(size);
                }
            }
        }
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != -1) {
            switch (i) {
                case 1:
                    return new ag(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_reply_item, viewGroup, false), this.b);
                case 2:
                    return new s(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_like_item, viewGroup, false), this.b);
                case 3:
                    return new com.xunlei.downloadprovider.personal.message.a.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_attention_item, viewGroup, false), this.b);
                case 4:
                    return new y(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_video_like_item, viewGroup, false), this.b);
                case 5:
                    return new an(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_video_reply_item, viewGroup, false), this.b);
                case 6:
                    return new ag(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_reply_item, viewGroup, false), this.b);
                case 7:
                    return new s(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_like_item, viewGroup, false), this.b);
                default:
                    switch (i) {
                        case 19:
                            return new az(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_comment_item_base, viewGroup, false), this.b);
                        case 20:
                            return new bb(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_like_item_base, viewGroup, false), this.b);
                        case 21:
                            return new ax(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_comment_item_base, viewGroup, false), this.b);
                        case 22:
                            return new av(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_like_item_base, viewGroup, false), this.b);
                        default:
                            StringBuilder stringBuilder = new StringBuilder("can not display invalid viewType: ");
                            stringBuilder.append(i);
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
            }
        }
        viewGroup = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.common_pull_up_refresh_item, null);
        viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        return new af(viewGroup);
    }
}
