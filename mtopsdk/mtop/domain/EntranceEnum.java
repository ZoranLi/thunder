package mtopsdk.mtop.domain;

public enum EntranceEnum {
    GW_OPEN("gw-open");
    
    private String entrance;

    private EntranceEnum(String str) {
        this.entrance = str;
    }

    public final String getEntrance() {
        return this.entrance;
    }
}
