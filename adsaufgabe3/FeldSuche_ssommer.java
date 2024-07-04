package adsaufgabe3;

public class FeldSuche_ssommer implements IFeldSuche {

    public FeldSuche_ssommer() {
    }

    @Override
    public int binaereSuche(String[] feld, String gesucht) {
        int lower = 0;
        int upper = feld.length - 1;
        int comparisons = 0;

        try {
            while (lower <= upper) {
                int mitte = lower + (upper - lower) / 2;
                comparisons++;
                int vergleich = compare(feld[mitte], gesucht);

                if (vergleich == 0) {
                    return mitte;
                } else if (vergleich < 0) {
                    lower = mitte + 1;
                } else {
                    upper = mitte - 1;
                }
            }
        } catch (Exception e) {
        }

        return -1 * comparisons;
    }

    @Override
    public int interpolationsSuche(String[] feld, String gesucht) {
        int lower = 0;
        int upper = feld.length - 1;
        int comparisons = 0;

        try {
            while (lower <= upper) {
                comparisons++;

                if (compare(feld[upper], feld[lower]) == 0) {
                    if (compare(gesucht, feld[lower]) == 0) {
                        return lower;
                    } else {
                        return -1 * comparisons;
                    }
                }

                long pos = lower + ((upper - lower) * (stringToLong(gesucht) - stringToLong(feld[lower])))
                        / (stringToLong(feld[upper]) - stringToLong(feld[lower]));

                if (pos < lower || pos > upper) {
                    return -1 * comparisons;
                }

                int vergleich = compare(feld[(int) pos], gesucht);

                if (vergleich == 0) {
                    return (int) pos;
                } else if (vergleich < 0) {
                    lower = (int) pos + 1;
                } else {
                    upper = (int) pos - 1;
                }
            }
        } catch (Exception e) {
        }

        return -1 * comparisons;
    }

    private int compare(String a, String b) {
        int len = Math.max(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            char charA = i < a.length() ? a.charAt(i) : '0';
            char charB = i < b.length() ? b.charAt(i) : '0';
            if (charA != charB) {
                return charA - charB;
            }
        }
        return 0;
    }

    private long stringToLong(String str) {
        long result = 0;
        for (char ch : str.toCharArray()) {
            result = result * 4 + (ch - '0');
        }
        return result;
    }
}
