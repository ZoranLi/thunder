package mtopsdk.common.util;

public enum TBSdkLog$LogEnable {
    VerboseEnable("V"),
    DebugEnable("D"),
    InfoEnable("I"),
    WarnEnable("W"),
    ErrorEnable("E"),
    NoneEnable("L");
    
    private String logEnable;

    private TBSdkLog$LogEnable(String str) {
        this.logEnable = str;
    }

    public final String getLogEnable() {
        return this.logEnable;
    }
}
