package okhttp3.internal.g;

import javax.security.auth.x500.X500Principal;

/* compiled from: DistinguishedNameParser */
final class c {
    final String a;
    final int b = this.a.length();
    int c;
    int d;
    int e;
    int f;
    char[] g;

    c(X500Principal x500Principal) {
        this.a = x500Principal.getName("RFC2253");
    }

    final String a() {
        while (this.c < this.b && this.g[this.c] == ' ') {
            this.c++;
        }
        if (this.c == this.b) {
            return null;
        }
        this.d = this.c;
        this.c++;
        while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] != ' ') {
            this.c++;
        }
        if (this.c >= this.b) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected end of DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.e = this.c;
        if (this.g[this.c] == ' ') {
            while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] == ' ') {
                this.c++;
            }
            if (this.g[this.c] != '=' || this.c == this.b) {
                stringBuilder = new StringBuilder("Unexpected end of DN: ");
                stringBuilder.append(this.a);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        do {
            this.c++;
            if (this.c >= this.b) {
                break;
            }
        } while (this.g[this.c] == ' ');
        if (this.e - this.d > 4 && this.g[this.d + 3] == '.' && ((this.g[this.d] == 'O' || this.g[this.d] == 'o') && ((this.g[this.d + 1] == 'I' || this.g[this.d + 1] == 'i') && (this.g[this.d + 2] == 'D' || this.g[this.d + 2] == 'd')))) {
            this.d += 4;
        }
        return new String(this.g, this.d, this.e - this.d);
    }

    final String b() {
        if (this.c + 4 >= this.b) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected end of DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        int i;
        int i2;
        this.d = this.c;
        this.c++;
        while (this.c != this.b && this.g[this.c] != '+' && this.g[this.c] != ',') {
            byte[] bArr;
            int i3;
            if (this.g[this.c] == ';') {
                break;
            } else if (this.g[this.c] == ' ') {
                this.e = this.c;
                this.c++;
                while (this.c < this.b && this.g[this.c] == ' ') {
                    this.c++;
                }
                i = this.e - this.d;
                if (i >= 5) {
                    if ((i & 1) == 0) {
                        bArr = new byte[(i / 2)];
                        i2 = this.d + 1;
                        for (i3 = 0; i3 < bArr.length; i3++) {
                            bArr[i3] = (byte) a(i2);
                            i2 += 2;
                        }
                        return new String(this.g, this.d, i);
                    }
                }
                stringBuilder = new StringBuilder("Unexpected end of DN: ");
                stringBuilder.append(this.a);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                if (this.g[this.c] >= 'A' && this.g[this.c] <= 'F') {
                    char[] cArr = this.g;
                    i3 = this.c;
                    cArr[i3] = (char) (cArr[i3] + 32);
                }
                this.c++;
            }
        }
        this.e = this.c;
        i = this.e - this.d;
        if (i >= 5) {
            if ((i & 1) == 0) {
                bArr = new byte[(i / 2)];
                i2 = this.d + 1;
                for (i3 = 0; i3 < bArr.length; i3++) {
                    bArr[i3] = (byte) a(i2);
                    i2 += 2;
                }
                return new String(this.g, this.d, i);
            }
        }
        stringBuilder = new StringBuilder("Unexpected end of DN: ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    final String c() {
        this.d = this.c;
        this.e = this.c;
        while (this.c < this.b) {
            char c = this.g[this.c];
            char[] cArr;
            if (c != ' ') {
                if (c != ';') {
                    int i;
                    if (c != '\\') {
                        switch (c) {
                            case '+':
                            case ',':
                                break;
                            default:
                                cArr = this.g;
                                i = this.e;
                                this.e = i + 1;
                                cArr[i] = this.g[this.c];
                                this.c++;
                                continue;
                        }
                    } else {
                        cArr = this.g;
                        i = this.e;
                        this.e = i + 1;
                        cArr[i] = d();
                        this.c++;
                    }
                }
                return new String(this.g, this.d, this.e - this.d);
            }
            this.f = this.e;
            this.c++;
            cArr = this.g;
            int i2 = this.e;
            this.e = i2 + 1;
            cArr[i2] = ' ';
            while (this.c < this.b && this.g[this.c] == ' ') {
                cArr = this.g;
                i2 = this.e;
                this.e = i2 + 1;
                cArr[i2] = ' ';
                this.c++;
            }
            if (this.c == this.b || this.g[this.c] == ',' || this.g[this.c] == '+' || this.g[this.c] == ';') {
                return new String(this.g, this.d, this.f - this.d);
            }
        }
        return new String(this.g, this.d, this.e - this.d);
    }

    final char d() {
        this.c++;
        if (this.c == this.b) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected end of DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        char c = this.g[this.c];
        if (!(c == ' ' || c == '%' || c == '\\' || c == '_')) {
            switch (c) {
                case '\"':
                case '#':
                    break;
                default:
                    switch (c) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return e();
                            }
                    }
            }
        }
        return this.g[this.c];
    }

    private char e() {
        int a = a(this.c);
        this.c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        int i;
        if (a <= 223) {
            a &= 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            a &= 15;
        } else {
            i = 3;
            a &= 7;
        }
        int i2 = 0;
        while (i2 < i) {
            this.c++;
            if (this.c != this.b) {
                if (this.g[this.c] == '\\') {
                    this.c++;
                    int a2 = a(this.c);
                    this.c++;
                    if ((a2 & 192) != 128) {
                        return '?';
                    }
                    a = (a << 6) + (a2 & 63);
                    i2++;
                }
            }
            return '?';
        }
        return (char) a;
    }

    private int a(int i) {
        int i2 = i + 1;
        if (i2 >= this.b) {
            StringBuilder stringBuilder = new StringBuilder("Malformed DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        i = this.g[i];
        if (i >= 48 && i <= 57) {
            i -= 48;
        } else if (i >= 97 && i <= 102) {
            i -= 87;
        } else if (i < 65 || i > 70) {
            stringBuilder = new StringBuilder("Malformed DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            i -= 55;
        }
        char c = this.g[i2];
        if (c >= '0' && c <= '9') {
            i2 = c - 48;
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 87;
        } else if (c < 'A' || c > 'F') {
            stringBuilder = new StringBuilder("Malformed DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            i2 = c - 55;
        }
        return (i << 4) + i2;
    }
}
