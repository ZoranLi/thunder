package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.PermissionChecker;
import java.util.Calendar;

class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    private static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        TwilightState() {
        }
    }

    static TwilightManager getInstance(@NonNull Context context) {
        if (sInstance == null) {
            context = context.getApplicationContext();
            sInstance = new TwilightManager(context, (LocationManager) context.getSystemService("location"));
        }
        return sInstance;
    }

    @VisibleForTesting
    static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    boolean isNight() {
        TwilightState twilightState = this.mTwilightState;
        if (isStateValid()) {
            return twilightState.isNight;
        }
        Location lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation != null) {
            updateState(lastKnownLocation);
            return twilightState.isNight;
        }
        int i = Calendar.getInstance().get(11);
        if (i >= 6) {
            if (i < 22) {
                return false;
            }
        }
        return true;
    }

    private Location getLastKnownLocation() {
        Location location = null;
        Location lastKnownLocationForProvider = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? getLastKnownLocationForProvider("network") : null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = getLastKnownLocationForProvider("gps");
        }
        return (location == null || lastKnownLocationForProvider == null) ? location != null ? location : lastKnownLocationForProvider : location.getTime() > lastKnownLocationForProvider.getTime() ? location : lastKnownLocationForProvider;
    }

    private android.location.Location getLastKnownLocationForProvider(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.mLocationManager;
        if (r0 == 0) goto L_0x0013;
    L_0x0004:
        r0 = r1.mLocationManager;	 Catch:{ Exception -> 0x0013 }
        r0 = r0.isProviderEnabled(r2);	 Catch:{ Exception -> 0x0013 }
        if (r0 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0013 }
    L_0x000c:
        r0 = r1.mLocationManager;	 Catch:{ Exception -> 0x0013 }
        r2 = r0.getLastKnownLocation(r2);	 Catch:{ Exception -> 0x0013 }
        return r2;
    L_0x0013:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.TwilightManager.getLastKnownLocationForProvider(java.lang.String):android.location.Location");
    }

    private boolean isStateValid() {
        return this.mTwilightState != null && this.mTwilightState.nextUpdate > System.currentTimeMillis();
    }

    private void updateState(@NonNull Location location) {
        long j;
        TwilightState twilightState;
        TwilightState twilightState2 = this.mTwilightState;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator instance = TwilightCalculator.getInstance();
        TwilightCalculator twilightCalculator = instance;
        twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = instance.sunset;
        twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = true;
        if (instance.state != 1) {
            z = false;
        }
        boolean z2 = z;
        long j3 = instance.sunrise;
        long j4 = j2;
        j2 = instance.sunset;
        TwilightState twilightState3 = twilightState2;
        long j5 = j3;
        boolean z3 = z2;
        instance.calculateTwilight(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j6 = instance.sunrise;
        if (j5 != -1) {
            if (j2 != -1) {
                long j7 = currentTimeMillis > j2 ? 0 + j6 : currentTimeMillis > j5 ? 0 + j2 : 0 + j5;
                j = j7 + 60000;
                twilightState = twilightState3;
                twilightState.isNight = z3;
                twilightState.yesterdaySunset = j4;
                twilightState.todaySunrise = j5;
                twilightState.todaySunset = j2;
                twilightState.tomorrowSunrise = j6;
                twilightState.nextUpdate = j;
            }
        }
        j = currentTimeMillis + 43200000;
        twilightState = twilightState3;
        twilightState.isNight = z3;
        twilightState.yesterdaySunset = j4;
        twilightState.todaySunrise = j5;
        twilightState.todaySunset = j2;
        twilightState.tomorrowSunrise = j6;
        twilightState.nextUpdate = j;
    }
}
