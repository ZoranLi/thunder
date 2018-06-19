package com.qq.e.comm.services;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.alipay.sdk.sys.a;
import com.qq.e.comm.constants.Constants.KEYS;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.services.RetCodeService.RetCodeInfo;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import org.json.JSONObject;

final class a$1 implements NetworkCallBack {
    private /* synthetic */ SM a;
    private /* synthetic */ PM b;
    private /* synthetic */ long c;

    a$1(SM sm, PM pm, long j) {
        this.a = sm;
        this.b = pm;
        this.c = j;
    }

    public final void onException(Exception exception) {
        GDTLogger.e("ActivateError", exception);
        RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", -1, (int) (System.currentTimeMillis() - this.c), 0, 0, 1));
    }

    public final void onResponse(Request request, Response response) {
        RetCodeService instance;
        RetCodeInfo retCodeInfo;
        try {
            String stringContent;
            if (response.getStatusCode() == 200) {
                stringContent = response.getStringContent();
                StringBuilder stringBuilder = new StringBuilder("ACTIVERESPONSE:");
                stringBuilder.append(stringContent);
                GDTLogger.d(stringBuilder.toString());
                if (StringUtil.isEmpty(stringContent)) {
                    GDTLogger.report("SDK Server response empty string,maybe zip or tea format error");
                    instance = RetCodeService.getInstance();
                    retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.c), 0, 0, 1);
                    instance.send(r9);
                }
                JSONObject jSONObject = new JSONObject(stringContent);
                int i = -1;
                if (jSONObject.has(KEYS.RET)) {
                    i = jSONObject.getInt(KEYS.RET);
                }
                if (i != 0) {
                    stringBuilder = new StringBuilder("Response Error,retCode=");
                    stringBuilder.append(i);
                    stringContent = stringBuilder.toString();
                } else {
                    if (jSONObject.has("suid")) {
                        stringContent = jSONObject.getString("suid");
                        if (!StringUtil.isEmpty(stringContent)) {
                            this.a.updateSUID(stringContent);
                        }
                    }
                    if (jSONObject.has("sid")) {
                        stringContent = jSONObject.getString("sid");
                        if (!StringUtil.isEmpty(stringContent)) {
                            this.a.updateSID(stringContent);
                        }
                    }
                    if (jSONObject.has(INoCaptchaComponent.sig)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(INoCaptchaComponent.sig);
                        if (jSONObject.has(a.j)) {
                            String string;
                            jSONObject = jSONObject.getJSONObject(a.j);
                            if (jSONObject.has("app") && jSONObject2.has("app")) {
                                string = jSONObject.getString("app");
                                this.a.updateDEVCloudSetting(jSONObject2.getString("app"), string);
                            }
                            if (jSONObject.has("sdk") && jSONObject2.has("sdk")) {
                                string = jSONObject.getString("sdk");
                                this.a.updateSDKCloudSetting(jSONObject2.getString("sdk"), string);
                            }
                            if (jSONObject.has(c.a)) {
                                this.a.updateContextSetting(jSONObject.getString(c.a));
                            } else {
                                this.a.updateContextSetting(null);
                            }
                        }
                        if (jSONObject2.has(ShareConstants.DEXMODE_JAR) && jSONObject2.has("url")) {
                            this.b.update(jSONObject2.getString(ShareConstants.DEXMODE_JAR), jSONObject2.getString("url"));
                        }
                    }
                    instance = RetCodeService.getInstance();
                    retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.c), 0, 0, 1);
                    instance.send(r9);
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("SDK server response code error while launch or activate,code:");
            stringBuilder2.append(response.getStatusCode());
            stringContent = stringBuilder2.toString();
            GDTLogger.e(stringContent);
            instance = RetCodeService.getInstance();
            retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.c), 0, 0, 1);
        } catch (Throwable e) {
            GDTLogger.e("ActivateError", e);
            instance = RetCodeService.getInstance();
            retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.c), 0, 0, 1);
        } catch (Throwable e2) {
            GDTLogger.e("Parse Active or launch response exception", e2);
            instance = RetCodeService.getInstance();
            retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.c), 0, 0, 1);
        } catch (Throwable th) {
            RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.c), 0, 0, 1));
        }
        instance.send(r9);
    }
}
