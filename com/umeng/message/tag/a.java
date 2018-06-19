package com.umeng.message.tag;

import com.umeng.message.common.UmLog;

/* compiled from: TagLengthFilter */
public class a implements TagFilter {
    private static final String a = "com.umeng.message.tag.a";
    private static int b = 256;

    public boolean filter(String str) {
        if (str != null) {
            if (!"".equals(str.trim())) {
                if (str == null || str.length() <= b) {
                    return true;
                }
                UmLog.e(a, String.format("The length of %s exceeds allowed max length %i", new Object[]{str, Integer.valueOf(b)}));
                return false;
            }
        }
        return false;
    }
}
