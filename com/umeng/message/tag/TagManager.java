package com.umeng.message.tag;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.common.inter.ITagManager.Result;
import com.umeng.message.util.HttpRequest;
import com.umeng.message.util.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TagManager {
    private static final String a = "com.umeng.message.tag.TagManager";
    private static final String b = "ok";
    private static final String c = "fail";
    private static TagManager d;
    private static ITagManager f;
    private Context e;

    public interface TCallBack {
        void onMessage(boolean z, Result result);
    }

    public interface TagListCallBack {
        void onMessage(boolean z, List<String> list);
    }

    private TagManager(Context context) {
        this.e = context.getApplicationContext();
    }

    public static synchronized TagManager getInstance(Context context) {
        synchronized (TagManager.class) {
            if (d == null) {
                d = new TagManager(context.getApplicationContext());
                try {
                    f = (ITagManager) Class.forName("com.umeng.message.common.impl.json.JTagManager").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
            context2 = d;
        }
        return context2;
    }

    public void add(final TCallBack tCallBack, final String... strArr) {
        new Thread(new Runnable(this) {
            final /* synthetic */ TagManager c;

            public void run() {
                Exception e;
                Result add;
                Exception exception;
                Result result = null;
                if (this.c.d()) {
                    try {
                        throw new Exception("Tag API is disabled by the server.");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                } else if (this.c.c()) {
                    if (strArr != null) {
                        if (strArr.length != 0) {
                            List arrayList = new ArrayList();
                            for (String str : strArr) {
                                if (!(MessageSharedPrefs.getInstance(this.c.e).isTagSet(str) || arrayList.contains(str))) {
                                    arrayList.add(str);
                                }
                            }
                            if (arrayList.size() == 0) {
                                tCallBack.onMessage(true, this.c.e());
                                return;
                            }
                            JSONObject e3;
                            try {
                                e3 = this.c.b();
                                try {
                                    e3.put("tags", e.a(arrayList));
                                    add = TagManager.f.add(e3, true, strArr);
                                    try {
                                        tCallBack.onMessage(true, add);
                                        return;
                                    } catch (Exception e4) {
                                        exception = e4;
                                        result = add;
                                        e2 = exception;
                                        e2.printStackTrace();
                                        if (e2.getMessage() == null) {
                                        }
                                        tCallBack.onMessage(false, result);
                                        return;
                                    }
                                } catch (Exception e5) {
                                    e2 = e5;
                                    e2.printStackTrace();
                                    if (e2.getMessage() == null) {
                                    }
                                    tCallBack.onMessage(false, result);
                                    return;
                                }
                            } catch (Exception e6) {
                                e2 = e6;
                                e3 = null;
                                e2.printStackTrace();
                                if (e2.getMessage() == null && e2.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                                    try {
                                        add = TagManager.f.add(e3, false, strArr);
                                        try {
                                            tCallBack.onMessage(true, add);
                                            return;
                                        } catch (Exception e42) {
                                            exception = e42;
                                            result = add;
                                            e2 = exception;
                                            tCallBack.onMessage(false, result);
                                            e2.printStackTrace();
                                            return;
                                        }
                                    } catch (Exception e7) {
                                        e2 = e7;
                                        tCallBack.onMessage(false, result);
                                        e2.printStackTrace();
                                        return;
                                    }
                                }
                                tCallBack.onMessage(false, result);
                                return;
                            }
                        }
                    }
                    try {
                        throw new Exception("No tags");
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                } else {
                    try {
                        throw new Exception("No utdid or device_token");
                    } catch (Exception e222) {
                        e222.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                }
            }
        }).start();
    }

    public void update(final TCallBack tCallBack, final String... strArr) {
        new Thread(new Runnable(this) {
            final /* synthetic */ TagManager c;

            public void run() {
                Exception e;
                JSONObject e2;
                Result update;
                Exception exception;
                Result result = null;
                if (this.c.d()) {
                    try {
                        throw new Exception("Tag API is disabled by the server.");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                } else if (this.c.c()) {
                    if (strArr != null) {
                        if (strArr.length != 0) {
                            List arrayList = new ArrayList();
                            for (Object add : strArr) {
                                arrayList.add(add);
                            }
                            if (arrayList.size() == 0) {
                                tCallBack.onMessage(true, this.c.e());
                                return;
                            }
                            try {
                                e2 = this.c.b();
                                try {
                                    e2.put("tags", e.a(arrayList));
                                    update = TagManager.f.update(e2, true, strArr);
                                } catch (Exception e4) {
                                    e3 = e4;
                                    e3.printStackTrace();
                                    if (e3.getMessage() == null) {
                                    }
                                    tCallBack.onMessage(false, result);
                                    return;
                                }
                                try {
                                    tCallBack.onMessage(true, update);
                                    return;
                                } catch (Exception e5) {
                                    exception = e5;
                                    result = update;
                                    e3 = exception;
                                    e3.printStackTrace();
                                    if (e3.getMessage() == null) {
                                    }
                                    tCallBack.onMessage(false, result);
                                    return;
                                }
                            } catch (Exception e6) {
                                e3 = e6;
                                e2 = null;
                                e3.printStackTrace();
                                if (e3.getMessage() == null && e3.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                                    try {
                                        update = TagManager.f.update(e2, false, strArr);
                                        try {
                                            tCallBack.onMessage(true, update);
                                            return;
                                        } catch (Exception e52) {
                                            exception = e52;
                                            result = update;
                                            e3 = exception;
                                            tCallBack.onMessage(false, result);
                                            e3.printStackTrace();
                                            return;
                                        }
                                    } catch (Exception e7) {
                                        e3 = e7;
                                        tCallBack.onMessage(false, result);
                                        e3.printStackTrace();
                                        return;
                                    }
                                }
                                tCallBack.onMessage(false, result);
                                return;
                            }
                        }
                    }
                    try {
                        throw new Exception("No tags");
                    } catch (Exception e32) {
                        e32.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                } else {
                    try {
                        throw new Exception("No utdid or device_token");
                    } catch (Exception e322) {
                        e322.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                }
            }
        }).start();
    }

    public void delete(final TCallBack tCallBack, final String... strArr) {
        new Thread(new Runnable(this) {
            final /* synthetic */ TagManager c;

            public void run() {
                Exception e;
                Exception exception;
                Result result = null;
                if (this.c.d()) {
                    try {
                        throw new Exception("Tag API is disabled by the server.");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                } else if (this.c.c()) {
                    if (strArr == null || strArr.length == 0) {
                        try {
                            throw new Exception("No tags");
                        } catch (Exception e22) {
                            e22.printStackTrace();
                            tCallBack.onMessage(false, null);
                        }
                    }
                    JSONObject e3;
                    try {
                        e3 = this.c.b();
                        try {
                            e3.put("tags", e.a(strArr));
                            Result delete = TagManager.f.delete(e3, true, strArr);
                            try {
                                tCallBack.onMessage(true, delete);
                            } catch (Exception e4) {
                                Result result2 = delete;
                                exception = e4;
                                result = result2;
                                exception.printStackTrace();
                                if (exception.getMessage() == null && exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                                    try {
                                        Result delete2 = TagManager.f.delete(e3, false, strArr);
                                        try {
                                            tCallBack.onMessage(true, delete2);
                                            return;
                                        } catch (Exception e5) {
                                            e22 = e5;
                                            result = delete2;
                                            tCallBack.onMessage(false, result);
                                            e22.printStackTrace();
                                            return;
                                        }
                                    } catch (Exception e6) {
                                        e22 = e6;
                                        tCallBack.onMessage(false, result);
                                        e22.printStackTrace();
                                        return;
                                    }
                                }
                                tCallBack.onMessage(false, result);
                            }
                        } catch (Exception e7) {
                            exception = e7;
                            exception.printStackTrace();
                            if (exception.getMessage() == null) {
                            }
                            tCallBack.onMessage(false, result);
                        }
                    } catch (Exception e8) {
                        exception = e8;
                        e3 = null;
                        exception.printStackTrace();
                        if (exception.getMessage() == null) {
                        }
                        tCallBack.onMessage(false, result);
                    }
                } else {
                    try {
                        throw new Exception("No utdid or device_token");
                    } catch (Exception e222) {
                        e222.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                }
            }
        }).start();
    }

    public void reset(final TCallBack tCallBack) {
        new Thread(new Runnable(this) {
            final /* synthetic */ TagManager b;

            public void run() {
                Exception e;
                Exception exception;
                if (this.b.d()) {
                    try {
                        throw new Exception("Tag API is disabled by the server.");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                } else if (this.b.c()) {
                    JSONObject e3;
                    Result reset;
                    try {
                        e3 = this.b.b();
                        try {
                            reset = TagManager.f.reset(e3, true);
                        } catch (Exception e4) {
                            Exception exception2 = e4;
                            reset = null;
                            exception = exception2;
                            exception.printStackTrace();
                            if (exception.getMessage() == null) {
                            }
                            tCallBack.onMessage(false, reset);
                        }
                        try {
                            tCallBack.onMessage(true, reset);
                        } catch (Exception e5) {
                            exception = e5;
                            exception.printStackTrace();
                            if (exception.getMessage() == null) {
                            }
                            tCallBack.onMessage(false, reset);
                        }
                    } catch (Exception e6) {
                        reset = null;
                        exception = e6;
                        e3 = reset;
                        exception.printStackTrace();
                        if (exception.getMessage() == null && exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                            Result reset2;
                            try {
                                reset2 = TagManager.f.reset(e3, false);
                                try {
                                    tCallBack.onMessage(true, reset2);
                                    return;
                                } catch (Exception e7) {
                                    e2 = e7;
                                    tCallBack.onMessage(false, reset2);
                                    e2.printStackTrace();
                                    return;
                                }
                            } catch (Exception e8) {
                                e2 = e8;
                                reset2 = reset;
                                tCallBack.onMessage(false, reset2);
                                e2.printStackTrace();
                                return;
                            }
                        }
                        tCallBack.onMessage(false, reset);
                    }
                } else {
                    try {
                        throw new Exception("No utdid or device_token");
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        tCallBack.onMessage(false, null);
                    }
                }
            }
        }).start();
    }

    public void list(final TagListCallBack tagListCallBack) {
        new Thread(new Runnable(this) {
            final /* synthetic */ TagManager b;

            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r7 = this;
                r0 = r7.b;
                r0 = r0.d();
                r1 = 0;
                r2 = 0;
                if (r0 == 0) goto L_0x001c;
            L_0x000a:
                r0 = new java.lang.Exception;	 Catch:{ Exception -> 0x0012 }
                r3 = "Tag API is disabled by the server.";	 Catch:{ Exception -> 0x0012 }
                r0.<init>(r3);	 Catch:{ Exception -> 0x0012 }
                throw r0;	 Catch:{ Exception -> 0x0012 }
            L_0x0012:
                r0 = move-exception;
                r0.printStackTrace();
                r0 = r2;
                r0.onMessage(r2, r1);
                return;
            L_0x001c:
                r0 = r7.b;
                r0 = r0.c();
                if (r0 != 0) goto L_0x0036;
            L_0x0024:
                r0 = new java.lang.Exception;	 Catch:{ Exception -> 0x002c }
                r3 = "No utdid or device_token";	 Catch:{ Exception -> 0x002c }
                r0.<init>(r3);	 Catch:{ Exception -> 0x002c }
                throw r0;	 Catch:{ Exception -> 0x002c }
            L_0x002c:
                r0 = move-exception;
                r0.printStackTrace();
                r0 = r2;
                r0.onMessage(r2, r1);
                return;
            L_0x0036:
                r0 = 1;
                r3 = r7.b;	 Catch:{ Exception -> 0x0052 }
                r3 = r3.b();	 Catch:{ Exception -> 0x0052 }
                r4 = com.umeng.message.tag.TagManager.f;	 Catch:{ Exception -> 0x004d }
                r4 = r4.list(r3, r0);	 Catch:{ Exception -> 0x004d }
                r1 = r2;	 Catch:{ Exception -> 0x004b }
                r1.onMessage(r0, r4);	 Catch:{ Exception -> 0x004b }
                return;
            L_0x004b:
                r1 = move-exception;
                goto L_0x0056;
            L_0x004d:
                r4 = move-exception;
                r6 = r4;
                r4 = r1;
                r1 = r6;
                goto L_0x0056;
            L_0x0052:
                r3 = move-exception;
                r4 = r1;
                r1 = r3;
                r3 = r4;
            L_0x0056:
                r5 = r1.getMessage();
                if (r5 == 0) goto L_0x007e;
            L_0x005c:
                r1 = r1.getMessage();
                r5 = com.umeng.message.MsgConstant.HTTPS_ERROR;
                r1 = r1.contains(r5);
                if (r1 == 0) goto L_0x0078;
            L_0x0068:
                r1 = com.umeng.message.tag.TagManager.f;	 Catch:{ Exception -> 0x007e }
                r1 = r1.list(r3, r2);	 Catch:{ Exception -> 0x007e }
                r3 = r2;	 Catch:{ Exception -> 0x0076 }
                r3.onMessage(r0, r1);	 Catch:{ Exception -> 0x0076 }
                return;
            L_0x0076:
                r4 = r1;
                goto L_0x007e;
            L_0x0078:
                r0 = r2;
                r0.onMessage(r2, r4);
                return;
            L_0x007e:
                r0 = r2;
                r0.onMessage(r2, r4);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.tag.TagManager.5.run():void");
            }
        }).start();
    }

    private JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", UTrack.getInstance(this.e).getHeader());
        jSONObject.put("utdid", UmengMessageDeviceConfig.getUtdid(this.e));
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(this.e).getDeviceToken());
        jSONObject.put(MsgConstant.KEY_TS, System.currentTimeMillis());
        return jSONObject;
    }

    private static JSONObject a(JSONObject jSONObject, String str) throws JSONException {
        String body = HttpRequest.post((CharSequence) str).acceptJson().contentType(HttpRequest.CONTENT_TYPE_JSON).send(jSONObject.toString()).body("UTF-8");
        String str2 = a;
        StringBuilder stringBuilder = new StringBuilder("postJson() url=");
        stringBuilder.append(str);
        stringBuilder.append("\n request = ");
        stringBuilder.append(jSONObject);
        stringBuilder.append("\n response = ");
        stringBuilder.append(body);
        UmLog.d(str2, stringBuilder.toString());
        return new JSONObject(body);
    }

    private boolean c() {
        if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(this.e))) {
            UmLog.e(a, "UTDID is empty");
            return false;
        } else if (!TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.e).getDeviceToken())) {
            return true;
        } else {
            UmLog.e(a, "RegistrationId is empty");
            return false;
        }
    }

    private boolean d() {
        boolean z = true;
        if (MessageSharedPrefs.getInstance(this.e).getTagSendPolicy() != 1) {
            z = false;
        }
        if (z) {
            UmLog.d(a, "tag is disabled by the server");
        }
        return z;
    }

    private Result e() {
        Result result = new Result(new JSONObject());
        result.remain = MessageSharedPrefs.getInstance(this.e).getTagRemain();
        result.status = "ok";
        StringBuilder stringBuilder = new StringBuilder("status:");
        stringBuilder.append(result.status);
        stringBuilder.append(", remain:");
        stringBuilder.append(result.remain);
        stringBuilder.append(",description:");
        stringBuilder.append(result.status);
        result.jsonString = stringBuilder.toString();
        return result;
    }
}
