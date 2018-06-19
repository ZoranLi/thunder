package com.taobao.tlog.adapter;

import android.content.Context;
import com.qihoo360.replugin.RePlugin;
import com.taobao.accs.common.Constants;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.collect.LogFileUploadManager;
import java.util.HashMap;
import java.util.Map;

public class TLogFileUploader {
    private static boolean isValid = false;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "com.taobao.tao.log.TLog";	 Catch:{ ClassNotFoundException -> 0x0009 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0009 }
        r0 = 1;	 Catch:{ ClassNotFoundException -> 0x0009 }
        isValid = r0;	 Catch:{ ClassNotFoundException -> 0x0009 }
        return;
    L_0x0009:
        r0 = 0;
        isValid = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tlog.adapter.TLogFileUploader.<clinit>():void");
    }

    public static void uploadLogFile(Context context, Map<String, Object> map) {
        uploadLogFile(context, map, null);
    }

    public static void uploadLogFile(Context context, Map<String, Object> map, String str) {
        if (isValid) {
            if (map != null) {
                Object obj = map.get("type");
                if ((obj instanceof String) && "exception".equalsIgnoreCase((String) obj)) {
                    return;
                }
            }
            context = LogFileUploadManager.getInstances(context);
            if (str == null) {
                context.addFiles(TLogUtils.getFilePath(TLogConstant.FILE_PREFIX, 1, null));
            } else {
                context.addFiles(TLogUtils.getFilePath(str, 1, null));
            }
            context.setType("client");
            context.setExtData(map);
            map = new HashMap();
            map.put("userId", RePlugin.PROCESS_UI);
            map.put(Constants.KEY_SERVICE_ID, "motu-remote");
            map.put("serialNumber", RePlugin.PROCESS_UI);
            map.put("taskId", RePlugin.PROCESS_UI);
            context.setReportParams(map);
            context.startUpload();
        }
    }
}
