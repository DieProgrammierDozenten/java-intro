# Exkurs: Methoden mit variabler Argumentanzahl (Varargs)
## Frage
Ist es möglich, einer Methode in Java eine dynamische (d.h. nicht zur Kompilierungszeit bekannte) Anzahl an Parametern zu übergeben?

## Erläuterung
Standardmäßig erwartet Java genau die Anzahl, Reihenfolge und Typen der Parameter, die wir bei der Methodendefinition angegeben haben:

```java
public int summieren(int a, int b) {
    return a + b;
}
```

```java
summieren(4, 5); // funktioniert
summieren(4); // Fehler: "actual and formal argument lists differ in length"
summieren(4, 5, 6); // Fehler: "actual and formal argument lists differ in length"
```

Möchten wir nun durch unsere Methode `summieren()` die Summe aus einer beliebigen Anzahl Ganzzahlen bilden, können wir alternativ auch ein Array oder z. B. auch ein `ArrayList`-Objekt übergeben:

```java
public int summieren(int[] summanden) {
    int ergebnis = 0;
    
    for(int i = 0; i < summanden.length; i++) {
        ergebnis += summanden[i];
    }
    
    return ergebnis;
}
 ```
 
 ```java
int[] summanden = {4, 5, 6, 7};
summieren(summanden); // funktioniert

summieren(new int[]{4, 5, 6, 7, 8, 9}); // funktioniert
 ```

Um die Schritte für die Deklaration und Initialisierung eines Arrays nur zur Übergabe als Parameter einzusparen, gibt es in Java die `Varargs`-Notation,
die über die Auslassungspunkte (ellipsis, `...`) eine unbestimmte Anzahl Parameter für eine Methode erlaubt.
Dabei werden die Auslassungspunkte direkt vor den Parameternamen geschrieben, z. B. `int ...summanden`.
Innerhalb der Methode werden die Parameter dann als Array zur Verfügung gestellt, weshalb wir die Schleife von unserem vorherigen Ansatz übernehmen können.

```java
public int summieren(int ...summanden) {
    int ergebnis = 0;
    
    for(int i = 0; i < summanden.length; i++) {
        ergebnis += summanden[i];
    }
    
    return ergebnis;
}
 ```

 ```java
summieren(4, 5, 6); // funktioniert

summieren(4, 5, 6, 7, 8, 9); // funktioniert
 ```

Wichtig ist, dass der `Varargs`-Parameter immer der letzte Parameter der Parameterliste sein muss,
da Java sonst nicht herausfinden kann, wo die Liste mit "normalen" Parametern endet und der `Varargs`-Parameter beginnt.
Aus diesem Grund kann es pro Methode auch nur maximal einen `Varargs`-Parameter geben.

```java
public String summieren(String ergebnisText, int ...summanden) {
     int ergebnis = 0;
    
    for(int i = 0; i < summanden.length; i++) {
        ergebnis += summanden[i];
    }
    
    return ergebnisText + ergebnis;
}
```

 ```java
summieren("Das Ergebnis ist ", 4, 5, 6); // funktioniert

summieren("Das Ergebnis ist ", 4, 5, 6, 7, 8, 9); // funktioniert
 ```

## Weiterführende Links
- [The Java Tutorials: Arbitary Number of Arguments](https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html#varargs)
- [Wikipedia: Variadische Funktionen](https://de.wikipedia.org/wiki/Variadische_Funktion)