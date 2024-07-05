package adsaufgabe2;

public class TestProgramm {

	public TestProgramm() {
	}

	public static void main(String[] args) {
		// Testfall 1 - different start node graph
		Graph g = new Graph(4);
		g.addEdge(0, 3, 6);
		g.addEdge(0, 1, 3);
		g.addEdge(1, 2, 3);
		g.addEdge(3, 2, 2);
		g.addEdge(1, 3, 2);
		boolean erfolgreich = true;
		IPrim t = new Prim_ssommer();
		if (!t.computeMSB(g, 3)) {
			System.out.println("Fehler: Der Knoten 3 ist enthalten");
			erfolgreich = false;
		}
		int vorg = t.getPredecessor(0);
		if (vorg != 1) {
			System.out.println("Fehler: Knoten 3 hat falschen Vorgaenger " + vorg);
			erfolgreich = false;
		}
		int summe = t.getSumOfWeights();
		if (summe != 7) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		int nummer = t.getProcessingOrder(2);
		if (nummer != 3) {
			System.out.println("Fehler: Knoten 2 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 1 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 1 zeigt Fehler in Ihrem Programm.\n");

		// Testfall 2 - isolated nodes graph
		g = new Graph(6);
		g.addEdge(0, 1, 7);
		g.addEdge(0, 3, 8);
		g.addEdge(0, 4, 6);
		g.addEdge(1, 3, 4);
		g.addEdge(1, 4, 3);
		g.addEdge(3, 4, 5);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (t.computeMSB(g, 0)) {
			System.out.println("Fehler: Sie sollten erkennen, dass der Graph unzusammenhaengend ist.");
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(2);
		if (nummer != 0) {
			System.out.println("Fehler: Knoten 2 wurde überhaupt nicht bearbeitet, auch nicht im Schritt " + nummer);
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 2 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 2 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 3 - negative weight graph
		g = new Graph(4);
		g.addEdge(0, 1, 2);
		g.addEdge(1, 2, 2);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 3, -3);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (!t.computeMSB(g, 0)) {
			System.out.println("Fehler: Der Knoten 0 ist enthalten");
			erfolgreich = false;
		}
		vorg = t.getPredecessor(2);
		if (vorg != 3) {
			System.out.println("Fehler: Knoten 2 hat falschen Vorgaenger " + vorg);
			erfolgreich = false;
		}
		summe = t.getSumOfWeights();
		if (summe != 0) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(3);
		if (nummer != 3) {
			System.out.println("Fehler: Knoten 3 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 3 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 3 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 4 - negative cycle graph
		g = new Graph(3);
		g.addEdge(0, 1, -2);
		g.addEdge(0, 2, -1);
		g.addEdge(1, 2, -3);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (!t.computeMSB(g, 0)) {
			System.out.println("Fehler: Der Knoten 0 ist enthalten");
			erfolgreich = false;
		}
		vorg = t.getPredecessor(0);
		if (vorg != -1) {
			System.out.println("Fehler: Knoten 0 hat keinen Vorgänger " + vorg);
			erfolgreich = false;
		}
		summe = t.getSumOfWeights();
		if (summe != -5) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(1);
		if (nummer != 2) {
			System.out.println("Fehler: Knoten 3 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 4 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 4 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 5 - same weight graph
		g = new Graph(4);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (!t.computeMSB(g, 0)) {
			System.out.println("Fehler: Der Knoten 0 ist enthalten");
			erfolgreich = false;
		}
		vorg = t.getPredecessor(3);
		if (vorg != 2) {
			System.out.println("Fehler: Knoten 2 hat falschen Vorgaenger " + vorg);
			erfolgreich = false;
		}
		summe = t.getSumOfWeights();
		if (summe != 3) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(2);
		if (nummer != 3) {
			System.out.println("Fehler: Knoten 2 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 5 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 5 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 6 - isolated bipartite graph
		g = new Graph(5);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(3, 4, 1);
		t = new Prim_ssommer();
		if (t.computeMSB(g, 0)) {
			System.out.println("Fehler: Sie sollten erkennen, dass der Graph unzusammenhaengend ist.");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 6 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 6 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 7 - cycle graph
		g = new Graph(5);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 0, 1);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (!t.computeMSB(g, 0)) {
			System.out.println("Fehler: Der Knoten 0 ist enthalten");
			erfolgreich = false;
		}
		vorg = t.getPredecessor(3);
		if (vorg != 4) {
			System.out.println("Fehler: Knoten 3 hat falschen Vorgaenger " + vorg);
			erfolgreich = false;
		}
		summe = t.getSumOfWeights();
		if (summe != 4) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(2);
		if (nummer != 5) {
			System.out.println("Fehler: Knoten 3 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 7 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 7 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 8 - zero weight graph
		g = new Graph(6);
		g.addEdge(0, 1, 0);
		g.addEdge(1, 2, 0);
		g.addEdge(2, 3, 0);
		g.addEdge(2, 4, 0);
		g.addEdge(3, 0, 0);
		g.addEdge(5, 2, 0);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (!t.computeMSB(g, 0)) {
			System.out.println("Fehler: Der Knoten 0 ist enthalten");
			erfolgreich = false;
		}
		vorg = t.getPredecessor(3);
		if (vorg != 0) {
			System.out.println("Fehler: Knoten 3 hat falschen Vorgaenger " + vorg);
			erfolgreich = false;
		}
		summe = t.getSumOfWeights();
		if (summe != 0) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(4);
		if (nummer != 5) {
			System.out.println("Fehler: Knoten 3 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 8 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 8 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 9 - star graph
		g = new Graph(7);
		g.addEdge(0, 1, 2);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 4);
		g.addEdge(1, 4, 2);
		g.addEdge(1, 5, 9);
		g.addEdge(1, 6, 12);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (!t.computeMSB(g, 0)) {
			System.out.println("Fehler: Der Knoten 0 ist enthalten");
			erfolgreich = false;
		}
		vorg = t.getPredecessor(4);
		if (vorg != 1) {
			System.out.println("Fehler: Knoten 3 hat falschen Vorgaenger " + vorg);
			erfolgreich = false;
		}
		summe = t.getSumOfWeights();
		if (summe != 30) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(2);
		if (nummer != 3) {
			System.out.println("Fehler: Knoten 3 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 9 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 9 zeigt Fehler in Ihrem Programm.\n");

		//Testfall 10 - tree graph
		g = new Graph(13);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 4);
		g.addEdge(1, 3, 1);
		g.addEdge(3, 4, 5);
		g.addEdge(3, 5, 1);
		g.addEdge(5, 8, 1);
		g.addEdge(8, 7, 2);
		g.addEdge(8, 10, 1);
		g.addEdge(7, 6, 1);
		g.addEdge(7, 9, 2);
		g.addEdge(10, 11, 6);
		g.addEdge(11, 12, 1);
		erfolgreich = true;
		t = new Prim_ssommer();
		if (!t.computeMSB(g, 0)) {
			System.out.println("Fehler: Der Knoten 0 ist enthalten");
			erfolgreich = false;
		}
		vorg = t.getPredecessor(7);
		if (vorg != 8) {
			System.out.println("Fehler: Knoten 3 hat falschen Vorgaenger " + vorg);
			erfolgreich = false;
		}
		summe = t.getSumOfWeights();
		if (summe != 26) {
			System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
			erfolgreich = false;
		}
		nummer = t.getProcessingOrder(4);
		if (nummer != 11) {
			System.out.println("Fehler: Knoten 3 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
			erfolgreich = false;
		}
		if (erfolgreich)
			System.out.println("Der Testfall 10 wurde erfolgreich gemeistert.");
		else
			System.out.println("Der Testfall 10 zeigt Fehler in Ihrem Programm.\n");
	}
}
