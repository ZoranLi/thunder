package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class AdService {
    protected static String channelId = "";
    protected static int instanceCount = -1;
    private AdView a;

    public static void setChannelId(String str) {
        channelId = str;
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setChannelId(str);
    }

    public AdService(Context context, ViewGroup viewGroup, LayoutParams layoutParams, AdViewListener adViewListener) {
        this(context, viewGroup, layoutParams, adViewListener, AdSize.Banner, "");
    }

    public AdService(Context context, ViewGroup viewGroup, LayoutParams layoutParams, AdViewListener adViewListener, AdSize adSize, String str) {
        if (!(context == null || viewGroup == null || layoutParams == null || adViewListener == null)) {
            if (adSize != null) {
                this.a = new AdView(context, false, adSize, str);
                this.a.setListener(adViewListener);
                a(viewGroup, layoutParams);
                instanceCount++;
                return;
            }
        }
        throw new IllegalArgumentException("One of arguments is null");
    }

    private void a(ViewGroup viewGroup, LayoutParams layoutParams) {
        try {
            if (this.a.getParent() != viewGroup) {
                if (this.a.getParent() != null) {
                    ((ViewGroup) this.a.getParent()).removeView(this.a);
                }
                viewGroup.addView(this.a, layoutParams);
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.a != null) {
            this.a.destroy();
            this.a = null;
        }
    }
}
