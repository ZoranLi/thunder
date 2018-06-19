package com.aplayer.io;

import com.aplayer.aplayerandroid.Log;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ALocalFile implements ExtIOBase {
    private static final String TAG = "ALocalFile";
    private long mCurPos = 0;
    private FileChannel mFileChannel = null;
    private FileDescriptor mFileDescriptor = null;
    private FileInputStream mFileInputStream = null;
    private long mFileSize = 0;

    public ALocalFile(FileDescriptor fileDescriptor) {
        this.mFileDescriptor = fileDescriptor;
    }

    public synchronized int open(String str) {
        this.mCurPos = 0;
        try {
            if (!this.mFileDescriptor.valid()) {
                return -1;
            }
            this.mFileInputStream = new FileInputStream(this.mFileDescriptor);
            if (this.mFileInputStream != null) {
                this.mFileChannel = this.mFileInputStream.getChannel();
            }
            if (this.mFileChannel == null) {
                return -1;
            }
            this.mFileSize = this.mFileChannel.size();
            if (this.mFileChannel.isOpen()) {
                return 1;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int close(String str) {
        if (this.mFileChannel != null) {
            try {
                this.mFileChannel.close();
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
        if (this.mFileInputStream != null) {
            try {
                this.mFileInputStream.close();
            } catch (String str22) {
                str22.printStackTrace();
            }
        }
        return 1;
    }

    public int read(ByteBuffer byteBuffer) {
        int read;
        synchronized (this.mFileChannel) {
            byteBuffer.position(0);
            try {
                read = this.mFileChannel.read(byteBuffer);
                byteBuffer.flip();
                byteBuffer = TAG;
                StringBuilder stringBuilder = new StringBuilder("ALocalFile read ");
                stringBuilder.append(read);
                Log.i(byteBuffer, stringBuilder.toString());
                if (read != -1) {
                    this.mCurPos += (long) read;
                }
            } catch (ByteBuffer byteBuffer2) {
                byteBuffer2.printStackTrace();
                return -1;
            }
        }
        return read;
    }

    public long seek(int i, int i2) {
        Log.i(TAG, "ALocalFile seek");
        synchronized (this.mFileChannel) {
            if (65536 == i2) {
                i = this.mFileSize;
                return i;
            }
            if (i2 == 0) {
                try {
                    this.mCurPos = (long) i;
                } catch (int i3) {
                    Log.e(TAG, "ALocalFile seek Exception");
                    i3.printStackTrace();
                    return -1;
                }
            } else if (1 == i2) {
                this.mCurPos += (long) i3;
            } else if (2 == i2) {
                this.mCurPos = this.mFileSize - ((long) i3);
            } else {
                i3 = TAG;
                StringBuilder stringBuilder = new StringBuilder("Ahttp seek whence = ");
                stringBuilder.append(i2);
                Log.e(i3, stringBuilder.toString());
                return -1;
            }
            i3 = TAG;
            i2 = new StringBuilder("ALocalFile seek mCurPos = ");
            i2.append(this.mCurPos);
            Log.i(i3, i2.toString());
            if (this.mFileDescriptor.valid() != 0) {
                this.mFileChannel.position(this.mCurPos);
                return 1;
            }
            Log.i(TAG, "ALocalFile seek mFileDescriptor is not valid");
            return -1;
        }
    }
}
