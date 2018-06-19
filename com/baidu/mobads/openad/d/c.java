package com.baidu.mobads.openad.d;

import android.net.Uri.Builder;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class c {
    public String a;
    public String b;
    public long c = 0;
    public String d = "text/plain";
    public int e = 1;
    private Builder f;

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getFixedString(this.a);
    }

    public Builder b() {
        return this.f;
    }

    public void a(Builder builder) {
        this.f = builder;
    }

    public void a(int i) {
        this.e = i;
    }
}
