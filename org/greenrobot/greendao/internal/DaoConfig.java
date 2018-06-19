package org.greenrobot.greendao.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.identityscope.IdentityScopeObject;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public final class DaoConfig implements Cloneable {
    public final String[] allColumns;
    public final Database db;
    private IdentityScope<?, ?> identityScope;
    public final boolean keyIsNumeric;
    public final String[] nonPkColumns;
    public final String[] pkColumns;
    public final Property pkProperty;
    public final Property[] properties;
    public final TableStatements statements;
    public final String tablename;

    public DaoConfig(Database database, Class<? extends AbstractDao<?, ?>> cls) {
        this.db = database;
        try {
            Property property = null;
            this.tablename = (String) cls.getField("TABLENAME").get(null);
            cls = reflectProperties(cls);
            this.properties = cls;
            this.allColumns = new String[cls.length];
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            Property property2 = null;
            for (int i = 0; i < cls.length; i++) {
                Property property3 = cls[i];
                String str = property3.columnName;
                this.allColumns[i] = str;
                if (property3.primaryKey) {
                    arrayList.add(str);
                    property2 = property3;
                } else {
                    arrayList2.add(str);
                }
            }
            this.nonPkColumns = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            this.pkColumns = (String[]) arrayList.toArray(new String[arrayList.size()]);
            boolean z = true;
            if (this.pkColumns.length == 1) {
                property = property2;
            }
            this.pkProperty = property;
            this.statements = new TableStatements(database, this.tablename, this.allColumns, this.pkColumns);
            if (this.pkProperty != null) {
                database = this.pkProperty.type;
                if (database.equals(Long.TYPE) == null && database.equals(Long.class) == null && database.equals(Integer.TYPE) == null && database.equals(Integer.class) == null && database.equals(Short.TYPE) == null && database.equals(Short.class) == null && database.equals(Byte.TYPE) == null) {
                    if (database.equals(Byte.class) == null) {
                        z = false;
                    }
                }
                this.keyIsNumeric = z;
                return;
            }
            this.keyIsNumeric = false;
        } catch (Database database2) {
            throw new DaoException("Could not init DAOConfig", database2);
        }
    }

    private static Property[] reflectProperties(Class<? extends AbstractDao<?, ?>> cls) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cls.getName());
        stringBuilder.append("$Properties");
        cls = Class.forName(stringBuilder.toString()).getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : cls) {
            if ((field.getModifiers() & 9) == 9) {
                Object obj = field.get(null);
                if (obj instanceof Property) {
                    arrayList.add((Property) obj);
                }
            }
        }
        cls = new Property[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Property property = (Property) it.next();
            if (cls[property.ordinal] != null) {
                throw new DaoException("Duplicate property ordinals");
            }
            cls[property.ordinal] = property;
        }
        return cls;
    }

    public DaoConfig(DaoConfig daoConfig) {
        this.db = daoConfig.db;
        this.tablename = daoConfig.tablename;
        this.properties = daoConfig.properties;
        this.allColumns = daoConfig.allColumns;
        this.pkColumns = daoConfig.pkColumns;
        this.nonPkColumns = daoConfig.nonPkColumns;
        this.pkProperty = daoConfig.pkProperty;
        this.statements = daoConfig.statements;
        this.keyIsNumeric = daoConfig.keyIsNumeric;
    }

    public final DaoConfig clone() {
        return new DaoConfig(this);
    }

    public final IdentityScope<?, ?> getIdentityScope() {
        return this.identityScope;
    }

    public final void clearIdentityScope() {
        IdentityScope identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public final void setIdentityScope(IdentityScope<?, ?> identityScope) {
        this.identityScope = identityScope;
    }

    public final void initIdentityScope(IdentityScopeType identityScopeType) {
        if (identityScopeType == IdentityScopeType.None) {
            this.identityScope = null;
        } else if (identityScopeType != IdentityScopeType.Session) {
            StringBuilder stringBuilder = new StringBuilder("Unsupported type: ");
            stringBuilder.append(identityScopeType);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.keyIsNumeric != null) {
            this.identityScope = new IdentityScopeLong();
        } else {
            this.identityScope = new IdentityScopeObject();
        }
    }
}
