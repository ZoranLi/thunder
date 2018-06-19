package com.xunlei.downloadprovider.player.xmp;

import android.content.Context;
import android.provider.Settings.System;
import android.view.OrientationEventListener;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.xunlei.downloadprovider.app.BaseActivity;

/* compiled from: PlayerFullScreenHelper */
final class h extends OrientationEventListener {
    final /* synthetic */ g a;

    h(g gVar, Context context) {
        this.a = gVar;
        super(context);
    }

    public final void onOrientationChanged(int i) {
        if (this.a.a != null) {
            if (this.a.a.e != null) {
                int i2 = 0;
                boolean z = true;
                if (System.getInt(this.a.a.e.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                    BaseActivity baseActivity = this.a.a.e;
                    if (baseActivity != null) {
                        if (baseActivity.b) {
                            if (i != -1) {
                                if ((i < 0 || i > 30) && i < ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE) {
                                    if ((i >= 60 && i <= 120) || (i >= 240 && i <= 300)) {
                                        if (!this.a.j) {
                                            if (i < 60 || i > 120) {
                                                z = false;
                                            }
                                            if (this.a.k != 0) {
                                                if (z) {
                                                    i2 = 8;
                                                }
                                                baseActivity.setRequestedOrientation(i2);
                                                this.a.c = z;
                                            } else {
                                                this.a.b(z);
                                            }
                                        } else if (this.a.h == 1) {
                                            this.a.j = false;
                                        }
                                        this.a.h = 2;
                                    }
                                    return;
                                }
                                if (this.a.i != 0) {
                                    if (this.a.h == 2) {
                                        this.a.i = false;
                                    }
                                } else if (this.a.b != 0) {
                                    if (this.a.k != 0) {
                                        baseActivity.setRequestedOrientation(1);
                                    } else {
                                        this.a.a();
                                    }
                                }
                                this.a.h = 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
