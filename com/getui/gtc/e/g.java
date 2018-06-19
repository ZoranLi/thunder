package com.getui.gtc.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class g {
    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e2) {
                        new String[1][0] = e2.toString();
                    }
                    try {
                        byteArrayOutputStream.close();
                        return bArr;
                    } catch (Exception e22) {
                        new String[1][0] = e22.toString();
                        return bArr;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        new String[1][0] = e.toString();
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e4) {
                                new String[1][0] = e4.toString();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e42) {
                                new String[1][0] = e42.toString();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e222) {
                                new String[1][0] = e222.toString();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e2222) {
                                new String[1][0] = e2222.toString();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e42 = e5;
                gZIPOutputStream = null;
                new String[1][0] = e42.toString();
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e42 = e6;
            byteArrayOutputStream = null;
            gZIPOutputStream = byteArrayOutputStream;
            new String[1][0] = e42.toString();
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            gZIPOutputStream = byteArrayOutputStream;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        Throwable th;
        Throwable th2;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e3) {
                        new String[1][0] = e3.toString();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e32) {
                        new String[1][0] = e32.toString();
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e322) {
                        new String[1][0] = e322.toString();
                    }
                    return toByteArray;
                } catch (Exception e4) {
                    e = e4;
                    byteArrayOutputStream = null;
                    try {
                        new String[1][0] = e.toString();
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e3222) {
                                new String[1][0] = e3222.toString();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e32222) {
                                new String[1][0] = e32222.toString();
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                                return null;
                            } catch (Exception e322222) {
                                new String[1][0] = e322222.toString();
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e3222222) {
                                new String[1][0] = e3222222.toString();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e32222222) {
                                new String[1][0] = e32222222.toString();
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e322222222) {
                                new String[1][0] = e322222222.toString();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    Throwable th5 = th4;
                    byteArrayOutputStream = null;
                    th = th5;
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                gZIPInputStream = null;
                byteArrayOutputStream = gZIPInputStream;
                new String[1][0] = e.toString();
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                    return null;
                }
                return null;
            } catch (Throwable th6) {
                th2 = th6;
                byteArrayOutputStream = null;
                th = th2;
                gZIPInputStream = byteArrayOutputStream;
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            gZIPInputStream = null;
            byteArrayInputStream = gZIPInputStream;
            byteArrayOutputStream = byteArrayInputStream;
            new String[1][0] = e.toString();
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
                return null;
            }
            return null;
        } catch (Throwable th7) {
            th2 = th7;
            byteArrayInputStream = null;
            byteArrayOutputStream = byteArrayInputStream;
            th = th2;
            gZIPInputStream = byteArrayOutputStream;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }

    public static byte[] c(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream dVar = new d(byteArrayOutputStream);
            a(byteArrayInputStream, dVar);
            dVar.a();
            try {
                byteArrayInputStream.close();
            } catch (Throwable th) {
                new String[1][0] = th.toString();
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                new String[1][0] = th2.toString();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new RuntimeException("Unexpected I/O error", e);
        } catch (Throwable th3) {
            new String[1][0] = th3.toString();
        }
        byteArrayOutputStream.close();
    }
}
