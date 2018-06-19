package com.xunlei.common.businessutil;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.R;
import java.io.File;
import java.util.HashMap;

public class XLFileTypeUtil {
    static String[] book_category = new String[]{SocializeConstants.KEY_TEXT, "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "rtf"};
    static String[] localvod_category = new String[]{"flv", "mp4", "3gp", "rmvb", "mkv", "avi", "mov", "wmv", "asf", "f4v", "m4v", "rm", "xv", MsgConstant.KEY_TS, "mpg", "mpe", "mpeg"};
    static String[] music_category = new String[]{"wav", "midi", "cda", "mp3", "mp3pro", "wma", "sacd", "vqf", "ra", "rmx", "voc", "au", "aif", "snd", "aac", "flac", "ape"};
    static String[] picture_category = new String[]{"png", "jpeg", "bmp", "jpg", "icon", "jpe", "gif", "jpeg2000"};
    static String[] rar_category = new String[]{"zip", "rar", "7z", "7zip", "tgz"};
    static final HashMap<String, Integer> sExtIconResId = new HashMap<String, Integer>() {
        {
            put("wmv", Integer.valueOf(R.drawable.ic_dl_wmv));
            put("asf", Integer.valueOf(R.drawable.ic_dl_asf));
            put("asx", Integer.valueOf(R.drawable.ic_dl_asx));
            put("rm", Integer.valueOf(R.drawable.ic_dl_rm));
            put("rmvb", Integer.valueOf(R.drawable.ic_dl_rmvb));
            put("mpg", Integer.valueOf(R.drawable.ic_dl_mpg));
            put("mpeg", Integer.valueOf(R.drawable.ic_dl_mpeg));
            put("mpe", Integer.valueOf(R.drawable.ic_dl_mpe));
            put("3gp", Integer.valueOf(R.drawable.ic_dl_3gp));
            put("mov", Integer.valueOf(R.drawable.ic_dl_mov));
            put("mp4", Integer.valueOf(R.drawable.ic_dl_mp4));
            put("m4v", Integer.valueOf(R.drawable.ic_dl_m4v));
            put("avi", Integer.valueOf(R.drawable.ic_dl_avi));
            put("mkv", Integer.valueOf(R.drawable.ic_dl_mkv));
            put("flv", Integer.valueOf(R.drawable.ic_dl_flv));
            put("f4v", Integer.valueOf(R.drawable.ic_dl_f4v));
            put("vob", Integer.valueOf(R.drawable.ic_dl_vob));
            put(MsgConstant.KEY_TS, Integer.valueOf(R.drawable.ic_dl_ts));
            put("xv", Integer.valueOf(R.drawable.ic_dl_xv));
            put("rar", Integer.valueOf(R.drawable.ic_dl_rar));
            put("zip", Integer.valueOf(R.drawable.ic_dl_zip));
            put("7zip", Integer.valueOf(R.drawable.ic_dl_7z));
            put("7z", Integer.valueOf(R.drawable.ic_dl_7z));
            put("tgz", Integer.valueOf(R.drawable.ic_dl_tar));
            put("rtf", Integer.valueOf(R.drawable.ic_dl_text));
            put(SocializeConstants.KEY_TEXT, Integer.valueOf(R.drawable.ic_dl_txt));
            put("doc", Integer.valueOf(R.drawable.ic_dl_doc));
            put("xls", Integer.valueOf(R.drawable.ic_dl_xls));
            put("ppt", Integer.valueOf(R.drawable.ic_dl_ppt));
            put("docx", Integer.valueOf(R.drawable.ic_dl_doc));
            put("xlsx", Integer.valueOf(R.drawable.ic_dl_xls));
            put("pptx", Integer.valueOf(R.drawable.ic_dl_ppt));
        }
    };
    static String[] sofware_category = new String[]{"apk", "APK"};
    static String[] torrent_category = new String[]{"torrent"};
    static String[] video_category = new String[]{"wmv", "asf", "asx", "rm", "rmvb", "mpg", "mpeg", "mpe", "3gp", "mov", "mp4", "m4v", "avi", "mkv", "flv", "f4v", "vob", MsgConstant.KEY_TS, "xv"};

    public enum EFileCategoryType {
        E_OTHER_CATEGORY,
        E_VIDEO_CATEGORY,
        E_MUSIC_CATEGORY,
        E_BOOK_CATEGORY,
        E_SOFTWARE_CATEGORY,
        E_PICTURE_CATEGORY,
        E_ZIP_CATEGORY,
        E_TORRENT_CATEGORY,
        E_XLFILE_UPPER,
        E_XLDIR_CATEGORY
    }

    public static boolean isVideo(String str) {
        if (!TextUtils.isEmpty(str) && getFileCategoryTypeByName(str) == EFileCategoryType.E_VIDEO_CATEGORY) {
            return true;
        }
        return false;
    }

    public static EFileCategoryType getFileCategoryTypeByName(String str) {
        return getFileCategoryTypeByName(str, false);
    }

    @SuppressLint({"DefaultLocale"})
    public static EFileCategoryType getFileCategoryTypeByName(String str, boolean z) {
        EFileCategoryType eFileCategoryType = EFileCategoryType.E_OTHER_CATEGORY;
        if (str == null) {
            return eFileCategoryType;
        }
        String trim = str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase().trim();
        int i = 0;
        int i2 = 0;
        while (i2 < video_category.length) {
            if (trim.compareTo(video_category[i2]) != 0) {
                if (TextUtils.isEmpty(trim) || !trim.startsWith(video_category[i2])) {
                    i2++;
                }
            }
            return EFileCategoryType.E_VIDEO_CATEGORY;
        }
        for (String compareTo : music_category) {
            if (trim.compareTo(compareTo) == 0) {
                return EFileCategoryType.E_MUSIC_CATEGORY;
            }
        }
        for (String compareTo2 : book_category) {
            if (trim.compareTo(compareTo2) == 0) {
                return EFileCategoryType.E_BOOK_CATEGORY;
            }
        }
        for (String compareTo22 : sofware_category) {
            if (trim.compareTo(compareTo22) == 0) {
                return EFileCategoryType.E_SOFTWARE_CATEGORY;
            }
        }
        for (String compareTo222 : rar_category) {
            if (trim.compareTo(compareTo222) == 0) {
                return EFileCategoryType.E_ZIP_CATEGORY;
            }
        }
        for (String compareTo2222 : picture_category) {
            if (trim.compareTo(compareTo2222) == 0) {
                return EFileCategoryType.E_PICTURE_CATEGORY;
            }
        }
        while (i < torrent_category.length) {
            if (trim.compareTo(torrent_category[i]) == 0) {
                return EFileCategoryType.E_TORRENT_CATEGORY;
            }
            i++;
        }
        if (z) {
            z = new File(str);
            if (!(z.exists() == null || z.isDirectory() == null)) {
                return EFileCategoryType.E_XLDIR_CATEGORY;
            }
        }
        return eFileCategoryType;
    }

    public static int getFileIconResIdForVideo(String str) {
        int i = R.drawable.ic_dl_video;
        str = extractFileExt(str, false).toLowerCase();
        return sExtIconResId.containsKey(str) ? ((Integer) sExtIconResId.get(str)).intValue() : i;
    }

    public static int getFileIconResId(String str) {
        String toLowerCase = extractFileExt(str, false).toLowerCase();
        if (sExtIconResId.containsKey(toLowerCase)) {
            return ((Integer) sExtIconResId.get(toLowerCase)).intValue();
        }
        int i = R.drawable.ic_dl_other;
        if (str != null) {
            switch (getFileCategoryTypeByName(str)) {
                case E_VIDEO_CATEGORY:
                    i = getFileIconResIdForVideo(str);
                    break;
                case E_MUSIC_CATEGORY:
                    i = R.drawable.ic_dl_music;
                    break;
                case E_BOOK_CATEGORY:
                    i = R.drawable.ic_dl_text;
                    break;
                case E_SOFTWARE_CATEGORY:
                    i = R.drawable.ic_dl_apk;
                    break;
                case E_PICTURE_CATEGORY:
                    i = R.drawable.ic_dl_image;
                    break;
                case E_ZIP_CATEGORY:
                    i = R.drawable.ic_dl_rar;
                    break;
                case E_TORRENT_CATEGORY:
                    i = R.drawable.ic_dl_torrent;
                    break;
                case E_OTHER_CATEGORY:
                    i = R.drawable.ic_dl_other;
                    break;
                default:
                    i = R.drawable.ic_dl_other;
                    break;
            }
        }
        return i;
    }

    public static boolean isLocalVodSupport(String str) {
        str = str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase().trim();
        for (String compareTo : localvod_category) {
            if (str.compareTo(compareTo) == 0) {
                return true;
            }
        }
        return false;
    }

    public static String extractFileExt(String str) {
        return extractFileExt(str, true);
    }

    public static String extractFileExt(String str, boolean z) {
        int lastIndexOf = !TextUtils.isEmpty(str) ? str.lastIndexOf(".") : -1;
        if (lastIndexOf != -1) {
            if (z || lastIndexOf + 1 != str.length()) {
                if (z) {
                    return str.substring(lastIndexOf).trim();
                }
                return str.substring(lastIndexOf + 1).trim();
            }
        }
        return "";
    }
}
