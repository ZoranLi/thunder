package com.xunlei.common.new_ptl.member.task.aq;

import com.xunlei.common.new_ptl.member.XLAvatarItem;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import com.xunlei.common.new_ptl.member.XLLixianCapacity;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

final class UserAqModifyPassWordTask$1 implements XLOnUserListener {
    private /* synthetic */ UserAqModifyPassWordTask a;

    public final boolean onHighSpeedCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLHspeedCapacity xLHspeedCapacity, Object obj, int i2) {
        return false;
    }

    public final boolean onLixianCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLLixianCapacity xLLixianCapacity, Object obj, int i2) {
        return false;
    }

    public final boolean onUserAqBindMobile(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserAqSendMessage(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserBindedOtherAccount(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        return false;
    }

    public final boolean onUserGetBindedOtherAccount(int i, String str, String str2, XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetCityCodeByIp(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetCityInfo(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetOtherAccountInfo(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        return false;
    }

    public final boolean onUserGetQRCode(int i, String str, String str2, String str3, byte[] bArr, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetRecommendAvatars(int i, String str, String str2, XLAvatarItem[] xLAvatarItemArr, Object obj, int i2) {
        return false;
    }

    public final boolean onUserInfoCatched(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserLogout(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserMobileLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserMobileRegister(int i, String str, String str2, boolean z, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserMobileSendMessage(int i, String str, String str2, String str3, Object obj, int i2) {
        return false;
    }

    public final boolean onUserModifyPassWord(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserPreVerifyedCode(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserQRCodeLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserQRCodeLoginAuth(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserRecvChannelMessage(int i, JSONArray jSONArray) {
        return false;
    }

    public final boolean onUserResumed(int i) {
        return false;
    }

    public final boolean onUserSelectRecommendAvatar(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserSessionidLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserSetAvatar(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserSetInfo(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserSuspended(int i) {
        return false;
    }

    public final boolean onUserThirdLogin(int i, String str, String str2, XLUserInfo xLUserInfo, int i2, int i3, Object obj, int i4) {
        return false;
    }

    public final boolean onUserTokenLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserUnBindeOtherAccount(int i, String str, String str2, int i2, Object obj, int i3) {
        return false;
    }

    public final boolean onUserVerifyCodeUpdated(int i, String str, String str2, String str3, int i2, byte[] bArr, Object obj, int i3) {
        return false;
    }

    public final boolean onUserVerifyedCode(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    UserAqModifyPassWordTask$1(UserAqModifyPassWordTask userAqModifyPassWordTask) {
        this.a = userAqModifyPassWordTask;
    }

    public final boolean onUserLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        if (i == 0) {
            UserAqModifyPassWordTask.a(this.a, i);
        } else {
            UserAqModifyPassWordTask.a(this.a, XLErrorCode.AQ_USER_MODIFY_AUTO_LOGIN_ERROR);
        }
        return false;
    }
}
