package com.xunlei.downloadprovider.download.giftdispatch.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.discovery.kuainiao.d;
import com.xunlei.downloadprovider.download.giftdispatch.a.a;
import com.xunlei.downloadprovider.download.giftdispatch.utils.GiftDispatchingReporter;
import com.xunlei.downloadprovider.download.giftdispatch.utils.GiftDispatchingReporter.ClickIdType;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.personal.redenvelope.g;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.RedEnvelopesDetailActivity;

public class DispatchingItemView extends FrameLayout {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    private View e;
    private a f;
    private boolean g;
    private boolean h;
    private OnClickListener i = new a(this);
    private g.a j = new b(this);

    public DispatchingItemView(Context context) {
        super(context);
        a(context);
    }

    public DispatchingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DispatchingItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.e = LayoutInflater.from(context).inflate(R.layout.gift_dispatching_item_layout, null);
        this.a = (ImageView) this.e.findViewById(R.id.iv_gift_icon);
        this.b = (TextView) this.e.findViewById(R.id.tv_gift_name);
        this.c = (TextView) this.e.findViewById(R.id.tv_tip_use);
        this.d = (TextView) this.e.findViewById(R.id.tv_item_divider);
        this.c.setOnClickListener(this.i);
        this.e.setOnClickListener(this.i);
        addView(this.e);
    }

    public void setGiftItemData(a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        this.f = aVar;
        this.b.setText(aVar.i);
        if (TextUtils.isEmpty(aVar.j)) {
            this.c.setText("立即使用");
        } else {
            this.c.setText(aVar.j);
        }
        this.d.setVisibility(aVar.n ? 0 : 4);
        setGiftItemIconFromUrl(aVar.b);
        GiftDispatchingReporter.a(aVar.d, aVar.m);
    }

    private void setGiftItemIconFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.setVisibility(8);
        } else {
            Glide.with(getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(this.a);
        }
    }

    private void a() {
        RedEnvelopesDetailActivity.a(getContext(), this.f.a, "dlcenter_list_packet");
    }

    static /* synthetic */ void a(DispatchingItemView dispatchingItemView) {
        GiftDispatchingReporter.a(dispatchingItemView.f.d, dispatchingItemView.f.m, ClickIdType.VIEW);
        switch (dispatchingItemView.f.k) {
            case 0:
                dispatchingItemView.a();
                return;
            case 1:
                if (dispatchingItemView.f.d == 3) {
                    if (!TextUtils.isEmpty(dispatchingItemView.f.o)) {
                        d.a();
                        d.a(dispatchingItemView.getContext(), dispatchingItemView.f.o);
                    }
                    return;
                }
                g.a(dispatchingItemView.getContext(), dispatchingItemView.f.c);
                return;
            case 3:
                if (!(dispatchingItemView.f.d == 11 || dispatchingItemView.f.d == 12)) {
                    if (dispatchingItemView.f.d != 13) {
                        if (dispatchingItemView.f.d == 8) {
                            g.b(dispatchingItemView.getContext(), "v_an_shoulei_push_xz_ec");
                            return;
                        } else {
                            g.a(dispatchingItemView.getContext(), PayFrom.DOWNLOAD_TASK_RED_PACKET, dispatchingItemView.f.g, dispatchingItemView.f.i);
                            return;
                        }
                    }
                }
                g.a(dispatchingItemView.getContext(), PayFrom.DOWNLOAD_TASK_RED_PACKET, dispatchingItemView.f.g, dispatchingItemView.f.d);
                return;
            case 4:
                if (!dispatchingItemView.h) {
                    dispatchingItemView.h = true;
                    g.a(dispatchingItemView.j);
                    return;
                }
                break;
            case 5:
                dispatchingItemView.a();
                return;
            default:
                dispatchingItemView.a();
                break;
        }
    }

    static /* synthetic */ void a(DispatchingItemView dispatchingItemView, String str) {
        if (!TextUtils.isEmpty(str)) {
            Activity activity = (Activity) dispatchingItemView.getContext();
            if (activity != null) {
                if (!activity.isFinishing()) {
                    activity.runOnUiThread(new d(dispatchingItemView, str));
                }
            }
        }
    }

    static /* synthetic */ void c(DispatchingItemView dispatchingItemView) {
        if (dispatchingItemView.g) {
            ((Activity) dispatchingItemView.getContext()).runOnUiThread(new c(dispatchingItemView));
            return;
        }
        g.a(dispatchingItemView.j);
        dispatchingItemView.g = true;
    }
}
