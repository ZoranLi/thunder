package com.qihoo360.replugin.ext.parser.a;

import com.qihoo360.replugin.ext.parser.a.c.a;
import com.qihoo360.replugin.ext.parser.b.a.f;
import com.qihoo360.replugin.ext.parser.b.a.g;
import com.qihoo360.replugin.ext.parser.b.a.i;
import com.qihoo360.replugin.ext.parser.c.a.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: XmlTranslator */
public final class e implements d {
    public StringBuilder a = new StringBuilder();
    private int b = 0;
    private c c;
    private boolean d;

    public e() {
        this.a.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        this.c = new c();
    }

    public final void a(i iVar) {
        if (this.d) {
            this.a.append(">\n");
        }
        int i = this.b;
        this.b = i + 1;
        a(i);
        this.a.append('<');
        if (iVar.a != null) {
            String a = this.c.a(iVar.a);
            if (a != null) {
                StringBuilder stringBuilder = this.a;
                stringBuilder.append(a);
                stringBuilder.append(Constants.COLON_SEPARATOR);
            } else {
                StringBuilder stringBuilder2 = this.a;
                stringBuilder2.append(iVar.a);
                stringBuilder2.append(Constants.COLON_SEPARATOR);
            }
        }
        this.a.append(iVar.b);
        c cVar = this.c;
        List emptyList;
        if (cVar.b.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = new ArrayList();
            emptyList.addAll(cVar.b);
            cVar.b.clear();
        }
        if (!r1.isEmpty()) {
            for (a aVar : r1) {
                StringBuilder stringBuilder3 = this.a;
                stringBuilder3.append(" xmlns:");
                stringBuilder3.append(aVar.a);
                stringBuilder3.append("=\"");
                stringBuilder3.append(aVar.b);
                stringBuilder3.append("\"");
            }
        }
        this.d = true;
        for (com.qihoo360.replugin.ext.parser.b.a.a aVar2 : iVar.c.a) {
            StringBuilder stringBuilder4;
            this.a.append(" ");
            String a2 = this.c.a(aVar2.a);
            if (a2 == null) {
                a2 = aVar2.a;
            }
            if (!(a2 == null || a2.isEmpty())) {
                stringBuilder4 = this.a;
                stringBuilder4.append(a2);
                stringBuilder4.append(':');
            }
            a2 = h.a(aVar2.d);
            stringBuilder4 = this.a;
            stringBuilder4.append(aVar2.b);
            stringBuilder4.append('=');
            stringBuilder4.append('\"');
            stringBuilder4.append(a2);
            stringBuilder4.append('\"');
        }
    }

    public final void a(g gVar) {
        this.b--;
        if (this.d) {
            this.a.append(" />\n");
        } else {
            a(this.b);
            this.a.append("</");
            if (gVar.a != null) {
                StringBuilder stringBuilder = this.a;
                stringBuilder.append(gVar.a);
                stringBuilder.append(Constants.COLON_SEPARATOR);
            }
            this.a.append(gVar.b);
            this.a.append(">\n");
        }
        this.d = null;
    }

    public final void a(f fVar) {
        c cVar = this.c;
        a aVar = new a(fVar.a, fVar.b);
        cVar.a.add(aVar);
        cVar.b.add(aVar);
    }

    public final void a(com.qihoo360.replugin.ext.parser.b.a.e eVar) {
        c cVar = this.c;
        a aVar = new a(eVar.a, eVar.b);
        cVar.a.remove(aVar);
        cVar.b.remove(aVar);
    }

    private void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.a.append("\t");
        }
    }
}
