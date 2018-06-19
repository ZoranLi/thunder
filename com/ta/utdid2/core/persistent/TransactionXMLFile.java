package com.ta.utdid2.core.persistent;

import com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor;
import com.ta.utdid2.core.persistent.MySharedPreferences.OnSharedPreferenceChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class TransactionXMLFile {
    private static final Object GLOBAL_COMMIT_LOCK = new Object();
    public static final int MODE_PRIVATE = 0;
    public static final int MODE_WORLD_READABLE = 1;
    public static final int MODE_WORLD_WRITEABLE = 2;
    private File mPreferencesDir;
    private final Object mSync = new Object();
    private HashMap<File, MySharedPreferencesImpl> sSharedPrefs = new HashMap();

    private static final class MySharedPreferencesImpl implements MySharedPreferences {
        private static final Object mContent = new Object();
        private boolean hasChange = false;
        private final File mBackupFile;
        private final File mFile;
        private WeakHashMap<OnSharedPreferenceChangeListener, Object> mListeners;
        private Map mMap;
        private final int mMode;

        public final class EditorImpl implements MyEditor {
            private boolean mClear = null;
            private final Map<String, Object> mModified = new HashMap();

            public final MyEditor putString(String str, String str2) {
                synchronized (this) {
                    this.mModified.put(str, str2);
                }
                return this;
            }

            public final MyEditor putInt(String str, int i) {
                synchronized (this) {
                    this.mModified.put(str, Integer.valueOf(i));
                }
                return this;
            }

            public final MyEditor putLong(String str, long j) {
                synchronized (this) {
                    this.mModified.put(str, Long.valueOf(j));
                }
                return this;
            }

            public final MyEditor putFloat(String str, float f) {
                synchronized (this) {
                    this.mModified.put(str, Float.valueOf(f));
                }
                return this;
            }

            public final MyEditor putBoolean(String str, boolean z) {
                synchronized (this) {
                    this.mModified.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            public final MyEditor remove(String str) {
                synchronized (this) {
                    this.mModified.put(str, this);
                }
                return this;
            }

            public final MyEditor clear() {
                synchronized (this) {
                    this.mClear = true;
                }
                return this;
            }

            public final boolean commit() {
                boolean access$2;
                synchronized (TransactionXMLFile.GLOBAL_COMMIT_LOCK) {
                    boolean z = MySharedPreferencesImpl.this.mListeners.size() > 0;
                    List list = null;
                    Set hashSet;
                    if (z) {
                        list = new ArrayList();
                        hashSet = new HashSet(MySharedPreferencesImpl.this.mListeners.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.mClear) {
                            MySharedPreferencesImpl.this.mMap.clear();
                            this.mClear = false;
                        }
                        for (Entry entry : this.mModified.entrySet()) {
                            String str = (String) entry.getKey();
                            EditorImpl value = entry.getValue();
                            if (value == this) {
                                MySharedPreferencesImpl.this.mMap.remove(str);
                            } else {
                                MySharedPreferencesImpl.this.mMap.put(str, value);
                            }
                            if (z) {
                                list.add(str);
                            }
                        }
                        this.mModified.clear();
                    }
                    access$2 = MySharedPreferencesImpl.this.writeFileLocked();
                    if (access$2) {
                        MySharedPreferencesImpl.this.setHasChange(true);
                    }
                }
                if (z) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        String str2 = (String) list.get(size);
                        for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : r5) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(MySharedPreferencesImpl.this, str2);
                            }
                        }
                    }
                }
                return access$2;
            }
        }

        MySharedPreferencesImpl(File file, int i, Map map) {
            this.mFile = file;
            this.mBackupFile = TransactionXMLFile.makeBackupFile(file);
            this.mMode = i;
            if (map == null) {
                map = new HashMap();
            }
            this.mMap = map;
            this.mListeners = new WeakHashMap();
        }

        public final boolean checkFile() {
            return this.mFile != null && new File(this.mFile.getAbsolutePath()).exists();
        }

        public final void setHasChange(boolean z) {
            synchronized (this) {
                this.hasChange = z;
            }
        }

        public final boolean hasFileChanged() {
            boolean z;
            synchronized (this) {
                z = this.hasChange;
            }
            return z;
        }

        public final void replace(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.mMap = map;
                }
            }
        }

        public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            synchronized (this) {
                this.mListeners.put(onSharedPreferenceChangeListener, mContent);
            }
        }

        public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            synchronized (this) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
            }
        }

        public final Map<String, ?> getAll() {
            Map hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.mMap);
            }
            return hashMap;
        }

        public final String getString(String str, String str2) {
            synchronized (this) {
                str = (String) this.mMap.get(str);
                if (str == null) {
                    str = str2;
                }
            }
            return str;
        }

        public final int getInt(String str, int i) {
            synchronized (this) {
                Integer num = (Integer) this.mMap.get(str);
                if (num != null) {
                    i = num.intValue();
                }
            }
            return i;
        }

        public final long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.mMap.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        public final float getFloat(String str, float f) {
            synchronized (this) {
                Float f2 = (Float) this.mMap.get(str);
                if (f2 != null) {
                    f = f2.floatValue();
                }
            }
            return f;
        }

        public final boolean getBoolean(String str, boolean z) {
            synchronized (this) {
                Boolean bool = (Boolean) this.mMap.get(str);
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            return z;
        }

        public final boolean contains(String str) {
            synchronized (this) {
                str = this.mMap.containsKey(str);
            }
            return str;
        }

        public final MyEditor edit() {
            return new EditorImpl();
        }

        private java.io.FileOutputStream createFileOutputStream(java.io.File r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = 0;
            r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0007 }
            r1.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0007 }
            goto L_0x0019;
        L_0x0007:
            r1 = r3.getParentFile();
            r1 = r1.mkdir();
            if (r1 != 0) goto L_0x0012;
        L_0x0011:
            return r0;
        L_0x0012:
            r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0018 }
            r1.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0018 }
            goto L_0x0019;
        L_0x0018:
            r1 = r0;
        L_0x0019:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.TransactionXMLFile.MySharedPreferencesImpl.createFileOutputStream(java.io.File):java.io.FileOutputStream");
        }

        private boolean writeFileLocked() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.mFile;
            r0 = r0.exists();
            r1 = 0;
            if (r0 == 0) goto L_0x0021;
        L_0x0009:
            r0 = r3.mBackupFile;
            r0 = r0.exists();
            if (r0 != 0) goto L_0x001c;
        L_0x0011:
            r0 = r3.mFile;
            r2 = r3.mBackupFile;
            r0 = r0.renameTo(r2);
            if (r0 != 0) goto L_0x0021;
        L_0x001b:
            return r1;
        L_0x001c:
            r0 = r3.mFile;
            r0.delete();
        L_0x0021:
            r0 = r3.mFile;	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
            r0 = r3.createFileOutputStream(r0);	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
            if (r0 != 0) goto L_0x002a;	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
        L_0x0029:
            return r1;	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
        L_0x002a:
            r2 = r3.mMap;	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
            com.ta.utdid2.core.persistent.XmlUtils.writeMapXml(r2, r0);	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
            r0.close();	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
            r0 = r3.mBackupFile;	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
            r0.delete();	 Catch:{ XmlPullParserException -> 0x0039, XmlPullParserException -> 0x0039 }
            r0 = 1;
            return r0;
        L_0x0039:
            r0 = r3.mFile;
            r0 = r0.exists();
            if (r0 == 0) goto L_0x0046;
        L_0x0041:
            r0 = r3.mFile;
            r0.delete();
        L_0x0046:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.TransactionXMLFile.MySharedPreferencesImpl.writeFileLocked():boolean");
        }
    }

    public TransactionXMLFile(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.mPreferencesDir = new File(str);
    }

    private File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        StringBuilder stringBuilder = new StringBuilder("File ");
        stringBuilder.append(str);
        stringBuilder.append(" contains a path separator");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private File getPreferencesDir() {
        File file;
        synchronized (this.mSync) {
            file = this.mPreferencesDir;
        }
        return file;
    }

    private File getSharedPrefsFile(String str) {
        File preferencesDir = getPreferencesDir();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str));
        stringBuilder.append(".xml");
        return makeFilename(preferencesDir, stringBuilder.toString());
    }

    public com.ta.utdid2.core.persistent.MySharedPreferences getMySharedPreferences(java.lang.String r8, int r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r8 = r7.getSharedPrefsFile(r8);
        r0 = GLOBAL_COMMIT_LOCK;
        monitor-enter(r0);
        r1 = r7.sSharedPrefs;	 Catch:{ all -> 0x00af }
        r1 = r1.get(r8);	 Catch:{ all -> 0x00af }
        r1 = (com.ta.utdid2.core.persistent.TransactionXMLFile.MySharedPreferencesImpl) r1;	 Catch:{ all -> 0x00af }
        if (r1 == 0) goto L_0x0019;	 Catch:{ all -> 0x00af }
    L_0x0011:
        r2 = r1.hasFileChanged();	 Catch:{ all -> 0x00af }
        if (r2 != 0) goto L_0x0019;	 Catch:{ all -> 0x00af }
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        return r1;	 Catch:{ all -> 0x00af }
    L_0x0019:
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        r0 = makeBackupFile(r8);
        r2 = r0.exists();
        if (r2 == 0) goto L_0x002a;
    L_0x0024:
        r8.delete();
        r0.renameTo(r8);
    L_0x002a:
        r0 = r8.exists();
        if (r0 == 0) goto L_0x0033;
    L_0x0030:
        r8.canRead();
    L_0x0033:
        r0 = 0;
        r2 = r8.exists();
        if (r2 == 0) goto L_0x008c;
    L_0x003a:
        r2 = r8.canRead();
        if (r2 == 0) goto L_0x008c;
    L_0x0040:
        r2 = new java.io.FileInputStream;	 Catch:{ XmlPullParserException -> 0x006b, FileNotFoundException -> 0x0066, IOException -> 0x0061, Exception -> 0x005c }
        r2.<init>(r8);	 Catch:{ XmlPullParserException -> 0x006b, FileNotFoundException -> 0x0066, IOException -> 0x0061, Exception -> 0x005c }
        r3 = com.ta.utdid2.core.persistent.XmlUtils.readMapXml(r2);	 Catch:{ XmlPullParserException -> 0x006b, FileNotFoundException -> 0x0066, IOException -> 0x0061, Exception -> 0x005c }
        r2.close();	 Catch:{ XmlPullParserException -> 0x005a, FileNotFoundException -> 0x0056, IOException -> 0x0052, Exception -> 0x004e }
        r0 = r3;
        goto L_0x008c;
    L_0x004e:
        r0 = move-exception;
        r2 = r0;
        r0 = r3;
        goto L_0x005d;
    L_0x0052:
        r0 = move-exception;
        r2 = r0;
        r0 = r3;
        goto L_0x0062;
    L_0x0056:
        r0 = move-exception;
        r2 = r0;
        r0 = r3;
        goto L_0x0067;
    L_0x005a:
        r0 = r3;
        goto L_0x006b;
    L_0x005c:
        r2 = move-exception;
    L_0x005d:
        r2.printStackTrace();
        goto L_0x008c;
    L_0x0061:
        r2 = move-exception;
    L_0x0062:
        r2.printStackTrace();
        goto L_0x008c;
    L_0x0066:
        r2 = move-exception;
    L_0x0067:
        r2.printStackTrace();
        goto L_0x008c;
    L_0x006b:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r2.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r3 = r2.available();	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r3 = new byte[r3];	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r2.read(r3);	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r2 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r4 = 0;	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r5 = r3.length;	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r6 = "UTF-8";	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        r2.<init>(r3, r4, r5, r6);	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0083 }
        goto L_0x008c;
    L_0x0083:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x008c;
    L_0x0088:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x008c:
        r2 = GLOBAL_COMMIT_LOCK;
        monitor-enter(r2);
        if (r1 == 0) goto L_0x0097;
    L_0x0091:
        r1.replace(r0);	 Catch:{ all -> 0x0095 }
        goto L_0x00ab;	 Catch:{ all -> 0x0095 }
    L_0x0095:
        r8 = move-exception;	 Catch:{ all -> 0x0095 }
        goto L_0x00ad;	 Catch:{ all -> 0x0095 }
    L_0x0097:
        r1 = r7.sSharedPrefs;	 Catch:{ all -> 0x0095 }
        r1 = r1.get(r8);	 Catch:{ all -> 0x0095 }
        r1 = (com.ta.utdid2.core.persistent.TransactionXMLFile.MySharedPreferencesImpl) r1;	 Catch:{ all -> 0x0095 }
        if (r1 != 0) goto L_0x00ab;	 Catch:{ all -> 0x0095 }
    L_0x00a1:
        r1 = new com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl;	 Catch:{ all -> 0x0095 }
        r1.<init>(r8, r9, r0);	 Catch:{ all -> 0x0095 }
        r9 = r7.sSharedPrefs;	 Catch:{ all -> 0x0095 }
        r9.put(r8, r1);	 Catch:{ all -> 0x0095 }
    L_0x00ab:
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
        return r1;	 Catch:{ all -> 0x0095 }
    L_0x00ad:
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
        throw r8;
    L_0x00af:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.TransactionXMLFile.getMySharedPreferences(java.lang.String, int):com.ta.utdid2.core.persistent.MySharedPreferences");
    }

    private static File makeBackupFile(File file) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(file.getPath()));
        stringBuilder.append(".bak");
        return new File(stringBuilder.toString());
    }
}
