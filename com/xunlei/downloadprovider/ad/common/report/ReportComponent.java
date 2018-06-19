package com.xunlei.downloadprovider.ad.common.report;

import com.xunlei.downloadprovider.ad.common.adget.b$a;
import com.xunlei.downloadprovider.ad.common.b.a;
import com.xunlei.xllib.b.d;

public abstract class ReportComponent implements g {
    protected String J = null;

    public static class DeepLinkException extends Exception {
        public static final int LANDING_ERROR_CODE_DEEP_LINK_CAN_NOT_RESOLVE = -1002;
        public static final int LANDING_ERROR_CODE_DEEP_LINK_NO_RECEIVER = -1001;
        public static final int LANDING_ERROR_CODE_DEEP_LINK_URL_PARSE_ERROR = -1000;
        private int errorCode;

        public DeepLinkException(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public abstract void J();

    public abstract void K();

    public abstract void a(a aVar);

    protected abstract void f();

    public abstract void g();

    public final void N() {
        h();
        K();
        g();
    }

    public void h() {
        if (!d.a(B())) {
            b$a.a().a(B());
        }
    }

    protected final String O() {
        return this.J;
    }

    public final void b(String str) {
        this.J = str;
    }

    public final void M() {
        if (!d.a(C())) {
            b$a.a().a(C());
        }
        J();
        f();
    }
}
