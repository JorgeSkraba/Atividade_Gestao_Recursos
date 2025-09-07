import threading
import time

# Função que será executada por cada thread
def worker_thread(thread_id):
    for i in range(1, 6):  # 1 até 5
        # Espera 0.5 segundos
        time.sleep(0.5)
        
        # Imprime a mensagem
        print(f"Thread {thread_id}: Contagem {i}")
    
    # Mensagem de finalização
    print(f"Thread {thread_id}: Terminou.")

def main():
    print("=== PROGRAMA COM 3 THREADS ===")
    print("Thread principal: Iniciando...")
    
    # Cria as 3 threads
    print("Thread principal: Iniciando as 3 threads...")
    thread1 = threading.Thread(target=worker_thread, args=(1,))
    thread2 = threading.Thread(target=worker_thread, args=(2,))
    thread3 = threading.Thread(target=worker_thread, args=(3,))
    
    # Inicia as threads
    thread1.start()
    thread2.start()
    thread3.start()
    
    # Thread principal espera todas terminarem
    print("Thread principal: Aguardando threads terminarem...")
    thread1.join()  # Espera thread 1 terminar
    thread2.join()  # Espera thread 2 terminar
    thread3.join()  # Espera thread 3 terminar
    
    # Mensagem final
    print("Thread principal: Todas as threads terminaram. Finalizando programa.")

if __name__ == "__main__":
    main()