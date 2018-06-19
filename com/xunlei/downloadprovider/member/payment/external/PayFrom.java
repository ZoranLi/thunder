package com.xunlei.downloadprovider.member.payment.external;

public enum PayFrom {
    DOWNLOAD_LIST_SPEEDUP("下载列表——加速按钮"),
    DOWNLOAD_TASK_DETAIL_SPEEDUP("下载任务详情页——加速按钮"),
    DOWNLOAD_LIST_TOP_TXT_LINK("下载列表——顶部文字链"),
    PERSONAL_CENTER_ICON("个人中心——头像"),
    PERSONAL_CENTER_FAST_PAY("个人中心——顶部开通按钮"),
    PERSONAL_CENTER_RENEW_TIP("个人中心——续费tip"),
    PERSONAL_CENTER_VIP_INFO_AREA("个人中心——年费信息区域"),
    DOWNLOAD_NOTIFICATION("下载任务-通知栏"),
    ACCOUNT_CENTER("账号信息页面"),
    PLAY_RECORD_LIST("播放记录"),
    VIP_RENEW_REMIND("续费触达提醒"),
    HOME_CHOICE_RENEW("首页精选续费触达"),
    BIRD_PAGE("快鸟-页面"),
    BIRD_TIP("快鸟-试用期弹窗"),
    RED_PACKET_DETAILS("红包详情"),
    RED_PACKET_LIST_ITEM("红包列表item"),
    DOWNLOAD_TASK_RED_PACKET("下载中心礼包"),
    DOWNLOAD_TASK_FREE_TRIAL("下载任务加速试用——开通会员"),
    DOWNLOAD_TASK_PRIVATE_SPACE("私人空间"),
    DOWNLOAD_TASK_LIMIT_PRIVILEGE("同时下载任务数特权"),
    DOWNLOAD_TASK_TEN_DAY_REDPACKET("10天红包优惠活动"),
    BXBB_SPEEDUP_TRIAL("边下边播试用加速"),
    DOWNLOAD_TASK_SUPER_SPEEDUP("快鸟超级加速"),
    LIXIAN_SPACE("离线空间"),
    VOD_SPEED_RATE("倍速播放");

    private PayFrom(String str) {
    }

    public final boolean isFromKuaiNiao() {
        if (this != BIRD_PAGE) {
            if (this != BIRD_TIP) {
                return false;
            }
        }
        return true;
    }

    public final boolean isFromRedPacket() {
        if (!(this == RED_PACKET_DETAILS || this == DOWNLOAD_TASK_RED_PACKET)) {
            if (this != RED_PACKET_LIST_ITEM) {
                return false;
            }
        }
        return true;
    }
}
