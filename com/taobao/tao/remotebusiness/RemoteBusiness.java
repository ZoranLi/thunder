package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.b;

public class RemoteBusiness extends MtopBusiness {
    private RemoteBusiness(MtopRequest mtopRequest, String str) {
        super(mtopRequest, str);
    }

    private RemoteBusiness(b bVar, String str) {
        super(bVar, str);
    }

    public static RemoteBusiness build(MtopRequest mtopRequest) {
        return new RemoteBusiness(mtopRequest, null);
    }

    public static RemoteBusiness build(MtopRequest mtopRequest, String str) {
        return new RemoteBusiness(mtopRequest, str);
    }

    public static RemoteBusiness build(b bVar) {
        return new RemoteBusiness(bVar, null);
    }

    public static RemoteBusiness build(b bVar, String str) {
        return new RemoteBusiness(bVar, str);
    }
}
