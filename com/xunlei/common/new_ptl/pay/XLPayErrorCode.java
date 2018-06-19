package com.xunlei.common.new_ptl.pay;

public final class XLPayErrorCode {
    public static final int HTTP_NO_RESPONSE = 10020;
    public static final int HTTP_PROTOCOL_ERROR = 10022;
    public static final int HTTP_RESPONSE_ERROR = 10021;
    public static final int SOCK_CONNECT_FAIL = 10003;
    public static final int SOCK_CONNECT_TIMEOUT = 10011;
    public static final int SOCK_EXCEPTION = 10000;
    public static final int SOCK_NO_ROUTE_TO_HOST = 10001;
    public static final int SOCK_PORT_UNREACHABLE = 10002;
    public static final int SOCK_SSL_ERR = 10013;
    public static final int SOCK_TIME_OUT = 10010;
    public static final int SOCK_UNKNOWN_HOST = 10012;
    public static final int XLP_ALI_CAN_ERROR = 101;
    public static final int XLP_ALI_DISCONTRACT_ERROR = 103;
    public static final int XLP_ALI_NOT_INSTALL = 102;
    public static final int XLP_ALI_PAY_ERROR = 100;
    public static final int XLP_ALI_QCONTRACT_ERROR = 104;
    public static final int XLP_ALI_QCONTRACT_EXIST = 105;
    public static final int XLP_CANCLE_ERROR = 1000001;
    public static final int XLP_COMMON_INVALID_PARAM = 150;
    public static final int XLP_CONTRACT_EXIST = 1000005;
    public static final int XLP_CONTRACT_QUERY_ERROR = 1000004;
    public static final int XLP_GET_ORDER_ERROR = 1000003;
    public static final int XLP_GET_PRICE_ERROR = 1000002;
    public static final int XLP_NET_GATE_ERROR_BASE = 1000000;
    public static final int XLP_SUCCESS = 0;
    public static final int XLP_WX_AUT_ERROR = 52;
    public static final int XLP_WX_CAN_ERROR = 51;
    public static final int XLP_WX_DISCONTRACT_ERROR = 56;
    public static final int XLP_WX_NOT_INSTALL = 54;
    public static final int XLP_WX_PAY_ERROR = 53;
    public static final int XLP_WX_QCONTRACT_ERROR = 57;
    public static final int XLP_WX_QCONTRACT_EXIST = 55;
    public static final int XLP_WX_REQ_ERROR = 50;

    public static String getErrorDesc(int i) {
        return i == 0 ? "成功" : i == XLP_CANCLE_ERROR ? "用户取消" : i == XLP_GET_PRICE_ERROR ? "获取价格错误" : i == XLP_GET_ORDER_ERROR ? "获取订单错误" : i == XLP_CONTRACT_QUERY_ERROR ? "查询签约关系失败" : i == XLP_CONTRACT_EXIST ? "已有签约关系" : i == 50 ? "请求微信支付失败" : i == 51 ? "微信用户取消支付" : i == 52 ? "微信授权被拒绝" : i == 53 ? "微信支付失败" : i == 54 ? "微信未安装" : i == 55 ? "微信包月已经签约" : i == 56 ? "微信包月解除签约失败" : i == 57 ? "微信包月查询签约失败" : i == 100 ? "支付失败" : i == 101 ? "支付取消" : i == 102 ? "支付宝钱包未安装" : i == 103 ? "支付包包月解除签约失败" : i == 104 ? "支付包包月查询签约失败" : i == 105 ? "支付包包月已经签约" : i == 150 ? "参数错误" : i == 10000 ? "socket异常，除SOCK_NO_ROUTE_TO_HOST/SOCK_PORT_UNREACHABLE/SOCK_CONNECT_FAIL其他连接异常(SocketException)" : i == 10001 ? "无法路由至主机(NoRouteToHostException)" : i == 10002 ? "指定端口不可达(PortUnreachableException)" : i == 10003 ? "连接失败(ConnectException)" : i == 10010 ? "socket读取超时，即服务端响应超时(SocketTimeoutException)" : i == 10011 ? "连接超时(ConnectTimeoutException)" : i == 10012 ? "无法解析域名(UnknownHostException)" : i == 10013 ? "ssl错误(SSLException)" : i == 10020 ? "服务端无响应(NoHttpResponseException)" : i == 10021 ? "服务端响应异常，HTTP错误码>=300(HttpResponseException)" : i == 10022 ? "HTTP协议数据处理错误(HttpException)" : "未知错误";
    }
}
