package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.igexin.assist.sdk.AssistPushConsts;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.mipush.sdk.PushMessageHandler.a;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.as;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.ag;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.ak;
import com.xiaomi.xmpush.thrift.an;
import com.xiaomi.xmpush.thrift.ap;
import com.xiaomi.xmpush.thrift.ar;
import com.xiaomi.xmpush.thrift.at;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.t;
import com.xiaomi.xmpush.thrift.u;
import com.xiaomi.xmpush.thrift.w;
import com.xiaomi.xmpush.thrift.z;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class aa {
    private static aa a;
    private static Queue<String> c;
    private static Object d = new Object();
    private Context b;

    private aa(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map) {
        Intent launchIntentForPackage;
        StringBuilder stringBuilder;
        MalformedURLException e;
        StringBuilder stringBuilder2;
        URISyntaxException e2;
        if (map == null || !map.containsKey("notify_effect")) {
            return null;
        }
        String str2 = (String) map.get("notify_effect");
        if (as.a.equals(str2)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e3) {
                stringBuilder = new StringBuilder("Cause: ");
                stringBuilder.append(e3.getMessage());
                b.d(stringBuilder.toString());
            }
        } else if (!as.b.equals(str2)) {
            if (as.c.equals(str2)) {
                str = (String) map.get("web_uri");
                if (str != null) {
                    str = str.trim();
                    if (!(str.startsWith("http://") || str.startsWith("https://"))) {
                        stringBuilder = new StringBuilder("http://");
                        stringBuilder.append(str);
                        str = stringBuilder.toString();
                    }
                    try {
                        r6 = new URL(str).getProtocol();
                        if (HttpConstant.HTTP.equals(r6) || "https".equals(r6)) {
                            launchIntentForPackage = new Intent("android.intent.action.VIEW");
                            try {
                                launchIntentForPackage.setData(Uri.parse(str));
                            } catch (MalformedURLException e4) {
                                e = e4;
                                stringBuilder2 = new StringBuilder("Cause: ");
                                str = e.getMessage();
                                stringBuilder2.append(str);
                                b.d(stringBuilder2.toString());
                                if (launchIntentForPackage != null) {
                                    launchIntentForPackage.addFlags(268435456);
                                    if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                                    }
                                }
                            }
                        }
                    } catch (MalformedURLException e5) {
                        e = e5;
                        launchIntentForPackage = null;
                        stringBuilder2 = new StringBuilder("Cause: ");
                        str = e.getMessage();
                        stringBuilder2.append(str);
                        b.d(stringBuilder2.toString());
                        if (launchIntentForPackage != null) {
                            launchIntentForPackage.addFlags(268435456);
                            if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                            }
                        }
                    }
                }
            }
            launchIntentForPackage = null;
        } else if (map.containsKey("intent_uri")) {
            r6 = (String) map.get("intent_uri");
            if (r6 != null) {
                try {
                    launchIntentForPackage = Intent.parseUri(r6, 1);
                    try {
                        launchIntentForPackage.setPackage(str);
                    } catch (URISyntaxException e6) {
                        e2 = e6;
                        stringBuilder2 = new StringBuilder("Cause: ");
                        str = e2.getMessage();
                        stringBuilder2.append(str);
                        b.d(stringBuilder2.toString());
                        if (launchIntentForPackage != null) {
                            launchIntentForPackage.addFlags(268435456);
                            try {
                                return context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null ? null : launchIntentForPackage;
                            } catch (Exception e7) {
                                StringBuilder stringBuilder3 = new StringBuilder("Cause: ");
                                stringBuilder3.append(e7.getMessage());
                                b.d(stringBuilder3.toString());
                            }
                        }
                    }
                } catch (URISyntaxException e8) {
                    e2 = e8;
                    launchIntentForPackage = null;
                    stringBuilder2 = new StringBuilder("Cause: ");
                    str = e2.getMessage();
                    stringBuilder2.append(str);
                    b.d(stringBuilder2.toString());
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(268435456);
                        if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                        }
                    }
                }
            }
            launchIntentForPackage = null;
        } else {
            if (map.containsKey("class_name")) {
                str2 = (String) map.get("class_name");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(str, str2));
                try {
                    if (map.containsKey("intent_flag")) {
                        intent.setFlags(Integer.parseInt((String) map.get("intent_flag")));
                    }
                } catch (NumberFormatException e9) {
                    stringBuilder = new StringBuilder("Cause by intent_flag: ");
                    stringBuilder.append(e9.getMessage());
                    b.d(stringBuilder.toString());
                }
                launchIntentForPackage = intent;
            }
            launchIntentForPackage = null;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
            }
        }
    }

    private a a(af afVar, boolean z, byte[] bArr) {
        Throwable th;
        af afVar2 = afVar;
        boolean z2 = z;
        a aVar = null;
        try {
            org.apache.thrift.a a = x.a(this.b, afVar2);
            if (a == null) {
                StringBuilder stringBuilder = new StringBuilder("receiving an un-recognized message. ");
                stringBuilder.append(afVar2.a);
                b.d(stringBuilder.toString());
                return null;
            }
            StringBuilder stringBuilder2 = new StringBuilder("receive a message.");
            stringBuilder2.append(a);
            b.c(stringBuilder2.toString());
            com.xiaomi.xmpush.thrift.a a2 = afVar.a();
            StringBuilder stringBuilder3 = new StringBuilder("processing a message, action=");
            stringBuilder3.append(a2);
            b.a(stringBuilder3.toString());
            switch (ab.a[a2.ordinal()]) {
                case 1:
                    if (!c.a(r1.b).k() || z2) {
                        an anVar = (an) a;
                        t l = anVar.l();
                        if (l != null) {
                            if (z2) {
                                if (ah.b(afVar)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(r1.b, l.b(), afVar.m(), afVar2.f, l.d());
                                } else {
                                    MiPushClient.reportMessageClicked(r1.b, l.b(), afVar.m(), l.d());
                                }
                            }
                            if (!z2) {
                                if (!TextUtils.isEmpty(anVar.j()) && MiPushClient.aliasSetTime(r1.b, anVar.j()) < 0) {
                                    MiPushClient.addAlias(r1.b, anVar.j());
                                } else if (!TextUtils.isEmpty(anVar.h()) && MiPushClient.topicSubscribedTime(r1.b, anVar.h()) < 0) {
                                    MiPushClient.addTopic(r1.b, anVar.h());
                                }
                            }
                            String str = (afVar2.h == null || afVar2.h.s() == null) ? null : (String) afVar2.h.j.get("jobkey");
                            if (TextUtils.isEmpty(str)) {
                                str = l.b();
                            }
                            if (z2 || !b(r1.b, str)) {
                                Serializable generateMessage = PushMessageHelper.generateMessage(anVar, afVar.m(), z2);
                                if (generateMessage.getPassThrough() == 0 && !z2 && ah.a(generateMessage.getExtra())) {
                                    ah.a(r1.b, afVar2, bArr);
                                    return null;
                                }
                                StringBuilder stringBuilder4 = new StringBuilder("receive a message, msgid=");
                                stringBuilder4.append(l.b());
                                stringBuilder4.append(", jobkey=");
                                stringBuilder4.append(str);
                                b.a(stringBuilder4.toString());
                                if (z2 && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                    Intent a3;
                                    Map extra = generateMessage.getExtra();
                                    String str2 = (String) extra.get("notify_effect");
                                    if (ah.b(afVar)) {
                                        a3 = a(r1.b, afVar2.f, extra);
                                        if (a3 == null) {
                                            b.a("Getting Intent fail from ignore reg message. ");
                                            return null;
                                        }
                                        Object f = l.f();
                                        if (!TextUtils.isEmpty(f)) {
                                            a3.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, f);
                                        }
                                    } else {
                                        a3 = a(r1.b, r1.b.getPackageName(), extra);
                                        if (a3 == null) {
                                            return null;
                                        }
                                        if (!str2.equals(as.c)) {
                                            a3.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        }
                                    }
                                    r1.b.startActivity(a3);
                                    return null;
                                }
                                aVar = generateMessage;
                            } else {
                                stringBuilder2 = new StringBuilder("drop a duplicate message, key=");
                                stringBuilder2.append(str);
                                b.a(stringBuilder2.toString());
                            }
                            if (afVar.m() == null && !z2) {
                                a(anVar, afVar2);
                                break;
                            }
                        }
                        b.d("receive an empty message without push content, drop it");
                        return null;
                    }
                    b.a("receive a message in pause state. drop it");
                    return null;
                    break;
                case 2:
                    ak akVar = (ak) a;
                    if (akVar.f == 0) {
                        c.a(r1.b).b(akVar.h, akVar.i);
                    }
                    if (!TextUtils.isEmpty(akVar.h)) {
                        aVar = new ArrayList();
                        aVar.add(akVar.h);
                    }
                    a generateCommandMessage = PushMessageHelper.generateCommandMessage("register", aVar, akVar.f, akVar.g, null);
                    ac.a(r1.b).f();
                    return generateCommandMessage;
                case 3:
                    if (((ar) a).f == 0) {
                        c.a(r1.b).h();
                        MiPushClient.clearExtras(r1.b);
                    }
                    PushMessageHandler.a();
                    return null;
                case 4:
                    ap apVar = (ap) a;
                    if (apVar.f == 0) {
                        MiPushClient.addTopic(r1.b, apVar.h());
                    }
                    if (!TextUtils.isEmpty(apVar.h())) {
                        aVar = new ArrayList();
                        aVar.add(apVar.h());
                    }
                    return PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_SUBSCRIBE_TOPIC, aVar, apVar.f, apVar.g, apVar.k());
                case 5:
                    at atVar = (at) a;
                    if (atVar.f == 0) {
                        MiPushClient.removeTopic(r1.b, atVar.h());
                    }
                    if (!TextUtils.isEmpty(atVar.h())) {
                        aVar = new ArrayList();
                        aVar.add(atVar.h());
                    }
                    return PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC, aVar, atVar.f, atVar.g, atVar.k());
                case 6:
                    ae aeVar = (ae) a;
                    Object e = aeVar.e();
                    List k = aeVar.k();
                    if (aeVar.g == 0) {
                        if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCEPT_TIME) && k != null && k.size() > 1) {
                            MiPushClient.addAcceptTime(r1.b, (String) k.get(0), (String) k.get(1));
                            if ("00:00".equals(k.get(0)) && "00:00".equals(k.get(1))) {
                                c.a(r1.b).a(true);
                            } else {
                                c.a(r1.b).a(false);
                            }
                            k = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), k);
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ALIAS) && k != null && k.size() > 0) {
                            MiPushClient.addAlias(r1.b, (String) k.get(0));
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ALIAS) && k != null && k.size() > 0) {
                            MiPushClient.removeAlias(r1.b, (String) k.get(0));
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCOUNT) && k != null && k.size() > 0) {
                            MiPushClient.addAccount(r1.b, (String) k.get(0));
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ACCOUNT) && k != null && k.size() > 0) {
                            MiPushClient.removeAccount(r1.b, (String) k.get(0));
                        }
                    }
                    return PushMessageHelper.generateCommandMessage(e, k, aeVar.g, aeVar.h, aeVar.m());
                case 7:
                    String c;
                    if (a instanceof com.xiaomi.xmpush.thrift.aa) {
                        com.xiaomi.xmpush.thrift.aa aaVar = (com.xiaomi.xmpush.thrift.aa) a;
                        c = aaVar.c();
                        if (r.M.W.equalsIgnoreCase(aaVar.e)) {
                            if (aaVar.g == 0) {
                                synchronized (u.class) {
                                    try {
                                        if (u.a(r1.b).e(c)) {
                                            u.a(r1.b).d(c);
                                            if ("syncing".equals(u.a(r1.b).a(aj.a))) {
                                                u.a(r1.b).a(aj.a, "synced");
                                                MiPushClient.clearNotification(r1.b);
                                                MiPushClient.clearLocalNotificationType(r1.b);
                                                PushMessageHandler.a();
                                                ac.a(r1.b).b();
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                return null;
                            } else if ("syncing".equals(u.a(r1.b).a(aj.a))) {
                                synchronized (u.class) {
                                    try {
                                        if (u.a(r1.b).e(c)) {
                                            if (u.a(r1.b).c(c) < 10) {
                                                u.a(r1.b).b(c);
                                                ac.a(r1.b).a(true, c);
                                            } else {
                                                u.a(r1.b).d(c);
                                            }
                                        }
                                    } catch (Throwable th22) {
                                        th = th22;
                                    }
                                }
                                return null;
                            }
                        } else if (r.N.W.equalsIgnoreCase(aaVar.e)) {
                            if (aaVar.g == 0) {
                                synchronized (u.class) {
                                    try {
                                        if (u.a(r1.b).e(c)) {
                                            u.a(r1.b).d(c);
                                            if ("syncing".equals(u.a(r1.b).a(aj.b))) {
                                                u.a(r1.b).a(aj.b, "synced");
                                            }
                                        }
                                    } catch (Throwable th222) {
                                        th = th222;
                                    }
                                }
                                return null;
                            } else if ("syncing".equals(u.a(r1.b).a(aj.b))) {
                                synchronized (u.class) {
                                    try {
                                        if (u.a(r1.b).e(c)) {
                                            if (u.a(r1.b).c(c) < 10) {
                                                u.a(r1.b).b(c);
                                                ac.a(r1.b).a(false, c);
                                            } else {
                                                u.a(r1.b).d(c);
                                            }
                                        }
                                    } catch (Throwable th2222) {
                                        th = th2222;
                                    }
                                }
                                return null;
                            }
                        } else if (r.U.W.equalsIgnoreCase(aaVar.e)) {
                            if (aaVar.g == 0) {
                                synchronized (u.class) {
                                    try {
                                        if (u.a(r1.b).e(c)) {
                                            u.a(r1.b).d(c);
                                            if ("syncing".equals(u.a(r1.b).a(aj.c))) {
                                                u.a(r1.b).a(aj.c, "synced");
                                            }
                                        }
                                    } catch (Throwable th22222) {
                                        th = th22222;
                                    }
                                }
                                return null;
                            } else if ("syncing".equals(u.a(r1.b).a(aj.c))) {
                                synchronized (u.class) {
                                    try {
                                        if (u.a(r1.b).e(c)) {
                                            if (u.a(r1.b).c(c) < 10) {
                                                u.a(r1.b).b(c);
                                                ac.a(r1.b).a(c);
                                            } else {
                                                u.a(r1.b).d(c);
                                            }
                                        }
                                    } catch (Throwable th222222) {
                                        th = th222222;
                                    }
                                }
                                return null;
                            }
                        }
                        u.a(r1.b).d(c);
                        return null;
                    } else if (a instanceof ai) {
                        ai aiVar = (ai) a;
                        String str3;
                        if ("registration id expired".equalsIgnoreCase(aiVar.e)) {
                            List<String> allAlias = MiPushClient.getAllAlias(r1.b);
                            List<String> allTopic = MiPushClient.getAllTopic(r1.b);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(r1.b);
                            String acceptTime = MiPushClient.getAcceptTime(r1.b);
                            MiPushClient.reInitialize(r1.b, w.a);
                            for (String alias : allAlias) {
                                MiPushClient.setAlias(r1.b, alias, null);
                            }
                            for (String str32 : allTopic) {
                                MiPushClient.subscribe(r1.b, str32, null);
                            }
                            for (String str322 : allUserAccount) {
                                MiPushClient.setUserAccount(r1.b, str322, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.addAcceptTime(r1.b, split[0], split[1]);
                                return null;
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(aiVar.e)) {
                            if (aiVar.i() != null && aiVar.i().containsKey("app_version")) {
                                c.a(r1.b).a((String) aiVar.i().get("app_version"));
                                return null;
                            }
                        } else if ("awake_app".equalsIgnoreCase(aiVar.e)) {
                            if (aiVar.i() != null && aiVar.i().containsKey("packages")) {
                                MiPushClient.awakeApps(r1.b, ((String) aiVar.i().get("packages")).split(Constants.ACCEPT_TIME_SEPARATOR_SP));
                                return null;
                            }
                        } else if (r.n.W.equalsIgnoreCase(aiVar.e)) {
                            com.xiaomi.xmpush.thrift.ah ahVar = new com.xiaomi.xmpush.thrift.ah();
                            try {
                                au.a(ahVar, aiVar.m());
                                com.xiaomi.push.service.an.a(am.a(r1.b), ahVar);
                                return null;
                            } catch (Throwable th2222222) {
                                b.a(th2222222);
                                return null;
                            }
                        } else if (r.o.W.equalsIgnoreCase(aiVar.e)) {
                            ag agVar = new ag();
                            au.a(agVar, aiVar.m());
                            com.xiaomi.push.service.an.a(am.a(r1.b), agVar);
                            return null;
                        } else if (r.w.W.equalsIgnoreCase(aiVar.e)) {
                            al.a(r1.b, aiVar);
                            return null;
                        } else if (r.x.W.equalsIgnoreCase(aiVar.e)) {
                            b.a("receive force sync notification");
                            al.a(r1.b, false);
                            return null;
                        } else if (r.D.W.equalsIgnoreCase(aiVar.e)) {
                            i.a(r1.b).a(aiVar);
                            return null;
                        } else if (r.F.W.equalsIgnoreCase(aiVar.e)) {
                            i.a(r1.b).b(aiVar);
                            return null;
                        } else if (r.H.W.equalsIgnoreCase(aiVar.e)) {
                            i.a(r1.b).c(aiVar);
                            return null;
                        } else if (r.L.W.equals(aiVar.e)) {
                            if (aiVar.i() != null) {
                                int i = -2;
                                if (aiVar.i().containsKey(as.I)) {
                                    c = (String) aiVar.i().get(as.I);
                                    if (!TextUtils.isEmpty(c)) {
                                        try {
                                            i = Integer.parseInt(c);
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                                if (i >= -1) {
                                    MiPushClient.clearNotification(r1.b, i);
                                    return null;
                                }
                                c = "";
                                str322 = "";
                                if (aiVar.i().containsKey(as.G)) {
                                    c = (String) aiVar.i().get(as.G);
                                }
                                if (aiVar.i().containsKey(as.H)) {
                                    str322 = (String) aiVar.i().get(as.H);
                                }
                                MiPushClient.clearNotification(r1.b, c, str322);
                                return null;
                            }
                        } else if (r.R.W.equals(aiVar.e)) {
                            r2 = new ak();
                            au.a(r2, aiVar.m());
                            MiPushClient4Hybrid.onReceiveRegisterResult(r1.b, r2);
                            return null;
                        } else if (r.T.W.equals(aiVar.e)) {
                            r2 = new ar();
                            au.a(r2, aiVar.m());
                            MiPushClient4Hybrid.onReceiveUnregisterResult(r1.b, r2);
                            return null;
                        }
                    }
                    break;
                default:
                    return null;
            }
            return aVar;
        } catch (Throwable th22222222) {
            b.a(th22222222);
            a(afVar);
            return null;
        } catch (Throwable th222222222) {
            b.a(th222222222);
            b.d("receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    private a a(af afVar, byte[] bArr) {
        String str = null;
        String str2;
        try {
            org.apache.thrift.a a = x.a(this.b, afVar);
            StringBuilder stringBuilder;
            if (a == null) {
                stringBuilder = new StringBuilder("message arrived: receiving an un-recognized message. ");
                stringBuilder.append(afVar.a);
                b.d(stringBuilder.toString());
                return null;
            }
            StringBuilder stringBuilder2 = new StringBuilder("message arrived: receive a message.");
            stringBuilder2.append(a);
            b.c(stringBuilder2.toString());
            com.xiaomi.xmpush.thrift.a a2 = afVar.a();
            StringBuilder stringBuilder3 = new StringBuilder("message arrived: processing an arrived message, action=");
            stringBuilder3.append(a2);
            b.a(stringBuilder3.toString());
            if (ab.a[a2.ordinal()] != 1) {
                return null;
            }
            an anVar = (an) a;
            t l = anVar.l();
            if (l == null) {
                str2 = "message arrived: receive an empty message without push content, drop it";
                b.d(str2);
                return null;
            }
            if (!(afVar.h == null || afVar.h.s() == null)) {
                str = (String) afVar.h.j.get("jobkey");
            }
            a generateMessage = PushMessageHelper.generateMessage(anVar, afVar.m(), false);
            generateMessage.setArrivedMessage(true);
            stringBuilder = new StringBuilder("message arrived: receive a message, msgid=");
            stringBuilder.append(l.b());
            stringBuilder.append(", jobkey=");
            stringBuilder.append(str);
            b.a(stringBuilder.toString());
            return generateMessage;
        } catch (Throwable e) {
            b.a(e);
            str2 = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (Throwable e2) {
            b.a(e2);
            str2 = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
    }

    public static aa a(Context context) {
        if (a == null) {
            a = new aa(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0)) > 1800000) {
            MiPushClient.reInitialize(this.b, w.b);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (d) {
            c.remove(str);
            c.a(context);
            SharedPreferences b = c.b(context);
            str = d.a(c, Constants.ACCEPT_TIME_SEPARATOR_SP);
            Editor edit = b.edit();
            edit.putString("pref_msg_ids", str);
            ak.a(edit);
        }
    }

    private void a(af afVar) {
        b.a("receive a message but decrypt failed. report now.");
        org.apache.thrift.a aiVar = new ai(afVar.m().a, false);
        aiVar.c(r.u.W);
        aiVar.b(afVar.h());
        aiVar.d(afVar.f);
        aiVar.h = new HashMap();
        aiVar.h.put("regid", MiPushClient.getRegId(this.b));
        ac.a(this.b).a(aiVar, com.xiaomi.xmpush.thrift.a.i, false, null);
    }

    private void a(an anVar, af afVar) {
        u m = afVar.m();
        org.apache.thrift.a zVar = new z();
        zVar.b(anVar.e());
        zVar.a(anVar.c());
        zVar.a(anVar.l().h());
        if (!TextUtils.isEmpty(anVar.h())) {
            zVar.c(anVar.h());
        }
        if (!TextUtils.isEmpty(anVar.j())) {
            zVar.d(anVar.j());
        }
        zVar.a(au.a(this.b, afVar));
        ac.a(this.b).a(zVar, com.xiaomi.xmpush.thrift.a.f, m);
    }

    private void b(af afVar) {
        u m = afVar.m();
        org.apache.thrift.a zVar = new z();
        zVar.b(afVar.h());
        zVar.a(m.b());
        zVar.a(m.d());
        if (!TextUtils.isEmpty(m.f())) {
            zVar.c(m.f());
        }
        zVar.a(au.a(this.b, afVar));
        ac.a(this.b).a(zVar, com.xiaomi.xmpush.thrift.a.f, false, afVar.m());
    }

    private static boolean b(Context context, String str) {
        synchronized (d) {
            c.a(context);
            SharedPreferences b = c.b(context);
            if (c == null) {
                String[] split = b.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                c = new LinkedList();
                for (Object add : split) {
                    c.add(add);
                }
            }
            if (c.contains(str)) {
                return true;
            }
            c.add(str);
            if (c.size() > 25) {
                c.poll();
            }
            str = d.a(c, Constants.ACCEPT_TIME_SEPARATOR_SP);
            Editor edit = b.edit();
            edit.putString("pref_msg_ids", str);
            ak.a(edit);
            return false;
        }
    }

    private boolean c(af afVar) {
        return TextUtils.equals(Constants.HYBRID_PACKAGE_NAME, afVar.j()) && afVar.m() != null && afVar.m().s() != null && TextUtils.equals("1", (CharSequence) afVar.m().s().get(Constants.EXTRA_KEY_HYBRID_PASS_THROUGH));
    }

    public com.xiaomi.mipush.sdk.PushMessageHandler.a a(android.content.Intent r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r11.getAction();
        r1 = new java.lang.StringBuilder;
        r2 = "receive an intent from server, action=";
        r1.<init>(r2);
        r1.append(r0);
        r1 = r1.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r1);
        r1 = "mrt";
        r1 = r11.getStringExtra(r1);
        if (r1 != 0) goto L_0x0025;
    L_0x001d:
        r1 = java.lang.System.currentTimeMillis();
        r1 = java.lang.Long.toString(r1);
    L_0x0025:
        r2 = "com.xiaomi.mipush.RECEIVE_MESSAGE";
        r2 = r2.equals(r0);
        r3 = 0;
        r4 = 0;
        if (r2 == 0) goto L_0x015a;
    L_0x002f:
        r0 = "mipush_payload";
        r0 = r11.getByteArrayExtra(r0);
        r2 = "mipush_notified";
        r11 = r11.getBooleanExtra(r2, r4);
        if (r0 != 0) goto L_0x0043;
    L_0x003d:
        r11 = "receiving an empty message, drop";
    L_0x003f:
        com.xiaomi.channel.commonutils.logger.b.d(r11);
        return r3;
    L_0x0043:
        r2 = new com.xiaomi.xmpush.thrift.af;
        r2.<init>();
        com.xiaomi.xmpush.thrift.au.a(r2, r0);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r5 = r10.b;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r5 = com.xiaomi.mipush.sdk.c.a(r5);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r6 = r2.m();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = r2.a();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r8 = com.xiaomi.xmpush.thrift.a.e;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r7 != r8) goto L_0x00ad;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x005d:
        if (r6 == 0) goto L_0x00ad;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x005f:
        r7 = r5.k();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r7 != 0) goto L_0x00ad;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0065:
        if (r11 != 0) goto L_0x00ad;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0067:
        r7 = "mrt";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r6.a(r7, r1);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = "mat";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = java.lang.Long.toString(r7);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r6.a(r1, r7);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = r10.c(r2);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 != 0) goto L_0x0083;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x007f:
        r10.b(r2);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        goto L_0x00ad;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0083:
        r1 = "this is a mina's pass through message, ack later";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        com.xiaomi.channel.commonutils.logger.b.b(r1);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = "__mina_message_ts";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = r6.d();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r6.a(r1, r7);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = "__mina_device_status";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = r10.b;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = com.xiaomi.xmpush.thrift.au.a(r7, r2);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r6.a(r1, r7);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = "__mina_appid";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = r2.h();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r6.a(r1, r7);	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00ad:
        r1 = r2.a();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = com.xiaomi.xmpush.thrift.a.e;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 != r7) goto L_0x010c;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00b5:
        r1 = r2.c();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 != 0) goto L_0x010c;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00bb:
        r1 = com.xiaomi.push.service.ah.b(r2);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r7 = 1;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r8 = 2;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 != 0) goto L_0x00e0;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00c3:
        r11 = "drop an un-encrypted messages. %1$s, %2$s";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r0 = new java.lang.Object[r8];	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = r2.j();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r0[r4] = r1;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r6 == 0) goto L_0x00d4;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00cf:
        r1 = r6.b();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        goto L_0x00d6;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00d4:
        r1 = "";	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00d6:
        r0[r7] = r1;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r11 = java.lang.String.format(r11, r0);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        com.xiaomi.channel.commonutils.logger.b.a(r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r3;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00e0:
        if (r11 == 0) goto L_0x00f4;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00e2:
        r1 = r6.s();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 == 0) goto L_0x00f4;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00e8:
        r1 = r6.s();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r9 = "notify_effect";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = r1.containsKey(r9);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 != 0) goto L_0x010c;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x00f4:
        r11 = "drop an un-encrypted messages. %1$s, %2$s";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r0 = new java.lang.Object[r8];	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = r2.j();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r0[r4] = r1;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = r6.b();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r0[r7] = r1;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r11 = java.lang.String.format(r11, r0);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        com.xiaomi.channel.commonutils.logger.b.a(r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r3;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x010c:
        r1 = r5.i();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 != 0) goto L_0x012c;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0112:
        r1 = r2.a;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r4 = com.xiaomi.xmpush.thrift.a.a;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 == r4) goto L_0x012c;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0118:
        r1 = com.xiaomi.push.service.ah.b(r2);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 == 0) goto L_0x0123;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x011e:
        r11 = r10.a(r2, r11, r0);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r11;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0123:
        r11 = "receive message without registration. need re-register!";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        com.xiaomi.channel.commonutils.logger.b.d(r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r10.a();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r3;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x012c:
        r1 = r5.i();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 == 0) goto L_0x0150;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0132:
        r1 = r5.m();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 == 0) goto L_0x0150;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0138:
        r11 = r2.a;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r0 = com.xiaomi.xmpush.thrift.a.b;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r11 != r0) goto L_0x014a;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x013e:
        r5.h();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r11 = r10.b;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        com.xiaomi.mipush.sdk.MiPushClient.clearExtras(r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        com.xiaomi.mipush.sdk.PushMessageHandler.a();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r3;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x014a:
        r11 = r10.b;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        com.xiaomi.mipush.sdk.MiPushClient.unregisterPush(r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r3;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0150:
        r11 = r10.a(r2, r11, r0);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r11;
    L_0x0155:
        r11 = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(r11);
        return r3;
    L_0x015a:
        r1 = "com.xiaomi.mipush.ERROR";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x01bb;
    L_0x0162:
        r0 = new com.xiaomi.mipush.sdk.MiPushCommandMessage;
        r0.<init>();
        r1 = new com.xiaomi.xmpush.thrift.af;
        r1.<init>();
        r2 = "mipush_payload";	 Catch:{ f -> 0x0177 }
        r2 = r11.getByteArrayExtra(r2);	 Catch:{ f -> 0x0177 }
        if (r2 == 0) goto L_0x0177;	 Catch:{ f -> 0x0177 }
    L_0x0174:
        com.xiaomi.xmpush.thrift.au.a(r1, r2);	 Catch:{ f -> 0x0177 }
    L_0x0177:
        r1 = r1.a();
        r1 = java.lang.String.valueOf(r1);
        r0.setCommand(r1);
        r1 = "mipush_error_code";
        r1 = r11.getIntExtra(r1, r4);
        r1 = (long) r1;
        r0.setResultCode(r1);
        r1 = "mipush_error_msg";
        r1 = r11.getStringExtra(r1);
        r0.setReason(r1);
        r1 = new java.lang.StringBuilder;
        r2 = "receive a error message. code = ";
        r1.<init>(r2);
        r2 = "mipush_error_code";
        r2 = r11.getIntExtra(r2, r4);
        r1.append(r2);
        r2 = ", msg= ";
        r1.append(r2);
        r2 = "mipush_error_msg";
        r11 = r11.getStringExtra(r2);
        r1.append(r11);
        r11 = r1.toString();
        com.xiaomi.channel.commonutils.logger.b.d(r11);
        return r0;
    L_0x01bb:
        r1 = "com.xiaomi.mipush.MESSAGE_ARRIVED";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0206;
    L_0x01c3:
        r0 = "mipush_payload";
        r11 = r11.getByteArrayExtra(r0);
        if (r11 != 0) goto L_0x01cf;
    L_0x01cb:
        r11 = "message arrived: receiving an empty message, drop";
        goto L_0x003f;
    L_0x01cf:
        r0 = new com.xiaomi.xmpush.thrift.af;
        r0.<init>();
        com.xiaomi.xmpush.thrift.au.a(r0, r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = r10.b;	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r1 = com.xiaomi.mipush.sdk.c.a(r1);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        r2 = com.xiaomi.push.service.ah.b(r0);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r2 == 0) goto L_0x01e9;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x01e3:
        r11 = "message arrived: receive ignore reg message, ignore!";	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x01e5:
        com.xiaomi.channel.commonutils.logger.b.d(r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r3;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x01e9:
        r2 = r1.i();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r2 != 0) goto L_0x01f2;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x01ef:
        r11 = "message arrived: receive message without registration. need unregister or re-register!";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        goto L_0x01e5;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x01f2:
        r2 = r1.i();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r2 == 0) goto L_0x0201;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x01f8:
        r1 = r1.m();	 Catch:{ f -> 0x0155, f -> 0x0155 }
        if (r1 == 0) goto L_0x0201;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x01fe:
        r11 = "message arrived: app info is invalidated";	 Catch:{ f -> 0x0155, f -> 0x0155 }
        goto L_0x01e5;	 Catch:{ f -> 0x0155, f -> 0x0155 }
    L_0x0201:
        r11 = r10.a(r0, r11);	 Catch:{ f -> 0x0155, f -> 0x0155 }
        return r11;
    L_0x0206:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.aa.a(android.content.Intent):com.xiaomi.mipush.sdk.PushMessageHandler$a");
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        List<String> list2 = list;
        if (timeZone.equals(timeZone2)) {
            return list2;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
        long parseLong = Long.parseLong(((String) list2.get(0)).split(Constants.COLON_SEPARATOR)[0]);
        long parseLong2 = Long.parseLong(((String) list2.get(0)).split(Constants.COLON_SEPARATOR)[1]);
        long j = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(((String) list2.get(1)).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(((String) list2.get(1)).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        List arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)}));
        return arrayList;
    }
}
