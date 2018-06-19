package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

class PaintCompatApi14 {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "󟿽";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal();

    PaintCompatApi14() {
    }

    static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText(TOFU_STRING);
        float measureText2 = paint.measureText(EM_STRING);
        float measureText3 = paint.measureText(str);
        float f = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > 2.0f * measureText2) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int charCount = Character.charCount(str.codePointAt(i)) + i;
                f += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText3 >= f) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair obtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds(TOFU_STRING, 0, 2, (Rect) obtainEmptyRects.first);
        paint.getTextBounds(str, 0, length, (Rect) obtainEmptyRects.second);
        return ((Rect) obtainEmptyRects.first).equals(obtainEmptyRects.second) == null;
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        Pair<Rect, Rect> pair = (Pair) sRectThreadLocal.get();
        if (pair == null) {
            pair = new Pair(new Rect(), new Rect());
            sRectThreadLocal.set(pair);
            return pair;
        }
        ((Rect) pair.first).setEmpty();
        ((Rect) pair.second).setEmpty();
        return pair;
    }
}
