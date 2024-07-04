package adsaufgabe1;

// Der Konstruktor der Klasse darf keine formalen Parameter (Argumente)
// enthalten

public class Inversionszahl_ssommer implements IInversionszahl {

    // Konstruktor ohne Argumente bitte belassen
    public Inversionszahl_ssommer() {

    }

    public int berechne(String[] array) {
        int writes = 0;
        for (int i = 1; i < array.length; i += 1) {
            for (int j = i; (j > 0) && (compareStrings(array[j - 1], array[j]) > 0); j -= 1) {
                String temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                writes += 1;
            }
        }
        return writes;
    }

    int compareStrings(String left, String right) {
        int indexLeftA = unsignedOr(left.indexOf("a"), Integer.MAX_VALUE);
        int indexRightA = unsignedOr(right.indexOf("a"), Integer.MAX_VALUE);

        int order = Integer.compare(indexLeftA, indexRightA);
        if (order == 0) {
            int distLeftB = left.lastIndexOf("b");
            distLeftB = distLeftB < 0
                    ? Integer.MAX_VALUE
                    : left.length() - distLeftB;
            int distRightB = right.lastIndexOf("b");
            distRightB = distRightB < 0
                    ? Integer.MAX_VALUE
                    : right.length() - distRightB;
            order = Integer.compare(distLeftB, distRightB);
        }
        if (order == 0) {
            order = Integer.compare(left.length(), right.length());
        }

        return order;
    }

    private int unsignedOr(int value, int or) {
        return value < 0 ? or : value;
    }
}
