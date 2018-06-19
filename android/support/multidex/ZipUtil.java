package android.support.multidex;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    static class CentralDirectory {
        long offset;
        long size;

        CentralDirectory() {
        }
    }

    ZipUtil() {
    }

    static long getZipCrc(File file) throws IOException {
        long j = "r";
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, j);
        try {
            j = computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
            return j;
        } finally {
            randomAccessFile.close();
        }
    }

    static CentralDirectory findCentralDirectory(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length < 0) {
            StringBuilder stringBuilder = new StringBuilder("File too short to be a zip file: ");
            stringBuilder.append(randomAccessFile.length());
            throw new ZipException(stringBuilder.toString());
        }
        long j2 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(ENDSIG);
        while (true) {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() != reverseBytes) {
                long j3 = length - 1;
                if (j3 < j) {
                    throw new ZipException("End Of Central Directory signature not found");
                }
                length = j3;
            } else {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                CentralDirectory centralDirectory = new CentralDirectory();
                centralDirectory.size = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                centralDirectory.offset = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return centralDirectory;
            }
        }
    }

    static long computeCrcOfCentralDir(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = centralDirectory.size;
        randomAccessFile.seek(centralDirectory.offset);
        byte[] bArr = new byte[16384];
        centralDirectory = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        while (centralDirectory != -1) {
            crc32.update(bArr, 0, centralDirectory);
            long j2 = j - ((long) centralDirectory);
            if (j2 == 0) {
                break;
            }
            centralDirectory = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j2));
            j = j2;
        }
        return crc32.getValue();
    }
}
