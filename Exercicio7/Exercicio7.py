import threading

# Variável global compartilhada
contador = 0
lock = threading.Lock()


def incrementar_contador(thread_id):
    global contador
    print(f"Thread {thread_id} iniciada")

    for i in range(1000):
        with lock:  # garante exclusão mútua
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

    print("\n=== RESULTADOS ===")
    print(f"Valor final do contador: {contador}")
    print("Valor esperado: 5000")


if __name__ == "__main__":
    main()
