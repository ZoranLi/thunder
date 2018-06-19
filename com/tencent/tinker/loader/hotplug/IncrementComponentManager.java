package com.tencent.tinker.loader.hotplug;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Xml;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.cons.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: BUGLY */
public final class IncrementComponentManager {
    private static final String TAG = "Tinker.IncrementCompMgr";
    private static final int TAG_ACTIVITY = 0;
    private static final int TAG_PROVIDER = 2;
    private static final int TAG_RECEIVER = 3;
    private static final int TAG_SERVICE = 1;
    private static final AttrTranslator<ActivityInfo> sActivityInfoAttrTranslator = new AttrTranslator<ActivityInfo>() {
        final void onInit(Context context, int i, XmlPullParser xmlPullParser) {
            if (i == 0) {
                try {
                    if (xmlPullParser.getEventType() != 2 || "activity".equals(xmlPullParser.getName()) == null) {
                        throw new IllegalStateException("unexpected xml parser state when parsing incremental component manifest.");
                    }
                } catch (Context context2) {
                    throw new IllegalStateException(context2);
                }
            }
        }

        final void onTranslate(android.content.Context r4, int r5, java.lang.String r6, java.lang.String r7, android.content.pm.ActivityInfo r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r5 = "name";
            r5 = r5.equals(r6);
            r0 = 46;
            r1 = 0;
            if (r5 == 0) goto L_0x002a;
        L_0x000b:
            r5 = r7.charAt(r1);
            if (r5 != r0) goto L_0x0027;
        L_0x0011:
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r4 = r4.getPackageName();
            r5.append(r4);
            r5.append(r7);
            r4 = r5.toString();
            r8.name = r4;
            return;
        L_0x0027:
            r8.name = r7;
            return;
        L_0x002a:
            r5 = "parentActivityName";
            r5 = r5.equals(r6);
            r2 = 16;
            if (r5 == 0) goto L_0x0057;
        L_0x0034:
            r5 = android.os.Build.VERSION.SDK_INT;
            if (r5 < r2) goto L_0x034c;
        L_0x0038:
            r5 = r7.charAt(r1);
            if (r5 != r0) goto L_0x0054;
        L_0x003e:
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r4 = r4.getPackageName();
            r5.append(r4);
            r5.append(r7);
            r4 = r5.toString();
            r8.parentActivityName = r4;
            return;
        L_0x0054:
            r8.parentActivityName = r7;
            return;
        L_0x0057:
            r5 = "exported";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0068;
        L_0x005f:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            r8.exported = r4;
            return;
        L_0x0068:
            r5 = "launchMode";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0077;
        L_0x0070:
            r4 = r3.parseLaunchMode(r7);
            r8.launchMode = r4;
            return;
        L_0x0077:
            r5 = "theme";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0090;
        L_0x007f:
            r5 = r4.getResources();
            r4 = r4.getPackageName();
            r6 = "style";
            r4 = r5.getIdentifier(r7, r6, r4);
            r8.theme = r4;
            return;
        L_0x0090:
            r5 = "uiOptions";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x00a9;
        L_0x0098:
            r4 = android.os.Build.VERSION.SDK_INT;
            r5 = 14;
            if (r4 < r5) goto L_0x034c;
        L_0x009e:
            r4 = java.lang.Integer.decode(r7);
            r4 = r4.intValue();
            r8.uiOptions = r4;
            return;
        L_0x00a9:
            r5 = "permission";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x00b4;
        L_0x00b1:
            r8.permission = r7;
            return;
        L_0x00b4:
            r5 = "taskAffinity";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x00bf;
        L_0x00bc:
            r8.taskAffinity = r7;
            return;
        L_0x00bf:
            r5 = "multiprocess";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x00d6;
        L_0x00c7:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x00cf:
            r4 = r8.flags;
            r4 = r4 | 1;
            r8.flags = r4;
            return;
        L_0x00d6:
            r5 = "finishOnTaskLaunch";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x00ed;
        L_0x00de:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x00e6:
            r4 = r8.flags;
            r4 = r4 | 2;
            r8.flags = r4;
            return;
        L_0x00ed:
            r5 = "clearTaskOnLaunch";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0104;
        L_0x00f5:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x00fd:
            r4 = r8.flags;
            r4 = r4 | 4;
            r8.flags = r4;
            return;
        L_0x0104:
            r5 = "noHistory";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x011b;
        L_0x010c:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x0114:
            r4 = r8.flags;
            r4 = r4 | 128;
            r8.flags = r4;
            return;
        L_0x011b:
            r5 = "alwaysRetainTaskState";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0132;
        L_0x0123:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x012b:
            r4 = r8.flags;
            r4 = r4 | 8;
            r8.flags = r4;
            return;
        L_0x0132:
            r5 = "stateNotNeeded";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0148;
        L_0x013a:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x0142:
            r4 = r8.flags;
            r4 = r4 | r2;
            r8.flags = r4;
            return;
        L_0x0148:
            r5 = "excludeFromRecents";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x015f;
        L_0x0150:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x0158:
            r4 = r8.flags;
            r4 = r4 | 32;
            r8.flags = r4;
            return;
        L_0x015f:
            r5 = "allowTaskReparenting";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0176;
        L_0x0167:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x016f:
            r4 = r8.flags;
            r4 = r4 | 64;
            r8.flags = r4;
            return;
        L_0x0176:
            r5 = "finishOnCloseSystemDialogs";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x018d;
        L_0x017e:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x0186:
            r4 = r8.flags;
            r4 = r4 | 256;
            r8.flags = r4;
            return;
        L_0x018d:
            r5 = "showOnLockScreen";
            r5 = r5.equals(r6);
            if (r5 != 0) goto L_0x0330;
        L_0x0195:
            r5 = "showForAllUsers";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x019f;
        L_0x019d:
            goto L_0x0330;
        L_0x019f:
            r5 = "immersive";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x01bc;
        L_0x01a7:
            r4 = android.os.Build.VERSION.SDK_INT;
            r5 = 18;
            if (r4 < r5) goto L_0x034c;
        L_0x01ad:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x01b5:
            r4 = r8.flags;
            r4 = r4 | 2048;
            r8.flags = r4;
            return;
        L_0x01bc:
            r5 = "hardwareAccelerated";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x01d9;
        L_0x01c4:
            r4 = android.os.Build.VERSION.SDK_INT;
            r5 = 11;
            if (r4 < r5) goto L_0x034c;
        L_0x01ca:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x01d2:
            r4 = r8.flags;
            r4 = r4 | 512;
            r8.flags = r4;
            return;
        L_0x01d9:
            r5 = "documentLaunchMode";
            r5 = r5.equals(r6);
            r0 = 21;
            if (r5 == 0) goto L_0x01f2;
        L_0x01e3:
            r4 = android.os.Build.VERSION.SDK_INT;
            if (r4 < r0) goto L_0x034c;
        L_0x01e7:
            r4 = java.lang.Integer.decode(r7);
            r4 = r4.intValue();
            r8.documentLaunchMode = r4;
            return;
        L_0x01f2:
            r5 = "maxRecents";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0209;
        L_0x01fa:
            r4 = android.os.Build.VERSION.SDK_INT;
            if (r4 < r0) goto L_0x034c;
        L_0x01fe:
            r4 = java.lang.Integer.decode(r7);
            r4 = r4.intValue();
            r8.maxRecents = r4;
            return;
        L_0x0209:
            r5 = "configChanges";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x021c;
        L_0x0211:
            r4 = java.lang.Integer.decode(r7);
            r4 = r4.intValue();
            r8.configChanges = r4;
            return;
        L_0x021c:
            r5 = "windowSoftInputMode";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x022f;
        L_0x0224:
            r4 = java.lang.Integer.decode(r7);
            r4 = r4.intValue();
            r8.softInputMode = r4;
            return;
        L_0x022f:
            r5 = "persistableMode";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0246;
        L_0x0237:
            r4 = android.os.Build.VERSION.SDK_INT;
            if (r4 < r0) goto L_0x034c;
        L_0x023b:
            r4 = java.lang.Integer.decode(r7);
            r4 = r4.intValue();
            r8.persistableMode = r4;
            return;
        L_0x0246:
            r5 = "allowEmbedded";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0264;
        L_0x024e:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x0256:
            r4 = r8.flags;
            r5 = android.content.pm.ActivityInfo.class;
            r6 = "FLAG_ALLOW_EMBEDDED";
            r5 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.getValueOfStaticIntField(r5, r6, r1);
            r4 = r4 | r5;
            r8.flags = r4;
            return;
        L_0x0264:
            r5 = "autoRemoveFromRecents";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x027f;
        L_0x026c:
            r4 = android.os.Build.VERSION.SDK_INT;
            if (r4 < r0) goto L_0x034c;
        L_0x0270:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x0278:
            r4 = r8.flags;
            r4 = r4 | 8192;
            r8.flags = r4;
            return;
        L_0x027f:
            r5 = "relinquishTaskIdentity";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x029a;
        L_0x0287:
            r4 = android.os.Build.VERSION.SDK_INT;
            if (r4 < r0) goto L_0x034c;
        L_0x028b:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x0293:
            r4 = r8.flags;
            r4 = r4 | 4096;
            r8.flags = r4;
            return;
        L_0x029a:
            r5 = "resumeWhilePausing";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x02b5;
        L_0x02a2:
            r4 = android.os.Build.VERSION.SDK_INT;
            if (r4 < r0) goto L_0x034c;
        L_0x02a6:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x02ae:
            r4 = r8.flags;
            r4 = r4 | 16384;
            r8.flags = r4;
            return;
        L_0x02b5:
            r5 = "screenOrientation";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x02c4;
        L_0x02bd:
            r4 = r3.parseScreenOrientation(r7);
            r8.screenOrientation = r4;
            return;
        L_0x02c4:
            r5 = "label";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x02e4;
        L_0x02cc:
            r4 = r4.getResources();	 Catch:{ Throwable -> 0x02db }
            r5 = "string";	 Catch:{ Throwable -> 0x02db }
            r6 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.sPackageName;	 Catch:{ Throwable -> 0x02db }
            r4 = r4.getIdentifier(r7, r5, r6);	 Catch:{ Throwable -> 0x02db }
            goto L_0x02dc;
        L_0x02db:
            r4 = r1;
        L_0x02dc:
            if (r4 == 0) goto L_0x02e1;
        L_0x02de:
            r8.labelRes = r4;
            return;
        L_0x02e1:
            r8.nonLocalizedLabel = r7;
            return;
        L_0x02e4:
            r5 = "icon";
            r5 = r5.equals(r6);
            r0 = 0;
            if (r5 == 0) goto L_0x02fc;
        L_0x02ed:
            r4 = r4.getResources();	 Catch:{ Throwable -> 0x02fb }
            r5 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.sPackageName;	 Catch:{ Throwable -> 0x02fb }
            r4 = r4.getIdentifier(r7, r0, r5);	 Catch:{ Throwable -> 0x02fb }
            r8.icon = r4;	 Catch:{ Throwable -> 0x02fb }
        L_0x02fb:
            return;
        L_0x02fc:
            r5 = "banner";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0319;
        L_0x0304:
            r5 = android.os.Build.VERSION.SDK_INT;
            r6 = 20;
            if (r5 < r6) goto L_0x034c;
        L_0x030a:
            r4 = r4.getResources();	 Catch:{ Throwable -> 0x0318 }
            r5 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.sPackageName;	 Catch:{ Throwable -> 0x0318 }
            r4 = r4.getIdentifier(r7, r0, r5);	 Catch:{ Throwable -> 0x0318 }
            r8.banner = r4;	 Catch:{ Throwable -> 0x0318 }
        L_0x0318:
            return;
        L_0x0319:
            r5 = "logo";
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x034c;
        L_0x0321:
            r4 = r4.getResources();	 Catch:{ Throwable -> 0x034c }
            r5 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.sPackageName;	 Catch:{ Throwable -> 0x034c }
            r4 = r4.getIdentifier(r7, r0, r5);	 Catch:{ Throwable -> 0x034c }
            r8.logo = r4;	 Catch:{ Throwable -> 0x034c }
            return;
        L_0x0330:
            r4 = android.os.Build.VERSION.SDK_INT;
            r5 = 23;
            if (r4 < r5) goto L_0x034c;
        L_0x0336:
            r4 = "true";
            r4 = r4.equalsIgnoreCase(r7);
            if (r4 == 0) goto L_0x034c;
        L_0x033e:
            r4 = r8.flags;
            r5 = android.content.pm.ActivityInfo.class;
            r6 = "FLAG_SHOW_FOR_ALL_USERS";
            r5 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.getValueOfStaticIntField(r5, r6, r1);
            r4 = r4 | r5;
            r8.flags = r4;
            return;
        L_0x034c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.IncrementComponentManager.1.onTranslate(android.content.Context, int, java.lang.String, java.lang.String, android.content.pm.ActivityInfo):void");
        }

        private int parseLaunchMode(String str) {
            if ("standard".equalsIgnoreCase(str)) {
                return 0;
            }
            if ("singleTop".equalsIgnoreCase(str)) {
                return 1;
            }
            if ("singleTask".equalsIgnoreCase(str)) {
                return 2;
            }
            if ("singleInstance".equalsIgnoreCase(str) != null) {
                return 3;
            }
            return 0;
        }

        private int parseScreenOrientation(String str) {
            if ("unspecified".equalsIgnoreCase(str)) {
                return -1;
            }
            if ("behind".equalsIgnoreCase(str)) {
                return 3;
            }
            if ("landscape".equalsIgnoreCase(str)) {
                return null;
            }
            if ("portrait".equalsIgnoreCase(str)) {
                return 1;
            }
            if ("reverseLandscape".equalsIgnoreCase(str)) {
                return 8;
            }
            if ("reversePortrait".equalsIgnoreCase(str)) {
                return 9;
            }
            if ("sensorLandscape".equalsIgnoreCase(str)) {
                return 6;
            }
            if ("sensorPortrait".equalsIgnoreCase(str)) {
                return 7;
            }
            if ("sensor".equalsIgnoreCase(str)) {
                return 4;
            }
            if ("fullSensor".equalsIgnoreCase(str)) {
                return 10;
            }
            if ("nosensor".equalsIgnoreCase(str)) {
                return 5;
            }
            if (MessageInfo.USER.equalsIgnoreCase(str)) {
                return 2;
            }
            if (VERSION.SDK_INT >= 18 && "fullUser".equalsIgnoreCase(str)) {
                return 13;
            }
            if (VERSION.SDK_INT >= 18 && "locked".equalsIgnoreCase(str)) {
                return 14;
            }
            if (VERSION.SDK_INT >= 18 && "userLandscape".equalsIgnoreCase(str)) {
                return 11;
            }
            if (VERSION.SDK_INT < 18 || "userPortrait".equalsIgnoreCase(str) == null) {
                return -1;
            }
            return 12;
        }
    };
    private static final Map<String, ActivityInfo> sClassNameToActivityInfoMap = new HashMap();
    private static final Map<String, IntentFilter> sClassNameToIntentFilterMap = new HashMap();
    private static Context sContext = null;
    private static volatile boolean sInitialized = false;
    private static String sPackageName;

