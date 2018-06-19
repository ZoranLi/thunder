package android.support.v4.provider;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {
    private File mFile;

    public boolean isVirtual() {
        return false;
    }

    RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.mFile = file;
    }

    public DocumentFile createFile(String str, String str2) {
        str = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(".");
            stringBuilder.append(str);
            str2 = stringBuilder.toString();
        }
        str = new File(this.mFile, str2);
        try {
            str.createNewFile();
            return new RawDocumentFile(this, str);
        } catch (String str3) {
            new StringBuilder("Failed to createFile: ").append(str3);
            return null;
        }
    }

    public DocumentFile createDirectory(String str) {
        File file = new File(this.mFile, str);
        if (file.isDirectory() == null) {
            if (file.mkdir() == null) {
                return null;
            }
        }
        return new RawDocumentFile(this, file);
    }

    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    public String getName() {
        return this.mFile.getName();
    }

    public String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(this.mFile.getName());
    }

    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    public boolean isFile() {
        return this.mFile.isFile();
    }

    public long lastModified() {
        return this.mFile.lastModified();
    }

    public long length() {
        return this.mFile.length();
    }

    public boolean canRead() {
        return this.mFile.canRead();
    }

    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    public boolean exists() {
        return this.mFile.exists();
    }

    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.mFile.listFiles();
        if (listFiles != null) {
            for (File rawDocumentFile : listFiles) {
                arrayList.add(new RawDocumentFile(this, rawDocumentFile));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean renameTo(String str) {
        File file = new File(this.mFile.getParentFile(), str);
        if (this.mFile.renameTo(file) == null) {
            return null;
        }
        this.mFile = file;
        return true;
    }

    private static String getTypeForName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
            if (str != null) {
                return str;
            }
        }
        return "application/octet-stream";
    }

    private static boolean deleteContents(File file) {
        file = file.listFiles();
        if (file == null) {
            return true;
        }
        boolean z = true;
        for (File file2 : file) {
            if (file2.isDirectory()) {
                z &= deleteContents(file2);
            }
            if (!file2.delete()) {
                new StringBuilder("Failed to delete ").append(file2);
                z = false;
            }
        }
        return z;
    }
}
