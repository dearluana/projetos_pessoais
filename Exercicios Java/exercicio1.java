import javax.swing.JOptionPane;

public class Exercicio1 {
    public static void main(String[] args) {
        try {
            int n1 = obterIdade("Digite a idade da primeira pessoa: ");
            int n2 = obterIdade("Digite a idade da segunda pessoa: ");
            int n3 = obterIdade("Digite a idade da terceira pessoa: ");
            int n4 = obterIdade("Digite a idade da quarta pessoa: ");
            int n5 = obterIdade("Digite a idade da quinta pessoa: ");

            int maiorIdade = encontrarMaiorIdade(n1, n2, n3, n4, n5);
            JOptionPane.showMessageDialog(null, "A pessoa com a maior idade tem " + maiorIdade + " anos.");

            int menorIdade = encontrarMenorIdade(n1, n2, n3, n4, n5);
            JOptionPane.showMessageDialog(null, "A pessoa com a menor idade tem " + menorIdade + " anos.");

            if (verificarIdadesIguais(n1, n2, n3, n4, n5)) {
                JOptionPane.showMessageDialog(null, "ERRO: Duas ou mais pessoas não podem ter a mesma idade nesta aplicação!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERRO: Entrada inválida. Certifique-se de inserir uma idade válida.");
        }
    }

    private static int obterIdade(String mensagem) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensagem);
                if (input == null) {
                    System.exit(0); 
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERRO: Por favor, insira uma idade válida.");
            }
        }
    }

    private static int encontrarMaiorIdade(int... idades) {
        int maior = Integer.MIN_VALUE;
        for (int idade : idades) {
            if (idade > maior) {
                maior = idade;
            }
        }
        return maior;
    }

    private static int encontrarMenorIdade(int... idades) {
        int menor = Integer.MAX_VALUE;
        for (int idade : idades) {
            if (idade < menor) {
                menor = idade;
            }
        }
        return menor;
    }

    private static boolean verificarIdadesIguais(int... idades) {
        for (int i = 0; i < idades.length - 1; i++) {
            for (int j = i + 1; j < idades.length; j++) {
                if (idades[i] == idades[j]) {
                    return true; 
                }
            }
        }
        return false; 
    }
}

