package com.qq.e.comm.pi;

import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;

public interface NEADVI {
    void destroy();

    void render();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);

    void setBrowserType(int i);
}
