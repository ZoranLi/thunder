package com.xunlei.tdlive.route;

public class RouteDispatcher extends BaseRouteDispatcher {
    private static RouteDispatcher a;

    public static RouteDispatcher getInstance() {
        if (a == null) {
            synchronized (RouteDispatcher.class) {
                if (a == null) {
                    a = new RouteDispatcher();
                }
            }
        }
        return a;
    }
}
