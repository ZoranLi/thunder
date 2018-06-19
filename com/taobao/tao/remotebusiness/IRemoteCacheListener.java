package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.c;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.a;

public interface IRemoteCacheListener extends k {
    void onCached(c cVar, a aVar, Object obj);
}
