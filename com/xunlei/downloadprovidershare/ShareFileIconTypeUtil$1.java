package com.xunlei.downloadprovidershare;

import com.umeng.message.MsgConstant;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;

final class ShareFileIconTypeUtil$1 extends HashMap<String, Integer> {
    ShareFileIconTypeUtil$1() {
        r1 = new String[8];
        int i = 0;
        r1[0] = "png";
        r1[1] = "jpeg";
        r1[2] = "bmp";
        r1[3] = "jpg";
        r1[4] = "icon";
        r1[5] = "jpe";
        r1[6] = "gif";
        r1[7] = "jpeg2000";
        for (int i2 = 0; i2 < 8; i2++) {
            put(r1[i2], Integer.valueOf(R.drawable.share_ic_task_file_image));
        }
        put("wmv", Integer.valueOf(R.drawable.share_ic_task_file_wmv));
        put("asf", Integer.valueOf(R.drawable.share_ic_task_file_asf));
        put("asx", Integer.valueOf(R.drawable.share_ic_task_file_asx));
        put("rm", Integer.valueOf(R.drawable.share_ic_task_file_rm));
        put("rmvb", Integer.valueOf(R.drawable.share_ic_task_file_rmvb));
        put("mpg", Integer.valueOf(R.drawable.share_ic_task_file_mpg));
        put("mpeg", Integer.valueOf(R.drawable.share_ic_task_file_mpeg));
        put("mpe", Integer.valueOf(R.drawable.share_ic_task_file_mpe));
        put("3gp", Integer.valueOf(R.drawable.share_ic_task_file_3gp));
        put("mov", Integer.valueOf(R.drawable.share_ic_task_file_mov));
        put("mp4", Integer.valueOf(R.drawable.share_ic_task_file_mp4));
        put("m4v", Integer.valueOf(R.drawable.share_ic_task_file_m4v));
        put("avi", Integer.valueOf(R.drawable.share_ic_task_file_avi));
        put("mkv", Integer.valueOf(R.drawable.share_ic_task_file_mkv));
        put("flv", Integer.valueOf(R.drawable.share_ic_task_file_flv));
        put("f4v", Integer.valueOf(R.drawable.share_ic_task_file_f4v));
        put("vob", Integer.valueOf(R.drawable.share_ic_task_file_vob));
        put(MsgConstant.KEY_TS, Integer.valueOf(R.drawable.share_ic_task_file_ts));
        put("xv", Integer.valueOf(R.drawable.share_ic_task_file_xv));
        put("apk", Integer.valueOf(R.drawable.share_ic_task_file_apk));
        put("rar", Integer.valueOf(R.drawable.share_ic_task_file_rar));
        put("zip", Integer.valueOf(R.drawable.share_ic_task_file_zip));
        put("7zip", Integer.valueOf(R.drawable.share_ic_task_file_7z));
        put("7z", Integer.valueOf(R.drawable.share_ic_task_file_7z));
        put("tgz", Integer.valueOf(R.drawable.share_ic_task_file_tar));
        String[] strArr = new String[]{SocializeConstants.KEY_TEXT, "pdf", "rtf"};
        while (i < 3) {
            put(strArr[i], Integer.valueOf(R.drawable.share_ic_task_file_text));
            i++;
        }
        put("doc", Integer.valueOf(R.drawable.share_ic_task_file_doc));
        put("docx", Integer.valueOf(R.drawable.share_ic_task_file_doc));
        put("xls", Integer.valueOf(R.drawable.share_ic_task_file_xls));
        put("xlsx", Integer.valueOf(R.drawable.share_ic_task_file_xls));
        put("ppt", Integer.valueOf(R.drawable.share_ic_task_file_ppt));
        put("pptx", Integer.valueOf(R.drawable.share_ic_task_file_ppt));
        put("torrent", Integer.valueOf(R.drawable.share_ic_task_file_torrent));
    }
}
