package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class PreFillQueue {
    private final Map<PreFillType, Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        this.bitmapsPerType = map;
        this.keyList = new ArrayList(map.keySet());
        map = map.values().iterator();
        while (map.hasNext()) {
            this.bitmapsRemaining += ((Integer) map.next()).intValue();
        }
    }

    public final PreFillType remove() {
        PreFillType preFillType = (PreFillType) this.keyList.get(this.keyIndex);
        Integer num = (Integer) this.bitmapsPerType.get(preFillType);
        if (num.intValue() == 1) {
            this.bitmapsPerType.remove(preFillType);
            this.keyList.remove(this.keyIndex);
        } else {
            this.bitmapsPerType.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.bitmapsRemaining--;
        this.keyIndex = this.keyList.isEmpty() ? 0 : (this.keyIndex + 1) % this.keyList.size();
        return preFillType;
    }

    public final int getSize() {
        return this.bitmapsRemaining;
    }

    public final boolean isEmpty() {
        return this.bitmapsRemaining == 0;
    }
}
