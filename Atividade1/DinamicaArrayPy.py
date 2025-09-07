meu_array = None

try:
    tamanho = int(input("Digite o tamanho do array: "))
    
    if tamanho <= 0:
        print("Erro: O tamanho deve ser um número positivo!")
        exit() 
    
    meu_array = [0] * tamanho
    
    for i in range(tamanho):
        meu_array[i] = i + 1
    
    print("Conteúdo do array:")
    for i in range(len(meu_array)):
        print(meu_array[i])
        
except ValueError:
    print("Erro: Digite um número inteiro válido!")
except MemoryError:
    print("Erro: Não foi possível alocar memória para o array!")
except Exception as e:
    print(f"Erro inesperado: {e}")
finally:
    meu_array = None

print("Programa finalizado. Memória será liberada automaticamente.")