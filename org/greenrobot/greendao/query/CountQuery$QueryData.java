package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

final class CountQuery$QueryData<T2> extends AbstractQueryData<T2, CountQuery<T2>> {
    private CountQuery$QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
    }

    protected final CountQuery<T2> createQuery() {
        return new CountQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone(), null);
    }
}
