package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import org.json.JSONObject;

public class NativeExpressADView extends FrameLayout {
    private NEADVI a;
    private boolean b = false;
    private volatile int c = 0;

    public NativeExpressADView(NEADI neadi, Context context, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap) {
        final Context context2 = context;
        super(context2);
        final String str3 = str;
        final NEADI neadi2 = neadi;
        final ADSize aDSize2 = aDSize;
        final String str4 = str2;
        final JSONObject jSONObject2 = jSONObject;
        final HashMap<String, JSONObject> hashMap2 = hashMap;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this) {
            final /* synthetic */ NativeExpressADView h;

            public void run() {
                if (GDTADManager.getInstance().initWith(context2, str3)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                            private /* synthetic */ AnonymousClass1 b;

                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        this.b.h.a = pOFactory.getNativeExpressADView(neadi2, context2, this.b.h, aDSize2, str3, str4, jSONObject2, hashMap2);
                                        this.b.h.b = true;
                                        if (this.b.h.c > 0) {
                                            this.b.h.render();
                                        }
                                    }
                                } catch (Throwable th) {
                                    this.b.h.b = true;
                                }
                                this.b.h.b = true;
                            }
                        });
                        return;
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init Native Express AD View plugin", th);
                        return;
                    }
                }
                GDTLogger.e("Fail to init ADManager");
            }
        });
    }

    public void destroy() {
        if (this.a != null) {
            this.a.destroy();
        }
    }

    public void render() {
        if (!this.b) {
            this.c++;
        } else if (this.a != null) {
            this.a.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        if (this.a != null) {
            this.a.setAdSize(aDSize);
        }
    }
}
