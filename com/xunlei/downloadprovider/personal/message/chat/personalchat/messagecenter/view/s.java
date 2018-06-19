package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.o;

/* compiled from: MessageCenterVisitViewHolder */
public final class s extends r<o> {
    protected View a = null;
    protected ImageView b = null;
    protected TextView c = null;
    protected TextView d = null;
    private TextView e = null;
    private ImageView f = null;

    public final /* synthetic */ void a(b bVar) {
        o oVar = (o) bVar;
        this.b.setImageResource(o.a().intValue());
        this.c.setText(oVar.getTitle());
        this.e.setText(this.h.getString(R.string.message_center_visit_read_count, new Object[]{j.a((long) (oVar.b - oVar.getUnreadCount()))}));
        int i = 8;
        this.e.setVisibility(oVar.b - oVar.getUnreadCount() > 0 ? 0 : 8);
        int unreadCount = oVar.getUnreadCount();
        this.d.setText(this.h.getString(R.string.message_center_visit_unread_count, new Object[]{j.a((long) unreadCount)}));
        TextView textView = this.d;
        if (unreadCount > 0) {
            i = 0;
        }
        textView.setVisibility(i);
        this.f.setVisibility(unreadCount > 0 ? 0 : 4);
        if (oVar.b <= 0) {
            this.e.setText(this.h.getString(R.string.message_center_visit_no_count));
            this.e.setVisibility(0);
        }
        StringBuilder stringBuilder = new StringBuilder("readCount: ");
        stringBuilder.append(oVar.b - oVar.getUnreadCount());
        stringBuilder.append(" + unreadCount");
        stringBuilder.append(oVar.getUnreadCount());
    }

    public s(View view) {
        super(view);
        this.a = view.findViewById(R.id.root_view);
        this.b = (ImageView) view.findViewById(R.id.iv_avatar);
        this.c = (TextView) view.findViewById(R.id.tv_name);
        this.e = (TextView) view.findViewById(R.id.tv_read_count);
        this.d = (TextView) view.findViewById(R.id.tv_unread_count);
        this.f = (ImageView) view.findViewById(R.id.iv_unread_point);
    }
}
