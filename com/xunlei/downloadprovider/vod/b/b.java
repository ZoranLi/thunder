package com.xunlei.downloadprovider.vod.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: SerializableObjectPersistUtil */
public class b {
    private static final String a = "b";

    public static void a(Serializable serializable, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str, str2);
        if (file.exists() != null) {
            file.delete();
        }
        str = null;
        try {
            file.createNewFile();
            str2 = new ObjectOutputStream(new FileOutputStream(file));
            try {
                str2.writeObject(serializable);
                str2.flush();
                try {
                    str2.close();
                } catch (Serializable serializable2) {
                    serializable2.printStackTrace();
                }
            } catch (IOException e) {
                serializable2 = e;
                str = str2;
                try {
                    new StringBuilder("serializeDataToFile error : ").append(serializable2.getMessage());
                    serializable2.printStackTrace();
                    if (str != null) {
                        try {
                            str.close();
                        } catch (Serializable serializable22) {
                            serializable22.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    serializable22 = th;
                    if (str != null) {
                        try {
                            str.close();
                        } catch (String str3) {
                            str3.printStackTrace();
                        }
                    }
                    throw serializable22;
                }
            } catch (Throwable th2) {
                serializable22 = th2;
                str3 = str2;
                if (str3 != null) {
                    str3.close();
                }
                throw serializable22;
            }
        } catch (IOException e2) {
            serializable22 = e2;
            new StringBuilder("serializeDataToFile error : ").append(serializable22.getMessage());
            serializable22.printStackTrace();
            if (str3 != null) {
                str3.close();
            }
        }
    }

    public static Object a(String str, String str2) {
        IOException e;
        ClassNotFoundException e2;
        File file = new File(str, str2);
        if (file.exists() == null) {
            return null;
        }
        try {
            str = new ObjectInputStream(new FileInputStream(file));
            try {
                String readObject = str.readObject();
                try {
                    str.close();
                } catch (String str3) {
                    str3.printStackTrace();
                }
                return readObject;
            } catch (IOException e3) {
                e = e3;
                new StringBuilder("deserializeDataFromFile IO error : ").append(e.getMessage());
                e.printStackTrace();
                if (str3 != null) {
                    return null;
                }
                str3.close();
                return null;
            } catch (ClassNotFoundException e4) {
                e2 = e4;
                try {
                    new StringBuilder("deserializeDataFromFile class error : ").append(e2.getMessage());
                    e2.printStackTrace();
                    if (str3 != null) {
                        return null;
                    }
                    try {
                        str3.close();
                        return null;
                    } catch (String str32) {
                        str32.printStackTrace();
                        return null;
                    }
                } catch (Throwable th) {
                    str2 = th;
                    if (str32 != null) {
                        try {
                            str32.close();
                        } catch (String str322) {
                            str322.printStackTrace();
                        }
                    }
                    throw str2;
                }
            }
        } catch (IOException e5) {
            e = e5;
            str322 = null;
            new StringBuilder("deserializeDataFromFile IO error : ").append(e.getMessage());
            e.printStackTrace();
            if (str322 != null) {
                return null;
            }
            str322.close();
            return null;
        } catch (ClassNotFoundException e6) {
            e2 = e6;
            str322 = null;
            new StringBuilder("deserializeDataFromFile class error : ").append(e2.getMessage());
            e2.printStackTrace();
            if (str322 != null) {
                return null;
            }
            str322.close();
            return null;
        } catch (String str3222) {
            str2 = str3222;
            str3222 = null;
            if (str3222 != null) {
                str3222.close();
            }
            throw str2;
        }
    }
}
