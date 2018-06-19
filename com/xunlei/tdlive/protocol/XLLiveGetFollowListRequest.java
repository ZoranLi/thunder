package com.xunlei.tdlive.protocol;

import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;
import java.util.List;

public class XLLiveGetFollowListRequest extends XLLiveRequest {
    public static final String TP_FANS = "fans";
    public static final String TP_FOLLOW = "focus";
    private int mLimit;
    private int mStart;
    private String mType;
    private String mUid;

    public static final class RoomInfo {
        public String roomid;
        public String stream_pull;
        public String title;
    }

    public static class UserListResp extends XLLiveRespBase {
        public List<UserInfo> data;

        public static final class UserInfo {
            public String avatar;
            public int is_follow;
            public int is_playering;
            public int is_roomadmin;
            public String nickname;
            public RoomInfo room_info;
            public String sign;
            public String status;
            public String userid;

            public final boolean isFollow() {
                return this.is_follow == 1;
            }

            public final void toggleFollow() {
                int i = 1;
                if (this.is_follow == 1) {
                    i = 0;
                }
                this.is_follow = i;
            }

            public final boolean isLiving() {
                return this.is_playering == 1 && this.room_info != null;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.nickname);
                stringBuilder.append("-");
                stringBuilder.append(this.userid);
                return stringBuilder.toString();
            }
        }
    }

    public XLLiveGetFollowListRequest(String str, String str2, int i, int i2) {
        this.mStart = i;
        this.mLimit = i2;
        this.mUid = str;
        this.mType = str2;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=player&a=getFollowList&playerid=");
        stringBuilder.append(this.mUid);
        stringBuilder.append("&type=");
        stringBuilder.append(this.mType);
        stringBuilder.append("&start=");
        stringBuilder.append(this.mStart);
        stringBuilder.append("&limit=");
        stringBuilder.append(this.mLimit);
        return stringBuilder.toString();
    }

    protected Class<?> onGetObjectClass() {
        return UserListResp.class;
    }
}
