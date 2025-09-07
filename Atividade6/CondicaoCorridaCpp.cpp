#include <iostream>
#include <thread>
#include <vector>

using namespace std;

int contador = 0;

void incrementarContador(int threadId) {
    cout << "Thread " << threadId << " iniciada" << endl;
    
    for (int i = 0; i < 1000; i++) {
        contador++; 
    }
    
    cout << "Thread " << threadId << " terminou" << endl;
}

int main() {
    cout << "5 threads incrementando contador 1000 vezes cada\n";
    cout << "Executando...\n\n";
    
    vector<thread> threads;
    
    for (int i = 1; i <= 5; i++) {
        threads.emplace_back(incrementarContador, i);
    }
    
    for (auto& t : threads) {
        t.join();
    }
    
    cout << "\n=== RESULTADOS ===\n";
    cout << "Valor final do contador: " << contador << endl;
    cout << "Valor esperado: 5000" << endl;
    
    if (contador == 5000) {
        cout << "Resultado correto (sorte ou poucas threads)" << endl;
    } else {
        cout << "Race condition ocorreu! Perdemos " << (5000 - contador) << " incrementos" << endl;
    }
    
    cout << "\n=== EXPLICAÇÃO ===" << endl;
    cout << "A operação 'contador++' não-atômica (leitura-modificação-escrita)!" << endl;
    cout << "Múltiplas threads podem interferir umas nas outras." << endl;
    
    return 0;
}