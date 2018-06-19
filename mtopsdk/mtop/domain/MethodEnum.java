package mtopsdk.mtop.domain;

public enum MethodEnum {
    GET("GET"),
    POST("POST");
    
    private String method;

    private MethodEnum(String str) {
        this.method = str;
    }

    public final String getMethod() {
        return this.method;
    }
}
