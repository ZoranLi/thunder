package com.xunlei.tdlive.protocol;

import android.support.v4.media.session.PlaybackStateCompat;
import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;
import com.xunlei.tdlive.util.XLog;
import com.xunlei.tdlive.util.e.h;
import java.io.File;

public class XLLiveUpdateAvatarRequest extends XLLiveRequest {
    private static final int AVATAR_MAX_SIZE = 1048576;
    private File mAvatar;

    public static final class AvatarData {
        public String avatar;
    }

    public static final class AvatarResp extends XLLiveRespBase {
        public AvatarData data;
    }

    protected String onGetURL() {
        return "http://upload.live.xunlei.com/caller?c=user&a=upload";
    }

    protected boolean useHttpPost() {
        return true;
    }

    public XLLiveUpdateAvatarRequest(File file) {
        this.mAvatar = file;
    }

    protected void onAddBodyParams(h hVar) {
        if (this.mAvatar == null || !this.mAvatar.exists() || this.mAvatar.length() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            XLog.w(XLLiveRequest.TAG, "avatar file not exits or size is greater than 1048576");
        } else {
            hVar.a("avatar", this.mAvatar);
        }
    }

    protected Class<?> onGetObjectClass() {
        return AvatarResp.class;
    }
}
