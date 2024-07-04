package adsaufgabe3;

public class Testtreiber {
	public static void main(String[] args) {
		IFeldSuche suche = new FeldSuche_ssommer();

		String[] feld = { "0000000001", "0000000011", "0000000022", "0000000302", "000000121", "0000013310",
				"000003322", "000103202", "00021301", "003003110", "0120122200", "13220102", "331002100" };
		int erg;

		// Testfall 1
		erg = suche.binaereSuche(feld, "0000000022");
		if (erg == 2)
			System.out.println("Testfall 1: erfolgreich");
		else
			System.out.println("Testfall 1: Fehler");

		// Testfall 2
		erg = suche.binaereSuche(feld, "000013310");
		if (erg == -3)
			System.out.println("Testfall 2: erfolgreich");
		else
			System.out.println("Testfall 2: Fehler");

		// Testfall 3
		erg = suche.interpolationsSuche(feld, "0000000022");
		if (erg == 2)
			System.out.println("Testfall 3: erfolgreich");
		else
			System.out.println("Testfall 3: Fehler");

		// Testfall 4
		erg = suche.interpolationsSuche(feld, "000013310");
		if (erg == -8)
			System.out.println("Testfall 4: erfolgreich");
		else
			System.out.println("Testfall 4: Fehler");

		// Testfall 5
		erg = suche.interpolationsSuche(feld, null);
		if (erg == -1)
			System.out.println("Testfall 5: erfolgreich");
		else
			System.out.println("Testfall 5: Fehler");

	}
}
