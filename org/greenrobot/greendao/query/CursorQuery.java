package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;

public class CursorQuery<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;

    public /* bridge */ /* synthetic */ void setLimit(int i) {
        super.setLimit(i);
    }

    public /* bridge */ /* synthetic */ void setOffset(int i) {
        super.setOffset(i);
    }

    public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    static <T2> CursorQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i, int i2) {
        return (CursorQuery) new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr), i, i2).forCurrentThread();
    }

    private CursorQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr, i, i2);
        this.queryData = queryData;
    }

    public CursorQuery forCurrentThread() {
        return (CursorQuery) this.queryData.forCurrentThread(this);
    }

    public Cursor query() {
        checkThread();
        return this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    }

    public CursorQuery<T> setParameter(int i, Object obj) {
        return (CursorQuery) super.setParameter(i, obj);
    }

    public CursorQuery<T> setParameter(int i, Date date) {
        return (CursorQuery) super.setParameter(i, date);
    }

    public CursorQuery<T> setParameter(int i, Boolean bool) {
        return (CursorQuery) super.setParameter(i, bool);
    }
}
