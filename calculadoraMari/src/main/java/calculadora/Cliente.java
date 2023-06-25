package calculadora;

import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class Cliente {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/calculadora?wsdl");
            QName qname = new QName("http://calculadora/", "CalculadoraResourceService");
            QName qnamedois = new QName("http://calculadora/", "CalculadoraResourcePort");
            Service service = Service.create(url, qname);
            CalculadoraWebService calculadora = service.getPort(qnamedois, CalculadoraWebService.class);

            while (true) {
                String menu = JOptionPane.showInputDialog("Calculadora\n\n"
                        + "Digite (1)..Somar\n"
                        + "Digite (2)..Subtrair\n"
                        + "Digite (3)..Multiplicar\n"
                        + "Digite (4)..Dividir\n"
                        + "Digite (5)..Sair");

                if (menu.equals("5")) {
                    break;
                }
                int a, b = 0;
                a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
                b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

                switch (menu) {
                    case "1":
                        int soma = calculadora.add(a, b);
                        JOptionPane.showMessageDialog(null, "Resultado: " + soma);
                        break;
                    case "2":
                        int subtracao = calculadora.sub(a, b);
                        JOptionPane.showMessageDialog(null, "Resultado: " + subtracao);
                        break;
                    case "3":
                        int multiplicacao = calculadora.mul(a, b);
                        JOptionPane.showMessageDialog(null, "Resultado: " + multiplicacao);
                        break;
                    case "4":
                        double divisao = calculadora.div(a, b);
                        JOptionPane.showMessageDialog(null, "Resultado: " + divisao);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                        continue;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a requisição: " + e.getMessage());
            System.out.println(e);
        }
    }
}
