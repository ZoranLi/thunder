package com.xunlei.downloadprovider.download.engine.kernel;

import android.database.Cursor;
import com.xunlei.download.Downloads.Impl;

/* compiled from: ColumnIndex */
public final class e {
    public int A;
    public int B;
    public int C;
    public int D = -1;
    public int E = -1;
    public int F;
    public int G;
    public int H;
    public int I;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o = -1;
    public int p = -1;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public final boolean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        this.a = cursor.getColumnIndex("_id");
        this.b = cursor.getColumnIndex("cid");
        this.c = cursor.getColumnIndex("gcid");
        this.d = cursor.getColumnIndex("title");
        this.e = cursor.getColumnIndex("uri");
        this.i = cursor.getColumnIndex(Impl._DATA);
        this.f = cursor.getColumnIndex("total_bytes");
        this.n = cursor.getColumnIndex("mimetype");
        this.m = cursor.getColumnIndex("errorMsg");
        this.g = cursor.getColumnIndex("status");
        this.h = cursor.getColumnIndex("task_type");
        this.j = cursor.getColumnIndex("create_time");
        this.k = cursor.getColumnIndex(Impl.COLUMN_LAST_MODIFICATION);
        this.l = cursor.getColumnIndex("download_duration");
        this.o = cursor.getColumnIndex(Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI);
        this.q = cursor.getColumnIndex(Impl.COLUMN_CURRENT_BYTES);
        this.s = cursor.getColumnIndex("origin_receive_size");
        this.r = cursor.getColumnIndex("download_speed");
        this.t = cursor.getColumnIndex("origin_speed");
        this.u = cursor.getColumnIndex("p2s_speed");
        this.w = cursor.getColumnIndex("p2p_speed");
        this.v = cursor.getColumnIndex("p2s_receive_size");
        this.x = cursor.getColumnIndex("p2p_receive_size");
        this.y = cursor.getColumnIndex("is_vip_speedup");
        this.B = cursor.getColumnIndex("addition_vip_speed");
        this.C = cursor.getColumnIndex("vip_receive_size");
        this.z = cursor.getColumnIndex("vip_status");
        this.A = cursor.getColumnIndex("vip_errno");
        this.D = cursor.getColumnIndex("dcdn_speed");
        this.E = cursor.getColumnIndex("dcdn_receive_size");
        this.F = cursor.getColumnIndex(Impl.COLUMN_RES_TOTAL);
        this.G = cursor.getColumnIndex(Impl.COLUMN_RES_USED_TOTAL);
        this.H = cursor.getColumnIndex("etag");
        this.o = cursor.getColumnIndex(Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI);
        this.p = cursor.getColumnIndex(Impl.COLUMN_CUSTOM_FLAGS);
        this.I = cursor.getColumnIndex(Impl.COLUMN_RANGE_INFO);
        return true;
    }
}
