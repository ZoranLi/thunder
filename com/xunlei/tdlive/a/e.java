package com.xunlei.tdlive.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.xunlei.tdlive.a.c.a;
import com.xunlei.tdlive.control.RoundImageView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.protocol.XLLiveGetBannerRequest;
import com.xunlei.tdlive.protocol.XLLiveGetCategoryBannerRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.b;

/* compiled from: LiveListBannerAdapter */
public class e extends d<String> {
    private int b;
    private int c;
    private String d;

    protected void a(int i, View view) {
    }

    public e(int i, a aVar, int i2) {
        this.a = aVar;
        this.b = i2;
        this.c = i;
    }

    public void a(final String str, boolean z, boolean z2) {
        if (a()) {
            if (this.a) {
                this.a.a(str, false, false);
            }
            switch (this.c) {
                case false:
                    new XLLiveGetBannerRequest().send((JsonCallBack) new JsonCallBack(this) {
                        final /* synthetic */ e b;

                        public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                            if (i == 0 && jsonWrapper != null) {
                                this.b.a((JsonWrapper) jsonWrapper.getArray("data", "[]"));
                            }
                            if (this.b.a != 0) {
                                this.b.a.a(str, true, false);
                            }
                            this.b.b();
                        }
                    });
                    return;
                case true:
                    new XLLiveGetCategoryBannerRequest(this.d).send((JsonCallBack) new JsonCallBack(this) {
                        final /* synthetic */ e b;

                        public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                            if (i == 0 && jsonWrapper != null) {
                                this.b.a((JsonWrapper) jsonWrapper.getArray("data", "[]"));
                            }
                            if (this.b.a != 0) {
                                this.b.a.a(str, true, false);
                            }
                            this.b.b();
                        }
                    });
                    return;
                default:
                    if (this.a) {
                        this.a.a(str, true, false);
                    }
                    b();
                    return;
            }
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view = new RoundImageView(viewGroup.getContext());
        view.setScaleType(ScaleType.CENTER_CROP);
        view.setBackgroundColor(-1578257);
        view.setId(i);
        view.setType(1);
        view.setBorderRadius(this.b);
        i = a(i);
        if (i != 0) {
            b.a(viewGroup.getContext()).a(view, i.getString("image", ""), b.a(viewGroup.getContext(), R.drawable.xllive_default_banner));
        }
        return view;
    }
}
