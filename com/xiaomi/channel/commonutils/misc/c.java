package com.xiaomi.channel.commonutils.misc;

import java.util.Collection;

public class c {
    public static <T> boolean a(Collection<T> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
