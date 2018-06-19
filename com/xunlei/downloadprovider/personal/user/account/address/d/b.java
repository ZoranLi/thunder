package com.xunlei.downloadprovider.personal.user.account.address.d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DBCopyUtil */
public final class b implements Runnable {
    final /* synthetic */ Context a;

    public b(Context context) {
        this.a = context;
    }

    public final void run() {
        Exception e;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th;
        File databasePath = this.a.getApplicationContext().getDatabasePath("newregion.db");
        if (!databasePath.exists()) {
            InputStream open;
            File file = new File(databasePath.getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                open = this.a.getAssets().open("newregion.db");
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    open = inputStream;
                    fileOutputStream2 = fileOutputStream;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                open = null;
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            try {
                fileOutputStream = new FileOutputStream(databasePath.getPath());
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3222) {
                        e3222.printStackTrace();
                    }
                } catch (Exception e6) {
                    e = e6;
                    inputStream = open;
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream2 = fileOutputStream;
                    if (open != null) {
                        open.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                inputStream = open;
                e.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th5) {
                th = th5;
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
    }
}
