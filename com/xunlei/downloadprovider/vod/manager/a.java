package com.xunlei.downloadprovider.vod.manager;

import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.VideoTagSearchResponse;
import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.VideoTagSearchResponse.VideoTagDTO;
import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.b;
import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* compiled from: HotTopicManager */
public final class a {
    public c a = new c();

    public final List<String> a(String str) {
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c.a());
        stringBuilder.append("api/file/searchTags");
        String stringBuilder2 = stringBuilder.toString();
        Map hashMap = new HashMap();
        hashMap.put("keyword", str);
        hashMap.put("count", MessageService.MSG_DB_COMPLETE);
        str = this.a;
        c.a(hashMap, "1.1");
        try {
            VideoTagSearchResponse videoTagSearchResponse = (VideoTagSearchResponse) com.xunlei.downloadprovider.vod.b.a.a(VideoTagSearchResponse.class, new JSONObject(str.a(stringBuilder2, hashMap)));
            if (!(videoTagSearchResponse == null || videoTagSearchResponse.tags == null || videoTagSearchResponse.tags.size() == 0)) {
                str = videoTagSearchResponse.tags.iterator();
                while (str.hasNext()) {
                    arrayList.add(((VideoTagDTO) str.next()).key);
                }
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return arrayList;
    }

    static void a(b bVar, c cVar) {
        if (cVar != null) {
            cVar.a(bVar);
        }
    }
}
