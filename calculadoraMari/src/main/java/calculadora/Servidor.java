package calculadora;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Configuração do RMI
            Calculadora calculadoraRMI = new Rmi();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculadora", calculadoraRMI);

            // Configuração do WebService
            String address = "http://localhost:8080/calculadora";
            Endpoint.publish(address, new CalculadoraResource());

            JOptionPane.showMessageDialog(null, "Servidor iniciado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar o servidor: " + e.getMessage());
            System.out.println(e);
        }
    }
}
