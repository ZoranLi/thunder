package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UTHybridHelper {
    private static UTHybridHelper a = new UTHybridHelper();

    public static UTHybridHelper getInstance() {
        return a;
    }

    public void setH5Url(String str) {
        if (str != null) {
            UTMIVariables.getInstance().setH5Url(str);
        }
    }

    public void h5UT(Map<String, String> map, Object obj) {
        if (map != null) {
            if (map.size() != 0) {
                String str = (String) map.get("functype");
                if (str == null) {
                    i.b("h5UT", "funcType is null");
                    return;
                }
                String str2 = (String) map.get("utjstype");
                if (str2 == null || str2.equals("0") || str2.equals("1")) {
                    map.remove("functype");
                    Date date = new Date();
                    if (str.equals("2001")) {
                        a(date, map, obj);
                        return;
                    }
                    if (str.equals("2101") != null) {
                        a(date, map);
                    }
                    return;
                }
                i.b("h5UT", "utjstype should be 1 or 0 or null");
                return;
            }
        }
        i.b("h5UT", "dataMap is empty");
    }

    private void a(Date date, Map<String, String> map, Object obj) {
        if (map != null) {
            if (map.size() != null) {
                date = b((String) map.get("urlpagename"), (String) map.get("url"));
                if (date != null) {
                    if (!TextUtils.isEmpty(date)) {
                        Map map2;
                        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder;
                        String refPage = UTMIVariables.getInstance().getRefPage();
                        String str = (String) map.get("utjstype");
                        map.remove("utjstype");
                        if (str != null) {
                            if (!str.equals("0")) {
                                if (str.equals("1")) {
                                    map = d(map);
                                    map2 = map;
                                    map = 2006;
                                    if (UTPageHitHelper.getInstance().a(obj)) {
                                        map = 2001;
                                    }
                                    uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(date, map, refPage, null, null, map2);
                                    if (2001 == map) {
                                        UTMIVariables.getInstance().setRefPage(date);
                                    }
                                    date = UTPageHitHelper.getInstance().c();
                                    if (date != null && date.size() > null) {
                                        uTOriginalCustomHitBuilder.setProperties(date);
                                    }
                                    date = UTAnalytics.getInstance().getDefaultTracker();
                                    if (date != null) {
                                        date.send(uTOriginalCustomHitBuilder.build());
                                    } else {
                                        i.b("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
                                    }
                                    UTPageHitHelper.getInstance().a(obj);
                                    return;
                                }
                                map2 = null;
                                map = 2006;
                                if (UTPageHitHelper.getInstance().a(obj)) {
                                    map = 2001;
                                }
                                uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(date, map, refPage, null, null, map2);
                                if (2001 == map) {
                                    UTMIVariables.getInstance().setRefPage(date);
                                }
                                date = UTPageHitHelper.getInstance().c();
                                uTOriginalCustomHitBuilder.setProperties(date);
                                date = UTAnalytics.getInstance().getDefaultTracker();
                                if (date != null) {
                                    i.b("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
                                } else {
                                    date.send(uTOriginalCustomHitBuilder.build());
                                }
                                UTPageHitHelper.getInstance().a(obj);
                                return;
                            }
                        }
                        map = c(map);
                        map2 = map;
                        map = 2006;
                        if (UTPageHitHelper.getInstance().a(obj)) {
                            map = 2001;
                        }
                        uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(date, map, refPage, null, null, map2);
                        if (2001 == map) {
                            UTMIVariables.getInstance().setRefPage(date);
                        }
                        date = UTPageHitHelper.getInstance().c();
                        uTOriginalCustomHitBuilder.setProperties(date);
                        date = UTAnalytics.getInstance().getDefaultTracker();
                        if (date != null) {
                            date.send(uTOriginalCustomHitBuilder.build());
                        } else {
                            i.b("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
                        }
                        UTPageHitHelper.getInstance().a(obj);
                        return;
                    }
                }
                i.b("h5Page", "pageName is null,return");
            }
        }
    }

    private void a(Date date, Map<String, String> map) {
        if (map != null) {
            if (map.size() != null) {
                Object b = b((String) map.get("urlpagename"), (String) map.get("url"));
                if (b != null) {
                    if (!TextUtils.isEmpty(b)) {
                        String str = (String) map.get("logkey");
                        if (str != null) {
                            if (!TextUtils.isEmpty(str)) {
                                Date uTOriginalCustomHitBuilder;
                                date = null;
                                String str2 = (String) map.get("utjstype");
                                map.remove("utjstype");
                                if (str2 != null) {
                                    if (!str2.equals("0")) {
                                        if (str2.equals("1")) {
                                            date = f(map);
                                        }
                                        uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(b, 2101, str, null, null, date);
                                        map = UTAnalytics.getInstance().getDefaultTracker();
                                        if (map == null) {
                                            map.send(uTOriginalCustomHitBuilder.build());
                                            return;
                                        } else {
                                            i.b("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
                                            return;
                                        }
                                    }
                                }
                                date = e(map);
                                uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(b, 2101, str, null, null, date);
                                map = UTAnalytics.getInstance().getDefaultTracker();
                                if (map == null) {
                                    i.b("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
                                    return;
                                } else {
                                    map.send(uTOriginalCustomHitBuilder.build());
                                    return;
                                }
                            }
                        }
                        i.a("h5Ctrl", new String[]{"logkey is null,return"});
                        return;
                    }
                }
                i.a("h5Ctrl", new String[]{"pageName is null,return"});
            }
        }
    }

    private Map<String, String> c(Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                Map hashMap = new HashMap();
                String str = (String) map.get("url");
                hashMap.put("_h5url", str == null ? "" : str);
                if (str != null) {
                    Uri parse = Uri.parse(str);
                    CharSequence queryParameter = parse.getQueryParameter("spm");
                    if (queryParameter == null || TextUtils.isEmpty(queryParameter)) {
                        hashMap.put("spm", "0.0.0.0");
                    } else {
                        hashMap.put("spm", queryParameter);
                    }
                    CharSequence queryParameter2 = parse.getQueryParameter("scm");
                    if (!(queryParameter2 == null || TextUtils.isEmpty(queryParameter2))) {
                        hashMap.put("scm", queryParameter2);
                    }
                } else {
                    hashMap.put("spm", "0.0.0.0");
                }
                Object obj = (String) map.get("spmcnt");
                String str2 = "_spmcnt";
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str2, obj);
                obj = (String) map.get("spmpre");
                str2 = "_spmpre";
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str2, obj);
                obj = (String) map.get("lzsid");
                str2 = "_lzsid";
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str2, obj);
                obj = (String) map.get("extendargs");
                str2 = "_h5ea";
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str2, obj);
                map = (String) map.get("cna");
                str = "_cna";
                if (map == null) {
                    map = "";
                }
                hashMap.put(str, map);
                hashMap.put("_ish5", "1");
                return hashMap;
            }
        }
        return null;
    }

    private Map<String, String> d(Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                Map hashMap = new HashMap();
                Object obj = (String) map.get("url");
                String str = "_h5url";
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str, obj);
                map = (String) map.get("extendargs");
                String str2 = "_h5ea";
                if (map == null) {
                    map = "";
                }
                hashMap.put(str2, map);
                hashMap.put("_ish5", "1");
                return hashMap;
            }
        }
        return null;
    }

    private Map<String, String> e(Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                Map<String, String> hashMap = new HashMap();
                Object obj = (String) map.get("logkeyargs");
                String str = "_lka";
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str, obj);
                obj = (String) map.get("cna");
                str = "_cna";
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str, obj);
                map = (String) map.get("extendargs");
                String str2 = "_h5ea";
                if (map == null) {
                    map = "";
                }
                hashMap.put(str2, map);
                hashMap.put("_ish5", "1");
                return hashMap;
            }
        }
        return null;
    }

    private Map<String, String> f(Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                Map<String, String> hashMap = new HashMap();
                map = (String) map.get("extendargs");
                String str = "_h5ea";
                if (map == null) {
                    map = "";
                }
                hashMap.put(str, map);
                hashMap.put("_ish5", "1");
                return hashMap;
            }
        }
        return null;
    }

    private String b(String str, String str2) {
        String str3 = "";
        if (str != null && !TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2) != null) {
            return str3;
        }
        str = str2.indexOf("?");
        if (str == -1) {
            return str2;
        }
        return str2.substring(0, str);
    }
}
