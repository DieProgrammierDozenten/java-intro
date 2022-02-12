class Main {
  public static void main(String[] args) {
    // String (als Literal, d.h. ohne explizites new String())
    String string1 = "Josef";
    String string2 = string1;
    System.out.println("String 1: " + string1); // string1 = "Josef"
    System.out.println("String 2: " + string2); // string2 = "Josef"
    System.out.print("Variablengleichheit: ");
    System.out.println(string1 == string2); // true
    System.out.println("Stringgleichheit: " + string1.equals(string2)); // true

    string1 = "Peter"; 

    System.out.println("String 1: " + string1); // string1 = "Peter"
    System.out.println("String 2: " + string2); // string2 = "Josef"
    System.out.print("Variablengleichheit: ");
    System.out.println(string1 == string2); // false
    System.out.println("Stringgleichheit: " + string1.equals(string2)); // false

    System.out.println(); // leere Zeile zur Erhöhung der Übersichtlichkeit

    // String mit expliziter Konstruktorbenutzung
    String stringObjekt1 = new String("Josef");
    String stringObjekt2 = new String(stringObjekt1); // unterschiedlich zu direkter Zuweisung stringMitKonstruktor2 = stringMitKonstruktor1
    System.out.println("String mit explizitem Konstruktoraufruf 1: " + stringObjekt1); // stringObjekt1 = "Josef"
    System.out.println("String mit explizitem Konstruktoraufruf 2: " + stringObjekt2); // stringObjekt2 = "Josef"
    System.out.print("Variablengleichheit: ");
    System.out.println(stringObjekt1 == stringObjekt2); // false (da zwei verschiedene Speicheradressen referenziert werden)
    System.out.println("Stringgleichheit: " + stringObjekt1.equals(stringObjekt2)); // true (da der "Text" in beiden String-Objekten der gleiche ist) <- zum Vergleichen von Strings immer .equals() verwenden!

    stringObjekt1 = new String("Peter"); // unterschiedlich zu direkter Zuweisung stringMitKonstruktor1 = "Peter"

    System.out.println("String mit explizitem Konstruktoraufruf 1: " + stringObjekt1); // stringObjekt1 = "Peter"
    System.out.println("String mit explizitem Konstruktoraufruf 2: " + stringObjekt2); // stringObjekt2 = "Josef"
    System.out.print("Variablengleichheit: ");
    System.out.println(stringObjekt1 == stringObjekt2); // false
    System.out.println("Stringgleichheit: " + stringObjekt1.equals(stringObjekt2)); // false

    System.out.println(); // leere Zeile zur Erhöhung der Übersichtlichkeit

    // int
    int int1 = 47;
    int int2 = int1;
    System.out.println("Integer 1: " + int1); // int1 = 47
    System.out.println("Integer 2: " + int2); // int2 = 47

    int1 = 74;

    System.out.println("Integer 1: " + int1); // int1 = 74
    System.out.println("Integer 2: " + int2); // int2 = 47

    System.out.println(); // leere Zeile zur Erhöhung der Übersichtlichkeit

    // Eigene Klasse "Person"
    Person person1 = new Person("Max");
    Person person2 = person1;
    // Hinweis: nun zeigen beide Variablen person1 und person2 auf die Referenz einer Person mit dem Namen "Max"

    System.out.println("Name von Person 1: " + person1.name); // person1.name = "Max"
    System.out.println("Name von Person 2: " + person2.name); // person2.name = "Max"

    person1.name = "Moritz";

    System.out.println("Name von Person 1: " + person1.name); // person1.name = "Moritz"
    System.out.println("Name von Person 2: " + person2.name); // person2.name = "Moritz"
  }
}