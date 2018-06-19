package com.ta.utdid2.aid;

import android.content.Context;
import android.text.TextUtils;
import com.ta.utdid2.android.utils.DebugUtils;
import com.ta.utdid2.android.utils.NetworkUtils;
import com.ut.device.AidCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class AidRequester {
    private static final String AIDFUNCNAME = "/get_aid/";
    private static final String AIDSERVER = "http://hydra.alibaba.com/";
    private static final String NAME_AID = "&aid=";
    private static final String NAME_ID = "&id=";
    private static final String NAME_RESULT_ACTION = "action";
    private static final String NAME_RESULT_AID = "aid";
    private static final String NAME_RESULT_ISERROR = "isError";
    private static final String NAME_RESULT_STATUS = "status";
    private static final String NAME_RESUTL_DATA = "data";
    private static final String NAME_TOKEN = "auth[token]=";
    private static final String NAME_TYPE = "&type=";
    private static final String RSP_ACTION_CHANGED = "changed";
    private static final String RSP_ACTION_NEW = "new";
    private static final String RSP_ACTION_UNCHANGED = "unchanged";
    private static final String RSP_ISERROR_FALSE = "false";
    private static final String RSP_ISERROR_TRUE = "true";
    private static final String RSP_STATUS_INVALID_APP = "404";
    private static final String RSP_STATUS_INVALID_TOKEN = "401";
    private static final String RSP_STATUS_OK = "200";
    private static final int SESSION_TIME_OUT = 1000;
    private static final String TAG = "com.ta.utdid2.aid.AidRequester";
    private static final String TYPE_UTDID = "utdid";
    private static final int WEAK_SESSION_TIME_OUT = 3000;
    private static AidRequester sAidRequester;
    private Context mContext;
    private Object mLock = new Object();

    class PostRestThread extends Thread {
        String mAppName;
        AidCallback mCallback;
        String mOldAid;
        HttpPost mPost;
        String mRspLine = "";
        String mToken = "";

        public PostRestThread(HttpPost httpPost) {
            this.mPost = httpPost;
        }

        public PostRestThread(HttpPost httpPost, AidCallback aidCallback, String str, String str2, String str3) {
            this.mPost = httpPost;
            this.mCallback = aidCallback;
            this.mOldAid = str;
            this.mAppName = str2;
            this.mToken = str3;
        }

        public void run() {
            HttpResponse execute;
            String readLine;
            if (this.mCallback != null) {
                this.mCallback.onAidEventChanged(1000, this.mOldAid);
            }
            BufferedReader bufferedReader = null;
            try {
                execute = new DefaultHttpClient().execute(this.mPost);
            } catch (Exception e) {
                if (this.mCallback != null) {
                    this.mCallback.onAidEventChanged(1002, this.mOldAid);
                }
                AidRequester.TAG;
                e.toString();
                execute = null;
            }
            if (execute != null) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(execute.getEntity().getContent(), Charset.forName("UTF-8")));
                } catch (Exception e2) {
                    if (this.mCallback != null) {
                        this.mCallback.onAidEventChanged(1002, this.mOldAid);
                    }
                    AidRequester.TAG;
                    e2.toString();
                }
            } else {
                AidRequester.TAG;
            }
            if (bufferedReader != null) {
                while (true) {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (DebugUtils.DBG) {
                            AidRequester.TAG;
                        }
                        this.mRspLine = readLine;
                    } catch (Exception e22) {
                        if (this.mCallback != null) {
                            this.mCallback.onAidEventChanged(1002, this.mOldAid);
                        }
                        AidRequester.TAG;
                        e22.toString();
                    }
                }
            } else {
                AidRequester.TAG;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    if (DebugUtils.DBG) {
                        AidRequester.TAG;
                    }
                } catch (IOException e3) {
                    AidRequester.TAG;
                    e3.toString();
                }
            }
            if (this.mCallback == null) {
                synchronized (AidRequester.this.mLock) {
                    AidRequester.this.mLock.notifyAll();
                }
                return;
            }
            readLine = AidRequester.getAidFromJsonRsp(this.mRspLine, this.mOldAid);
            this.mCallback.onAidEventChanged(1001, readLine);
            AidStorageController.setAidValueToSP(AidRequester.this.mContext, this.mAppName, readLine, this.mToken);
        }

        public String getResponseLine() {
            return this.mRspLine;
        }
    }

    public static synchronized AidRequester getInstance(Context context) {
        synchronized (AidRequester.class) {
            if (sAidRequester == null) {
                sAidRequester = new AidRequester(context);
            }
            context = sAidRequester;
        }
        return context;
    }

    public AidRequester(Context context) {
        this.mContext = context;
    }

    public void postRestAsync(String str, String str2, String str3, String str4, AidCallback aidCallback) {
        str3 = getPostUrl(str, str2, str3, str4);
        if (DebugUtils.DBG) {
            StringBuilder stringBuilder = new StringBuilder("url:");
            stringBuilder.append(str3);
            stringBuilder.append("; len:");
            stringBuilder.append(str3.length());
        }
        new PostRestThread(new HttpPost(str3), aidCallback, str4, str, str2).start();
    }

    public String postRest(String str, String str2, String str3, String str4) {
        str = getPostUrl(str, str2, str3, str4);
        str2 = NetworkUtils.isConnectedToWeakNetwork(this.mContext) != null ? 3000 : 1000;
        if (DebugUtils.DBG != null) {
            str3 = new StringBuilder("url:");
            str3.append(str);
            str3.append("; timeout:");
            str3.append(str2);
        }
        str = new PostRestThread(new HttpPost(str));
        str.start();
        try {
            synchronized (this.mLock) {
                this.mLock.wait((long) str2);
            }
        } catch (String str22) {
            str22.toString();
        }
        str = str.getResponseLine();
        str22 = DebugUtils.DBG;
        return getAidFromJsonRsp(str, str4);
    }

    private static String getAidFromJsonRsp(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string;
                if (jSONObject.has("data") != null) {
                    str = jSONObject.getJSONObject("data");
                    if (str.has("action") && str.has("aid")) {
                        string = str.getString("action");
                        if (string.equalsIgnoreCase("new") || string.equalsIgnoreCase(RSP_ACTION_CHANGED)) {
                            return str.getString("aid");
                        }
                    }
                } else if (!(jSONObject.has(NAME_RESULT_ISERROR) == null || jSONObject.has("status") == null)) {
                    str = jSONObject.getString(NAME_RESULT_ISERROR);
                    string = jSONObject.getString("status");
                    if (!(str.equalsIgnoreCase(RSP_ISERROR_TRUE) == null || (string.equalsIgnoreCase(RSP_STATUS_INVALID_APP) == null && string.equalsIgnoreCase(RSP_STATUS_INVALID_TOKEN) == null))) {
                        str = DebugUtils.DBG;
                        return "";
                    }
                }
            } catch (String str3) {
                str3.toString();
            } catch (String str32) {
                str32.toString();
            }
        }
        return str2;
    }

    private static String getPostUrl(String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            str3 = URLEncoder.encode(str3, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        stringBuilder.append(AIDSERVER);
        stringBuilder.append(str);
        stringBuilder.append("/get_aid/?auth[token]=");
        stringBuilder.append(str2);
        stringBuilder.append("&type=utdid&id=");
        stringBuilder.append(str3);
        stringBuilder.append(NAME_AID);
        stringBuilder.append(str4);
        return stringBuilder.toString();
    }
}
