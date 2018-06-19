package com.umeng.message;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Process;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.h;
import com.umeng.message.provider.a;
import java.io.File;
import java.io.FileOutputStream;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class UmengMessageCallbackHandlerService extends IntentService {
    public static final String TAG = "com.umeng.message.UmengMessageCallbackHandlerService";
    private Context a = this;

    public UmengMessageCallbackHandlerService() {
        super("UmengMessageCallbackHandlerService");
    }

    protected void onHandleIntent(Intent intent) {
        h.a(this.a, Process.myPid());
        if (intent != null) {
            if (intent.getAction() != null) {
                if (intent.getAction().equals(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION)) {
                    try {
                        final String stringExtra = intent.getStringExtra(MsgConstant.KEY_REGISTRATION_ID);
                        boolean booleanExtra = intent.getBooleanExtra("status", false);
                        StringBuilder stringBuilder = new StringBuilder("enable(): register-->:");
                        stringBuilder.append(stringExtra);
                        stringBuilder.append(",status:");
                        stringBuilder.append(booleanExtra);
                        IUmengRegisterCallback registerCallback = PushAgent.getInstance(this.a).getRegisterCallback();
                        if (booleanExtra) {
                            new Thread(new Runnable(this) {
                                final /* synthetic */ UmengMessageCallbackHandlerService b;

                                public void run() {
                                    try {
                                        String deviceToken = MessageSharedPrefs.getInstance(this.b.a).getDeviceToken();
                                        if (!(stringExtra == null || deviceToken == null || stringExtra.equals(deviceToken))) {
                                            MessageSharedPrefs.getInstance(this.b.a).setHasResgister(false);
                                            MessageSharedPrefs.getInstance(this.b.a).setDeviceToken(stringExtra);
                                            this.b.a(this.b.a, stringExtra);
                                            ContentResolver contentResolver = this.b.a.getContentResolver();
                                            a.a(this.b.a);
                                            contentResolver.delete(a.e, null, null);
                                            MessageSharedPrefs.getInstance(this.b.a).resetTags();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                            intent = new Handler(getMainLooper());
                            intent.postDelayed(new Runnable(this) {
                                final /* synthetic */ UmengMessageCallbackHandlerService a;

                                {
                                    this.a = r1;
                                }

                                public void run() {
                                    UTrack.getInstance(this.a.a).trackRegister();
                                }
                            }, 600);
                            if (registerCallback != null) {
                                registerCallback.onSuccess(stringExtra);
                                intent.postDelayed(new Runnable(this) {
                                    final /* synthetic */ UmengMessageCallbackHandlerService a;

                                    {
                                        this.a = r1;
                                    }

                                    public void run() {
                                        PushAgent.getInstance(this.a.a).onAppStart();
                                    }
                                }, 10000);
                            }
                            return;
                        }
                        if (registerCallback != null) {
                            registerCallback.onFailure(intent.getStringExtra("s"), intent.getStringExtra("s1"));
                        }
                    } catch (Intent intent2) {
                        intent2.printStackTrace();
                    }
                } else if (intent2.getAction().equals(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION)) {
                    try {
                        r0 = intent2.getBooleanExtra("status", false);
                        r1 = PushAgent.getInstance(this.a).getCallback();
                        if (r0) {
                            if (r1 != null) {
                                r1.onSuccess();
                            }
                        } else if (r1 != null) {
                            r1.onFailure(intent2.getStringExtra("s"), intent2.getStringExtra("s1"));
                        }
                    } catch (Intent intent22) {
                        intent22.printStackTrace();
                    }
                } else if (intent22.getAction().equals(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION)) {
                    try {
                        r0 = intent22.getBooleanExtra("status", false);
                        r1 = PushAgent.getInstance(this.a).getCallback();
                        if (r0) {
                            if (r1 != null) {
                                r1.onSuccess();
                            }
                        } else if (r1 != null) {
                            r1.onFailure(intent22.getStringExtra("s"), intent22.getStringExtra("s1"));
                        }
                    } catch (Intent intent222) {
                        intent222.printStackTrace();
                    }
                } else {
                    if (intent222.getAction().equals(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION)) {
                        try {
                            UMessage uMessage = new UMessage(new JSONObject(intent222.getStringExtra(AgooConstants.MESSAGE_BODY)));
                            if (UMessage.DISPLAY_TYPE_NOTIFICATIONPULLAPP.equals(uMessage.display_type) != null) {
                                intent222 = PushAgent.getInstance(this.a).getAdHandler();
                            } else {
                                intent222 = PushAgent.getInstance(this.a).getMessageHandler();
                            }
                            if (intent222 != null) {
                                intent222.handleMessage(this.a, uMessage);
                            }
                        } catch (Intent intent2222) {
                            intent2222.toString();
                        }
                    }
                }
            }
        }
    }

    private void a(Context context, String str) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getExternalFilesDir(null).getPath());
        stringBuilder.append("/deviceToken");
        File file = new File(stringBuilder.toString());
        if (file.exists() != null) {
            file.delete();
        }
        context = new FileOutputStream(file);
        context.write(str.getBytes());
        context.close();
    }
}
