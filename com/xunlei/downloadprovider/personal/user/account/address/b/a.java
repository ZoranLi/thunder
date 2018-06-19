package com.xunlei.downloadprovider.personal.user.account.address.b;

import java.text.Collator;
import java.util.Comparator;

/* compiled from: RegionComparator */
public final class a implements Comparator<String> {
    private Collator a = Collator.getInstance();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return this.a.getCollationKey((String) obj).compareTo(this.a.getCollationKey((String) obj2));
    }
}
