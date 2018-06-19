package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* compiled from: Okio */
public final class m {
    static final Logger a = Logger.getLogger(m.class.getName());

    private m() {
    }

    public static g a(v vVar) {
        return new r(vVar);
    }

    public static f a(u uVar) {
        return new q(uVar);
    }

    public static u a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        w c = c(socket);
        socket = socket.getOutputStream();
        if (socket != null) {
            return new b(c, new n(c, socket));
        }
        throw new IllegalArgumentException("out == null");
    }

    public static v a(InputStream inputStream) {
        return a(inputStream, new w());
    }

    private static v a(InputStream inputStream, w wVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (wVar != null) {
            return new o(wVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static v a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static v b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        w c = c(socket);
        return new c(c, a(socket.getInputStream(), c));
    }

    private static a c(Socket socket) {
        return new p(socket);
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }
}
