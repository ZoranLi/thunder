package me.iwf.photopicker.fragment;

import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.bumptech.glide.Glide;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.iwf.photopicker.R;
import me.iwf.photopicker.a.e;

public class ImagePagerFragment extends Fragment {
    public ArrayList<String> a;
    public ViewPager b;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public boolean g = false;
    public int h = 0;
    private e i;
    private final ColorMatrix j = new ColorMatrix();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ArrayList();
        bundle = getArguments();
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray("PATHS");
            this.a.clear();
            if (stringArray != null) {
                this.a = new ArrayList(Arrays.asList(stringArray));
            }
            this.g = bundle.getBoolean("HAS_ANIM");
            this.h = bundle.getInt("ARG_CURRENT_ITEM");
            this.c = bundle.getInt("THUMBNAIL_TOP");
            this.d = bundle.getInt("THUMBNAIL_LEFT");
            this.e = bundle.getInt("THUMBNAIL_WIDTH");
            this.f = bundle.getInt("THUMBNAIL_HEIGHT");
        }
        this.i = new e(Glide.with(this), this.a);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.__picker_picker_fragment_image_pager, viewGroup, false);
        this.b = (ViewPager) layoutInflater.findViewById(R.id.vp_photos);
        this.b.setAdapter(this.i);
        this.b.setCurrentItem(this.h);
        this.b.setOffscreenPageLimit(5);
        if (bundle == null && this.g != null) {
            this.b.getViewTreeObserver().addOnPreDrawListener(new a(this));
        }
        this.b.addOnPageChangeListener(new b(this));
        return layoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.clear();
        this.a = null;
        if (this.b != null) {
            this.b.setAdapter(null);
        }
    }

    public static ImagePagerFragment a(List<String> list, int i, int[] iArr, int i2, int i3) {
        ImagePagerFragment imagePagerFragment = new ImagePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("PATHS", (String[]) list.toArray(new String[list.size()]));
        bundle.putInt("ARG_CURRENT_ITEM", i);
        bundle.putBoolean("HAS_ANIM", false);
        imagePagerFragment.setArguments(bundle);
        imagePagerFragment.getArguments().putInt("THUMBNAIL_LEFT", iArr[0]);
        imagePagerFragment.getArguments().putInt("THUMBNAIL_TOP", iArr[1]);
        imagePagerFragment.getArguments().putInt("THUMBNAIL_WIDTH", i2);
        imagePagerFragment.getArguments().putInt("THUMBNAIL_HEIGHT", i3);
        imagePagerFragment.getArguments().putBoolean("HAS_ANIM", true);
        return imagePagerFragment;
    }

    static /* synthetic */ void d(ImagePagerFragment imagePagerFragment) {
        ViewHelper.setPivotX(imagePagerFragment.b, 0.0f);
        ViewHelper.setPivotY(imagePagerFragment.b, 0.0f);
        ViewHelper.setScaleX(imagePagerFragment.b, ((float) imagePagerFragment.e) / ((float) imagePagerFragment.b.getWidth()));
        ViewHelper.setScaleY(imagePagerFragment.b, ((float) imagePagerFragment.f) / ((float) imagePagerFragment.b.getHeight()));
        ViewHelper.setTranslationX(imagePagerFragment.b, (float) imagePagerFragment.d);
        ViewHelper.setTranslationY(imagePagerFragment.b, (float) imagePagerFragment.c);
        ViewPropertyAnimator.animate(imagePagerFragment.b).setDuration(200).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofInt = ObjectAnimator.ofInt(imagePagerFragment.b.getBackground(), "alpha", new int[]{0, 255});
        ofInt.setDuration(200);
        ofInt.start();
        imagePagerFragment = ObjectAnimator.ofFloat(imagePagerFragment, "saturation", new float[]{0.0f, 1.0f});
        imagePagerFragment.setDuration(200);
        imagePagerFragment.start();
    }
}
