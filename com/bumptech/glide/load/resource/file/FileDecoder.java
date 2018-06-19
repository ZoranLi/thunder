package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder implements ResourceDecoder<File, File> {
    public String getId() {
        return "";
    }

    public Resource<File> decode(File file, int i, int i2) {
        return new FileResource(file);
    }
}
