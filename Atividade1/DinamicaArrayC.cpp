#include <iostream>
#include <new> 

using namespace std;

int main() {
    int* meuArray = nullptr; 
    int tamanho;
    
    try {
        cout << "Digite o tamanho do array: ";
        cin >> tamanho;
        
        if (tamanho <= 0) {
            cout << "Erro: O tamanho deve ser um número positivo!" << endl;
            return 1;
        }
        
        meuArray = new int[tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            meuArray[i] = i + 1;
        }
        
        cout << "Conteúdo do array:" << endl;
        for (int i = 0; i < tamanho; i++) {
            cout << meuArray[i] << endl;
        }
        
    } catch (bad_alloc& e) {
        cout << "Erro: Não foi possível alocar memória para o array!" << endl;
        cout << "Detalhes: " << e.what() << endl;
        return 1;
    } catch (exception& e) {
        cout << "Erro inesperado: " << e.what() << endl;
        return 1;
    }
    
    delete[] meuArray;
    meuArray = nullptr;
    
    cout << "Programa finalizado. Memória liberada com sucesso." << endl;
    
    return 0;
}