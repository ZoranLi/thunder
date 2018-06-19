package com.taobao.tao.remotebusiness.a;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import mtopsdk.mtop.common.h;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.a;

public final class b implements Serializable {
    public k a;
    public h b;
    public a c;
    public MtopBusiness d;
    public MtopResponse e;

    public b(k kVar, h hVar, MtopBusiness mtopBusiness) {
        this.a = kVar;
        this.b = hVar;
        this.d = mtopBusiness;
    }
}
