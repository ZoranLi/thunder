package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.h.b;

public class VideoAdView extends RelativeLayout {
    private b a;
    private IOAdEventListener b = new v(this);
    private VideoAdViewListener c;

    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        
        private int a;

        private VideoDuration(int i) {
            this.a = i;
        }

        protected final int getValue() {
            return this.a;
        }
    }

    public enum VideoSize {
        SIZE_16x9(320, 180),
        SIZE_4x3(400, 300);
        
        private int a;
        private int b;

        private VideoSize(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        protected final int getWidth() {
            return this.a;
        }

        protected final int getHeight() {
            return this.b;
        }
    }

    public VideoAdView(Context context) {
        super(context);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
    }

    public void requestAd(VideoAdRequest videoAdRequest) {
        this.a = new b(getContext(), "TODO");
        this.a.setActivity(getContext());
        this.a.setAdSlotBase(this);
        this.a.addEventListener(IXAdEvent.AD_CLICK_THRU, this.b);
        this.a.addEventListener(IXAdEvent.AD_LOADED, this.b);
        this.a.addEventListener(IXAdEvent.AD_STARTED, this.b);
        this.a.addEventListener(IXAdEvent.AD_STOPPED, this.b);
        this.a.addEventListener(IXAdEvent.AD_ERROR, this.b);
        this.a.request();
    }

    public void startVideo() {
        this.a.start();
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.c = videoAdViewListener;
    }
}
