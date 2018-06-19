package com.xunlei.tdlive.route;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseRouteDispatcher {
    private ArrayList<IXLLiveRoute> a = new ArrayList();

    public void addXLLiveRoute(IXLLiveRoute iXLLiveRoute) {
        if (iXLLiveRoute != null) {
            this.a.add(iXLLiveRoute);
        }
    }

    public void removeXLLiveRoute(IXLLiveRoute iXLLiveRoute) {
        if (iXLLiveRoute != null) {
            this.a.remove(iXLLiveRoute);
        }
    }

    public boolean dispatch(String str, String str2) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            try {
                if (((IXLLiveRoute) it.next()).dispatch(str, str2)) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
