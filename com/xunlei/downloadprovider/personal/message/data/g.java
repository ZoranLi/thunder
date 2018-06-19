package com.xunlei.downloadprovider.personal.message.data;

import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: MessageNetWork */
public class g extends a {
    private static final String b = "g";
    private static final long c = LoginHelper.a().g.c();
    public ArrayList<MessageInfo> a;

    public final void a(long j, String str, boolean z, boolean z2, MessageType messageType, f fVar) {
        String str2 = "http://api-shoulei-ssl.xunlei.com/msgcenter/query?";
        switch (p.a[messageType.ordinal()]) {
            case 1:
                str2 = "http://api-shoulei-ssl.xunlei.com/msgcenter/query_star_v4?";
                break;
            case 2:
                str2 = "http://api-shoulei-ssl.xunlei.com/msgcenter/query_comment_v4?";
                break;
            case 3:
                str2 = "http://api-shoulei-ssl.xunlei.com/msgcenter/query_follow_v2?";
                break;
            default:
                break;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("userid=");
        stringBuilder.append(j);
        stringBuilder.append("&cursor=");
        stringBuilder.append(str);
        stringBuilder.append("&size=20&reset_read_status=0");
        a(stringBuilder.toString(), new h(this, fVar, z, messageType, z2), new i(this, z, messageType, fVar));
    }

    public final void a(long j, long j2, MessageType messageType, f fVar) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/msgcenter/delmsg?msgid=");
        stringBuilder.append(j);
        stringBuilder.append("&userid=");
        stringBuilder.append(j2);
        a(stringBuilder.toString(), new l(this, j, messageType, fVar), new m(this, fVar, j, messageType));
    }

