package com.xunlei.downloadprovider.ad.common.adget;

import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.net.thunderserver.signature.Parameter;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.report.e;
import com.xunlei.downloadprovider.ad.common.report.i;
import com.xunlei.xllib.android.b;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: AggetUtils */
public class k {
    private static final String a = "k";

    private static Map<String, String> a(String str, List<a> list) {
        List arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar != null) {
                arrayList.add(new i(aVar).a());
            }
        }
        return a(str, ThunderReport.getContentList(arrayList));
    }

    @NonNull
    private static Map<String, String> a(String str, String str2) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("contentlist", str2);
        hashMap.put("ad_type", str);
        return hashMap;
    }

    public static Map<String, String> a(String str, a aVar) {
        return a(str, Collections.singletonList(aVar));
    }

    public static Map<String, String> a(String str, Map<THUNDER_AD_INFO, a> map) {
        if (map == null) {
            return null;
        }
        map = map.entrySet();
        List arrayList = new ArrayList();
        map = map.iterator();
        while (map.hasNext()) {
            arrayList.add(((Entry) map.next()).getValue());
        }
        return a(str, arrayList);
    }

    public static Map<String, String> a(String str, THUNDER_AD_INFO thunder_ad_info, STYLES_INFO styles_info) {
        return a(str, ThunderReport.getSingleContentList(new i(str, thunder_ad_info, styles_info).a()));
    }

    public static Map<String, String> a(THUNDER_AD_INFO thunder_ad_info, STYLES_INFO styles_info, String str) {
        return thunder_ad_info != null ? a(thunder_ad_info.getPositionId(), styles_info, str) : null;
    }

    public static Map<String, String> a(String str, STYLES_INFO styles_info, String str2) {
        str = ThunderReport.getSingleContentList(new com.xunlei.downloadprovider.ad.common.report.k(str, styles_info).a());
        styles_info = new HashMap();
        styles_info.put("contentlist", str);
        styles_info.put("ad_type", str2);
        return styles_info;
    }

    public static Map<String, String> a(List<THUNDER_AD_INFO> list, String str) {
        if (list == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (THUNDER_AD_INFO thunder_ad_info : list) {
            Map hashMap = new HashMap();
            hashMap.put("position_id", thunder_ad_info.getPositionId());
            arrayList.add(hashMap);
        }
        list = ThunderReport.getContentList(arrayList);
        Map<String, String> hashMap2 = new HashMap();
        hashMap2.put("contentlist", list);
        hashMap2.put("ad_type", str);
        return hashMap2;
    }

    public static Map<String, String> a(List<THUNDER_AD_INFO> list, String str, e eVar) {
        if (list == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (THUNDER_AD_INFO thunder_ad_info : list) {
            arrayList.add(new com.xunlei.downloadprovider.ad.common.report.k(thunder_ad_info.mPositionId, "").a());
        }
        return a(str, eVar, ThunderReport.getContentList(arrayList));
    }

    public static Map<String, String> a(THUNDER_AD_INFO thunder_ad_info, STYLES_INFO styles_info, String str, e eVar) {
        return thunder_ad_info != null ? a(thunder_ad_info.getPositionId(), styles_info, str, eVar) : null;
    }

    public static Map<String, String> a(String str, STYLES_INFO styles_info, String str2, e eVar) {
        return a(str2, eVar, ThunderReport.getSingleContentList(new com.xunlei.downloadprovider.ad.common.report.k(str, styles_info).a()));
    }

    @NonNull
    private static Map<String, String> a(String str, e eVar, String str2) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("contentlist", str2);
        hashMap.put("ad_type", str);
        hashMap.put("error_code", String.valueOf(eVar.a));
        hashMap.put("error_msg", eVar.b);
        return hashMap;
    }

    public static String a(String str) {
        String str2 = "";
        List arrayList = new ArrayList();
        str = str.split("\\?");
        if (str != null && str.length > 1) {
            for (String split : str[1].split("&")) {
                String[] split2 = split.split("=");
                if (split2.length > 1) {
                    a(arrayList, split2[0], split2[1]);
                } else if (split2.length == 1) {
                    a(arrayList, split2[0], "");
                }
            }
        }
        try {
            str = b(arrayList, "ed35b80ab6de3944a96466be405de2fc");
        } catch (String str3) {
            str3.printStackTrace();
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder("&sig=");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    private static void a(List<Parameter> list, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            list.add(new Parameter(str, Uri.decode(str2)));
        }
    }

    public static void b(String str, Map<String, String> map) {
        a(str, (Map) map, null);
    }

    public static String a(List<THUNDER_AD_INFO> list, boolean z, int i) {
        if (list != null) {
            if (list.size() != 0) {
                boolean z2;
                boolean hashCode;
                Object obj;
                StringBuilder stringBuilder;
                StringBuilder stringBuilder2 = new StringBuilder();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(System.currentTimeMillis());
                Object stringBuilder4 = stringBuilder3.toString();
                a((List) list, z, i, stringBuilder2);
                z = true;
                a(stringBuilder2, "devicetype", Integer.valueOf(1), false);
                a(stringBuilder2, "make", AndroidConfig.getPhoneBrand(), false);
                a(stringBuilder2, "os", (Object) "4", false);
                a(stringBuilder2, IXAdRequestInfo.OSV, VERSION.RELEASE, false);
                a(stringBuilder2, Constants.KEY_MODEL, AndroidConfig.getPhoneModel(), false);
                a(stringBuilder2, IXAdRequestInfo.HEIGHT, Integer.valueOf(AndroidConfig.getScreenHeight()), false);
                a(stringBuilder2, IXAdRequestInfo.WIDTH, Integer.valueOf(AndroidConfig.getScreenWidth()), false);
                String str = DispatchConstants.CARRIER;
                Object obj2 = "";
                String a = b.a.a(com.xunlei.downloadprovider.ad.a.a());
                int hashCode2 = a.hashCode();
                if (hashCode2 != 618558396) {
                    if (hashCode2 != 618596989) {
                        if (hashCode2 == 618663094) {
                            if (a.equals("中国联通")) {
                                z2 = true;
                                switch (z2) {
                                    case false:
                                        obj2 = "1";
                                        break;
                                    case true:
                                        obj2 = "2";
                                        break;
                                    case true:
                                        obj2 = "0";
                                        break;
                                    default:
                                        break;
                                }
                                a(stringBuilder2, str, obj2, false);
                                list = b.c(com.xunlei.downloadprovider.ad.a.a());
                                hashCode = list.hashCode();
                                if (hashCode) {
                                    if (hashCode) {
                                        if (hashCode) {
                                            if (hashCode) {
                                                if (list.equals("wifi") != null) {
                                                    z = false;
                                                    switch (z) {
                                                        case false:
                                                            obj = "0";
                                                            break;
                                                        case true:
                                                            obj = "1";
                                                            break;
                                                        case true:
                                                            obj = "2";
                                                            break;
                                                        case true:
                                                            obj = "3";
                                                            break;
                                                        default:
                                                            obj = "";
                                                            break;
                                                    }
                                                    if (!TextUtils.isEmpty(obj)) {
                                                        a(stringBuilder2, "connectiontype", obj, false);
                                                    }
                                                    a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                                    a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                                    a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                                    a(stringBuilder2, "v", (Object) "1.0", false);
                                                    a(stringBuilder2, "callId", stringBuilder4, false);
                                                    list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                                    if (list != null) {
                                                        list = "";
                                                    } else {
                                                        stringBuilder = new StringBuilder();
                                                        a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                                        a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                                        a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                                        a(stringBuilder, "country", list.d, false);
                                                        a(stringBuilder, "prov", list.e, false);
                                                        a(stringBuilder, "city", list.f, false);
                                                        new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                                        list = stringBuilder.toString().trim();
                                                    }
                                                    if (!TextUtils.isEmpty(list.trim())) {
                                                        stringBuilder2.append(list);
                                                    }
                                                    return stringBuilder2.toString();
                                                }
                                            }
                                        } else if (list.equals(UtilityImpl.NET_TYPE_4G) != null) {
                                            z = true;
                                            switch (z) {
                                                case false:
                                                    obj = "0";
                                                    break;
                                                case true:
                                                    obj = "1";
                                                    break;
                                                case true:
                                                    obj = "2";
                                                    break;
                                                case true:
                                                    obj = "3";
                                                    break;
                                                default:
                                                    obj = "";
                                                    break;
                                            }
                                            if (TextUtils.isEmpty(obj)) {
                                                a(stringBuilder2, "connectiontype", obj, false);
                                            }
                                            a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                            a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                            a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                            a(stringBuilder2, "v", (Object) "1.0", false);
                                            a(stringBuilder2, "callId", stringBuilder4, false);
                                            list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                            if (list != null) {
                                                stringBuilder = new StringBuilder();
                                                a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                                a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                                a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                                a(stringBuilder, "country", list.d, false);
                                                a(stringBuilder, "prov", list.e, false);
                                                a(stringBuilder, "city", list.f, false);
                                                new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                                list = stringBuilder.toString().trim();
                                            } else {
                                                list = "";
                                            }
                                            if (TextUtils.isEmpty(list.trim())) {
                                                stringBuilder2.append(list);
                                            }
                                            return stringBuilder2.toString();
                                        }
                                    } else if (list.equals(UtilityImpl.NET_TYPE_3G) != null) {
                                        z = true;
                                        switch (z) {
                                            case false:
                                                obj = "0";
                                                break;
                                            case true:
                                                obj = "1";
                                                break;
                                            case true:
                                                obj = "2";
                                                break;
                                            case true:
                                                obj = "3";
                                                break;
                                            default:
                                                obj = "";
                                                break;
                                        }
                                        if (TextUtils.isEmpty(obj)) {
                                            a(stringBuilder2, "connectiontype", obj, false);
                                        }
                                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                        a(stringBuilder2, "v", (Object) "1.0", false);
                                        a(stringBuilder2, "callId", stringBuilder4, false);
                                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                        if (list != null) {
                                            list = "";
                                        } else {
                                            stringBuilder = new StringBuilder();
                                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                            a(stringBuilder, "country", list.d, false);
                                            a(stringBuilder, "prov", list.e, false);
                                            a(stringBuilder, "city", list.f, false);
                                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                            list = stringBuilder.toString().trim();
                                        }
                                        if (TextUtils.isEmpty(list.trim())) {
                                            stringBuilder2.append(list);
                                        }
                                        return stringBuilder2.toString();
                                    }
                                } else if (list.equals(UtilityImpl.NET_TYPE_2G) != null) {
                                    switch (z) {
                                        case false:
                                            obj = "0";
                                            break;
                                        case true:
                                            obj = "1";
                                            break;
                                        case true:
                                            obj = "2";
                                            break;
                                        case true:
                                            obj = "3";
                                            break;
                                        default:
                                            obj = "";
                                            break;
                                    }
                                    if (TextUtils.isEmpty(obj)) {
                                        a(stringBuilder2, "connectiontype", obj, false);
                                    }
                                    a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                    a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                    a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                    a(stringBuilder2, "v", (Object) "1.0", false);
                                    a(stringBuilder2, "callId", stringBuilder4, false);
                                    list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                    if (list != null) {
                                        stringBuilder = new StringBuilder();
                                        a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                        a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                        a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                        a(stringBuilder, "country", list.d, false);
                                        a(stringBuilder, "prov", list.e, false);
                                        a(stringBuilder, "city", list.f, false);
                                        new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                        list = stringBuilder.toString().trim();
                                    } else {
                                        list = "";
                                    }
                                    if (TextUtils.isEmpty(list.trim())) {
                                        stringBuilder2.append(list);
                                    }
                                    return stringBuilder2.toString();
                                }
                                z = true;
                                switch (z) {
                                    case false:
                                        obj = "0";
                                        break;
                                    case true:
                                        obj = "1";
                                        break;
                                    case true:
                                        obj = "2";
                                        break;
                                    case true:
                                        obj = "3";
                                        break;
                                    default:
                                        obj = "";
                                        break;
                                }
                                if (TextUtils.isEmpty(obj)) {
                                    a(stringBuilder2, "connectiontype", obj, false);
                                }
                                a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                a(stringBuilder2, "v", (Object) "1.0", false);
                                a(stringBuilder2, "callId", stringBuilder4, false);
                                list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                if (list != null) {
                                    list = "";
                                } else {
                                    stringBuilder = new StringBuilder();
                                    a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                    a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                    a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                    a(stringBuilder, "country", list.d, false);
                                    a(stringBuilder, "prov", list.e, false);
                                    a(stringBuilder, "city", list.f, false);
                                    new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                    list = stringBuilder.toString().trim();
                                }
                                if (TextUtils.isEmpty(list.trim())) {
                                    stringBuilder2.append(list);
                                }
                                return stringBuilder2.toString();
                            }
                        }
                    } else if (a.equals("中国移动")) {
                        z2 = false;
                        switch (z2) {
                            case false:
                                obj2 = "1";
                                break;
                            case true:
                                obj2 = "2";
                                break;
                            case true:
                                obj2 = "0";
                                break;
                            default:
                                break;
                        }
                        a(stringBuilder2, str, obj2, false);
                        list = b.c(com.xunlei.downloadprovider.ad.a.a());
                        hashCode = list.hashCode();
                        if (hashCode) {
                            if (list.equals(UtilityImpl.NET_TYPE_2G) != null) {
                                switch (z) {
                                    case false:
                                        obj = "0";
                                        break;
                                    case true:
                                        obj = "1";
                                        break;
                                    case true:
                                        obj = "2";
                                        break;
                                    case true:
                                        obj = "3";
                                        break;
                                    default:
                                        obj = "";
                                        break;
                                }
                                if (TextUtils.isEmpty(obj)) {
                                    a(stringBuilder2, "connectiontype", obj, false);
                                }
                                a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                a(stringBuilder2, "v", (Object) "1.0", false);
                                a(stringBuilder2, "callId", stringBuilder4, false);
                                list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                if (list != null) {
                                    stringBuilder = new StringBuilder();
                                    a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                    a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                    a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                    a(stringBuilder, "country", list.d, false);
                                    a(stringBuilder, "prov", list.e, false);
                                    a(stringBuilder, "city", list.f, false);
                                    new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                    list = stringBuilder.toString().trim();
                                } else {
                                    list = "";
                                }
                                if (TextUtils.isEmpty(list.trim())) {
                                    stringBuilder2.append(list);
                                }
                                return stringBuilder2.toString();
                            }
                        } else if (hashCode) {
                            if (list.equals(UtilityImpl.NET_TYPE_3G) != null) {
                                z = true;
                                switch (z) {
                                    case false:
                                        obj = "0";
                                        break;
                                    case true:
                                        obj = "1";
                                        break;
                                    case true:
                                        obj = "2";
                                        break;
                                    case true:
                                        obj = "3";
                                        break;
                                    default:
                                        obj = "";
                                        break;
                                }
                                if (TextUtils.isEmpty(obj)) {
                                    a(stringBuilder2, "connectiontype", obj, false);
                                }
                                a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                a(stringBuilder2, "v", (Object) "1.0", false);
                                a(stringBuilder2, "callId", stringBuilder4, false);
                                list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                if (list != null) {
                                    list = "";
                                } else {
                                    stringBuilder = new StringBuilder();
                                    a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                    a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                    a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                    a(stringBuilder, "country", list.d, false);
                                    a(stringBuilder, "prov", list.e, false);
                                    a(stringBuilder, "city", list.f, false);
                                    new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                    list = stringBuilder.toString().trim();
                                }
                                if (TextUtils.isEmpty(list.trim())) {
                                    stringBuilder2.append(list);
                                }
                                return stringBuilder2.toString();
                            }
                        } else if (hashCode) {
                            if (list.equals(UtilityImpl.NET_TYPE_4G) != null) {
                                z = true;
                                switch (z) {
                                    case false:
                                        obj = "0";
                                        break;
                                    case true:
                                        obj = "1";
                                        break;
                                    case true:
                                        obj = "2";
                                        break;
                                    case true:
                                        obj = "3";
                                        break;
                                    default:
                                        obj = "";
                                        break;
                                }
                                if (TextUtils.isEmpty(obj)) {
                                    a(stringBuilder2, "connectiontype", obj, false);
                                }
                                a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                a(stringBuilder2, "v", (Object) "1.0", false);
                                a(stringBuilder2, "callId", stringBuilder4, false);
                                list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                if (list != null) {
                                    stringBuilder = new StringBuilder();
                                    a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                    a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                    a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                    a(stringBuilder, "country", list.d, false);
                                    a(stringBuilder, "prov", list.e, false);
                                    a(stringBuilder, "city", list.f, false);
                                    new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                    list = stringBuilder.toString().trim();
                                } else {
                                    list = "";
                                }
                                if (TextUtils.isEmpty(list.trim())) {
                                    stringBuilder2.append(list);
                                }
                                return stringBuilder2.toString();
                            }
                        } else if (hashCode) {
                            if (list.equals("wifi") != null) {
                                z = false;
                                switch (z) {
                                    case false:
                                        obj = "0";
                                        break;
                                    case true:
                                        obj = "1";
                                        break;
                                    case true:
                                        obj = "2";
                                        break;
                                    case true:
                                        obj = "3";
                                        break;
                                    default:
                                        obj = "";
                                        break;
                                }
                                if (TextUtils.isEmpty(obj)) {
                                    a(stringBuilder2, "connectiontype", obj, false);
                                }
                                a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                a(stringBuilder2, "v", (Object) "1.0", false);
                                a(stringBuilder2, "callId", stringBuilder4, false);
                                list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                if (list != null) {
                                    list = "";
                                } else {
                                    stringBuilder = new StringBuilder();
                                    a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                    a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                    a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                    a(stringBuilder, "country", list.d, false);
                                    a(stringBuilder, "prov", list.e, false);
                                    a(stringBuilder, "city", list.f, false);
                                    new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                    list = stringBuilder.toString().trim();
                                }
                                if (TextUtils.isEmpty(list.trim())) {
                                    stringBuilder2.append(list);
                                }
                                return stringBuilder2.toString();
                            }
                        }
                        z = true;
                        switch (z) {
                            case false:
                                obj = "0";
                                break;
                            case true:
                                obj = "1";
                                break;
                            case true:
                                obj = "2";
                                break;
                            case true:
                                obj = "3";
                                break;
                            default:
                                obj = "";
                                break;
                        }
                        if (TextUtils.isEmpty(obj)) {
                            a(stringBuilder2, "connectiontype", obj, false);
                        }
                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                        a(stringBuilder2, "v", (Object) "1.0", false);
                        a(stringBuilder2, "callId", stringBuilder4, false);
                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                        if (list != null) {
                            stringBuilder = new StringBuilder();
                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                            a(stringBuilder, "country", list.d, false);
                            a(stringBuilder, "prov", list.e, false);
                            a(stringBuilder, "city", list.f, false);
                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                            list = stringBuilder.toString().trim();
                        } else {
                            list = "";
                        }
                        if (TextUtils.isEmpty(list.trim())) {
                            stringBuilder2.append(list);
                        }
                        return stringBuilder2.toString();
                    }
                } else if (a.equals("中国电信")) {
                    z2 = true;
                    switch (z2) {
                        case false:
                            obj2 = "1";
                            break;
                        case true:
                            obj2 = "2";
                            break;
                        case true:
                            obj2 = "0";
                            break;
                        default:
                            break;
                    }
                    a(stringBuilder2, str, obj2, false);
                    list = b.c(com.xunlei.downloadprovider.ad.a.a());
                    hashCode = list.hashCode();
                    if (hashCode) {
                        if (hashCode) {
                            if (hashCode) {
                                if (hashCode) {
                                    if (list.equals("wifi") != null) {
                                        z = false;
                                        switch (z) {
                                            case false:
                                                obj = "0";
                                                break;
                                            case true:
                                                obj = "1";
                                                break;
                                            case true:
                                                obj = "2";
                                                break;
                                            case true:
                                                obj = "3";
                                                break;
                                            default:
                                                obj = "";
                                                break;
                                        }
                                        if (TextUtils.isEmpty(obj)) {
                                            a(stringBuilder2, "connectiontype", obj, false);
                                        }
                                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                        a(stringBuilder2, "v", (Object) "1.0", false);
                                        a(stringBuilder2, "callId", stringBuilder4, false);
                                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                        if (list != null) {
                                            list = "";
                                        } else {
                                            stringBuilder = new StringBuilder();
                                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                            a(stringBuilder, "country", list.d, false);
                                            a(stringBuilder, "prov", list.e, false);
                                            a(stringBuilder, "city", list.f, false);
                                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                            list = stringBuilder.toString().trim();
                                        }
                                        if (TextUtils.isEmpty(list.trim())) {
                                            stringBuilder2.append(list);
                                        }
                                        return stringBuilder2.toString();
                                    }
                                }
                            } else if (list.equals(UtilityImpl.NET_TYPE_4G) != null) {
                                z = true;
                                switch (z) {
                                    case false:
                                        obj = "0";
                                        break;
                                    case true:
                                        obj = "1";
                                        break;
                                    case true:
                                        obj = "2";
                                        break;
                                    case true:
                                        obj = "3";
                                        break;
                                    default:
                                        obj = "";
                                        break;
                                }
                                if (TextUtils.isEmpty(obj)) {
                                    a(stringBuilder2, "connectiontype", obj, false);
                                }
                                a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                                a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                                a(stringBuilder2, "appId", Integer.valueOf(true), false);
                                a(stringBuilder2, "v", (Object) "1.0", false);
                                a(stringBuilder2, "callId", stringBuilder4, false);
                                list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                                if (list != null) {
                                    stringBuilder = new StringBuilder();
                                    a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                    a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                    a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                    a(stringBuilder, "country", list.d, false);
                                    a(stringBuilder, "prov", list.e, false);
                                    a(stringBuilder, "city", list.f, false);
                                    new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                    list = stringBuilder.toString().trim();
                                } else {
                                    list = "";
                                }
                                if (TextUtils.isEmpty(list.trim())) {
                                    stringBuilder2.append(list);
                                }
                                return stringBuilder2.toString();
                            }
                        } else if (list.equals(UtilityImpl.NET_TYPE_3G) != null) {
                            z = true;
                            switch (z) {
                                case false:
                                    obj = "0";
                                    break;
                                case true:
                                    obj = "1";
                                    break;
                                case true:
                                    obj = "2";
                                    break;
                                case true:
                                    obj = "3";
                                    break;
                                default:
                                    obj = "";
                                    break;
                            }
                            if (TextUtils.isEmpty(obj)) {
                                a(stringBuilder2, "connectiontype", obj, false);
                            }
                            a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                            a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                            a(stringBuilder2, "appId", Integer.valueOf(true), false);
                            a(stringBuilder2, "v", (Object) "1.0", false);
                            a(stringBuilder2, "callId", stringBuilder4, false);
                            list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                            if (list != null) {
                                list = "";
                            } else {
                                stringBuilder = new StringBuilder();
                                a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                                a(stringBuilder, "lon", Double.valueOf(list.b), false);
                                a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                                a(stringBuilder, "country", list.d, false);
                                a(stringBuilder, "prov", list.e, false);
                                a(stringBuilder, "city", list.f, false);
                                new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                                list = stringBuilder.toString().trim();
                            }
                            if (TextUtils.isEmpty(list.trim())) {
                                stringBuilder2.append(list);
                            }
                            return stringBuilder2.toString();
                        }
                    } else if (list.equals(UtilityImpl.NET_TYPE_2G) != null) {
                        switch (z) {
                            case false:
                                obj = "0";
                                break;
                            case true:
                                obj = "1";
                                break;
                            case true:
                                obj = "2";
                                break;
                            case true:
                                obj = "3";
                                break;
                            default:
                                obj = "";
                                break;
                        }
                        if (TextUtils.isEmpty(obj)) {
                            a(stringBuilder2, "connectiontype", obj, false);
                        }
                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                        a(stringBuilder2, "v", (Object) "1.0", false);
                        a(stringBuilder2, "callId", stringBuilder4, false);
                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                        if (list != null) {
                            stringBuilder = new StringBuilder();
                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                            a(stringBuilder, "country", list.d, false);
                            a(stringBuilder, "prov", list.e, false);
                            a(stringBuilder, "city", list.f, false);
                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                            list = stringBuilder.toString().trim();
                        } else {
                            list = "";
                        }
                        if (TextUtils.isEmpty(list.trim())) {
                            stringBuilder2.append(list);
                        }
                        return stringBuilder2.toString();
                    }
                    z = true;
                    switch (z) {
                        case false:
                            obj = "0";
                            break;
                        case true:
                            obj = "1";
                            break;
                        case true:
                            obj = "2";
                            break;
                        case true:
                            obj = "3";
                            break;
                        default:
                            obj = "";
                            break;
                    }
                    if (TextUtils.isEmpty(obj)) {
                        a(stringBuilder2, "connectiontype", obj, false);
                    }
                    a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                    a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                    a(stringBuilder2, "appId", Integer.valueOf(true), false);
                    a(stringBuilder2, "v", (Object) "1.0", false);
                    a(stringBuilder2, "callId", stringBuilder4, false);
                    list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                    if (list != null) {
                        list = "";
                    } else {
                        stringBuilder = new StringBuilder();
                        a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                        a(stringBuilder, "lon", Double.valueOf(list.b), false);
                        a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                        a(stringBuilder, "country", list.d, false);
                        a(stringBuilder, "prov", list.e, false);
                        a(stringBuilder, "city", list.f, false);
                        new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                        list = stringBuilder.toString().trim();
                    }
                    if (TextUtils.isEmpty(list.trim())) {
                        stringBuilder2.append(list);
                    }
                    return stringBuilder2.toString();
                }
                z2 = true;
                switch (z2) {
                    case false:
                        obj2 = "1";
                        break;
                    case true:
                        obj2 = "2";
                        break;
                    case true:
                        obj2 = "0";
                        break;
                    default:
                        break;
                }
                a(stringBuilder2, str, obj2, false);
                list = b.c(com.xunlei.downloadprovider.ad.a.a());
                hashCode = list.hashCode();
                if (hashCode) {
                    if (list.equals(UtilityImpl.NET_TYPE_2G) != null) {
                        switch (z) {
                            case false:
                                obj = "0";
                                break;
                            case true:
                                obj = "1";
                                break;
                            case true:
                                obj = "2";
                                break;
                            case true:
                                obj = "3";
                                break;
                            default:
                                obj = "";
                                break;
                        }
                        if (TextUtils.isEmpty(obj)) {
                            a(stringBuilder2, "connectiontype", obj, false);
                        }
                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                        a(stringBuilder2, "v", (Object) "1.0", false);
                        a(stringBuilder2, "callId", stringBuilder4, false);
                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                        if (list != null) {
                            stringBuilder = new StringBuilder();
                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                            a(stringBuilder, "country", list.d, false);
                            a(stringBuilder, "prov", list.e, false);
                            a(stringBuilder, "city", list.f, false);
                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                            list = stringBuilder.toString().trim();
                        } else {
                            list = "";
                        }
                        if (TextUtils.isEmpty(list.trim())) {
                            stringBuilder2.append(list);
                        }
                        return stringBuilder2.toString();
                    }
                } else if (hashCode) {
                    if (list.equals(UtilityImpl.NET_TYPE_3G) != null) {
                        z = true;
                        switch (z) {
                            case false:
                                obj = "0";
                                break;
                            case true:
                                obj = "1";
                                break;
                            case true:
                                obj = "2";
                                break;
                            case true:
                                obj = "3";
                                break;
                            default:
                                obj = "";
                                break;
                        }
                        if (TextUtils.isEmpty(obj)) {
                            a(stringBuilder2, "connectiontype", obj, false);
                        }
                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                        a(stringBuilder2, "v", (Object) "1.0", false);
                        a(stringBuilder2, "callId", stringBuilder4, false);
                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                        if (list != null) {
                            list = "";
                        } else {
                            stringBuilder = new StringBuilder();
                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                            a(stringBuilder, "country", list.d, false);
                            a(stringBuilder, "prov", list.e, false);
                            a(stringBuilder, "city", list.f, false);
                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                            list = stringBuilder.toString().trim();
                        }
                        if (TextUtils.isEmpty(list.trim())) {
                            stringBuilder2.append(list);
                        }
                        return stringBuilder2.toString();
                    }
                } else if (hashCode) {
                    if (list.equals(UtilityImpl.NET_TYPE_4G) != null) {
                        z = true;
                        switch (z) {
                            case false:
                                obj = "0";
                                break;
                            case true:
                                obj = "1";
                                break;
                            case true:
                                obj = "2";
                                break;
                            case true:
                                obj = "3";
                                break;
                            default:
                                obj = "";
                                break;
                        }
                        if (TextUtils.isEmpty(obj)) {
                            a(stringBuilder2, "connectiontype", obj, false);
                        }
                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                        a(stringBuilder2, "v", (Object) "1.0", false);
                        a(stringBuilder2, "callId", stringBuilder4, false);
                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                        if (list != null) {
                            stringBuilder = new StringBuilder();
                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                            a(stringBuilder, "country", list.d, false);
                            a(stringBuilder, "prov", list.e, false);
                            a(stringBuilder, "city", list.f, false);
                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                            list = stringBuilder.toString().trim();
                        } else {
                            list = "";
                        }
                        if (TextUtils.isEmpty(list.trim())) {
                            stringBuilder2.append(list);
                        }
                        return stringBuilder2.toString();
                    }
                } else if (hashCode) {
                    if (list.equals("wifi") != null) {
                        z = false;
                        switch (z) {
                            case false:
                                obj = "0";
                                break;
                            case true:
                                obj = "1";
                                break;
                            case true:
                                obj = "2";
                                break;
                            case true:
                                obj = "3";
                                break;
                            default:
                                obj = "";
                                break;
                        }
                        if (TextUtils.isEmpty(obj)) {
                            a(stringBuilder2, "connectiontype", obj, false);
                        }
                        a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                        a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                        a(stringBuilder2, "appId", Integer.valueOf(true), false);
                        a(stringBuilder2, "v", (Object) "1.0", false);
                        a(stringBuilder2, "callId", stringBuilder4, false);
                        list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                        if (list != null) {
                            list = "";
                        } else {
                            stringBuilder = new StringBuilder();
                            a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                            a(stringBuilder, "lon", Double.valueOf(list.b), false);
                            a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                            a(stringBuilder, "country", list.d, false);
                            a(stringBuilder, "prov", list.e, false);
                            a(stringBuilder, "city", list.f, false);
                            new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                            list = stringBuilder.toString().trim();
                        }
                        if (TextUtils.isEmpty(list.trim())) {
                            stringBuilder2.append(list);
                        }
                        return stringBuilder2.toString();
                    }
                }
                z = true;
                switch (z) {
                    case false:
                        obj = "0";
                        break;
                    case true:
                        obj = "1";
                        break;
                    case true:
                        obj = "2";
                        break;
                    case true:
                        obj = "3";
                        break;
                    default:
                        obj = "";
                        break;
                }
                if (TextUtils.isEmpty(obj)) {
                    a(stringBuilder2, "connectiontype", obj, false);
                }
                a(stringBuilder2, "dpid", System.getString(com.xunlei.downloadprovider.ad.a.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID), false);
                a(stringBuilder2, SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC(), false);
                a(stringBuilder2, "appId", Integer.valueOf(true), false);
                a(stringBuilder2, "v", (Object) "1.0", false);
                a(stringBuilder2, "callId", stringBuilder4, false);
                list = com.xunlei.downloadprovider.ad.c.b.b.a().a;
                if (list != null) {
                    stringBuilder = new StringBuilder();
                    a(stringBuilder, DispatchConstants.LATITUDE, Double.valueOf(list.a), false);
                    a(stringBuilder, "lon", Double.valueOf(list.b), false);
                    a(stringBuilder, "geotype", Integer.valueOf(list.c), false);
                    a(stringBuilder, "country", list.d, false);
                    a(stringBuilder, "prov", list.e, false);
                    a(stringBuilder, "city", list.f, false);
                    new StringBuilder("getLocationParams: ").append(stringBuilder.toString().trim());
                    list = stringBuilder.toString().trim();
                } else {
                    list = "";
                }
                if (TextUtils.isEmpty(list.trim())) {
                    stringBuilder2.append(list);
                }
                return stringBuilder2.toString();
            }
        }
        return "";
    }

    private static void a(List<THUNDER_AD_INFO> list, boolean z, int i, StringBuilder stringBuilder) {
        String str;
        boolean z2;
        if (i != 1) {
            if (i != 5) {
                str = "p";
                z2 = false;
                for (THUNDER_AD_INFO thunder_ad_info : list) {
                    if (!z2) {
                        a(stringBuilder, str, thunder_ad_info.mPositionId, z ^ 1);
                        z2 = true;
                    } else if (i != 1) {
                        a(stringBuilder, "ext_ads_id", thunder_ad_info.mPositionId, false);
                        return;
                    } else {
                        a(stringBuilder, str, thunder_ad_info.mPositionId, false);
                    }
                }
            }
        }
        str = "positionId";
        z2 = false;
        for (THUNDER_AD_INFO thunder_ad_info2 : list) {
            if (!z2) {
                a(stringBuilder, str, thunder_ad_info2.mPositionId, z ^ 1);
                z2 = true;
            } else if (i != 1) {
                a(stringBuilder, str, thunder_ad_info2.mPositionId, false);
            } else {
                a(stringBuilder, "ext_ads_id", thunder_ad_info2.mPositionId, false);
                return;
            }
        }
    }

    public static void a(StringBuilder stringBuilder, String str, Object obj, boolean z) {
        obj = String.valueOf(obj);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(obj)) {
                stringBuilder.append(z ? "" : "&");
                stringBuilder.append(str);
                stringBuilder.append("=");
                stringBuilder.append(Uri.encode(obj));
            }
        }
    }

    public static <T> ArrayList<T> a(T t) {
        if (t == null) {
            return null;
        }
        ArrayList<T> arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    private static String b(@NonNull List<Parameter> list, String str) throws IOException {
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (Parameter parameter : list) {
            stringBuilder.append(parameter.name);
            stringBuilder.append("=");
            stringBuilder.append(parameter.value);
        }
        stringBuilder.append(str);
        try {
            list = MessageDigest.getInstance("MD5").digest(stringBuilder.toString().getBytes("UTF-8"));
            str = new StringBuilder();
            for (byte b : list) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    str.append("0");
                }
                str.append(toHexString);
            }
            return str.toString();
        } catch (List<Parameter> list2) {
            throw new IOException(list2);
        }
    }

    public static void a(String str, Map<String, String> map, b$a com_xunlei_downloadprovider_ad_common_c_b_a) {
        boolean a = f.a();
        StringBuilder stringBuilder = new StringBuilder("reportHubRequestEvent. eventName: ");
        stringBuilder.append(str);
        stringBuilder.append(" shouldReportRequestEvent: ");
        stringBuilder.append(a);
        if (a) {
            str = StatEvent.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    str.addString(str2, (String) map.get(str2));
                }
            }
            if (com_xunlei_downloadprovider_ad_common_c_b_a != null) {
                str.add(SocializeProtocolConstants.DURATION, com_xunlei_downloadprovider_ad_common_c_b_a.b());
            }
            map = "net_type";
            com_xunlei_downloadprovider_ad_common_c_b_a = b.b(com.xunlei.downloadprovider.ad.a.a());
            if (com_xunlei_downloadprovider_ad_common_c_b_a != null && com_xunlei_downloadprovider_ad_common_c_b_a.equals("null")) {
                com_xunlei_downloadprovider_ad_common_c_b_a = "0";
            }
            str.addString(map, com_xunlei_downloadprovider_ad_common_c_b_a);
            ThunderReport.reportEvent(str);
        }
    }
}
