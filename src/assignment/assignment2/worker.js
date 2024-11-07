// worker.js
self.onmessage = function(e) {
    let result = e.data * 2; // Einfache Berechnung
    postMessage(result);
};