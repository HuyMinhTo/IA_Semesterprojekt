// Definition: Parallelität bedeutet, dass mehrere Aufgaben gleichzeitig ausgeführt werden.
// In der Programmierung passiert dies oft in Systemen mit mehreren Kernen,
// bei denen verschiedene Threads auf verschiedenen Kernen parallel laufen.



// main.js
let worker = new Worker('worker.js');
worker.postMessage(10); // Sendet Daten an den Worker

worker.onmessage = function(e) {
    console.log("Ergebnis vom Worker:", e.data); // Ausgabe: Ergebnis vom Worker: 20
};

// Der Code in worker.js läuft in einem separaten Thread
// und führt Berechnungen unabhängig vom Haupt-Thread aus.