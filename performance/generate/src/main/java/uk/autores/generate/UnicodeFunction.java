package uk.autores.generate;

final class UnicodeFunction {

    private int cp = Character.MIN_CODE_POINT;

    public int fill(char[] buf) {
        boolean trunc = false;
        for (int i = 0; i < buf.length;) {
            int codepoint = nextCodepoint(cp);
            int count = Character.charCount(codepoint);
            if (count == 1) {
                cp++;
                buf[i++] = (char) codepoint;
            } else {
                if (i == buf.length - 1) {
                    trunc = true;
                    break;
                }
                cp++;
                buf[i++] = Character.highSurrogate(codepoint);
                buf[i++] = Character.lowSurrogate(codepoint);
            }
        }
        return trunc
                ? buf.length - 1
                : buf.length;
    }

    private int nextCodepoint(int cp) {
        int codepoint = cp;
        while(true) {
            if (cp == Character.MIN_SURROGATE) {
                cp = Character.MAX_SURROGATE + 1;
                continue;
            }
            if (cp > Character.MAX_CODE_POINT) {
                cp = Character.MIN_CODE_POINT;
                continue;
            }
            if (Character.isDefined(cp)) {
                return codepoint;
            }
            codepoint++;
        }
    }
}
