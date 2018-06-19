package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.ad.home.a.f;
import java.util.ArrayList;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments = new ArrayList();
    private ArrayList<SavedState> mSavedState = new ArrayList();

    public abstract Fragment getItem(int i);

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            StringBuilder stringBuilder = new StringBuilder("ViewPager with adapter ");
            stringBuilder.append(this);
            stringBuilder.append(" requires a view id");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment;
        if (this.mFragments.size() > i) {
            fragment = (Fragment) this.mFragments.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        fragment = getItem(i);
        if (this.mSavedState.size() > i) {
            SavedState savedState = (SavedState) this.mSavedState.get(i);
            if (savedState != null) {
                fragment.setInitialSavedState(savedState);
            }
        }
        while (this.mFragments.size() <= i) {
            this.mFragments.add(null);
        }
        fragment.setMenuVisibility(false);
        fragment.setUserVisibleHint(false);
        this.mFragments.set(i, fragment);
        this.mCurTransaction.add(viewGroup.getId(), fragment);
        return fragment;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        while (this.mSavedState.size() <= i) {
            this.mSavedState.add(null);
        }
        this.mSavedState.set(i, fragment.isAdded() ? this.mFragmentManager.saveFragmentInstanceState(fragment) : null);
        this.mFragments.set(i, null);
        this.mCurTransaction.remove(fragment);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.mCurTransaction != null) {
            this.mCurTransaction.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view ? true : null;
    }

    public Parcelable saveState() {
        Parcelable bundle;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.mFragments.size(); i++) {
            Fragment fragment = (Fragment) this.mFragments.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                StringBuilder stringBuilder = new StringBuilder(f.a);
                stringBuilder.append(i);
                this.mFragmentManager.putFragment(bundle, stringBuilder.toString(), fragment);
            }
        }
        return bundle;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            classLoader = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (classLoader != null) {
                for (Object obj : classLoader) {
                    this.mSavedState.add((SavedState) obj);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(f.a)) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.mFragmentManager.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.mFragments.set(parseInt, fragment);
                    }
                }
            }
        }
    }
}
