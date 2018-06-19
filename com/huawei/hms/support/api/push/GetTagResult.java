package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.push.GetTagsResp;
import java.util.Map;

public class GetTagResult extends Result {
    protected GetTagsResp resp = null;

    public void setTagsRes(GetTagsResp getTagsResp) {
        this.resp = getTagsResp;
    }

    public GetTagsResp getTagsRes() {
        return this.resp;
    }

    public Map<String, String> getTags() {
        return this.resp != null ? this.resp.getTags() : null;
    }
}
