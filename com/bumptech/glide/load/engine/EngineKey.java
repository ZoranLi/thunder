package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class EngineKey implements Key {
    private static final String EMPTY_LOG_STRING = "";
    private final ResourceDecoder cacheDecoder;
    private final ResourceDecoder decoder;
    private final ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final String id;
    private Key originalKey;
    private final Key signature;
    private final Encoder sourceEncoder;
    private String stringKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;

    public EngineKey(String str, Key key, int i, int i2, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder) {
        this.id = str;
        this.signature = key;
        this.width = i;
        this.height = i2;
        this.cacheDecoder = resourceDecoder;
        this.decoder = resourceDecoder2;
        this.transformation = transformation;
        this.encoder = resourceEncoder;
        this.transcoder = resourceTranscoder;
        this.sourceEncoder = encoder;
    }

    public Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new OriginalKey(this.id, this.signature);
        }
        return this.originalKey;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                EngineKey engineKey = (EngineKey) obj;
                if (!this.id.equals(engineKey.id) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width) {
                    return false;
                }
                if (((this.transformation == null ? 1 : 0) ^ (engineKey.transformation == null ? 1 : 0)) != 0) {
                    return false;
                }
                if (this.transformation != null && !this.transformation.getId().equals(engineKey.transformation.getId())) {
                    return false;
                }
                if (((this.decoder == null ? 1 : 0) ^ (engineKey.decoder == null ? 1 : 0)) != 0) {
                    return false;
                }
                if (this.decoder != null && !this.decoder.getId().equals(engineKey.decoder.getId())) {
                    return false;
                }
                if (((this.cacheDecoder == null ? 1 : 0) ^ (engineKey.cacheDecoder == null ? 1 : 0)) != 0) {
                    return false;
                }
                if (this.cacheDecoder != null && !this.cacheDecoder.getId().equals(engineKey.cacheDecoder.getId())) {
                    return false;
                }
                if (((this.encoder == null ? 1 : 0) ^ (engineKey.encoder == null ? 1 : 0)) != 0) {
                    return false;
                }
                if (this.encoder != null && !this.encoder.getId().equals(engineKey.encoder.getId())) {
                    return false;
                }
                if (((this.transcoder == null ? 1 : 0) ^ (engineKey.transcoder == null ? 1 : 0)) != 0) {
                    return false;
                }
                if (this.transcoder != null && !this.transcoder.getId().equals(engineKey.transcoder.getId())) {
                    return false;
                }
                if (((this.sourceEncoder == null ? 1 : 0) ^ (engineKey.sourceEncoder == null ? 1 : 0)) != 0) {
                    return false;
                }
                return this.sourceEncoder == null || this.sourceEncoder.getId().equals(engineKey.sourceEncoder.getId()) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.id.hashCode();
            this.hashCode = (this.hashCode * 31) + this.signature.hashCode();
            this.hashCode = (this.hashCode * 31) + this.width;
            this.hashCode = (this.hashCode * 31) + this.height;
            int i = 0;
            this.hashCode = (this.hashCode * 31) + (this.cacheDecoder != null ? this.cacheDecoder.getId().hashCode() : 0);
            this.hashCode = (this.hashCode * 31) + (this.decoder != null ? this.decoder.getId().hashCode() : 0);
            this.hashCode = (this.hashCode * 31) + (this.transformation != null ? this.transformation.getId().hashCode() : 0);
            this.hashCode = (this.hashCode * 31) + (this.encoder != null ? this.encoder.getId().hashCode() : 0);
            this.hashCode = (this.hashCode * 31) + (this.transcoder != null ? this.transcoder.getId().hashCode() : 0);
            int i2 = 31 * this.hashCode;
            if (this.sourceEncoder != null) {
                i = this.sourceEncoder.getId().hashCode();
            }
            this.hashCode = i2 + i;
        }
        return this.hashCode;
    }

    public String toString() {
        if (this.stringKey == null) {
            StringBuilder stringBuilder = new StringBuilder("EngineKey{");
            stringBuilder.append(this.id);
            stringBuilder.append('+');
            stringBuilder.append(this.signature);
            stringBuilder.append("+[");
            stringBuilder.append(this.width);
            stringBuilder.append('x');
            stringBuilder.append(this.height);
            stringBuilder.append("]+'");
            stringBuilder.append(this.cacheDecoder != null ? this.cacheDecoder.getId() : "");
            stringBuilder.append('\'');
            stringBuilder.append('+');
            stringBuilder.append('\'');
            stringBuilder.append(this.decoder != null ? this.decoder.getId() : "");
            stringBuilder.append('\'');
            stringBuilder.append('+');
            stringBuilder.append('\'');
            stringBuilder.append(this.transformation != null ? this.transformation.getId() : "");
            stringBuilder.append('\'');
            stringBuilder.append('+');
            stringBuilder.append('\'');
            stringBuilder.append(this.encoder != null ? this.encoder.getId() : "");
            stringBuilder.append('\'');
            stringBuilder.append('+');
            stringBuilder.append('\'');
            stringBuilder.append(this.transcoder != null ? this.transcoder.getId() : "");
            stringBuilder.append('\'');
            stringBuilder.append('+');
            stringBuilder.append('\'');
            stringBuilder.append(this.sourceEncoder != null ? this.sourceEncoder.getId() : "");
            stringBuilder.append('\'');
            stringBuilder.append('}');
            this.stringKey = stringBuilder.toString();
        }
        return this.stringKey;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        messageDigest.update((this.cacheDecoder != null ? this.cacheDecoder.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.decoder != null ? this.decoder.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.transformation != null ? this.transformation.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.encoder != null ? this.encoder.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.sourceEncoder != null ? this.sourceEncoder.getId() : "").getBytes("UTF-8"));
    }
}