    public final void a(long j, ad adVar) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/msgcenter/unread_info_v4?userid=");
        stringBuilder.append(j);
        a(stringBuilder.toString(), new n(this, adVar), new o(this));
    }

    private void a(com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.a;
        if (r0 == 0) goto L_0x006b;
    L_0x0004:
        r0 = r5.a;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x006b;
    L_0x000c:
        r0 = new java.io.File;
        r1 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r1 = r1.getCacheDir();
        r2 = new java.lang.StringBuilder;
        r3 = "messages_data_";
        r2.<init>(r3);
        r3 = c;
        r2.append(r3);
        r3 = "_";
        r2.append(r3);
        r6 = r6.name();
        r2.append(r6);
        r6 = r2.toString();
        r0.<init>(r1, r6);
        r6 = r0.exists();
        if (r6 == 0) goto L_0x003e;
    L_0x003b:
        r0.delete();
    L_0x003e:
        r6 = 0;
        r0.createNewFile();	 Catch:{ Exception -> 0x0065, all -> 0x005e }
        r1 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x0065, all -> 0x005e }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0065, all -> 0x005e }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0065, all -> 0x005e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0065, all -> 0x005e }
        r6 = r5.a;	 Catch:{ Exception -> 0x005c, all -> 0x0058 }
        r1.writeObject(r6);	 Catch:{ Exception -> 0x005c, all -> 0x0058 }
        r1.flush();	 Catch:{ Exception -> 0x005c, all -> 0x0058 }
        r1.close();	 Catch:{ Exception -> 0x0057 }
    L_0x0057:
        return;
    L_0x0058:
        r6 = move-exception;
        r0 = r6;
        r6 = r1;
        goto L_0x005f;
    L_0x005c:
        r6 = r1;
        goto L_0x0065;
    L_0x005e:
        r0 = move-exception;
    L_0x005f:
        if (r6 == 0) goto L_0x0064;
    L_0x0061:
        r6.close();	 Catch:{ Exception -> 0x0064 }
    L_0x0064:
        throw r0;
    L_0x0065:
        if (r6 == 0) goto L_0x006b;
    L_0x0067:
        r6.close();	 Catch:{ Exception -> 0x006a }
    L_0x006a:
        return;
    L_0x006b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.message.data.g.a(com.xunlei.downloadprovider.personal.message.MessageActivty$MessageType):void");
    }

    static /* synthetic */ void b(com.xunlei.downloadprovider.personal.message.data.g r5, com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.File;
        r1 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r1 = r1.getCacheDir();
        r2 = new java.lang.StringBuilder;
        r3 = "messages_data_";
        r2.<init>(r3);
        r3 = c;
        r2.append(r3);
        r3 = "_";
        r2.append(r3);
        r6 = r6.name();
        r2.append(r6);
        r6 = r2.toString();
        r0.<init>(r1, r6);
        r6 = r0.exists();
        if (r6 != 0) goto L_0x003b;
    L_0x002f:
        r6 = r5.a;
        if (r6 != 0) goto L_0x003a;
    L_0x0033:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r5.a = r6;
    L_0x003a:
        return;
    L_0x003b:
        r6 = 0;
        r1 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r6 = r1.readObject();	 Catch:{ Exception -> 0x005f, all -> 0x005d }
        r6 = (java.util.ArrayList) r6;	 Catch:{ Exception -> 0x005f, all -> 0x005d }
        r5.a = r6;	 Catch:{ Exception -> 0x005f, all -> 0x005d }
        r6 = r5.a;	 Catch:{ Exception -> 0x005f, all -> 0x005d }
        if (r6 != 0) goto L_0x0059;	 Catch:{ Exception -> 0x005f, all -> 0x005d }
    L_0x0052:
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x005f, all -> 0x005d }
        r6.<init>();	 Catch:{ Exception -> 0x005f, all -> 0x005d }
        r5.a = r6;	 Catch:{ Exception -> 0x005f, all -> 0x005d }
    L_0x0059:
        r1.close();	 Catch:{ Exception -> 0x005c }
    L_0x005c:
        return;
    L_0x005d:
        r5 = move-exception;
        goto L_0x0063;
    L_0x005f:
        r6 = r1;
        goto L_0x0069;
    L_0x0061:
        r5 = move-exception;
        r1 = r6;
    L_0x0063:
        if (r1 == 0) goto L_0x0068;
    L_0x0065:
        r1.close();	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        throw r5;
    L_0x0069:
        if (r6 == 0) goto L_0x006f;
    L_0x006b:
        r6.close();	 Catch:{ Exception -> 0x006e }
    L_0x006e:
        return;
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.message.data.g.b(com.xunlei.downloadprovider.personal.message.data.g, com.xunlei.downloadprovider.personal.message.MessageActivty$MessageType):void");
    }

    static /* synthetic */ void a(g gVar, JSONObject jSONObject, long j, MessageType messageType, f fVar) {
        if (jSONObject != null) {
            jSONObject = jSONObject.optString("result");
            if (!(jSONObject == null || jSONObject.equals(ITagManager.SUCCESS) == null)) {
                if (fVar != null) {
                    fVar.a(j, messageType, true);
                }
                if (gVar.a != null) {
                    if (gVar.a.isEmpty() == null) {
                        f<MessageInfo> arrayList = new ArrayList();
                        Iterator it = gVar.a.iterator();
                        while (it.hasNext()) {
                            MessageInfo messageInfo = (MessageInfo) it.next();
                            if (messageInfo.getType() == 1 && messageInfo.getMsgid() == j) {
                                arrayList.add(messageInfo);
                            }
                        }
                        if (arrayList.size() > null) {
                            for (MessageInfo remove : arrayList) {
                                gVar.a.remove(remove);
                            }
                            gVar.a(messageType);
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (fVar != null) {
            fVar.a(j, messageType, (boolean) null);
        }
    }

    static /* synthetic */ void a(JSONObject jSONObject, ad adVar) {
        s sVar = new s();
        if (jSONObject != null) {
            String optString = jSONObject.optString("result");
            if (optString != null && optString.equals(ITagManager.SUCCESS)) {
                int optInt = jSONObject.optInt("comment", 0);
                int optInt2 = jSONObject.optInt("follow", 0);
                int optInt3 = jSONObject.optInt("star", 0);
                int optInt4 = jSONObject.optInt("visit", 0);
                jSONObject = jSONObject.optInt("chat", 0);
                sVar.a = optInt;
                sVar.b = optInt2;
                sVar.c = optInt3;
                sVar.d = optInt4;
                sVar.a(jSONObject);
            }
        }
        if (adVar != null) {
            adVar.a(sVar);
        }
    }
}
