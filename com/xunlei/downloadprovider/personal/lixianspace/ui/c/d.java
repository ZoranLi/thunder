package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.personal.lixianspace.expansion.a.b.a;
import com.xunlei.downloadprovider.personal.lixianspace.expansion.columnview.ColumnChartView;

/* compiled from: LXSpaceExpansionDlg */
final class d implements a {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void a(boolean z) {
        if (z) {
            c.a(this.a);
            z = com.xunlei.downloadprovider.personal.lixianspace.expansion.a.a.a(j.a().d(), j.a().a.m(), j.a().e());
            if (z.size() > 0 && this.a.b != null) {
                ColumnChartView b = this.a.b;
                if (z.size() > 0) {
                    b.a.a = 500.0f;
                    b.b.clear();
                    b.b.addAll(z);
                    b.invalidate();
                }
            }
        }
    }
}
