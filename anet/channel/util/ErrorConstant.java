package anet.channel.util;

import android.util.SparseArray;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Taobao */
public class ErrorConstant {
    public static final int ERROR_ACCS_AUTH_PARAM_INVALID = -104;
    public static final int ERROR_ACCS_CUSTOM_FRAME_CB_NULL = -105;
    public static final int ERROR_AUTH_EXCEPTION = -302;
    public static final int ERROR_CONNECT_EXCEPTION = -406;
    public static final int ERROR_CONN_TIME_OUT = -400;
    public static final int ERROR_DATA_TOO_LARGE = -303;
    public static final int ERROR_DEPULICATE_ACCS_SESSION = -107;
    public static final int ERROR_EXCEPTION = -101;
    public static final int ERROR_FILE_RENAME_TO_FAIL = -106;
    public static final int ERROR_GET_PROCESS_NULL = -108;
    public static final int ERROR_HOST_NOT_VERIFY_ERROR = -403;
    public static final int ERROR_IO_EXCEPTION = -404;
    public static final int ERROR_NO_NETWORK = -200;
    public static final int ERROR_NO_STRATEGY = -203;
    public static final int ERROR_OPEN_CONNECTION_NULL = -407;
    public static final int ERROR_PARAM_ILLEGAL = -102;
    public static final int ERROR_REMOTE_CALL_FAIL = -103;
    public static final int ERROR_REQUEST_CANCEL = -204;
    public static final int ERROR_REQUEST_FAIL = -201;
    public static final int ERROR_REQUEST_TIME_OUT = -202;
    public static final int ERROR_SESSION_INVALID = -301;
    public static final int ERROR_SOCKET_TIME_OUT = -401;
    public static final int ERROR_SSL_ERROR = -402;
    public static final int ERROR_TNET_EXCEPTION = -300;
    public static final int ERROR_UNKNOWN = -100;
    public static final int ERROR_UNKNOWN_HOST_EXCEPTION = -405;
    public static final int SC_OK = 200;
    private static SparseArray<String> errorMsgMap;

    static {
        SparseArray sparseArray = new SparseArray();
        errorMsgMap = sparseArray;
        sparseArray.put(200, "请求成功");
        errorMsgMap.put(-100, "未知错误");
        errorMsgMap.put(ERROR_EXCEPTION, "发生异常");
        errorMsgMap.put(ERROR_PARAM_ILLEGAL, "非法参数");
        errorMsgMap.put(-103, "远程调用失败");
        errorMsgMap.put(ERROR_ACCS_AUTH_PARAM_INVALID, "ACCS非法鉴权参数");
        errorMsgMap.put(ERROR_ACCS_CUSTOM_FRAME_CB_NULL, "ACCS自定义帧回调为空");
        errorMsgMap.put(ERROR_FILE_RENAME_TO_FAIL, "文件renameTo失败");
        errorMsgMap.put(ERROR_DEPULICATE_ACCS_SESSION, "存在重复的accs长连");
        errorMsgMap.put(ERROR_GET_PROCESS_NULL, "获取Process失败");
        errorMsgMap.put(ERROR_NO_NETWORK, "无网络");
        errorMsgMap.put(ERROR_NO_STRATEGY, "网络库无策略");
        errorMsgMap.put(ERROR_REQUEST_TIME_OUT, "请求超时");
        errorMsgMap.put(ERROR_REQUEST_CANCEL, "请求被取消");
        errorMsgMap.put(ERROR_SESSION_INVALID, "Session不可用");
        errorMsgMap.put(ERROR_TNET_EXCEPTION, "tnet层异常");
        errorMsgMap.put(ERROR_AUTH_EXCEPTION, "鉴权异常");
        errorMsgMap.put(ERROR_DATA_TOO_LARGE, "自定义帧数据过大");
        errorMsgMap.put(-400, "连接超时");
        errorMsgMap.put(ERROR_SOCKET_TIME_OUT, "Socket超时");
        errorMsgMap.put(ERROR_SSL_ERROR, "SSL失败");
        errorMsgMap.put(-403, "域名未认证");
        errorMsgMap.put(ERROR_IO_EXCEPTION, "IO异常");
        errorMsgMap.put(ERROR_UNKNOWN_HOST_EXCEPTION, "域名不能解析");
        errorMsgMap.put(ERROR_CONNECT_EXCEPTION, "连接异常");
        errorMsgMap.put(ERROR_OPEN_CONNECTION_NULL, "打开连接失败");
    }

    public static String getErrMsg(int i) {
        return StringUtils.stringNull2Empty((String) errorMsgMap.get(i));
    }

    public static String formatMsg(int i, String str) {
        return StringUtils.concatString(getErrMsg(i), Constants.COLON_SEPARATOR, str);
    }
}
