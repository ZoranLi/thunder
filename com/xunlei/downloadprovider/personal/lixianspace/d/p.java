package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.aplayer.aplayerandroid.FF2AndroidMapper;

/* compiled from: LXErrorCode */
public final class p {
    public static String a(int i) {
        if (i == -20000) {
            return "数据解析异常";
        }
        if (i == -1000) {
            return "网络连接失败，请稍候重试！";
        }
        switch (i) {
            case 222:
                return "因涉及版权问题无法离线下载";
            case 223:
                return "因涉及敏感信息无法离线下载";
            case 224:
                return "已达到当前最大离线下载次数";
            case 225:
                return "任务过期";
            default:
                switch (i) {
                    case 233:
                        return "任务已存在";
                    case 234:
                        return "本月离线空间任务数已用完";
                    default:
                        switch (i) {
                            case 241:
                                return "离线下载完成";
                            case 242:
                                return "下载失败";
                            case 243:
                                return "下载出错";
                            case FF2AndroidMapper.FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
                                return "任务不存在";
                            default:
                                return "出错啦，请稍候重试！";
                        }
                }
        }
    }
}
