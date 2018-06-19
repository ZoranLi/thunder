package com.xunlei.common.new_ptl.member;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

public class XLHttpHeader implements Header {
    private String hName = null;
    private String hValue = null;

    public HeaderElement[] getElements() throws ParseException {
        return null;
    }

    public XLHttpHeader(String str, String str2) {
        this.hName = str;
        this.hValue = str2;
    }

    public String getName() {
        return this.hName;
    }

    public String getValue() {
        return this.hValue;
    }
}
