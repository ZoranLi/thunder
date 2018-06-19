package okio;

import com.alipay.sdk.data.a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Okio */
final class p extends a {
    final /* synthetic */ Socket a;

    p(Socket socket) {
        this.a = socket;
    }

    protected final IOException a(@Nullable IOException iOException) {
        IOException socketTimeoutException = new SocketTimeoutException(a.f);
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    protected final void a() {
        Logger logger;
        Level level;
        StringBuilder stringBuilder;
        try {
            this.a.close();
        } catch (Throwable e) {
            logger = m.a;
            level = Level.WARNING;
            stringBuilder = new StringBuilder("Failed to close timed out socket ");
            stringBuilder.append(this.a);
            logger.log(level, stringBuilder.toString(), e);
        } catch (Throwable e2) {
            if (m.a(e2)) {
                logger = m.a;
                level = Level.WARNING;
                stringBuilder = new StringBuilder("Failed to close timed out socket ");
                stringBuilder.append(this.a);
                logger.log(level, stringBuilder.toString(), e2);
                return;
            }
            throw e2;
        }
    }
}
