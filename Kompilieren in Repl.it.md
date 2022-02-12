# Lösung von Kompilierungsfehlern in Repl.it

## Hintergrund
[https://stackoverflow.com/a/8769536/5508497](https://stackoverflow.com/a/8769536/5508497)

## Linux, macOS und Repl.it
- Terminal öffnen
- `find -name "*.java" > sources.txt` eingeben und ausführen
- `javac @sources.txt` eingeben und ausführen

## Windows
- Kommandozeile (`cmd`) oder `Powershell` öffnen
- `dir /s /B *.java > sources.txt` eingeben und ausführen
- `javac @sources.txt` eingeben und ausführen

## Konfiguration in der .replit-Datei
```
language = "java10"
run = "cd <Ordnername> && java JavaIntro"
```