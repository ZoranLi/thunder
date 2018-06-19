package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.j;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.common.n;

public interface IRemoteProcessListener extends k {
    void onDataReceived(n nVar, Object obj);

    void onHeader(j jVar, Object obj);
}
