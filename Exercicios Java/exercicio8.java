import java.util.InputMismatchException;
import java.util.Scanner;

class Caneta {
    private String marca;
    private String cor;
    private double tamanho;

     
    public Caneta(String marca, String cor, double tamanho) {
        this.marca = marca;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Caneta [marca=" + marca + ", cor=" + cor + ", tamanho=" + tamanho + "]";
    }
}

class CanetaTesteVetor {
    private static final int MAX_CANETAS = 50;
    private Caneta[] vetorCanetas;
    private int quantidadeCanetas;

    public CanetaTesteVetor() {
        this.vetorCanetas = new Caneta[MAX_CANETAS];
        this.quantidadeCanetas = 0;
    }

    public void cadastrarCaneta(Caneta caneta) {
        if (quantidadeCanetas < MAX_CANETAS) {
            vetorCanetas[quantidadeCanetas++] = caneta;
            System.out.println("Caneta cadastrada com sucesso!");
        } else {
            System.out.println("Limite máximo de canetas atingido. Não foi possível cadastrar.");
        }
    }

    public void exibirTodasCanetas() {
        System.out.println("\nTodas as Canetas Cadastradas:");
        for (int i = 0; i < quantidadeCanetas; i++) {
            System.out.println(vetorCanetas[i]);
        }
    }

    public void exibirQuantidadeCanetas() {
        System.out.println("\nQuantidade de Canetas Cadastradas: " + quantidadeCanetas);
    }

    public void consultarQuantidadePorCor(String cor) {
        int quantidadePorCor = 0;
        for (int i = 0; i < quantidadeCanetas; i++) {
            if (vetorCanetas[i].getCor().equalsIgnoreCase(cor)) {
                quantidadePorCor++;
            }
        }
        System.out.println("Quantidade de Canetas da cor '" + cor + "': " + quantidadePorCor);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Caneta");
            System.out.println("2 - Exibir Todas as Canetas");
            System.out.println("3 - Exibir Quantidade de Canetas Cadastradas");
            System.out.println("4 - Consultar Quantidade de Canetas por Cor");
            System.out.println("0 - Sair");

            try {
                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        cadastrarCaneta(criarCaneta(scanner));
                        break;
                    case 2:
                        exibirTodasCanetas();
                        break;
                    case 3:
                        exibirQuantidadeCanetas();
                        break;
                    case 4:
                        System.out.print("Digite a cor para consultar: ");
                        String corConsulta = scanner.nextLine();
                        consultarQuantidadePorCor(corConsulta);
                        break;
                    case 0:
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de inserir um valor numérico quando necessário.");
                scanner.nextLine(); 
                opcao = -1; // Forçar nova iteração do loop
            }
        } while (opcao != 0);

        scanner.close();
    }

    private Caneta criarCaneta(Scanner scanner) {
        System.out.print("Digite a marca da caneta: ");
        String marca = scanner.nextLine();
        System.out.print("Digite a cor da caneta: ");
        String cor = scanner.nextLine();
        System.out.print("Digite o tamanho da caneta: ");
        double tamanho = scanner.nextDouble();
        scanner.nextLine(); 

        return new Caneta(marca, cor, tamanho);
    }
}

public class Main {
    public static void main(String[] args) {
        CanetaTesteVetor programa = new CanetaTesteVetor();
        programa.menu();
    }
}
