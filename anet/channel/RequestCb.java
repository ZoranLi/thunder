package anet.channel;

import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public interface RequestCb {
    void onDataReceive(ByteArray byteArray, boolean z);

    void onFinish(int i, String str, RequestStatistic requestStatistic);

    void onResponseCode(int i, Map<String, List<String>> map);
}
