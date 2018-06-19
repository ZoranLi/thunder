package me.iwf.photopicker;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Collection;
import me.iwf.photopicker.fragment.ImagePagerFragment;

public class PhotoPagerActivity extends AppCompatActivity {
    private ImagePagerFragment a;
    private ActionBar b;
    private boolean c;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.__picker_activity_photo_pager);
        bundle = getIntent().getIntExtra("current_item", 0);
        Collection stringArrayListExtra = getIntent().getStringArrayListExtra("photos");
        this.c = getIntent().getBooleanExtra("show_delete", true);
        if (this.a == null) {
            this.a = (ImagePagerFragment) getSupportFragmentManager().findFragmentById(R.id.photoPagerFragment);
        }
        ImagePagerFragment imagePagerFragment = this.a;
        imagePagerFragment.a.clear();
        imagePagerFragment.a.addAll(stringArrayListExtra);
        imagePagerFragment.h = bundle;
        imagePagerFragment.b.setCurrentItem(bundle);
        imagePagerFragment.b.getAdapter().notifyDataSetChanged();
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.b = getSupportActionBar();
        if (this.b != null) {
            this.b.setDisplayHomeAsUpEnabled(true);
            a();
            if (VERSION.SDK_INT >= 21) {
                this.b.setElevation(25.0f);
            }
        }
        this.a.b.addOnPageChangeListener(new a(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.c) {
            getMenuInflater().inflate(R.menu.__picker_menu_preview, menu);
        }
        return true;
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("SELECTED_PHOTOS", this.a.a);
        setResult(-1, intent);
        finish();
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        } else if (menuItem.getItemId() != R.id.delete) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            menuItem = this.a.b.getCurrentItem();
            String str = (String) this.a.a.get(menuItem);
            Snackbar make = Snackbar.make(this.a.getView(), R.string.__picker_deleted_a_photo, 0);
            if (this.a.a.size() <= 1) {
                new Builder(this).setTitle(R.string.__picker_confirm_to_delete).setPositiveButton(R.string.__picker_yes, new c(this, menuItem)).setNegativeButton(R.string.__picker_cancel, new b(this)).show();
            } else {
                make.show();
                this.a.a.remove(menuItem);
                this.a.b.getAdapter().notifyDataSetChanged();
            }
            make.setAction(R.string.__picker_undo, new d(this, menuItem, str));
            return true;
        }
    }

    public final void a() {
        if (this.b != null) {
            this.b.setTitle(getString(R.string.__picker_image_index, new Object[]{Integer.valueOf(this.a.b.getCurrentItem() + 1), Integer.valueOf(this.a.a.size())}));
        }
    }
}
