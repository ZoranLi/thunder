package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.utils.v;

public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private IX5WebSettings a;
    private android.webkit.WebSettings b;
    private boolean c;

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);
        
        int value;

        private TextSize(int i) {
            this.value = i;
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        private ZoomDensity(int i) {
            this.value = i;
        }
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = null;
        this.b = webSettings;
        this.c = false;
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = iX5WebSettings;
        this.b = null;
        this.c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        if (bk.b().c() || VERSION.SDK_INT < 17) {
            return null;
        }
        Object a = v.a(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[]{Context.class}, context);
        return a == null ? null : (String) a;
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        if (this.c && this.a != null) {
            return this.a.enableSmoothTransition();
        }
        if (this.c || this.b == null || VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.b, "enableSmoothTransition");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        if (this.c && this.a != null) {
            return this.a.getAllowContentAccess();
        }
        if (this.c || this.b == null || VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.b, "getAllowContentAccess");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? false : this.b.getAllowFileAccess() : this.a.getAllowFileAccess();
    }

    public synchronized boolean getBlockNetworkImage() {
        if (this.c && this.a != null) {
            return this.a.getBlockNetworkImage();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.getBlockNetworkImage();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.c;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.a;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r3.a;	 Catch:{ all -> 0x002c }
        r0 = r0.getBlockNetworkLoads();	 Catch:{ all -> 0x002c }
        monitor-exit(r3);
        return r0;
    L_0x0011:
        r0 = r3.c;	 Catch:{ all -> 0x002c }
        r1 = 0;
        if (r0 != 0) goto L_0x002a;
    L_0x0016:
        r0 = r3.b;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x002a;
    L_0x001a:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x002c }
        r2 = 8;
        if (r0 < r2) goto L_0x0028;
    L_0x0020:
        r0 = r3.b;	 Catch:{ all -> 0x002c }
        r0 = r0.getBlockNetworkLoads();	 Catch:{ all -> 0x002c }
        monitor-exit(r3);
        return r0;
    L_0x0028:
        monitor-exit(r3);
        return r1;
    L_0x002a:
        monitor-exit(r3);
        return r1;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.getBlockNetworkLoads():boolean");
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? false : this.b.getBuiltInZoomControls() : this.a.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? 0 : this.b.getCacheMode() : this.a.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        if (this.c && this.a != null) {
            return this.a.getCursiveFontFamily();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getCursiveFontFamily();
        }
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        if (this.c && this.a != null) {
            return this.a.getDatabaseEnabled();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.getDatabaseEnabled();
        }
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        if (this.c && this.a != null) {
            return this.a.getDatabasePath();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getDatabasePath();
        }
    }

    public synchronized int getDefaultFixedFontSize() {
        if (this.c && this.a != null) {
            return this.a.getDefaultFixedFontSize();
        } else if (this.c || this.b == null) {
            return 0;
        } else {
            return this.b.getDefaultFixedFontSize();
        }
    }

    public synchronized int getDefaultFontSize() {
        if (this.c && this.a != null) {
            return this.a.getDefaultFontSize();
        } else if (this.c || this.b == null) {
            return 0;
        } else {
            return this.b.getDefaultFontSize();
        }
    }

    public synchronized String getDefaultTextEncodingName() {
        if (this.c && this.a != null) {
            return this.a.getDefaultTextEncodingName();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getDefaultTextEncodingName();
        }
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        String name;
        if (this.c && this.a != null) {
            name = this.a.getDefaultZoom().name();
        } else if (this.c || this.b == null) {
            return null;
        } else {
            name = this.b.getDefaultZoom().name();
        }
        return ZoomDensity.valueOf(name);
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        if (this.c && this.a != null) {
            return this.a.getDisplayZoomControls();
        }
        if (this.c || this.b == null || VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.b, "getDisplayZoomControls");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        if (this.c && this.a != null) {
            return this.a.getDomStorageEnabled();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.getDomStorageEnabled();
        }
    }

    public synchronized String getFantasyFontFamily() {
        if (this.c && this.a != null) {
            return this.a.getFantasyFontFamily();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getFantasyFontFamily();
        }
    }

    public synchronized String getFixedFontFamily() {
        if (this.c && this.a != null) {
            return this.a.getFixedFontFamily();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getFixedFontFamily();
        }
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        if (this.c && this.a != null) {
            return this.a.getJavaScriptCanOpenWindowsAutomatically();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.getJavaScriptCanOpenWindowsAutomatically();
        }
    }

    public synchronized boolean getJavaScriptEnabled() {
        if (this.c && this.a != null) {
            return this.a.getJavaScriptEnabled();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.getJavaScriptEnabled();
        }
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        if (this.c && this.a != null) {
            return LayoutAlgorithm.valueOf(this.a.getLayoutAlgorithm().name());
        } else if (this.c || this.b == null) {
            return null;
        } else {
            return LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
        }
    }

    public boolean getLightTouchEnabled() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? false : this.b.getLightTouchEnabled() : this.a.getLightTouchEnabled();
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? false : this.b.getLoadWithOverviewMode() : this.a.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        if (this.c && this.a != null) {
            return this.a.getLoadsImagesAutomatically();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.getLoadsImagesAutomatically();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        /*
        r3 = this;
        r0 = r3.c;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r3.a;
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r0 = r3.a;
        r0 = r0.getMediaPlaybackRequiresUserGesture();
        return r0;
    L_0x000f:
        r0 = r3.c;
        r1 = 0;
        if (r0 != 0) goto L_0x0031;
    L_0x0014:
        r0 = r3.b;
        if (r0 == 0) goto L_0x0031;
    L_0x0018:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 17;
        if (r0 >= r2) goto L_0x001f;
    L_0x001e:
        return r1;
    L_0x001f:
        r0 = r3.b;
        r2 = "getMediaPlaybackRequiresUserGesture";
        r0 = com.tencent.smtt.utils.v.a(r0, r2);
        if (r0 != 0) goto L_0x002a;
    L_0x0029:
        return r1;
    L_0x002a:
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        return r0;
    L_0x0031:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.getMediaPlaybackRequiresUserGesture():boolean");
    }

    public synchronized int getMinimumFontSize() {
        if (this.c && this.a != null) {
            return this.a.getMinimumFontSize();
        } else if (this.c || this.b == null) {
            return 0;
        } else {
            return this.b.getMinimumFontSize();
        }
    }

    public synchronized int getMinimumLogicalFontSize() {
        if (this.c && this.a != null) {
            return this.a.getMinimumLogicalFontSize();
        } else if (this.c || this.b == null) {
            return 0;
        } else {
            return this.b.getMinimumLogicalFontSize();
        }
    }

    public synchronized int getMixedContentMode() {
        if (this.c && this.a != null) {
            try {
                return this.a.getMixedContentMode();
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        } else if (VERSION.SDK_INT < 21) {
            return -1;
        } else {
            Object a = v.a(this.b, "getMixedContentMode", new Class[0], new Object[0]);
            if (a == null) {
                return -1;
            }
            return ((Integer) a).intValue();
        }
    }

    public boolean getNavDump() {
        if (this.c && this.a != null) {
            return this.a.getNavDump();
        }
        if (this.c || this.b == null) {
            return false;
        }
        Object a = v.a(this.b, "getNavDump");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(8)
    @java.lang.Deprecated
    public synchronized com.tencent.smtt.sdk.WebSettings.PluginState getPluginState() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.c;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0019;
    L_0x0005:
        r0 = r3.a;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0019;
    L_0x0009:
        r0 = r3.a;	 Catch:{ all -> 0x0044 }
        r0 = r0.getPluginState();	 Catch:{ all -> 0x0044 }
        r0 = r0.name();	 Catch:{ all -> 0x0044 }
        r0 = com.tencent.smtt.sdk.WebSettings.PluginState.valueOf(r0);	 Catch:{ all -> 0x0044 }
        monitor-exit(r3);
        return r0;
    L_0x0019:
        r0 = r3.c;	 Catch:{ all -> 0x0044 }
        r1 = 0;
        if (r0 != 0) goto L_0x0042;
    L_0x001e:
        r0 = r3.b;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0042;
    L_0x0022:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0044 }
        r2 = 8;
        if (r0 < r2) goto L_0x0040;
    L_0x0028:
        r0 = r3.b;	 Catch:{ all -> 0x0044 }
        r2 = "getPluginState";
        r0 = com.tencent.smtt.utils.v.a(r0, r2);	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0034;
    L_0x0032:
        monitor-exit(r3);
        return r1;
    L_0x0034:
        r0 = (android.webkit.WebSettings.PluginState) r0;	 Catch:{ all -> 0x0044 }
        r0 = r0.name();	 Catch:{ all -> 0x0044 }
        r0 = com.tencent.smtt.sdk.WebSettings.PluginState.valueOf(r0);	 Catch:{ all -> 0x0044 }
        monitor-exit(r3);
        return r0;
    L_0x0040:
        monitor-exit(r3);
        return r1;
    L_0x0042:
        monitor-exit(r3);
        return r1;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.getPluginState():com.tencent.smtt.sdk.WebSettings$PluginState");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(8)
    @java.lang.Deprecated
    public synchronized boolean getPluginsEnabled() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.c;	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.a;	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r3.a;	 Catch:{ all -> 0x004d }
        r0 = r0.getPluginsEnabled();	 Catch:{ all -> 0x004d }
        monitor-exit(r3);
        return r0;
    L_0x0011:
        r0 = r3.c;	 Catch:{ all -> 0x004d }
        r1 = 0;
        if (r0 != 0) goto L_0x004b;
    L_0x0016:
        r0 = r3.b;	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x004b;
    L_0x001a:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x004d }
        r2 = 17;
        if (r0 > r2) goto L_0x0034;
    L_0x0020:
        r0 = r3.b;	 Catch:{ all -> 0x004d }
        r2 = "getPluginsEnabled";
        r0 = com.tencent.smtt.utils.v.a(r0, r2);	 Catch:{ all -> 0x004d }
        if (r0 != 0) goto L_0x002c;
    L_0x002a:
        monitor-exit(r3);
        return r1;
    L_0x002c:
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x004d }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x004d }
        monitor-exit(r3);
        return r0;
    L_0x0034:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x004d }
        r2 = 18;
        if (r0 != r2) goto L_0x0049;
    L_0x003a:
        r0 = r3.b;	 Catch:{ all -> 0x004d }
        r0 = r0.getPluginState();	 Catch:{ all -> 0x004d }
        r2 = android.webkit.WebSettings.PluginState.ON;	 Catch:{ all -> 0x004d }
        if (r2 != r0) goto L_0x0047;
    L_0x0044:
        r0 = 1;
        monitor-exit(r3);
        return r0;
    L_0x0047:
        monitor-exit(r3);
        return r1;
    L_0x0049:
        monitor-exit(r3);
        return r1;
    L_0x004b:
        monitor-exit(r3);
        return r1;
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.getPluginsEnabled():boolean");
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        if (this.c && this.a != null) {
            return this.a.getPluginsPath();
        } else if (this.c || this.b == null) {
            return "";
        } else if (VERSION.SDK_INT <= 17) {
            Object a = v.a(this.b, "getPluginsPath");
            if (a == null) {
                return null;
            }
            return (String) a;
        } else {
            return "";
        }
    }

    public synchronized String getSansSerifFontFamily() {
        if (this.c && this.a != null) {
            return this.a.getSansSerifFontFamily();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getSansSerifFontFamily();
        }
    }

    public boolean getSaveFormData() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? false : this.b.getSaveFormData() : this.a.getSaveFormData();
    }

    public boolean getSavePassword() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? false : this.b.getSavePassword() : this.a.getSavePassword();
    }

    public synchronized String getSerifFontFamily() {
        if (this.c && this.a != null) {
            return this.a.getSerifFontFamily();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getSerifFontFamily();
        }
    }

    public synchronized String getStandardFontFamily() {
        if (this.c && this.a != null) {
            return this.a.getStandardFontFamily();
        } else if (this.c || this.b == null) {
            return "";
        } else {
            return this.b.getStandardFontFamily();
        }
    }

    public TextSize getTextSize() {
        String name;
        if (this.c && this.a != null) {
            name = this.a.getTextSize().name();
        } else if (this.c || this.b == null) {
            return null;
        } else {
            name = this.b.getTextSize().name();
        }
        return TextSize.valueOf(name);
    }

    @android.annotation.TargetApi(14)
    public synchronized int getTextZoom() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.c;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ all -> 0x0040 }
    L_0x0005:
        r0 = r3.a;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ all -> 0x0040 }
    L_0x0009:
        r0 = r3.a;	 Catch:{ all -> 0x0040 }
        r0 = r0.getTextZoom();	 Catch:{ all -> 0x0040 }
        monitor-exit(r3);
        return r0;
    L_0x0011:
        r0 = r3.c;	 Catch:{ all -> 0x0040 }
        r1 = 0;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x003e;	 Catch:{ all -> 0x0040 }
    L_0x0016:
        r0 = r3.b;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x003e;	 Catch:{ all -> 0x0040 }
    L_0x001a:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0040 }
        r2 = 14;
        if (r0 >= r2) goto L_0x0022;
    L_0x0020:
        monitor-exit(r3);
        return r1;
    L_0x0022:
        r0 = r3.b;	 Catch:{ Exception -> 0x002a }
        r0 = r0.getTextZoom();	 Catch:{ Exception -> 0x002a }
        monitor-exit(r3);
        return r0;
    L_0x002a:
        r0 = r3.b;	 Catch:{ all -> 0x0040 }
        r2 = "getTextZoom";	 Catch:{ all -> 0x0040 }
        r0 = com.tencent.smtt.utils.v.a(r0, r2);	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x0036;
    L_0x0034:
        monitor-exit(r3);
        return r1;
    L_0x0036:
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0040 }
        r0 = r0.intValue();	 Catch:{ all -> 0x0040 }
        monitor-exit(r3);
        return r0;
    L_0x003e:
        monitor-exit(r3);
        return r1;
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.getTextZoom():int");
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        if (this.c && this.a != null) {
            return this.a.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (this.c || this.b == null) {
            return false;
        }
        Object a = v.a(this.b, "getUseWebViewBackgroundForOverscrollBackground");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        if (this.c && this.a != null) {
            return this.a.getUseWideViewPort();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.getUseWideViewPort();
        }
    }

    @TargetApi(3)
    public String getUserAgentString() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? "" : this.b.getUserAgentString() : this.a.getUserAgentString();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        if (this.c && this.a != null) {
            this.a.setAllowContentAccess(z);
        } else if (!this.c && this.b != null && VERSION.SDK_INT >= 11) {
            v.a(this.b, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setAllowFileAccess(z);
            }
            return;
        }
        this.a.setAllowFileAccess(z);
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                v.a(this.b, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
            return;
        }
        this.a.setAllowFileAccessFromFileURLs(z);
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                v.a(this.b, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
            return;
        }
        this.a.setAllowUniversalAccessFromFileURLs(z);
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setAppCacheEnabled(z);
            }
            return;
        }
        this.a.setAppCacheEnabled(z);
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setAppCacheMaxSize(j);
            }
            return;
        }
        this.a.setAppCacheMaxSize(j);
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setAppCachePath(str);
            }
            return;
        }
        this.a.setAppCachePath(str);
    }

    public void setBlockNetworkImage(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setBlockNetworkImage(z);
            }
            return;
        }
        this.a.setBlockNetworkImage(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.c;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r2.a;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r2.a;	 Catch:{ all -> 0x0029 }
        r0.setBlockNetworkLoads(r3);	 Catch:{ all -> 0x0029 }
        monitor-exit(r2);
        return;
    L_0x0010:
        r0 = r2.c;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0027;
    L_0x0014:
        r0 = r2.b;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0027;
    L_0x0018:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0029 }
        r1 = 8;
        if (r0 < r1) goto L_0x0025;
    L_0x001e:
        r0 = r2.b;	 Catch:{ all -> 0x0029 }
        r0.setBlockNetworkLoads(r3);	 Catch:{ all -> 0x0029 }
        monitor-exit(r2);
        return;
    L_0x0025:
        monitor-exit(r2);
        return;
    L_0x0027:
        monitor-exit(r2);
        return;
    L_0x0029:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setBlockNetworkLoads(boolean):void");
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setBuiltInZoomControls(z);
            }
            return;
        }
        this.a.setBuiltInZoomControls(z);
    }

    public void setCacheMode(int i) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setCacheMode(i);
            }
            return;
        }
        this.a.setCacheMode(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setCursiveFontFamily(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setCursiveFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setCursiveFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setCursiveFontFamily(java.lang.String):void");
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setDatabaseEnabled(z);
            }
            return;
        }
        this.a.setDatabaseEnabled(z);
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                v.a(this.b, "setDatabasePath", new Class[]{String.class}, str);
            }
            return;
        }
        this.a.setDatabasePath(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setDefaultFixedFontSize(int r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setDefaultFixedFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setDefaultFixedFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setDefaultFixedFontSize(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setDefaultFontSize(int r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setDefaultFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setDefaultFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setDefaultFontSize(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setDefaultTextEncodingName(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setDefaultTextEncodingName(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setDefaultTextEncodingName(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setDefaultTextEncodingName(java.lang.String):void");
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
            }
            return;
        }
        this.a.setDefaultZoom(com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        if (this.c && this.a != null) {
            this.a.setDisplayZoomControls(z);
        } else if (!this.c && this.b != null && VERSION.SDK_INT >= 11) {
            v.a(this.b, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setDomStorageEnabled(z);
            }
            return;
        }
        this.a.setDomStorageEnabled(z);
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null || VERSION.SDK_INT < 11)) {
                v.a(this.b, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
            return;
        }
        this.a.setEnableSmoothTransition(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setFantasyFontFamily(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setFantasyFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setFantasyFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setFantasyFontFamily(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setFixedFontFamily(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setFixedFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setFixedFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setFixedFontFamily(java.lang.String):void");
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setGeolocationDatabasePath(str);
            }
            return;
        }
        this.a.setGeolocationDatabasePath(str);
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setGeolocationEnabled(z);
            }
            return;
        }
        this.a.setGeolocationEnabled(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setJavaScriptCanOpenWindowsAutomatically(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setJavaScriptCanOpenWindowsAutomatically(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setJavaScriptCanOpenWindowsAutomatically(boolean):void");
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        try {
            if (!this.c || this.a == null) {
                if (!(this.c || this.b == null)) {
                    this.b.setJavaScriptEnabled(z);
                }
                return;
            }
            this.a.setJavaScriptEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
            }
            return;
        }
        this.a.setLayoutAlgorithm(com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
    }

    public void setLightTouchEnabled(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setLightTouchEnabled(z);
            }
            return;
        }
        this.a.setLightTouchEnabled(z);
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setLoadWithOverviewMode(z);
            }
            return;
        }
        this.a.setLoadWithOverviewMode(z);
    }

    public void setLoadsImagesAutomatically(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setLoadsImagesAutomatically(z);
            }
            return;
        }
        this.a.setLoadsImagesAutomatically(z);
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (this.c && this.a != null) {
            this.a.setMediaPlaybackRequiresUserGesture(z);
        } else if (!this.c && this.b != null && VERSION.SDK_INT >= 17) {
            v.a(this.b, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setMinimumFontSize(int r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setMinimumFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setMinimumFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setMinimumFontSize(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setMinimumLogicalFontSize(int r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setMinimumLogicalFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setMinimumLogicalFontSize(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setMinimumLogicalFontSize(int):void");
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        if ((!this.c || this.a == null) && !this.c && this.b != null && VERSION.SDK_INT >= 21) {
            v.a(this.b, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setNavDump(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                v.a(this.b, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
            return;
        }
        this.a.setNavDump(z);
    }

    public void setNeedInitialFocus(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setNeedInitialFocus(z);
            }
            return;
        }
        this.a.setNeedInitialFocus(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(8)
    @java.lang.Deprecated
    public synchronized void setPluginState(com.tencent.smtt.sdk.WebSettings.PluginState r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.c;	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x0018;
    L_0x0005:
        r0 = r6.a;	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x0018;
    L_0x0009:
        r0 = r6.a;	 Catch:{ all -> 0x0047 }
        r7 = r7.name();	 Catch:{ all -> 0x0047 }
        r7 = com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState.valueOf(r7);	 Catch:{ all -> 0x0047 }
        r0.setPluginState(r7);	 Catch:{ all -> 0x0047 }
        monitor-exit(r6);
        return;
    L_0x0018:
        r0 = r6.c;	 Catch:{ all -> 0x0047 }
        if (r0 != 0) goto L_0x0045;
    L_0x001c:
        r0 = r6.b;	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x0045;
    L_0x0020:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0047 }
        r1 = 8;
        if (r0 < r1) goto L_0x0043;
    L_0x0026:
        r7 = r7.name();	 Catch:{ all -> 0x0047 }
        r7 = android.webkit.WebSettings.PluginState.valueOf(r7);	 Catch:{ all -> 0x0047 }
        r0 = r6.b;	 Catch:{ all -> 0x0047 }
        r1 = "setPluginState";
        r2 = 1;
        r3 = new java.lang.Class[r2];	 Catch:{ all -> 0x0047 }
        r4 = android.webkit.WebSettings.PluginState.class;
        r5 = 0;
        r3[r5] = r4;	 Catch:{ all -> 0x0047 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0047 }
        r2[r5] = r7;	 Catch:{ all -> 0x0047 }
        com.tencent.smtt.utils.v.a(r0, r1, r3, r2);	 Catch:{ all -> 0x0047 }
        monitor-exit(r6);
        return;
    L_0x0043:
        monitor-exit(r6);
        return;
    L_0x0045:
        monitor-exit(r6);
        return;
    L_0x0047:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setPluginState(com.tencent.smtt.sdk.WebSettings$PluginState):void");
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                v.a(this.b, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
            return;
        }
        this.a.setPluginsEnabled(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @java.lang.Deprecated
    public synchronized void setPluginsPath(java.lang.String r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.c;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r6.a;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r6.a;	 Catch:{ all -> 0x002f }
        r0.setPluginsPath(r7);	 Catch:{ all -> 0x002f }
        monitor-exit(r6);
        return;
    L_0x0010:
        r0 = r6.c;	 Catch:{ all -> 0x002f }
        if (r0 != 0) goto L_0x002d;
    L_0x0014:
        r0 = r6.b;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r0 = r6.b;	 Catch:{ all -> 0x002f }
        r1 = "setPluginsPath";
        r2 = 1;
        r3 = new java.lang.Class[r2];	 Catch:{ all -> 0x002f }
        r4 = java.lang.String.class;
        r5 = 0;
        r3[r5] = r4;	 Catch:{ all -> 0x002f }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x002f }
        r2[r5] = r7;	 Catch:{ all -> 0x002f }
        com.tencent.smtt.utils.v.a(r0, r1, r3, r2);	 Catch:{ all -> 0x002f }
        monitor-exit(r6);
        return;
    L_0x002d:
        monitor-exit(r6);
        return;
    L_0x002f:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setPluginsPath(java.lang.String):void");
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderPriority.name()));
            }
            return;
        }
        this.a.setRenderPriority(com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setSansSerifFontFamily(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setSansSerifFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setSansSerifFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setSansSerifFontFamily(java.lang.String):void");
    }

    public void setSaveFormData(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setSaveFormData(z);
            }
            return;
        }
        this.a.setSaveFormData(z);
    }

    public void setSavePassword(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setSavePassword(z);
            }
            return;
        }
        this.a.setSavePassword(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setSerifFontFamily(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setSerifFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setSerifFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setSerifFontFamily(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setStandardFontFamily(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r1.a;	 Catch:{ all -> 0x0021 }
        r0.setStandardFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x0010:
        r0 = r1.c;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001f;
    L_0x0014:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r1.b;	 Catch:{ all -> 0x0021 }
        r0.setStandardFontFamily(r2);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return;
    L_0x001f:
        monitor-exit(r1);
        return;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setStandardFontFamily(java.lang.String):void");
    }

    public void setSupportMultipleWindows(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setSupportMultipleWindows(z);
            }
            return;
        }
        this.a.setSupportMultipleWindows(z);
    }

    public void setSupportZoom(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setSupportZoom(z);
            }
            return;
        }
        this.a.setSupportZoom(z);
    }

    public void setTextSize(TextSize textSize) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setTextSize(android.webkit.WebSettings.TextSize.valueOf(textSize.name()));
            }
            return;
        }
        this.a.setTextSize(com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize.valueOf(textSize.name()));
    }

    @android.annotation.TargetApi(14)
    public synchronized void setTextZoom(int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.c;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x0010;	 Catch:{ all -> 0x0040 }
    L_0x0005:
        r0 = r6.a;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x0010;	 Catch:{ all -> 0x0040 }
    L_0x0009:
        r0 = r6.a;	 Catch:{ all -> 0x0040 }
        r0.setTextZoom(r7);	 Catch:{ all -> 0x0040 }
        monitor-exit(r6);
        return;
    L_0x0010:
        r0 = r6.c;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x003e;	 Catch:{ all -> 0x0040 }
    L_0x0014:
        r0 = r6.b;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x003e;	 Catch:{ all -> 0x0040 }
    L_0x0018:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0040 }
        r1 = 14;
        if (r0 >= r1) goto L_0x0020;
    L_0x001e:
        monitor-exit(r6);
        return;
    L_0x0020:
        r0 = r6.b;	 Catch:{ Exception -> 0x0027 }
        r0.setTextZoom(r7);	 Catch:{ Exception -> 0x0027 }
        monitor-exit(r6);
        return;
    L_0x0027:
        r0 = r6.b;	 Catch:{ all -> 0x0040 }
        r1 = "setTextZoom";	 Catch:{ all -> 0x0040 }
        r2 = 1;	 Catch:{ all -> 0x0040 }
        r3 = new java.lang.Class[r2];	 Catch:{ all -> 0x0040 }
        r4 = java.lang.Integer.TYPE;	 Catch:{ all -> 0x0040 }
        r5 = 0;	 Catch:{ all -> 0x0040 }
        r3[r5] = r4;	 Catch:{ all -> 0x0040 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0040 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0040 }
        r2[r5] = r7;	 Catch:{ all -> 0x0040 }
        com.tencent.smtt.utils.v.a(r0, r1, r3, r2);	 Catch:{ all -> 0x0040 }
    L_0x003e:
        monitor-exit(r6);
        return;
    L_0x0040:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebSettings.setTextZoom(int):void");
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                v.a(this.b, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
            return;
        }
        this.a.setUseWebViewBackgroundForOverscrollBackground(z);
    }

    public void setUseWideViewPort(boolean z) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setUseWideViewPort(z);
            }
            return;
        }
        this.a.setUseWideViewPort(z);
    }

    public void setUserAgent(String str) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setUserAgentString(str);
            }
            return;
        }
        this.a.setUserAgent(str);
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setUserAgentString(str);
            }
            return;
        }
        this.a.setUserAgentString(str);
    }

    public synchronized boolean supportMultipleWindows() {
        if (this.c && this.a != null) {
            return this.a.supportMultipleWindows();
        } else if (this.c || this.b == null) {
            return false;
        } else {
            return this.b.supportMultipleWindows();
        }
    }

    public boolean supportZoom() {
        return (!this.c || this.a == null) ? (this.c || this.b == null) ? false : this.b.supportZoom() : this.a.supportZoom();
    }
}
