package adsaufgabe3;

public interface IFeldSuche {

    /*
      Sie koennen davon ausgehen, dass das uebergebene Array
      feld aufsteigend sortiert ist. 
      Falls diese Voraussetzung fuer die Eingabe nicht erfuellt ist,
      sind beliebige Rueckgabewerte moeglich. (Design-by-Contract).
      Die Rueckgabewerte sind auf dem Aufgabenblatt beschrieben.
     */
    public int binaereSuche(String[] feld, String gesucht);

    /*
      Sie koennen davon ausgehen, dass das uebergebene Array
      feld aufsteigend sortiert ist. 
      Falls diese Voraussetzung fuer die Eingabe nicht erfuellt ist,
      sind beliebige Rueckgabewerte moeglich. (Design-by-Contract).
      Die Rueckgabewerte sind auf dem Aufgabenblatt beschrieben.
     */
    public int interpolationsSuche(String[] feld, String gesucht);

}
