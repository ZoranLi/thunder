package com.xunlei.downloadprovider.web.base.core;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.UTMini;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.message.MsgConstant;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.thunderserver.request.BasicRequest;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cardslide.u;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.m;
import com.xunlei.downloadprovider.download.c;
import com.xunlei.downloadprovider.download.create.DownData;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.l.b;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.shortvideo.videodetail.LongVideoDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class DefaultJsInterface extends BaseJsInterface {
    ae mJsInterfaceClientSettings = new ae();
    private List<ag> mMessageInterceptorList = new ArrayList();
    private b mPayListener = new l(this);
    private Runnable mPayListenerRemoveRunnable = new k(this);

    public final ae getJsInterfaceClientSettings() {
        return this.mJsInterfaceClientSettings;
    }

    public DefaultJsInterface(Context context, CustomWebView customWebView) {
        super(context, customWebView);
    }

    public final void addInterceptor(ag agVar) {
        this.mMessageInterceptorList.add(agVar);
    }

    public final void removeInterceptor(ag agVar) {
        this.mMessageInterceptorList.remove(agVar);
    }

    public final void clearInterceptors() {
        this.mMessageInterceptorList.clear();
    }

    private boolean interceptMessage(MethodName methodName, JSONObject jSONObject, String str) throws JSONException {
        if (!this.mMessageInterceptorList.isEmpty()) {
            for (ag a : this.mMessageInterceptorList) {
                if (a.a(methodName, jSONObject, str)) {
                    return true;
                }
            }
        }
        return null;
    }

    protected final boolean handleMessage(MethodName methodName, JSONObject jSONObject, String str) throws JSONException {
        boolean z = true;
        if (interceptMessage(methodName, jSONObject, str)) {
            return true;
        }
        new StringBuilder("handleMessage methodName=").append(methodName);
        switch (m.a[methodName.ordinal()]) {
            case 1:
                xlGetUserInfo(jSONObject, str);
                break;
            case 2:
                xlGetNetworkInfo(str);
                break;
            case 3:
                xlCheckAppInstalled(jSONObject, str);
                break;
            case 4:
                xlShowToast(jSONObject);
                break;
            case 5:
                xlOpenUrl(jSONObject, str);
                break;
            case 6:
                xlGetAppMetaData(str);
                break;
            case 7:
                xlAddTask(jSONObject, getJsInterfaceClientSettings().a);
                break;
            case 8:
                xlSocialShare(jSONObject, str);
                break;
            case 9:
                xlHttpRequest(jSONObject, str);
                break;
            case 10:
                xlReportStatistics(jSONObject, str);
                break;
            case 11:
                xlShowLoading();
                break;
            case 12:
                xlHideLoading();
                break;
            case 13:
                callbackWithOneParam(str, "from", getWebView() != null ? getWebView().getFrom() : "");
                break;
            case 14:
                xlVideoPlay(jSONObject, str);
                break;
            case 15:
                xlGotoShortMovieDetail(jSONObject, str);
                break;
            case 16:
                xlLogout(jSONObject, str);
                break;
            case 17:
                xlOpenLocalPage(jSONObject, str);
                break;
            case 18:
                xlOpenApp(jSONObject, str);
                break;
            case 19:
                xlPay(jSONObject, str);
                break;
            case 20:
                xlGetSniffConfig(str);
                break;
            case 21:
                xlStartSniff(jSONObject);
                break;
            case 22:
                xlGetConfig(jSONObject, str);
                break;
            case 23:
                xlSetConfig(jSONObject, str);
                break;
            case 24:
                xlJumpToDetailPage(jSONObject);
                break;
            case 25:
                xlOpenSearchResultResoucre(jSONObject);
                break;
            case 26:
                copyToClipboard(jSONObject);
                return true;
            case 27:
                xlGoToAnchorHomePage(jSONObject);
                return true;
            case 28:
                xlGotoPublisherPage(jSONObject);
                return true;
            case 29:
                xlOpenClientPage(jSONObject, str);
                return true;
            case 30:
                xlUserSignInfo(jSONObject);
                return true;
            case 31:
                xlAuthWechat(str);
                return true;
            case 32:
                if (!(getContext() == null || (getContext() instanceof Activity) == null)) {
                    ((Activity) getContext()).finish();
                    break;
                }
            case 33:
                xlBindThirdAccount(jSONObject, str);
                return true;
            case 34:
                xlJumpDeepLink(jSONObject, str);
                return true;
            default:
                z = false;
                break;
        }
        return z;
    }

    private void xlGetConfig(JSONObject jSONObject, String str) {
        jSONObject = jSONObject.optString("key");
        Object obj = "";
        JSONObject jSONObject2 = new JSONObject();
        int i = 1;
        if ("lixian.auto_sync_to_lixian_space".equals(jSONObject)) {
            LoginHelper.a();
            if (l.c() == null || LoginHelper.a().l() == null) {
                obj = String.valueOf(SettingStateController.getInstance().getAutoSyncToLixianSpaceFlag());
            } else {
                obj = "true";
            }
        } else if ("thunder_android_global_config".equals(jSONObject) != null) {
            obj = d.a().b();
        } else {
            i = 0;
        }
        try {
            jSONObject2.put(RequestHeaders.COLUMN_VALUE, obj);
        } catch (JSONObject jSONObject3) {
            jSONObject3.printStackTrace();
        }
        jSONObject3 = new HashMap();
        jSONObject3.put("data", jSONObject2);
        jSONObject3.put("result", Integer.valueOf(i));
        callback(str, jSONObject3);
    }

    private void xlSetConfig(JSONObject jSONObject, String str) {
        int i;
        String optString = jSONObject.optString("key");
        jSONObject = jSONObject.optString(RequestHeaders.COLUMN_VALUE);
        if (!"lixian.auto_sync_to_lixian_space".equals(optString) || TextUtils.isEmpty(jSONObject)) {
            i = 0;
        } else {
            i = 1;
            SettingStateController.getInstance().setAutoSyncToLixianSpaceFlag(Boolean.parseBoolean(jSONObject));
        }
        jSONObject = new HashMap();
        jSONObject.put("result", Integer.valueOf(i));
        callback(str, jSONObject);
    }

    private void xlGetSniffConfig(String str) {
        callbackGetSniffConfigure(str);
    }

    private void callbackGetSniffConfigure(String str) {
        Collection b = m.a().b();
        Map hashMap = new HashMap();
        hashMap.put("keyword_suffix", new JSONArray(b));
        callback(str, hashMap);
    }

    private void xlStartSniff(JSONObject jSONObject) {
        String optString = jSONObject.optString("keyword");
        jSONObject = jSONObject.optString("suffix");
        if (!TextUtils.isEmpty(jSONObject)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(optString);
            stringBuilder.append(" ");
            stringBuilder.append(jSONObject);
            optString = stringBuilder.toString();
        }
        a.a();
        a.a(getContext(), 0, optString, false, BrowserFrom.SEARCH_RESULT);
    }

    private void xlLogout(JSONObject jSONObject, String str) {
        LoginHelper.a().a(new i(this, str));
    }

    private void xlHideLoading() {
        if (getWebView() != null) {
            getWebView().a(false);
        }
    }

    private void xlShowLoading() {
        if (getWebView() != null) {
            getWebView().a();
        }
    }

    private void xlVideoPlay(JSONObject jSONObject, String str) throws JSONException {
        String string = jSONObject.getString("url");
        jSONObject.optString("title");
        long parseLong = Long.parseLong(jSONObject.getString("fileSize"));
        jSONObject = jSONObject.optString("playFrom");
        if (TextUtils.isEmpty(jSONObject) != null) {
            jSONObject = "webpage";
        }
        c.a(string, "", parseLong, "", new TaskStatInfo(string, ""), null, new n(this, jSONObject));
    }

    private void xlGotoShortMovieDetail(JSONObject jSONObject, String str) throws JSONException {
        str = jSONObject.getString("movieid");
        String string = jSONObject.getString("gcid");
        jSONObject = jSONObject.optString("from");
        ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
        aVar.u = From.WEB;
        if (From.WITHDRAW.getText().equals(jSONObject)) {
            aVar.u = From.WITHDRAW;
        } else if (From.CINECISM_MORE_RECOMMEND.getText().equals(jSONObject)) {
            aVar.u = From.CINECISM_MORE_RECOMMEND;
        }
        aVar.a = str;
        aVar.b = string;
        ShortMovieDetailActivity.a(getContext(), aVar);
        if (From.CINECISM_MORE_RECOMMEND.getText().equals(jSONObject) != null && (getContext() instanceof CinecismDetailActivity) != null) {
            ((CinecismDetailActivity) getContext()).finish();
        }
    }

    private void xlGetNetworkInfo(String str) {
        int networkType = getNetworkType();
        String c = com.xunlei.xllib.android.b.c(BrothersApplication.getApplicationInstance());
        Map hashMap = new HashMap();
        hashMap.put("status", String.valueOf(networkType));
        hashMap.put("alias", String.valueOf(c));
        callback(str, hashMap);
    }

    private int getNetworkType() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        int i = 0;
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            i = 1;
        } else if (type == 0) {
            i = 2;
        }
        return i;
    }

    private void xlCheckAppInstalled(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            ArrayList arrayList = new ArrayList();
            jSONObject = jSONObject.getJSONArray("pkgNameList");
            for (int i = 0; i < jSONObject.length(); i++) {
                arrayList.add(jSONObject.getString(i));
            }
            if (arrayList.isEmpty() == null) {
                callback(str, checkAppInstalled(arrayList));
            }
        }
    }

    private Map<String, Object> checkAppInstalled(ArrayList<String> arrayList) {
        Map<String, Object> hashMap = new HashMap();
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                List<PackageInfo> installedPackages = getContext().getPackageManager().getInstalledPackages(8192);
                arrayList = arrayList.iterator();
                while (arrayList.hasNext()) {
                    String str = (String) arrayList.next();
                    boolean z = false;
                    for (PackageInfo packageInfo : installedPackages) {
                        if (str.equals(packageInfo.packageName)) {
                            z = true;
                            break;
                        }
                    }
                    hashMap.put(str, Boolean.valueOf(z));
                }
                return hashMap;
            }
        }
        return hashMap;
    }

    private void xlShowToast(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            Object string = jSONObject.getString("message");
            if (!TextUtils.isEmpty(string)) {
                if (jSONObject.optInt("type") != 1) {
                    Toast.makeText(getContext(), string, 0).show();
                } else {
                    XLToast.showToast(getContext(), string);
                }
            }
        }
    }

    private void xlOpenSearchResultResoucre(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString(AgooConstants.MESSAGE_ID);
            String optString3 = jSONObject.optString("title");
            if (!TextUtils.isEmpty(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    if (optString.equals("shortVideo")) {
                        ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
                        aVar.u = From.SEARCH_RESULT_PAGE;
                        aVar.a = optString2;
                        aVar.b = jSONObject.optString("gcid");
                        aVar.s = null;
                        ShortMovieDetailActivity.a(getContext(), aVar);
                    } else if (optString.equals("publicno")) {
                        com.xunlei.downloadprovider.personal.user.account.m.a(getContext(), Long.valueOf(optString2).longValue(), "pub", optString3, "", PublisherActivity.From.SEARCH_RESULT);
                    } else {
                        if (optString.equals("youliao")) {
                            String optString4 = jSONObject.optString("avatar_url", "");
                            com.xunlei.downloadprovider.personal.user.account.m.a(getContext(), Long.valueOf(optString2).longValue(), jSONObject.optString("kind", ""), optString3, optString4, PublisherActivity.From.SEARCH_RESULT);
                        }
                    }
                }
            }
        }
    }

    private void xlOpenUrl(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String string = jSONObject.getString("url");
            int i = jSONObject.getInt("openType");
            jSONObject = jSONObject.optString("from");
            switch (i) {
                case 1:
                    a.a();
                    a.a(getContext(), string, optString, jSONObject);
                    return;
                case 2:
                    handleBrowserOpenUrl(str, string);
                    return;
                case 3:
                    jSONObject = BrowserFrom.fromString(jSONObject);
                    a.a();
                    a.a(getContext(), 0, string, false, jSONObject);
                    return;
                case 4:
                    LongVideoDetailActivity.a(getContext(), jSONObject, string, optString);
                    break;
                default:
                    break;
            }
        }
    }

    private void handleBrowserOpenUrl(String str, String str2) {
        try {
            Intent xLIntent = new XLIntent();
            xLIntent.setAction("android.intent.action.VIEW");
            xLIntent.setData(Uri.parse(str2));
            getContext().startActivity(xLIntent);
        } catch (String str22) {
            if (str22 instanceof ActivityNotFoundException) {
                openUrlCallback(str, 2, "ActivityNotFoundException");
            } else {
                openUrlCallback(str, 2, str22.getMessage());
            }
        }
    }

    private void openUrlCallback(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("openType", Integer.valueOf(i));
        hashMap.put("errorMsg", str2);
        callback(str, hashMap);
    }

    private void xlGetAppMetaData(String str) {
        Map hashMap = new HashMap();
        hashMap.put("versionCode", Integer.valueOf(11100));
        hashMap.put("appVersion", "5.60.2.5510");
        hashMap.put("systemVersion", Integer.valueOf(AndroidConfig.getAndroidVersion()));
        hashMap.put("productID", AndroidConfig.getProductId());
        hashMap.put("peerID", AndroidConfig.getPeerid());
        hashMap.put("partnerID", AndroidConfig.getPartnerId());
        hashMap.put("deviceGuid", AndroidConfig.getHubbleDeviceGUID());
        hashMap.put("businessType", Integer.valueOf(40));
        callback(str, af.a(hashMap));
    }

    public final void xlAddTask(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            try {
                if (getContext() != null) {
                    String string = jSONObject.getString("url");
                    String optString = jSONObject.optString(com.alipay.sdk.cons.c.e);
                    String optString2 = jSONObject.optString("refurl");
                    jSONObject = jSONObject.optString("createOrigin");
                    if (TextUtils.isEmpty(optString2) && getWebView() != null) {
                        optString2 = getWebView().getUrl();
                    }
                    if (TextUtils.isEmpty(jSONObject)) {
                        jSONObject = "browser/other";
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject = str;
                        }
                    }
                    if (TextUtils.isEmpty(string) != null) {
                        XLToast.showToast(getContext(), getContext().getResources().getString(R.string.empty_download_url));
                        return;
                    }
                    str = new TaskStatInfo(jSONObject, string, optString2);
                    str.h = com.xunlei.downloadprovider.download.engine.report.a.b(string);
                    jSONObject = new DownData();
                    jSONObject.b = string;
                    if (!k.g(string)) {
                        jSONObject.a = optString;
                        jSONObject.a(optString2);
                    }
                    jSONObject.b();
                    c.a(getContext(), jSONObject, str, null);
                }
            } catch (JSONObject jSONObject2) {
                XLToast.showToast(getContext(), getContext().getResources().getString(R.string.invalid_json_data));
                throw jSONObject2;
            }
        }
    }

    private void xlSocialShare(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            f a;
            String str2;
            ShareOperationType shareOperationType;
            ShareOperationType shareOperationType2;
            Activity activity;
            o oVar;
            o oVar2;
            int i = jSONObject2.getInt("sharePlatform");
            String optString = jSONObject2.optString("shareResId");
            String optString2 = jSONObject2.optString("sharePublisherId");
            String optString3 = jSONObject2.optString("shareHeadline");
            String optString4 = jSONObject2.optString("shareText");
            String optString5 = jSONObject2.optString("shareImageUrl");
            String optString6 = jSONObject2.optString("shareUrl");
            String optString7 = jSONObject2.optString("shareType");
            String optString8 = jSONObject2.optString("shareFrom");
            String optString9 = jSONObject2.optString("gcid");
            String str3 = TextUtils.isEmpty(optString8) ? "web" : optString8;
            f fVar = new f(optString8, optString6, optString3);
            fVar.d = optString4;
            fVar.h = optString5;
            if ("ONLY_IMG".equals(optString7)) {
                optString4 = DispatchConstants.OTHER;
                fVar.l = 2;
            } else if ("RED_PACKET_VIDEO".equals(optString7)) {
                a = com.xunlei.downloadprovider.f.c.a(getContext(), str3, optString, optString3, optString2, optString5, 0, 0, n.c, false);
                str2 = "shortvideo";
                shareOperationType = null;
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        shareOperationType = ShareOperationType.WEIXIN;
                        break;
                    case 2:
                        shareOperationType = ShareOperationType.WEIXIN_CIRCLE;
                        break;
                    case 3:
                        shareOperationType = ShareOperationType.QZONE;
                        break;
                    case 4:
                        shareOperationType = ShareOperationType.SINA;
                        break;
                    case 5:
                        shareOperationType = ShareOperationType.QQ;
                        break;
                    default:
                        break;
                }
                shareOperationType2 = shareOperationType;
                if (shareOperationType2 != null) {
                    com.xunlei.downloadprovider.f.a.a();
                    activity = (Activity) getContext();
                    oVar = oVar2;
                    optString8 = str2;
                    oVar2 = new o(this, optString, optString9, optString8, str3, optString2, str2, str);
                    com.xunlei.downloadprovider.f.a.a(activity, a, oVar);
                } else {
                    optString8 = str2;
                    com.xunlei.downloadprovider.f.a.a();
                    com.xunlei.downloadprovider.f.a.a((Activity) getContext(), shareOperationType2, a, new p(this, str3, optString, optString2, optString8, str));
                }
                u.b(str3, optString, optString2, optString8);
            } else {
                optString4 = DispatchConstants.OTHER;
            }
            str2 = optString4;
            a = fVar;
            shareOperationType = null;
            switch (i) {
                case 0:
                    break;
                case 1:
                    shareOperationType = ShareOperationType.WEIXIN;
                    break;
                case 2:
                    shareOperationType = ShareOperationType.WEIXIN_CIRCLE;
                    break;
                case 3:
                    shareOperationType = ShareOperationType.QZONE;
                    break;
                case 4:
                    shareOperationType = ShareOperationType.SINA;
                    break;
                case 5:
                    shareOperationType = ShareOperationType.QQ;
                    break;
                default:
                    break;
            }
            shareOperationType2 = shareOperationType;
            if (shareOperationType2 != null) {
                optString8 = str2;
                com.xunlei.downloadprovider.f.a.a();
                com.xunlei.downloadprovider.f.a.a((Activity) getContext(), shareOperationType2, a, new p(this, str3, optString, optString2, optString8, str));
            } else {
                com.xunlei.downloadprovider.f.a.a();
                activity = (Activity) getContext();
                oVar = oVar2;
                optString8 = str2;
                oVar2 = new o(this, optString, optString9, optString8, str3, optString2, str2, str);
                com.xunlei.downloadprovider.f.a.a(activity, a, oVar);
            }
            u.b(str3, optString, optString2, optString8);
        }
    }

    private void xlGetUserInfo(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            int i = jSONObject.getInt("forceLogin");
            String optString = jSONObject.optString("source");
            jSONObject = jSONObject.optInt("businessType", UTMini.EVENTID_AGOO);
            Object obj = 1;
            if (i != 1) {
                obj = null;
            }
            LoginHelper.a();
            if (obj == null || l.b()) {
                callbackGetUserInfo(str, jSONObject);
            } else {
                startLoginDlgActivity(optString, str, jSONObject);
            }
        }
    }

    private void startLoginDlgActivity(String str, String str2, int i) {
        if (!((Activity) getContext()).isFinishing()) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = -1;
                switch (str.hashCode()) {
                    case -1097929876:
                        if (str.equals("user_discuss") != null) {
                            obj = 2;
                            break;
                        }
                        break;
                    case -902468670:
                        if (str.equals("signIn") != null) {
                            obj = 3;
                            break;
                        }
                        break;
                    case 109637894:
                        if (str.equals("space") != null) {
                            obj = 1;
                            break;
                        }
                        break;
                    case 288355239:
                        if (str.equals("income_detail") != null) {
                            obj = 5;
                            break;
                        }
                        break;
                    case 623358647:
                        if (str.equals("任务列表") != null) {
                            obj = 4;
                            break;
                        }
                        break;
                    case 1478793696:
                        if (str.equals("integralMall") != null) {
                            obj = null;
                            break;
                        }
                        break;
                    default:
                        break;
                }
                switch (obj) {
                    case null:
                        str = LoginFrom.GAME_CENTER;
                        break;
                    case 1:
                        str = LoginFrom.SPACE_LI_XIAN;
                        break;
                    case 2:
                        str = LoginFrom.USER_DISCUSS;
                        break;
                    case 3:
                    case 4:
                        str = LoginFrom.TASK_CENTER;
                        break;
                    case 5:
                        str = LoginFrom.INCOME_DETAIL;
                        break;
                    default:
                        str = LoginFrom.H5_OTHER;
                        break;
                }
            }
            str = LoginFrom.H5_OTHER;
            LoginHelper.a().a(getContext(), new q(this, str2, i), str, null);
        }
    }

    private void callbackGetUserInfo(String str, int i) {
        Object jSONObject;
        LoginHelper a = LoginHelper.a();
        Map hashMap = new HashMap();
        if (l.b()) {
            hashMap.put("isLogin", Integer.valueOf(1));
            Map hashMap2 = new HashMap();
            hashMap2.put("sessionID", a.c());
            hashMap2.put("jumpKey", a.a(i));
            hashMap2.put("avatarURL", a.e());
            hashMap2.put("nickName", a.g.d());
            hashMap2.put("userID", Long.valueOf(a.g.c()));
            hashMap2.put("isVip", Integer.valueOf(a.g.e()));
            hashMap2.put("vipType", Integer.valueOf(a.g.f()));
            hashMap2.put("vipLevel", Integer.valueOf(a.m()));
            hashMap2.put("vipExpirationDate", a.o());
            jSONObject = new JSONObject(af.a(hashMap2));
        } else {
            hashMap.put("isLogin", Integer.valueOf(0));
            jSONObject = null;
        }
        hashMap.put(Constants.KEY_USER_ID, jSONObject);
        callback(str, hashMap);
    }

    private void xlHttpRequest(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            String string = jSONObject.getString("url");
            String string2 = jSONObject.getString("method");
            int optInt = jSONObject.optInt(com.alipay.sdk.data.a.f);
            Object optString = jSONObject.optString("postContent");
            String optString2 = jSONObject.optString("contentEncoding");
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            boolean optBoolean = jSONObject.optBoolean("withClientHeader", false);
            if (jSONObject.optBoolean("useUrlSignature", false) != null) {
                jSONObject = new d(string);
                jSONObject.b = "GET";
            } else {
                jSONObject = new a(string);
                jSONObject.b = "GET";
            }
            jSONObject.b = string2;
            jSONObject.g = optInt;
            if (!TextUtils.isEmpty(optString)) {
                jSONObject.d = optString;
                jSONObject.e = optString2;
            }
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                if (keys.hasNext()) {
                    string = (String) keys.next();
                    CharSequence optString3 = optJSONObject.optString(string);
                    if (!(TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString3))) {
                        if (!TextUtils.isEmpty(string)) {
                            jSONObject.c.put(string, optString3);
                        }
                    }
                }
            }
            if (optBoolean) {
                Map hashMap = new HashMap(BasicRequest.buildCommonHeaders());
                hashMap.put("IMEI", AndroidConfig.getIMEI());
                hashMap.put("User-Id", String.valueOf(LoginHelper.a().g.c()));
                jSONObject.c.putAll(hashMap);
            }
            jSONObject.f = new s(this, str);
            new StringBuilder("xlHttpRequest: ").append(jSONObject);
            XLThreadPool.execute(new x(sJsHttpClient, jSONObject));
        }
    }

    private void httpRequestCallback(String str, boolean z, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("isSuccess", Boolean.valueOf(z));
        hashMap.put("responseText", str2);
        hashMap.put("status", Integer.valueOf(i));
        callback(str, hashMap);
    }

    private void xlReportStatistics(JSONObject jSONObject, String str) {
        try {
            str = new JSONObject(jSONObject.toString());
            jSONObject = str.optInt("reportPlat");
            StatEvent build = HubbleEventBuilder.build(str.optString("hubbleEventId"), str.optString("hubbleAttribute1"));
            str = str.optJSONObject("hubbleExData");
            if (str != null) {
                Iterator keys = str.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    if (!str.isNull(str2)) {
                        Object optString = str.optString(str2);
                        if (!TextUtils.isEmpty(optString)) {
                            build.add(str2, optString);
                        }
                    }
                }
            }
            new StringBuilder("statFields=").append(build);
            if (jSONObject == null) {
                ThunderReport.reportEvent(build);
                return;
            }
            if (jSONObject == 1) {
                ThunderReport.reportEvent(build);
            }
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
    }

    private void xlOpenLocalPage(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            str = jSONObject.getInt("openType");
            jSONObject.optString("from");
            if (str == 1) {
                str = jSONObject.optInt("vodType", -1);
                String optString = jSONObject.optString("vodTypeName");
                Object string = jSONObject.getString(AgooConstants.MESSAGE_ID);
                jSONObject = jSONObject.getString("gcid");
                if (!TextUtils.isEmpty(string)) {
                    ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
                    aVar.j = (long) str;
                    aVar.l = optString;
                    aVar.u = From.SHARE_PAGE;
                    aVar.a = string;
                    aVar.b = jSONObject;
                    ShortMovieDetailActivity.a(getContext(), aVar);
                }
            }
        }
    }

    private void xlOpenClientPage(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            str = jSONObject.optString("clientPageName");
            String optString = jSONObject.optString("from");
            if (!TextUtils.isEmpty(str)) {
                Object obj = -1;
                int hashCode = str.hashCode();
                if (hashCode != -756406816) {
                    if (hashCode != -486325234) {
                        if (hashCode != 943438604) {
                            if (hashCode == 1674259163) {
                                if (str.equals("xlliveRoom") != null) {
                                    obj = 2;
                                }
                            }
                        } else if (str.equals("videoRelease") != null) {
                            obj = 3;
                        }
                    } else if (str.equals("homePage") != null) {
                        obj = null;
                    }
                } else if (str.equals("xllive") != null) {
                    obj = 1;
                }
                switch (obj) {
                    case null:
                        MainTabActivity.b(getContext(), "thunder", null);
                        return;
                    case 1:
                        MainTabActivity.b(getContext(), "xllive", null);
                        return;
                    case 2:
                        com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(getContext(), jSONObject.optString("roomInfo"), optString);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void releaseCallback(String str, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("result", z ? "success" : "fail");
        callback(str, hashMap);
        new StringBuilder("paramJson = ").append(hashMap.toString());
    }

    private void xlUserSignInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            Object obj = 1;
            if (jSONObject.optInt("sign") != 1) {
                obj = null;
            }
            if (obj != null) {
                com.xunlei.downloadprovider.personal.a.e.b.a().a(new t(this));
                com.xunlei.downloadprovider.personal.a.a.a().d();
            }
        }
    }

    private void xlAuthWechat(String str) {
        com.xunlei.downloadprovider.member.login.a.a a = com.xunlei.downloadprovider.member.login.a.a.a();
        a.c = new u(this, str);
        a.a = true;
        str = WXAPIFactory.createWXAPI(BrothersApplication.getApplicationInstance(), "wx3e6556568beeebdd", false);
        str.registerApp("wx3e6556568beeebdd");
        BaseReq req = new Req();
        req.scope = "snsapi_userinfo";
        req.state = "com.xunlei.downloadprovider.youliao.score";
        str.sendReq(req);
    }

    private void xlBindThirdAccount(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            jSONObject = jSONObject.optString("type");
            Object obj = -1;
            if (jSONObject.hashCode() == -791770330) {
                if (jSONObject.equals(Token.WX_TOKEN_PLATFORMID_VALUE) != null) {
                    obj = null;
                }
            }
            if (obj == null) {
                bindWeChat(str);
            }
        }
    }

    private void xlJumpDeepLink(org.json.JSONObject r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 != 0) goto L_0x000d;
    L_0x0003:
        r3 = "result";
        r0 = java.lang.Boolean.valueOf(r0);
        r2.callbackWithOneParam(r4, r3, r0);
        return;
    L_0x000d:
        r1 = "url";
        r3 = r3.optString(r1);
        r1 = r2.getContext();	 Catch:{ DeepLinkException -> 0x0025 }
        com.xunlei.downloadprovider.ad.common.browser.a.a(r1, r3);	 Catch:{ DeepLinkException -> 0x0025 }
        r3 = "result";	 Catch:{ DeepLinkException -> 0x0025 }
        r1 = 1;	 Catch:{ DeepLinkException -> 0x0025 }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ DeepLinkException -> 0x0025 }
        r2.callbackWithOneParam(r4, r3, r1);	 Catch:{ DeepLinkException -> 0x0025 }
        return;
    L_0x0025:
        r3 = "result";
        r0 = java.lang.Boolean.valueOf(r0);
        r2.callbackWithOneParam(r4, r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.base.core.DefaultJsInterface.xlJumpDeepLink(org.json.JSONObject, java.lang.String):void");
    }

    private void bindWeChat(String str) {
        if (ApkHelper.isApkPackageInstalled(BrothersApplication.getApplicationInstance(), "com.tencent.mm")) {
            LoginHelper.a().a(21, new v(this, str));
        } else {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "尚未安装微信");
        }
    }

    private void bindThirdAccountCallback(String str, int i, String str2, int i2, String str3) {
        i = i == 21 ? Token.WX_TOKEN_PLATFORMID_VALUE : "";
        Map hashMap = new HashMap();
        hashMap.put("type", i);
        hashMap.put("result", str2);
        hashMap.put("errorCode", Integer.valueOf(i2));
        hashMap.put("errorDes", str3);
        callback(str, hashMap);
    }

    private void xlOpenApp(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            str = jSONObject.optInt("openType");
            jSONObject = jSONObject.optString("pkgName");
            if (!TextUtils.isEmpty(jSONObject)) {
                if (str == null) {
                    jSONObject = getContext().getPackageManager().getLaunchIntentForPackage(jSONObject);
                    if (jSONObject != null) {
                        getContext().startActivity(jSONObject);
                    }
                }
            }
        }
    }

    private void copyToClipboard(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(MsgConstant.INAPP_LABEL);
            jSONObject = jSONObject.optString("text");
            if (!TextUtils.isEmpty(jSONObject)) {
                com.xunlei.downloadprovider.download.create.m.a().a(jSONObject);
                ClipboardUtil.copyToClipboard(BrothersApplication.getApplicationInstance(), jSONObject, optString);
            }
        }
    }

    private void xlPay(JSONObject jSONObject, String str) throws JSONException {
        int i;
        JSONException jSONException;
        String optString;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            int i2;
            int i3;
            int optInt;
            String optString2;
            String optString3;
            String optString4;
            String optString5;
            String optString6;
            String optString7;
            String optString8;
            String optString9;
            int i4 = jSONObject2.getInt("payType");
            String string = jSONObject2.getString("reportRefer");
            try {
                int i5 = jSONObject2.getInt("monthOrTDays");
                try {
                    i2 = i5;
                    i3 = jSONObject2.getInt("vasType");
                } catch (JSONException e) {
                    i = i5;
                    jSONException = e;
                    jSONException.printStackTrace();
                    i3 = 0;
                    i2 = i;
                    optInt = jSONObject2.optInt("orderType");
                    optString2 = jSONObject2.optString("orderVoucher");
                    optString3 = jSONObject2.optString("orderExtraParam");
                    optString4 = jSONObject2.optString("accessToken");
                    optString5 = jSONObject2.optString("paramExt1");
                    optString6 = jSONObject2.optString("paramExt2");
                    optString7 = jSONObject2.optString("paramOther1");
                    optString8 = jSONObject2.optString("paramOther2");
                    optString9 = jSONObject2.optString("paramOther4");
                    optString = jSONObject2.optString("activeId");
                    attachPayListener();
                    switch (i4) {
                        case 0:
                            return;
                        case 1:
                            gotoWxpay(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9, optString);
                            return;
                        case 2:
                            gotoAlipay(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9, optString);
                            return;
                        case 3:
                            gotoPaymentPage(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9);
                            break;
                        default:
                            break;
                    }
                }
            } catch (JSONException e2) {
                jSONException = e2;
                i = 0;
                jSONException.printStackTrace();
                i3 = 0;
                i2 = i;
                optInt = jSONObject2.optInt("orderType");
                optString2 = jSONObject2.optString("orderVoucher");
                optString3 = jSONObject2.optString("orderExtraParam");
                optString4 = jSONObject2.optString("accessToken");
                optString5 = jSONObject2.optString("paramExt1");
                optString6 = jSONObject2.optString("paramExt2");
                optString7 = jSONObject2.optString("paramOther1");
                optString8 = jSONObject2.optString("paramOther2");
                optString9 = jSONObject2.optString("paramOther4");
                optString = jSONObject2.optString("activeId");
                attachPayListener();
                switch (i4) {
                    case 0:
                        return;
                    case 1:
                        gotoWxpay(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9, optString);
                        return;
                    case 2:
                        gotoAlipay(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9, optString);
                        return;
                    case 3:
                        gotoPaymentPage(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9);
                        break;
                    default:
                        break;
                }
            }
            optInt = jSONObject2.optInt("orderType");
            optString2 = jSONObject2.optString("orderVoucher");
            optString3 = jSONObject2.optString("orderExtraParam");
            optString4 = jSONObject2.optString("accessToken");
            optString5 = jSONObject2.optString("paramExt1");
            optString6 = jSONObject2.optString("paramExt2");
            optString7 = jSONObject2.optString("paramOther1");
            optString8 = jSONObject2.optString("paramOther2");
            optString9 = jSONObject2.optString("paramOther4");
            optString = jSONObject2.optString("activeId");
            attachPayListener();
            switch (i4) {
                case 0:
                    return;
                case 1:
                    gotoWxpay(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9, optString);
                    return;
                case 2:
                    gotoAlipay(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9, optString);
                    return;
                case 3:
                    gotoPaymentPage(str, optString2, optString3, string, i2, optInt, i3, optString4, optString5, optString6, optString7, optString8, optString9);
                    break;
                default:
                    break;
            }
        }
    }

    private void gotoPaymentPage(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, String str7, String str8, String str9, String str10) {
        str = new PayEntryParam((PayFrom) null);
        str.a(str4);
        runOnUiThread(new j(this, str));
    }

    private int gotoAlipay(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        return com.xunlei.downloadprovider.member.payment.external.l.a().a(str11, i, str4, com.xunlei.downloadprovider.member.payment.external.l.a(null, str6, str11, ""), (Activity) getContext(), str);
    }

    private int gotoWxpay(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        return com.xunlei.downloadprovider.member.payment.external.l.a().a(str11, i, str4, com.xunlei.downloadprovider.member.payment.external.l.a(null, str6, str11, ""), str);
    }

    private void xlJumpToDetailPage(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String string = jSONObject.getString("reportRefer");
            String optString = jSONObject.optString("gcid");
            String optString2 = jSONObject.optString(AgooConstants.MESSAGE_ID);
            String optString3 = jSONObject.optString("poster");
            jSONObject.optString("type");
            ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
            aVar.u = From.HOME_HOT_SRC;
            aVar.a = optString2;
            aVar.b = optString;
            aVar.c = string;
            aVar.e = optString3;
            ShortMovieDetailActivity.a(getContext(), aVar);
        }
    }

    @Deprecated
    private void xlGoToAnchorHomePage(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("rad_status");
            jSONObject = jSONObject.optJSONObject(PushResult.ROOM_INFO);
            if (jSONObject != null) {
                Object optString = jSONObject.optString("uid");
                jSONObject = jSONObject.optString("roomInfo");
                if (optInt != 1 || TextUtils.isEmpty(jSONObject)) {
                    if (TextUtils.isEmpty(optString) == null) {
                        com.xunlei.downloadprovider.personal.user.account.m.a(getContext(), Long.valueOf(optString).longValue(), "rad", "", "", PublisherActivity.From.SEARCH_RESULT);
                    }
                    return;
                }
                com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(getContext(), jSONObject, XLLiveRoomPlayFrom.SEARCH_RESULT);
            }
        }
    }

    private void xlGotoPublisherPage(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.optString("pageType");
            jSONObject.optString("title");
            jSONObject.optLong(AgooConstants.MESSAGE_ID);
            jSONObject.optString("icon");
            jSONObject.optString("from");
        }
    }

    private void attachPayListener() {
        removeViewCallbacks(this.mPayListenerRemoveRunnable);
        if (this.mPayListener != null) {
            com.xunlei.downloadprovider.member.payment.external.l.a().b(this.mPayListener);
            com.xunlei.downloadprovider.member.payment.external.l.a().a(this.mPayListener);
        }
    }

    private void detachPayListener() {
        runOnUiThread(this.mPayListenerRemoveRunnable);
    }

    private void authWechatCallback(String str, JSONObject jSONObject) {
        Map hashMap = new HashMap();
        if (jSONObject != null) {
            hashMap.put("status", Boolean.valueOf(true));
            hashMap.put("msg", "success");
            com.xunlei.downloadprovider.member.login.a.d dVar = new com.xunlei.downloadprovider.member.login.a.d();
            if (jSONObject != null) {
                String optString = jSONObject.optString("access_token");
                String optString2 = jSONObject.optString("openid");
                jSONObject = jSONObject.optString("unionid");
                dVar.a = optString;
                dVar.b = optString2;
                dVar.c = jSONObject;
            }
            jSONObject = new HashMap();
            jSONObject.put("unionid", dVar.c);
            jSONObject.put("openid", dVar.b);
            jSONObject.put("phoneNum", LoginHelper.a().i());
            hashMap.put("data", new JSONObject(jSONObject));
        } else {
            hashMap.put("status", Boolean.valueOf(false));
            hashMap.put("msg", "fail");
            hashMap.put("data", "");
        }
        callback(str, hashMap);
    }
}
