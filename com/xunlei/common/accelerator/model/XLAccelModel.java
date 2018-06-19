package com.xunlei.common.accelerator.model;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.accelerator.base.BaseModel;
import com.xunlei.common.accelerator.bean.AccelInfoResultBean;
import com.xunlei.common.accelerator.bean.KeepResultBean;
import com.xunlei.common.accelerator.bean.PortalResultBean;
import com.xunlei.common.accelerator.bean.StartAccelResultBean;
import com.xunlei.common.accelerator.bean.StopAccelResultBean;
import com.xunlei.common.accelerator.bean.TryInfoResultBean;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.accelerator.bean.XLAccelTryInfo;
import com.xunlei.common.accelerator.bean.XLAccelUser;
import org.json.JSONException;
import org.json.JSONObject;

public class XLAccelModel extends BaseModel {
    public static final int RT_BAND_INFO = 0;
    public static final int RT_START_ACCEL = 1;
    public static final int RT_STOP_ACCEL = 2;

    public PortalResultBean parsePortalData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = new PortalResultBean();
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("richmessage");
            str.setError(optInt);
            str.setRichmessage(optString);
            if (optInt == 0) {
                String optString2 = jSONObject.optString("interface_ip");
                String optString3 = jSONObject.optString("interface_port");
                str.setIp(optString2);
                str.setPort(optString3);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("http://");
                stringBuffer.append(optString2);
                stringBuffer.append(Constants.COLON_SEPARATOR);
                stringBuffer.append(optString3);
                str.setAddress(stringBuffer.toString());
            }
            return str;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public AccelInfoResultBean parseBandInfoData(String str) {
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            str = new AccelInfoResultBean();
            if (jSONObject.isNull("errno")) {
                i = 0;
            } else {
                i = jSONObject.getInt("errno");
                str.setError(i);
            }
            if (!jSONObject.isNull("sequence")) {
                str.setSeq(jSONObject.getInt("sequence"));
            }
            if (!jSONObject.isNull("richmessage")) {
                str.setRichmessage(jSONObject.getString("richmessage"));
            }
            if (!jSONObject.isNull("dial_account")) {
                str.setDialAccount(jSONObject.getString("dial_account"));
            }
            if (i == 0) {
                XLAccelBandInfo obtainBandInfo = obtainBandInfo(jSONObject, 0);
                if (obtainBandInfo.mCanUpgrade == 0) {
                    str.setRichmessage("当前带宽已经达到最大值");
                }
                str.setXlAccelBandInfo(obtainBandInfo);
            }
            return str;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public TryInfoResultBean parseTryAccelInfoData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optInt("sequence");
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("richmessage");
            TryInfoResultBean tryInfoResultBean = new TryInfoResultBean();
            tryInfoResultBean.setSeq(str);
            tryInfoResultBean.setError(optInt);
            tryInfoResultBean.setRichmessage(optString);
            if (optInt == 0) {
                str = new XLAccelTryInfo();
                str.mNumOfTry = jSONObject.optInt("number_of_try");
                str.mTryDuration = jSONObject.optInt("try_duration");
                tryInfoResultBean.setXlAccelTryInfo(str);
            }
            return tryInfoResultBean;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public StartAccelResultBean parseStartAccelData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optInt("sequence");
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("richmessage");
            StartAccelResultBean startAccelResultBean = new StartAccelResultBean();
            startAccelResultBean.setSeq(str);
            startAccelResultBean.setError(optInt);
            startAccelResultBean.setRichmessage(optString);
            if (optInt == 0) {
                startAccelResultBean.setXlAccelBandInfo(obtainBandInfo(jSONObject, 1));
            }
            return startAccelResultBean;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public StopAccelResultBean parseStopAccelData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optInt("sequence");
            int optInt = jSONObject.optInt("errno");
            String str2 = "";
            if (!jSONObject.isNull("richmessage")) {
                str2 = jSONObject.optString("richmessage");
            }
            StopAccelResultBean stopAccelResultBean = new StopAccelResultBean();
            stopAccelResultBean.setSeq(str);
            stopAccelResultBean.setError(optInt);
            stopAccelResultBean.setRichmessage(str2);
            if (optInt == 0 && jSONObject.isNull("bandwidth") == null) {
                stopAccelResultBean.setXlAccelBandInfo(obtainBandInfo(jSONObject, 2));
            }
            return stopAccelResultBean;
        } catch (String str3) {
            str3.printStackTrace();
            return null;
        }
    }

    private XLAccelBandInfo obtainBandInfo(JSONObject jSONObject, int i) throws JSONException {
        XLAccelBandInfo xLAccelBandInfo = new XLAccelBandInfo();
        JSONObject jSONObject2 = jSONObject.getJSONObject("bandwidth");
        if (jSONObject2 != null) {
            xLAccelBandInfo.mCurrentBandWidth.mDownStream = jSONObject2.optLong("downstream");
            xLAccelBandInfo.mCurrentBandWidth.mUpStream = jSONObject2.optLong("upstream");
        }
        if (i == 0) {
            xLAccelBandInfo.mCanUpgrade = jSONObject.optInt("can_upgrade");
            i = jSONObject.getJSONObject("max_bandwidth");
            if (i != 0) {
                xLAccelBandInfo.mMaxBandWidth.mDownStream = i.optLong("downstream");
                xLAccelBandInfo.mMaxBandWidth.mUpStream = i.optLong("upstream");
            }
        }
        xLAccelBandInfo.mBandWidthInfo.mServiceProvider = jSONObject.optString("sp");
        xLAccelBandInfo.mBandWidthInfo.mDialAccount = jSONObject.optString("dial_account");
        xLAccelBandInfo.mBandWidthInfo.mProvince = jSONObject.optString("province");
        xLAccelBandInfo.mBandWidthInfo.mServiceProviderName = jSONObject.optString("sp_name");
        xLAccelBandInfo.mBandWidthInfo.mProvinceName = jSONObject.optString("province_name");
        return xLAccelBandInfo;
    }

    public KeepResultBean parseKeepAliveData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optInt("sequence");
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("richmessage");
            String optString2 = jSONObject.optString("client_type");
            KeepResultBean keepResultBean = new KeepResultBean();
            keepResultBean.setSeq(str);
            keepResultBean.setError(optInt);
            keepResultBean.setRichmessage(optString);
            keepResultBean.setClient_type(optString2);
            if (jSONObject.isNull("timestamp") == null) {
                keepResultBean.setTimestamp(jSONObject.optString("timestamp"));
            }
            if (jSONObject.isNull("upgrade_type") == null) {
                keepResultBean.setUpgrade_type(String.valueOf(jSONObject.optInt("upgrade_type")));
            }
            if (jSONObject.isNull("userid") == null) {
                keepResultBean.setUserid(jSONObject.optString("userid"));
            }
            return keepResultBean;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static String bandInfoToJson(int i, int i2, String str, XLAccelBandInfo xLAccelBandInfo) {
        i = getBaseJsonObj(i, i2, str);
        if (xLAccelBandInfo != null) {
            try {
                i2 = new JSONObject();
                i2.put("mCanUpgrade", xLAccelBandInfo.mCanUpgrade);
                if (xLAccelBandInfo.mCurrentBandWidth != null) {
                    str = new JSONObject();
                    str.put("mUpStream", xLAccelBandInfo.mCurrentBandWidth.mUpStream);
                    str.put("mDownStream", xLAccelBandInfo.mCurrentBandWidth.mDownStream);
                    i2.put("mCurrentBandWidth", str);
                }
                if (xLAccelBandInfo.mMaxBandWidth != null) {
                    str = new JSONObject();
                    str.put("mUpStream", xLAccelBandInfo.mMaxBandWidth.mUpStream);
                    str.put("mDownStream", xLAccelBandInfo.mMaxBandWidth.mDownStream);
                    i2.put("mMaxBandWidth", str);
                }
                if (xLAccelBandInfo.mBandWidthInfo != null) {
                    str = new JSONObject();
                    str.put("mServiceProvider", xLAccelBandInfo.mBandWidthInfo.mServiceProvider);
                    str.put("mServiceProviderName", xLAccelBandInfo.mBandWidthInfo.mServiceProviderName);
                    str.put("mDialAccount", xLAccelBandInfo.mBandWidthInfo.mDialAccount);
                    str.put("mProvince", xLAccelBandInfo.mBandWidthInfo.mProvince);
                    str.put("mProvinceName", xLAccelBandInfo.mBandWidthInfo.mProvinceName);
                    i2.put("mBandWidthInfo", str);
                }
                i.put("xbi", i2);
            } catch (int i22) {
                i22.printStackTrace();
            }
        }
        return i.toString();
    }

    public static String tryInfoToJson(int i, int i2, String str, XLAccelTryInfo xLAccelTryInfo) {
        i = getBaseJsonObj(i, i2, str);
        if (xLAccelTryInfo != null) {
            try {
                i2 = new JSONObject();
                i2.put("mNumOfTry", xLAccelTryInfo.mNumOfTry);
                i2.put("mTryDuration", xLAccelTryInfo.mTryDuration);
                i2.put("mRemainTime", xLAccelTryInfo.mRemainTime);
                i.put("tryInfo", i2);
            } catch (int i22) {
                i22.printStackTrace();
            }
        }
        return i.toString();
    }

    private static JSONObject getBaseJsonObj(int i, int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("seq", i);
            jSONObject.put("error", i2);
            jSONObject.put("errorDesc", str);
        } catch (int i3) {
            i3.printStackTrace();
        }
        return jSONObject;
    }

    public static String UserInfoToJsonJ(XLAccelUser xLAccelUser) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mUserID", xLAccelUser.mUserID);
            jSONObject.put("mSessionID", xLAccelUser.mSessionID);
            jSONObject.put("mUserType", xLAccelUser.mUserType);
            jSONObject.put("mVipType", xLAccelUser.mVipType);
        } catch (XLAccelUser xLAccelUser2) {
            xLAccelUser2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
