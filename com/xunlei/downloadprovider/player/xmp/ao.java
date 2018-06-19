package com.xunlei.downloadprovider.player.xmp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.xunlei.downloadprovider.broadcast.b;

/* compiled from: XmpPlayerManager */
final class ao extends b {
    final /* synthetic */ ak a;

    ao(ak akVar) {
        this.a = akVar;
    }

    public final void a(Context context, Intent intent) {
        if (this.a.g == null) {
            ThunderXmpPlayer thunderXmpPlayer;
            StringBuilder stringBuilder;
            Context context2;
            String str;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            intent = null;
            if (connectivityManager != null) {
                context = connectivityManager.getActiveNetworkInfo();
                if (context != null) {
                    if ((context.getType() != 1 ? null : 1) != null) {
                        context = 1;
                        if (context != null) {
                            while (intent < this.a.b.size()) {
                                thunderXmpPlayer = (ThunderXmpPlayer) this.a.b.valueAt(intent);
                                if (thunderXmpPlayer != null) {
                                    stringBuilder = new StringBuilder("onNetworkChange--");
                                    stringBuilder.append(thunderXmpPlayer);
                                    stringBuilder.append("|isNetworkAvailable=");
                                    stringBuilder.append(com.xunlei.xllib.android.b.a(thunderXmpPlayer.d));
                                    context2 = thunderXmpPlayer.e;
                                    if (context2 == null) {
                                        if (!context2.b) {
                                            if (thunderXmpPlayer.r != null && com.xunlei.xllib.android.b.d(thunderXmpPlayer.d)) {
                                                str = "";
                                                if (!(thunderXmpPlayer.i == null || thunderXmpPlayer.i.b == null)) {
                                                    str = thunderXmpPlayer.i.b.d;
                                                }
                                                if (thunderXmpPlayer.a.a(str, context2, new s(thunderXmpPlayer))) {
                                                    if (thunderXmpPlayer.f.e) {
                                                        thunderXmpPlayer.b();
                                                    } else {
                                                        thunderXmpPlayer.a(true, true);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                intent++;
                            }
                        }
                    }
                }
            }
            context = null;
            if (context != null) {
                while (intent < this.a.b.size()) {
                    thunderXmpPlayer = (ThunderXmpPlayer) this.a.b.valueAt(intent);
                    if (thunderXmpPlayer != null) {
                        stringBuilder = new StringBuilder("onNetworkChange--");
                        stringBuilder.append(thunderXmpPlayer);
                        stringBuilder.append("|isNetworkAvailable=");
                        stringBuilder.append(com.xunlei.xllib.android.b.a(thunderXmpPlayer.d));
                        context2 = thunderXmpPlayer.e;
                        if (context2 == null) {
                            if (!context2.b) {
                                str = "";
                                str = thunderXmpPlayer.i.b.d;
                                if (thunderXmpPlayer.a.a(str, context2, new s(thunderXmpPlayer))) {
                                    if (thunderXmpPlayer.f.e) {
                                        thunderXmpPlayer.b();
                                    } else {
                                        thunderXmpPlayer.a(true, true);
                                    }
                                }
                            }
                        }
                    }
                    intent++;
                }
            }
        }
    }
}
