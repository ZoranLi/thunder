package com.aplayer.aplayerandroid;

import com.aplayer.Version;
import com.aplayer.io.AHttp;
import com.aplayer.io.ALocalFile;
import com.aplayer.io.ExtIOBase;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

public class XLMediaMetaDataRetriever {
    private static final String TAG = "meeeeXLMediaMetaDataRetriver";
    private ExtIOBase mExtIO;
    private long mNativeContext = 0;

    private native byte[] _getAnyFrameAtTime(int i, int i2, int i3);

    private native int _getBitRate();

    private native int _getDuration();

    private native long _getFileSize();

    private native int _getFrameRate();

    private native int _getHeight();

    private native byte[] _getKeyFrameAtTime(int i, int i2, int i3);

    private native int _getRotation();

    private native int _getWidth();

    private static native void _init();

    private native void _release();

    private native int _setDataSource(String str);

    private native void _setExtIO(boolean z);

    private native void _setup();

    static {
        try {
            System.loadLibrary(Version.LIB_APLAYER_FFMPEG_NAME);
            System.loadLibrary(Version.LIB_APLAYER_ANDROID_NAME);
        } catch (Exception e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("loadLibrary fail");
            stringBuilder.append(e.toString());
            Log.e(str, stringBuilder.toString());
        }
        _init();
    }

    public XLMediaMetaDataRetriever() {
        _setup();
    }

    public int setDataSource(FileDescriptor fileDescriptor) {
        this.mExtIO = new ALocalFile(fileDescriptor);
        if (this.mExtIO.open("") == -1) {
            Log.e(TAG, "ALocalFile open Failed");
            return -1;
        }
        _setExtIO(true);
        fileDescriptor = _setDataSource("c:\\");
        if (fileDescriptor == -1) {
            Log.e(TAG, "setDataSource error");
        }
        return fileDescriptor;
    }

    public int setDataSource(String str) {
        if (str == null) {
            return -1;
        }
        if (str == null || str.indexOf("https://") != 0) {
            _setExtIO(false);
            this.mExtIO = null;
        } else {
            _setExtIO(true);
            this.mExtIO = new AHttp();
        }
        return _setDataSource(str);
    }

    public byte[] getKeyFrameAtTime(int i, int i2, int i3) {
        return _getKeyFrameAtTime(i, i2, i3);
    }

    private byte[] getAnyFrameAtTime(int i, int i2, int i3) {
        return _getAnyFrameAtTime(i, i2, i3);
    }

    public void release() {
        _release();
    }

    public int getWidth() {
        return _getWidth();
    }

    public int getHeight() {
        return _getHeight();
    }

    public int getRotation() {
        return _getRotation();
    }

    public int getDuraton() {
        return _getDuration();
    }

    public int getBitRate() {
        return _getBitRate();
    }

    public int getFrameRate() {
        return _getFrameRate();
    }

    public long getFileSize() {
        return _getFileSize();
    }

    private int extIOOpen(String str) {
        return this.mExtIO != null ? this.mExtIO.open(str) : null;
    }

    private int extIOClose(String str) {
        if (this.mExtIO == null) {
            return null;
        }
        this.mExtIO.close(str);
        return 1;
    }

    private int extIORead(ByteBuffer byteBuffer) {
        return this.mExtIO != null ? this.mExtIO.read(byteBuffer) : null;
    }

    private long extIOSeek(int i, int i2) {
        return this.mExtIO != null ? this.mExtIO.seek(i, i2) : 0;
    }
}
