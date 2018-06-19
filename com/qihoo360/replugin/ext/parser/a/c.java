package com.qihoo360.replugin.ext.parser.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: XmlNamespaces */
final class c {
    List<a> a = new ArrayList();
    List<a> b = new ArrayList();

    /* compiled from: XmlNamespaces */
    public static class a {
        String a;
        String b;

        private a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    a aVar = (a) obj;
                    if (this.a == null && aVar.a != null) {
                        return false;
                    }
                    if (this.b == null && aVar.b != null) {
                        return false;
                    }
                    if (this.a == null || this.a.equals(aVar.a)) {
                        return this.b == null || this.b.equals(aVar.b) != null;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * this.a.hashCode()) + this.b.hashCode();
        }
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        for (a aVar : this.a) {
            if (aVar.b.equals(str)) {
                return aVar.a;
            }
        }
        return null;
    }
}
