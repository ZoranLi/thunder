package com.xunlei.downloadprovidershare.b;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovidershare.R;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: SharePlatformsDialog */
public final class d extends AlertDialog {
    public LinearLayout a;
    public b b;
    private int c = 1;
    private c d;
    private c e;
    private boolean f;

    /* compiled from: SharePlatformsDialog */
    private class a implements OnClickListener {
        final /* synthetic */ d a;
        private ShareOperationType b;

        public a(d dVar, ShareOperationType shareOperationType) {
            this.a = dVar;
            this.b = shareOperationType;
        }

        public final void onClick(View view) {
            if (this.a.b != null) {
                this.a.b.a(this.b);
            }
            if (this.b.isShouldProcessShareUrl() == null) {
                this.a.f = true;
            }
            this.a.dismiss();
        }
    }

    /* compiled from: SharePlatformsDialog */
    public interface b {
        void a(ShareOperationType shareOperationType);

        void a(boolean z);
    }

    public d(Context context, int i, c cVar, c cVar2) {
        super(context, R.style.SharePlatformStyle);
        this.c = i;
        this.d = cVar;
        this.e = cVar2;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        bundle = getContext();
        if (this.d != null) {
            if (!this.d.a.isEmpty()) {
                if (this.e != null) {
                    if (!this.e.a.isEmpty()) {
                        if (this.c == 2) {
                            this.a = (LinearLayout) LayoutInflater.from(bundle).inflate(R.layout.share_platform_player_dialog, null);
                            this.a.setOnClickListener(new f(this));
                        } else {
                            this.a = (LinearLayout) LayoutInflater.from(bundle).inflate(R.layout.share_platform_dialog, null);
                            this.a.findViewById(R.id.cancel).setOnClickListener(new g(this));
                        }
                        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.share_operation_layout);
                        a(this.c, (LinearLayout) this.a.findViewById(R.id.share_platfrom_layout), this.d);
                        a(this.c, linearLayout, this.e);
                        setContentView(this.a);
                        if (this.c == 2) {
                            getWindow().setGravity(17);
                            getWindow().getDecorView().setPadding(0, 0, 0, 0);
                        } else {
                            bundle = getWindow();
                            bundle.setGravity(80);
                            bundle.setWindowAnimations(R.style.bottom_dialog_animation);
                            LayoutParams attributes = getWindow().getAttributes();
                            attributes.width = -1;
                            attributes.height = -2;
                            attributes.dimAmount = 0.65f;
                            bundle.setAttributes(attributes);
                        }
                        setOnDismissListener(new e(this));
                        return;
                    }
                }
                throw new IllegalArgumentException("operationItems may not null!");
            }
        }
        throw new IllegalArgumentException("platformItems may not null!");
    }

    private void a(int i, LinearLayout linearLayout, c cVar) {
        int dip2px = DipPixelUtil.dip2px(17.0f);
        int dip2px2 = DipPixelUtil.dip2px(66.0f);
        int i2 = R.layout.share_platform_item;
        if (i == 2) {
            i2 = R.layout.share_platform_item_player;
        }
        int i3 = 1;
        for (b bVar : cVar.a.values()) {
            View inflate = LayoutInflater.from(getContext()).inflate(i2, null);
            inflate.setOnClickListener(new a(this, bVar.d));
            TextView textView = (TextView) inflate.findViewById(R.id.share_title);
            textView.setText(bVar.a);
            textView.setSingleLine(true);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.share_icon);
            if (TextUtils.isEmpty(bVar.c)) {
                imageView.setImageResource(bVar.b);
            } else {
                Glide.with(getContext()).load(bVar.c).diskCacheStrategy(DiskCacheStrategy.ALL).override(Integer.MIN_VALUE, Integer.MIN_VALUE).centerCrop().into(imageView);
            }
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px2, -2);
            layoutParams.gravity = 17;
            if (i3 != 0) {
                i3 = 0;
                layoutParams.leftMargin = DipPixelUtil.dip2px(13.0f);
            }
            layoutParams.rightMargin = dip2px;
            linearLayout.addView(inflate, layoutParams);
        }
    }
}
