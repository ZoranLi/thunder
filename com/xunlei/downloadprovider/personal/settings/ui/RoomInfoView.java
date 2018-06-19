package com.xunlei.downloadprovider.personal.settings.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.data.CooperationScene;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.cooperation.ui.b;

public class RoomInfoView extends FrameLayout implements OnClickListener {
    public TextView a;
    public TextView b;
    private TextView c;
    private TextView d;
    private CooperationItem e;
    private CooperationScene f;

    public RoomInfoView(Context context) {
        super(context);
        a(context);
    }

    public RoomInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.room_info_view, this);
        this.b = (TextView) context.findViewById(R.id.tv_total);
        this.a = (TextView) context.findViewById(R.id.tv_remain);
        this.c = (TextView) context.findViewById(R.id.tv_has_clean);
        this.d = (TextView) context.findViewById(R.id.tv_deep_clean);
        this.e = c.a().a(2);
        this.f = c.a().b(1013);
        if (this.e != null) {
            if (TextUtils.isEmpty(this.e.getCopyWriting()) == null) {
                this.d.setVisibility(0);
                this.d.setText(this.e.getCopyWriting());
                this.d.setOnClickListener(this);
                a.a(l.c(this.e.getDisplayLocation()), this.e.getAppPackageName(), this.e.isShowInstallTip());
                if (this.f == null && TextUtils.isEmpty(this.f.getDescription()) == null) {
                    this.c.setVisibility(0);
                    this.c.setText(this.f.getDescription());
                    return;
                }
                this.c.setVisibility(8);
            }
        }
        this.d.setVisibility(8);
        if (this.f == null) {
        }
        this.c.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_deep_clean) {
            if (this.e != null) {
                b.a().a(getContext(), this.e, "");
            }
        }
    }
}
