package android.support.v4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AtomicFile {
    private final File mBackupName;
    private final File mBaseName;

    public AtomicFile(File file) {
        this.mBaseName = file;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".bak");
        this.mBackupName = new File(stringBuilder.toString());
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mBackupName.delete();
    }

    public java.io.FileOutputStream startWrite() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r3.mBaseName;
        r0 = r0.exists();
        if (r0 == 0) goto L_0x0036;
    L_0x0008:
        r0 = r3.mBackupName;
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0031;
    L_0x0010:
        r0 = r3.mBaseName;
        r1 = r3.mBackupName;
        r0 = r0.renameTo(r1);
        if (r0 != 0) goto L_0x0036;
    L_0x001a:
        r0 = new java.lang.StringBuilder;
        r1 = "Couldn't rename file ";
        r0.<init>(r1);
        r1 = r3.mBaseName;
        r0.append(r1);
        r1 = " to backup file ";
        r0.append(r1);
        r1 = r3.mBackupName;
        r0.append(r1);
        goto L_0x0036;
    L_0x0031:
        r0 = r3.mBaseName;
        r0.delete();
    L_0x0036:
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x003e }
        r1 = r3.mBaseName;	 Catch:{ FileNotFoundException -> 0x003e }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x003e }
        goto L_0x0067;
    L_0x003e:
        r0 = r3.mBaseName;
        r0 = r0.getParentFile();
        r0 = r0.mkdirs();
        if (r0 != 0) goto L_0x0060;
    L_0x004a:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r2 = "Couldn't create directory ";
        r1.<init>(r2);
        r2 = r3.mBaseName;
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0060:
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0068 }
        r1 = r3.mBaseName;	 Catch:{ FileNotFoundException -> 0x0068 }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0068 }
    L_0x0067:
        return r0;
    L_0x0068:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r2 = "Couldn't create ";
        r1.<init>(r2);
        r2 = r3.mBaseName;
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.AtomicFile.startWrite():java.io.FileOutputStream");
    }

    public void finishWrite(java.io.FileOutputStream r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = this;
        if (r1 == 0) goto L_0x000e;
    L_0x0002:
        sync(r1);
        r1.close();	 Catch:{ IOException -> 0x000e }
        r1 = r0.mBackupName;	 Catch:{ IOException -> 0x000e }
        r1.delete();	 Catch:{ IOException -> 0x000e }
        return;
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.AtomicFile.finishWrite(java.io.FileOutputStream):void");
    }

    public void failWrite(java.io.FileOutputStream r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0015;
    L_0x0002:
        sync(r2);
        r2.close();	 Catch:{ IOException -> 0x0015 }
        r2 = r1.mBaseName;	 Catch:{ IOException -> 0x0015 }
        r2.delete();	 Catch:{ IOException -> 0x0015 }
        r2 = r1.mBackupName;	 Catch:{ IOException -> 0x0015 }
        r0 = r1.mBaseName;	 Catch:{ IOException -> 0x0015 }
        r2.renameTo(r0);	 Catch:{ IOException -> 0x0015 }
        return;
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.AtomicFile.failWrite(java.io.FileOutputStream):void");
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mBackupName.exists()) {
            this.mBaseName.delete();
            this.mBackupName.renameTo(this.mBaseName);
        }
        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    break;
                }
                i += read;
                read = openRead.available();
                if (read > bArr.length - i) {
                    Object obj = new byte[(read + i)];
                    System.arraycopy(bArr, 0, obj, 0, i);
                    bArr = obj;
                }
            }
            return bArr;
        } finally {
            openRead.close();
        }
    }

    static boolean sync(java.io.FileOutputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        if (r0 == 0) goto L_0x000c;
    L_0x0002:
        r0 = r0.getFD();	 Catch:{ IOException -> 0x000a }
        r0.sync();	 Catch:{ IOException -> 0x000a }
        goto L_0x000c;
    L_0x000a:
        r0 = 0;
        return r0;
    L_0x000c:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.AtomicFile.sync(java.io.FileOutputStream):boolean");
    }
}
