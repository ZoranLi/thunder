package mtopsdk.mtop.domain;

public enum JsonTypeEnum {
    JSON("json"),
    ORIGINALJSON("originaljson");
    
    private String jsonType;

    private JsonTypeEnum(String str) {
        this.jsonType = str;
    }

    public final String getJsonType() {
        return this.jsonType;
    }
}