    /* compiled from: BUGLY */
    private static abstract class AttrTranslator<T_RESULT> {
        void onInit(Context context, int i, XmlPullParser xmlPullParser) {
        }

        abstract void onTranslate(Context context, int i, String str, String str2, T_RESULT t_result);

        private AttrTranslator() {
        }

        final void translate(Context context, int i, XmlPullParser xmlPullParser, T_RESULT t_result) {
            onInit(context, i, xmlPullParser);
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i2 = 0; i2 < attributeCount; i2++) {
                if (DispatchConstants.ANDROID.equals(xmlPullParser.getAttributePrefix(i2))) {
                    onTranslate(context, i, xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2), t_result);
                }
            }
        }
    }

    public static synchronized boolean init(Context context, ShareSecurityCheck shareSecurityCheck) throws IOException {
        synchronized (IncrementComponentManager.class) {
            if (shareSecurityCheck.getMetaContentMap().containsKey(EnvConsts.INCCOMPONENT_META_FILE)) {
                while (context instanceof ContextWrapper) {
                    Context baseContext = ((ContextWrapper) context).getBaseContext();
                    if (baseContext == null) {
                        break;
                    }
                    context = baseContext;
                }
                sContext = context;
                sPackageName = context.getPackageName();
                Closeable stringReader = new StringReader((String) shareSecurityCheck.getMetaContentMap().get(EnvConsts.INCCOMPONENT_META_FILE));
                try {
                    shareSecurityCheck = Xml.newPullParser();
                    shareSecurityCheck.setInput(stringReader);
                    for (int eventType = shareSecurityCheck.getEventType(); eventType != 1; eventType = shareSecurityCheck.next()) {
                        if (eventType == 2) {
                            String name = shareSecurityCheck.getName();
                            if ("activity".equalsIgnoreCase(name)) {
                                ActivityInfo parseActivity = parseActivity(context, shareSecurityCheck);
                                sClassNameToActivityInfoMap.put(parseActivity.name, parseActivity);
                            } else if (!(NotificationCompat.CATEGORY_SERVICE.equalsIgnoreCase(name) || "receiver".equalsIgnoreCase(name))) {
                                "provider".equalsIgnoreCase(name);
                            }
                        }
                    }
                    sInitialized = true;
                    SharePatchFileUtil.closeQuietly(stringReader);
                    return true;
                } catch (Context context2) {
                    throw new IOException(context2);
                } catch (Throwable th) {
                    SharePatchFileUtil.closeQuietly(stringReader);
                }
            } else {
                return null;
            }
        }
    }

    private static synchronized ActivityInfo parseActivity(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ActivityInfo activityInfo;
        synchronized (IncrementComponentManager.class) {
            activityInfo = new ActivityInfo();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            activityInfo.applicationInfo = applicationInfo;
            activityInfo.packageName = sPackageName;
            activityInfo.processName = applicationInfo.processName;
            activityInfo.launchMode = 0;
            activityInfo.permission = applicationInfo.permission;
            activityInfo.screenOrientation = -1;
            activityInfo.taskAffinity = applicationInfo.taskAffinity;
            if (VERSION.SDK_INT >= 11 && (applicationInfo.flags & 536870912) != 0) {
                activityInfo.flags |= 512;
            }
            if (VERSION.SDK_INT >= 21) {
                activityInfo.documentLaunchMode = 0;
            }
            if (VERSION.SDK_INT >= 14) {
                activityInfo.uiOptions = applicationInfo.uiOptions;
            }
            sActivityInfoAttrTranslator.translate(context, 0, xmlPullParser, activityInfo);
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if ("intent-filter".equalsIgnoreCase(name)) {
                        parseIntentFilter(context, activityInfo.name, xmlPullParser);
                    } else if ("meta-data".equalsIgnoreCase(name)) {
                        parseMetaData(context, activityInfo, xmlPullParser);
                    }
                }
            }
        }
        return activityInfo;
    }

    private static synchronized void parseIntentFilter(android.content.Context r9, java.lang.String r10, org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.class;
        monitor-enter(r9);
        r0 = new android.content.IntentFilter;	 Catch:{ all -> 0x0121 }
        r0.<init>();	 Catch:{ all -> 0x0121 }
        r1 = "priority";	 Catch:{ all -> 0x0121 }
        r2 = 0;	 Catch:{ all -> 0x0121 }
        r1 = r11.getAttributeValue(r2, r1);	 Catch:{ all -> 0x0121 }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0121 }
        if (r3 != 0) goto L_0x0020;	 Catch:{ all -> 0x0121 }
    L_0x0015:
        r1 = java.lang.Integer.decode(r1);	 Catch:{ all -> 0x0121 }
        r1 = r1.intValue();	 Catch:{ all -> 0x0121 }
        r0.setPriority(r1);	 Catch:{ all -> 0x0121 }
    L_0x0020:
        r1 = "autoVerify";	 Catch:{ all -> 0x0121 }
        r1 = r11.getAttributeValue(r2, r1);	 Catch:{ all -> 0x0121 }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0121 }
        r4 = 0;
        r5 = 1;
        if (r3 != 0) goto L_0x004d;
    L_0x002e:
        r3 = android.content.IntentFilter.class;	 Catch:{ Throwable -> 0x004d }
        r6 = "setAutoVerify";	 Catch:{ Throwable -> 0x004d }
        r7 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x004d }
        r8 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x004d }
        r7[r4] = r8;	 Catch:{ Throwable -> 0x004d }
        r3 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r3, r6, r7);	 Catch:{ Throwable -> 0x004d }
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x004d }
        r7 = "true";	 Catch:{ Throwable -> 0x004d }
        r1 = r7.equalsIgnoreCase(r1);	 Catch:{ Throwable -> 0x004d }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Throwable -> 0x004d }
        r6[r4] = r1;	 Catch:{ Throwable -> 0x004d }
        r3.invoke(r0, r6);	 Catch:{ Throwable -> 0x004d }
    L_0x004d:
        r1 = r11.getDepth();	 Catch:{ all -> 0x0121 }
    L_0x0051:
        r3 = r11.next();	 Catch:{ all -> 0x0121 }
        if (r3 == r5) goto L_0x011a;	 Catch:{ all -> 0x0121 }
    L_0x0057:
        r6 = 3;	 Catch:{ all -> 0x0121 }
        if (r3 != r6) goto L_0x0060;	 Catch:{ all -> 0x0121 }
    L_0x005a:
        r7 = r11.getDepth();	 Catch:{ all -> 0x0121 }
        if (r7 <= r1) goto L_0x011a;	 Catch:{ all -> 0x0121 }
    L_0x0060:
        if (r3 == r6) goto L_0x0051;	 Catch:{ all -> 0x0121 }
    L_0x0062:
        r6 = 4;	 Catch:{ all -> 0x0121 }
        if (r3 == r6) goto L_0x0051;	 Catch:{ all -> 0x0121 }
    L_0x0065:
        r3 = r11.getName();	 Catch:{ all -> 0x0121 }
        r6 = "action";	 Catch:{ all -> 0x0121 }
        r6 = r6.equals(r3);	 Catch:{ all -> 0x0121 }
        if (r6 == 0) goto L_0x007e;	 Catch:{ all -> 0x0121 }
    L_0x0071:
        r3 = "name";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x0115;	 Catch:{ all -> 0x0121 }
    L_0x0079:
        r0.addAction(r3);	 Catch:{ all -> 0x0121 }
        goto L_0x0115;	 Catch:{ all -> 0x0121 }
    L_0x007e:
        r6 = "category";	 Catch:{ all -> 0x0121 }
        r6 = r6.equals(r3);	 Catch:{ all -> 0x0121 }
        if (r6 == 0) goto L_0x0093;	 Catch:{ all -> 0x0121 }
    L_0x0086:
        r3 = "name";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x0115;	 Catch:{ all -> 0x0121 }
    L_0x008e:
        r0.addCategory(r3);	 Catch:{ all -> 0x0121 }
        goto L_0x0115;	 Catch:{ all -> 0x0121 }
    L_0x0093:
        r6 = "data";	 Catch:{ all -> 0x0121 }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x0115;	 Catch:{ all -> 0x0121 }
    L_0x009b:
        r3 = "mimeType";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x00b0;
    L_0x00a3:
        r0.addDataType(r3);	 Catch:{ MalformedMimeTypeException -> 0x00a7 }
        goto L_0x00b0;
    L_0x00a7:
        r10 = move-exception;
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ all -> 0x0121 }
        r1 = "bad mimeType";	 Catch:{ all -> 0x0121 }
        r0.<init>(r1, r11, r10);	 Catch:{ all -> 0x0121 }
        throw r0;	 Catch:{ all -> 0x0121 }
    L_0x00b0:
        r3 = "scheme";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x00bb;	 Catch:{ all -> 0x0121 }
    L_0x00b8:
        r0.addDataScheme(r3);	 Catch:{ all -> 0x0121 }
    L_0x00bb:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0121 }
        r6 = 19;	 Catch:{ all -> 0x0121 }
        r7 = 2;	 Catch:{ all -> 0x0121 }
        if (r3 < r6) goto L_0x00e3;	 Catch:{ all -> 0x0121 }
    L_0x00c2:
        r3 = "ssp";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x00cd;	 Catch:{ all -> 0x0121 }
    L_0x00ca:
        r0.addDataSchemeSpecificPart(r3, r4);	 Catch:{ all -> 0x0121 }
    L_0x00cd:
        r3 = "sspPrefix";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x00d8;	 Catch:{ all -> 0x0121 }
    L_0x00d5:
        r0.addDataSchemeSpecificPart(r3, r5);	 Catch:{ all -> 0x0121 }
    L_0x00d8:
        r3 = "sspPattern";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x00e3;	 Catch:{ all -> 0x0121 }
    L_0x00e0:
        r0.addDataSchemeSpecificPart(r3, r7);	 Catch:{ all -> 0x0121 }
    L_0x00e3:
        r3 = "host";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        r6 = "port";	 Catch:{ all -> 0x0121 }
        r6 = r11.getAttributeValue(r2, r6);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x00f4;	 Catch:{ all -> 0x0121 }
    L_0x00f1:
        r0.addDataAuthority(r3, r6);	 Catch:{ all -> 0x0121 }
    L_0x00f4:
        r3 = "path";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x00ff;	 Catch:{ all -> 0x0121 }
    L_0x00fc:
        r0.addDataPath(r3, r4);	 Catch:{ all -> 0x0121 }
    L_0x00ff:
        r3 = "pathPrefix";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x010a;	 Catch:{ all -> 0x0121 }
    L_0x0107:
        r0.addDataPath(r3, r5);	 Catch:{ all -> 0x0121 }
    L_0x010a:
        r3 = "pathPattern";	 Catch:{ all -> 0x0121 }
        r3 = r11.getAttributeValue(r2, r3);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x0115;	 Catch:{ all -> 0x0121 }
    L_0x0112:
        r0.addDataPath(r3, r7);	 Catch:{ all -> 0x0121 }
    L_0x0115:
        skipCurrentTag(r11);	 Catch:{ all -> 0x0121 }
        goto L_0x0051;	 Catch:{ all -> 0x0121 }
    L_0x011a:
        r11 = sClassNameToIntentFilterMap;	 Catch:{ all -> 0x0121 }
        r11.put(r10, r0);	 Catch:{ all -> 0x0121 }
        monitor-exit(r9);
        return;
    L_0x0121:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.IncrementComponentManager.parseIntentFilter(android.content.Context, java.lang.String, org.xmlpull.v1.XmlPullParser):void");
    }

    private static synchronized void parseMetaData(Context context, ActivityInfo activityInfo, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        synchronized (IncrementComponentManager.class) {
            ClassLoader classLoader = IncrementComponentManager.class.getClassLoader();
            Object attributeValue = xmlPullParser.getAttributeValue(null, c.e);
            xmlPullParser = xmlPullParser.getAttributeValue(null, RequestHeaders.COLUMN_VALUE);
            if (!TextUtils.isEmpty(attributeValue)) {
                if (activityInfo.metaData == null) {
                    activityInfo.metaData = new Bundle(classLoader);
                }
                activityInfo.metaData.putString(attributeValue, xmlPullParser);
            }
        }
    }

    private static void skipCurrentTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    private static synchronized void ensureInitialized() {
        synchronized (IncrementComponentManager.class) {
            if (sInitialized) {
            } else {
                throw new IllegalStateException("Not initialized!!");
            }
        }
    }

    public static boolean isIncrementActivity(String str) {
        ensureInitialized();
        return (str == null || sClassNameToActivityInfoMap.containsKey(str) == null) ? null : true;
    }

    public static ActivityInfo queryActivityInfo(String str) {
        ensureInitialized();
        return str != null ? (ActivityInfo) sClassNameToActivityInfoMap.get(str) : null;
    }

    public static ResolveInfo resolveIntent(Intent intent) {
        Object className;
        IntentFilter intentFilter;
        ensureInitialized();
        ComponentName component = intent.getComponent();
        int i = -1;
        int i2 = 0;
        if (component != null) {
            className = component.getClassName();
            if (sClassNameToActivityInfoMap.containsKey(className)) {
                i = 0;
            } else {
                className = null;
            }
            intentFilter = null;
        } else {
            int i3 = -1;
            int i4 = 0;
            ResolveInfo resolveInfo = null;
            intentFilter = resolveInfo;
            for (Entry entry : sClassNameToIntentFilterMap.entrySet()) {
                String str = (String) entry.getKey();
                IntentFilter intentFilter2 = (IntentFilter) entry.getValue();
                int match = intentFilter2.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), TAG);
                int i5 = (match == -3 || match == -4 || match == -2 || match == -1) ? 0 : 1;
                int priority = intentFilter2.getPriority();
                if (i5 != 0 && priority > i3) {
                    intentFilter = intentFilter2;
                    resolveInfo = str;
                    i4 = match;
                    i3 = priority;
                }
            }
            className = resolveInfo;
            i2 = i4;
            i = i3;
        }
        if (className == null) {
            return null;
        }
        ResolveInfo resolveInfo2 = new ResolveInfo();
        resolveInfo2.activityInfo = (ActivityInfo) sClassNameToActivityInfoMap.get(className);
        resolveInfo2.filter = intentFilter;
        resolveInfo2.match = i2;
        resolveInfo2.priority = i;
        resolveInfo2.resolvePackageName = sPackageName;
        resolveInfo2.icon = resolveInfo2.activityInfo.icon;
        resolveInfo2.labelRes = resolveInfo2.activityInfo.labelRes;
        return resolveInfo2;
    }

    private IncrementComponentManager() {
        throw new UnsupportedOperationException();
    }
}
