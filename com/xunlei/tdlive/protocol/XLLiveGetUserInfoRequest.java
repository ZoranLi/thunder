package com.xunlei.tdlive.protocol;

import com.xunlei.tdlive.protocol.ProtocolData.WidthDrawDetails;
import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;

public class XLLiveGetUserInfoRequest extends XLLiveRequest {
    private LType mLType;

    public enum LType {
        XL,
        WX
    }

    public static class GetUserInfoResp extends XLLiveRespBase {
        public Data data;

        public static class Data {
            public String avatar;
            public long current_coin;
            public WidthDrawDetails exchange_info;
            public ExtData ext;
            public int fans_num;
            public int follow_num;
            public int is_sign;
            public LevelInfo level = new LevelInfo();
            public int mail_num;
            public String nickname;
            public int sex = 0;
            public String sign;
            public int total_record_num;
            public long used_coin;
            public String userid;
            public String uuid;

            public boolean isSigner() {
                return this.is_sign == 1;
            }

            public long getSend() {
                return this.used_coin;
            }

            public boolean sexEditable() {
                return this.ext != null && this.ext.sex_isup == 0;
            }

            public boolean voiceCallable() {
                return this.ext != null && this.ext.voicecall == 1;
            }
        }

        public static final class ExtData {
            public int sex_isup;
            public int voicecall;
        }
    }

    public XLLiveGetUserInfoRequest(LType lType) {
        this.mLType = lType;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=user&a=getinfo&show_yl=1&type=");
        stringBuilder.append(this.mLType.ordinal());
        return stringBuilder.toString();
    }

    protected Class<?> onGetObjectClass() {
        return GetUserInfoResp.class;
    }
}
