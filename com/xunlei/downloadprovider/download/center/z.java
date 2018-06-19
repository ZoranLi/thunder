package com.xunlei.downloadprovider.download.center;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.web.website.a;

/* compiled from: DownloadCenterActivityFragment */
final class z implements OnPageChangeListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    z(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onPageSelected(int i) {
        DownloadCenterActivityFragment.c(i);
        h.e().a(i);
        this.a.d(i);
        a a = a.a();
        a.b = false;
        a.b();
        this.a.D = false;
        if (i == 3) {
            this.a.D = true;
            this.a.p.setVisibility(8);
            DownloadCenterActivityFragment.d(this.a);
            DownloadCenterActivityFragment.b(this.a, true);
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(false);
        } else {
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(true);
            DownloadCenterActivityFragment.b(this.a, false);
        }
        this.a.n.a().a();
        if (i == 2 || i == 1) {
            i = this.a.n;
            if (i.h.m.getCurrentItem() < 3) {
                TaskListPageFragment taskListPageFragment = (TaskListPageFragment) i.a();
                if (taskListPageFragment.c != null) {
                    taskListPageFragment.c.stopNestedScroll();
                }
            }
        }
    }
}
