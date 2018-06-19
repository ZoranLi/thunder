package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.identityscope.IdentityScope;

public abstract class AbstractDaoTest<D extends AbstractDao<T, K>, T, K> extends DbTest {
    protected D dao;
    protected InternalUnitTestDaoAccess<T, K> daoAccess;
    protected final Class<D> daoClass;
    protected IdentityScope<K, T> identityScopeForDao;
    protected Property pkColumn;

    public AbstractDaoTest(Class<D> cls) {
        this(cls, true);
    }

    public AbstractDaoTest(Class<D> cls, boolean z) {
        super(z);
        this.daoClass = cls;
    }

    public void setIdentityScopeBeforeSetUp(IdentityScope<K, T> identityScope) {
        this.identityScopeForDao = identityScope;
    }

    protected void setUp() throws Exception {
        super.setUp();
        try {
            setUpTableForDao();
            this.daoAccess = new InternalUnitTestDaoAccess(this.db, this.daoClass, this.identityScopeForDao);
            this.dao = this.daoAccess.getDao();
        } catch (Throwable e) {
            throw new RuntimeException("Could not prepare DAO Test", e);
        }
    }

    protected void setUpTableForDao() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.daoClass;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r1 = "createTable";	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2 = 2;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = org.greenrobot.greendao.database.Database.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r5 = 0;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3[r5] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r6 = 1;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3[r6] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x0026 }
        r1 = 0;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = r7.db;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2[r5] = r3;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = java.lang.Boolean.valueOf(r5);	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2[r6] = r3;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r0.invoke(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0026 }
        return;
    L_0x0026:
        r0 = "No createTable method";
        org.greenrobot.greendao.DaoLog.i(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.test.AbstractDaoTest.setUpTableForDao():void");
    }

    protected void clearIdentityScopeIfAny() {
        if (this.identityScopeForDao != null) {
            this.identityScopeForDao.clear();
            DaoLog.d("Identity scope cleared");
            return;
        }
        DaoLog.d("No identity scope to clear");
    }

    protected void logTableDump() {
        logTableDump(this.dao.getTablename());
    }
}
