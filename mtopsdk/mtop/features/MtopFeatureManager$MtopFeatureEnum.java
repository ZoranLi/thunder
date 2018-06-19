package mtopsdk.mtop.features;

public enum MtopFeatureManager$MtopFeatureEnum {
    SUPPORT_RELATIVE_URL(1),
    UNIT_INFO_FEATURE(2),
    DISABLE_WHITEBOX_SIGN(3),
    SUPPORT_UTDID_UNIT(4),
    DISABLE_X_COMMAND(5),
    SUPPORT_OPEN_ACCOUNT(6);
    
    long feature;

    private MtopFeatureManager$MtopFeatureEnum(long j) {
        this.feature = j;
    }

    public final long getFeature() {
        return this.feature;
    }
}
