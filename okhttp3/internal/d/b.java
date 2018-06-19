package okhttp3.internal.d;

import java.io.File;
import java.io.IOException;

/* compiled from: FileSystem */
final class b implements a {
    b() {
    }

    public final void a(File file) throws IOException {
        if (!file.delete() && file.exists()) {
            StringBuilder stringBuilder = new StringBuilder("failed to delete ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
    }
}
