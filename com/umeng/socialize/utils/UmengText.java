package com.umeng.socialize.utils;

import com.umeng.socialize.bean.SHARE_MEDIA;

public class UmengText {
    public static String ALIPAY = "支付宝";
    public static String APPKEY_ERROR = "友盟appkey格式错误或不正确的appkey";
    public static String APPKEY_NOT_FOUND = "没有设置友盟Appkey";
    public static String APPKEY_NOT_REAL = "您使用的友盟appkey不是有效的appkey，请去官网申请";
    public static String AUTH_DENIED = "权限验证失败，请检查你的签名以及该平台Appkey权限.";
    public static String AUTH_FAIL_LOG = "授权失败，请查看log";
    public static String CHECK_FORMAT_ERROR = "checkFormat出错--";
    public static String CLEAN_CACHE_ERROR = "清除缓存抛出异常--";
    public static String CONTEXT_EMPTY = "请输入内容....";
    public static String CONTEXT_ERROR = "ContextUtil中context为空，请确保程序初始化完毕，且程序中不要使用ContextUtil.setContext（null）方法";
    public static String CONTEXT_LONG = "超出最大字数限制....";
    public static String DATA_EMPTY = "返回数据为空";
    public static String DECRPT_ERROR = "### AuthWebViewClient解密失败";
    public static String DINGTALK = "钉钉";
    public static String DOUBAN = "豆瓣";
    public static String DROPBOX = "Dropbox";
    public static String EMAIL = "邮件";
    public static String EMPTY_TEXT = "分享的文本不能为空";
    public static String EMPTY_WEB_URL = "您分享的是网页类型但是网址为空";
    public static String EVERNOTE = "印象笔记";
    public static String FACEBOOK = "Facebook";
    public static String FACEBOOK_MESSAGER = "Facebook Messager";
    public static String FACEBOOK_NET_SUPPORT = "facebook网页链接，缩略图必须为网络图片";
    public static String FET_CACHE_PATH_ERROR = "获取缓存路径出错--";
    public static String FILE_TO_BINARY_ERROR = "文件转入字节流，先要进行压缩出错";
    public static String FLICKR = "Flickr";
    public static String FOURSQUARE = "Foursquare";
    public static String FULL = "完整版";
    public static String GET_FAIL_BY_EMPTY = "获取用户资料为空，uid为空或token为空";
    public static String GET_FAIL_LOG = "获取用户资料失败，请查看log";
    public static String GET_FILE_FROM_BINARY = "字节流输出文件出错--";
    public static String GET_IMAGE_SCALE_ERROR = "获取文件大小出错--";
    public static String IMAGE_DOWNLOAD_ERROR = "图片下载失败--";
    public static String INSTAGRAM = "Instagram";
    public static String KAKAO = "KaKaoTalk";
    public static String LAIWANG = "来往";
    public static String LAIWANG_DYNAMIC = "来往动态";
    public static String LINE = "LINE";
    public static String LINKEDIN = "领英";
    public static String LONG_TEXT = "分享的文本过长";
    public static String LONG_URL = "分享的链接过长";
    public static String MAN = "男";
    public static String MORE = "更多";
    public static String NET_AGAIN_ERROR = "重定向问题：url和重定向url相同";
    public static String NET_INAVALIBLE = "抱歉,您的网络不可用...";
    public static String NOT_SUPPORT_PLATFROM = "平台不支持授权,无法完成操作";
    public static String OOM = "图片过大导致OOM，请减小图片---";
    public static String PINTEREST = "Pinterest";
    public static String POCKET = "Pocket";
    public static String QQ = "QQ";
    public static String QQ_ERROR = "mTencent信息不正确，请确认appid";
    public static String QQ_MUSIC = "QQ分享音乐,除了设置播放音乐的url,还可以设置一个跳转的url,可以通过UMusic().setmTargetUrl(xxx)设定";
    public static String QQ_PERMISSION = "QQ图片存储失败，请检查图片或者检查是否有读写权限";
    public static String QQ_TENCENT_ERROR = "Tencent变量初始化失败，请检查你的app id跟AndroidManifest.xml文件中AuthActivity的scheme是否填写正确";
    public static String QZONE = "QQ空间";
    public static String READ_IMAGE_ERROR = "读取图片文件出错--";
    public static String RENREN = "人人网";
    public static String SD_NOT_FOUNT = "没有找到存储设备，存储图片";
    public static String SHARECONTENT_IMAGE_ERROR = "图片参数有误，您没有设置缩略图，或者设置的缩略图内容有误，不能被解析";
    public static String SHARECONTENT_THUMB_ERROR = "缩略图参数有误，您没有设置缩略图，或者设置的缩略图内容有误，不能被解析";
    public static String SHARE_CONTENT_FAIL = "当前分享类型内容有误，缺少设置参数或内容不合规，请查看友盟log";
    public static String SHARE_FAIL_LOG = "分享失败，请查看log";
    public static String SHARE_STYLE = "分享类型--";
    public static String SHARE_TO = "分享到";
    public static String SIMPLE = "精简版";
    public static String SINA = "新浪";
    public static String SINA_AID_ERROR = "新浪AID获取失败";
    public static String SINA_GET_ERROR = "返回结果为空，请检查网络，或token是否过期";
    public static String SINA_SIGN_ERROR = "新浪签名或回调地址错误，请去后台检查";
    public static String SINA_THUMB_ERROR = "新浪多媒体分享，需要添加缩略图，请检查是否添加正确";
    public static String SINA_UPLOAD_ERROR = "新浪上传图片失败";
    public static String SMS = "短信";
    public static String SOLVE = "解决方案--";
    public static String TENCENT = "腾讯微博";
    public static String THUMB_ERROR = "### 您的原始图片太大,导致缩略图压缩过后还大于32KB,请将分享到微信的图片进行适当缩小.";
    public static String TUMBLR = "Tumblr";
    public static String TWITTER = "Twitter";
    public static String UNKNOW_SHARE_TYPE = "不支持的分享类型";
    public static String UNKNOW_UMIMAGE = "Don't support type，UMImage构造类型只支持bitmap 二进制字节流 本地文件，资源文件和网络链接，您传入的格式错误";
    public static String UPLOADFAIL = "上fsdfsdfsdddddsadasdas";
    public static String VERSION_NOT_SUPPORT = "当前使用的客户端版本不支持分享或授权";
    public static String VKONTAKTE = "VKontakte";
    public static String WEB_HTTP = "分享的链接需要以http开头";
    public static String WEIXIN = "微信";
    public static String WEIXIN_CIRCLE = "朋友圈";
    public static String WEIXIN_FAVORITE = "微信收藏";
    public static String WHATSAPP = "WhatsApp";
    public static String WOMAN = "女";
    public static String WX_CIRCLE_NOT_SUPPORT_EMOJ = "微信朋友圈不支持表情分享...";
    public static String WX_CIRCLE_NOT_SUPPORT_MIN = "微信朋友圈不支持小程序分享...";
    public static String YIXIN = "易信";
    public static String YIXIN_CIRCLE = "易信朋友圈";
    public static String YNOTE = "有道笔记";

