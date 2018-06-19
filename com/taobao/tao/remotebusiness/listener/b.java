package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.k;

abstract class b {
    protected k listener = null;
    protected MtopBusiness mtopBusiness = null;

    protected b(MtopBusiness mtopBusiness, k kVar) {
        this.mtopBusiness = mtopBusiness;
        this.listener = kVar;
    }
}
