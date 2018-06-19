package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.e.i;
import com.taobao.accs.common.Constants;
import com.ut.mini.UTHitBuilders.UTPageHitBuilder;
import com.ut.mini.base.UTMIVariables;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class UTPageHitHelper {
    private static UTPageHitHelper a = new UTPageHitHelper();
    private boolean K = false;
    private Queue<UTPageEventObject> f15a = new LinkedList();
    private String ag = null;
    private String ah = null;
    private Map<String, String> w = new HashMap();
    private Map<String, UTPageEventObject> x = new HashMap();
    private Map<String, String> y = new HashMap();
    private Map<Object, String> z = new HashMap();

    public static class UTPageEventObject {
        private long A = 0;
        private boolean L = false;
        private boolean M = false;
        private boolean N = false;
        private Uri a = null;
        private UTPageStatus f16a = null;
        private String ai = null;
        private String aj = null;
        private String ak = null;
        private Map<String, String> w = new HashMap();

        public void setCacheKey(String str) {
            this.ak = str;
        }

        public String getCacheKey() {
            return this.ak;
        }

        public void resetPropertiesWithoutSkipFlagAndH5Flag() {
            this.w = new HashMap();
            this.A = 0;
            this.a = null;
            this.ai = null;
            this.aj = null;
            if (this.f16a == null || this.f16a != UTPageStatus.UT_H5_IN_WebView) {
                this.f16a = null;
            }
            this.L = false;
            this.N = false;
        }

        public boolean isH5Called() {
            return this.N;
        }

        public void setH5Called() {
            this.N = true;
        }

        public void setToSkipPage() {
            this.M = true;
        }

        public boolean isSkipPage() {
            return this.M;
        }

        public void setPageAppearCalled() {
            this.L = true;
        }

        public boolean isPageAppearCalled() {
            return this.L;
        }

        public void setPageStatus(UTPageStatus uTPageStatus) {
            this.f16a = uTPageStatus;
        }

        public UTPageStatus getPageStatus() {
            return this.f16a;
        }

        public Map<String, String> getPageProperties() {
            return this.w;
        }

        public void setPageProperties(Map<String, String> map) {
            this.w = map;
        }

        public long getPageStayTimstamp() {
            return this.A;
        }

        public void setPageStayTimstamp(long j) {
            this.A = j;
        }

        public Uri getPageUrl() {
            return this.a;
        }

        public void setPageUrl(Uri uri) {
            this.a = uri;
        }

        public void setPageName(String str) {
            this.ai = str;
        }

        public String getPageName() {
            return this.ai;
        }

        public void setRefPage(String str) {
            this.aj = str;
        }

        public String getRefPage() {
            return this.aj;
        }
    }

    public static UTPageHitHelper getInstance() {
        return a;
    }

    synchronized Map<String, String> c() {
        if (this.y == null || this.y.size() <= 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        hashMap.putAll(this.y);
        this.y.clear();
        return hashMap;
    }

    synchronized void a(UTPageEventObject uTPageEventObject) {
        uTPageEventObject.resetPropertiesWithoutSkipFlagAndH5Flag();
        if (!this.f15a.contains(uTPageEventObject)) {
            this.f15a.add(uTPageEventObject);
        }
        if (this.f15a.size() > 200) {
            for (uTPageEventObject = null; uTPageEventObject < 100; uTPageEventObject++) {
                UTPageEventObject uTPageEventObject2 = (UTPageEventObject) this.f15a.poll();
                if (uTPageEventObject2 != null && this.x.containsKey(uTPageEventObject2.getCacheKey())) {
                    this.x.remove(uTPageEventObject2.getCacheKey());
                }
            }
        }
    }

    @Deprecated
    public synchronized void turnOffAutoPageTrack() {
        this.K = true;
    }

    public String getCurrentPageName() {
        return this.ah;
    }

    void pageAppearByAuto(Activity activity) {
        if (!this.K) {
            pageAppear(activity);
        }
    }

    private String m13a(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName();
        }
        obj = obj.hashCode();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(obj);
        return stringBuilder.toString();
    }

    synchronized boolean m16a(Object obj) {
        if (obj != null) {
            obj = a(obj);
            if (obj.getPageStatus() != null && obj.getPageStatus() == UTPageStatus.UT_H5_IN_WebView) {
                return true;
            }
        }
        return null;
    }

    synchronized void m15a(Object obj) {
        if (obj != null) {
            obj = a(obj);
            if (obj.getPageStatus() != null) {
                obj.setH5Called();
            }
        }
    }

    private synchronized UTPageEventObject a(Object obj) {
        obj = a(obj);
        if (this.x.containsKey(obj)) {
            return (UTPageEventObject) this.x.get(obj);
        }
        UTPageEventObject uTPageEventObject = new UTPageEventObject();
        this.x.put(obj, uTPageEventObject);
        uTPageEventObject.setCacheKey(obj);
        return uTPageEventObject;
    }

    private synchronized void a(String str, UTPageEventObject uTPageEventObject) {
        this.x.put(str, uTPageEventObject);
    }

    private synchronized void b(UTPageEventObject uTPageEventObject) {
        if (this.x.containsKey(uTPageEventObject.getCacheKey())) {
            this.x.remove(uTPageEventObject.getCacheKey());
        }
    }

    private synchronized void m14b(Object obj) {
        obj = a(obj);
        if (this.x.containsKey(obj)) {
            this.x.remove(obj);
        }
    }

    @Deprecated
    public synchronized void pageAppear(Object obj) {
        a(obj, null, false);
    }

    synchronized void a(Object obj, String str, boolean z) {
        if (obj != null) {
            String a = a(obj);
            if (a == null || !a.equals(this.ag)) {
                StringBuilder stringBuilder;
                if (this.ag != null) {
                    stringBuilder = new StringBuilder("Last page requires leave(");
                    stringBuilder.append(this.ag);
                    stringBuilder.append(").");
                    i.b("lost 2001", stringBuilder.toString());
                }
                UTPageEventObject a2 = a(obj);
                if (z || !a2.isSkipPage()) {
                    z = UTMIVariables.getInstance().getH5Url();
                    if (z) {
                        try {
                            this.w.put("spm", Uri.parse(z).getQueryParameter("spm"));
                        } catch (boolean z2) {
                            z2.printStackTrace();
                        }
                        UTMIVariables.getInstance().setH5Url(null);
                    }
                    z2 = b(obj);
                    if (TextUtils.isEmpty(str)) {
                        str = z2;
                    }
                    if (!TextUtils.isEmpty(a2.getPageName())) {
                        str = a2.getPageName();
                    }
                    this.ah = str;
                    a2.setPageName(str);
                    a2.setPageStayTimstamp(SystemClock.elapsedRealtime());
                    a2.setRefPage(UTMIVariables.getInstance().getRefPage());
                    a2.setPageAppearCalled();
                    if (this.y != null) {
                        str = a2.getPageProperties();
                        if (str == null) {
                            a2.setPageProperties(this.y);
                        } else {
                            z2 = new HashMap();
                            z2.putAll(str);
                            z2.putAll(this.y);
                            a2.setPageProperties(z2);
                        }
                    }
                    this.y = null;
                    this.ag = a(obj);
                    b(a2);
                    a(a(obj), a2);
                    return;
                }
                z2 = new String[true];
                stringBuilder = new StringBuilder("page name:");
                stringBuilder.append(obj.getClass().getSimpleName());
                z2[0] = stringBuilder.toString();
                i.a("skip page[pageAppear]", z2);
                return;
            }
            return;
        }
        i.b("pageAppear", "The page object should not be null");
    }

    synchronized void pageAppear(Object obj, String str) {
        a(obj, str, false);
    }

    @Deprecated
    public synchronized void updatePageProperties(Map<String, String> map) {
        if (map != null) {
            this.w.putAll(map);
        }
    }

    synchronized void updatePageProperties(Object obj, Map<String, String> map) {
        if (!(obj == null || map == null)) {
            if (map.size() != 0) {
                Map hashMap = new HashMap();
                hashMap.putAll(map);
                obj = a(obj);
                map = obj.getPageProperties();
                if (map == null) {
                    obj.setPageProperties(hashMap);
                    return;
                }
                Map hashMap2 = new HashMap();
                hashMap2.putAll(map);
                hashMap2.putAll(hashMap);
                obj.setPageProperties(hashMap2);
                return;
            }
        }
        i.b("updatePageProperties", "failed to update project, parameters should not be null and the map should not be empty");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void updatePageName(java.lang.Object r2, java.lang.String r3) {
        /*
        r1 = this;
        monitor-enter(r1);
        if (r2 == 0) goto L_0x0018;
    L_0x0003:
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0018;
    L_0x000a:
        r2 = r1.a(r2);	 Catch:{ all -> 0x0015 }
        r2.setPageName(r3);	 Catch:{ all -> 0x0015 }
        r1.ah = r3;	 Catch:{ all -> 0x0015 }
        monitor-exit(r1);
        return;
    L_0x0015:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
    L_0x0018:
        monitor-exit(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageHitHelper.updatePageName(java.lang.Object, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void updatePageUrl(java.lang.Object r3, android.net.Uri r4) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 == 0) goto L_0x0020;
    L_0x0003:
        if (r4 != 0) goto L_0x0006;
    L_0x0005:
        goto L_0x0020;
    L_0x0006:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001d }
        r1 = "url";
        r0.<init>(r1);	 Catch:{ all -> 0x001d }
        r1 = r4.toString();	 Catch:{ all -> 0x001d }
        r0.append(r1);	 Catch:{ all -> 0x001d }
        r3 = r2.a(r3);	 Catch:{ all -> 0x001d }
        r3.setPageUrl(r4);	 Catch:{ all -> 0x001d }
        monitor-exit(r2);
        return;
    L_0x001d:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
    L_0x0020:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageHitHelper.updatePageUrl(java.lang.Object, android.net.Uri):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void updatePageStatus(java.lang.Object r1, com.ut.mini.UTPageStatus r2) {
        /*
        r0 = this;
        monitor-enter(r0);
        if (r1 == 0) goto L_0x0012;
    L_0x0003:
        if (r2 != 0) goto L_0x0006;
    L_0x0005:
        goto L_0x0012;
    L_0x0006:
        r1 = r0.a(r1);	 Catch:{ all -> 0x000f }
        r1.setPageStatus(r2);	 Catch:{ all -> 0x000f }
        monitor-exit(r0);
        return;
    L_0x000f:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x0012:
        monitor-exit(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageHitHelper.updatePageStatus(java.lang.Object, com.ut.mini.UTPageStatus):void");
    }

    synchronized void updateNextPageProperties(Map<String, String> map) {
        if (map != null) {
            Map hashMap = new HashMap();
            hashMap.putAll(map);
            this.y = hashMap;
        }
    }

    void pageDisAppearByAuto(Activity activity) {
        if (!this.K) {
            pageDisAppear(activity);
        }
    }

    synchronized void skipPage(Object obj) {
        if (obj != null) {
            a(obj).setToSkipPage();
        }
    }

    @Deprecated
    public synchronized void pageDisAppear(Object obj) {
        Map pageProperties;
        UnsupportedEncodingException unsupportedEncodingException;
        UTTracker defaultTracker;
        if (obj == null) {
            i.b("pageDisAppear", "The page object should not be null");
        } else if (this.ag != null) {
            UTPageEventObject a = a(obj);
            if (!a.isPageAppearCalled()) {
                StringBuilder stringBuilder = new StringBuilder("Please call pageAppear first(");
                stringBuilder.append(b(obj));
                stringBuilder.append(").");
                i.b("UT", stringBuilder.toString());
            } else if (a.getPageStatus() != null && UTPageStatus.UT_H5_IN_WebView == a.getPageStatus() && a.isH5Called()) {
                a(a);
                return;
            } else {
                UTPageHitBuilder uTPageHitBuilder;
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.getPageStayTimstamp();
                if (a.getPageUrl() == null && (obj instanceof Activity)) {
                    a.setPageUrl(((Activity) obj).getIntent().getData());
                }
                String pageName = a.getPageName();
                String refPage = a.getRefPage();
                if (refPage == null || refPage.length() == 0) {
                    refPage = "-";
                }
                Map map = this.w;
                if (map == null) {
                    map = new HashMap();
                }
                if (a.getPageProperties() != null) {
                    map.putAll(a.getPageProperties());
                }
                if (obj instanceof IUTPageTrack) {
                    IUTPageTrack iUTPageTrack = (IUTPageTrack) obj;
                    CharSequence referPage = iUTPageTrack.getReferPage();
                    if (!TextUtils.isEmpty(referPage)) {
                        refPage = referPage;
                    }
                    pageProperties = iUTPageTrack.getPageProperties();
                    if (pageProperties != null && pageProperties.size() > 0) {
                        this.w.putAll(pageProperties);
                        map = this.w;
                    }
                    CharSequence pageName2 = iUTPageTrack.getPageName();
                    if (!TextUtils.isEmpty(pageName2)) {
                        pageName = pageName2;
                    }
                }
                Uri pageUrl = a.getPageUrl();
                if (pageUrl != null) {
                    try {
                        Object obj2;
                        CharSequence queryParameter;
                        Object a2;
                        pageProperties = new HashMap();
                        Object queryParameter2 = pageUrl.getQueryParameter("spm");
                        if (TextUtils.isEmpty(queryParameter2)) {
                            try {
                                Uri parse = Uri.parse(URLDecoder.decode(pageUrl.toString(), "UTF-8"));
                                try {
                                    queryParameter2 = parse.getQueryParameter("spm");
                                    pageUrl = parse;
                                } catch (UnsupportedEncodingException e) {
                                    Uri uri = parse;
                                    unsupportedEncodingException = e;
                                    pageUrl = uri;
                                    unsupportedEncodingException.printStackTrace();
                                    if (!TextUtils.isEmpty(queryParameter2)) {
                                        obj2 = null;
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            pageProperties.put("spm", queryParameter2);
                                            this.z.put(obj, queryParameter2);
                                        }
                                    }
                                    queryParameter = pageUrl.getQueryParameter("scm");
                                    if (!TextUtils.isEmpty(queryParameter)) {
                                        pageProperties.put("scm", queryParameter);
                                    }
                                    a2 = a(pageUrl);
                                    if (!TextUtils.isEmpty(a2)) {
                                        c.a().a(a2);
                                    }
                                    if (pageProperties.size() > 0) {
                                        map.putAll(pageProperties);
                                    }
                                    uTPageHitBuilder = new UTPageHitBuilder(pageName);
                                    uTPageHitBuilder.setReferPage(refPage).setDurationOnPage(elapsedRealtime).setProperties(map);
                                    UTMIVariables.getInstance().setRefPage(pageName);
                                    defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                                    if (defaultTracker != null) {
                                        i.b("Record page event error", "Fatal Error,must call setRequestAuthentication method first.");
                                    } else {
                                        defaultTracker.send(uTPageHitBuilder.build());
                                    }
                                    this.w = new HashMap();
                                    if (a.isSkipPage()) {
                                        if (a.getPageStatus() == null) {
                                        }
                                        b(obj);
                                    } else {
                                        a(a);
                                    }
                                    this.ag = null;
                                    this.ah = null;
                                }
                            } catch (UnsupportedEncodingException e2) {
                                unsupportedEncodingException = e2;
                                unsupportedEncodingException.printStackTrace();
                                if (TextUtils.isEmpty(queryParameter2)) {
                                    obj2 = null;
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        pageProperties.put("spm", queryParameter2);
                                        this.z.put(obj, queryParameter2);
                                    }
                                }
                                queryParameter = pageUrl.getQueryParameter("scm");
                                if (TextUtils.isEmpty(queryParameter)) {
                                    pageProperties.put("scm", queryParameter);
                                }
                                a2 = a(pageUrl);
                                if (TextUtils.isEmpty(a2)) {
                                    c.a().a(a2);
                                }
                                if (pageProperties.size() > 0) {
                                    map.putAll(pageProperties);
                                }
                                uTPageHitBuilder = new UTPageHitBuilder(pageName);
                                uTPageHitBuilder.setReferPage(refPage).setDurationOnPage(elapsedRealtime).setProperties(map);
                                UTMIVariables.getInstance().setRefPage(pageName);
                                defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                                if (defaultTracker != null) {
                                    defaultTracker.send(uTPageHitBuilder.build());
                                } else {
                                    i.b("Record page event error", "Fatal Error,must call setRequestAuthentication method first.");
                                }
                                this.w = new HashMap();
                                if (a.isSkipPage()) {
                                    a(a);
                                } else {
                                    if (a.getPageStatus() == null) {
                                    }
                                    b(obj);
                                }
                                this.ag = null;
                                this.ah = null;
                            }
                        }
                        if (TextUtils.isEmpty(queryParameter2)) {
                            obj2 = null;
                            if (this.z.containsKey(obj) && queryParameter2.equals(this.z.get(obj))) {
                                obj2 = 1;
                            }
                            if (obj2 == null) {
                                pageProperties.put("spm", queryParameter2);
                                this.z.put(obj, queryParameter2);
                            }
                        }
                        queryParameter = pageUrl.getQueryParameter("scm");
                        if (TextUtils.isEmpty(queryParameter)) {
                            pageProperties.put("scm", queryParameter);
                        }
                        a2 = a(pageUrl);
                        if (TextUtils.isEmpty(a2)) {
                            c.a().a(a2);
                        }
                        if (pageProperties.size() > 0) {
                            map.putAll(pageProperties);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                uTPageHitBuilder = new UTPageHitBuilder(pageName);
                uTPageHitBuilder.setReferPage(refPage).setDurationOnPage(elapsedRealtime).setProperties(map);
                UTMIVariables.getInstance().setRefPage(pageName);
                defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTPageHitBuilder.build());
                } else {
                    i.b("Record page event error", "Fatal Error,must call setRequestAuthentication method first.");
                }
            }
            this.w = new HashMap();
            if (a.isSkipPage()) {
                a(a);
            } else if (a.getPageStatus() == null && UTPageStatus.UT_H5_IN_WebView == a.getPageStatus()) {
                a(a);
            } else {
                b(obj);
            }
            this.ag = null;
            this.ah = null;
        }
    }

    private static String a(Uri uri) {
        if (uri != null) {
            Uri<String> queryParameters = uri.getQueryParameters(Constants.KEY_TTID);
            if (queryParameters != null) {
                for (String str : queryParameters) {
                    if (!str.contains("@") && !str.contains("%40")) {
                        return str;
                    }
                }
            }
        }
        return null;
    }

    private static String b(Object obj) {
        obj = obj.getClass().getSimpleName();
        return (obj == null || !obj.toLowerCase().endsWith("activity")) ? obj : obj.substring(0, obj.length() - 8);
    }
}
