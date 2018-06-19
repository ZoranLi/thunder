package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.a.d;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public String targetClassName;
        public String targetPkgName;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("targetPkgName:");
            stringBuilder.append(this.targetPkgName);
            stringBuilder.append(", targetClassName:");
            stringBuilder.append(this.targetClassName);
            stringBuilder.append(", content:");
            stringBuilder.append(this.content);
            stringBuilder.append(", flags:");
            stringBuilder.append(this.flags);
            stringBuilder.append(", bundle:");
            stringBuilder.append(this.bundle);
            return stringBuilder.toString();
        }
    }

    public static boolean send(Context context, Args args) {
        if (context == null || args == null) {
            return false;
        }
        if (d.h(args.targetPkgName)) {
            new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ").append(args.targetPkgName);
            return false;
        }
        StringBuilder stringBuilder;
        if (d.h(args.targetClassName)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(args.targetPkgName);
            stringBuilder.append(DEFAULT_ENTRY_CLASS_NAME);
            args.targetClassName = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder("send, targetPkgName = ");
        stringBuilder.append(args.targetPkgName);
        stringBuilder.append(", targetClassName = ");
        stringBuilder.append(args.targetClassName);
        Intent intent = new Intent();
        intent.setClassName(args.targetPkgName, args.targetClassName);
        if (args.bundle != null) {
            intent.putExtras(args.bundle);
        }
        String packageName = context.getPackageName();
        intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, args.content);
        intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(args.content, Build.SDK_INT, packageName));
        if (args.flags == -1) {
            intent.addFlags(268435456).addFlags(134217728);
        } else {
            intent.setFlags(args.flags);
        }
        try {
            context.startActivity(intent);
            new StringBuilder("send mm message, intent=").append(intent);
            return true;
        } catch (Exception e) {
            new StringBuilder("send fail, ex = ").append(e.getMessage());
            return false;
        }
    }
}
