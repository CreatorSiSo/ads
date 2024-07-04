package adsaufgabe1;

public class Testtreiber {
	public static void main(String[] args) {
		Inversionszahl_ssommer invz = new Inversionszahl_ssommer();
		System.out.println(invz.compareStrings("ijkaubbbbbbbbbb", "bbbbax"));
		System.out.println(invz.compareStrings("uiaoooobo", "qbao"));
		System.out.println(invz.compareStrings("udhgbaii", "poikjabxxx"));
		System.out.println(invz.compareStrings("aaa", "aba"));
		System.out.println(invz.compareStrings("bazbab", "bab"));

		int inv;

		// Tesfall 1
		String[] feld1 = { "aaa", "bba", "aba", "aab" };
		int inv1 = 5;
		inv = invz.berechne(feld1);
		if (inv == inv1)
			System.out.println("Testfall 1 erfolgreich");
		else
			System.out.println("Fehler bei der Bearbeitung von Testfall 1 (" + inv + " statt " + inv1 + ")");

		// Testfall 2
		String[] feld2 = { "aba", "baaza", "cccba", "abab", "bab", "baaaa", "bazbab" };
		int inv2 = 9;
		inv = invz.berechne(feld2);
		if (inv == inv2)
			System.out.println("Testfall 2 erfolgreich");
		else
			System.out.println("Fehler bei der Bearbeitung von Testfall 2 (" + inv + " statt " + inv2 + ")");

		// Testfall 3
		String[] feld3 = { "bbb", "b", "cbcc", "iii", "bab", "aaaab", "c" };
		int inv3 = 11;
		inv = invz.berechne(feld3);
		if (inv == inv3)
			System.out.println("Testfall 3 erfolgreich");
		else
			System.out.println("Fehler bei der Bearbeitung von Testfall 3 (" + inv + " statt " + inv3 + ")");
	}
}
