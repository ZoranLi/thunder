package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T> {
    private String id;
    private final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length <= 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = Arrays.asList(transformationArr);
    }

    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (collection.size() <= 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = collection;
    }

    public Resource<T> transform(Resource<T> resource, int i, int i2) {
        Resource<T> resource2 = resource;
        for (Transformation transform : this.transformations) {
            Resource<T> transform2 = transform.transform(resource2, i, i2);
            if (!(resource2 == null || resource2.equals(resource) || resource2.equals(transform2))) {
                resource2.recycle();
            }
            resource2 = transform2;
        }
        return resource2;
    }

    public String getId() {
        if (this.id == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Transformation id : this.transformations) {
                stringBuilder.append(id.getId());
            }
            this.id = stringBuilder.toString();
        }
        return this.id;
    }
}
