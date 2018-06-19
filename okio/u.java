package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink */
public interface u extends Closeable, Flushable {
    w a();

    void a_(e eVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
