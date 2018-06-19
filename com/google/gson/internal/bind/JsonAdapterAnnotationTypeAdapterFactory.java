package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    final TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        constructorConstructor = constructorConstructor.get(TypeToken.get(jsonAdapter.value())).construct();
        if (constructorConstructor instanceof TypeAdapter) {
            constructorConstructor = (TypeAdapter) constructorConstructor;
        } else if (constructorConstructor instanceof TypeAdapterFactory) {
            constructorConstructor = ((TypeAdapterFactory) constructorConstructor).create(gson, typeToken);
        } else {
            boolean z = constructorConstructor instanceof JsonSerializer;
            if (!z) {
                if (!(constructorConstructor instanceof JsonDeserializer)) {
                    jsonAdapter = new StringBuilder("Invalid attempt to bind an instance of ");
                    jsonAdapter.append(constructorConstructor.getClass().getName());
                    jsonAdapter.append(" as a @JsonAdapter for ");
                    jsonAdapter.append(typeToken.toString());
                    jsonAdapter.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                    throw new IllegalArgumentException(jsonAdapter.toString());
                }
            }
            JsonDeserializer jsonDeserializer = null;
            JsonSerializer jsonSerializer = z ? (JsonSerializer) constructorConstructor : null;
            if (constructorConstructor instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) constructorConstructor;
            }
            ConstructorConstructor treeTypeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, null);
        }
        return (constructorConstructor == null || jsonAdapter.nullSafe() == null) ? constructorConstructor : constructorConstructor.nullSafe();
    }
}
