package com.xunlei.downloadprovider.personal.lixianspace.b;

import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import java.util.List;

/* compiled from: ILXDataResponseListener */
public interface a {
    void a();

    void a(long j, int i);

    void a(TorrentInfo torrentInfo);

    void a(LXTaskInfo lXTaskInfo, int i, String str);

    void a(String str, int i, LXTaskInfo lXTaskInfo);

    void a(List<LXTaskInfo> list, int i);

    void b(List<LXTaskInfo> list, int i);
}
