package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] PRIMITIVE_TYPES = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public final JsonPrimitive deepCopy() {
        return this;
    }

    public JsonPrimitive(Boolean bool) {
        setValue(bool);
    }

    public JsonPrimitive(Number number) {
        setValue(number);
    }

    public JsonPrimitive(String str) {
        setValue(str);
    }

    public JsonPrimitive(Character ch) {
        setValue(ch);
    }

    JsonPrimitive(Object obj) {
        setValue(obj);
    }

    final void setValue(Object obj) {
        if (obj instanceof Character) {
            this.value = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z;
        if (!(obj instanceof Number)) {
            if (!isPrimitiveOrString(obj)) {
                z = false;
                C$Gson$Preconditions.checkArgument(z);
                this.value = obj;
            }
        }
        z = true;
        C$Gson$Preconditions.checkArgument(z);
        this.value = obj;
    }

    public final boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    final Boolean getAsBooleanWrapper() {
        return (Boolean) this.value;
    }

    public final boolean getAsBoolean() {
        if (isBoolean()) {
            return getAsBooleanWrapper().booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public final boolean isNumber() {
        return this.value instanceof Number;
    }

    public final Number getAsNumber() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public final boolean isString() {
        return this.value instanceof String;
    }

    public final String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return getAsBooleanWrapper().toString();
        }
        return (String) this.value;
    }

    public final double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public final BigDecimal getAsBigDecimal() {
        return this.value instanceof BigDecimal ? (BigDecimal) this.value : new BigDecimal(this.value.toString());
    }

    public final BigInteger getAsBigInteger() {
        if (this.value instanceof BigInteger) {
            return (BigInteger) this.value;
        }
        return new BigInteger(this.value.toString());
    }

    public final float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    public final long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public final short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    public final int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    public final byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    public final char getAsCharacter() {
        return getAsString().charAt(0);
    }

    private static boolean isPrimitiveOrString(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        obj = obj.getClass();
        for (Class isAssignableFrom : PRIMITIVE_TYPES) {
            if (isAssignableFrom.isAssignableFrom(obj)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.value == null) {
            return 31;
        }
        long longValue;
        if (isIntegral(this)) {
            longValue = getAsNumber().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.value instanceof Number)) {
            return this.value.hashCode();
        } else {
            longValue = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
                if (this.value == null) {
                    return jsonPrimitive.value == null;
                } else {
                    if (isIntegral(this) && isIntegral(jsonPrimitive)) {
                        return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
                    } else {
                        if (!(this.value instanceof Number) || !(jsonPrimitive.value instanceof Number)) {
                            return this.value.equals(jsonPrimitive.value);
                        }
                        double doubleValue = getAsNumber().doubleValue();
                        double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
                        if (doubleValue != doubleValue2) {
                            if (Double.isNaN(doubleValue) == null || Double.isNaN(doubleValue2) == null) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        if (!(jsonPrimitive.value instanceof Number)) {
            return false;
        }
        Number number = (Number) jsonPrimitive.value;
        if (!((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short))) {
            if ((number instanceof Byte) == null) {
                return false;
            }
        }
        return true;
    }
}
