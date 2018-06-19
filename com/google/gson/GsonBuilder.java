package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
    private boolean complexMapKeySerialization = false;
    private String datePattern;
    private int dateStyle = 2;
    private boolean escapeHtmlChars = true;
    private Excluder excluder = Excluder.DEFAULT;
    private final List<TypeAdapterFactory> factories = new ArrayList();
    private FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
    private boolean generateNonExecutableJson = false;
    private final List<TypeAdapterFactory> hierarchyFactories = new ArrayList();
    private final Map<Type, InstanceCreator<?>> instanceCreators = new HashMap();
    private boolean lenient = false;
    private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    private boolean prettyPrinting = false;
    private boolean serializeNulls = false;
    private boolean serializeSpecialFloatingPointValues = false;
    private int timeStyle = 2;

    public final GsonBuilder setVersion(double d) {
        this.excluder = this.excluder.withVersion(d);
        return this;
    }

    public final GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.excluder = this.excluder.withModifiers(iArr);
        return this;
    }

    public final GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public final GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public final GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public final GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public final GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public final GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = longSerializationPolicy;
        return this;
    }

    public final GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }

    public final GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public final GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        for (ExclusionStrategy withExclusionStrategy : exclusionStrategyArr) {
            this.excluder = this.excluder.withExclusionStrategy(withExclusionStrategy, true, true);
        }
        return this;
    }

    public final GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public final GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public final GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public final GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public final GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public final GsonBuilder setDateFormat(String str) {
        this.datePattern = str;
        return this;
    }

    public final GsonBuilder setDateFormat(int i) {
        this.dateStyle = i;
        this.datePattern = 0;
        return this;
    }

    public final GsonBuilder setDateFormat(int i, int i2) {
        this.dateStyle = i;
        this.timeStyle = i2;
        this.datePattern = 0;
        return this;
    }

    public final GsonBuilder registerTypeAdapter(Type type, Object obj) {
        boolean z;
        boolean z2 = obj instanceof JsonSerializer;
        if (!(z2 || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator))) {
            if (!(obj instanceof TypeAdapter)) {
                z = false;
                C$Gson$Preconditions.checkArgument(z);
                if (obj instanceof InstanceCreator) {
                    this.instanceCreators.put(type, (InstanceCreator) obj);
                }
                if (z2 || (obj instanceof JsonDeserializer)) {
                    this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
                }
                if (obj instanceof TypeAdapter) {
                    this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
                }
                return this;
            }
        }
        z = true;
        C$Gson$Preconditions.checkArgument(z);
        if (obj instanceof InstanceCreator) {
            this.instanceCreators.put(type, (InstanceCreator) obj);
        }
        this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
        if (obj instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public final GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        this.factories.add(typeAdapterFactory);
        return this;
    }

    public final GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        boolean z;
        boolean z2 = obj instanceof JsonSerializer;
        if (!(z2 || (obj instanceof JsonDeserializer))) {
            if (!(obj instanceof TypeAdapter)) {
                z = false;
                C$Gson$Preconditions.checkArgument(z);
                if ((obj instanceof JsonDeserializer) || z2) {
                    this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
                }
                if (obj instanceof TypeAdapter) {
                    this.factories.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
                }
                return this;
            }
        }
        z = true;
        C$Gson$Preconditions.checkArgument(z);
        this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
        if (obj instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public final GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public final Gson create() {
        List arrayList = new ArrayList((this.factories.size() + this.hierarchyFactories.size()) + 3);
        arrayList.addAll(this.factories);
        Collections.reverse(arrayList);
        Collection arrayList2 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
        return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, arrayList);
    }

    private void addTypeAdaptersForDate(String str, int i, int i2, List<TypeAdapterFactory> list) {
        TypeAdapter defaultDateTypeAdapter;
        TypeAdapter defaultDateTypeAdapter2;
        TypeAdapter typeAdapter;
        if (str != null && !"".equals(str.trim())) {
            i = new DefaultDateTypeAdapter(Date.class, str);
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(Timestamp.class, str);
            defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(java.sql.Date.class, str);
            typeAdapter = i;
        } else if (i != 2 && i2 != 2) {
            typeAdapter = new DefaultDateTypeAdapter(Date.class, i, i2);
            defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
            TypeAdapter defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
            defaultDateTypeAdapter = defaultDateTypeAdapter2;
            defaultDateTypeAdapter2 = defaultDateTypeAdapter3;
        } else {
            return;
        }
        list.add(TypeAdapters.newFactory(Date.class, typeAdapter));
        list.add(TypeAdapters.newFactory(Timestamp.class, defaultDateTypeAdapter));
        list.add(TypeAdapters.newFactory(java.sql.Date.class, defaultDateTypeAdapter2));
    }
}
