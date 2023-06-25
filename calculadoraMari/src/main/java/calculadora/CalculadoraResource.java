package calculadora;

import javax.jws.WebService;

@WebService(endpointInterface = "calculadora.CalculadoraWebService")
public class CalculadoraResource implements CalculadoraWebService {
     int param1;
     int param2;

    @Override
    public int add(int a, int b) {
        param1 = a;
        param2 = b;
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        param1 = a;
        param2 = b;
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        param1 = a;
        param2 = b;
        return a * b;
    }

    @Override
    public double div(int a, int b) {
        param1 = a;
        param2 = b;
        return (double) a / b;
    }

    public void resetParameters() {
        param1 = 0;
        param2 = 0;
    }
}
