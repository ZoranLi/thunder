package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = "ActivityChooserModel";
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private static final Object sRegistryLock = new Object();
    private final List<ActivityResolveInfo> mActivities = new ArrayList();
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter = new DefaultSorter();
    boolean mCanReadHistoricalData = true;
    final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    private boolean mHistoricalRecordsChanged = true;
    final String mHistoryFileName;
    private int mHistoryMaxSize = 50;
    private final Object mInstanceLock = new Object();
    private Intent mIntent;
    private boolean mReadShareHistoryCalled = false;
    private boolean mReloadActivities = false;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public final int hashCode() {
            return 31 + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public final int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:");
            stringBuilder.append(this.resolveInfo.toString());
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public final int hashCode() {
            return (31 * ((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32))))) + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            if (this.activity == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!this.activity.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:");
            stringBuilder.append(this.activity);
            stringBuilder.append("; time:");
            stringBuilder.append(this.time);
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        public final java.lang.Void doInBackground(java.lang.Object... r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r11 = this;
            r0 = 0;
            r1 = r12[r0];
            r1 = (java.util.List) r1;
            r2 = 1;
            r12 = r12[r2];
            r12 = (java.lang.String) r12;
            r3 = 0;
            r4 = android.support.v7.widget.ActivityChooserModel.this;	 Catch:{ FileNotFoundException -> 0x00c7 }
            r4 = r4.mContext;	 Catch:{ FileNotFoundException -> 0x00c7 }
            r12 = r4.openFileOutput(r12, r0);	 Catch:{ FileNotFoundException -> 0x00c7 }
            r4 = android.util.Xml.newSerializer();
            r4.setOutput(r12, r3);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r5 = "UTF-8";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r6 = java.lang.Boolean.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.startDocument(r5, r6);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r5 = "historical-records";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.startTag(r3, r5);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r5 = r1.size();	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r6 = r0;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
        L_0x002d:
            if (r6 >= r5) goto L_0x0063;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
        L_0x002f:
            r7 = r1.remove(r0);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r7 = (android.support.v7.widget.ActivityChooserModel.HistoricalRecord) r7;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r8 = "historical-record";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.startTag(r3, r8);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r8 = "activity";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r9 = r7.activity;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r9 = r9.flattenToString();	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r8 = "time";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r9 = r7.time;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r9 = java.lang.String.valueOf(r9);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r8 = "weight";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r7 = r7.weight;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r7 = java.lang.String.valueOf(r7);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.attribute(r3, r8, r7);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r7 = "historical-record";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.endTag(r3, r7);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r6 = r6 + 1;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            goto L_0x002d;	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
        L_0x0063:
            r0 = "historical-records";	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.endTag(r3, r0);	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r4.endDocument();	 Catch:{ IllegalArgumentException -> 0x00a5, IllegalStateException -> 0x008e, IOException -> 0x0077 }
            r0 = android.support.v7.widget.ActivityChooserModel.this;
            r0.mCanReadHistoricalData = r2;
            if (r12 == 0) goto L_0x00bc;
        L_0x0071:
            r12.close();	 Catch:{ IOException -> 0x00bc }
            goto L_0x00bc;
        L_0x0075:
            r0 = move-exception;
            goto L_0x00bd;
        L_0x0077:
            r0 = android.support.v7.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0075 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r0.<init>(r1);	 Catch:{ all -> 0x0075 }
            r1 = android.support.v7.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0075 }
            r1 = r1.mHistoryFileName;	 Catch:{ all -> 0x0075 }
            r0.append(r1);	 Catch:{ all -> 0x0075 }
            r0 = android.support.v7.widget.ActivityChooserModel.this;
            r0.mCanReadHistoricalData = r2;
            if (r12 == 0) goto L_0x00bc;
        L_0x008d:
            goto L_0x0071;
        L_0x008e:
            r0 = android.support.v7.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0075 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r0.<init>(r1);	 Catch:{ all -> 0x0075 }
            r1 = android.support.v7.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0075 }
            r1 = r1.mHistoryFileName;	 Catch:{ all -> 0x0075 }
            r0.append(r1);	 Catch:{ all -> 0x0075 }
            r0 = android.support.v7.widget.ActivityChooserModel.this;
            r0.mCanReadHistoricalData = r2;
            if (r12 == 0) goto L_0x00bc;
        L_0x00a4:
            goto L_0x0071;
        L_0x00a5:
            r0 = android.support.v7.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0075 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r0.<init>(r1);	 Catch:{ all -> 0x0075 }
            r1 = android.support.v7.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0075 }
            r1 = r1.mHistoryFileName;	 Catch:{ all -> 0x0075 }
            r0.append(r1);	 Catch:{ all -> 0x0075 }
            r0 = android.support.v7.widget.ActivityChooserModel.this;
            r0.mCanReadHistoricalData = r2;
            if (r12 == 0) goto L_0x00bc;
        L_0x00bb:
            goto L_0x0071;
        L_0x00bc:
            return r3;
        L_0x00bd:
            r1 = android.support.v7.widget.ActivityChooserModel.this;
            r1.mCanReadHistoricalData = r2;
            if (r12 == 0) goto L_0x00c6;
        L_0x00c3:
            r12.close();	 Catch:{ IOException -> 0x00c6 }
        L_0x00c6:
            throw r0;
        L_0x00c7:
            r12 = android.support.v7.widget.ActivityChooserModel.LOG_TAG;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

        DefaultSorter() {
        }

        public final void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            intent = this.mPackageNameToActivityMap;
            intent.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) list.get(i);
                activityResolveInfo.weight = 0.0f;
                intent.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
            }
            float f = ActivityChooserModel.DEFAULT_HISTORICAL_RECORD_WEIGHT;
            for (size = list2.size() - 1; size >= 0; size--) {
                HistoricalRecord historicalRecord = (HistoricalRecord) list2.get(size);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) intent.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f;
                    f *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(list);
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            activityChooserModel = (ActivityChooserModel) sDataModelRegistry.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                sDataModelRegistry.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str) == null && str.endsWith(HISTORY_FILE_EXTENSION) == null) {
            context = new StringBuilder();
            context.append(str);
            context.append(HISTORY_FILE_EXTENSION);
            this.mHistoryFileName = context.toString();
            return;
        }
        this.mHistoryFileName = str;
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            ensureConsistentState();
        }
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public ResolveInfo getActivity(int i) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            i = ((ActivityResolveInfo) this.mActivities.get(i)).resolveInfo;
        }
        return i;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            List list = this.mActivities;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((ActivityResolveInfo) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent chooseActivity(int i) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.mActivities.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            i = new Intent(this.mIntent);
            i.setComponent(componentName);
            if (this.mActivityChoserModelPolicy != null) {
                if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(i))) {
                    return null;
                }
            }
            addHistoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), (float) DEFAULT_HISTORICAL_RECORD_WEIGHT));
            return i;
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            if (this.mActivities.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ActivityResolveInfo) this.mActivities.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public void setDefaultActivity(int i) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.mActivities.get(i);
            ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) this.mActivities.get(0);
            addHistoricalRecord(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : DEFAULT_HISTORICAL_RECORD_WEIGHT));
        }
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = false;
            if (!TextUtils.isEmpty(this.mHistoryFileName)) {
                new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setActivitySorter(android.support.v7.widget.ActivityChooserModel.ActivitySorter r3) {
        /*
        r2 = this;
        r0 = r2.mInstanceLock;
        monitor-enter(r0);
        r1 = r2.mActivitySorter;	 Catch:{ all -> 0x0016 }
        if (r1 != r3) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        return;
    L_0x0009:
        r2.mActivitySorter = r3;	 Catch:{ all -> 0x0016 }
        r3 = r2.sortActivitiesIfNeeded();	 Catch:{ all -> 0x0016 }
        if (r3 == 0) goto L_0x0014;
    L_0x0011:
        r2.notifyChanged();	 Catch:{ all -> 0x0016 }
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        return;
    L_0x0016:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.setActivitySorter(android.support.v7.widget.ActivityChooserModel$ActivitySorter):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setHistoryMaxSize(int r3) {
        /*
        r2 = this;
        r0 = r2.mInstanceLock;
        monitor-enter(r0);
        r1 = r2.mHistoryMaxSize;	 Catch:{ all -> 0x0019 }
        if (r1 != r3) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        return;
    L_0x0009:
        r2.mHistoryMaxSize = r3;	 Catch:{ all -> 0x0019 }
        r2.pruneExcessiveHistoricalRecordsIfNeeded();	 Catch:{ all -> 0x0019 }
        r3 = r2.sortActivitiesIfNeeded();	 Catch:{ all -> 0x0019 }
        if (r3 == 0) goto L_0x0017;
    L_0x0014:
        r2.notifyChanged();	 Catch:{ all -> 0x0019 }
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        return;
    L_0x0019:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.setHistoryMaxSize(int):void");
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    private void ensureConsistentState() {
        int loadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (loadActivitiesIfNeeded != 0) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null || this.mIntent == null || this.mActivities.isEmpty() || this.mHistoricalRecords.isEmpty()) {
            return false;
        }
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    private boolean loadActivitiesIfNeeded() {
        int i = 0;
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        while (i < size) {
            this.mActivities.add(new ActivityResolveInfo((ResolveInfo) queryIntentActivities.get(i)));
            i++;
        }
        return true;
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
            return false;
        }
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        historicalRecord = this.mHistoricalRecords.add(historicalRecord);
        if (historicalRecord != null) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return historicalRecord;
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (size > 0) {
            this.mHistoricalRecordsChanged = true;
            for (int i = 0; i < size; i++) {
                this.mHistoricalRecords.remove(0);
            }
        }
    }

    private void readHistoricalDataImpl() {
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
        r9 = this;
        r0 = r9.mContext;	 Catch:{ FileNotFoundException -> 0x00ad }
        r1 = r9.mHistoryFileName;	 Catch:{ FileNotFoundException -> 0x00ad }
        r0 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00ad }
        r1 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r2 = "UTF-8";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r1.setInput(r0, r2);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r2 = 0;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0012:
        r3 = 1;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        if (r2 == r3) goto L_0x001d;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0015:
        r4 = 2;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        if (r2 == r4) goto L_0x001d;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0018:
        r2 = r1.next();	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        goto L_0x0012;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x001d:
        r2 = "historical-records";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r2 = r2.equals(r4);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        if (r2 != 0) goto L_0x0031;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0029:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r2 = "Share records file does not start with historical-records tag.";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0031:
        r2 = r9.mHistoricalRecords;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r2.clear();	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0036:
        r4 = r1.next();	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        if (r4 == r3) goto L_0x007a;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x003c:
        r5 = 3;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        if (r4 == r5) goto L_0x0036;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x003f:
        r5 = 4;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        if (r4 == r5) goto L_0x0036;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0042:
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r5 = "historical-record";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r4 = r5.equals(r4);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        if (r4 != 0) goto L_0x0056;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x004e:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r2 = "Share records file not well-formed.";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
    L_0x0056:
        r4 = "activity";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r5 = 0;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r4 = r1.getAttributeValue(r5, r4);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r6 = "time";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r6 = r1.getAttributeValue(r5, r6);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r6 = java.lang.Long.parseLong(r6);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r8 = "weight";	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r5 = r1.getAttributeValue(r5, r8);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r8 = new android.support.v7.widget.ActivityChooserModel$HistoricalRecord;	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r8.<init>(r4, r6, r5);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        r2.add(r8);	 Catch:{ XmlPullParserException -> 0x0094, IOException -> 0x0082 }
        goto L_0x0036;
    L_0x007a:
        if (r0 == 0) goto L_0x00a6;
    L_0x007c:
        r0.close();	 Catch:{ IOException -> 0x007f }
    L_0x007f:
        return;
    L_0x0080:
        r1 = move-exception;
        goto L_0x00a7;
    L_0x0082:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r2 = "Error reading historical recrod file: ";	 Catch:{ all -> 0x0080 }
        r1.<init>(r2);	 Catch:{ all -> 0x0080 }
        r2 = r9.mHistoryFileName;	 Catch:{ all -> 0x0080 }
        r1.append(r2);	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x00a6;
    L_0x0090:
        r0.close();	 Catch:{ IOException -> 0x0093 }
    L_0x0093:
        return;
    L_0x0094:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r2 = "Error reading historical recrod file: ";	 Catch:{ all -> 0x0080 }
        r1.<init>(r2);	 Catch:{ all -> 0x0080 }
        r2 = r9.mHistoryFileName;	 Catch:{ all -> 0x0080 }
        r1.append(r2);	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x00a6;
    L_0x00a2:
        r0.close();	 Catch:{ IOException -> 0x00a5 }
    L_0x00a5:
        return;
    L_0x00a6:
        return;
    L_0x00a7:
        if (r0 == 0) goto L_0x00ac;
    L_0x00a9:
        r0.close();	 Catch:{ IOException -> 0x00ac }
    L_0x00ac:
        throw r1;
    L_0x00ad:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.readHistoricalDataImpl():void");
    }
}
