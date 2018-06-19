package com.aplayer.io;

import android.os.Environment;
import com.aplayer.aplayerandroid.APlayerAndroid.PlayCompleteRet;
import com.aplayer.aplayerandroid.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AHttp implements ExtIOBase {
    private static final String TAG = "APlayerAndroid";
    private String mCacheFileDir = null;
    CacheFileDirManage mCacheFileDirManage = null;
    private String mCurCacheFileName = "";
    private long mCurHttpPos = 0;
    private long mCurPos = 0;
    private CacheFile mFileBuf = null;
    private long mFileSize = 0;
    private HttpURLConnection mHttpConnection = null;
    private InputStream mInputStream = null;
    private String mUrlPath = null;
    private boolean mUseCache = false;

    private class CacheFile {
        private static final int mMemoryBufSize = 2097152;
        private BufNode mCurWriteBufNode;
        private FileOutputStream mDataFileOutputStream;
        private RandomAccessFile mDataRandomAccessFile;
        private FileInputStream mFileInputStream;
        private long mFileSize = 0;
        private List<BufNode> mListBufNodes = new ArrayList();
        private byte[] mMemoryBuf;
        private long mReadStreamPos = 0;
        private RandomAccessFile mRecRandomAccessFile;
        private long mWriteStreamPos = 0;

        private class BufNode implements Comparable {
            public long filePos;
            public long recFilePos;
            public int size;
            public long startPos;

            private BufNode() {
            }

            public int compareTo(Object obj) {
                return (int) (this.startPos - ((BufNode) obj).startPos);
            }
        }

        public boolean open(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".data");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append(".rec");
            str = stringBuilder3.toString();
            File file = new File(stringBuilder2);
            File file2 = new File(str);
            if (file.exists() != null && file2.exists() == null && file.delete() == null) {
                return false;
            }
            if (file.exists() == null && file2.exists() != null && file2.delete() == null) {
                return false;
            }
            if (file.exists() == null) {
                try {
                    file.createNewFile();
                } catch (String str2) {
                    str2.printStackTrace();
                    return false;
                }
            }
            if (file2.exists() == null) {
                try {
                    file2.createNewFile();
                } catch (String str22) {
                    str22.printStackTrace();
                    return false;
                }
            }
            try {
                this.mDataFileOutputStream = new FileOutputStream(file, true);
                try {
                    this.mDataRandomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        this.mRecRandomAccessFile = new RandomAccessFile(file2, "rw");
                        try {
                            if (((int) this.mRecRandomAccessFile.length()) >= 12) {
                                try {
                                    this.mFileSize = this.mRecRandomAccessFile.readLong();
                                    str22 = this.mRecRandomAccessFile.readInt();
                                } catch (String str222) {
                                    str222.printStackTrace();
                                    return false;
                                }
                            }
                            try {
                                this.mRecRandomAccessFile.seek(0);
                                this.mRecRandomAccessFile.writeLong(0);
                                this.mRecRandomAccessFile.writeInt(0);
                                str222 = null;
                            } catch (String str2222) {
                                str2222.printStackTrace();
                                return false;
                            }
                            try {
                                if (((long) (str2222 * 20)) + this.mRecRandomAccessFile.getFilePointer() != this.mRecRandomAccessFile.length()) {
                                    Log.e(AHttp.TAG, "recfile size is not right");
                                    return false;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            int i = 0;
                            while (i < str2222) {
                                BufNode bufNode = new BufNode();
                                try {
                                    bufNode.recFilePos = this.mRecRandomAccessFile.getFilePointer();
                                    bufNode.filePos = this.mRecRandomAccessFile.readLong();
                                    bufNode.startPos = this.mRecRandomAccessFile.readLong();
                                    bufNode.size = this.mRecRandomAccessFile.readInt();
                                    this.mListBufNodes.add(bufNode);
                                    i++;
                                } catch (String str22222) {
                                    str22222.printStackTrace();
                                    return false;
                                }
                            }
                            if (this.mListBufNodes.size() > null) {
                                Collections.sort(this.mListBufNodes);
                            }
                            str22222 = AHttp.TAG;
                            stringBuilder = new StringBuilder("AbufNode open nodesize = ");
                            stringBuilder.append(this.mListBufNodes.size());
                            Log.i(str22222, stringBuilder.toString());
                            this.mWriteStreamPos = file.length();
                            for (str22222 = null; str22222 < this.mListBufNodes.size(); str22222++) {
                                BufNode bufNode2 = (BufNode) this.mListBufNodes.get(str22222);
                                if (bufNode2.filePos + ((long) bufNode2.size) == this.mWriteStreamPos) {
                                    str22222 = AHttp.TAG;
                                    stringBuilder3 = new StringBuilder("find mCurWriteBufNode filePos = ");
                                    stringBuilder3.append(bufNode2.filePos);
                                    stringBuilder3.append(" mWriteStreamPos = ");
                                    stringBuilder3.append(this.mWriteStreamPos);
                                    Log.i(str22222, stringBuilder3.toString());
                                    this.mCurWriteBufNode = bufNode2;
                                    break;
                                }
                            }
                            if (this.mCurWriteBufNode == null) {
                                this.mCurWriteBufNode = new BufNode();
                                this.mCurWriteBufNode.filePos = this.mWriteStreamPos;
                                this.mCurWriteBufNode.startPos = 0;
                                this.mCurWriteBufNode.size = 0;
                                try {
                                    this.mCurWriteBufNode.recFilePos = (long) ((int) this.mRecRandomAccessFile.getFilePointer());
                                    this.mRecRandomAccessFile.writeLong(this.mCurWriteBufNode.filePos);
                                    this.mRecRandomAccessFile.writeLong(this.mCurWriteBufNode.startPos);
                                    this.mRecRandomAccessFile.writeInt(this.mCurWriteBufNode.size);
                                    this.mRecRandomAccessFile.seek(8);
                                    this.mRecRandomAccessFile.writeInt(this.mListBufNodes.size() + 1);
                                    this.mListBufNodes.add(this.mCurWriteBufNode);
                                } catch (String str222222) {
                                    str222222.printStackTrace();
                                    return false;
                                }
                            }
                            return true;
                        } catch (String str2222222) {
                            str2222222.printStackTrace();
                            return false;
                        }
                    } catch (String str22222222) {
                        str22222222.printStackTrace();
                        return false;
                    }
                } catch (String str222222222) {
                    str222222222.printStackTrace();
                    return false;
                }
            } catch (String str2222222222) {
                str2222222222.printStackTrace();
                return false;
            }
        }

        public long getFileSize() {
            return this.mFileSize;
        }

        public void setFileSize(long j) {
            this.mFileSize = j;
            if (this.mRecRandomAccessFile != null) {
                try {
                    this.mRecRandomAccessFile.seek(0);
                    this.mRecRandomAccessFile.writeLong(this.mFileSize);
                } catch (long j2) {
                    j2.printStackTrace();
                }
            }
        }

        public void write(long j, byte[] bArr, int i, int i2) throws Exception {
            byte[] bArr2 = bArr;
            if (this.mDataFileOutputStream != null) {
                if (r0.mRecRandomAccessFile != null) {
                    int i3;
                    long j2 = j;
                    int i4 = i;
                    int i5 = i2;
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < r0.mListBufNodes.size()) {
                        BufNode bufNode = (BufNode) r0.mListBufNodes.get(i6);
                        long j3 = j2 - bufNode.startPos;
                        long j4 = j2 + ((long) i5);
                        long j5 = j4 - (bufNode.startPos + ((long) bufNode.size));
                        int i8 = i6;
                        long j6 = j2 - (bufNode.startPos + ((long) bufNode.size));
                        long j7 = j4 - bufNode.startPos;
                        if (j3 < 0 && j5 < 0 && j7 > 0) {
                            i3 = ((int) j3) * -1;
                            break;
                        }
                        if (j3 > 0 && j5 > 0 && j6 < 0) {
                            j4 = j2 - j6;
                            int i9 = (int) j6;
                            i4 -= i9;
                            i5 += i9;
                            j2 = j4;
                        }
                        if (j3 >= 0 && j5 <= 0) {
                            i3 = 0;
                            break;
                        }
                        if (j3 <= 0 && j5 >= 0) {
                            if (j3 != 0) {
                                r0.mCurWriteBufNode = new BufNode();
                                r0.mCurWriteBufNode.filePos = r0.mWriteStreamPos;
                                r0.mCurWriteBufNode.startPos = j2;
                                r0.mCurWriteBufNode.size = ((int) j3) * -1;
                                r0.mListBufNodes.add(r0.mCurWriteBufNode);
                                r0.mDataFileOutputStream.write(bArr2, i4, r0.mCurWriteBufNode.size);
                                r0.mWriteStreamPos += (long) r0.mCurWriteBufNode.size;
                                i7 = 1;
                            }
                            long j8 = j2 - j6;
                            i3 = (int) j6;
                            i4 -= i3;
                            i5 += i3;
                            j2 = j8;
                        }
                        i6 = i8 + 1;
                    }
                    i3 = i5;
                    if (i3 != 0) {
                        r0.mDataFileOutputStream.write(bArr2, i4, i3);
                        if (r0.mCurWriteBufNode.startPos + ((long) r0.mCurWriteBufNode.size) == j2 && r0.mWriteStreamPos == r0.mCurWriteBufNode.filePos + ((long) r0.mCurWriteBufNode.size)) {
                            BufNode bufNode2 = r0.mCurWriteBufNode;
                            bufNode2.size += i3;
                            r0.mRecRandomAccessFile.seek(r0.mCurWriteBufNode.recFilePos + 16);
                            r0.mRecRandomAccessFile.writeInt(r0.mCurWriteBufNode.size);
                        } else {
                            r0.mCurWriteBufNode = new BufNode();
                            r0.mCurWriteBufNode.filePos = r0.mWriteStreamPos;
                            r0.mCurWriteBufNode.startPos = j2;
                            r0.mCurWriteBufNode.size = i3;
                            long length = r0.mRecRandomAccessFile.length();
                            r0.mRecRandomAccessFile.seek(length);
                            r0.mCurWriteBufNode.recFilePos = (long) ((int) length);
                            r0.mRecRandomAccessFile.writeLong(r0.mCurWriteBufNode.filePos);
                            r0.mRecRandomAccessFile.writeLong(r0.mCurWriteBufNode.startPos);
                            r0.mRecRandomAccessFile.writeInt(r0.mCurWriteBufNode.size);
                            r0.mRecRandomAccessFile.seek(8);
                            r0.mRecRandomAccessFile.writeInt(r0.mListBufNodes.size() + 1);
                            r0.mListBufNodes.add(r0.mCurWriteBufNode);
                            i7 = 1;
                        }
                        r0.mWriteStreamPos += (long) i3;
                    }
                    if (i7 != 0) {
                        Collections.sort(r0.mListBufNodes);
                    }
                }
            }
        }

        public int read(long j, byte[] bArr, int i, int i2) throws Exception {
            if (this.mDataRandomAccessFile == null) {
                return -1;
            }
            int i3 = 0;
            while (i3 < r0.mListBufNodes.size()) {
                BufNode bufNode = (BufNode) r0.mListBufNodes.get(i3);
                long j2 = j - bufNode.startPos;
                long j3 = j - (bufNode.startPos + ((long) bufNode.size));
                int i4;
                if (j2 < 0 || j3 >= 0) {
                    byte[] bArr2 = bArr;
                    int i5 = i;
                    i4 = i2;
                    i3++;
                } else {
                    int i6 = (int) (0 - j3);
                    i4 = i2;
                    if (i6 >= i4) {
                        i6 = i4;
                    }
                    r0.mDataRandomAccessFile.seek(bufNode.filePos + j2);
                    return r0.mDataRandomAccessFile.read(bArr, i, i6);
                }
            }
            return -1;
        }

        public boolean close() {
            try {
                if (this.mDataFileOutputStream != null) {
                    this.mDataFileOutputStream.close();
                    this.mDataFileOutputStream = null;
                }
                if (this.mRecRandomAccessFile != null) {
                    this.mRecRandomAccessFile.close();
                    this.mRecRandomAccessFile = null;
                }
                if (this.mDataRandomAccessFile != null) {
                    this.mDataRandomAccessFile.close();
                    this.mDataRandomAccessFile = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    private class CacheFileDirManage implements Runnable {
        private File dirFile;

        private class AFileInfo implements Comparable {
            File file;
            long modifyTime;

            private AFileInfo() {
            }

            public int compareTo(Object obj) {
                return (int) (this.modifyTime - ((AFileInfo) obj).modifyTime);
            }
        }

        public CacheFileDirManage(String str) {
            this.dirFile = new File(str, "");
            new Thread(this).start();
        }

        public void run() {
            long j;
            List arrayList = new ArrayList();
            long usableSpace = this.dirFile.getUsableSpace();
            File[] listFiles = this.dirFile.listFiles();
            int i = 0;
            if (listFiles != null) {
                int i2 = 0;
                j = 0;
                while (i2 < listFiles.length) {
                    AFileInfo aFileInfo = new AFileInfo();
                    aFileInfo.file = listFiles[i2];
                    aFileInfo.modifyTime = listFiles[i2].lastModified();
                    arrayList.add(aFileInfo);
                    i2++;
                    j += listFiles[i2].length();
                }
            } else {
                j = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AHttp.this.mCurCacheFileName);
            stringBuilder.append(".data");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(AHttp.this.mCurCacheFileName);
            stringBuilder3.append(".rec");
            String stringBuilder4 = stringBuilder3.toString();
            if (j - ((long) (((double) usableSpace) * 0.3d)) > 0) {
                while (i < arrayList.size()) {
                    AFileInfo aFileInfo2 = (AFileInfo) arrayList.get(i);
                    String name = aFileInfo2.file.getName();
                    if (name.compareTo(stringBuilder4) != 0) {
                        if (name.compareTo(stringBuilder2) != 0) {
                            aFileInfo2.file.length();
                            aFileInfo2.file.delete();
                            i++;
                        }
                    }
                    String str = AHttp.TAG;
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(name);
                    stringBuilder5.append(" is using,can not delete");
                    Log.e(str, stringBuilder5.toString());
                    i++;
                }
            }
        }
    }

    public int open(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("Ahttp ");
        stringBuilder.append(str);
        Log.i(str2, stringBuilder.toString());
        try {
            init();
            this.mUrlPath = str;
            if (this.mUseCache != null && openBufFile() == null) {
                return -1;
            }
            if (this.mUseCache != null && this.mFileBuf != null && this.mFileBuf.getFileSize() > 0) {
                return 1;
            }
            if (openHttpFile(this.mCurPos) != null && getFileSize() > 0) {
                if (this.mFileBuf != null) {
                    this.mFileBuf.setFileSize(getFileSize());
                }
                return 1;
            }
            return -1;
        } catch (String str3) {
            String str4 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("open Ahttp failed:");
            stringBuilder2.append(str3);
            Log.e(str4, stringBuilder2.toString());
            str3.printStackTrace();
        }
    }

    public int close(String str) {
        String str2;
        StringBuilder stringBuilder;
        try {
            closeBufFile();
            closeHttpFile();
            if (!(str.equals(PlayCompleteRet.PLAYRE_RESULT_CLOSE) || str.equals(PlayCompleteRet.PLAYRE_RESULT_COMPLETE) || !this.mUseCache)) {
                str2 = TAG;
                stringBuilder = new StringBuilder("ahttp delete cache file ret = ");
                stringBuilder.append(str);
                Log.e(str2, stringBuilder.toString());
                deleteCache(this.mUrlPath);
            }
            return 1;
        } catch (String str3) {
            str2 = TAG;
            stringBuilder = new StringBuilder("close Ahttp failed:");
            stringBuilder.append(str3);
            Log.e(str2, stringBuilder.toString());
            str3.printStackTrace();
            return -1;
        }
    }

    public int setCacheFileDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (String str2) {
                str2.printStackTrace();
                return -1;
            }
        }
        if (!file.isDirectory()) {
            return -1;
        }
        this.mCacheFileDir = str2;
        return 1;
    }

    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    public int read(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return -1;
        }
        try {
            byteBuffer.position(0);
            int limit = byteBuffer.limit();
            if (limit == 0) {
                Log.e(TAG, "ahttp read size == 0");
                return -1;
            }
            byte[] bArr = new byte[limit];
            if (this.mUseCache && this.mFileBuf != null) {
                try {
                    int read = this.mFileBuf.read(this.mCurPos, bArr, 0, limit);
                    if (-1 != read) {
                        String str = TAG;
                        StringBuilder stringBuilder = new StringBuilder("Ahttp file buf read readbyte = ");
                        stringBuilder.append(read);
                        Log.i(str, stringBuilder.toString());
                        byteBuffer.put(bArr, 0, read);
                        this.mCurPos += (long) read;
                        return read;
                    }
                } catch (ByteBuffer byteBuffer2) {
                    byteBuffer2.printStackTrace();
                    this.mUseCache = false;
                    return -1;
                }
            }
            if (this.mCurPos != this.mCurHttpPos) {
                seekHttpFile(this.mCurPos);
            }
            if (this.mInputStream == null && !openHttpFile(this.mCurHttpPos)) {
                return -1;
            }
            try {
                limit = this.mInputStream.read(bArr, 0, limit);
                String str2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder("Ahttp read from net readByte = ");
                stringBuilder2.append(limit);
                Log.i(str2, stringBuilder2.toString());
                if (limit != -1) {
                    byteBuffer2.put(bArr, 0, limit);
                    if (this.mUseCache != null) {
                        try {
                            this.mFileBuf.write(this.mCurPos, bArr, 0, limit);
                        } catch (ByteBuffer byteBuffer22) {
                            byteBuffer22.printStackTrace();
                            this.mUseCache = false;
                        }
                    }
                    long j = (long) limit;
                    this.mCurPos += j;
                    this.mCurHttpPos += j;
                }
                return limit;
            } catch (ByteBuffer byteBuffer222) {
                byteBuffer222.printStackTrace();
                return -1;
            }
        } catch (ByteBuffer byteBuffer2222) {
            byteBuffer2222.printStackTrace();
            String str3 = TAG;
            StringBuilder stringBuilder3 = new StringBuilder("read Ahttp failed:");
            stringBuilder3.append(byteBuffer2222);
            Log.e(str3, stringBuilder3.toString());
            return -1;
        }
    }

    public long seek(int i, int i2) {
        StringBuilder stringBuilder;
        try {
            String str = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("Ahttp seek offset = ");
            stringBuilder2.append(i);
            stringBuilder2.append("whence = ");
            stringBuilder2.append(i2);
            Log.i(str, stringBuilder2.toString());
            if (65536 == i2) {
                getFileSize();
                return this.mFileSize;
            }
            long j;
            if (i2 == 0) {
                j = (long) i;
            } else if (1 == i2) {
                j = this.mCurPos + ((long) i);
            } else if (2 == i2) {
                getFileSize();
                j = this.mFileSize - ((long) i);
            } else {
                i = TAG;
                stringBuilder = new StringBuilder("Ahttp seek whence = ");
                stringBuilder.append(i2);
                Log.e(i, stringBuilder.toString());
                return -1;
            }
            this.mCurPos = j;
            return 1;
        } catch (int i3) {
            i3.printStackTrace();
            i2 = TAG;
            stringBuilder = new StringBuilder("seek Ahttp failed:");
            stringBuilder.append(i3);
            Log.e(i2, stringBuilder.toString());
            return -1;
        }
    }

    public boolean deleteCache(String str) {
        str = stringToMD5(str);
        if (str == null) {
            return false;
        }
        if (this.mCacheFileDir == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().toString());
            stringBuilder.append("/ahttp/");
            this.mCacheFileDir = stringBuilder.toString();
        }
        File file = new File(this.mCacheFileDir);
        if (file.isDirectory()) {
            if (file.exists()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.mCacheFileDir);
                stringBuilder2.append(str);
                stringBuilder2.append(".data");
                File file2 = new File(stringBuilder2.toString());
                if (file2.exists() != null) {
                    file2.delete();
                }
                return true;
            }
        }
        return false;
    }

    private void init() {
        this.mInputStream = null;
        this.mHttpConnection = null;
        this.mUrlPath = null;
        this.mCurPos = 0;
        this.mCurHttpPos = 0;
        this.mFileSize = 0;
        this.mCurCacheFileName = "";
        this.mFileBuf = new CacheFile();
    }

    private long getFileSize() {
        if (this.mFileSize != 0) {
            return this.mFileSize;
        }
        if (this.mFileBuf != null) {
            this.mFileSize = this.mFileBuf.getFileSize();
        }
        if (this.mFileSize == 0 && this.mHttpConnection != null) {
            this.mFileSize = (long) this.mHttpConnection.getContentLength();
        }
        return this.mFileSize;
    }

    private boolean seekHttpFile(long j) {
        if (closeHttpFile()) {
            return openHttpFile(j);
        }
        return 0;
    }

    private boolean closeHttpFile() {
        try {
            if (this.mInputStream != null) {
                this.mInputStream.close();
                this.mInputStream = null;
            }
            if (this.mHttpConnection != null) {
                this.mHttpConnection.disconnect();
                this.mHttpConnection = null;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean openHttpFile(long j) {
        this.mCurHttpPos = j;
        try {
            try {
                this.mHttpConnection = (HttpURLConnection) new URL(this.mUrlPath).openConnection();
                this.mHttpConnection.setDoInput(true);
                this.mHttpConnection.setRequestProperty("Accept", "*/*");
                StringBuilder stringBuilder = new StringBuilder("bytes=");
                stringBuilder.append(j);
                stringBuilder.append("-");
                this.mHttpConnection.setRequestProperty("Range", stringBuilder.toString());
                try {
                    this.mHttpConnection.setRequestMethod("GET");
                    try {
                        this.mInputStream = this.mHttpConnection.getInputStream();
                        return true;
                    } catch (long j2) {
                        j2.printStackTrace();
                        return false;
                    }
                } catch (long j22) {
                    j22.printStackTrace();
                    return false;
                }
            } catch (long j222) {
                j222.printStackTrace();
                return false;
            }
        } catch (long j2222) {
            j2222.printStackTrace();
            return false;
        }
    }

    private boolean openBufFile() {
        String stringToMD5 = stringToMD5(this.mUrlPath);
        if (stringToMD5 == null) {
            return false;
        }
        if (this.mCacheFileDir == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().toString());
            stringBuilder.append("/ahttp/");
            this.mCacheFileDir = stringBuilder.toString();
        }
        File file = new File(this.mCacheFileDir);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (!file.isDirectory()) {
            return false;
        }
        this.mCacheFileDirManage = new CacheFileDirManage(this.mCacheFileDir);
        this.mCurCacheFileName = stringToMD5;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.mCacheFileDir);
        stringBuilder.append(stringToMD5);
        stringToMD5 = stringBuilder.toString();
        if (this.mFileBuf != null) {
            return this.mFileBuf.open(stringToMD5);
        }
        return false;
    }

    private boolean closeBufFile() {
        if (this.mFileBuf == null) {
            return false;
        }
        boolean close = this.mFileBuf.close();
        this.mFileBuf = null;
        return close;
    }

    private String stringToMD5(String str) {
        try {
            str = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder(str.length * 2);
            for (byte b : str) {
                int i = b & 255;
                if (i < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i));
            }
            return stringBuilder.toString();
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        } catch (String str22) {
            str22.printStackTrace();
            return null;
        }
    }
}
