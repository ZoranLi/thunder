package com.baidu.mobads.vo;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.qihoo360.replugin.RePlugin;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class XAdInstanceInfo implements Parcelable, IXAdInstanceInfo, Cloneable {
    public static final Creator<XAdInstanceInfo> CREATOR = new a();
    public static final String TAG = "XAdInstanceInfo";
    private int A;
    private int B;
    @Deprecated
    private String C;
    private Set<String> D;
    private Set<String> E;
    private Set<String> F;
    private Set<String> G;
    private Set<String> H;
    private Set<String> I;
    private Set<String> J;
    private Set<String> K;
    private Set<String> L;
    private Set<String> M;
    private int N;
    private boolean O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private long U;
    private int V;
    private String W;
    private int X;
    private boolean Y;
    private long Z;
    private String a;
    private CreativeType aa;
    private String ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private String al;
    private String am;
    private String an;
    private JSONArray ao;
    private boolean ap;
    private String aq;
    private boolean ar;
    private String as;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private String m;
    private String n;
    private boolean o;
    private int p;
    private String q;
    private String r;
    private int s;
    private int t;
    @Deprecated
    private boolean u;
    @Deprecated
    private int v;
    private String w;
    private String x;
    private JSONObject y;
    private String z;

    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.ab;
    }

    public void setUrl(String str) {
        this.ab = str;
    }

    public int getDlTunnel() {
        return this.ac;
    }

    public void setDlTunnel(int i) {
        this.ac = i;
    }

    public boolean isInapp() {
        return this.ad;
    }

    public void setInapp(boolean z) {
        this.ad = z;
    }

    public boolean isClose() {
        return this.ae;
    }

    public void setClose(boolean z) {
        this.ae = z;
    }

    public boolean isAutoOpen() {
        return this.af;
    }

    public void setAutoOpen(boolean z) {
        this.af = z;
    }

    public boolean isPopNotif() {
        return this.ag;
    }

    public void setPopNotif(boolean z) {
        this.ag = z;
    }

    public boolean isWifiTargeted() {
        return this.ah;
    }

    public void setWifiTargeted(boolean z) {
        this.ah = z;
    }

    public boolean isTooLarge() {
        return this.ai;
    }

    public void setTooLarge(boolean z) {
        this.ai = z;
    }

    public boolean isCanCancel() {
        return this.aj;
    }

    public void setCanCancel(boolean z) {
        this.aj = z;
    }

    public boolean isCanDelete() {
        return this.ak;
    }

    public void setCanDelete(boolean z) {
        this.ak = z;
    }

    public CreativeType getCreativeType() {
        return this.aa;
    }

    public void setCreativeType(CreativeType creativeType) {
        this.aa = creativeType;
    }

    public String getFwt() {
        return this.a;
    }

    public void setFwt(String str) {
        this.a = str;
    }

    public String getAdId() {
        return this.b;
    }

    public void setAdId(String str) {
        this.b = str;
    }

    public Boolean isValid() {
        return Boolean.valueOf(RePlugin.PROCESS_UI.equalsIgnoreCase(getAdId()) ^ 1);
    }

    public String getAdSource() {
        return this.c;
    }

    public void setAdSource(String str) {
        this.c = str;
    }

    public String getTitle() {
        return this.d;
    }

    public void setTitle(String str) {
        this.d = str;
    }

    public String getDescription() {
        return this.e;
    }

    public void setDescription(String str) {
        this.e = str;
    }

    public String getSponsorUrl() {
        return this.f;
    }

    public void setSponsorUrl(String str) {
        this.f = str;
    }

    public String getMaterialType() {
        return this.g;
    }

    public void setMaterialType(String str) {
        this.g = str;
    }

    public String getPhoneNumber() {
        return this.h;
    }

    public void setPhoneNumber(String str) {
        this.h = str;
    }

    public String getMainPictureUrl() {
        return this.i;
    }

    public void setMainPictureUrl(String str) {
        this.i = str;
    }

    public String getIconUrl() {
        return this.j;
    }

    public void setIconUrl(String str) {
        this.j = str;
    }

    public String getExp2ForSingleAd() {
        return this.k;
    }

    public void setExp2ForSingleAd(String str) {
        this.k = str;
    }

    public int getAntiTag() {
        return this.l;
    }

    public void setAntiTag(int i) {
        this.l = i;
    }

    public String getLocalCreativeURL() {
        return this.m;
    }

    public void setLocalCreativeURL(String str) {
        this.m = str;
    }

    public String getVideoUrl() {
        return this.n;
    }

    public void setVideoUrl(String str) {
        this.n = str;
    }

    public boolean isVideoMuted() {
        return this.o;
    }

    public void setVideoMuted(boolean z) {
        this.o = z;
    }

    public int getVideoDuration() {
        return this.p;
    }

    public void setVideoDuration(int i) {
        this.p = i;
    }

    public boolean isIconVisibleForImageType() {
        return this.u;
    }

    public void setIconVisibleForImageType(boolean z) {
        this.u = z;
    }

    public int getHoursInADayToShowAd() {
        return this.v;
    }

    public void setHoursInADayToShowAd(int i) {
        this.v = i;
    }

    public String getClickThroughUrl() {
        return this.w;
    }

    public void setClickThroughUrl(String str) {
        this.w = str;
    }

    public String getOriginClickUrl() {
        return this.x;
    }

    public void setOriginClickUrl(String str) {
        this.x = str;
    }

    public String getHtmlSnippet() {
        return this.z;
    }

    public void setHtmlSnippet(String str) {
        this.z = str;
    }

    public int getMainMaterialWidth() {
        return this.A;
    }

    public void setMainMaterialWidth(int i) {
        this.A = i;
    }

    public int getMainMaterialHeight() {
        return this.B;
    }

    public void setMainMaterialHeight(int i) {
        this.B = i;
    }

    public String getPhoneForLocalBranding() {
        return this.C;
    }

    public void setPhoneForLocalBranding(String str) {
        this.C = str;
    }

    public Set<String> getImpressionUrls() {
        return this.D;
    }

    public void setImpressionUrls(Set<String> set) {
        this.D = set;
    }

    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.E);
    }

    public void setThirdImpressionTrackingUrls(Set<String> set) {
        this.E = set;
    }

    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.F);
    }

    public void setThirdClickTrackingUrls(Set<String> set) {
        this.F = set;
    }

    public int getActionType() {
        return this.N;
    }

    public void setActionType(int i) {
        this.N = i;
    }

    public boolean isActionOnlyWifi() {
        return this.O;
    }

    public void setActionOnlyWifi(boolean z) {
        this.O = z;
    }

    public String getConfirmBorderPercent() {
        return this.P;
    }

    public void setConfirmBorderPercent(String str) {
        this.P = str;
    }

    public String getQueryKey() {
        return this.Q;
    }

    public void setQueryKey(String str) {
        this.Q = str;
    }

    public String getAppPackageName() {
        return this.S;
    }

    public void setAppPackageName(String str) {
        this.S = str;
    }

    public String getAppName() {
        return this.T;
    }

    public void setAppName(String str) {
        this.T = str;
    }

    public long getAppSize() {
        return this.U;
    }

    public void setAppSize(long j) {
        this.U = j;
    }

    public int getSwitchButton() {
        return this.V;
    }

    public void setSwitchButton(int i) {
        this.V = i;
    }

    public String getAppOpenStrs() {
        return this.W;
    }

    public void setAppOpenStrs(String str) {
        this.W = str;
    }

    public int getPointsForWall() {
        return this.X;
    }

    public void setPointsForWall(int i) {
        this.X = i;
    }

    public boolean isTaskDoneForWall() {
        return this.Y;
    }

    public void setTaskDoneForWall(boolean z) {
        this.Y = z;
    }

    public JSONObject getOriginJsonObject() {
        return this.y;
    }

    public String getVurl() {
        return this.al;
    }

    public void setVurl(String str) {
        this.al = str;
    }

    public String getClklogurl() {
        return this.am;
    }

    public void setClklogurl(String str) {
        this.am = str;
    }

    public String getWinurl() {
        return this.an;
    }

    public void setWinurl(String str) {
        this.an = str;
    }

    public JSONArray getNwinurl() {
        return this.ao;
    }

    public void setNwinurl(JSONArray jSONArray) {
        this.ao = jSONArray;
    }

    @SuppressLint({"DefaultLocale"})
    public XAdInstanceInfo(JSONObject jSONObject) {
        this.b = RePlugin.PROCESS_UI;
        this.q = "";
        this.r = "";
        this.s = 0;
        this.t = 0;
        this.D = new HashSet();
        this.E = new HashSet();
        this.F = new HashSet();
        this.G = new HashSet();
        this.H = new HashSet();
        this.I = new HashSet();
        this.J = new HashSet();
        this.K = new HashSet();
        this.L = new HashSet();
        this.M = new HashSet();
        this.O = true;
        this.aa = CreativeType.NONE;
        this.ad = true;
        this.af = true;
        this.ag = true;
        this.ap = false;
        this.ar = false;
        this.as = null;
        this.y = jSONObject;
        try {
            String optString;
            int i;
            String optString2;
            this.Z = System.currentTimeMillis();
            this.N = jSONObject.optInt(SocialConstants.PARAM_ACT);
            this.z = jSONObject.optString("html", null);
            this.b = jSONObject.optString(AgooConstants.MESSAGE_ID, RePlugin.PROCESS_UI);
            this.c = jSONObject.optString("src", "");
            this.d = jSONObject.optString("tit", "");
            this.e = jSONObject.optString("desc", "");
            this.f = jSONObject.optString("surl", "");
            this.h = jSONObject.optString("phone", "");
            this.i = jSONObject.optString("w_picurl", "");
            this.j = jSONObject.optString("icon", "");
            this.k = jSONObject.optString("exp2", "{}");
            this.l = jSONObject.optInt("anti_tag");
            this.n = jSONObject.optString("vurl", "");
            this.p = jSONObject.optInt(SocializeProtocolConstants.DURATION, 0);
            this.o = jSONObject.optInt("sound", 0) != 1;
            this.u = jSONObject.optInt("iv", 0) == 1;
            this.v = jSONObject.optInt("dur", 0);
            this.w = jSONObject.optString("curl", "");
            this.x = jSONObject.optString("ori_curl", "");
            this.g = jSONObject.optString("type");
            if (this.z != null && this.z.length() > 0) {
                this.aa = CreativeType.HTML;
            } else if (this.g != null) {
                if (this.g.equals("text")) {
                    this.aa = CreativeType.TEXT;
                } else if (this.g.equals("image")) {
                    if (!(this.i == null || this.i.equals(""))) {
                        int lastIndexOf = this.i.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        String str = "";
                        if (lastIndexOf >= 0) {
                            str = this.i.toLowerCase(Locale.getDefault()).substring(lastIndexOf);
                        }
                        if (str.equals(".gif")) {
                            this.aa = CreativeType.GIF;
                        } else {
                            this.aa = CreativeType.STATIC_IMAGE;
                        }
                    }
                } else if (this.g.equals("rm")) {
                    this.aa = CreativeType.RM;
                } else if (this.g.equals("video")) {
                    this.aa = CreativeType.VIDEO;
                }
            }
            this.A = jSONObject.optInt(IXAdRequestInfo.WIDTH);
            this.B = jSONObject.optInt(IXAdRequestInfo.HEIGHT);
            this.C = jSONObject.optString("lb_phone", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("nwinurl");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                optString = jSONObject.optString("winurl", "");
                if (!optString.equals("")) {
                    this.D.add(optString);
                }
            } else {
                for (i = 0; i < optJSONArray.length(); i++) {
                    this.D.add(optJSONArray.getString(i));
                }
            }
            optString = jSONObject.optString("clklogurl", "");
            if (!optString.equals("")) {
                this.D.add(optString);
            }
            optJSONArray = jSONObject.optJSONArray("mon");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString3 = jSONObject2.optString("s", "");
                    optString2 = jSONObject2.optString(c.a, "");
                    a(optString3);
                    b(optString2);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("monitors");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    optString2 = (String) keys.next();
                    JSONArray optJSONArray2;
                    int i2;
                    if (optString2.equals("s")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals("vskip")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addSkipMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals("scard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addScardMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals("ccard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addCcardMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals("vstart")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addStartMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals("vfullscreen")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addFullScreenMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals("vclose")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addCloseMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals("cstartcard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addCstartcardMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (optString2.equals(c.a)) {
                        optJSONArray2 = optJSONObject.optJSONArray(optString2);
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            b(optJSONArray2.optString(i2));
                        }
                    }
                }
            }
            this.O = true;
            this.P = jSONObject.optString("cf", "");
            this.Q = jSONObject.optString("qk", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.Q);
            stringBuilder.append("_");
            stringBuilder.append(new Random().nextLong());
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("|");
            this.R = stringBuilder.toString();
            this.T = jSONObject.optString("appname", "");
            this.S = jSONObject.optString(IXAdRequestInfo.PACKAGE, "");
            this.U = jSONObject.optLong("sz", 0);
            this.V = jSONObject.optInt("sb", 0);
            this.W = jSONObject.optString("apo", "");
            this.X = jSONObject.optInt("po", 0);
            this.Y = jSONObject.optInt(SocializeProtocolConstants.PROTOCOL_KEY_ST, 0) == 1;
            this.r = jSONObject.optString("murl", "");
            if (this.g.equals("video") && this.r.length() > 0) {
                this.s = jSONObject.optInt(IXAdRequestInfo.WIDTH, 0);
                this.t = jSONObject.optInt(IXAdRequestInfo.HEIGHT, 0);
                this.q = "video";
                if (this.N == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeLandingPage()) {
                    this.r = this.w;
                }
            }
        } catch (JSONObject jSONObject3) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(TAG, jSONObject3.getMessage());
        }
    }

    final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.E.add(str);
        }
    }

    final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.F.add(str);
        }
    }

    public void addStartMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.G.add(str);
        }
    }

    public List<String> getStartTrackers() {
        return new ArrayList(this.G);
    }

    public void setStartTrackers(List<String> list) {
        try {
            this.G.clear();
            this.G.addAll(list);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public void addSkipMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.H.add(str);
        }
    }

    public List<String> getSkipTrackers() {
        return new ArrayList(this.H);
    }

    public void setSkipTrackers(List<String> list) {
        this.H.addAll(list);
    }

    public void addScardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.I.add(str);
        }
    }

    public List<String> getScardTrackers() {
        return new ArrayList(this.I);
    }

    public void setScardTrackers(List<String> list) {
        this.I.addAll(list);
    }

    public void addCcardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.J.add(str);
        }
    }

    public List<String> getCcardTrackers() {
        return new ArrayList(this.J);
    }

    public void setCcardTrackers(List<String> list) {
        this.J.addAll(list);
    }

    public void addFullScreenMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.K.add(str);
        }
    }

    public List<String> getFullScreenTrackers() {
        return new ArrayList(this.K);
    }

    public void setFullScreenTrackers(List<String> list) {
        this.K.addAll(list);
    }

    public void addCloseMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.L.add(str);
        }
    }

    public List<String> getCloseTrackers() {
        return new ArrayList(this.L);
    }

    public void setCstartcardTrackers(List<String> list) {
        this.M.clear();
        this.M.addAll(list);
    }

    public void addCstartcardMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.M.add(str);
        }
    }

    public List<String> getCstartcardTrackers() {
        return new ArrayList(this.M);
    }

    public void setCloseTrackers(List<String> list) {
        try {
            this.L.clear();
            this.L.addAll(list);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public Object clone() {
        return super.clone();
    }

    public long getCreateTime() {
        return this.Z;
    }

    public void setCreateTime(long j) {
        this.Z = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.T);
        parcel.writeString(this.W);
        parcel.writeString(this.S);
        parcel.writeString(this.w);
        parcel.writeString(this.am);
        parcel.writeString(this.P);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeString(this.k);
        parcel.writeString(this.a);
        parcel.writeString(this.z);
        parcel.writeString(this.j);
        parcel.writeString(this.i);
        parcel.writeString(this.g);
        parcel.writeInt(this.B);
        parcel.writeInt(this.A);
        parcel.writeString(this.x);
        parcel.writeString(this.C);
        parcel.writeString(this.h);
        parcel.writeString(this.Q);
        parcel.writeString(this.f);
        parcel.writeString(this.ab);
        parcel.writeString(this.n);
        parcel.writeInt(this.p);
        parcel.writeString(this.al);
        parcel.writeString(this.an);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeStringList(getStartTrackers());
        parcel.writeStringList(getCloseTrackers());
    }

    private XAdInstanceInfo(Parcel parcel) {
        this.b = RePlugin.PROCESS_UI;
        this.q = "";
        this.r = "";
        this.s = 0;
        this.t = 0;
        this.D = new HashSet();
        this.E = new HashSet();
        this.F = new HashSet();
        this.G = new HashSet();
        this.H = new HashSet();
        this.I = new HashSet();
        this.J = new HashSet();
        this.K = new HashSet();
        this.L = new HashSet();
        this.M = new HashSet();
        this.O = true;
        this.aa = CreativeType.NONE;
        this.ad = true;
        this.af = true;
        this.ag = true;
        this.ap = false;
        this.ar = false;
        this.as = null;
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.T = parcel.readString();
        this.W = parcel.readString();
        this.S = parcel.readString();
        this.w = parcel.readString();
        this.am = parcel.readString();
        this.P = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
        this.k = parcel.readString();
        this.a = parcel.readString();
        this.z = parcel.readString();
        this.j = parcel.readString();
        this.i = parcel.readString();
        this.g = parcel.readString();
        this.B = parcel.readInt();
        this.A = parcel.readInt();
        this.x = parcel.readString();
        this.C = parcel.readString();
        this.h = parcel.readString();
        this.Q = parcel.readString();
        this.f = parcel.readString();
        this.ab = parcel.readString();
        this.n = parcel.readString();
        this.p = parcel.readInt();
        this.al = parcel.readString();
        this.an = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        List arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setStartTrackers(arrayList);
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setCloseTrackers(arrayList);
    }

    public String getUniqueId() {
        return this.R;
    }

    public boolean isSecondConfirmed() {
        return this.ap;
    }

    public void setSecondConfirmed(boolean z) {
        this.ap = z;
    }

    public boolean getAPOOpen() {
        return this.ar;
    }

    public void setAPOOpen(boolean z) {
        this.ar = z;
    }

    public String getPage() {
        return this.as;
    }

    public void setPage(String str) {
        this.as = str;
    }

    public void setSplash3DLocalUrl(String str) {
        this.aq = str;
    }

    public String getSplash3DLocalUrl() {
        return this.aq;
    }

    public int getVideoWidth() {
        return this.s;
    }

    public void setVideoWidth(int i) {
        this.s = i;
    }

    public int getVideoHeight() {
        return this.t;
    }

    public void setVideoHeight(int i) {
        this.t = i;
    }

    public void setAction(String str) {
        this.q = str;
    }

    public String getAction() {
        return this.q;
    }

    public String getWebUrl() {
        return this.r;
    }

    public void setWebUrl(String str) {
        this.r = str;
    }
}
