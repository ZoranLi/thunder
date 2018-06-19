package org.greenrobot.greendao.query;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

public interface WhereCondition {

    public static abstract class AbstractCondition implements WhereCondition {
        protected final boolean hasSingleValue;
        protected final Object value;
        protected final Object[] values;

        public AbstractCondition() {
            this.hasSingleValue = false;
            this.value = null;
            this.values = null;
        }

        public AbstractCondition(Object obj) {
            this.value = obj;
            this.hasSingleValue = true;
            this.values = null;
        }

        public AbstractCondition(Object[] objArr) {
            this.value = null;
            this.hasSingleValue = false;
            this.values = objArr;
        }

        public void appendValuesTo(List<Object> list) {
            if (this.hasSingleValue) {
                list.add(this.value);
                return;
            }
            if (this.values != null) {
                for (Object add : this.values) {
                    list.add(add);
                }
            }
        }
    }

    public static class PropertyCondition extends AbstractCondition {
        public final String op;
        public final Property property;

        private static Object checkValueForType(Property property, Object obj) {
            if (obj != null && obj.getClass().isArray()) {
                throw new DaoException("Illegal value: found array, but simple object required");
            } else if (property.type != Date.class) {
                if (property.type == Boolean.TYPE || property.type == Boolean.class) {
                    if ((obj instanceof Boolean) != null) {
                        return Integer.valueOf(((Boolean) obj).booleanValue());
                    }
                    if ((obj instanceof Number) != null) {
                        property = ((Number) obj).intValue();
                        if (!(property == null || property == 1)) {
                            r0 = new StringBuilder("Illegal boolean value: numbers must be 0 or 1, but was ");
                            r0.append(obj);
                            throw new DaoException(r0.toString());
                        }
                    } else if ((obj instanceof String) != null) {
                        String str = (String) obj;
                        if ("TRUE".equalsIgnoreCase(str)) {
                            return Integer.valueOf(1);
                        }
                        if ("FALSE".equalsIgnoreCase(str) != null) {
                            return Integer.valueOf(null);
                        }
                        r0 = new StringBuilder("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was ");
                        r0.append(obj);
                        throw new DaoException(r0.toString());
                    }
                }
                return obj;
            } else if ((obj instanceof Date) != null) {
                return Long.valueOf(((Date) obj).getTime());
            } else {
                if ((obj instanceof Long) != null) {
                    return obj;
                }
                r0 = new StringBuilder("Illegal date value: expected java.util.Date or Long for value ");
                r0.append(obj);
                throw new DaoException(r0.toString());
            }
        }

        private static Object[] checkValuesForType(Property property, Object[] objArr) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = checkValueForType(property, objArr[i]);
            }
            return objArr;
        }

        public PropertyCondition(Property property, String str) {
            this.property = property;
            this.op = str;
        }

        public PropertyCondition(Property property, String str, Object obj) {
            super(checkValueForType(property, obj));
            this.property = property;
            this.op = str;
        }

        public PropertyCondition(Property property, String str, Object[] objArr) {
            super(checkValuesForType(property, objArr));
            this.property = property;
            this.op = str;
        }

        public void appendTo(StringBuilder stringBuilder, String str) {
            SqlUtils.appendProperty(stringBuilder, str, this.property).append(this.op);
        }
    }

    public static class StringCondition extends AbstractCondition {
        protected final String string;

        public StringCondition(String str) {
            this.string = str;
        }

        public StringCondition(String str, Object obj) {
            super(obj);
            this.string = str;
        }

        public StringCondition(String str, Object... objArr) {
            super(objArr);
            this.string = str;
        }

        public void appendTo(StringBuilder stringBuilder, String str) {
            stringBuilder.append(this.string);
        }
    }

    void appendTo(StringBuilder stringBuilder, String str);

    void appendValuesTo(List<Object> list);
}
