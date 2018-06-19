package com.qihoo360.replugin.model;

import java.util.Comparator;

/* compiled from: PluginInfo */
final class b implements Comparator<PluginInfo> {
    b() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        long versionValue = ((PluginInfo) obj).getVersionValue() - ((PluginInfo) obj2).getVersionValue();
        if (versionValue > 0) {
            return 1;
        }
        return versionValue < 0 ? -1 : null;
    }
}
