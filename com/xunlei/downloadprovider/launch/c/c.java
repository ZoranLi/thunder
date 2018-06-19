package com.xunlei.downloadprovider.launch.c;

import android.view.View;
import com.umeng.message.MsgConstant;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.launch.c.a.a.a;
import java.util.ArrayList;

/* compiled from: LaunchPermissionsManager */
final class c implements a {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ a b;

    c(a aVar, ArrayList arrayList) {
        this.b = aVar;
        this.a = arrayList;
    }

    public final void a(com.xunlei.downloadprovider.launch.c.a.a aVar, View view) {
        int i = 0;
        aVar.setCancelable(false);
        aVar.a();
        aVar = view.findViewById(R.id.dlg_item_1);
        if (aVar != null) {
            aVar.setVisibility(this.a.contains(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) ? 0 : 8);
        }
        aVar = view.findViewById(R.id.dlg_item_2);
        if (aVar != null) {
            if (this.a.contains(MsgConstant.PERMISSION_READ_PHONE_STATE) == null) {
                i = 8;
            }
            aVar.setVisibility(i);
        }
    }
}
