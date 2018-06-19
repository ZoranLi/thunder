package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageCodecV2 */
public class g extends f {
    protected List<Object> a(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        int i = bundle.getInt("_list_size_");
        List<Object> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            StringBuilder stringBuilder = new StringBuilder("_list_item_");
            stringBuilder.append(i2);
            Object obj = bundle.get(stringBuilder.toString());
            if (!(obj.getClass().isPrimitive() || (obj instanceof String))) {
                if (!(obj instanceof Serializable)) {
                    if (obj instanceof Bundle) {
                        Bundle bundle2 = (Bundle) obj;
                        int i3 = bundle2.getInt("_val_type_", -1);
                        if (i3 == 1) {
                            throw new InstantiationException("Nested List can not be supported");
                        } else if (i3 == 0) {
                            arrayList.add(a(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                        } else {
                            throw new InstantiationException("Unknown type can not be supported");
                        }
                    }
                    continue;
                }
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    protected void a(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i = 0; i < list.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder("_list_item_");
            stringBuilder.append(i);
            a(stringBuilder.toString(), list.get(i), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
