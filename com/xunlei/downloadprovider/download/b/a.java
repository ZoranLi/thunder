package com.xunlei.downloadprovider.download.b;

/* compiled from: ConfigImpl */
final class a {
    boolean a = false;
    int b = 0;

    a() {
    }

    final void a(int i) {
        if (!(i == 0 || i == 1)) {
            if (i != 3) {
                i = i == 2 ? 1 : 0;
            }
        }
        this.b = i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConfigImpl{mIsDestinationDownloadTab=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mCardStyle=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
