package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import java.util.Set;

public interface RequestManagerTreeNode {
    Set<RequestManager> getDescendants();
}
