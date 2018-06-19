package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.a;

public interface IRemoteBaseListener extends k {
    void onError(int i, MtopResponse mtopResponse, Object obj);

    void onSuccess(int i, MtopResponse mtopResponse, a aVar, Object obj);

    void onSystemError(int i, MtopResponse mtopResponse, Object obj);
}
