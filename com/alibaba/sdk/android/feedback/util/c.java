package com.alibaba.sdk.android.feedback.util;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.IOException;

public class c {
    private File a;
    private MediaRecorder b;
    private boolean c = false;
    private long d = 0;
    private Handler e;
    private final IWxCallback f;
    private final long g;
    private final long h;
    private Runnable i = new e(this);

    public c(IWxCallback iWxCallback, long j, long j2) {
        this.f = iWxCallback;
        this.g = j * 1000;
        this.h = j2 * 1000;
    }

    public static File a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            StringBuilder stringBuilder = new StringBuilder("record_");
            stringBuilder.append(System.currentTimeMillis());
            return File.createTempFile(stringBuilder.toString(), "", file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void b(String str) {
        f();
        if (this.f != null) {
            this.f.onError(0, str);
        }
    }

    private void e() {
        this.e.removeCallbacks(this.i);
        if (this.c) {
            String str;
            if (this.b != null) {
                try {
                    this.b.stop();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
                this.b.release();
                this.b = null;
            }
            this.c = false;
            if (System.currentTimeMillis() - this.d < this.h) {
                n.a("AudioRecordingFailed", "RecordTimeShort");
                str = "RecordTimeShort";
            } else if (this.a == null) {
                n.a("AudioRecordingFailed", "createAudioFile fail");
                str = "createAudioFile fail";
            } else {
                if (this.f != null) {
                    n.a("AudioRecordingSuccess", null);
                    this.f.onSuccess(this.a.getAbsolutePath(), Integer.valueOf((int) (r6 / 1000)));
                }
                d();
            }
            b(str);
            d();
        }
    }

    private void f() {
        if (this.a != null) {
            try {
                this.a.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void g() {
        f();
        if (this.f != null) {
            this.f.onError(0, "recordExceptionCaught");
        }
    }

    public void a() {
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("ChattingRecorder");
            handlerThread.start();
            this.e = new Handler(handlerThread.getLooper());
        }
        this.e.post(new d(this));
        this.e.postDelayed(this.i, this.g);
    }

    public void b() {
        if (this.e != null) {
            this.e.post(new f(this));
        }
    }

    public void c() {
        if (this.c) {
            this.e.post(new g(this));
        }
    }

    public void d() {
        if (this.e != null) {
            this.e.post(new h(this));
        }
    }
}
