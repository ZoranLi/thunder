package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.InputStream;

public class ImageVideoBitmapDecoder implements ResourceDecoder<ImageVideoWrapper, Bitmap> {
    private static final String TAG = "ImageVideoDecoder";
    private final ResourceDecoder<ParcelFileDescriptor, Bitmap> fileDescriptorDecoder;
    private final ResourceDecoder<InputStream, Bitmap> streamDecoder;

    public String getId() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    public ImageVideoBitmapDecoder(ResourceDecoder<InputStream, Bitmap> resourceDecoder, ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder2) {
        this.streamDecoder = resourceDecoder;
        this.fileDescriptorDecoder = resourceDecoder2;
    }

    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(com.bumptech.glide.load.model.ImageVideoWrapper r3, int r4, int r5) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3.getStream();
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r1 = r2.streamDecoder;	 Catch:{ IOException -> 0x000d }
        r0 = r1.decode(r0, r4, r5);	 Catch:{ IOException -> 0x000d }
        goto L_0x000e;
    L_0x000d:
        r0 = 0;
    L_0x000e:
        if (r0 != 0) goto L_0x001c;
    L_0x0010:
        r3 = r3.getFileDescriptor();
        if (r3 == 0) goto L_0x001c;
    L_0x0016:
        r0 = r2.fileDescriptorDecoder;
        r0 = r0.decode(r3, r4, r5);
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ImageVideoBitmapDecoder.decode(com.bumptech.glide.load.model.ImageVideoWrapper, int, int):com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap>");
    }
}
