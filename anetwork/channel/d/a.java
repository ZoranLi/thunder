package anetwork.channel.d;

import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public interface a {
    void a(int i, int i2, ByteArray byteArray);

    void a(int i, Map<String, List<String>> map);

    void a(DefaultFinishEvent defaultFinishEvent);
}
