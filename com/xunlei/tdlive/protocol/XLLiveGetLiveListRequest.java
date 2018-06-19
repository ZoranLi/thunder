package com.xunlei.tdlive.protocol;

import android.text.TextUtils;
import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;
import java.util.List;

public class XLLiveGetLiveListRequest extends XLLiveRequest {
    int mCount = -1;
    int mFrom = -1;
    String mTypeID = "";
    String mURL = "";

    public static class GetLiveListResp extends XLLiveRespBase {
        public List<Room> data;
        public int grayid;

        public static class Player {
            public long funs_num;
            public long like_num;
            public long total_gold_coin;
            public long total_play_num;
        }

        public static class Room {
            public String image;
            public long onlinenum;
            public String play_hls_url;
            public Player playerinfo;
            public String roomid;
            public Seq2 seq2;
            public String start_time;
            public int status;
            public String stream_pull;
            public int stream_server;
            public String title;
            public String userid;
            public User userinfo;

            public String getImageUrl() {
                if (TextUtils.isEmpty(this.image)) {
                    return this.userinfo != null ? this.userinfo.avatar : null;
                } else {
                    return this.image;
                }
            }
        }

        public static final class Seq2 {
            public int hot_level;
            public int is_follow;
            public int is_recommend;
            public int is_sign;
        }

        public static class User {
            public String avatar;
            public long current_gold_coin;
            public String nickname;
            public long total_gold_coin;
            public int type;
        }
    }

    public XLLiveGetLiveListRequest(String str, int i, int i2, String str2) {
        this.mTypeID = str2;
        this.mFrom = i;
        this.mCount = i2;
        this.mURL = str;
    }

    protected String onGetURL() {
        String str = this.mURL;
        if (TextUtils.isEmpty(XLLiveRequest.getSessionId())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&hid=");
            stringBuilder.append(XLLiveRequest.getUserId());
            str = stringBuilder.toString();
        }
        if (this.mFrom >= 0 && this.mCount > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&start=");
            stringBuilder.append(this.mFrom);
            stringBuilder.append("&count=");
            stringBuilder.append(this.mCount);
            str = stringBuilder.toString();
        }
        if (TextUtils.isEmpty(this.mTypeID)) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&type_id=");
        stringBuilder.append(this.mTypeID);
        return stringBuilder.toString();
    }

    protected Class<?> onGetObjectClass() {
        return GetLiveListResp.class;
    }
}
