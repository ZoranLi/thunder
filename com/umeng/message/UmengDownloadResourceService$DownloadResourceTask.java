package com.umeng.message;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;

public class UmengDownloadResourceService$DownloadResourceTask extends AsyncTask<Void, Void, Boolean> {
    UMessage a;
    ArrayList<String> b = new ArrayList();
    int c;
    final /* synthetic */ UmengDownloadResourceService d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    public UmengDownloadResourceService$DownloadResourceTask(com.umeng.message.UmengDownloadResourceService r2, com.umeng.message.entity.UMessage r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.d = r2;
        r1.<init>();
        r1.a = r3;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1.b = r2;
        r2 = "notificationpullapp";
        r0 = r3.display_type;
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x002a;
    L_0x0018:
        r2 = r3.custom;
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x002a }
        r0.<init>(r2);	 Catch:{ Exception -> 0x002a }
        r2 = "img";	 Catch:{ Exception -> 0x002a }
        r2 = r0.optString(r2);	 Catch:{ Exception -> 0x002a }
        r0 = r1.b;	 Catch:{ Exception -> 0x002a }
        r0.add(r2);	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        r2 = r3.isLargeIconFromInternet();
        if (r2 == 0) goto L_0x0037;
    L_0x0030:
        r2 = r1.b;
        r0 = r3.img;
        r2.add(r0);
    L_0x0037:
        r2 = r3.isSoundFromInternet();
        if (r2 == 0) goto L_0x0044;
    L_0x003d:
        r2 = r1.b;
        r3 = r3.sound;
        r2.add(r3);
    L_0x0044:
        r1.c = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengDownloadResourceService$DownloadResourceTask.<init>(com.umeng.message.UmengDownloadResourceService, com.umeng.message.entity.UMessage, int):void");
    }

    protected Boolean a(Void... voidArr) {
        voidArr = this.b.iterator();
        boolean z = true;
        while (voidArr.hasNext()) {
            z &= download((String) voidArr.next());
        }
        return Boolean.valueOf(z);
    }

    protected void a(Boolean bool) {
        super.onPostExecute(bool);
        this.d.c.remove(this.a.msg_id);
        if (bool.booleanValue() == null) {
            if (this.c > null) {
                if (this.d.c.size() == null) {
                    this.d.stopSelf();
                }
                return;
            }
        }
        MessageSharedPrefs.getInstance(this.d.b).setMessageResourceDownloaded(this.a.msg_id);
        bool = this.a.getRaw().toString();
        Intent intent = new Intent(this.d.b, UmengDownloadResourceService.class);
        intent.putExtra(AgooConstants.MESSAGE_BODY, bool);
        intent.putExtra(AgooConstants.MESSAGE_ID, this.a.message_id);
        intent.putExtra(AgooConstants.MESSAGE_TASK_ID, this.a.task_id);
        intent.putExtra("OPERATIOIN", 1);
        intent.putExtra("RETRY_TIME", this.c);
        this.d.startService(intent);
    }

    public boolean download(String str) {
        Closeable fileOutputStream;
        Exception e;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Closeable closeable = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.hashCode());
            String stringBuilder2 = stringBuilder.toString();
            String messageResourceFolder = UmengDownloadResourceService.getMessageResourceFolder(this.d.b, this.a);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append(".tmp");
            File file = new File(messageResourceFolder, stringBuilder3.toString());
            File file2 = new File(messageResourceFolder, stringBuilder2);
            if (file2.exists()) {
                this.d.close(null);
                this.d.close(null);
                return true;
            }
            File file3 = new File(messageResourceFolder);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            str = new URL(new URI(str).toASCIIString()).openStream();
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                closeable = str;
                str = e;
                try {
                    str.printStackTrace();
                    this.d.close(closeable);
                    this.d.close(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    str = th2;
                    this.d.close(closeable);
                    this.d.close(fileOutputStream);
                    throw str;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                closeable = str;
                str = th;
                this.d.close(closeable);
                this.d.close(fileOutputStream);
                throw str;
            }
            try {
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = str.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        file.renameTo(file2);
                        this.d.close(str);
                        this.d.close(fileOutputStream);
                        return true;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                closeable = str;
                str = e;
                str.printStackTrace();
                this.d.close(closeable);
                this.d.close(fileOutputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                closeable = str;
                str = th;
                this.d.close(closeable);
                this.d.close(fileOutputStream);
                throw str;
            }
        } catch (Exception e4) {
            str = e4;
            fileOutputStream = null;
            str.printStackTrace();
            this.d.close(closeable);
            this.d.close(fileOutputStream);
            return false;
        } catch (Throwable th5) {
            str = th5;
            fileOutputStream = null;
            this.d.close(closeable);
            this.d.close(fileOutputStream);
            throw str;
        }
    }
}
