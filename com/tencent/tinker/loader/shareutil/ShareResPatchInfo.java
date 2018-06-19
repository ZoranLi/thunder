package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class ShareResPatchInfo {
    public ArrayList<String> addRes = new ArrayList();
    public String arscBaseCrc = null;
    public ArrayList<String> deleteRes = new ArrayList();
    public HashMap<String, LargeModeInfo> largeModMap = new HashMap();
    public ArrayList<String> largeModRes = new ArrayList();
    public ArrayList<String> modRes = new ArrayList();
    public HashSet<Pattern> patterns = new HashSet();
    public String resArscMd5 = null;
    public HashMap<String, File> storeRes = new HashMap();

    /* compiled from: BUGLY */
    public static class LargeModeInfo {
        public long crc;
        public File file = null;
        public String md5 = null;
    }

    public static void parseAllResPatchInfo(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null) {
            if (str.length() != 0) {
                str = str.split("\n");
                int i = 0;
                while (i < str.length) {
                    String str2 = str[i];
                    if (str2 != null && str2.length() > 0) {
                        if (str2.startsWith(ShareConstants.RES_TITLE)) {
                            String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP, 3);
                            shareResPatchInfo.arscBaseCrc = split[1];
                            shareResPatchInfo.resArscMd5 = split[2];
                        } else if (str2.startsWith(ShareConstants.RES_PATTERN_TITLE)) {
                            for (r2 = Integer.parseInt(str2.split(Constants.COLON_SEPARATOR, 2)[1]); r2 > 0; r2--) {
                                i++;
                                shareResPatchInfo.patterns.add(convertToPatternString(str[i]));
                            }
                        } else if (str2.startsWith(ShareConstants.RES_ADD_TITLE)) {
                            for (r2 = Integer.parseInt(str2.split(Constants.COLON_SEPARATOR, 2)[1]); r2 > 0; r2--) {
                                i++;
                                shareResPatchInfo.addRes.add(str[i]);
                            }
                        } else if (str2.startsWith(ShareConstants.RES_MOD_TITLE)) {
                            for (r2 = Integer.parseInt(str2.split(Constants.COLON_SEPARATOR, 2)[1]); r2 > 0; r2--) {
                                i++;
                                shareResPatchInfo.modRes.add(str[i]);
                            }
                        } else if (str2.startsWith(ShareConstants.RES_LARGE_MOD_TITLE)) {
                            for (r2 = Integer.parseInt(str2.split(Constants.COLON_SEPARATOR, 2)[1]); r2 > 0; r2--) {
                                i++;
                                String[] split2 = str[i].split(Constants.ACCEPT_TIME_SEPARATOR_SP, 3);
                                Object obj = split2[0];
                                LargeModeInfo largeModeInfo = new LargeModeInfo();
                                largeModeInfo.md5 = split2[1];
                                largeModeInfo.crc = Long.parseLong(split2[2]);
                                shareResPatchInfo.largeModRes.add(obj);
                                shareResPatchInfo.largeModMap.put(obj, largeModeInfo);
                            }
                        } else if (str2.startsWith(ShareConstants.RES_DEL_TITLE)) {
                            for (r2 = Integer.parseInt(str2.split(Constants.COLON_SEPARATOR, 2)[1]); r2 > 0; r2--) {
                                i++;
                                shareResPatchInfo.deleteRes.add(str[i]);
                            }
                        } else if (str2.startsWith(ShareConstants.RES_STORE_TITLE)) {
                            for (r2 = Integer.parseInt(str2.split(Constants.COLON_SEPARATOR, 2)[1]); r2 > 0; r2--) {
                                i++;
                                shareResPatchInfo.storeRes.put(str[i], null);
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public static boolean checkFileInPattern(HashSet<Pattern> hashSet, String str) {
        if (!hashSet.isEmpty()) {
            hashSet = hashSet.iterator();
            while (hashSet.hasNext()) {
                if (((Pattern) hashSet.next()).matcher(str).matches()) {
                    return true;
                }
            }
        }
        return null;
    }

    public static boolean checkResPatchInfo(ShareResPatchInfo shareResPatchInfo) {
        if (shareResPatchInfo == null) {
            return false;
        }
        shareResPatchInfo = shareResPatchInfo.resArscMd5;
        if (shareResPatchInfo != null) {
            if (shareResPatchInfo.length() == 32) {
                return true;
            }
        }
        return false;
    }

    private static Pattern convertToPatternString(String str) {
        if (str.contains(".")) {
            str = str.replaceAll("\\.", "\\\\.");
        }
        if (str.contains("?")) {
            str = str.replaceAll("\\?", "\\.");
        }
        if (str.contains("*")) {
            str = str.replace("*", ".*");
        }
        return Pattern.compile(str);
    }

    public static void parseResPatchInfoFirstLine(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null) {
            if (str.length() != 0) {
                String str2 = str.split("\n")[0];
                if (str2 != null) {
                    if (str2.length() > 0) {
                        str = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP, 3);
                        shareResPatchInfo.arscBaseCrc = str[1];
                        shareResPatchInfo.resArscMd5 = str[2];
                        return;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("res meta Corrupted:");
                stringBuilder.append(str);
                throw new TinkerRuntimeException(stringBuilder.toString());
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder("resArscMd5:");
        stringBuilder.append(this.resArscMd5);
        stringBuilder.append("\n");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("arscBaseCrc:");
        stringBuilder.append(this.arscBaseCrc);
        stringBuilder.append("\n");
        stringBuffer.append(stringBuilder.toString());
        Iterator it = this.patterns.iterator();
        while (it.hasNext()) {
            Pattern pattern = (Pattern) it.next();
            StringBuilder stringBuilder2 = new StringBuilder(ShareConstants.RES_PATTERN_TITLE);
            stringBuilder2.append(pattern);
            stringBuilder2.append("\n");
            stringBuffer.append(stringBuilder2.toString());
        }
        it = this.addRes.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            stringBuilder2 = new StringBuilder("addedSet:");
            stringBuilder2.append(str);
            stringBuilder2.append("\n");
            stringBuffer.append(stringBuilder2.toString());
        }
        it = this.modRes.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            stringBuilder2 = new StringBuilder("modifiedSet:");
            stringBuilder2.append(str);
            stringBuilder2.append("\n");
            stringBuffer.append(stringBuilder2.toString());
        }
        it = this.largeModRes.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            stringBuilder2 = new StringBuilder("largeModifiedSet:");
            stringBuilder2.append(str);
            stringBuilder2.append("\n");
            stringBuffer.append(stringBuilder2.toString());
        }
        it = this.deleteRes.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            stringBuilder2 = new StringBuilder("deletedSet:");
            stringBuilder2.append(str);
            stringBuilder2.append("\n");
            stringBuffer.append(stringBuilder2.toString());
        }
        for (String str2 : this.storeRes.keySet()) {
            stringBuilder2 = new StringBuilder("storeSet:");
            stringBuilder2.append(str2);
            stringBuilder2.append("\n");
            stringBuffer.append(stringBuilder2.toString());
        }
        return stringBuffer.toString();
    }
}
