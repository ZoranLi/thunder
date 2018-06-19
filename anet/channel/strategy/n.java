package anet.channel.strategy;

import java.io.File;
import java.util.Comparator;

/* compiled from: Taobao */
final class n implements Comparator<File> {
    n() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return a((File) obj, (File) obj2);
    }

    public final int a(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }
}
