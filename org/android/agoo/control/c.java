package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;

/* compiled from: Taobao */
class c implements Runnable {
    final /* synthetic */ AgooFactory a;

    c(AgooFactory agooFactory) {
        this.a = agooFactory;
    }

    public void run() {
        ArrayList b = AgooFactory.access$100(this.a).b();
        if (b != null && b.size() > 0) {
            ALog.e("AgooFactory", "reportCacheMsg", new Object[]{"size", Integer.valueOf(b.size())});
            Iterator it = b.iterator();
            while (it.hasNext()) {
                MsgDO msgDO = (MsgDO) it.next();
                if (msgDO != null) {
                    msgDO.isFromCache = true;
                    this.a.notifyManager.report(msgDO, null);
                }
            }
        }
    }
}
