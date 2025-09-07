#include <iostream>
#include <chrono>
using namespace std;

struct MeuRegistro {
    int id;
    char data [100];
};

const int Numero = 1000000;

int main() {
    auto comeca = chrono::high_resolution_clock::now();
    for (int i = 0; i < Numero; i++) {
        MeuRegistro* meuregistro = new MeuRegistro;
        meuregistro -> id = i;
        delete meuregistro;
        
    }
    
    auto fim = chrono::high_resolution_clock::now();
    auto duration = chrono::duration_cast<chrono::milliseconds>(fim - comeca);

    cout << "Tempo de desalocacao manua: "
         << duration.count() << " ms" << endl;

    return 0;
}

