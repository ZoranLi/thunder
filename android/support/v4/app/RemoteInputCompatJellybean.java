package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@RequiresApi(16)
class RemoteInputCompatJellybean {
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_LABEL = "label";
    private static final String KEY_RESULT_KEY = "resultKey";

    RemoteInputCompatJellybean() {
    }

    static RemoteInput fromBundle(Bundle bundle, Factory factory) {
        ArrayList stringArrayList = bundle.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        Set hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
        }
        return factory.build(bundle.getString(KEY_RESULT_KEY), bundle.getCharSequence("label"), bundle.getCharSequenceArray(KEY_CHOICES), bundle.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), bundle.getBundle(KEY_EXTRAS), hashSet);
    }

    static Bundle toBundle(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RESULT_KEY, remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray(KEY_CHOICES, remoteInput.getChoices());
        bundle.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, remoteInput.getAllowFreeFormInput());
        bundle.putBundle(KEY_EXTRAS, remoteInput.getExtras());
        RemoteInput<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (!(allowedDataTypes == null || allowedDataTypes.isEmpty())) {
            ArrayList arrayList = new ArrayList(allowedDataTypes.size());
            for (String add : allowedDataTypes) {
                arrayList.add(add);
            }
            bundle.putStringArrayList(KEY_ALLOWED_DATA_TYPES, arrayList);
        }
        return bundle;
    }

    static RemoteInput[] fromBundleArray(Bundle[] bundleArr, Factory factory) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] newArray = factory.newArray(bundleArr.length);
        for (int i = 0; i < bundleArr.length; i++) {
            newArray[i] = fromBundle(bundleArr[i], factory);
        }
        return newArray;
    }

    static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = toBundle(remoteInputArr[i]);
        }
        return bundleArr;
    }

    static Bundle getResultsFromIntent(Intent intent) {
        intent = getClipDataIntentFromIntent(intent);
        if (intent == null) {
            return null;
        }
        return (Bundle) intent.getExtras().getParcelable(RemoteInput.EXTRA_RESULTS_DATA);
    }

    static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        intent = getClipDataIntentFromIntent(intent);
        if (intent == null) {
            return null;
        }
        Map<String, Uri> hashMap = new HashMap();
        for (String str2 : intent.getExtras().keySet()) {
            String str22;
            if (str22.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA)) {
                String substring = str22.substring(39);
                if (!(substring == null || substring.isEmpty())) {
                    str22 = intent.getBundleExtra(str22).getString(str);
                    if (!(str22 == null || str22.isEmpty())) {
                        hashMap.put(substring, Uri.parse(str22));
                    }
                }
            }
        }
        if (hashMap.isEmpty() != null) {
            return null;
        }
        return hashMap;
    }

    static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            clipDataIntentFromIntent = new Intent();
        }
        Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(RemoteInput.EXTRA_RESULTS_DATA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        for (RemoteInput remoteInput : remoteInputArr) {
            Object obj = bundle.get(remoteInput.getResultKey());
            if (obj instanceof CharSequence) {
                bundleExtra.putCharSequence(remoteInput.getResultKey(), (CharSequence) obj);
            }
        }
        clipDataIntentFromIntent.putExtra(RemoteInput.EXTRA_RESULTS_DATA, bundleExtra);
        intent.setClipData(ClipData.newIntent(RemoteInput.RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            clipDataIntentFromIntent = new Intent();
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str = (String) entry.getKey();
            Uri uri = (Uri) entry.getValue();
            if (str != null) {
                Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(getExtraResultsKeyForData(str));
                if (bundleExtra == null) {
                    bundleExtra = new Bundle();
                }
                bundleExtra.putString(remoteInput.getResultKey(), uri.toString());
                clipDataIntentFromIntent.putExtra(getExtraResultsKeyForData(str), bundleExtra);
            }
        }
        intent.setClipData(ClipData.newIntent(RemoteInput.RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
    }

    private static String getExtraResultsKeyForData(String str) {
        StringBuilder stringBuilder = new StringBuilder(EXTRA_DATA_TYPE_RESULTS_DATA);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static Intent getClipDataIntentFromIntent(Intent intent) {
        intent = intent.getClipData();
        if (intent == null) {
            return null;
        }
        ClipDescription description = intent.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals(RemoteInput.RESULTS_CLIP_LABEL)) {
            return intent.getItemAt(0).getIntent();
        }
        return null;
    }
}
