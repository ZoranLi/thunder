package com.xunlei.downloadprovider.member.payment.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: PayPagerAdapter */
public final class ak extends FragmentStatePagerAdapter {
    SparseArray<Fragment> a = new SparseArray();
    List<ae> b;
    private FragmentManager c;

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public ak(FragmentManager fragmentManager, List<ae> list) {
        super(fragmentManager);
        this.c = fragmentManager;
        this.b = list;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup = super.instantiateItem(viewGroup, i);
        StringBuilder stringBuilder = new StringBuilder("instantiateItem--position=");
        stringBuilder.append(i);
        stringBuilder.append("|object=");
        stringBuilder.append(viewGroup);
        return viewGroup;
    }

    public final Fragment getItem(int i) {
        Fragment fragment;
        InstantiationException e;
        StringBuilder stringBuilder;
        IllegalAccessException e2;
        ae aeVar = (ae) this.b.get(i);
        try {
            fragment = (Fragment) aeVar.b.newInstance();
            try {
                Bundle bundle = aeVar.c;
                if (bundle == null) {
                    bundle = new Bundle(1);
                }
                bundle.putInt("position", i);
                fragment.setArguments(bundle);
            } catch (InstantiationException e3) {
                e = e3;
                e.printStackTrace();
                if (fragment != null) {
                    this.a.put(i, fragment);
                }
                stringBuilder = new StringBuilder("getItem--position=");
                stringBuilder.append(i);
                stringBuilder.append("|fragment=");
                stringBuilder.append(fragment);
                return fragment;
            } catch (IllegalAccessException e4) {
                e2 = e4;
                e2.printStackTrace();
                if (fragment != null) {
                    this.a.put(i, fragment);
                }
                stringBuilder = new StringBuilder("getItem--position=");
                stringBuilder.append(i);
                stringBuilder.append("|fragment=");
                stringBuilder.append(fragment);
                return fragment;
            }
        } catch (InstantiationException e5) {
            e = e5;
            fragment = null;
            e.printStackTrace();
            if (fragment != null) {
                this.a.put(i, fragment);
            }
            stringBuilder = new StringBuilder("getItem--position=");
            stringBuilder.append(i);
            stringBuilder.append("|fragment=");
            stringBuilder.append(fragment);
            return fragment;
        } catch (IllegalAccessException e6) {
            e2 = e6;
            fragment = null;
            e2.printStackTrace();
            if (fragment != null) {
                this.a.put(i, fragment);
            }
            stringBuilder = new StringBuilder("getItem--position=");
            stringBuilder.append(i);
            stringBuilder.append("|fragment=");
            stringBuilder.append(fragment);
            return fragment;
        }
        if (fragment != null) {
            this.a.put(i, fragment);
        }
        stringBuilder = new StringBuilder("getItem--position=");
        stringBuilder.append(i);
        stringBuilder.append("|fragment=");
        stringBuilder.append(fragment);
        return fragment;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        viewGroup = this.c.beginTransaction();
        viewGroup.remove((Fragment) obj);
        viewGroup.commitAllowingStateLoss();
    }

    public final int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }
}
