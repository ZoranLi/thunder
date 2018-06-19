package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions = new ArrayList();
    public final Map<String, Object> values = new HashMap();
    public View view;

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.view == transitionValues.view && this.values.equals(transitionValues.values) != null) {
                return true;
            }
        }
        return null;
    }

    public int hashCode() {
        return (31 * this.view.hashCode()) + this.values.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TransitionValues@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(":\n");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("    view = ");
        stringBuilder3.append(this.view);
        stringBuilder3.append("\n");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("    values:");
        stringBuilder2 = stringBuilder3.toString();
        for (String str : this.values.keySet()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("    ");
            stringBuilder4.append(str);
            stringBuilder4.append(": ");
            stringBuilder4.append(this.values.get(str));
            stringBuilder4.append("\n");
            stringBuilder2 = stringBuilder4.toString();
        }
        return stringBuilder2;
    }
}
