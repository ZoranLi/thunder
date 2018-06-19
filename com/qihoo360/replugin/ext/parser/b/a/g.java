package com.qihoo360.replugin.ext.parser.b.a;

import com.xiaomi.mipush.sdk.Constants;

/* compiled from: XmlNodeEndTag */
public final class g {
    public String a;
    public String b;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("</");
        if (this.a != null) {
            stringBuilder.append(this.a);
            stringBuilder.append(Constants.COLON_SEPARATOR);
        }
        stringBuilder.append(this.b);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
