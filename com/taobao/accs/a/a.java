package com.taobao.accs.a;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.taobao.accs.client.AccsConfig.ACCS_GROUP;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.internal.ServiceImpl;
import com.taobao.accs.internal.b;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.c;
import com.taobao.accs.utl.i;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    public static final String ACTION_ACCS_CUSTOM_ELECTION;
    public static final String ACTION_ACCS_ELECTION = "com.taobao.accs.intent.action.ELECTION";
    public static final String TAG = "ElectionServiceUtil";
    public static String a = null;
    public static boolean b = false;
    private static File c;
    private static File d;
    private static long e;
    private static final Random f = new Random();

    static {
        StringBuilder stringBuilder = new StringBuilder("com.taobao.accs.intent.action.");
        stringBuilder.append(GlobalConfig.mGroup);
        stringBuilder.append("ELECTION");
        ACTION_ACCS_CUSTOM_ELECTION = stringBuilder.toString();
    }

    public static void a() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.DIRECTORY_DOWNLOADS);
            stringBuilder.append(d());
            c = Environment.getExternalStoragePublicDirectory(stringBuilder.toString());
            String str = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("path=");
            stringBuilder2.append(c);
            ALog.i(str, stringBuilder2.toString(), new Object[0]);
            File file = new File(c, b.ELECTION_SERVICE_ID);
            d = file;
            a = file.getPath();
        } catch (Throwable th) {
            ALog.e(TAG, TAG, th, new Object[0]);
        }
    }

    public static final void a(Context context, a aVar) {
        if (aVar != null) {
            GlobalClientInfo.getInstance(context).setElectionReslt(aVar);
            ThreadPoolExecutorFactory.execute(new b(context, aVar));
        }
    }

    public static final a a(Context context) {
        if (!b()) {
            return new a();
        }
        a electionResult = GlobalClientInfo.getInstance(context).getElectionResult();
        if (electionResult == null) {
            return b(context);
        }
        ALog.i(TAG, "getElectionResult from mem", new Object[]{"host", electionResult.a, "retry", Integer.valueOf(electionResult.b)});
        return electionResult;
    }

    public static final boolean b() {
        if (!b) {
            return i.c();
        }
        ALog.e(TAG, "try Election Fail, disable election!!", new Object[0]);
        return false;
    }

    public static final a b(Context context) {
        a aVar = new a();
        FileInputStream fileInputStream = null;
        try {
            if (c == null) {
                a();
            }
            File file = new File(a);
            if (file.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    String string = jSONObject.getString("package");
                    if (UtilityImpl.packageExist(context, string)) {
                        aVar.a = string;
                        e = jSONObject.getLong("lastFlushTime");
                    }
                    if (System.currentTimeMillis() < e + 86400000) {
                        aVar.b = jSONObject.getInt("retry");
                    } else {
                        e = 0;
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    context = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw context;
                }
            }
            ALog.i(TAG, "getElectionResult", new Object[]{"host", aVar.a, "retry", Integer.valueOf(aVar.b)});
            GlobalClientInfo.getInstance(context).setElectionReslt(aVar);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            context2 = th2;
            ALog.e(TAG, "readFile is error", context2, new Object[0]);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return aVar;
        }
        return aVar;
    }

    public static final void a(Context context, byte[] bArr) {
        if (bArr != null) {
            if (c != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                stringBuilder.append("/accs_blacklist");
                ALog.i(TAG, "saveBlackList", new Object[]{"path", stringBuilder.toString()});
                GlobalClientInfo.getInstance(context).setElectionBlackList(a(bArr));
                ThreadPoolExecutorFactory.execute(new c(context, bArr, r3));
                return;
            }
        }
        ALog.e(TAG, "saveBlackList null", new Object[]{"data", bArr, "path", c});
    }

    public static final void c(Context context) {
        ALog.i(TAG, "clearBlackList", new Object[0]);
        GlobalClientInfo.getInstance(context).setElectionBlackList(null);
        if (c == null) {
            ALog.e(TAG, "clearBlackList path null", new Object[0]);
            return;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c);
            stringBuilder.append("accs_blacklist");
            context = new File(stringBuilder.toString());
            if (context.exists()) {
                context.delete();
            }
        } catch (Context context2) {
            ALog.e(TAG, "clearBlackList", context2, new Object[0]);
        }
    }

    public static final Map<String, Set<Integer>> d(Context context) {
        Map<String, Set<Integer>> electionBlackList = GlobalClientInfo.getInstance(context).getElectionBlackList();
        if (electionBlackList != null) {
            ALog.i(TAG, "getBlackList from mem", new Object[]{electionBlackList.toString()});
            return electionBlackList;
        } else if (c == null) {
            ALog.e(TAG, "getBlackList path null", new Object[0]);
            return null;
        } else {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                stringBuilder.append("accs_blacklist");
                byte[] a = c.a(new File(stringBuilder.toString()));
                if (a != null) {
                    electionBlackList = a(a);
                }
            } catch (Throwable th) {
                ALog.e(TAG, "getBlackList", th, new Object[0]);
            }
            GlobalClientInfo.getInstance(context).setElectionBlackList(electionBlackList);
            return electionBlackList;
        }
    }

    private static Map<String, Set<Integer>> a(byte[] bArr) {
        Map<String, Set<Integer>> map = null;
        if (bArr == null) {
            return null;
        }
        try {
            bArr = new JSONObject(new String(bArr)).getJSONArray(b.ELECTION_KEY_BLACKLIST);
            if (bArr != null && bArr.length() > 0) {
                Map<String, Set<Integer>> hashMap = new HashMap();
                int i = 0;
                while (i < bArr.length()) {
                    try {
                        JSONObject jSONObject = bArr.getJSONObject(i);
                        JSONArray jSONArray = jSONObject.getJSONArray(b.ELECTION_KEY_SDKVS);
                        String string = jSONObject.getString(Constants.KEY_ELECTION_PKG);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            Set hashSet = new HashSet();
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                hashSet.add(Integer.valueOf(jSONArray.getInt(i)));
                            }
                            hashMap.put(string, hashSet);
                        }
                        i++;
                    } catch (Throwable th) {
                        bArr = th;
                        map = hashMap;
                    }
                }
                map = hashMap;
            }
            bArr = TAG;
            String str = "praseBlackList";
            Object[] objArr = new Object[2];
            objArr[0] = b.ELECTION_KEY_BLACKLIST;
            objArr[1] = map == null ? "null" : map.toString();
            ALog.i(bArr, str, objArr);
        } catch (Throwable th2) {
            bArr = th2;
            ALog.e(TAG, "praseBlackList", bArr, new Object[0]);
            return map;
        }
        return map;
    }

    public static final boolean a(Context context, String str, int i) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i != 1) {
            try {
                ALog.w(TAG, "checkApp election version not match", new Object[]{"package", str, "require", Integer.valueOf(i), "self ver", Integer.valueOf(1)});
                return false;
            } catch (Context context2) {
                ALog.e(TAG, "checkApp error", context2, new Object[0]);
            }
        } else if (ServiceImpl.a(str) == 0) {
            ALog.w(TAG, "checkApp is unbinded", new Object[]{"package", str});
            return false;
        } else {
            i = context2.getPackageManager().getApplicationInfo(str, 0);
            if (i == 0) {
                ALog.w(TAG, "checkApp applicaton info null", new Object[]{"package", str});
                return false;
            } else if (i.enabled == 0) {
                ALog.i(TAG, "checkApp is disabled", new Object[]{"package", str});
                return false;
            } else {
                context2 = d(context2);
                if (context2 != null) {
                    ALog.i(TAG, "checkApp", new Object[]{"blackList", context2.toString()});
                    Set set = (Set) context2.get(str);
                    if (set == null || (!set.contains(Integer.valueOf(221)) && set.contains(Integer.valueOf(-1)) == 0)) {
                        Set set2 = (Set) context2.get("*");
                        if (!(set2 == null || (set2.contains(Integer.valueOf(221)) == 0 && set2.contains(Integer.valueOf(-1)) == null))) {
                            ALog.w(TAG, "checkApp in blacklist *", new Object[]{"package", str, "sdkv", Integer.valueOf(221)});
                            return false;
                        }
                    }
                    ALog.w(TAG, "checkApp in blacklist", new Object[]{"package", str, "sdkv", Integer.valueOf(221)});
                    return false;
                }
                z = true;
                return z;
            }
        }
    }

    public static String a(Context context, Map<String, Integer> map) {
        if (map != null) {
            if (map.size() > 0) {
                long j = -1;
                map = map.entrySet().iterator();
                List arrayList = new ArrayList();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    String str = (String) entry.getKey();
                    long intValue = (long) ((Integer) entry.getValue()).intValue();
                    if (intValue > j) {
                        arrayList.clear();
                        j = intValue;
                    }
                    if (intValue == j) {
                        arrayList.add(str);
                    }
                }
                map = (String) arrayList.get(f.nextInt(10000) % arrayList.size());
                if (TextUtils.isEmpty(map)) {
                    map = context.getPackageName();
                    ALog.i(TAG, "localElection localResult null, user curr app", new Object[]{Constants.KEY_ELECTION_PKG, map});
                }
                return map;
            }
        }
        ALog.e(TAG, "localElection failed, packMap null", new Object[0]);
        return null;
    }

    public static final String e(Context context) {
        String str = null;
        try {
            context = context.getPackageManager().resolveService(new Intent(c()), 0);
            if (context == null) {
                ALog.e(TAG, "getResolveService resolveInfo null", new Object[0]);
                return null;
            }
            context = context.serviceInfo;
            if (context != null) {
                if (context.isEnabled()) {
                    context = context.packageName;
                    if (TextUtils.isEmpty(context)) {
                        ALog.e(TAG, "getResolveService clientPack null", new Object[0]);
                        return null;
                    }
                    try {
                        ALog.i(TAG, "getResolveService", new Object[]{"package", context});
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        str = context;
                        context = th2;
                        ALog.e(TAG, "getResolveService error", context, new Object[0]);
                        context = str;
                        return context;
                    }
                    return context;
                }
            }
            ALog.e(TAG, "getResolveService serviceinfo null or disabled", new Object[0]);
            return null;
        } catch (Throwable th3) {
            context = th3;
            ALog.e(TAG, "getResolveService error", context, new Object[0]);
            context = str;
            return context;
        }
    }

    public static String c() {
        if (GlobalConfig.mGroup == ACCS_GROUP.TAOBAO) {
            return "com.taobao.accs.intent.action.ELECTION";
        }
        return ACTION_ACCS_CUSTOM_ELECTION;
    }

    public static String d() {
        if (GlobalConfig.mGroup == ACCS_GROUP.TAOBAO) {
            return "/accs/accs_main/1";
        }
        StringBuilder stringBuilder = new StringBuilder("/accs/");
        stringBuilder.append(GlobalConfig.mGroup);
        stringBuilder.append("/1");
        return stringBuilder.toString();
    }
}
