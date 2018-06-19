package com.google.gson;

public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    public final JsonNull deepCopy() {
        return INSTANCE;
    }

    public final int hashCode() {
        return JsonNull.class.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if ((obj instanceof JsonNull) == null) {
                return null;
            }
        }
        return true;
    }
}
