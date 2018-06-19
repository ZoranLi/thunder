package mtopsdk.mtop.domain;

public enum ProtocolEnum {
    HTTP("http://"),
    HTTPSECURE("https://");
    
    private String protocol;

    private ProtocolEnum(String str) {
        this.protocol = str;
    }

    public final String getProtocol() {
        return this.protocol;
    }
}
