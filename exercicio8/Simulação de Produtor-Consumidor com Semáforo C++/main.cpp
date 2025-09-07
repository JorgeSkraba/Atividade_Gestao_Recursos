#include <iostream>
#include <thread>
#include <semaphore>
#include <random>
#include <mutex>

const int NUM_ITEMS = 10;
int buffer = 0;
std::binary_semaphore vazio(1), cheio(0);
std::mutex mtx;

void produtor() {
    std::mt19937 gen(std::random_device{}());
    for (int i = 0; i < NUM_ITEMS; ++i) {
        int item = gen() % 100 + 1;
        vazio.acquire();
        buffer = item;
        std::lock_guard<std::mutex> lk(mtx);
        std::cout << "Produtor produziu: " << item << '\n';
        cheio.release();
    }
}

void consumidor() {
    for (int i = 0; i < NUM_ITEMS; ++i) {
        cheio.acquire();
        int item = buffer;
        std::lock_guard<std::mutex> lk(mtx);
        std::cout << "Consumidor consumiu: " << item << '\n';
        vazio.release();
    }
}

int main() {
    std::thread prod(produtor), cons(consumidor);
    prod.join();
    cons.join();
}