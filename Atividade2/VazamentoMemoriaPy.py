lista_blocos = []  
Contador = 0

print("Simulando vazamento de memoria. Observe o consumo no Gerenciador de Tarefas.")
print("Pressione Ctrl+C para parar.")

try:
    while True:
        try:
            P = bytearray(1024) 
            
            lista_blocos.append(P)
            
        except MemoryError:
            print("Falha ao alocar memoria. Provavelmente sem memoria disponivel.")
            break 
        
        Contador = Contador + 1
        
        if (Contador % 1000) == 0:
            print(f"Blocos alocados: {Contador}")

except KeyboardInterrupt:
    print(f"\nPrograma interrompido. Total de blocos: {Contador}")

input("Pressione Enter para sair...")