package org.android.spdy;

import android.content.Context;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class SpdyAgent {
    public static final int ACCS_ONLINE_SERVER = 1;
    public static final int ACCS_TEST_SERVER = 0;
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    static final int MODE_QUIC = 256;
    static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    static final int SPDY_DATA_CHUNK_RECV = 4097;
    static final int SPDY_DATA_RECV = 4098;
    static final int SPDY_DATA_SEND = 4099;
    static final int SPDY_PING_RECV = 4101;
    static final int SPDY_REQUEST_RECV = 4102;
    static final int SPDY_SESSION_CLOSE = 4103;
    static final int SPDY_SESSION_CREATE = 4096;
    static final int SPDY_SESSION_FAILED_ERROR = 4105;
    static final int SPDY_STREAM_CLOSE = 4100;
    static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    private static final String TNET_SO_VERSION = "tnet-3.1.11";
    private static Object domainHashLock = new Object();
    private static HashMap<String, Integer> domainHashMap = new HashMap();
    public static volatile boolean enableDebug = false;
    public static volatile boolean enableTimeGaurd = false;
    private static volatile SpdyAgent gSingleInstance = null;
    private static volatile boolean loadSucc = false;
    private static Object lock = new Object();
    private static final Lock r;
    private static final ReentrantReadWriteLock rwLock;
    private static int totalDomain;
    private static final Lock w = rwLock.writeLock();
    private AccsSSLCallback accsSSLCallback;
    private long agentNativePtr;
    private AtomicBoolean closed = new AtomicBoolean();
    private String proxyPassword = null;
    private String proxyUsername = null;
    private HashMap<String, SpdySession> sessionMgr = new HashMap(5);
    private LinkedList<SpdySession> sessionQueue = new LinkedList();

    private native int closeSessionN(long j);

    private static native int configIpStackModeN(int i);

    private native int configLogFileN(String str, int i, int i2);

    private native int configLogFileN(String str, int i, int i2, int i3);

    private static void crashReporter(int i) {
    }

    private native long createSessionN(long j, SpdySession spdySession, int i, byte[] bArr, char c, byte[] bArr2, char c2, byte[] bArr3, byte[] bArr4, Object obj, int i2, int i3, int i4);

    private native int freeAgent(long j);

    private void getPerformance(SpdySession spdySession, SslPermData sslPermData) {
    }

    private native long getSession(long j, byte[] bArr, char c);

    private native long initAgent(int i, int i2, int i3);

    @Deprecated
    public static void inspect(String str) {
    }

    private native void logFileCloseN();

    private native void logFileFlushN();

    private native int setConTimeout(long j, int i);

    private native int setSessionKind(long j, int i);

    public final void close() {
    }

    @Deprecated
    public final void switchAccsServer(int i) {
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        rwLock = reentrantReadWriteLock;
        r = reentrantReadWriteLock.readLock();
    }

    final void clearSpdySession(String str, String str2, int i) {
        if (str != null) {
            w.lock();
            if (str != null) {
                try {
                    HashMap hashMap = this.sessionMgr;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str2);
                    stringBuilder.append(i);
                    hashMap.remove(stringBuilder.toString());
                } catch (Throwable th) {
                    w.unlock();
                }
            }
            w.unlock();
        }
    }

    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, null);
                }
            }
        }
        return gSingleInstance;
    }

    public static boolean checkLoadSucc() {
        return loadSucc;
    }

    @Deprecated
    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, accsSSLCallback);
                }
            }
        }
        return gSingleInstance;
    }

    private int getDomainHashIndex(String str) {
        Integer num;
        synchronized (domainHashLock) {
            num = (Integer) domainHashMap.get(str);
            if (num == null) {
                HashMap hashMap = domainHashMap;
                int i = totalDomain + 1;
                totalDomain = i;
                hashMap.put(str, Integer.valueOf(i));
                num = Integer.valueOf(totalDomain);
            }
        }
        return num.intValue();
    }

    private SpdyAgent(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws UnsatisfiedLinkError {
        try {
            SoInstallMgrSdk.init(context);
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
        } catch (Context context2) {
            context2.printStackTrace();
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), SslVersion.SLIGHT_VERSION_V1.getint());
            this.accsSSLCallback = accsSSLCallback;
        } catch (Context context22) {
            context22.printStackTrace();
        }
        this.closed.set(null);
    }

    private void checkLoadSo() throws SpdyErrorException {
        if (!loadSucc) {
            try {
                synchronized (lock) {
                    if (loadSucc) {
                        return;
                    } else {
                        loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
                        this.agentNativePtr = initAgent(0, 0, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            return;
        }
        if (!loadSucc) {
            throw new SpdyErrorException("TNET_JNI_ERR_LOAD_SO_FAIL", (int) TnetStatusCode.TNET_JNI_ERR_LOAD_SO_FAIL);
        }
    }

    public final void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    static void securityCheck(int i, int i2) {
        StringBuilder stringBuilder;
        if (i >= 32768) {
            stringBuilder = new StringBuilder("SPDY_JNI_ERR_INVALID_PARAM:total=");
            stringBuilder.append(i);
            throw new SpdyErrorException(stringBuilder.toString(), (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        } else if (i2 >= 8192) {
            stringBuilder = new StringBuilder("SPDY_JNI_ERR_INVALID_PARAM:value=");
            stringBuilder.append(i2);
            throw new SpdyErrorException(stringBuilder.toString(), (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    static void tableListJudge(int i) {
        if (i >= 5242880) {
            StringBuilder stringBuilder = new StringBuilder("SPDY_JNI_ERR_INVALID_PARAM:total=");
            stringBuilder.append(i);
            throw new SpdyErrorException(stringBuilder.toString(), (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            if ((bArr[i2] & 255) < 32 || (bArr[i2] & 255) > Opcodes.NOT_LONG) {
                bArr[i2] = (byte) 63;
            }
            i2++;
        }
        while (i < bArr2.length) {
            if ((bArr2[i] & 255) < 32 || (bArr2[i] & 255) > 126) {
                bArr2[i] = (byte) 63;
            }
            i++;
        }
    }

    static void headJudge(Map<String, String> map) {
        if (map != null) {
            map = map.entrySet().iterator();
            int i = 0;
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                InvlidCharJudge(str.getBytes(), str2.getBytes());
                i += (str.length() + 1) + str2.length();
                securityCheck(i, str2.length());
            }
        }
    }

    static String mapBodyToString(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map == null) {
            return null;
        }
        map = map.entrySet().iterator();
        int i = 0;
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            stringBuilder.append(str);
            stringBuilder.append('=');
            stringBuilder.append(str2);
            stringBuilder.append('&');
            i += (str.length() + 1) + str2.length();
            tableListJudge(i);
        }
        if (stringBuilder.length() > null) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        spdyRequest = mapBodyToString(spdyDataProvider.postBody);
        if (spdyRequest != null) {
            spdyRequest = spdyRequest.getBytes();
        } else {
            spdyRequest = spdyDataProvider.data;
        }
        if (spdyRequest == null || spdyRequest.length < 5242880) {
            return spdyRequest;
        }
        StringBuilder stringBuilder = new StringBuilder("SPDY_JNI_ERR_INVALID_PARAM:total=");
        stringBuilder.append(spdyRequest.length);
        throw new SpdyErrorException(stringBuilder.toString(), (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    @Deprecated
    public final SpdySession createSession(String str, Object obj, SessionCb sessionCb, int i) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, null, i, 0);
    }

    @Deprecated
    public final SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, int i) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, null, i, 0);
    }

    @Deprecated
    public final SpdySession createSession(String str, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, sslCertcb, i, 0);
    }

    public final SpdySession createSession(SessionInfo sessionInfo) throws SpdyErrorException {
        return createSession(sessionInfo.getAuthority(), sessionInfo.getDomain(), sessionInfo.getSessonUserData(), sessionInfo.getSessionCb(), null, sessionInfo.getMode(), sessionInfo.getPubKeySeqNum(), sessionInfo.getConnectionTimeoutMs());
    }

    @Deprecated
    public final SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i, i2, -1);
    }

    public final org.android.spdy.SpdySession createSession(java.lang.String r25, java.lang.String r26, java.lang.Object r27, org.android.spdy.SessionCb r28, org.android.spdy.SslCertcb r29, int r30, int r31, int r32) throws org.android.spdy.SpdyErrorException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r24 = this;
        r15 = r24;
        r14 = r25;
        r13 = r26;
        r12 = r30;
        if (r14 != 0) goto L_0x0014;
    L_0x000a:
        r1 = new org.android.spdy.SpdyErrorException;
        r2 = "SPDY_JNI_ERR_INVALID_PARAM";
        r3 = -1102; // 0xfffffffffffffbb2 float:NaN double:NaN;
        r1.<init>(r2, r3);
        throw r1;
    L_0x0014:
        r1 = "/";
        r1 = r14.split(r1);
        r16 = 0;
        r2 = r1[r16];
        r3 = ":";
        r11 = r2.split(r3);
        r2 = "0.0.0.0";
        r2 = r2.getBytes();
        r10 = 1;
        r3 = r1.length;
        if (r3 == r10) goto L_0x0049;
    L_0x002e:
        r1 = r1[r10];
        r2 = ":";
        r1 = r1.split(r2);
        r2 = r1[r16];
        r2 = r2.getBytes();
        r1 = r1[r10];
        r1 = java.lang.Integer.parseInt(r1);
        r1 = (char) r1;
        r18 = r1;
        r17 = r2;
        r9 = r14;
        goto L_0x005f;
    L_0x0049:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r14);
        r3 = "/0.0.0.0:0";
        r1.append(r3);
        r1 = r1.toString();
        r9 = r1;
        r17 = r2;
        r18 = r16;
    L_0x005f:
        r24.agentIsOpen();
        r1 = r;
        r1.lock();
        r1 = r15.sessionMgr;	 Catch:{ all -> 0x01ea }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ea }
        r2.<init>();	 Catch:{ all -> 0x01ea }
        r2.append(r9);	 Catch:{ all -> 0x01ea }
        r2.append(r13);	 Catch:{ all -> 0x01ea }
        r2.append(r12);	 Catch:{ all -> 0x01ea }
        r2 = r2.toString();	 Catch:{ all -> 0x01ea }
        r1 = r1.get(r2);	 Catch:{ all -> 0x01ea }
        r1 = (org.android.spdy.SpdySession) r1;	 Catch:{ all -> 0x01ea }
        r2 = r15.sessionMgr;	 Catch:{ all -> 0x01ea }
        r2 = r2.size();	 Catch:{ all -> 0x01ea }
        r3 = 50;
        if (r2 < r3) goto L_0x008d;
    L_0x008b:
        r2 = r10;
        goto L_0x008f;
    L_0x008d:
        r2 = r16;
    L_0x008f:
        r3 = r;
        r3.unlock();
        if (r2 == 0) goto L_0x00a0;
    L_0x0096:
        r1 = new org.android.spdy.SpdyErrorException;
        r2 = "SPDY_SESSION_EXCEED_MAXED: session count exceed max";
        r3 = -1105; // 0xfffffffffffffbaf float:NaN double:NaN;
        r1.<init>(r2, r3);
        throw r1;
    L_0x00a0:
        if (r1 == 0) goto L_0x00a6;
    L_0x00a2:
        r1.increRefCount();
        return r1;
    L_0x00a6:
        r1 = w;
        r1.lock();
        r19 = 0;
        r1 = r15.sessionMgr;	 Catch:{ Throwable -> 0x00c8 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c8 }
        r2.<init>();	 Catch:{ Throwable -> 0x00c8 }
        r2.append(r9);	 Catch:{ Throwable -> 0x00c8 }
        r2.append(r13);	 Catch:{ Throwable -> 0x00c8 }
        r2.append(r12);	 Catch:{ Throwable -> 0x00c8 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00c8 }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x00c8 }
        r1 = (org.android.spdy.SpdySession) r1;	 Catch:{ Throwable -> 0x00c8 }
        goto L_0x00ca;
    L_0x00c8:
        r1 = r19;
    L_0x00ca:
        if (r1 == 0) goto L_0x00d5;
    L_0x00cc:
        r2 = w;
        r2.unlock();
        r1.increRefCount();
        return r1;
    L_0x00d5:
        r8 = new org.android.spdy.SpdySession;	 Catch:{ all -> 0x01e1 }
        r2 = 0;	 Catch:{ all -> 0x01e1 }
        r1 = r8;	 Catch:{ all -> 0x01e1 }
        r4 = r15;	 Catch:{ all -> 0x01e1 }
        r5 = r9;	 Catch:{ all -> 0x01e1 }
        r6 = r13;	 Catch:{ all -> 0x01e1 }
        r7 = r28;	 Catch:{ all -> 0x01e1 }
        r20 = r8;	 Catch:{ all -> 0x01e1 }
        r8 = r12;	 Catch:{ all -> 0x01e1 }
        r21 = r9;	 Catch:{ all -> 0x01e1 }
        r9 = r31;	 Catch:{ all -> 0x01e1 }
        r22 = r10;	 Catch:{ all -> 0x01e1 }
        r10 = r27;	 Catch:{ all -> 0x01e1 }
        r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x01e1 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01e1 }
        r1.<init>();	 Catch:{ all -> 0x01e1 }
        r1.append(r13);	 Catch:{ all -> 0x01e1 }
        r1.append(r12);	 Catch:{ all -> 0x01e1 }
        r1 = r1.toString();	 Catch:{ all -> 0x01e1 }
        r5 = r15.getDomainHashIndex(r1);	 Catch:{ all -> 0x01e1 }
        r1 = r15.proxyUsername;	 Catch:{ all -> 0x01e1 }
        if (r1 == 0) goto L_0x0142;
    L_0x0104:
        r1 = r15.proxyPassword;	 Catch:{ all -> 0x013d }
        if (r1 == 0) goto L_0x0142;	 Catch:{ all -> 0x013d }
    L_0x0108:
        r2 = r15.agentNativePtr;	 Catch:{ all -> 0x013d }
        r1 = r11[r16];	 Catch:{ all -> 0x013d }
        r6 = r1.getBytes();	 Catch:{ all -> 0x013d }
        r1 = r11[r22];	 Catch:{ all -> 0x013d }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ all -> 0x013d }
        r7 = (char) r1;	 Catch:{ all -> 0x013d }
        r1 = r15.proxyUsername;	 Catch:{ all -> 0x013d }
        r10 = r1.getBytes();	 Catch:{ all -> 0x013d }
        r1 = r15.proxyPassword;	 Catch:{ all -> 0x013d }
        r11 = r1.getBytes();	 Catch:{ all -> 0x013d }
        r1 = r15;
        r4 = r20;
        r8 = r17;
        r9 = r18;
        r12 = r27;
        r13 = r30;
        r14 = r31;
        r15 = r32;
        r1 = r1.createSessionN(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ all -> 0x0137 }
        goto L_0x0166;
    L_0x0137:
        r0 = move-exception;
        r2 = r0;
        r1 = r24;
        goto L_0x01e4;
    L_0x013d:
        r0 = move-exception;
        r2 = r0;
        r1 = r15;
        goto L_0x01e4;
    L_0x0142:
        r2 = r15.agentNativePtr;	 Catch:{ all -> 0x01e1 }
        r1 = r11[r16];	 Catch:{ all -> 0x01e1 }
        r6 = r1.getBytes();	 Catch:{ all -> 0x01e1 }
        r1 = r11[r22];	 Catch:{ all -> 0x01e1 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ all -> 0x01e1 }
        r7 = (char) r1;
        r10 = 0;
        r11 = 0;
        r1 = r15;
        r4 = r20;
        r8 = r17;
        r9 = r18;
        r12 = r27;
        r13 = r30;
        r14 = r31;
        r15 = r32;
        r1 = r1.createSessionN(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ all -> 0x01dd }
    L_0x0166:
        r3 = "tnet-jni";	 Catch:{ all -> 0x01dd }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01dd }
        r5 = " create new session: ";	 Catch:{ all -> 0x01dd }
        r4.<init>(r5);	 Catch:{ all -> 0x01dd }
        r5 = r25;	 Catch:{ all -> 0x01dd }
        r4.append(r5);	 Catch:{ all -> 0x01dd }
        r4 = r4.toString();	 Catch:{ all -> 0x01dd }
        org.android.spdy.spduLog.Logi(r3, r4);	 Catch:{ all -> 0x01dd }
        r3 = 1;	 Catch:{ all -> 0x01dd }
        r5 = r1 & r3;	 Catch:{ all -> 0x01dd }
        r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));	 Catch:{ all -> 0x01dd }
        r3 = 0;	 Catch:{ all -> 0x01dd }
        if (r7 != 0) goto L_0x018b;	 Catch:{ all -> 0x01dd }
    L_0x0185:
        r1 = r1 >> r22;	 Catch:{ all -> 0x01dd }
        r1 = (int) r1;	 Catch:{ all -> 0x01dd }
        r5 = r1;	 Catch:{ all -> 0x01dd }
        r1 = r3;	 Catch:{ all -> 0x01dd }
        goto L_0x018d;	 Catch:{ all -> 0x01dd }
    L_0x018b:
        r5 = r16;	 Catch:{ all -> 0x01dd }
    L_0x018d:
        r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ all -> 0x01dd }
        if (r6 == 0) goto L_0x01bf;	 Catch:{ all -> 0x01dd }
    L_0x0191:
        r3 = r20;	 Catch:{ all -> 0x01dd }
        r3.setSessionNativePtr(r1);	 Catch:{ all -> 0x01dd }
        r1 = r24;
        r2 = r1.sessionMgr;	 Catch:{ all -> 0x01bd }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01bd }
        r4.<init>();	 Catch:{ all -> 0x01bd }
        r14 = r21;	 Catch:{ all -> 0x01bd }
        r4.append(r14);	 Catch:{ all -> 0x01bd }
        r5 = r26;	 Catch:{ all -> 0x01bd }
        r4.append(r5);	 Catch:{ all -> 0x01bd }
        r5 = r30;	 Catch:{ all -> 0x01bd }
        r4.append(r5);	 Catch:{ all -> 0x01bd }
        r4 = r4.toString();	 Catch:{ all -> 0x01bd }
        r2.put(r4, r3);	 Catch:{ all -> 0x01bd }
        r2 = r1.sessionQueue;	 Catch:{ all -> 0x01bd }
        r2.add(r3);	 Catch:{ all -> 0x01bd }
        r19 = r3;	 Catch:{ all -> 0x01bd }
        goto L_0x01d7;	 Catch:{ all -> 0x01bd }
    L_0x01bd:
        r0 = move-exception;	 Catch:{ all -> 0x01bd }
        goto L_0x01e3;	 Catch:{ all -> 0x01bd }
    L_0x01bf:
        r1 = r24;	 Catch:{ all -> 0x01bd }
        if (r5 == 0) goto L_0x01d7;	 Catch:{ all -> 0x01bd }
    L_0x01c3:
        r2 = new org.android.spdy.SpdyErrorException;	 Catch:{ all -> 0x01bd }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01bd }
        r4 = "create session error: ";	 Catch:{ all -> 0x01bd }
        r3.<init>(r4);	 Catch:{ all -> 0x01bd }
        r3.append(r5);	 Catch:{ all -> 0x01bd }
        r3 = r3.toString();	 Catch:{ all -> 0x01bd }
        r2.<init>(r3, r5);	 Catch:{ all -> 0x01bd }
        throw r2;	 Catch:{ all -> 0x01bd }
    L_0x01d7:
        r2 = w;
        r2.unlock();
        return r19;
    L_0x01dd:
        r0 = move-exception;
        r1 = r24;
        goto L_0x01e3;
    L_0x01e1:
        r0 = move-exception;
        r1 = r15;
    L_0x01e3:
        r2 = r0;
    L_0x01e4:
        r3 = w;
        r3.unlock();
        throw r2;
    L_0x01ea:
        r0 = move-exception;
        r1 = r15;
        r2 = r0;
        r3 = r;
        r3.unlock();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.SpdyAgent.createSession(java.lang.String, java.lang.String, java.lang.Object, org.android.spdy.SessionCb, org.android.spdy.SslCertcb, int, int, int):org.android.spdy.SpdySession");
    }

    @Deprecated
    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, 0, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    @Deprecated
    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, i2, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i, int i2) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i, i2);
    }

    @Deprecated
    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i);
    }

    private void agentIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", (int) TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
        checkLoadSo();
    }

    final void removeSession(SpdySession spdySession) {
        w.lock();
        try {
            this.sessionQueue.remove(spdySession);
        } finally {
            w.unlock();
        }
    }

    final int closeSession(long j) {
        return closeSessionN(j);
    }

    static String[] mapToByteArray(Map<String, String> map) {
        if (map != null) {
            if (map.size() > 0) {
                String[] strArr = new String[(map.size() * 2)];
                map = map.entrySet().iterator();
                int i = 0;
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    strArr[i] = (String) entry.getKey();
                    strArr[i + 1] = (String) entry.getValue();
                    i += 2;
                }
                return strArr;
            }
        }
        return null;
    }

    static Map<String, List<String>> stringArrayToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        Map hashMap = new HashMap(5);
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 <= strArr.length) {
                if (strArr[i] == null) {
                    break;
                }
                int i3 = i + 1;
                if (strArr[i3] == null) {
                    break;
                }
                List list = (List) hashMap.get(strArr[i]);
                if (list == null) {
                    list = new ArrayList(1);
                    hashMap.put(strArr[i], list);
                }
                list.add(strArr[i3]);
                i = i2;
            } else {
                return hashMap;
            }
        }
        return null;
    }

    @Deprecated
    public final int setSessionKind(SpdySessionKind spdySessionKind) {
        agentIsOpen();
        try {
            return setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (SpdySessionKind spdySessionKind2) {
            spdySessionKind2.printStackTrace();
            return -1;
        }
    }

    @Deprecated
    public final int setConnectTimeOut(int i) {
        agentIsOpen();
        try {
            return setConTimeout(this.agentNativePtr, i);
        } catch (int i2) {
            i2.printStackTrace();
            return 0;
        }
    }

    public final void setAccsSslCallback(AccsSSLCallback accsSSLCallback) {
        StringBuilder stringBuilder = new StringBuilder("[setAccsSslCallback] - ");
        stringBuilder.append(accsSSLCallback.getClass());
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        this.accsSSLCallback = accsSSLCallback;
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, int i, SpdyByteArray spdyByteArray, int i2) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataChunkRecvCB(spdySession, z, j, spdyByteArray, i2);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataRecvCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataSendCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i, int i2, int i3, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyStreamCloseCallback(spdySession, j, i2, i3, superviseData);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyPingRecvCallback(spdySession, (long) i, obj);
        }
    }

    private void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyCustomControlFrameRecvCallback(spdySession, obj, i, i2, i3, i4, bArr);
        }
    }

    private void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyCustomControlFrameFailCallback(spdySession, obj, i, i2);
        }
    }

    private void bioPingRecvCallback(SpdySession spdySession, int i) {
        spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.bioPingRecvCallback(spdySession, i);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i, int i2) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
        } else if (spdySession.intenalcb == 0) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyRequestRecvCallback(spdySession, j, i2);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i, String[] strArr, int i2) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        Map stringArrayToMap = stringArrayToMap(strArr);
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
        } else if (spdySession.intenalcb == 0) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyOnStreamResponse(spdySession, j, stringArrayToMap, i2);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        StringBuilder stringBuilder = new StringBuilder("[spdySessionCloseCallback] - errorCode = ");
        stringBuilder.append(i);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
            }
            spdySession.cleanUp();
        } catch (Throwable th) {
            spdySession.cleanUp();
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionFailedError(spdySession, i, obj);
            }
            spdySession.cleanUp();
        } catch (Throwable th) {
            spdySession.cleanUp();
        }
    }

    private void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionOnWritable(spdySession, obj, i);
            }
        } catch (SpdySession spdySession2) {
            i = new StringBuilder("[spdySessionOnWritable] - exception:");
            i.append(spdySession2);
            spduLog.Loge("tnet-jni", i.toString());
        }
    }

    private byte[] getSSLPublicKey(int i, byte[] bArr) {
        if (this.accsSSLCallback != null) {
            return this.accsSSLCallback.getSSLPublicKey(i, bArr);
        }
        spduLog.Logd("tnet-jni", "[getSSLPublicKey] - accsSSLCallback is null.");
        return 0;
    }

    private int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session is null");
            return -1;
        } else if (spdySession.intenalcb != null) {
            return spdySession.intenalcb.putSSLMeta(spdySession, bArr);
        } else {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session.intenalcb is null");
            return -1;
        }
    }

    private byte[] getSSLMeta(SpdySession spdySession) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session is null");
            return null;
        } else if (spdySession.intenalcb != null) {
            return spdySession.intenalcb.getSSLMeta(spdySession);
        } else {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session.intenalcb is null");
            return null;
        }
    }

    public final HashMap<String, SpdySession> getAllSession() {
        return this.sessionMgr;
    }

    public final int configLogFile(String str, int i, int i2) {
        return loadSucc ? configLogFileN(str, i, i2) : -1;
    }

    public final int configLogFile(String str, int i, int i2, int i3) {
        return loadSucc ? configLogFileN(str, i, i2, i3) : -1;
    }

    public final void logFileFlush() {
        if (loadSucc) {
            logFileFlushN();
        }
    }

    public final void logFileClose() {
        if (loadSucc) {
            logFileFlushN();
            logFileCloseN();
        }
    }

    public static int configIpStackMode(int i) {
        StringBuilder stringBuilder = new StringBuilder("[configIpStackMode] - ");
        stringBuilder.append(i);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        return configIpStackModeN(i);
    }
}
