#include <iostream>
using namespace std;

int main() {
    char* P; 
    int Contador = 0;
    
    cout << "Simulando vazamento de memoria. Observe o consumo no Gerenciador de Tarefas." << endl;
    cout << "Pressione Ctrl+C para parar." << endl;
    
    while (true) {
        P = new(nothrow) char[1024]; 
        
        if (P == nullptr) {
            cout << "Falha ao alocar memoria. Provavelmente sem memoria disponivel." << endl;
            break;
        }
        
        Contador++;
        
        if ((Contador % 1000) == 0) {
            cout << "Blocos alocados: " << Contador << endl;
        }
    }
    
    cout << "Pressione Enter para sair...";
    cin.get();
    
    return 0;
}