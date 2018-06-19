package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.Priority;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;

class GifFrameModelLoader implements ModelLoader<GifDecoder, GifDecoder> {

    private static class GifFrameDataFetcher implements DataFetcher<GifDecoder> {
        private final GifDecoder decoder;

        public void cancel() {
        }

        public void cleanup() {
        }

        public GifFrameDataFetcher(GifDecoder gifDecoder) {
            this.decoder = gifDecoder;
        }

        public GifDecoder loadData(Priority priority) {
            return this.decoder;
        }

        public String getId() {
            return String.valueOf(this.decoder.getCurrentFrameIndex());
        }
    }

    GifFrameModelLoader() {
    }

    public DataFetcher<GifDecoder> getResourceFetcher(GifDecoder gifDecoder, int i, int i2) {
        return new GifFrameDataFetcher(gifDecoder);
    }
}
