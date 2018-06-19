package com.xunlei.downloadprovider.frame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentPagerAdapterNormal */
public final class e extends FragmentStatePagerAdapter {
    SparseArray<Fragment> a;
    private List<Class<? extends Fragment>> b;
    private List<Bundle> c;

    public final int getItemPosition(Object obj) {
        return -2;
    }

    private e(FragmentManager fragmentManager, Class<?>[] clsArr) {
        super(fragmentManager);
        this.a = new SparseArray();
        this.b = new ArrayList();
        if (clsArr != null && clsArr.length > null) {
            for (Object add : clsArr) {
                this.b.add(add);
            }
            this.c = null;
        }
    }

    public e(FragmentManager fragmentManager, Class<?>[] clsArr, byte b) {
        this(fragmentManager, clsArr);
    }

    public final Fragment getItem(int i) {
        Fragment fragment;
        InstantiationException e;
        IllegalAccessException e2;
        Fragment fragment2 = (Fragment) this.a.get(i);
        if (fragment2 == null) {
            try {
                fragment = (Fragment) ((Class) this.b.get(i)).newInstance();
                Bundle bundle = null;
                try {
                    if (this.c != null && this.c.size() > i) {
                        bundle = (Bundle) this.c.get(i);
                    }
                    if (bundle == null) {
                        bundle = new Bundle(1);
                    }
                    bundle.putInt("position", i);
                    fragment.setArguments(bundle);
                } catch (InstantiationException e3) {
                    e = e3;
                    e.printStackTrace();
                    fragment2 = fragment;
                    if (fragment2 != null) {
                        this.a.put(i, fragment2);
                    }
                    return fragment2;
                } catch (IllegalAccessException e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    fragment2 = fragment;
                    if (fragment2 != null) {
                        this.a.put(i, fragment2);
                    }
                    return fragment2;
                }
            } catch (InstantiationException e5) {
                InstantiationException instantiationException = e5;
                fragment = fragment2;
                e = instantiationException;
                e.printStackTrace();
                fragment2 = fragment;
                if (fragment2 != null) {
                    this.a.put(i, fragment2);
                }
                return fragment2;
            } catch (IllegalAccessException e6) {
                IllegalAccessException illegalAccessException = e6;
                fragment = fragment2;
                e2 = illegalAccessException;
                e2.printStackTrace();
                fragment2 = fragment;
                if (fragment2 != null) {
                    this.a.put(i, fragment2);
                }
                return fragment2;
            }
            fragment2 = fragment;
            if (fragment2 != null) {
                this.a.put(i, fragment2);
            }
        }
        return fragment2;
    }

    public final int getCount() {
        return this.b.size();
    }
}
