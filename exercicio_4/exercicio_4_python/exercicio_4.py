import os
import subprocess
import sys

NUM_PROCESSES = 3

def main():
    print(f"Processo Pai (PID: {os.getpid()})")

    processes = []
    for i in range(NUM_PROCESSES):
        try:
            # Comando 
            cmd = ["notepad"]
            
             # inicia o processo
            processo = subprocess.Popen(cmd)  
            processes.append(processo)
            print(f"Pai: criado Processo Filho {i+1} (PID: {processo.pid})")

        except FileNotFoundError as e:
            print(f"Pai: Erro ao criar o processo filho {i+1}: comando não encontrado ({e})")
           
            return
        except OSError as e:
            print(f"Pai: Erro ao criar o processo filho {i+1}: {e}")
            return

    print("Pai: Todos os filhos lançados. Pressione Enter para terminar o pai")
    input()

if __name__ == "__main__":
    main()