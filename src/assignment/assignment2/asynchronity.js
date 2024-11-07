//Definition: Asynchronität bedeutet, dass bestimmte Aufgaben im Code ausgeführt werden,
//ohne darauf zu warten, dass andere Aufgaben abgeschlossen sind.
//Das ist hilfreich, um z.B. auf eine Antwort von einem Server zu warten, ohne den restlichen Code zu blockieren.

console.log("Starte Aufgabe 1");

//setTimeout ist asynchron und blockiert den Ablauf des Codes nicht.
setTimeout(() => {
    console.log("Asynchrone Aufgabe abgeschlossen");
}, 2000); // 2 Sekunden Verzögerung

console.log("Starte Aufgabe 2");


//"Starte Aufgabe 1" und "Starte Aufgabe 2" werden sofort ausgegeben,
// während "Asynchrone Aufgabe abgeschlossen" nach 2 Sekunden erscheint.