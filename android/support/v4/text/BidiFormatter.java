package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = Character.toString(LRM);
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING = Character.toString(RLM);
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = true;
        }

        public final Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public final Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        public final BidiFormatter build() {
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }
    }

    private static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            for (int i = 0; i < DIR_TYPE_CACHE_SIZE; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        int getEntryDir() {
            this.charIndex = 0;
            int i = 0;
            int i2 = i;
            int i3 = i2;
            while (this.charIndex < this.length && i == 0) {
                byte dirTypeForward = dirTypeForward();
                if (dirTypeForward != (byte) 9) {
                    switch (dirTypeForward) {
                        case (byte) 0:
                            if (i3 == 0) {
                                return -1;
                            }
                            break;
                        case (byte) 1:
                        case (byte) 2:
                            if (i3 == 0) {
                                return 1;
                            }
                            break;
                        default:
                            switch (dirTypeForward) {
                                case (byte) 14:
                                case (byte) 15:
                                    i3++;
                                    i2 = -1;
                                    continue;
                                case (byte) 16:
                                case (byte) 17:
                                    i3++;
                                    i2 = 1;
                                    continue;
                                case (byte) 18:
                                    i3--;
                                    i2 = 0;
                                    continue;
                                    continue;
                                default:
                                    break;
                            }
                    }
                    i = i3;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case (byte) 14:
                    case (byte) 15:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return -1;
                    case (byte) 16:
                    case (byte) 17:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return 1;
                    case (byte) 18:
                        i3++;
                        break;
                    default:
                        break;
                }
            }
            return 0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        int getExitDir() {
            /*
            r6 = this;
            r0 = r6.length;
            r6.charIndex = r0;
            r0 = 0;
            r1 = r0;
            r2 = r1;
        L_0x0007:
            r3 = r6.charIndex;
            if (r3 <= 0) goto L_0x003a;
        L_0x000b:
            r3 = r6.dirTypeBackward();
            r4 = 9;
            if (r3 == r4) goto L_0x0007;
        L_0x0013:
            r4 = 1;
            r5 = -1;
            switch(r3) {
                case 0: goto L_0x0033;
                case 1: goto L_0x002d;
                case 2: goto L_0x002d;
                default: goto L_0x0018;
            };
        L_0x0018:
            switch(r3) {
                case 14: goto L_0x0027;
                case 15: goto L_0x0027;
                case 16: goto L_0x0021;
                case 17: goto L_0x0021;
                case 18: goto L_0x001e;
                default: goto L_0x001b;
            };
        L_0x001b:
            if (r1 != 0) goto L_0x0007;
        L_0x001d:
            goto L_0x0038;
        L_0x001e:
            r2 = r2 + 1;
            goto L_0x0007;
        L_0x0021:
            if (r1 != r2) goto L_0x0024;
        L_0x0023:
            return r4;
        L_0x0024:
            r2 = r2 + -1;
            goto L_0x0007;
        L_0x0027:
            if (r1 != r2) goto L_0x002a;
        L_0x0029:
            return r5;
        L_0x002a:
            r2 = r2 + -1;
            goto L_0x0007;
        L_0x002d:
            if (r2 != 0) goto L_0x0030;
        L_0x002f:
            return r4;
        L_0x0030:
            if (r1 != 0) goto L_0x0007;
        L_0x0032:
            goto L_0x0038;
        L_0x0033:
            if (r2 != 0) goto L_0x0036;
        L_0x0035:
            return r5;
        L_0x0036:
            if (r1 != 0) goto L_0x0007;
        L_0x0038:
            r1 = r2;
            goto L_0x0007;
        L_0x003a:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.BidiFormatter.DirectionalityEstimator.getExitDir():int");
        }

        private static byte getCachedDirectionality(char c) {
            return c < '܀' ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        }

        byte dirTypeForward() {
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                if (this.lastChar == '<') {
                    cachedDirectionality = skipTagForward();
                } else if (this.lastChar == '&') {
                    cachedDirectionality = skipEntityForward();
                }
            }
            return cachedDirectionality;
        }

        byte dirTypeBackward() {
            this.lastChar = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                if (this.lastChar == '>') {
                    cachedDirectionality = skipTagBackward();
                } else if (this.lastChar == ';') {
                    cachedDirectionality = skipEntityBackward();
                }
            }
            return cachedDirectionality;
        }

        private byte skipTagForward() {
            int i = this.charIndex;
            while (this.charIndex < this.length) {
                CharSequence charSequence = this.text;
                int i2 = this.charIndex;
                this.charIndex = i2 + 1;
                this.lastChar = charSequence.charAt(i2);
                if (this.lastChar == '>') {
                    return (byte) 12;
                }
                if (this.lastChar == '\"' || this.lastChar == '\'') {
                    char c = this.lastChar;
                    while (this.charIndex < this.length) {
                        CharSequence charSequence2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '<';
            return (byte) 13;
        }

        private byte skipTagBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.lastChar = charSequence.charAt(i2);
                if (this.lastChar != '<') {
                    if (this.lastChar == '>') {
                        break;
                    } else if (this.lastChar == '\"' || this.lastChar == '\'') {
                        char c = this.lastChar;
                        while (this.charIndex > 0) {
                            CharSequence charSequence2 = this.text;
                            i2 = this.charIndex - 1;
                            this.charIndex = i2;
                            char charAt = charSequence2.charAt(i2);
                            this.lastChar = charAt;
                            if (charAt == c) {
                                break;
                            }
                        }
                    }
                } else {
                    return (byte) 12;
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            while (this.charIndex < this.length) {
                CharSequence charSequence = this.text;
                int i = this.charIndex;
                this.charIndex = i + 1;
                char charAt = charSequence.charAt(i);
                this.lastChar = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return (byte) 12;
        }

        private byte skipEntityBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.lastChar = charSequence.charAt(i2);
                if (this.lastChar != '&') {
                    if (this.lastChar == ';') {
                        break;
                    }
                }
                return (byte) 12;
            }
            this.charIndex = i;
            this.lastChar = ';';
            return (byte) 13;
        }
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public final boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public final boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        textDirectionHeuristicCompat = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (this.mIsRtlContext || (textDirectionHeuristicCompat == null && getExitDir(charSequence) != 1)) {
            return (this.mIsRtlContext && (textDirectionHeuristicCompat == null || getExitDir(charSequence) == -1)) ? RLM_STRING : "";
        } else {
            return LRM_STRING;
        }
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        textDirectionHeuristicCompat = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (this.mIsRtlContext || (textDirectionHeuristicCompat == null && getEntryDir(charSequence) != 1)) {
            return (this.mIsRtlContext && (textDirectionHeuristicCompat == null || getEntryDir(charSequence) == -1)) ? RLM_STRING : "";
        } else {
            return LRM_STRING;
        }
    }

    public final boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public final boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        return str == null ? null : unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public final CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        textDirectionHeuristicCompat = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append(markBefore(charSequence, textDirectionHeuristicCompat != null ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (textDirectionHeuristicCompat != this.mIsRtlContext) {
            spannableStringBuilder.append(textDirectionHeuristicCompat != null ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(markAfter(charSequence, textDirectionHeuristicCompat != null ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public final CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public final String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public final CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public final String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public final CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    private static boolean isRtlLocale(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1 ? true : null;
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }
}