    public static String errorWithUrl(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n解决方案：");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static String resError(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder("缺少资源文件:packageName=");
        stringBuilder.append(str);
        stringBuilder.append("\n type=");
        stringBuilder.append(str2);
        stringBuilder.append("\n name=");
        stringBuilder.append(str3);
        stringBuilder.append("请去sdk下载包中拷贝");
        return stringBuilder.toString();
    }

    public static String netMethodError(String str) {
        StringBuilder stringBuilder = new StringBuilder("验证请求方式失败[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String supportStyle(boolean z, String str) {
        StringBuilder stringBuilder = new StringBuilder("该平台");
        stringBuilder.append(z ? "只" : "不");
        stringBuilder.append("支持");
        if (str.contains("image")) {
            stringBuilder.append("图片");
        }
        if (str.contains("netimg")) {
            stringBuilder.append("网络图片");
        }
        if (str.contains("localimg")) {
            stringBuilder.append("本地图片");
        }
        if (str.contains("url")) {
            stringBuilder.append("链接");
        }
        if (str.contains("video")) {
            stringBuilder.append("视频");
        }
        if (str.contains("timg")) {
            stringBuilder.append("图文");
        }
        if (str.contains("text")) {
            stringBuilder.append("纯文本");
        }
        stringBuilder.append("分享");
        return stringBuilder.toString();
    }

    public static String tencentEmpty(boolean z) {
        z = z ? SIMPLE : FULL;
        StringBuilder stringBuilder = new StringBuilder("您使用的是");
        stringBuilder.append(z);
        stringBuilder.append("但是你的AndroidManifest配置不正确，或者配置的不是");
        stringBuilder.append(z);
        stringBuilder.append("的路径，请参照线上报错必看文档");
        return stringBuilder.toString();
    }

    public static String urlEmpty(int i) {
        StringBuilder stringBuilder = new StringBuilder("错误:设置视频");
        if (i == 0) {
            stringBuilder.append("视频");
        }
        if (i == 1) {
            stringBuilder.append("音乐");
        }
        if (i == 2) {
            stringBuilder.append("网页");
        }
        stringBuilder.append("分享类型，链接不能为空");
        return stringBuilder.toString();
    }

    public static String noJar(SHARE_MEDIA share_media) {
        StringBuilder stringBuilder = new StringBuilder("您 没有配置 ");
        stringBuilder.append(share_media);
        stringBuilder.append(" 的jar包");
        return stringBuilder.toString();
    }

    public static String noKey(SHARE_MEDIA share_media) {
        StringBuilder stringBuilder = new StringBuilder("您 没有配置");
        stringBuilder.append(share_media.toString());
        stringBuilder.append("的appkey");
        return stringBuilder.toString();
    }
}
