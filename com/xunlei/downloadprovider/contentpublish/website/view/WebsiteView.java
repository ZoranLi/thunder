package com.xunlei.downloadprovider.contentpublish.website.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.contentpublish.website.bg;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.b;

public class WebsiteView extends FrameLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private int d = d.a().b.r();

    public WebsiteView(@NonNull Context context) {
        super(context);
        a(context, null);
    }

    public WebsiteView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public WebsiteView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.WebsiteView);
        attributeSet = context.getBoolean(0, false);
        context.recycle();
        if (attributeSet != null) {
            this.d = 1;
        }
        context = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        this.a = (ImageView) context.findViewById(R.id.iv_res);
        this.b = (TextView) context.findViewById(R.id.tv_link_title);
        this.c = (TextView) context.findViewById(R.id.tv_link_url);
    }

    public final void a(WebsiteInfo websiteInfo) {
        int i = R.drawable.website_icon_default_square;
        if (websiteInfo == null) {
            bg.a(this.a, "", 0, 0);
            this.a.setImageResource(R.drawable.website_icon_default_square);
            this.b.setText("该链接已删除");
            this.c.setVisibility(8);
            return;
        }
        this.b.setText(websiteInfo.e);
        this.c.setVisibility(0);
        if (this.d != 3) {
            this.c.setText(websiteInfo.f);
        } else {
            TextView textView = this.c;
            StringBuilder stringBuilder = new StringBuilder("来自：");
            stringBuilder.append(websiteInfo.f);
            textView.setText(stringBuilder.toString());
        }
        if (this.d != 2) {
            if (this.d != 3) {
                if (!bg.a(this.a, websiteInfo.g, websiteInfo.h, websiteInfo.i)) {
                    i = R.drawable.ic_website_default_vertical_pic;
                }
                b.a().a(getContext(), this.a, websiteInfo.g, i);
                return;
            }
        }
        bg.b(this.a, websiteInfo.g, websiteInfo.h, websiteInfo.i);
        b.a().a(getContext(), this.a, websiteInfo.g, R.drawable.website_icon_default_square_1);
    }

    private int getLayoutId() {
        switch (this.d) {
            case 2:
                return R.layout.website_view_2;
            case 3:
                return R.layout.website_view_3;
            default:
                return R.layout.website_view;
        }
    }
}
