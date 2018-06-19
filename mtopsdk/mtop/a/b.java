package mtopsdk.mtop.a;

import android.content.Context;
import com.taobao.tao.remotebusiness.listener.c;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ c b = null;
    final /* synthetic */ String c;

    b(Context context, String str) {
        this.a = context;
        this.c = str;
    }

    public final void run() {
        if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
            j.b("[init]MtopSDK init Called");
        }
        a.a(this.a, this.b, this.c);
    }
}
