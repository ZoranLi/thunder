package com.xunlei.tdlive.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.modal.b;
import com.xunlei.tdlive.modal.d;
import com.xunlei.tdlive.sdk.R;

public class LiveListPKBannerView extends FrameLayout implements OnClickListener, com.xunlei.tdlive.modal.d.a {
    private LinearLayout a;
    private TextView b;
    private a c;

    public interface a {
        void a();

        void a(JsonWrapper jsonWrapper);

        void a(boolean z);
    }

    public LiveListPKBannerView(@NonNull Context context) {
        super(context);
        a(context);
        setOnClickListener(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a().a((com.xunlei.tdlive.modal.d.a) this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a().b(this);
    }

    public void setPKBannerCallback(a aVar) {
        this.c = aVar;
    }

    private void a(Context context) {
        inflate(context, R.layout.xllive_livelist_common_banner_view, this);
        this.a = (LinearLayout) com.xunlei.tdlive.base.d.a((View) this, R.id.extra);
        this.b = (TextView) com.xunlei.tdlive.base.d.a((View) this, R.id.desc);
        this.b.setText(b.c[1]);
    }

    public void onDataChanged(JsonWrapper jsonWrapper) {
        a(jsonWrapper);
    }

    private void a(JsonWrapper jsonWrapper) {
        if (this.c != null) {
            this.c.a(jsonWrapper.getLength() > 0);
        }
        if (jsonWrapper.getLength() > 0) {
            this.a.removeAllViews();
            int i = 0;
            while (i < 3 && i < jsonWrapper.getLength()) {
                String string = jsonWrapper.getObject(i, "{}").getObject("userinfo", "{}").getString("avatar", "");
                jsonWrapper.getObject(i, "{}").getInt("status", 0);
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.xllive_livelist_liveuser_item, this.a, false);
                inflate.setTag(jsonWrapper.getObject(i, "{}"));
                inflate.setOnClickListener(this);
                com.xunlei.tdlive.util.b.a(this.a.getContext()).a((ImageView) com.xunlei.tdlive.base.d.a(inflate, R.id.head_image), string);
                ImageView imageView = (ImageView) com.xunlei.tdlive.base.d.a(inflate, R.id.experience_grade_image);
                imageView.setImageResource(R.drawable.xllive_living);
                imageView.setVisibility(8);
                this.a.addView(inflate);
                i++;
            }
        }
    }

    public void onClick(View view) {
        if (this.c != null) {
            if (view == this) {
                this.c.a();
                return;
            }
            this.c.a((JsonWrapper) view.getTag());
        }
    }
}
