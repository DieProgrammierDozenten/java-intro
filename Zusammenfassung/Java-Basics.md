# Java-Basics
## Inhaltsverzeichnis
- [Einführung](#einfhrung)
    - [Warum Java?](#warum-java)
    - [Java vs. Python](#java-vs-python)
- [Syntax](#syntax)
    - [Bedingte Anweisung und Verzweigung (`if`/`else`)](#bedingte-anweisung-und-verzweigung-ifelse)
    - [Auswahloperator ("Conditional Operator")](#auswahloperator-conditional-operator)
    - [Mehrfachverzweigung (`switch`-Konstrukt)](#mehrfachverzweigung-switch-konstrukt)
- [Typen und Typisierung](#typen-und-typisierung)
    - [Konzept](#konzept)
    - [Basistypen](#basistypen)
    - [Typumwandlung (Casting)](#typumwandlung-typecast)
    - [Arrays](#arrays)
    - [`null`](#null)
    - [Konstanten](#konstanten)
- [Schleifen](#schleifen)
    - [`for`-Schleife](#for-schleife)
    - [`for`-Schleife (vereinfacht)](#for-schleife-vereinfacht)
    - [`while`-Schleife](#while-schleife)
    - [`do-while`-Schleife](#do-while-schleife)
- [Methoden](#methoden)
    - [`void` und Rückgabewerte](#void-und-rckgabewerte)
    - [`main`-Methode](#main-methode)
- [`package` und `import`](#package-und-import)
    
    
## Einführung
### Warum Java?
Java ist vielseitig einsetzbar und wird von einem Großteil der (IT-)Unternehmen eingesetzt (siehe z. B. [Analyse auf stackshare](https://stackshare.io/java)).

Neben vielen "klassischen" PC-Applikationen sind auch Spiele (z. B. `Minecraft`), Backends für Webservices, mobile Apps (der Großteil der Android-Apps), Blu-ray-Player, Drucker usw. mit Java implementiert bzw. nutzen Java.

Im Rahmen der Vorlesung soll das Konzept der Objektorientierten Programmierung (OOP) vermittelt werden.
Dies unterstützen auch viele andere Programmiersprachen, allerdings ist es in Java strikt implementiert und die Konzepte lassen sich entsprechend einfach erläutern. 

### Java vs. Python
Python ist eine sogenannte Interpretersprache. Das bedeutet, dass der Code einer `.py`-Datei zur Laufzeit, also nach Start des Programms, Zeile für Zeile evaluiert und ausgeführt wird.
Dies bietet den Vorteil, dass Änderungen am Code direkt bei erneuter Ausführung des Codes berücksichtigt werden.
Das beschleunigt das Entwickeln und Debuggen (Fehler finden und beheben) enorm. Außerdem muss für jede Plattform (z. B. Windows, Linux, macOS) und Prozessorarchitektur (ARM, x86 usw.) nur ein passender Interpreter existieren, damit das Programm dort lauffähig ist.
Das Programm an sich muss dafür (meist) nicht angepasst werden.

Auf der anderen Seite sind die Möglichkeiten zur Optimierung des Programmcodes begrenzt.
Jede Plattform und jede Prozessorarchitektur besitzt unterschiedliche Befehlssätze, also Instruktionen für die Hardware, in die der Programmcode erst übersetzt werden muss.
Logischerweise gibt es für jede Plattform auch unterschiedliche Wege, wie man eine Zeile Code in Maschinencode repräsentieren kann - manche davon sind schneller, andere langsamer.

Compilersprachen wie beispielsweise `C` oder `C++` haben durch eine Kompilierung des Programms _vor_ der Ausführung die Möglichkeit, den Code entsprechend in den jeweiligen Maschinencode der Plattform zu übersetzen und dabei zu optimieren.
Folglich ist die Geschwindigkeit von Compilersprachen häufig etwas höher als von Interpretersprachen.
Allerdings muss für jede Plattform das Programm separat kompiliert werden, da sich der Befehlssatz und damit die Repräsentation des Programms als Maschinencode unterscheidet.
Bei jeder Änderung des Codes ist eine erneute Kompilierung erforderlich, was Zeit kostet und die Entwicklung verlangsamen kann.

| | Interpreter | Compiler |
| --- | --- | --- |
| Quellcode-Übersetzung | zur Laufzeit | vor der Ausführung im Kompilierungsschritt |
| Ausführungsmodus | Zeile für Zeile | gesamter Code |
| Entwicklungsaufwand | geringer | höher |
| Programmgeschwindigkeit | höher | geringer |
| Voraussetzung für andere Plattform | Verfügbarkeit des Interpreters für die Zielplattform | Neukompilierung des Programms für Zielplattform |
| Beispiele | `Python`, `PHP`, `JavaScript` | `C`, `C++`, `Pascal`

Java verfolgt einen hybriden Ansatz und kombiniert die Vorteile von Compiler und Interpreter.
Dabei wird über den Compiler (Programm `javac`) der Quellcode der `.java`-Dateien vor der Ausführung des Programms in einen sogenannten Bytecode (`.class`-Dateien) kompiliert.
Dieser ist vereinfacht gesagt der Maschinencode für die Java Virtual Machine (JVM) und kann nur von dieser interpretiert werden.
Die JVM muss für die Zielplattform verfügbar sowie auf dem Zielsystem installiert sein und interpretiert zur Laufzeit des Programms (über das Programm `java`) den Bytecode und übersetzt ihn in den Maschinencode der jeweiligen Plattform. 
Dadurch, dass durch die bereits vorher erfolgte Kompilierung bereits eine Syntaxüberprüfung und Codeoptimierung stattgefunden hat, muss diese nicht mehr während des Interpretierens von der JVM ausgeführt werden.
Dies beschleunigt die Ausführung des Programms, sodass eine ähnliche Performance zu Compilersprachen erreicht werden kann. 

![Python vs. Java](includes/Python%20vs.%20Java.png)

Neben der Art, wie das Programm für die Ausführung vorbereitet und schlussendlich ausgeführt wird, ist Java im Gegensatz zu Python auch streng objektorientiert ausgelegt (siehe [Objektorientierungs-Basics](OOP-Basics.md)).
Zudem ist Java statisch typisiert, d.h. wir müssen bei jeder Variablen schon bei der Deklaration (Definition) mitteilen, welchen Typ (z. B. `int` oder `String`) diese besitzen soll.
Java überprüft diesen Typ dann bei jeder Änderung der Variable und gibt eine Fehlermeldung aus, wenn man beispielweise einen Integerwert wie `6` ohne Konvertierungsschritt in einer `String`-Variable speichern möchte (siehe Abschnitt [Typen und Typisierung](#typen-und-typisierung)). 

## Syntax
Zwei grundlegende syntaktische Unterschiede fallen beim Vergleich von Python- und Java-Code sofort auf:
1. Jede Instruktion endet in Java mit einem Semikolon (`;`), z. B. `int ganzzahl = 6;`
2. Blöcke, beispielsweise bei Schleifen oder `if`/`else`-Verzweigungen, werden durch geschweifte Klammern (`{` und `}`) und nicht durch Einrückungen eingegrenzt.
Trotzdem wird der Inhalt dieser Blöcke zur Verbesserung der Lesbarkeit eingerückt.
3. Kommentare werden über `//` eingeleitet (bzw. `/*` und `*/` für mehrzeilige Kommentare)
4. Die `print("Hello World")`-Anweisung zum Ausgeben von Werten an der Konsole sieht anders aus: `System.out.println("Hello World")`
5. Jede Anweisung, Variablen- oder Methodendeklaration muss sich innerhalb einer Klasse befinden:
```java
class Klassenname {
    // Attribute, Methoden usw.
}
```

### Bedingte Anweisung und Verzweigung (`if`/`else`)

Ansonsten verhält sich die Syntax sehr ähnlich zu der, die wir bereits bei Python kennengelernt haben.
Als Beispiel eine `if`/`else`-Verzweigung:

```java
int zahl = 5;

if(zahl < 5) {
    // Wert von Variable "zahl" ist kleiner 5
} else if(zahl == 5) {
    // Wert von Variable "zahl" ist gleich 5
} else {
    // Wert von Variable "zahl" ist größer 5
}
```

### Auswahloperator ("Conditional Operator")

Eine `if`/`else`-Verzweigung kann auch in kompakterer Form geschrieben werden.
Dazu wird der sogenannte Auswahloperator ("Conditional Operator") verwendet.
Dieser besteht aus einem `?` und einem `:`.

```java
int tankinhalt = 12; // in Prozent 

String status = (tankinhalt < 20) ? "Tank bald leer!" : "Genügend Reserve vorhanden.";
System.out.println(status); // Ausgabe: "Tank bald leer!"
```

Diese Notation kann man sich mit dem Satzbau einer "normalen" Frage merken:
> Ist die Bedingung `tankinhalt < 20` erfüllt **?** gebe "Tank bald leer!" aus, ansonsten **:** "Genügend Reserve vorhanden.".

Der Teil vor dem Fragezeichen ist folglich der zu evaluierende Ausdruck, der Teil nach dem Fragezeichen die Operation,
die ausgeführt werden soll, wenn der Ausdruck `true` ist,
und der Teil nach dem Doppelpunkt entspricht dem `else`, also dem Fall, wenn der Ausdruck `false` ist.

Als bedingte Anweisung sieht das Beispiel so aus:

```java
int tankinhalt = 12; // in Prozent 

String status;
if(tankinhalt < 20) {
    status = "Tank bald leer!";
} else {
    status = "Genügend Reserve vorhanden.";
}

System.out.println(status); // Ausgabe: "Tank bald leer!"
```

Auch eine Schachtelung verschiedener Auswahloperatoranweisungen ist möglich, darunter leidet allerdings die Verständlichkeit des Quelltexts.

```java
int tankinhalt = 12; // in Prozent 

String status = (tankinhalt < 20) ? (tankinhalt < 5) ? "Tank ist leer!" : "Tank bald leer!" : "Genügend Reserve vorhanden.";
System.out.println(status); // Ausgabe: "Tank bald leer!"
```

Als bedingte Anweisung lässt sich dies ebenfalls durch eine Schachtelung von zwei `if`/`else` realisieren:

```java
int tankinhalt = 12; // in Prozent 

String status;
if(tankinhalt < 20) {
    if(tankinhalt < 5) {
        status = "Tank bald leer!";
    } else {
        status = "Tank ist leer!";
    }
} else {
    status = "Genügend Reserve vorhanden.";
}

System.out.println(status); // Ausgabe: "Tank bald leer!"
```

Dabei ist zu beachten, dass der Fall in der äußeren `if`-Anweisung den Fall der inneren `if`-Anweisung beinhalten muss.
In unserem Beispiel ist dies erfüllt, da wenn `tankinhalt < 20` der Wert entweder `< 5` (`if`) oder `>= 5` (`else`) sein kann.

### Mehrfachverzweigung (`switch`-Konstrukt)

Sollen mehrere Verzweigungen bzw. Fälle überprüft werden, kann in Java eine `switch`-Anweisung verwendet werden:

```java
int wochentag = 4; // z. B. eine Benutzereingabe

switch(wochentag) {
    case 1:
        System.out.println("Es ist Montag.");
        break;
    case 2:
        System.out.println("Heute ist Dienstag.");
        break;
    case 3:
        System.out.println("Es ist Mittwoch.");
        break;
    case 4:
        System.out.println("Heute ist Donnerstag.");
        break;
    case 5:
        System.out.println("Freitag. Bald ist Wochenende!");
        break;
    case 6:
        System.out.println("Heute ist Samstag (Wochenende)");
        break;
    case 7:
        System.out.println("Heute ist Sonntag (Wochenende)");
        break;
    default: // ... else
        System.out.println(wochentag + " ist kein gültiger Wochentag!");
} // Ausgabe: "Heute ist Donnerstag."
```

Dieses Konstrukt macht das gleiche wie die folgende Kombination aus `if`/`else if`/`else`-Verzweigungen:

```java
int wochentag = 4; // z. B. eine Benutzereingabe

if (wochentag == 1) {
    System.out.println("Es ist Montag.");
} else if (wochentag == 2) {
    System.out.println("Heute ist Dienstag.");
} else if (wochentag == 3) {
    System.out.println("Es ist Mittwoch.");
} else if (wochentag == 4) {
    System.out.println("Heute ist Donnerstag.");
} else if (wochentag == 5) {
    System.out.println("Freitag. Bald ist Wochenende!");
} else if (wochentag == 6) {
    System.out.println("Heute ist Samstag (Wochenende)");
} else if (wochentag == 7) {
    System.out.println("Heute ist Sonntag (Wochenende)");
} else {
    System.out.println(wochentag + " ist kein gültiger Wochentag!");
}
```

Jeder Fall (`case`) entspricht einer Überprüfung des Werts der Variable im `switch()` auf Gleichheit.
In unserem Beispiel wird der Code-Block hinter `case 3:` nur ausgeführt, wenn die Variable `wochentag` den Wert `3` besitzt.
Folglich muss die Bedingung `wochentag == 3` wahr sein.

Durch die `break`-Anweisung wird der Codeblock für den jeweiligen `case` beendet, d.h. danach wird für das `switch`-Konstrukt keine weitere Anweisung mehr ausgeführt.
Dies ist eine häufige Fehlerquelle, da das Weglassen der `break`-Anweisung auch eine valide Syntax aufweist.
Im folgenden Beispiel wird für alle Werte von `wochentag` zwischen `1` und `5` der String `Arbeitstag` ausgegeben, für `6` und `7` der String `Wochenende`.

```java
int wochentag = 4; // z. B. eine Benutzereingabe

switch(wochentag) {
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        System.out.println("Arbeitstag");
        break; // hier nicht mehr weitermachen, falls eine der Fälle eingetreten ist
    case 6:
    case 7:
        System.out.println("Wochenende");
        break; // hier nicht mehr weitermachen, falls eine der Fälle eingetreten ist
    default: // ... else
        System.out.println(wochentag + " ist kein gültiger Wochentag!");
}
```

Alle Fälle des `switch`-Konstrukts werden von oben nach unten ab dem ersten "Treffer" durchlaufen, bis ein `break` oder das Ende des `switch`-Konstrukts erreicht wird.
Für alle Fälle, die nicht von einem `case` abgedeckt sind, wird der `default`-Zweig durchlaufen, `default` funktioniert folglich wie das `else` bei einer bedingten Anweisung (`if`/`else`).
Da `default` die letzte Anweisung in einem `switch`-Block ist, wird dafür kein `break` benötigt.

Zu beachten ist, dass das `switch`-Konstrukt in Java nur auf Gleichheit (also z. B. nicht `>` oder `<`) prüfen kann und mit folgenden Datentypen funktioniert:
`byte`, `short`, `char`, `int`, `String` und `Enum` (siehe [The Java Tutorials](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)).

Seit Java SDK-Version 14 ist es außerdem möglich, sogenannte `switch`-Expressions zu verwenden.
Diese besitzen eine kompaktere Syntax als die gerade präsentierten "originalen" `switch`-Anweisungen.
Mehr Informationen zur Syntax dieser finden Sie in der offiziellen Java-Dokumentation zu [Switch Expressions](https://docs.oracle.com/en/java/javase/15/language/switch-expressions.html).

## Typen und Typisierung
### Konzept
Python ist `dynamisch` typisiert, wohingegen Java `statisch` typisiert ist.
Das bedeutet, dass sich Python den Typ einer Variablen zur Laufzeit selbst "erschließt", während man diesen Java bereits im Programmcode mitteilen muss.

**Python:**
```python
eineVariable = 6
```
Python "erkennt", dass es sich um einen Integer handeln muss.
Diese Variable kann zu einem späteren Zeitpunkt einfach mit einem anderen Datentyp überschrieben werden:
```python
eineVariable = "Hello World"
```
Python "erkennt" nun, dass der Typ ein `String` ist.

**Java:**
```java
int eineVariable = 6;
```
Java "weiß", dass hier nur ein Integer drin gespeichert werden darf.
```java
eineVariable = "Hello World;
```
Java zeigt nun eine Fehlermeldung an, da die Zeichenkette `Hello World` nicht in einer Variablen des Typs `int` (Ganzzahl) gespeichert werden darf.

Was erst einmal nach mehr Aufwand und Komplexität aussieht, hat in der Praxis viele Vorteile:
Als Entwickler kann ich beispielsweise zu einem späteren Zeitpunkt erwarten, dass eine Variable vom Typ `int` auch wirklich eine Zahl steht, mit der ich rechnen kann.
Bei Python kann es sein, dass nach der Initialisierung der Variable `eineZahl = 6` an anderer Stelle die Variable beispielsweise für einen `String` (`eineZahl = "6`) wiederverwendet wurde.
Dies würde zu einem Fehler bei der Laufzeit führen und bei nicht korrekter Behandlung dieser `Exception` das Programm zu Abstürzen bringen.

### Basistypen
Java unterstützt einige Basistypen (auch primitive Datentypen genannt):

|  Datentyp | Größe | Wertebereich | Verwendung | Standardwert | Beispiel |
| :--- | :--- | :--- | :--- | :--- | :--- |
| byte | 1 byte | -128 bis 127 | Ganzzahlen | `0` | `byte einByte = 123;` |
| short | 2 bytes | -32.768 bis 32.767 | Ganzzahlen | `0` | `short einShort = 12345;`|
| int | 4 bytes | -2.147,483,648 bis 2.147.483.647 | Ganzzahlen | `0` | `int einInt = 92983;` |
| long | 8 bytes | -9.223.372.036.854,775,808 bis 9.223.372.036.854.775.807 | Ganzzahlen | `0` | `long einLong = 2938L;` _(`L` am Ende beachten!)_ |
| float | 4 bytes | 6 bis 7 Nachkommastellen | Fließkommazahlen | `0.0` | `float einFloat = 12.34f;` _(`f` am Ende beachten!)_ |
| double | 8 bytes | 15 Nachkommastellen | Fließkommazahl (doppelte Genauigkeit) | `0.0` | `double einDouble = 12.345;` |
| boolean | 1 bit | `true` oder `false` | Wahrheitswert | `false` | `boolean einBoolean = true;` |
| char | 2 bytes | einzelne Zeichen | einzelne Zeichen | `''` | `char einChar = 'B';` _(`''` statt `""` verwenden!)_ | 

Weitere Typen wie z. B. `String` sind als Klassen implementiert und können wie Objekte genutzt werden:

```java
String einString = "Hello World"; // für Strings lassen sich auch direkt Literale übergeben
String einWeitererString = new String("Hello World"); // reguläre Objektinitialisierungssyntax mit "new"
```

### Typumwandlung (Typecast)
Teilweise muss zur Laufzeit eine Variable eines Typs zu einer Variablen eines anderen Typs umgewandelt werden.
Beispielsweise gibt ein Benutzer an der Konsole einen `String` ein, wir möchten diesen aber als Zahl (`int`) interpretieren, damit wir mit diesem Berechnungen vornehmen können.

Dazu wird eine Typumwandlung (Typecast) verwendet.
Teilweise erfolgt eine Typumwandlung bereits implizit, wenn ein niederwertiger Datentyp (z. B. `short`) in einen höherwertigen Datentyp (z. B. `int`) umgewandelt wird.

```java
short eineKleineGanzzahl = 42;
int eineGanzzahl = eineKleineGanzzahl; // Typumwandlung erfolgt automatisch
```

Im entgegengesetzten Fall, also bei einer Konvertierung von einem höherwertigen in einen niederwertigeren Datentyp muss ein expliziter Typecast vorgenommen werden.
Dies ist dadurch begründet, dass dabei (fast) immer Informationen verloren gehen, beispielsweise die Nachkommastellen wie im folgenden Beispiel:

```java
int wert;
double pi = 3.1415926; // usw.

wert = (int) pi; // danach ist wert = 3

wert = pi; // Fehler: "error: incompatible types: possible lossy conversion from double to int"
```

Durch den Cast-Operator `(<Zieldatentyp>)` vor der "Quellvariable" teilen wir dem Compiler mit, dass wir uns dem möglichen Informationsverlust bewusst sind und trotzdem eine Typumwandlung wünschen. 

Des Weiteren muss bei Berechnungen die automatische Typkonvertierung beachtet werden.
Addiert man beispielsweise eine Variable vom Typ `int` zu einer Variablen vom Typ `long`, so ist der resultierende Datentyp `long`, also immer der höherwertige Operand.

|  | `byte` | `char` | `short` | `int` | `long` | `float` | `double` |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **`byte`** | `int` | `int` | `int` | `int` | `long` | `float` | `double` |
| **`char`** | `int` | `int` | `int` | `int` | `long` | `float` | `double` |
| **`short`** | `int` | `int` | `int` | `int` | `long` | `float` | `double` |
| **`int`** | `int` | `int` | `int` | `int` | `long` | `float` | `double` |
| **`long`** | `long` | `long` | `long` | `long` | `long` | `float` | `double` |
| **`float`** | `float` | `float` | `float` | `float` | `float` | `float` | `double` |
| **`double`** | `double` | `double` | `double` | `double` | `double` | `double` | `double` |

### Arrays
Ein Array besitzt in Java eine statische Länge, die bei der Initialisierung zugewiesen wird.
Daraus folgt, dass zur Laufzeit keine weiteren Elemente hinzugefügt werden können, sondern nur die Elemente an den bereits initialisierten Indizes modifiziert werden können.

Der Zugriff auf ein Element des Arrays erfolgt ähnlich zu Python über den Index in `[]`.
```java
int[] einIntArray = new int[6]; // 6 Elemente (Index 0 bis 5)
for(int i = 0; i < einIntArray.length; i++) { // alle Elemente des Arrays durchlaufen
    System.out.println(einIntArray[i]); // Ausgabe: jeweils der Wert 0
}
```

Ein Basistyp kann im Gegensatz zu einer Variablen, die als Typ eine Klasse besitzt, nicht `null` sein.
Deshalb wird jedes Elements des Arrays mit dem "Standardwert" des Basistyps (siehe [Basistypen](#basistypen)) initialisiert.

Alternativ können bei der Initialisierung des Arrays auch die Initialisierungswerte über die `{ }`-Notation mitgegeben werden.
Die Länge des Arrays ergibt sich aus der Anzahl der Elemente in der Werteliste.

Zu beachten ist auch hier: Alle Elemente müssen den gleichen Typ besitzen, der bei der Deklaration des Arrays (z. B. `int[]`) festgelegt wurde.
```java
int[] einWeiteresIntArray = {1, 4, 8, 16, 42}; // 5 Elemente (Index 0 bis 4) und bereits initialisierte Werte
for(int i = 0; i < einWeiteresIntArray.length; i++) { // alle Elemente des Arrays durchlaufen
    System.out.println(einWeiteresIntArray[i]); // Ausgaben: 1, 4, 8, 16, 42
}
```

In vielen Fällen ist die erwartete bzw. maximale Anzahl an Werten, die in einem Array gespeichert werden sollen, nicht bei der Entwicklung des Programms bekannt.
Beispielsweise muss ein Onlinespiel zwei Spieler, aber auch 1000 Spieler unterstützen und speichern können.
Ein Ansatz wäre es, das Array der Spieler (hier vereinfacht als Spieler-IDs vom Typ `int`) bereits mit einer sehr großen Anzahl an Elementen zu initialisieren:
```java
int[] spielerIDs = new int[20000];
```
Dies bringt allerdings zwei Nachteile mit sich: 
1. Vielleicht gibt es auch Fälle, in denen mehr als 20.000 Spieler beitreten können.
Das Programm würde dann (ohne weitere Fehlerbehandlung) abstürzen, da z. B. der Index `spielerIDs[20001]` `OutOfBounds` ist, also für dieses Array nicht definiert wurde.
2. Sollten bei einem Onlinespiel doch nur weniger Spieler beitreten, muss der Speicherbereich für das 20.000-Elemente-Array trotzdem reserviert werden.
Das ist nicht besonders effizient.

Als Lösung kann ein "dynamisches" Array über diverse Implementierung des `List`-Interfaces (was das genau ist, erfahren wir später) realisiert werden.
Die bekannteste Implementierung ist die Klasse `ArrayList` aus dem standardmäßig in Java enthaltenen Paket `java.utils`.
Diese wird über `new ArrayList<>()` initialisiert und ist erst einmal leer, d.h. sie enthält `0` Werte.

Da die Klasse `ArrayList` möglichst alle möglichen Typen von Arrays unterstützen soll, können wir den Typ der Elemente zwischen den `<` und `>` mitgeben, z. B. `<String>`.
Zu beachten ist hier, dass die Basistypen wie beispielsweise `int` nicht unterstützt werden.
Um trotzdem ein Integer-Array verwenden zu können, kann eine sogenannte Wrapper-Klasse für die Basistypen verwendet werden.
Für `int` ist das `Integer`, für `double` `Double` und für die anderen Basistypen entsprechend der Typname mit einem großen statt einem kleinen Anfangsbuchstaben.

```java
ArrayList<String> dynamischesStringArray = new ArrayList<>();
ArrayList<Integer> dynamischesIntegerArray = new ArrayList<>();
```

Bei einer `ArrayList` handelt es sich um ein Objekt, d.h. wir können verschiedene Methoden verwenden, um Elemente hinzuzufügen oder zu löschen, die Anzahl der Elemente ausgeben zu lassen usw.
Alle implementierten Methoden können in der [offiziellen Dokumentation der `ArrayList`-Klasse](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/ArrayList.html) eingesehen werden.

Die wichtigsten Methoden sind:

```java
dynamischesStringArray.add("Hello World"); // fügt den String "Hello World" an der nächsten freien Position ein
dynamischesStringArray.add(index, "Hello World"); // fügt den String "Hello World" an Position "index" (Ganzzahl) ein

dynamischesStringArray.get(index); // gibt das Element am Index "index" (eine Ganzzahl) zurück, z. B. .get(1);

dynamischesStringArray.remove("Hello World"); // entfernt den String "Hello World" aus der ArrayList

dynamischesStringArray.size(); // gibt die Anzahl der Elemente, die momentan in der ArrayList gespeichert sind, zurück
``` 

### `null`
Im Unterschied zu den Basistypen kann ein Objekt auch "leer" sein, also keine Referenz auf eine Speicheradresse aufweisen.
In Java hat dies dann den "Wert" `null`.

Beispielsweise bedeutet die Anweisung `String einString = null;`, dass wir eine neue Variable des Typs/der Klasse `String` deklarieren möchten, der allerdings keine Speicherreferenz aufweist.
Sobald wir diesen dann mit einem anderen Wert, z. B. `einString = "Hello World";` überschreiben, wird im Speicher ein Objekt der Klasse `String` angelegt und die Referenz darauf in der Variable `einString` gespeichert.

Im Unterschied zur `String einString;`, was einer Deklaration entspricht, ist `einString` mit der Zuweisung von `null` bereits initialisiert.
Die folgende Anweisung erzeugt einen Fehler, da `einString` noch nicht initialisiert wurde:

```java
String einString;
System.out.println(einString); // Fehlermeldung: "error: variable einString might not have been initialized"
```

Initialisiert man `einString` hingegen mit `null`, so besitzt die Variable nur keine Referenz auf ein Objekt:
```java
String einString = null;
System.out.println(einString); // Ausgabe: null
```

Ob eine Variable vom Typ einer Klasse zu einem Zeitpunkt während der Programmausführung einen Wert besitzt, kann über den Vergleich mit `null` überprüft werden:

```java
String einString = null;
if(einString == null) {
    System.out.println("Ist null!");
} else {
    System.out.println("Ist NICHT null!");
}
```

### Konstanten
Im Gegensatz zu Variablen, deren Wert auch nach der Initialisierung geändert werden kann, existieren in der Programmierung auch sogenannte Konstanten.
Diese sind, sobald sie einmal initialisiert wurden, d.h. einen Wert zugewiesen bekommen haben, nicht mehr veränderbar und dadurch konstant.

In Java teilt man dem Compiler mit dem Schlüsselwort `final` mit, dass es sich nicht um eine Variable, sondern um eine Konstante handelt.
Um Konstanten besser von Variablen unterscheiden zu können, schreibt man diese meistens in Großbuchstaben, z. B. `final int MAXIMALE_ANZAHL_SPIELER = 10;`.

```java
final double PI = 3.1415926; // usw.
PI = 4; // Compilerfehler   
```

Durch den Einsatz von Konstanten kann die Übersichtlichkeit des Quelltexts erhöht werden.
Anstatt an jeder Stelle, an der die Zahl `3.1415926` verwendet wird, diese als solche hinzuschreiben, wird sie einmalig als `PI` definiert und ist über diesen Bezeichner überall verwendbar.
Sollte sich der Wert einer Konstante ändern, z. B. soll die `MAXIMALE_ANZAHL_SPIELER` auf `15` erhöht werden, so muss diese Änderung nur an einer anstatt an jeder einzelnen Stelle im Code vorgenommen werden.
Da der Compiler explizit überprüft, ob unsere Konstante existiert, reduziert dies auch die Fehlerhäufigkeit, da beispielsweise `3.1416` ebenfalls ein valider Wert wäre, nicht aber `IP` statt `PI`.

## Schleifen
### `for`-Schleife
Eine `for`-Schleife ist eine sogenannte "kopfgesteuerte" Schleife, da die Überprüfung des Abbruchkriteriums _vor_ jeder Iteration stattfindet.
Die Schleife besteht aus drei Teilen:
1. Initialisierung der Zählervariable: z. B. `int i = 0;`
2. Abbruchbedingung: z. B. `i < 10;`
3. Nach jeder Iteration ausgeführte Anweisung: z. B. `i++;` oder `i = i + 4;` für Viererschritte

Die Syntax sieht wie folgt aus und tut das gleiche wie `for i in range(0, 10);` in Python, nämlich den Schleifenrumpf (`{ }`) 10 Mal durchlaufen und dabei nach jeder Iteration die Variable `i` um eins erhöhen. 

```java
// for(1.; 2.; 3.) { }
for(int i = 0; i < 10; i++) {
    // wird in jedem Schleifendurchlauf ausgeführt ...
}
```

Alternativ kann man die drei oben genannten Teile auch teilweise oder komplett in den Schleifenrumpf verschieben:

```java
int i = 0; // wir starten bei i = 0

for( ; ;) {
    if(i == 10) {
        break; // wenn der Wert von i 10 erreicht, brechen wir ab
    }
    
    // wird in jedem Schleifendurchlauf ausgeführt ...

    i++; // Zählervariable um 1 erhöhen
}
```

Diese Schreibweise ist allerdings im Vergleich zu "zentralen" Pflege der drei "Schleifenteile" im ersten Beispiel nicht gut lesbar und fehleranfällig, da es bei Nichtbeachtung einer Variablenkonstellation einfacher zu einer Endlosschleife kommen kann. 


### `for`-Schleife (vereinfacht)
Für Manche Objekte wie auch `ArrayList` bieten die Möglichkeit, eine vereinfachte Form der `for`-Schleife zu schreiben.
Dazu muss keine Zählervariable definiert und manuell hochgezählt werden, sondern die Schleife wird automatisch für jedes Element, dass sich in dem `ArrayList`-Objekt befindet, ausgegeben.
In anderen Sprachen wird diese Art von Schleife auch als `foreach`-Schleife bezeichnet, da sie "für jedes Element des Arrays" ausgeführt wird.

```java
ArrayList<String> eineArrayList = new ArrayList<>();

eineArrayList.add("Hello");
eineArrayList.add("World");
// ... mehr Elemente über .add() hinzufügen

for(String einElement : eineArrayList) {
    System.out.println(einElement); // gibt jedes Element in der ArrayList an der Konsole aus
} 
```

Diese Notation erzielt das gleiche Ergebnis wie die folgende:

```java
ArrayList<String> eineArrayList = new ArrayList<>();

eineArrayList.add("Hello");
eineArrayList.add("World");
// ... mehr Elemente über .add() hinzufügen

for(int i = 0; i < eineArrayList.size(); i++) {
    String einElement = eineArrayList.get(i);
    System.out.println(einElement); // gibt jedes Element in der ArrayList an der Konsole aus
} 
```

### `while`-Schleife
Die `while`-Schleife ist bereits aus Python bekannt.
Sie ist ebenfalls wie die `for`-Schleife "kopfgesteuert", allerdings gibt man hier nicht die Abbruch-, sondern die "Weiterlaufbedingung" an und muss sich um die eventuell notwendige Zählervariable im Schleifenrumpf selbst kümmern.

Die `for`-Schleife im Abschnitt [`for`-Schleife](#for-schleife) sieht als `while´-Schleife so aus:
```java
int i = 0; // Zählervariable mit 0 initialisieren

while (i < 10) {
    // wird in jedem Schleifendurchlauf ausgeführt ...

    i++; // Zählervariable hochzählen
}
```

Die `while`-Schleife eignet sich somit eher für Anwendungsfälle, wo bei Start der Schleife noch nicht klar ist, wann diese "sich beenden" wird.
In anderen Worten kann die Anzahl der Iterationen im Vorhinein noch nicht bestimmt werden.

(Stark vereinfachtes) Beispiel eines Webservers, der wartet, bis eine Anfrage von einem Client eingeht: 
```java
Webserver webserverObject = new Webserver();

while(webserverObject.clientRequestExists() == false) {
    System.out.println("Warten auf Client-Request...");
}
```

Natürlich muss an anderer Stelle definiert werden, wann `clientRequestExists()` statt `false` `true` zurückgibt, ansonsten wird aus der Schleife eine Endlosschleife, d.h. sie endet nie und das Programm hängt sich auf.

### `do-while`-Schleife
Im Gegensatz zur `for`- und zur `while`-Schleife ist die `do-while`-Schleife "fußgesteuert", d.h. sie läuft _immer_ mindestens einmal durch, da die Abbruchbedingung erst nach Ende jeder Iteration überprüft wird.

```java
int i = 0;

do {
    System.out.println("Schleife ausgeführt");
} while(i > 0);
```

In diesem Fall würde eine "kopfgesteuerte" `for`- oder `while`-Schleife gar nicht erst ausgeführt, da die Abbruchbedingung `i > 0` bereits zu Beginn erfüllt ist, da `i == 0` ist.
Folglich würde auch keine Ausgabe an der Konsole erscheinen.

Im Gegensatz dazu würde das folgende Beispiel den Text fünfmal an der Konsole ausgeben:
```java
int i = 5;

do {
    System.out.println("Schleife ausgeführt");
    i--; // nach jedem Durchlauf i um 1 dekrementieren
} while(i > 0);
```

| Wert von `i` vor `do`-Block | Wert von `i` nach `do`-Block | Ausgabe | `i > 0` |
| :--- | :--- | :--- | :--- |
| `5` | `4` | ja | erfüllt |
| `4` | `3` | ja |  erfüllt |
| `3` | `2` | ja |  erfüllt |
| `2` | `1` | ja |  erfüllt |
| `1` | `0` | ja |  nicht erfüllt |
 
Die Verwendung der `do-while`-Schleife sollte nur in Fällen, in denen man sich den "Nebenwirkungen" bewusst ist, in Betracht gezogen werden. 
 
## Methoden
### `void` und Rückgabewerte
Da Java typisiert ist, müssen wir für jede Methode auch mitteilen, welcher Rückgabewert (bei einem `return`) zu erwarten ist.
Dabei können alle Basistypen wie beispielsweise `int`, aber auch Klassen wie `String` oder `MeineSpielerKlasse` verwendet werden.
Soll die Methode (wie auch die `main`) keinen Wert zurückgeben, muss `void` angegeben werden, was im Englischen etwa `nichtig` oder `leer` bedeutet.

### `main`-Methode
Die `main`-Methode ist eine statische Methode, d.h. sie ist für die Klasse definiert und damit für alle Objekte der Klasse gleich.
Jede Java-Applikation benötigt eine statische Methode mit dem Namen `main` und folgender Signatur:

```java
public static void main(String[] args) {
    // Inhalt des Programms ...
}
```

Die `main`-Methode wird von der JVM zuerst aufgerufen und startet alle weiteren Aktionen.
Das `String`-Array `args` wird von der JVM mit dem beim Ausführen des Programms (mit dem Programm `java`) übergebenen Parametern gefüllt.
Beispielsweise lassen sich so bei jedem Programmstart andere Optionen mitgeben:

```bash
java MeinDateiAuflistProgramm verzeichnis=Bilder
```

Mit dem Programmaufruf wäre der Wert von `args[0]` nun `verzeichnis=Bilder`.
Dies könnte unser Programm entsprechend interpretieren und alle Dateien im Verzeichnis `Bilder` auflisten.
Möchte ich das Programm für den Ordner `Filme` benutzen muss ich nicht den Programmcode anpassen, sondern übergebe dem Programm beim Aufruf einfach folgendes:

```
java MeinDateiAuflistProgramm verzeichnis=Filme
```

## `package` und `import`
Gerade bei größeren Projekten, an den viele Programmierende parallel arbeiten, wird der Code schnell unübersichtlich.
Zudem werden in Java Projekte in Modulen organisiert, um beispielsweise Namensdopplungen bei Klassendefinitionen zu vermeiden.
Deshalb weist man über die Anweisung `package <package name>`, also z. B. `package vorlesung.beispiele.basics;` zu Beginn einer jeden (Klassen-)Datei die jeweiligen Artefakte wie Klassen usw. einem Paket (`package`) zu.
Die durch `.` separierten Bestandteile des Paketnamens werden als Ordnerhierarchie angesehen.

Sollen nun in einem zweiten Paket `vorlesung.beispiele.advanced` Klassen vom Paket `vorlesung.beispiele.basics` importiert werden, so kann dafür die `import`-Anweisung genutzt werden.
Entweder gibt man direkt den Namen der zu importierenden Klasse an, beispielsweise `import vorlesung.beispiele.basics.EineKlasse;` oder man importiert über das Wildcard-Symbol `*` alle Klassen aus dem Paket (`import vorlesung.beispiele.basics.*;`).
Die darüber importierten Klassen bzw. Module aus anderen Paketen können dann auch im eigenen Paket genutzt werden:

**`BasicProgramm.java`**                                                                                                      
```java
package vorlesung.beispiele.bascis;

class BasicProgramm {
    public int quadrieren(int zahl) {
        return zahl * zahl;
    }
}
```

**`AdvancedProgramm.java`**                                                                                                      
```java
package vorlesung.beispiele.advanced;

import vorlesung.beispiele.basics.BasicProgramm;
// oder: import vorlesung.beispiele.basics.*;

class AdvancedProgramm {
    public static void main(String[] args) {
        BasicProgramm einBasicProgramm = new BasicProgramm();
        System.out.println(einBasicProgramm.quadrieren(5)); // Ausgabe: 25
    }
}
```

Nach dem gleichen Prinzip wurde auch die `ArrayList`-Klasse aus dem Paket `java.utils` im Abschnitt [Arrays](#arrays) eingebunden.