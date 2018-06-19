package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final GsonContextImpl context = new GsonContextImpl();
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    private final class GsonContextImpl implements JsonDeserializationContext, JsonSerializationContext {
        private GsonContextImpl() {
        }

        public final JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        public final JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }

        public final <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }
    }

    private static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            JsonDeserializer jsonDeserializer = null;
            this.serializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            if (obj instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) obj;
            }
            this.deserializer = jsonDeserializer;
            if (this.serializer == null) {
                if (this.deserializer == null) {
                    obj = null;
                    C$Gson$Preconditions.checkArgument(obj);
                    this.exactType = typeToken;
                    this.matchRawType = z;
                    this.hierarchyType = cls;
                }
            }
            obj = true;
            C$Gson$Preconditions.checkArgument(obj);
            this.exactType = typeToken;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean z;
            if (this.exactType != null) {
                if (!this.exactType.equals(typeToken)) {
                    if (!this.matchRawType || this.exactType.getType() != typeToken.getRawType()) {
                        z = false;
                    }
                }
                z = true;
            } else {
                z = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            }
            return z ? new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this) : null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    public final T read(JsonReader jsonReader) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        jsonReader = Streams.parse(jsonReader);
        if (jsonReader.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(jsonReader, this.typeToken.getType(), this.context);
    }

    public final void write(JsonWriter jsonWriter, T t) throws IOException {
        if (this.serializer == null) {
            delegate().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(this.serializer.serialize(t, this.typeToken.getType(), this.context), jsonWriter);
        }
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        typeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = typeAdapter;
        return typeAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }
}
