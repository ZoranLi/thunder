package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileToStreamDecoder<T> implements ResourceDecoder<File, T> {
    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private final FileOpener fileOpener;
    private ResourceDecoder<InputStream, T> streamDecoder;

    static class FileOpener {
        FileOpener() {
        }

        public InputStream open(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public String getId() {
        return "";
    }

    public FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder) {
        this(resourceDecoder, DEFAULT_FILE_OPENER);
    }

    FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder, FileOpener fileOpener) {
        this.streamDecoder = resourceDecoder;
        this.fileOpener = fileOpener;
    }

    public com.bumptech.glide.load.engine.Resource<T> decode(java.io.File r3, int r4, int r5) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        r1 = r2.fileOpener;	 Catch:{ all -> 0x0015 }
        r3 = r1.open(r3);	 Catch:{ all -> 0x0015 }
        r0 = r2.streamDecoder;	 Catch:{ all -> 0x0013 }
        r4 = r0.decode(r3, r4, r5);	 Catch:{ all -> 0x0013 }
        if (r3 == 0) goto L_0x0012;
    L_0x000f:
        r3.close();	 Catch:{ IOException -> 0x0012 }
    L_0x0012:
        return r4;
    L_0x0013:
        r4 = move-exception;
        goto L_0x0017;
    L_0x0015:
        r4 = move-exception;
        r3 = r0;
    L_0x0017:
        if (r3 == 0) goto L_0x001c;
    L_0x0019:
        r3.close();	 Catch:{ IOException -> 0x001c }
    L_0x001c:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.file.FileToStreamDecoder.decode(java.io.File, int, int):com.bumptech.glide.load.engine.Resource<T>");
    }
}
