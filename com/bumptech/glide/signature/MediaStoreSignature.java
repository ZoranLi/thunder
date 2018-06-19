package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature implements Key {
    private final long dateModified;
    private final String mimeType;
    private final int orientation;

    public MediaStoreSignature(String str, long j, int i) {
        this.mimeType = str;
        this.dateModified = j;
        this.orientation = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
                if (this.dateModified != mediaStoreSignature.dateModified || this.orientation != mediaStoreSignature.orientation) {
                    return false;
                }
                if (this.mimeType == null) {
                    return mediaStoreSignature.mimeType == null;
                } else {
                    if (this.mimeType.equals(mediaStoreSignature.mimeType) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * (((this.mimeType != null ? this.mimeType.hashCode() : 0) * 31) + ((int) (this.dateModified ^ (this.dateModified >>> 32))))) + this.orientation;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes("UTF-8"));
    }
}
