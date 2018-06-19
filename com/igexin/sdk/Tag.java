package com.igexin.sdk;

import java.io.Serializable;

public class Tag implements Serializable {
    private String a;

    private boolean a(String str) {
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if ((charAt < '一' || charAt > '龥') && ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-' || charAt == '*' || charAt == '_' || charAt == ' ')))) {
                if (charAt != ':') {
                    z = false;
                    if (z) {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                break;
            }
        }
        return z;
    }

    public String getName() {
        return this.a;
    }

    public boolean isValidTagValue(String str) {
        return a(str);
    }

    public void setName(String str) {
        this.a = str;
    }
}
