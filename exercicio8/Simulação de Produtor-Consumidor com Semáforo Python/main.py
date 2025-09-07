import threading
import random

Item = 10
buffer = None

sem_vazio = threading.Semaphore(1)  
sem_cheio = threading.Semaphore(0) 

def produtor():
    global buffer
    for i in range(Item):
        item = random.randint(1, 100)
        sem_vazio.acquire()  
        buffer = item        
        print(f"Produtor produziu{item}")
        sem_cheio.release()  

def consumidor():
    global buffer
    for i in range(Item):
        sem_cheio.acquire()   
        item = buffer         
        buffer = None
        print(f"Consumidor consumiu{item}")
        sem_vazio.release()   

if __name__ == "__main__":
    t_prod = threading.Thread(target=produtor)
    t_cons = threading.Thread(target=consumidor)

    t_prod.start()
    t_cons.start()

    t_prod.join()
    t_cons.join()

    print("Fim.")