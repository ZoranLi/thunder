package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

final class DeleteQuery$QueryData<T2> extends AbstractQueryData<T2, DeleteQuery<T2>> {
    private DeleteQuery$QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
    }

    protected final DeleteQuery<T2> createQuery() {
        return new DeleteQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone(), null);
    }
}
