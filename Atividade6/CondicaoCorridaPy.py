import threading
import time

# Variável global compartilhada
contador = 0

def incrementar_contador(thread_id):
    global contador
    print(f"Thread {thread_id} iniciada")
    
    for i in range(1000):
        contador += 1 
    
    print(f"Thread {thread_id} terminou")

def main():
    global contador
    print("5 threads incrementando contador 1000 vezes cada")
    print("Executando...\n")
    
    threads = []
    
    for i in range(1, 6):
        t = threading.Thread(target=incrementar_contador, args=(i,))
        threads.append(t)
        t.start()
    
    for t in threads:
        t.join()
    
    # Resultado final
    print("\n=== RESULTADOS ===")
    print(f"Valor final do contador: {contador}")
    print("Valor esperado: 5000")
    
    if contador == 5000:
        print("Resultado correto (sorte ou poucas threads)")
    else:
        print(f"Race condition ocorreu! Perdemos {5000 - contador} incrementos")
    
    print("\n=== EXPLICAÇÃO ===")
    print("A operação 'contador++' não-atômica (leitura-modificação-escrita)!")
    print("Múltiplas threads podem interferir umas nas outras.")

if __name__ == "__main__":
    main()