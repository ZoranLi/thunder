package com.xunlei.downloadprovider.member.login;

import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import com.xunlei.common.new_ptl.member.XLLixianCapacity;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.downloadprovider.member.login.b.p;
import com.xunlei.downloadprovider.member.login.c.a;
import org.json.JSONObject;

/* compiled from: LoginHelper */
final class d extends p {
    final /* synthetic */ LoginHelper a;

    d(LoginHelper loginHelper) {
        this.a = loginHelper;
    }

    public final boolean onUserLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        this.a.a(i, xLUserInfo, obj, str);
        return false;
    }

    public final boolean onUserThirdLogin(int i, String str, String str2, XLUserInfo xLUserInfo, int i2, int i3, Object obj, int i4) {
        LoginHelper.a(this.a, i, i2, i3, obj);
        this.a.a(i, xLUserInfo, obj, str);
        return false;
    }

    public final boolean onUserTokenLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        this.a.a(i, xLUserInfo, obj, str);
        return false;
    }

    public final boolean onUserSessionidLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        this.a.a(i, xLUserInfo, obj, str);
        return false;
    }

    public final boolean onUserLogout(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        LoginHelper.a(this.a, i);
        return false;
    }

    public final boolean onUserInfoCatched(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        LoginHelper.a(this.a, i, xLUserInfo);
        return false;
    }

    public final boolean onUserSetInfo(int i, String str, String str2, Object obj, int i2) {
        LoginHelper.a(this.a, i, obj);
        return false;
    }

    public final boolean onHighSpeedCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLHspeedCapacity xLHspeedCapacity, Object obj, int i2) {
        LoginHelper.a(this.a, i, xLUserInfo, xLHspeedCapacity);
        return false;
    }

    public final boolean onLixianCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLLixianCapacity xLLixianCapacity, Object obj, int i2) {
        LoginHelper.a(this.a, i, xLLixianCapacity);
        return false;
    }

    public final boolean onUserVerifyCodeUpdated(int i, String str, String str2, String str3, int i2, byte[] bArr, Object obj, int i3) {
        LoginHelper.a(this.a, i, str3, bArr);
        return false;
    }

    public final boolean onUserSetAvatar(int i, String str, String str2, Object obj, int i2) {
        LoginHelper.a(this.a, i, (String) obj);
        return false;
    }

    public final boolean onUserGetBindedOtherAccount(int i, String str, String str2, XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr, Object obj, int i2) {
        LoginHelper.a(this.a, xLBindedOtherAccountItemArr, i);
        return false;
    }

    public final boolean onUserBindedOtherAccount(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        LoginHelper.a(this.a, i, str, i2, xLThirdUserInfo);
        return false;
    }

    public final boolean onUserUnBindeOtherAccount(int i, String str, String str2, int i2, Object obj, int i3) {
        LoginHelper.a(this.a, i2, i);
        return false;
    }

    public final boolean onUserGetOtherAccountInfo(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        LoginHelper.a(this.a, i, xLThirdUserInfo);
        return false;
    }

    public final boolean onUserGetCityInfo(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        a.a(jSONObject);
        return false;
    }

    public final boolean onUserModifyPassWord(int i, String str, String str2, Object obj, int i2) {
        LoginHelper.b(this.a, i);
        return false;
    }

    public final boolean onUserGetCityCodeByIp(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        LoginHelper.a(this.a, i, str, jSONObject);
        return false;
    }

    public final boolean onUserMobileSendMessage(int i, String str, String str2, String str3, Object obj, int i2) {
        LoginHelper.a(this.a, i, str, str3);
        return false;
    }

    public final boolean onUserMobileLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        LoginHelper.a(this.a, i, str, xLUserInfo, obj);
        return false;
    }

    public final boolean onUserMobileRegister(int i, String str, String str2, boolean z, XLUserInfo xLUserInfo, Object obj, int i2) {
        LoginHelper.a(this.a, i, str, z, xLUserInfo, obj);
        return false;
    }
}
