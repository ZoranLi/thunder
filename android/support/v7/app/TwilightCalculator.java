package android.support.v7.app;

class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
    }

    static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j, double d, double d2) {
        TwilightCalculator twilightCalculator = this;
        float f = ((float) (j - UTC_2000)) / 8.64E7f;
        float f2 = 6.24006f + (0.01720197f * f);
        double d3 = (double) f2;
        double sin = (((((0.03341960161924362d * Math.sin(d3)) + d3) + (3.4906598739326E-4d * Math.sin((double) (2.0f * f2)))) + (5.236000106378924E-6d * Math.sin((double) (3.0f * f2)))) + 1.796593063d) + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double round = ((((double) (((float) Math.round(((double) (f - J0)) - d4)) + J0)) + d4) + (0.0053d * Math.sin(d3))) + (-0.0069d * Math.sin(2.0d * sin));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d;
        sin = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(d5) * Math.cos(asin));
        if (sin >= 1.0d) {
            twilightCalculator.state = 1;
            twilightCalculator.sunset = -1;
            twilightCalculator.sunrise = -1;
        } else if (sin <= -1.0d) {
            twilightCalculator.state = 0;
            twilightCalculator.sunset = -1;
            twilightCalculator.sunrise = -1;
        } else {
            d5 = (double) ((float) (Math.acos(sin) / 6.283185307179586d));
            twilightCalculator.sunset = Math.round((round + d5) * 8.64E7d) + UTC_2000;
            twilightCalculator.sunrise = Math.round((round - d5) * 8.64E7d) + UTC_2000;
            if (twilightCalculator.sunrise >= j || twilightCalculator.sunset <= j) {
                twilightCalculator.state = 1;
            } else {
                twilightCalculator.state = 0;
            }
        }
    }
}
