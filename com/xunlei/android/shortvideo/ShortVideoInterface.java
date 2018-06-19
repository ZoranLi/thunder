package com.xunlei.android.shortvideo;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.xunlei.android.shortvideo.ShortVideoTask.STATUS;
import com.xunlei.downloadlib.android.XLLog;

public class ShortVideoInterface {
    private static ShortVideoInterface b = null;
    private static long e = -1;
    public Handler a;
    private HandlerThread c;
    private com.xunlei.downloadlib.proguard.b d;

    public enum PlayerEvent {
        PLAYER_UNKNOWN,
        CREATE_START,
        CREATE_FINISH,
        HANDLER_PENDING,
        PLAYER_CALL_START,
        PLAYER_IDLE,
        PLAYER_PREPARING,
        PLAYER_BUFFERING,
        PLAYER_READY,
        PLAYER_ENDED
    }

    public static final class a {
        static final /* synthetic */ boolean f = true;
        public String a;
        public final String b;
        public final String c;
        public final int d;
        public int e;

        static {
            Class cls = ShortVideoInterface.class;
        }

        public a(String str, String str2, String str3, int i, int i2) {
            if (!f && TextUtils.isEmpty(str)) {
                throw new AssertionError("CreateTaskParam url is Empty");
            } else if (f || !TextUtils.isEmpty(str2)) {
                if (str3 == null) {
                    str3 = "";
                }
                this.a = str;
                this.b = str2;
                this.d = i;
                this.e = i2;
                this.c = str3;
            } else {
                throw new AssertionError("CreateTaskParam gcid is Empty");
            }
        }

        public a(String str, String str2, String str3, int i) {
            this(str, str2, str3, i, -1);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("mTitle=[");
            stringBuilder.append(this.c);
            stringBuilder.append("] mCacheDuration=[");
            stringBuilder.append(this.e);
            stringBuilder.append("] mGcid=[");
            stringBuilder.append(this.b);
            stringBuilder.append("] mVideoDuration=[");
            stringBuilder.append(this.d);
            stringBuilder.append("] mUrl=[");
            stringBuilder.append(this.a);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface b {
        void a(String str, STATUS status, int i);
    }

    public static synchronized ShortVideoInterface a(Context context, String str) {
        synchronized (ShortVideoInterface.class) {
            if (b == null) {
                b = new ShortVideoInterface(context.getApplicationContext(), str);
                StringBuilder stringBuilder = new StringBuilder("Instance context=");
                stringBuilder.append(context.toString());
                stringBuilder.append(", maxDiskSpaceSize=157286400, cachePath=");
                stringBuilder.append(str);
                stringBuilder.append(", downloadLibPath=");
                stringBuilder.append(null);
                XLLog.d("ShortVideoInterface", stringBuilder.toString());
            }
            context = b;
        }
        return context;
    }

    public static synchronized ShortVideoInterface a() {
        ShortVideoInterface shortVideoInterface;
        synchronized (ShortVideoInterface.class) {
            shortVideoInterface = b;
        }
        return shortVideoInterface;
    }

    public final void a(PlayerEvent playerEvent) {
        this.a.post(new b(this, playerEvent, System.currentTimeMillis()));
    }

    private ShortVideoInterface(Context context, String str) {
        this.c = null;
        this.a = null;
        this.d = null;
        this.c = new HandlerThread("ShortVideoInterface");
        this.c.start();
        this.a = new Handler(this.c.getLooper());
        this.a.post(new c(this, context, str));
    }
}
