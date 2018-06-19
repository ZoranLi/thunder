package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

final class CursorQuery$QueryData<T2> extends AbstractQueryData<T2, CursorQuery<T2>> {
    private final int limitPosition;
    private final int offsetPosition;

    CursorQuery$QueryData(AbstractDao abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr);
        this.limitPosition = i;
        this.offsetPosition = i2;
    }

    protected final CursorQuery<T2> createQuery() {
        return new CursorQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition, null);
    }
}
