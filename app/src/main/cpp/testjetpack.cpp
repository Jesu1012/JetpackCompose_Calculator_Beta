#include <jni.h>
#include <string>
#include <iostream>
#include <array>
#include <map>
#include <stack>
#include <functional>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testjetpack_MainActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++ in App.kt";
    return env->NewStringUTF(hello.c_str());
}


static std::string menu() {
    std::string menuString = "";
    menuString += "\n|          ||   ||   |";
    menuString += "\n|   exit   || % || / |";
    menuString += "\n|          ||   ||   |";

    menuString += "\n|    ||    ||   ||   |";
    menuString += "\n| 7  || 8  || 9 || * |";
    menuString += "\n|    ||    ||   ||   |";

    menuString += "\n|    ||    ||   ||   |";
    menuString += "\n| 4  || 5  || 6 || - |";
    menuString += "\n|    ||    ||   ||   |";

    menuString += "\n|    ||    ||   ||   |";
    menuString += "\n| 1  || 2  || 3 || + |";
    menuString += "\n|    ||    ||   ||   |";

    menuString += "\n|          ||   ||   |";
    menuString += "\n| 0        || , || = |";
    menuString += "\n|          ||   ||   |";

    menuString += "\n";

    return menuString;
} //No se utiliza

static std::array<char, 7> inputCharAvalible{ {'%', '/', '*','-','+','=',','}};

class NumberO {
    std::string numberCurrent;
    std::size_t hasunico;

public:


    NumberO(std::string numberModify){
        numberCurrent = numberModify;
        hasunico = std::hash<std::string>{}(numberModify) % 10000;
        ajustarHash();
    }

    NumberO() {}


    void ajustarHash() {
        // Si el hash tiene menos de 4 dígitos, lo ajustamos
        while (hasunico < 1000) {
            hasunico *= 10;
        }
    }

    std::size_t obtenerHashUnico() const {
        return hasunico;
    }

    std::string obtenerNumberCurrent() const {
        return numberCurrent;
    }

};

std::map<size_t, NumberO> doubleMap;

class Expression {
    std::string expressionCurrent;
    std::string expressionConvertInfija;
    std::string expressionConvertPostfija;
    int expressionConvertCalculada;
public:

    bool IsContainsSpace() {
        std::string expressionModify;
        for (char& c : expressionCurrent) {
            if (c == ' ') {
                continue;
            }
            expressionModify += c;
        }
        expressionCurrent = expressionModify;
        return 1;
    }

    bool ErrorSyntax() {
        char lastChar = '\0';


        if (!expressionCurrent.empty()) {
            char firstChar = expressionCurrent.front();
            char lastChar = expressionCurrent.back();
            if (std::find(inputCharAvalible.begin(), inputCharAvalible.end(), firstChar) != inputCharAvalible.end()
                || std::find(inputCharAvalible.begin(), inputCharAvalible.end(), lastChar) != inputCharAvalible.end()
                    ) {
                return true;
            }
        }

        for (char j : expressionCurrent) {
            if (!isdigit(j)) {
                bool validChar = false;
                for (char k : inputCharAvalible) {
                    if (j == k) {

                        if (lastChar != '\0'
                            && std::find(inputCharAvalible.begin(), inputCharAvalible.end(), lastChar) != inputCharAvalible.end()
                                ) {
                            return true;
                        }
                        validChar = true;
                        break;
                    }
                }
                if (!validChar) {
                    return true;
                }
            }
            lastChar = j;
        }
        return false;
    }


    void SetExpressionData(std::string expressionModify) {
        expressionCurrent = expressionModify;
    }

    void AddMap() {
        std::cout << "Expression in Method AddMap: " << expressionCurrent << std::endl;
        std::string fbs = "";
        std::string xls = "";
        int value = 0;

        for (char c : expressionCurrent) {
            if (std::find(inputCharAvalible.begin(), inputCharAvalible.end(), c) != inputCharAvalible.end()) {
                if (!fbs.empty()) {
                    value += 1;
                    doubleMap[value] = NumberO(fbs);

                    xls += std::to_string(doubleMap[value].obtenerHashUnico());
                    xls += c;
                    fbs.clear();
                }
            }
            else {
                fbs += c;
            }
        }
        value += 1;
        if (!fbs.empty()) {
            doubleMap[value] = NumberO(fbs);
            xls += std::to_string(doubleMap[value].obtenerHashUnico());

        }
        expressionConvertInfija = xls;
        std::cout << "(Method AddMap) conteo Expression Infija Convert: " << expressionConvertInfija << std::endl;

        expressionConvertPostfija = convertir();
        std::cout << "(Method AddMap) conteo Expression Posfija Convert: " << expressionConvertPostfija << std::endl;

        expressionConvertCalculada = evaluar();
        std::cout << "(Method AddMap) conteo Expression Calculada Convert: " << expressionConvertCalculada << " >>>>>>"  << std::endl;

    }

