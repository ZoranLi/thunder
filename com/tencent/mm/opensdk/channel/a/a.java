package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.a.d;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

public final class a {

    public static class a {
        public String W;
        public String X;
        public long Y;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, a aVar) {
        if (context == null || d.h(aVar.X)) {
            return false;
        }
        String str = null;
        if (!d.h(aVar.W)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aVar.W);
            stringBuilder.append(".permission.MM_MESSAGE");
            str = stringBuilder.toString();
        }
        Intent intent = new Intent(aVar.X);
        if (aVar.bundle != null) {
            intent.putExtras(aVar.bundle);
        }
        String packageName = context.getPackageName();
        intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, aVar.content);
        intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.Y);
        intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(aVar.content, Build.SDK_INT, packageName));
        context.sendBroadcast(intent, str);
        StringBuilder stringBuilder2 = new StringBuilder("send mm message, intent=");
        stringBuilder2.append(intent);
        stringBuilder2.append(", perm=");
        stringBuilder2.append(str);
        return true;
    }
}
