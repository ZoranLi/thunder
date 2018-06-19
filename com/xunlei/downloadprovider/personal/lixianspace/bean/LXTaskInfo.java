package com.xunlei.downloadprovider.personal.lixianspace.bean;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.personal.lixianspace.b.l;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class LXTaskInfo {
    public long a;
    public String b;
    public int c;
    public String d;
    public int e;
    public String f;
    public long g;
    public List<a> h;
    public CollectState i;
    public boolean j = false;
    public LXTaskType k = LXTaskType.URL;

    public enum CollectState {
        fail("下载失败"),
        complete("离线下载完成"),
        downloading("正在下载"),
        download_error("下载出错"),
        porn_resource("资源涉黄"),
        reactionary_resource("资源涉反"),
        piracy_resource("资源涉盗"),
        illegal_resource("资源非法"),
        unknown("未知状态");
        
        private String value;

        private CollectState(String str) {
            this.value = str;
        }

        public static CollectState getCollectState(String str) {
            for (CollectState collectState : values()) {
                if (TextUtils.equals(collectState.value, str)) {
                    return collectState;
                }
            }
            return unknown;
        }
    }

    public static class a {
        public String a;
        public long b;
        public long c;
        public String d;

        private a() {
        }
    }

    private LXTaskInfo() {
    }

    public static LXTaskInfo a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return null;
        }
        try {
            LXTaskInfo lXTaskInfo = new LXTaskInfo();
            lXTaskInfo.a = jSONObject2.getLong(AgooConstants.MESSAGE_TASK_ID);
            lXTaskInfo.b = jSONObject2.optString("url");
            lXTaskInfo.c = jSONObject2.optInt(NotificationCompat.CATEGORY_PROGRESS);
            lXTaskInfo.e = jSONObject2.getInt("indate");
            lXTaskInfo.d = jSONObject2.optString("create_time");
            lXTaskInfo.f = jSONObject2.optString("filename");
            lXTaskInfo.i = CollectState.getCollectState(jSONObject2.optString("collect_state"));
            lXTaskInfo.h = new ArrayList(8);
            JSONArray optJSONArray = jSONObject2.optJSONArray("files");
            long optLong = jSONObject2.optLong("filesize");
            lXTaskInfo.g = optLong;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                byte b = (byte) 0;
                long j = 0;
                int i = 0;
                while (i < length) {
                    int i2;
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    if (jSONObject3 != null) {
                        a aVar = new a();
                        aVar.a = jSONObject3.optString("filename");
                        i2 = i;
                        aVar.b = jSONObject3.optLong("filesize", 0);
                        long j2 = j + aVar.b;
                        aVar.c = jSONObject3.optLong("fileindex", 0);
                        aVar.d = jSONObject3.optString("gdl_url");
                        lXTaskInfo.h.add(aVar);
                        j = j2;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    b = (byte) 0;
                }
                lXTaskInfo.g = j;
            }
            if (lXTaskInfo.g <= 0) {
                lXTaskInfo.g = optLong;
            }
            String str = lXTaskInfo.b;
            if (str.startsWith("bt://")) {
                lXTaskInfo.b = l.a(str.substring(str.indexOf("bt://") + 5));
            }
            if (lXTaskInfo.h.size() > 1 || k.g(str) || str.startsWith("bt://")) {
                lXTaskInfo.k = LXTaskType.BT;
            }
            return lXTaskInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
