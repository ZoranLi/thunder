package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.arch.lifecycle.Lifecycle.Event;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: ReportFragment */
public final class h extends Fragment {
    private a a;

    /* compiled from: ReportFragment */
    interface a {
    }

    public static void a(Activity activity) {
        activity = activity.getFragmentManager();
        if (activity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            activity.beginTransaction().add(new h(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            activity.executePendingTransactions();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(Event.ON_CREATE);
    }

    public final void onStart() {
        super.onStart();
        a(Event.ON_START);
    }

    public final void onResume() {
        super.onResume();
        a(Event.ON_RESUME);
    }

    public final void onPause() {
        super.onPause();
        a(Event.ON_PAUSE);
    }

    public final void onStop() {
        super.onStop();
        a(Event.ON_STOP);
    }

    public final void onDestroy() {
        super.onDestroy();
        a(Event.ON_DESTROY);
        this.a = null;
    }

    private void a(Event event) {
        Activity activity = getActivity();
        if (activity instanceof e) {
            ((e) activity).a().a(event);
            return;
        }
        if (activity instanceof b) {
            Lifecycle lifecycle = ((b) activity).getLifecycle();
            if (lifecycle instanceof c) {
                ((c) lifecycle).a(event);
            }
        }
    }
}
