package android.support.v4.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput extends android.support.v4.app.RemoteInputCompatBase.RemoteInput {
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static final Factory FACTORY = new Factory() {
        public final RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, Set<String> set) {
            return new RemoteInput(str, charSequence, charSequenceArr, z, bundle, set);
        }

        public final RemoteInput[] newArray(int i) {
            return new RemoteInput[i];
        }
    };
    private static final Impl IMPL;
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    public static final class Builder {
        private boolean mAllowFreeFormTextInput = true;
        private final Set<String> mAllowedDataTypes = new HashSet();
        private CharSequence[] mChoices;
        private Bundle mExtras = new Bundle();
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.mResultKey = str;
        }

        public final Builder setLabel(CharSequence charSequence) {
            this.mLabel = charSequence;
            return this;
        }

        public final Builder setChoices(CharSequence[] charSequenceArr) {
            this.mChoices = charSequenceArr;
            return this;
        }

        public final Builder setAllowDataType(String str, boolean z) {
            if (z) {
                this.mAllowedDataTypes.add(str);
            } else {
                this.mAllowedDataTypes.remove(str);
            }
            return this;
        }

        public final Builder setAllowFreeFormInput(boolean z) {
            this.mAllowFreeFormTextInput = z;
            return this;
        }

        public final Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            return this;
        }

        public final Bundle getExtras() {
            return this.mExtras;
        }

        public final RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mExtras, this.mAllowedDataTypes);
        }
    }

    interface Impl {
        void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map);

        void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);

        Map<String, Uri> getDataResultsFromIntent(Intent intent, String str);

        Bundle getResultsFromIntent(Intent intent);
    }

    @RequiresApi(20)
    static class ImplApi20 implements Impl {
        ImplApi20() {
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatApi20.getResultsFromIntent(intent);
        }

        public Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
            return RemoteInputCompatApi20.getDataResultsFromIntent(intent, str);
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatApi20.addResultsToIntent(remoteInputArr, intent, bundle);
        }

        public void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
            RemoteInputCompatApi20.addDataResultToIntent(remoteInput, intent, map);
        }
    }

    static class ImplBase implements Impl {
        public void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        }

        public Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
            return null;
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return null;
        }

        ImplBase() {
        }
    }

    @RequiresApi(16)
    static class ImplJellybean implements Impl {
        ImplJellybean() {
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatJellybean.getResultsFromIntent(intent);
        }

        public Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
            return RemoteInputCompatJellybean.getDataResultsFromIntent(intent, str);
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatJellybean.addResultsToIntent(remoteInputArr, intent, bundle);
        }

        public void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
            RemoteInputCompatJellybean.addDataResultToIntent(remoteInput, intent, map);
        }
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, Set<String> set) {
        this.mResultKey = str;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArr;
        this.mAllowFreeFormTextInput = z;
        this.mExtras = bundle;
        this.mAllowedDataTypes = set;
    }

    public final String getResultKey() {
        return this.mResultKey;
    }

    public final CharSequence getLabel() {
        return this.mLabel;
    }

    public final CharSequence[] getChoices() {
        return this.mChoices;
    }

    public final Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public final boolean isDataOnly() {
        return (getAllowFreeFormInput() || ((getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty())) ? false : true;
    }

    public final boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        return IMPL.getDataResultsFromIntent(intent, str);
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return IMPL.getResultsFromIntent(intent);
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        IMPL.addResultsToIntent(remoteInputArr, intent, bundle);
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        IMPL.addDataResultToIntent(remoteInput, intent, map);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            IMPL = new ImplApi20();
        } else if (VERSION.SDK_INT >= 16) {
            IMPL = new ImplJellybean();
        } else {
            IMPL = new ImplBase();
        }
    }
}
