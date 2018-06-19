package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import java.util.Arrays;
import java.util.List;

public class ConnectResp implements IMessageEntity {
    @a
    public List<Integer> protocolVersion = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2)});
    @a
    public String sessionId;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("protocol version:");
        for (Integer append : this.protocolVersion) {
            stringBuilder.append(append);
            stringBuilder.append(',');
        }
        return stringBuilder.toString();
    }
}
