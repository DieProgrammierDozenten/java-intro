# Vermischte `stdout`- und `stderr`-Zeilen in der IntelliJ-Konsole
## Hintergrund
Bei manchen Installationen von IntelliJ kommt es vor, dass die Ausgaben von regulärem Text (`stdout`) und "Fehlertexten" (`stderr`) vermischt werden.
Das bedeutet, dass die Reihenfolge der Ausgaben in der Konsole nicht der Reihenfolge von `System.out.println()` oder `System.err.println()` im Code entspricht.

## Testfall
Getestet werden kann das Verhalten bspw. über folgenden Code:
```java
for(int i = 0; i < 100; i++) {
  System.out.println(i + " stdout");
  System.err.println(i + " stderr");
}
```
Die erwartete Ausgabe ist:
```
0 out
1 out
...
99 out
0 err
1 err
2 err
...
99 err
```

## Lösungsansatz
Das Issue [IDEA-70016](https://youtrack.jetbrains.com/issue/IDEA-70016), das das Problem beschreibt, ist bereits seit über 10 Jahren offen und es existiert keine offizielle Lösung.
Allerdings hilft möglicherweise das Umschalten auf einen `Blocking-Mode`.
Dazu wählt man in IntelliJ im Menü `Help > Edit Custom Properties` und fügt folgende Zeile ein:
```
output.reader.blocking.mode=true
```
Quelle: [https://intellij-support.jetbrains.com/hc/en-us/community/posts/206882795/comments/360000399199](https://intellij-support.jetbrains.com/hc/en-us/community/posts/206882795/comments/360000399199)
