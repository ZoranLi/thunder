package com.xunlei.downloadprovider.frame;

import android.os.Bundle;
import com.xunlei.downloadprovider.discovery.DiscoveryFragment;
import com.xunlei.downloadprovider.frame.view.a;
import com.xunlei.downloadprovider.homepage.HomeFragment;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.tdlive.XLLiveFragment;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MainTabFragmentBuilder */
public final class aa extends a {
    Map<String, BaseFragment> a = null;

    public final BaseFragment a(String str, Bundle bundle) {
        BaseFragment a = a(str);
        if (a == null) {
            if (str.equals("thunder")) {
                a = new HomeFragment();
                a(str, a);
            } else if (str.equals("xllive")) {
                a = new XLLiveFragment();
                a(str, a);
            } else if (str.equals("find")) {
                a = new DiscoveryFragment();
                a(str, a);
            } else if (str.equals(MessageInfo.USER)) {
                a = new UserCenterFragment();
                a(str, a);
            } else {
                a = null;
            }
        }
        if (!(a == null || bundle == null)) {
            a.setExtras(bundle);
        }
        return a;
    }

    private void a(String str, BaseFragment baseFragment) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, baseFragment);
    }

    public final BaseFragment a(String str) {
        if (this.a == null) {
            return null;
        }
        return (BaseFragment) this.a.get(str);
    }
}
