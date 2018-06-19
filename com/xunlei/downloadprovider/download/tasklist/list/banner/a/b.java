package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: CountTimer */
final class b implements Callback {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final boolean handleMessage(Message message) {
        String str = (String) message.obj;
        Integer num = (Integer) this.a.d.get(str);
        if (num != null) {
            if (num.intValue() == 0) {
                int hashCode = str.hashCode();
                a.a(this.a, hashCode, str);
                this.a.d.remove(str);
                this.a.a.remove(hashCode);
                Runnable runnable = (Runnable) this.a.b.get(hashCode);
                if (runnable != null) {
                    runnable.run();
                    this.a.b.remove(hashCode);
                }
            } else {
                this.a.d.put(str, Integer.valueOf(num.intValue() - 1));
                a.b(this.a, str.hashCode(), str);
                this.a.c.sendMessageDelayed(Message.obtain(this.a.c, 0, str), 1000);
            }
        }
        return true;
    }
}
