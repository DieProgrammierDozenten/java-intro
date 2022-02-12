# JavaFX
## Inhaltsverzeichnis
- [Download und Einrichtung](#download-und-einrichtung)
- [Nützliche Links](#nützliche-links)
    
## Download und Einrichtung
JavaFX ist eine Bibliothek, die Java um Funktionalitäten erweitert, die zur Erstellung von grafischen Benutzeroberflächen dienen.
Die Bibliothek muss über [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/) heruntergeladen werden.

Das heruntergeladene Archiv wird entpackt und sollte in einen Ordner verschoben werden, dessen Pfad sich später nicht mehr ändert.
Den Pfad zu diesem Ordner, z. B. `C:/dev/javafx-sdk-16` für Windows, benötigen Sie für die nächsten Einrichtungsschritte. 

Die genauen Schritte zur Konfiguration von JavaFX für Ihr Java-Projekt unterscheidet sich je nach verwendeter Entwicklungsumgebung.
Für [IntelliJ](https://openjfx.io/openjfx-docs/#IDE-Intellij) und [Eclipse](https://openjfx.io/openjfx-docs/#IDE-Eclipse) existieren detaillierte Schritt-für-Schritt-Anleitungen, die Sie befolgen können.

Grundlegend müssen in jedem Fall zwei Konfigurationen vorgenommen werden:
1. Die JavaFX-Bibliothek, die durch die `.jar`-Dateien im `lib`-Ordner repräsentiert ist, muss dem Projekt in der Entwicklungumgebung hinzugefügt werden.
2. Die Java Virtual Machine (JVM) muss beim Programmstart darauf hingewiesen werden, dass JavaFX verwendet werden soll.
Dazu gibt es die sogenannten `VM options`, die die IDE an die JVM weiterreicht.

## Nützliche Links
- [JavaFX-Tutorial auf Jenkov.com](http://tutorials.jenkov.com/javafx/index.html)
- [JavaFX-Tutorial bei Tutorialspoint](https://www.tutorialspoint.com/javafx/index.htm)