#include <iostream>
#include <thread>
#include <chrono>
#include <vector>

using namespace std;

// Função que será executada por cada thread
void workerThread(int threadID) {
    for (int i = 1; i <= 5; i++) {
        // Espera 0.5 segundos
        this_thread::sleep_for(chrono::milliseconds(500));
        
        // Imprime a mensagem
        cout << "Thread " << threadID << ": Contagem " << i << endl;
    }
    
    // Mensagem de finalização
    cout << "Thread " << threadID << ": Terminou." << endl;
}

int main() {
    cout << "=== PROGRAMA COM 3 THREADS ===" << endl;
    cout << "Thread principal: Iniciando..." << endl;
    
    // Cria as 3 threads
    cout << "Thread principal: Iniciando as 3 threads..." << endl;
    thread thread1(workerThread, 1);
    thread thread2(workerThread, 2);
    thread thread3(workerThread, 3);
    
    // Thread principal espera todas terminarem
    cout << "Thread principal: Aguardando threads terminarem..." << endl;
    thread1.join(); // Espera thread 1 terminar
    thread2.join(); // Espera thread 2 terminar
    thread3.join(); // Espera thread 3 terminar
    
    // Mensagem final
    cout << "Thread principal: Todas as threads terminaram. Finalizando programa." << endl;
    
    return 0;
}