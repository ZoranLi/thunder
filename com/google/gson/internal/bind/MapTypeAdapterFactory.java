package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        private final TypeAdapter<V> valueTypeAdapter;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        public final Map<K, V> read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.constructor.construct();
            Object read;
            StringBuilder stringBuilder;
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    read = this.keyTypeAdapter.read(jsonReader);
                    if (map.put(read, this.valueTypeAdapter.read(jsonReader)) != null) {
                        stringBuilder = new StringBuilder("duplicate key: ");
                        stringBuilder.append(read);
                        throw new JsonSyntaxException(stringBuilder.toString());
                    }
                    jsonReader.endArray();
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    read = this.keyTypeAdapter.read(jsonReader);
                    if (map.put(read, this.valueTypeAdapter.read(jsonReader)) != null) {
                        stringBuilder = new StringBuilder("duplicate key: ");
                        stringBuilder.append(read);
                        throw new JsonSyntaxException(stringBuilder.toString());
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }

        public final void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            if (map == null) {
                jsonWriter.nullValue();
            } else if (MapTypeAdapterFactory.this.complexMapKeySerialization) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                map = map.entrySet().iterator();
                int i = 0;
                int i2 = 0;
                while (map.hasNext()) {
                    int i3;
                    Entry entry = (Entry) map.next();
                    JsonElement toJsonTree = this.keyTypeAdapter.toJsonTree(entry.getKey());
                    arrayList.add(toJsonTree);
                    arrayList2.add(entry.getValue());
                    if (!toJsonTree.isJsonArray()) {
                        if (!toJsonTree.isJsonObject()) {
                            i3 = 0;
                            i2 |= i3;
                        }
                    }
                    i3 = 1;
                    i2 |= i3;
                }
                if (i2 != 0) {
                    jsonWriter.beginArray();
                    map = arrayList.size();
                    while (i < map) {
                        jsonWriter.beginArray();
                        Streams.write((JsonElement) arrayList.get(i), jsonWriter);
                        this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                        jsonWriter.endArray();
                        i++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                map = arrayList.size();
                while (i < map) {
                    jsonWriter.name(keyToString((JsonElement) arrayList.get(i)));
                    this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.endObject();
            } else {
                jsonWriter.beginObject();
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry2 = (Entry) map.next();
                    jsonWriter.name(String.valueOf(entry2.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, entry2.getValue());
                }
                jsonWriter.endObject();
            }
        }

        private String keyToString(JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                jsonElement = jsonElement.getAsJsonPrimitive();
                if (jsonElement.isNumber()) {
                    return String.valueOf(jsonElement.getAsNumber());
                }
                if (jsonElement.isBoolean()) {
                    return Boolean.toString(jsonElement.getAsBoolean());
                }
                if (jsonElement.isString()) {
                    return jsonElement.getAsString();
                }
                throw new AssertionError();
            } else if (jsonElement.isJsonNull() != null) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = z;
    }

    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, C$Gson$Types.getRawType(type));
        return new Adapter(gson, mapKeyAndValueTypes[0], getKeyAdapter(gson, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(typeToken));
    }

    private TypeAdapter<?> getKeyAdapter(Gson gson, Type type) {
        if (type != Boolean.TYPE) {
            if (type != Boolean.class) {
                return gson.getAdapter(TypeToken.get(type));
            }
        }
        return TypeAdapters.BOOLEAN_AS_STRING;
    }
}
