#include <iostream>
#include <vector>
#include <string>
#include <windows.h>

const int NUM_PROCESSES = 3;

int main() {

    std::cout << "Processo Pai (PID: " << GetCurrentProcessId() << ")\n";
    std::vector<HANDLE> childHandles;

    for (int i = 0; i < NUM_PROCESSES; ++i) {

        std::string cmd = "notepad";

        // criacao buffer modificavel
        std::vector<char> cmdBuf(cmd.begin(), cmd.end());
        cmdBuf.push_back('\0');

        STARTUPINFOA si;
        PROCESS_INFORMATION pi;
        ZeroMemory(&si, sizeof(si));
        si.cb = sizeof(si);
        ZeroMemory(&pi, sizeof(pi));

        BOOL ok = CreateProcessA(
            NULL,               // nome do aplicativo (NULL -> usa cmd line)
            cmdBuf.data(),      // linha de comando 
            NULL, NULL, FALSE,  
            0, NULL, NULL,
            &si, &pi
        );

        if (!ok) {
            DWORD err = GetLastError();
            std::cerr << "Pai: Erro ao criar o processo filho " << (i+1)
                      << ": código de erro " << err << "\n";
        }

        // pid processo filho
        DWORD childPid = GetProcessId(pi.hProcess);
        std::cout << "Pai: criado Processo Filho " << (i+1)
                  << " (PID: " << childPid << ")\n";

        // fechar handle de thread
        CloseHandle(pi.hThread);
    }

    std::cout << "Pai: Todos os filhos lançados. Pressione Enter para terminar.\n";
    std::string dummy;
    std::getline(std::cin, dummy);
    return 0;
}