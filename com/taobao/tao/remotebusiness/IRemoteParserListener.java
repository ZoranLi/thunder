package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.MtopResponse;

public interface IRemoteParserListener extends k {
    void parseResponse(MtopResponse mtopResponse);
}
