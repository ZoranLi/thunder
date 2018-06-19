package com.tencent.bugly.beta.tinker;

import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

/* compiled from: BUGLY */
public class TinkerReport {
    public static final int KEY_APPLIED = 5;
    public static final int KEY_APPLIED_DEXOPT_EXIST = 122;
    public static final int KEY_APPLIED_DEXOPT_FORMAT = 123;
    public static final int KEY_APPLIED_DEXOPT_OTHER = 121;
    public static final int KEY_APPLIED_DEX_EXTRACT = 182;
    public static final int KEY_APPLIED_EXCEPTION = 120;
    public static final int KEY_APPLIED_FAIL_COST_10S_LESS = 206;
    public static final int KEY_APPLIED_FAIL_COST_30S_LESS = 207;
    public static final int KEY_APPLIED_FAIL_COST_5S_LESS = 205;
    public static final int KEY_APPLIED_FAIL_COST_60S_LESS = 208;
    public static final int KEY_APPLIED_FAIL_COST_OTHER = 209;
    public static final int KEY_APPLIED_INFO_CORRUPTED = 124;
    public static final int KEY_APPLIED_LIB_EXTRACT = 183;
    public static final int KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 153;
    public static final int KEY_APPLIED_PACKAGE_CHECK_DEX_META = 151;
    public static final int KEY_APPLIED_PACKAGE_CHECK_LIB_META = 152;
    public static final int KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND = 155;
    public static final int KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 154;
    public static final int KEY_APPLIED_PACKAGE_CHECK_RES_META = 157;
    public static final int KEY_APPLIED_PACKAGE_CHECK_SIGNATURE = 150;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 158;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 156;
    public static final int KEY_APPLIED_PATCH_FILE_EXTRACT = 181;
    public static final int KEY_APPLIED_RESOURCE_EXTRACT = 184;
    public static final int KEY_APPLIED_START = 4;
    public static final int KEY_APPLIED_SUCC_COST_10S_LESS = 201;
    public static final int KEY_APPLIED_SUCC_COST_30S_LESS = 202;
    public static final int KEY_APPLIED_SUCC_COST_5S_LESS = 200;
    public static final int KEY_APPLIED_SUCC_COST_60S_LESS = 203;
    public static final int KEY_APPLIED_SUCC_COST_OTHER = 204;
    public static final int KEY_APPLIED_UPGRADE = 100;
    public static final int KEY_APPLIED_UPGRADE_FAIL = 101;
    public static final int KEY_APPLIED_VERSION_CHECK = 180;
    public static final int KEY_APPLY_WITH_RETRY = 10;
    public static final int KEY_CRASH_CAUSE_XPOSED_ART = 9;
    public static final int KEY_CRASH_CAUSE_XPOSED_DALVIK = 8;
    public static final int KEY_CRASH_FAST_PROTECT = 7;
    public static final int KEY_DOWNLOAD = 1;
    public static final int KEY_LOADED = 6;
    public static final int KEY_LOADED_EXCEPTION_DEX = 252;
    public static final int KEY_LOADED_EXCEPTION_DEX_CHECK = 253;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE = 254;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE_CHECK = 255;
    public static final int KEY_LOADED_INFO_CORRUPTED = 309;
    public static final int KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR = 450;
    public static final int KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR = 451;
    public static final int KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK = 452;
    public static final int KEY_LOADED_MISMATCH_DEX = 300;
    public static final int KEY_LOADED_MISMATCH_LIB = 301;
    public static final int KEY_LOADED_MISMATCH_RESOURCE = 302;
    public static final int KEY_LOADED_MISSING_DEX = 303;
    public static final int KEY_LOADED_MISSING_DEX_OPT = 307;
    public static final int KEY_LOADED_MISSING_LIB = 304;
    public static final int KEY_LOADED_MISSING_PATCH_FILE = 305;
    public static final int KEY_LOADED_MISSING_PATCH_INFO = 306;
    public static final int KEY_LOADED_MISSING_RES = 308;
    public static final int KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 353;
    public static final int KEY_LOADED_PACKAGE_CHECK_DEX_META = 351;
    public static final int KEY_LOADED_PACKAGE_CHECK_LIB_META = 352;
    public static final int KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND = 356;
    public static final int KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 354;
    public static final int KEY_LOADED_PACKAGE_CHECK_RES_META = 357;
    public static final int KEY_LOADED_PACKAGE_CHECK_SIGNATURE = 350;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 358;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 355;
    public static final int KEY_LOADED_SUCC_COST_1000_LESS = 401;
    public static final int KEY_LOADED_SUCC_COST_3000_LESS = 402;
    public static final int KEY_LOADED_SUCC_COST_5000_LESS = 403;
    public static final int KEY_LOADED_SUCC_COST_500_LESS = 400;
    public static final int KEY_LOADED_SUCC_COST_OTHER = 404;
    public static final int KEY_LOADED_UNCAUGHT_EXCEPTION = 251;
    public static final int KEY_LOADED_UNKNOWN_EXCEPTION = 250;
    public static final int KEY_REQUEST = 0;
    public static final int KEY_TRY_APPLY = 2;
    public static final int KEY_TRY_APPLY_ALREADY_APPLY = 77;
    public static final int KEY_TRY_APPLY_CONDITION_NOT_SATISFIED = 80;
    public static final int KEY_TRY_APPLY_CRASH_LIMIT = 79;
    public static final int KEY_TRY_APPLY_DISABLE = 71;
    public static final int KEY_TRY_APPLY_GOOGLEPLAY = 75;
    public static final int KEY_TRY_APPLY_INSERVICE = 73;
    public static final int KEY_TRY_APPLY_JIT = 81;
    public static final int KEY_TRY_APPLY_MEMORY_LIMIT = 78;
    public static final int KEY_TRY_APPLY_NOT_EXIST = 74;
    public static final int KEY_TRY_APPLY_ROM_SPACE = 76;
    public static final int KEY_TRY_APPLY_RUNNING = 72;
    public static final int KEY_TRY_APPLY_SUCCESS = 3;
    public static final int KEY_TRY_APPLY_UPGRADE = 70;
    private static final String TAG = "Tinker.TinkerReport";
    private static Reporter reporter;

