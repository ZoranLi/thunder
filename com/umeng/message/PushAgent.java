package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig.Builder;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.message.UTrack.ICallBack;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.proguard.h;
import com.umeng.message.tag.TagManager;
import java.util.Random;
import org.android.spdy.SpdyAgent;

public class PushAgent {
    public static boolean DEBUG = false;
    private static PushAgent a = null;
    private static boolean d = false;
    private static final String e = "com.umeng.message.PushAgent";
    private TagManager b;
    private Context c;
    private UHandler f;
    private UHandler g;
    private UHandler h;
    private boolean i = false;
    private boolean j = true;
    private Handler k;
    private IUmengRegisterCallback l;
    private IUmengCallback m;

    private PushAgent(Context context) {
        try {
            this.c = context;
            this.b = TagManager.getInstance(context);
            this.f = new UmengMessageHandler();
            this.g = new UmengAdHandler();
            this.h = new UmengNotificationClickHandler();
        } catch (Exception e) {
            UmLog.e(e, e.getMessage());
        }
        this.k = new Handler(this, context.getMainLooper()) {
            final /* synthetic */ PushAgent a;

            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
    }

    public static synchronized PushAgent getInstance(Context context) {
        synchronized (PushAgent.class) {
            if (a == null) {
                a = new PushAgent(context.getApplicationContext());
            }
            context = a;
        }
        return context;
    }

    private void b() {
        try {
            if (VERSION.SDK_INT < 11) {
                UmLog.e(e, "Push SDK does not work for Android Verion < 11");
            } else if (h.a(this.c, this.k)) {
                UmLog.d(e, "The AndroidManifest config is right");
                if (!TextUtils.isEmpty(getMessageAppkey())) {
                    if (!TextUtils.isEmpty(getMessageSecret())) {
                        h.a(this.c, UmengMessageCallbackHandlerService.class);
                        if (UmLog.LOG) {
                            h.b(this.c, this.k);
                        }
                        ALog.setUseTlog(false);
                        anet.channel.util.ALog.setUseTlog(false);
                        ACCSClient.setEnvironment(this.c, 0);
                        Builder builder = new Builder();
                        StringBuilder stringBuilder = new StringBuilder("umeng:");
                        stringBuilder.append(getMessageAppkey());
                        ACCSClient.init(this.c, builder.setAppKey(stringBuilder.toString()).setAppSecret(getMessageSecret()).setInappHost("umengacs.m.taobao.com").setInappPubKey(11).setChannelHost("umengjmacs.m.taobao.com").setChannelPubKey(11).setKeepAlive(e()).setAutoUnit(false).build());
                        DispatchConstants.setAmdcServerDomain(new String[]{"amdcopen.m.taobao.com", "amdc.wapa.taobao.com", "amdc.taobao.net"});
                        r1 = new String[3][];
                        r1[0] = new String[]{"106.11.61.135", "106.11.61.137"};
                        r1[1] = null;
                        r1[2] = null;
                        DispatchConstants.setAmdcServerFixIp(r1);
                        if (UmengMessageDeviceConfig.isMiui8()) {
                            TaobaoRegister.setAgooMsgReceiveService("com.umeng.message.XiaomiIntentService");
                        } else {
                            TaobaoRegister.setAgooMsgReceiveService("com.umeng.message.UmengIntentService");
                        }
                        Context context = this.c;
                        StringBuilder stringBuilder2 = new StringBuilder("umeng:");
                        stringBuilder2.append(getMessageAppkey());
                        TaobaoRegister.register(context, stringBuilder2.toString(), getMessageSecret(), "android@umeng", new IRegister(this) {
                            final /* synthetic */ PushAgent a;

                            {
                                this.a = r1;
                            }

                            public void onSuccess(String str) {
                                String a = PushAgent.e;
                                StringBuilder stringBuilder = new StringBuilder("register-->onSuccess:");
                                stringBuilder.append(str);
                                UmLog.i(a, stringBuilder.toString());
                                this.a.a(str);
                            }

                            public void onFailure(String str, String str2) {
                                String a = PushAgent.e;
                                StringBuilder stringBuilder = new StringBuilder("register-->onFailure-->s:");
                                stringBuilder.append(str);
                                stringBuilder.append(",s1:");
                                stringBuilder.append(str2);
                                UmLog.i(a, stringBuilder.toString());
                                this.a.a(str, str2);
                            }
                        });
                        GlobalConfig.setEnableForground(this.c, false);
                        return;
                    }
                }
                UmLog.e(e, "Appkey or Secret key should not be null");
            } else {
                UmLog.e(e, "Need to correct AndroidManifest config according to instruction from http://dev.umeng.com/push/android/integration");
            }
        } catch (Exception e) {
            UmLog.e(e, e.getMessage());
        }
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.setPackage(this.c.getPackageName());
        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        intent.putExtra(MsgConstant.KEY_REGISTRATION_ID, str);
        intent.putExtra("status", true);
        this.c.startService(intent);
    }

    private void a(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage(this.c.getPackageName());
        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        intent.putExtra("status", false);
        intent.putExtra("s", str);
        intent.putExtra("s1", str2);
        this.c.startService(intent);
    }

    private void c() {
        TaobaoRegister.bindAgoo(this.c, new ICallback(this) {
            final /* synthetic */ PushAgent a;

            {
                this.a = r1;
            }

            public void onSuccess() {
                UmLog.i(PushAgent.e, "bindAgoo-->onSuccess");
                Intent intent = new Intent();
                intent.setPackage(this.a.c.getPackageName());
                intent.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
                intent.putExtra("status", true);
                this.a.c.startService(intent);
            }

            public void onFailure(String str, String str2) {
                String a = PushAgent.e;
                StringBuilder stringBuilder = new StringBuilder("bindAgoo-->onFailure-->s:");
                stringBuilder.append(str);
                stringBuilder.append(",s1:");
                stringBuilder.append(str2);
                UmLog.i(a, stringBuilder.toString());
                Intent intent = new Intent();
                intent.setPackage(this.a.c.getPackageName());
                intent.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
                intent.putExtra("status", false);
                intent.putExtra("s", str);
                intent.putExtra("s1", str2);
                this.a.c.startService(intent);
            }
        });
    }

    private void d() {
        try {
            UmLog.i(e, "unBindAgoo");
            TaobaoRegister.unbindAgoo(this.c, new ICallback(this) {
                final /* synthetic */ PushAgent a;

                {
                    this.a = r1;
                }

                public void onSuccess() {
                    UmLog.i(PushAgent.e, "unBindAgoo-->onSuccess");
                    Intent intent = new Intent();
                    intent.setPackage(this.a.c.getPackageName());
                    intent.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
                    intent.putExtra("status", true);
                    this.a.c.startService(intent);
                }

                public void onFailure(String str, String str2) {
                    String a = PushAgent.e;
                    StringBuilder stringBuilder = new StringBuilder("onFailure-->s:");
                    stringBuilder.append(str);
                    stringBuilder.append(",s1:");
                    stringBuilder.append(str2);
                    UmLog.i(a, stringBuilder.toString());
                    Intent intent = new Intent();
                    intent.setPackage(this.a.c.getPackageName());
                    intent.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
                    intent.putExtra("status", false);
                    intent.putExtra("s", str);
                    intent.putExtra("s1", str2);
                    this.a.c.startService(intent);
                }
            });
        } catch (Exception e) {
            UmLog.e(e, e.getMessage());
        }
    }

    public void register(IUmengRegisterCallback iUmengRegisterCallback) {
        setRegisterCallback(iUmengRegisterCallback);
        b();
    }

    public void enable(IUmengCallback iUmengCallback) {
        setCallback(iUmengCallback);
        c();
    }

    public void disable(IUmengCallback iUmengCallback) {
        setCallback(iUmengCallback);
        d();
    }

    public void setMessageHandler(UHandler uHandler) {
        this.f = uHandler;
    }

    public UHandler getMessageHandler() {
        return this.f;
    }

    public UHandler getAdHandler() {
        return this.g;
    }

    public void setNotificationClickHandler(UHandler uHandler) {
        this.h = uHandler;
    }

    public UHandler getNotificationClickHandler() {
        return this.h;
    }

    public TagManager getTagManager() {
        return this.b;
    }

    public void addAlias(String str, String str2, ICallBack iCallBack) {
        UTrack.getInstance(this.c).addAlias(str, str2, iCallBack);
    }

    public void addExclusiveAlias(String str, String str2, ICallBack iCallBack) {
        UTrack.getInstance(this.c).addExclusiveAlias(str, str2, iCallBack);
    }

    public void removeAlias(String str, String str2, ICallBack iCallBack) {
        UTrack.getInstance(this.c).removeAlias(str, str2, iCallBack);
    }

    public String getMessageSecret() {
        String messageAppSecret = MessageSharedPrefs.getInstance(this.c).getMessageAppSecret();
        return TextUtils.isEmpty(messageAppSecret) ? UmengMessageDeviceConfig.getMetaData(this.c, "UMENG_MESSAGE_SECRET") : messageAppSecret;
    }

    public String getMessageAppkey() {
        String messageAppKey = MessageSharedPrefs.getInstance(this.c).getMessageAppKey();
        return TextUtils.isEmpty(messageAppKey) ? UmengMessageDeviceConfig.getAppkey(this.c) : messageAppKey;
    }

    public String getMessageChannel() {
        String messageChannel = MessageSharedPrefs.getInstance(this.c).getMessageChannel();
        return TextUtils.isEmpty(messageChannel) ? UmengMessageDeviceConfig.getChannel(this.c) : messageChannel;
    }

    public void onAppStart() {
        UTrack.getInstance(this.c).trackAppLaunch(10000);
        UTrack.getInstance(this.c).sendCachedMsgLog(isAppLaunchByMessage() ? Math.abs(new Random().nextLong() % MsgConstant.b) : 0);
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setPushIntentServiceClass(cls);
        }
    }

