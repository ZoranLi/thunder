package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;

public class CountQuery<T> extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    static <T2> CountQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return (CountQuery) new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr), null).forCurrentThread();
    }

    private CountQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.queryData = queryData;
    }

    public CountQuery<T> forCurrentThread() {
        return (CountQuery) this.queryData.forCurrentThread(this);
    }

    public long count() {
        checkThread();
        Cursor rawQuery = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        try {
            if (!rawQuery.moveToNext()) {
                throw new DaoException("No result for count");
            } else if (!rawQuery.isLast()) {
                r2 = new StringBuilder("Unexpected row count: ");
                r2.append(rawQuery.getCount());
                throw new DaoException(r2.toString());
            } else if (rawQuery.getColumnCount() != 1) {
                r2 = new StringBuilder("Unexpected column count: ");
                r2.append(rawQuery.getColumnCount());
                throw new DaoException(r2.toString());
            } else {
                long j = rawQuery.getLong(0);
                return j;
            }
        } finally {
            rawQuery.close();
        }
    }

    public CountQuery<T> setParameter(int i, Object obj) {
        return (CountQuery) super.setParameter(i, obj);
    }

    public CountQuery<T> setParameter(int i, Date date) {
        return (CountQuery) super.setParameter(i, date);
    }

    public CountQuery<T> setParameter(int i, Boolean bool) {
        return (CountQuery) super.setParameter(i, bool);
    }
}