    /* compiled from: BUGLY */
    public interface Reporter {
        void onReport(int i);

        void onReport(String str);
    }

    public void setReporter(Reporter reporter) {
        reporter = reporter;
    }

    public static void onTryApply(boolean z) {
        if (reporter != null) {
            reporter.onReport(2);
            reporter.onReport(70);
            if (z) {
                reporter.onReport(3);
            }
        }
    }

    public static void onTryApplyFail(int i) {
        if (reporter != null) {
            switch (i) {
                case -24:
                    reporter.onReport(80);
                    break;
                case -23:
                    reporter.onReport(79);
                    return;
                case -22:
                    reporter.onReport(78);
                    return;
                case -21:
                    reporter.onReport(76);
                    return;
                case -20:
                    reporter.onReport(75);
                    return;
                default:
                    switch (i) {
                        case -6:
                            reporter.onReport(77);
                            return;
                        case -5:
                            reporter.onReport(81);
                            return;
                        case -4:
                            reporter.onReport(73);
                            return;
                        case -3:
                            reporter.onReport(72);
                            return;
                        case -2:
                            reporter.onReport(74);
                            return;
                        case -1:
                            reporter.onReport(71);
                            return;
                        default:
                            break;
                    }
            }
        }
    }

    public static void onLoadPackageCheckFail(int i) {
        if (reporter != null) {
            switch (i) {
                case -9:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                    break;
                case -8:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_RES_META);
                    return;
                case -7:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL);
                    return;
                case -6:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND);
                    return;
                case -5:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                    return;
                case -4:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_LIB_META);
                    return;
                case -3:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_DEX_META);
                    return;
                case -2:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND);
                    return;
                case -1:
                    reporter.onReport((int) KEY_LOADED_PACKAGE_CHECK_SIGNATURE);
                    return;
                default:
                    break;
            }
        }
    }

    public static void onLoaded(long j) {
        if (reporter != null) {
            reporter.onReport(6);
            if (j < 0) {
                TinkerLog.e(TAG, "hp_report report load cost failed, invalid cost", new Object[0]);
            } else if (j <= 500) {
                reporter.onReport(400);
            } else if (j <= 1000) {
                reporter.onReport(401);
            } else if (j <= 3000) {
                reporter.onReport(402);
            } else if (j <= 5000) {
                reporter.onReport(403);
            } else {
                reporter.onReport(404);
            }
        }
    }

    public static void onLoadInfoCorrupted() {
        if (reporter != null) {
            reporter.onReport(309);
        }
    }

    public static void onLoadFileNotFound(int i) {
        if (reporter != null) {
            switch (i) {
                case 1:
                    reporter.onReport(305);
                    return;
                case 2:
                    reporter.onReport(306);
                    return;
                case 3:
                    reporter.onReport(303);
                    return;
                case 4:
                    reporter.onReport(307);
                    return;
                case 5:
                    reporter.onReport(304);
                    return;
                case 6:
                    reporter.onReport(308);
                    break;
                default:
                    break;
            }
        }
    }

    public static void onLoadInterpretReport(int i, Throwable th) {
        if (reporter != null) {
            StringBuilder stringBuilder;
            switch (i) {
                case 0:
                    reporter.onReport((int) KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK);
                    break;
                case 1:
                    reporter.onReport((int) KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR);
                    i = reporter;
                    stringBuilder = new StringBuilder("Tinker Exception:interpret occur exception ");
                    stringBuilder.append(TinkerUtils.getExceptionCauseString(th));
                    i.onReport(stringBuilder.toString());
                    return;
                case 2:
                    reporter.onReport((int) KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR);
                    i = reporter;
                    stringBuilder = new StringBuilder("Tinker Exception:interpret occur exception ");
                    stringBuilder.append(TinkerUtils.getExceptionCauseString(th));
                    i.onReport(stringBuilder.toString());
                    return;
                default:
                    break;
            }
        }
    }

    public static void onLoadFileMisMatch(int i) {
        if (reporter != null) {
            if (i != 3) {
                switch (i) {
                    case 5:
                        reporter.onReport(301);
                        return;
                    case 6:
                        reporter.onReport(302);
                        break;
                    default:
                        break;
                }
                return;
            }
            reporter.onReport(300);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onLoadException(java.lang.Throwable r4, int r5) {
        /*
        r0 = reporter;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 1;
        r1 = 0;
        switch(r5) {
            case -4: goto L_0x00b2;
            case -3: goto L_0x0064;
            case -2: goto L_0x0015;
            case -1: goto L_0x000c;
            default: goto L_0x000a;
        };
    L_0x000a:
        goto L_0x00b9;
    L_0x000c:
        r5 = reporter;
        r0 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r5.onReport(r0);
        goto L_0x00b9;
    L_0x0015:
        r5 = r4.getMessage();
        r2 = "checkDexInstall failed";
        r5 = r5.contains(r2);
        if (r5 == 0) goto L_0x0043;
    L_0x0021:
        r5 = reporter;
        r2 = 253; // 0xfd float:3.55E-43 double:1.25E-321;
        r5.onReport(r2);
        r5 = "Tinker.TinkerReport";
        r2 = new java.lang.StringBuilder;
        r3 = "tinker dex check fail:";
        r2.<init>(r3);
        r3 = r4.getMessage();
        r2.append(r3);
        r2 = r2.toString();
        r1 = new java.lang.Object[r1];
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r2, r1);
        goto L_0x00ba;
    L_0x0043:
        r5 = reporter;
        r0 = 252; // 0xfc float:3.53E-43 double:1.245E-321;
        r5.onReport(r0);
        r5 = "Tinker.TinkerReport";
        r0 = new java.lang.StringBuilder;
        r2 = "tinker dex reflect fail:";
        r0.<init>(r2);
        r2 = r4.getMessage();
        r0.append(r2);
        r0 = r0.toString();
        r2 = new java.lang.Object[r1];
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r0, r2);
        goto L_0x00b9;
    L_0x0064:
        r5 = r4.getMessage();
        r2 = "checkResInstall failed";
        r5 = r5.contains(r2);
        if (r5 == 0) goto L_0x0091;
    L_0x0070:
        r5 = reporter;
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r5.onReport(r2);
        r5 = "Tinker.TinkerReport";
        r2 = new java.lang.StringBuilder;
        r3 = "tinker res check fail:";
        r2.<init>(r3);
        r3 = r4.getMessage();
        r2.append(r3);
        r2 = r2.toString();
        r1 = new java.lang.Object[r1];
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r2, r1);
        goto L_0x00ba;
    L_0x0091:
        r5 = reporter;
        r0 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        r5.onReport(r0);
        r5 = "Tinker.TinkerReport";
        r0 = new java.lang.StringBuilder;
        r2 = "tinker res reflect fail:";
        r0.<init>(r2);
        r2 = r4.getMessage();
        r0.append(r2);
        r0 = r0.toString();
        r2 = new java.lang.Object[r1];
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r0, r2);
        goto L_0x00b9;
    L_0x00b2:
        r5 = reporter;
        r0 = 251; // 0xfb float:3.52E-43 double:1.24E-321;
        r5.onReport(r0);
    L_0x00b9:
        r0 = r1;
    L_0x00ba:
        if (r0 != 0) goto L_0x00d3;
    L_0x00bc:
        r5 = reporter;
        r0 = new java.lang.StringBuilder;
        r1 = "Tinker Exception:load tinker occur exception ";
        r0.<init>(r1);
        r4 = com.tencent.bugly.beta.tinker.TinkerUtils.getExceptionCauseString(r4);
        r0.append(r4);
        r4 = r0.toString();
        r5.onReport(r4);
    L_0x00d3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerReport.onLoadException(java.lang.Throwable, int):void");
    }

    public static void onApplyPatchServiceStart() {
        if (reporter != null) {
            reporter.onReport(4);
        }
    }

    public static void onApplyDexOptFail(Throwable th) {
        if (reporter != null) {
            if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL)) {
                reporter.onReport(122);
            } else if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL)) {
                reporter.onReport(123);
            } else {
                reporter.onReport(121);
                Reporter reporter = reporter;
                StringBuilder stringBuilder = new StringBuilder("Tinker Exception:apply tinker occur exception ");
                stringBuilder.append(TinkerUtils.getExceptionCauseString(th));
                reporter.onReport(stringBuilder.toString());
            }
        }
    }

    public static void onApplyInfoCorrupted() {
        if (reporter != null) {
            reporter.onReport(124);
        }
    }

    public static void onApplyVersionCheckFail() {
        if (reporter != null) {
            reporter.onReport(180);
        }
    }

    public static void onApplyExtractFail(int i) {
        if (reporter != null) {
            if (i == 1) {
                reporter.onReport(181);
            } else if (i != 3) {
                switch (i) {
                    case 5:
                        reporter.onReport(183);
                        return;
                    case 6:
                        reporter.onReport(184);
                        break;
                    default:
                        break;
                }
            } else {
                reporter.onReport(182);
            }
        }
    }

    public static void onApplied(long j, boolean z) {
        if (reporter != null) {
            if (z) {
                reporter.onReport(5);
            }
            if (z) {
                reporter.onReport(100);
            } else {
                reporter.onReport(101);
            }
            TinkerLog.i(TAG, "hp_report report apply cost = %d", Long.valueOf(j));
            if (j < 0) {
                TinkerLog.e(TAG, "hp_report report apply cost failed, invalid cost", new Object[0]);
            } else if (j <= 5000) {
                if (z) {
                    reporter.onReport(200);
                } else {
                    reporter.onReport(205);
                }
            } else if (j <= 10000) {
                if (z) {
                    reporter.onReport(201);
                } else {
                    reporter.onReport(206);
                }
            } else if (j <= StatisticConfig.MIN_UPLOAD_INTERVAL) {
                if (z) {
                    reporter.onReport(202);
                } else {
                    reporter.onReport(207);
                }
            } else if (j <= 60000) {
                if (z) {
                    reporter.onReport(203);
                } else {
                    reporter.onReport(208);
                }
            } else if (z) {
                reporter.onReport(204);
            } else {
                reporter.onReport(209);
            }
        }
    }

    public static void onApplyPackageCheckFail(int i) {
        if (reporter != null) {
            TinkerLog.i(TAG, "hp_report package check failed, error = %d", Integer.valueOf(i));
            switch (i) {
                case -9:
                    reporter.onReport(158);
                    break;
                case -8:
                    reporter.onReport(157);
                    return;
                case -7:
                    reporter.onReport(156);
                    return;
                case -6:
                    reporter.onReport(154);
                    return;
                case -5:
                    reporter.onReport(153);
                    return;
                case -4:
                    reporter.onReport(152);
                    return;
                case -3:
                    reporter.onReport(151);
                    return;
                case -2:
                    reporter.onReport(155);
                    return;
                case -1:
                    reporter.onReport(150);
                    return;
                default:
                    break;
            }
        }
    }

    public static void onApplyCrash(Throwable th) {
        if (reporter != null) {
            reporter.onReport(120);
            Reporter reporter = reporter;
            StringBuilder stringBuilder = new StringBuilder("Tinker Exception:apply tinker occur exception ");
            stringBuilder.append(TinkerUtils.getExceptionCauseString(th));
            reporter.onReport(stringBuilder.toString());
        }
    }

    public static void onFastCrashProtect() {
        if (reporter != null) {
            reporter.onReport(7);
        }
    }

    public static void onXposedCrash() {
        if (reporter != null) {
            if (ShareTinkerInternals.isVmArt()) {
                reporter.onReport(9);
            } else {
                reporter.onReport(8);
            }
        }
    }

    public static void onReportRetryPatch() {
        if (reporter != null) {
            reporter.onReport(10);
        }
    }
}
