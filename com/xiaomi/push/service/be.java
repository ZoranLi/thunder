package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.e;
import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.thrift.a;

public class be {
    private static String a;
    private static AtomicLong b = new AtomicLong(0);

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.a(5));
        stringBuilder.append("-");
        a = stringBuilder.toString();
    }

    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(b.incrementAndGet());
        return stringBuilder.toString();
    }

    public static ArrayList<ai> a(List<f> list, String str, String str2, int i) {
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else if (list.size() == 0) {
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        } else {
            ArrayList<ai> arrayList = new ArrayList();
            a eVar = new e();
            int i2 = 0;
            int i3 = i2;
            while (i2 < list.size()) {
                f fVar = (f) list.get(i2);
                if (fVar != null) {
                    int length = au.a(fVar).length;
                    if (length > i) {
                        StringBuilder stringBuilder = new StringBuilder("TinyData is too big, ignore upload request.");
                        stringBuilder.append(fVar.d());
                        b.d(stringBuilder.toString());
                    } else {
                        if (i3 + length > i) {
                            ai aiVar = new ai(a(), false);
                            aiVar.d(str);
                            aiVar.b(str2);
                            aiVar.c(r.UploadTinyData.W);
                            aiVar.a(com.xiaomi.channel.commonutils.file.a.a(au.a(eVar)));
                            arrayList.add(aiVar);
                            eVar = new e();
                            i3 = 0;
                        }
                        eVar.a(fVar);
                        i3 += length;
                    }
                }
                i2++;
            }
            if (eVar.a() != 0) {
                ai aiVar2 = new ai(a(), false);
                aiVar2.d(str);
                aiVar2.b(str2);
                aiVar2.c(r.UploadTinyData.W);
                aiVar2.a(com.xiaomi.channel.commonutils.file.a.a(au.a(eVar)));
                arrayList.add(aiVar2);
            }
            return arrayList;
        }
        b.d(str3);
        return null;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        f fVar = new f();
        fVar.d(str);
        fVar.c(str2);
        fVar.a(j);
        fVar.b(str3);
        fVar.a("push_sdk_channel");
        fVar.g(context.getPackageName());
        fVar.e(context.getPackageName());
        fVar.c(true);
        fVar.b(System.currentTimeMillis());
        fVar.f(a());
        bf.a(context, fVar);
    }

    public static boolean a(f fVar, boolean z) {
        String str;
        if (fVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(fVar.a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(fVar.g)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(fVar.c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!d.d(fVar.g)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (!d.d(fVar.c)) {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (fVar.b == null || fVar.b.length() <= 10240) {
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder("item.data is too large(");
            stringBuilder.append(fVar.b.length());
            stringBuilder.append("), max size for data is 10240 , verfiy ClientUploadDataItem failed.");
            str = stringBuilder.toString();
        }
        b.a(str);
        return true;
    }
}
