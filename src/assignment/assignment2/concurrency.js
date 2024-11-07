// Nebenläufigkeit (Concurrency oder Multithreading)
// Definition: Nebenläufigkeit bedeutet, dass mehrere Aufgaben scheinbar gleichzeitig ausgeführt werden,
// oft durch das schnelle Umschalten zwischen Aufgaben.
// In JavaScript wird dies durch asynchrone Funktionen und Event Loop erreicht.

async function fetchData() {
    console.log("Daten werden abgerufen...");
    const data = await new Promise(resolve => setTimeout(() => resolve("Daten geladen"), 2000));
    console.log(data);
}

console.log("Starte Prozess");
fetchData();
console.log("Prozess läuft weiter");


// Die Funktion fetchData läuft asynchron,
// aber die Event Loop ermöglicht das Weiterlaufen des restlichen Codes (Prozess läuft weiter).