    public String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(this.c).getPushIntentServiceClass();
    }

    public void setDebugMode(boolean z) {
        UmLog.LOG = z;
        ALog.setPrintLog(z);
        anet.channel.util.ALog.setPrintLog(z);
        SpdyAgent.enableDebug = z;
    }

    public void setNoDisturbMode(int i, int i2, int i3, int i4) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).a(i, i2, i3, i4);
        }
    }

    public int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(this.c).a();
    }

    public int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(this.c).b();
    }

    public int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(this.c).c();
    }

    public int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(this.c).d();
    }

    public static void setAppLaunchByMessage() {
        d = true;
    }

    public static boolean isAppLaunchByMessage() {
        return d;
    }

    public String getRegistrationId() {
        return MessageSharedPrefs.getInstance(this.c).getDeviceToken();
    }

    public void setDisplayNotificationNumber(int i) {
        if (h.d(this.c) && i >= 0 && i <= 10) {
            MessageSharedPrefs.getInstance(this.c).setDisplayNotificationNumber(i);
        }
    }

    public int getDisplayNotificationNumber() {
        return MessageSharedPrefs.getInstance(this.c).getDisplayNotificationNumber();
    }

    public void setAppkeyAndSecret(String str, String str2) {
        if (h.d(this.c)) {
            String messageAppKey = MessageSharedPrefs.getInstance(this.c).getMessageAppKey();
            String messageAppSecret = MessageSharedPrefs.getInstance(this.c).getMessageAppSecret();
            if (!(messageAppKey.equals(str) || messageAppSecret.equals(str2))) {
                MessageSharedPrefs.getInstance(this.c).removeMessageAppKey();
                MessageSharedPrefs.getInstance(this.c).removeMessageAppSecret();
            }
            MessageSharedPrefs.getInstance(this.c).setMessageAppKey(str);
            MessageSharedPrefs.getInstance(this.c).setMessageAppSecret(str2);
            UTrack.getInstance(this.c).updateHeader();
        }
    }

    public void setMessageChannel(String str) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setMessageChannel(str);
            UTrack.getInstance(this.c).updateHeader();
        }
    }

    public void setRegisterCallback(IUmengRegisterCallback iUmengRegisterCallback) {
        this.l = iUmengRegisterCallback;
    }

    public IUmengRegisterCallback getRegisterCallback() {
        return this.l;
    }

    public void setCallback(IUmengCallback iUmengCallback) {
        this.m = iUmengCallback;
    }

    public IUmengCallback getCallback() {
        return this.m;
    }

    public void setMuteDurationSeconds(int i) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setMuteDuration(i);
        }
    }

    public int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(this.c).getMuteDuration();
    }

    public boolean isIncludesUmengUpdateSDK() {
        Class cls;
        try {
            cls = Class.forName("com.umeng.update.UmengUpdateAgent");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        return cls != null;
    }

    public boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(this.c).getNotificaitonOnForeground();
    }

    public void setNotificaitonOnForeground(boolean z) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setNotificaitonOnForeground(z);
        }
    }

    public String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(this.c).getResourcePackageName();
    }

    public void setResourcePackageName(String str) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setResourcePackageName(str);
        }
    }

    public boolean isPushCheck() {
        return this.i;
    }

    public void setPushCheck(boolean z) {
        this.i = z;
    }

    public int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(this.c).getNotificationPlayVibrate();
    }

    public void setNotificationPlayVibrate(int i) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setNotificationPlayVibrate(i);
        }
    }

    public int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(this.c).getNotificationPlayLights();
    }

    public void setNotificationPlayLights(int i) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setNotificationPlayLights(i);
        }
    }

    public int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(this.c).getNotificationPlaySound();
    }

    public void setNotificationPlaySound(int i) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).setNotificationPlaySound(i);
        }
    }

    public void keepLowPowerMode(boolean z) {
        this.j = z ^ 1;
    }

    private boolean e() {
        return this.j;
    }

    public void setEnableForground(Context context, boolean z) {
        GlobalConfig.setEnableForground(context, z);
    }

    public void setLocationInterval(int i) {
        MessageSharedPrefs.getInstance(this.c).setLocationInterval(i);
    }

    public int getLocationInterval() {
        return MessageSharedPrefs.getInstance(this.c).getLocationInterval();
    }

    public void setNotificationChannelName(String str) {
        if (h.d(this.c)) {
            MessageSharedPrefs.getInstance(this.c).b(str);
        }
    }

    public String getNotificationChannelName() {
        return MessageSharedPrefs.getInstance(this.c).h();
    }
}
