# Exkurs: Strings vs. Basistypen
## Frage
Warum verhalten sich in Java ein `String` bzw. ein Objekt einer Klasse anders als die Basistypen (z. B. `int` oder `double`)?

## Erläuterung
Ein String verhält sich nicht in allen Belangen wie ein "normales" Objekt in Java, da es zwar kein Basistyp ist, trotzdem aber (teilweise) als ein Literal (also ein definierter fester Wert im Quelltext, wie z. B. auch der Integer `1` oder `6`) behandelt wird (Stichworte `String Pool` und `Literale`).

Es macht einen Unterschied, ob man einen neuen String mit `String text = new String("Ein Text");` initialisiert oder mit `String text = "Ein Text";`. 
Aus diesem Grund bitte immer `einString.equals(einAndererString);` verwenden, um die (Text-)Gleichheit von zwei Strings zu vergleichen.

Über die Erstellung eines neuen Objekts mit `new String()` "sagen" wir Java, dass wir eine neue String-Referenz anlegen möchten.
Wenn wir das über die `""`-Notation machen, wird der Wert im sogenannten _String Pool_ gespeichert und wenn wir zwei Strings mit diesem Wert und der gleichen Notation anlegen, zeigen beide auf den gleichen Eintrag im String-Pool.
In diesem Fall verhält sich ein `String` vereinfacht gesagt wie ein Basistyp.

Dieses Konzept nennt sich `String Interning` und ist auch in der offiziellen Dokumentation zur String-Klasse beschrieben:

> When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object) method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String object is returned. 

Quelle: [Java API Dokumentation für die Klasse "String"](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html)

Um das allgemein gültige Verhalten von Objekten und deren Referenzen zu demonstrieren, habe ich die Klasse `Person` erstellt, da dort der Unterschied zwischen Objektreferenzen und Werten deutlicher wird.

Nach dem Ausführen des Beispiels sehen Sie in der Konsole, dass das Ändern des Namens von `person1` auch den von `person2` ändert, da beide auf die gleiche Speicheradresse und im Endeffekt das gleiche Objekt zeigen.

Wenn Sie das Konzept des `String Pools` im Detail verstehen möchten, empfehle ich Ihnen folgenden Beitrag: [Baeldung: Java String Pool](https://www.baeldung.com/java-string-pool)

## Beispiele
- auf [Repl.it](https://repl.it/join/hjvkrsaq-laundy)
- Verzeichnis `Strings vs. Basistypen`

## Weiterführende Links
- [Baeldung: Java String Pool](https://www.baeldung.com/java-string-pool)
- [GeeksforGeeks: Interning of String in Java](https://www.geeksforgeeks.org/interning-of-string/)