    bool esOperando(char c) {
        return (c >= '0' && c <= '9');
    }

    bool esOperador(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    int aplicarOperador(int operand1, int operand2, char operador) {
        switch (operador) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                }
                else {
                    // Manejo de división por cero
                    throw std::runtime_error("Error: división por cero");
                }
            default:
                // Manejo de operador desconocido
                throw std::invalid_argument("Error: operador desconocido");
        }
    }

    std::string convertir() {
        std::string expresionPostfija;
        std::stack<char> pilaOperadores;

        for (char c : expressionConvertInfija) {
            if (esOperando(c)) {
                expresionPostfija += c;
            }
            else if (esOperador(c)) {
                while (!pilaOperadores.empty() && precedencia(pilaOperadores.top()) >= precedencia(c)) {
                    expresionPostfija += pilaOperadores.top();
                    pilaOperadores.pop();
                }
                pilaOperadores.push(c);
            }
        }

        while (!pilaOperadores.empty()) {
            expresionPostfija += pilaOperadores.top();
            pilaOperadores.pop();
        }

        return expresionPostfija;
    }

    int evaluar() {
        std::stack<int> pilaOperandos;
        int numero = 0;
        int digitosContados = 0;
        int num = 0;
        for (char c : expressionConvertPostfija) {
            if (esOperando(c)) {
                // Convertir el carácter a un dígito numérico y agregarlo al número
                numero = numero * 10 + (c - '0');
                digitosContados++;

                // Si hemos acumulado 4 dígitos, agregar el número a la pila de operandos
                if (digitosContados == 4) {
                    num = 0;
                    std::cout << "(Method AddMap) Num: " << numero << std::endl;
                    for (size_t i = 1; i < doubleMap.size() + 1; i++) {
                        if (doubleMap[i].obtenerHashUnico() == numero)
                        {
                            num = std::stoi(doubleMap[i].obtenerNumberCurrent());
                        }


                    }
                    pilaOperandos.push(num);
                    numero = 0;
                    digitosContados = 0;
                }
            }
            else if (esOperador(c)) {
                num = 0;
                for (size_t i = 1; i < doubleMap.size() + 1; i++) {
                    if (doubleMap[i].obtenerHashUnico() == numero)
                    {
                        num = std::stoi(doubleMap[i].obtenerNumberCurrent());
                        pilaOperandos.push(num);
                    }


                }

                // Reiniciar el número y el contador de dígitos para el próximo operando
                numero = 0;
                digitosContados = 0;

                // Realizar las operaciones cuando se encuentre un operador
                int operand2 = pilaOperandos.top();
                pilaOperandos.pop();
                int operand1 = pilaOperandos.top();
                pilaOperandos.pop();
                int resultado = aplicarOperador(operand1, operand2, c);
                pilaOperandos.push(resultado);
            }
        }

        return pilaOperandos.top();
    }



    std::string GetExpression() {
        return expressionCurrent;
    }
    std::string GetExpressionEvaluate() {
        return std::to_string(expressionConvertCalculada);
    }
    std::string GetExpressionPosfija() {
        return expressionConvertPostfija;
    }
    std::string GetExpressionInfija() {
        return expressionConvertInfija;
    }



};

int main() {
    std::string expression;
    std::string continueV;
    Expression inputExpression;
    while (true)
    {
        system("cls");
        std::cout << menu() << std::endl;
        std::cout << "Enter: ";
        std::getline(std::cin, expression);

        if (expression == "exit")
        {
            return 0;
        }
        else {
            inputExpression.SetExpressionData(expression);

            inputExpression.IsContainsSpace();

            if (!inputExpression.ErrorSyntax())
            {

                inputExpression.AddMap();

            }
            else {
                std::cout << "Error Syntax" << std::endl;
            }



            std::cout << "\n\tConteo lista de numeros: " <<doubleMap.size()<< std::endl;

            for (size_t i = 1; i < doubleMap.size() + 1; i++) {

                std::cout << "Key: " << i << ", Value: " << doubleMap[i].obtenerNumberCurrent() << ", Hascode: " << doubleMap[i].obtenerHashUnico() << std::endl;

            }

            std::cout << "\n\tPress Enter for Continue or write exit.. ";
            std::getline(std::cin, continueV);
            doubleMap.clear();
            if (continueV == "exit")
            {
                return 0;
            }
        }
    }

    return 0;
}

static Expression expression;

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_testjetpack_Conection_SentDataAndChecking(JNIEnv *env, jobject thiz, jstring param) {
    const char* utfChars = env->GetStringUTFChars(param, NULL);
    expression.SetExpressionData(utfChars);
    bool result = expression.ErrorSyntax();
    env->ReleaseStringUTFChars(param, utfChars);
    return result;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testjetpack_Conection_ReceiveData(JNIEnv *env, jobject thiz) {

    expression.AddMap();
    const char* result = expression.GetExpressionEvaluate().c_str();
    jstring jResult = env->NewStringUTF(result);
    return jResult;
}
