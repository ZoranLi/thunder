package me.iwf.photopicker;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.ArrayList;
import me.iwf.photopicker.fragment.ImagePagerFragment;
import me.iwf.photopicker.fragment.PhotoPickerFragment;
import me.iwf.photopicker.fragment.c;

public class PhotoPickerActivity extends AppCompatActivity {
    static final /* synthetic */ boolean b = true;
    public ImagePagerFragment a;
    private PhotoPickerFragment c;
    private MenuItem d;
    private int e = 9;
    private boolean f = false;
    private boolean g = false;
    private int h = 3;
    private ArrayList<String> i = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("SHOW_CAMERA", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("SHOW_GIF", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("PREVIEW_ENABLED", true);
        this.g = booleanExtra2;
        setContentView(R.layout.__picker_activity_photo_picker);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        setTitle(R.string.__picker_title);
        bundle = getSupportActionBar();
        if (b || bundle != null) {
            bundle.setDisplayHomeAsUpEnabled(true);
            if (VERSION.SDK_INT >= 21) {
                bundle.setElevation(25.0f);
            }
            this.e = getIntent().getIntExtra("MAX_COUNT", 9);
            this.h = getIntent().getIntExtra("column", 3);
            this.i = getIntent().getStringArrayListExtra("ORIGINAL_PHOTOS");
            this.c = (PhotoPickerFragment) getSupportFragmentManager().findFragmentByTag("tag");
            if (this.c == null) {
                this.c = PhotoPickerFragment.a(booleanExtra, booleanExtra2, booleanExtra3, this.h, this.e, this.i);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, this.c, "tag").commit();
                getSupportFragmentManager().executePendingTransactions();
            }
            this.c.a.a = new e(this);
            return;
        }
        throw new AssertionError();
    }

    public void onBackPressed() {
        if (this.a == null || !this.a.isVisible()) {
            super.onBackPressed();
            return;
        }
        ImagePagerFragment imagePagerFragment = this.a;
        Runnable fVar = new f(this);
        if (imagePagerFragment.getArguments().getBoolean("HAS_ANIM", false)) {
            if (imagePagerFragment.g) {
                ViewPropertyAnimator.animate(imagePagerFragment.b).setDuration(200).setInterpolator(new AccelerateInterpolator()).scaleX(((float) imagePagerFragment.e) / ((float) imagePagerFragment.b.getWidth())).scaleY(((float) imagePagerFragment.f) / ((float) imagePagerFragment.b.getHeight())).translationX((float) imagePagerFragment.d).translationY((float) imagePagerFragment.c).setListener(new c(imagePagerFragment, fVar));
                ObjectAnimator ofInt = ObjectAnimator.ofInt(imagePagerFragment.b.getBackground(), "alpha", new int[]{0});
                ofInt.setDuration(200);
                ofInt.start();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imagePagerFragment, "saturation", new float[]{1.0f, 0.0f});
                ofFloat.setDuration(200);
                ofFloat.start();
                return;
            }
        }
        fVar.run();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f) {
            return false;
        }
        getMenuInflater().inflate(R.menu.__picker_menu_picker, menu);
        this.d = menu.findItem(R.id.done);
        if (this.i == null || this.i.size() <= null) {
            this.d.setEnabled(false);
        } else {
            this.d.setEnabled(true);
            this.d.setTitle(getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(this.i.size()), Integer.valueOf(this.e)}));
        }
        this.f = true;
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            super.onBackPressed();
            return true;
        } else if (menuItem.getItemId() != R.id.done) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            menuItem = new Intent();
            menuItem.putStringArrayListExtra("SELECTED_PHOTOS", this.c.a.a());
            setResult(-1, menuItem);
            finish();
            return true;
        }
    }
}
