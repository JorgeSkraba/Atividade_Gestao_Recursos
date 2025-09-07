#include <iostream>
#include <thread>
#include <vector>
#include <mutex>

int contador = 0;
std::mutex mtx;

void incrementar_contador(int threadId) {
    std::cout << "Thread " << threadId << " iniciada\n";

    for (int i = 0; i < 1000; i++) {
        std::lock_guard<std::mutex> lock(mtx); // RAII
        contador++;
    }

    std::cout << "Thread " << threadId << " terminou\n";
}

int main() {
    std::cout << "5 threads incrementando contador 1000 vezes cada\n";
    std::cout << "Executando...\n\n";

    std::vector<std::thread> threads;

    for (int i = 1; i <= 5; i++) {
        threads.emplace_back(incrementar_contador, i);
    }

    for (auto& t : threads) {
        t.join();
    }

    std::cout << "\n=== RESULTADOS ===\n";
    std::cout << "Valor final do contador: " << contador << "\n";
    std::cout << "Valor esperado: 5000\n";

    return 0;
}
