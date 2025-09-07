import time

numero = 1000000

class MeuRecord:
    def __init__(self, id):
        self.id = id
        self.data = bytearray(100)

start = time.time()

for i in range(numero):
    r = MeuRecord(i)

end = time.time()
print(f"Tempo: {(end - start) * 1000:.2f} ms")
