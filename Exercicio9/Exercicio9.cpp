#include <iostream>
#include <thread>
#include <vector>

using namespace std;

void somaIntervalo(long inicio, long fim, long &resultado) {
    long somaLocal = 0;
    for (long j = inicio; j <= fim; j++) {
        somaLocal += j;
    }
    resultado = somaLocal;
}

int main() {
    const int numThreads = 4;
    long tamanhoRangeThreads = 1000000 / numThreads;

    vector<thread> threads;
    vector<long> resultadosParciais(numThreads);

    for (int i = 0; i < numThreads; i++) {
        long inicio = (i * tamanhoRangeThreads) + 1;
        long fim = (i == numThreads - 1) ? 1000000 : (i + 1) * tamanhoRangeThreads;

        threads.emplace_back(somaIntervalo, inicio, fim, ref(resultadosParciais[i]));
    }

    for (auto &t : threads) {
        t.join();
    }

    long somaTotal = 0;
    for (long r : resultadosParciais) {
        somaTotal += r;
    }

    cout << "Soma total = " << somaTotal << endl;
    return 0;
}
