package com.ut.mini.core.sign;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.j;

public class UTBaseRequestAuthentication implements IUTRequestAuthentication {
    private String Y = null;
    private String b = null;

    public String getAppkey() {
        return this.b;
    }

    public String getAppSecret() {
        return this.Y;
    }

    public UTBaseRequestAuthentication(String str, String str2) {
        this.b = str;
        this.Y = str2;
    }

    public String getSign(String str) {
        if (this.b != null) {
            if (this.Y != null) {
                if (str == null) {
                    return null;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.Y);
                return j.a(j.c(stringBuilder.toString().getBytes()));
            }
        }
        i.b("UTBaseRequestAuthentication", "There is no appkey,please check it!");
        return null;
    }
}
