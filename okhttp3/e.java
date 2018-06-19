package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.b.f;

/* compiled from: CacheControl */
public final class e {
    public static final e a;
    public static final e b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final boolean k;
    @Nullable
    String l;
    private final int m;
    private final boolean n;
    private final boolean o;

    static {
        a aVar = new a();
        aVar.a = true;
        a = aVar.a();
        aVar = new a();
        aVar.f = true;
        long toSeconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        aVar.d = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
        b = aVar.a();
    }

    private e(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.c = z;
        this.d = z2;
        this.e = i;
        this.m = i2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = i3;
        this.j = i4;
        this.k = z6;
        this.n = z7;
        this.o = z8;
        this.l = str;
    }

    e(a aVar) {
        this.c = aVar.a;
        this.d = aVar.b;
        this.e = aVar.c;
        this.m = -1;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = aVar.d;
        this.j = aVar.e;
        this.k = aVar.f;
        this.n = aVar.g;
        this.o = aVar.h;
    }

    public final String toString() {
        String str = this.l;
        if (str != null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.c) {
            stringBuilder.append("no-cache, ");
        }
        if (this.d) {
            stringBuilder.append("no-store, ");
        }
        if (this.e != -1) {
            stringBuilder.append("max-age=");
            stringBuilder.append(this.e);
            stringBuilder.append(", ");
        }
        if (this.m != -1) {
            stringBuilder.append("s-maxage=");
            stringBuilder.append(this.m);
            stringBuilder.append(", ");
        }
        if (this.f) {
            stringBuilder.append("private, ");
        }
        if (this.g) {
            stringBuilder.append("public, ");
        }
        if (this.h) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.i != -1) {
            stringBuilder.append("max-stale=");
            stringBuilder.append(this.i);
            stringBuilder.append(", ");
        }
        if (this.j != -1) {
            stringBuilder.append("min-fresh=");
            stringBuilder.append(this.j);
            stringBuilder.append(", ");
        }
        if (this.k) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.n) {
            stringBuilder.append("no-transform, ");
        }
        if (this.o) {
            stringBuilder.append("immutable, ");
        }
        if (stringBuilder.length() == 0) {
            str = "";
        } else {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            str = stringBuilder.toString();
        }
        this.l = str;
        return str;
    }

    public static e a(y yVar) {
        y yVar2 = yVar;
        int length = yVar2.a.length / 2;
        Object obj = 1;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        int i = -1;
        int i2 = -1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        for (int i5 = 0; i5 < length; i5++) {
            int i6;
            int a;
            String trim;
            int a2;
            boolean z9;
            int a3;
            String trim2;
            String a4 = yVar2.a(i5);
            String b = yVar2.b(i5);
            if (a4.equalsIgnoreCase("Cache-Control")) {
                if (str == null) {
                    str = b;
                    i6 = 0;
                    while (i6 < b.length()) {
                        a = f.a(b, i6, "=,;");
                        trim = b.substring(i6, a).trim();
                        if (!(a == b.length() || b.charAt(a) == ',')) {
                            if (b.charAt(a) == ';') {
                                a2 = f.a(b, a + 1);
                                if (a2 < b.length() || b.charAt(a2) != '\"') {
                                    z9 = true;
                                    a3 = f.a(b, a2, ",;");
                                    trim2 = b.substring(a2, a3).trim();
                                } else {
                                    a2++;
                                    a3 = f.a(b, a2, "\"");
                                    trim2 = b.substring(a2, a3);
                                    z9 = true;
                                    a3++;
                                }
                                if (!"no-cache".equalsIgnoreCase(trim)) {
                                    i6 = a3;
                                    z = z9;
                                } else if ("no-store".equalsIgnoreCase(trim)) {
                                    if (!"max-age".equalsIgnoreCase(trim)) {
                                        i = f.b(trim2, -1);
                                    } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                                        i2 = f.b(trim2, -1);
                                    } else if (!"private".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z3 = z9;
                                    } else if (!"public".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z4 = z9;
                                    } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z5 = z9;
                                    } else if (!"max-stale".equalsIgnoreCase(trim)) {
                                        i3 = f.b(trim2, Integer.MAX_VALUE);
                                    } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                                        i4 = f.b(trim2, -1);
                                    } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z6 = z9;
                                    } else if (!"no-transform".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z7 = z9;
                                    } else if ("immutable".equalsIgnoreCase(trim)) {
                                        z8 = z9;
                                    }
                                    i6 = a3;
                                } else {
                                    i6 = a3;
                                    z2 = z9;
                                }
                            }
                        }
                        z9 = true;
                        a3 = a + 1;
                        trim2 = null;
                        if (!"no-cache".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z = z9;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            if (!"max-age".equalsIgnoreCase(trim)) {
                                i = f.b(trim2, -1);
                            } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                                i2 = f.b(trim2, -1);
                            } else if (!"private".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z3 = z9;
                            } else if (!"public".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z4 = z9;
                            } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z5 = z9;
                            } else if (!"max-stale".equalsIgnoreCase(trim)) {
                                i3 = f.b(trim2, Integer.MAX_VALUE);
                            } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                                i4 = f.b(trim2, -1);
                            } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z6 = z9;
                            } else if (!"no-transform".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z7 = z9;
                            } else if ("immutable".equalsIgnoreCase(trim)) {
                                z8 = z9;
                            }
                            i6 = a3;
                        } else {
                            i6 = a3;
                            z2 = z9;
                        }
                    }
                }
            } else if (!a4.equalsIgnoreCase("Pragma")) {
            }
            obj = null;
            i6 = 0;
            while (i6 < b.length()) {
                a = f.a(b, i6, "=,;");
                trim = b.substring(i6, a).trim();
                if (b.charAt(a) == ';') {
                    a2 = f.a(b, a + 1);
                    if (a2 < b.length()) {
                    }
                    z9 = true;
                    a3 = f.a(b, a2, ",;");
                    trim2 = b.substring(a2, a3).trim();
                    if (!"no-cache".equalsIgnoreCase(trim)) {
                        i6 = a3;
                        z = z9;
                    } else if ("no-store".equalsIgnoreCase(trim)) {
                        i6 = a3;
                        z2 = z9;
                    } else {
                        if (!"max-age".equalsIgnoreCase(trim)) {
                            i = f.b(trim2, -1);
                        } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                            i2 = f.b(trim2, -1);
                        } else if (!"private".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z3 = z9;
                        } else if (!"public".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z4 = z9;
                        } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z5 = z9;
                        } else if (!"max-stale".equalsIgnoreCase(trim)) {
                            i3 = f.b(trim2, Integer.MAX_VALUE);
                        } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                            i4 = f.b(trim2, -1);
                        } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z6 = z9;
                        } else if (!"no-transform".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z7 = z9;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z8 = z9;
                        }
                        i6 = a3;
                    }
                } else {
                    z9 = true;
                    a3 = a + 1;
                    trim2 = null;
                    if (!"no-cache".equalsIgnoreCase(trim)) {
                        i6 = a3;
                        z = z9;
                    } else if ("no-store".equalsIgnoreCase(trim)) {
                        if (!"max-age".equalsIgnoreCase(trim)) {
                            i = f.b(trim2, -1);
                        } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                            i2 = f.b(trim2, -1);
                        } else if (!"private".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z3 = z9;
                        } else if (!"public".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z4 = z9;
                        } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z5 = z9;
                        } else if (!"max-stale".equalsIgnoreCase(trim)) {
                            i3 = f.b(trim2, Integer.MAX_VALUE);
                        } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                            i4 = f.b(trim2, -1);
                        } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z6 = z9;
                        } else if (!"no-transform".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z7 = z9;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z8 = z9;
                        }
                        i6 = a3;
                    } else {
                        i6 = a3;
                        z2 = z9;
                    }
                }
            }
        }
        return new e(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, obj == null ? null : str);
    }
}
