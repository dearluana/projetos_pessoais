import javax.swing.JOptionPane;

public class CalculadoraPrecoVeiculo {

    public static void main(String[] args) {
        try {
            double precoCusto = obterDoubleDoUsuario("Digite o preço de custo do veículo");
            double valorOpcional = obterDoubleDoUsuario("Digite o valor do opcional desejado conforme a tabela da importadora");

            double precoFinal = calcularPrecoFinal(precoCusto, valorOpcional);

            JOptionPane.showMessageDialog(null, "Preço Final do Veículo é: " + precoFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Certifique-se de inserir um número válido.");
        }
    }

    private static double obterDoubleDoUsuario(String mensagem) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Insira um número válido.");
            }
        }
    }

    private static double calcularPrecoFinal(double precoCusto, double valorOpcional) {
        return precoCusto + valorOpcional;
    }
}
