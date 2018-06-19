package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: SubtitleController */
final class bb extends BroadcastReceiver {
    final /* synthetic */ ba a;

    bb(ba baVar) {
        this.a = baVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            context = intent.getAction();
            intent = -1;
            int hashCode = context.hashCode();
            if (hashCode != 878007972) {
                if (hashCode == 1805719813) {
                    if (context.equals("ACTION_OnPrepared") != null) {
                        intent = true;
                    }
                }
            } else if (context.equals("ACTION_OnCompletion") != null) {
                intent = null;
            }
            switch (intent) {
                case null:
                    this.a.b.a(this.a.m(), this.a.t(), this.a.s());
                    return;
                case 1:
                    this.a.t = true;
                    if (this.a.f != null) {
                        if (this.a.A() == null) {
                            ba.m;
                            break;
                        }
                        ba.m;
                        context = new StringBuilder("ACTION_OnPrepared， startFetchSubTitleManifestAsync,cid : ");
                        context.append(this.a.r());
                        context.append(", name : ");
                        context.append(this.a.t());
                        if ((TextUtils.isEmpty(this.a.r()) == null || TextUtils.isEmpty(this.a.t()) == null) && this.a.u == null) {
                            this.a.b.a(this.a.r(), this.a.t());
                            this.a.u = true;
                            return;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
