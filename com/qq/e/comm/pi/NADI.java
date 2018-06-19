package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import java.util.List;

public interface NADI {
    void loadAd(int i);

    void setBrowserType(int i);

    void setCategories(List<String> list);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);
}
