import threading

def soma_intervalo(inicio, fim, resultados, thread_id):
    soma_local = 0
    for j in range(inicio, fim + 1):
        soma_local += j
    resultados[thread_id] = soma_local

num_threads = 4
tamanho_range_threads = 1000000 // num_threads

threads = []
resultados_parciais = [0] * num_threads

for i in range(num_threads):
    inicio = (i * tamanho_range_threads) + 1
    fim = 1000000 if i == num_threads - 1 else (i + 1) * tamanho_range_threads
    t = threading.Thread(target=soma_intervalo, args=(inicio, fim, resultados_parciais, i))
    threads.append(t)
    t.start()

for t in threads:
    t.join()

soma_total = sum(resultados_parciais)
print("Soma total =", soma_total)
