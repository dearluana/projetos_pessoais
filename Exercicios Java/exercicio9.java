import java.util.InputMismatchException;
import java.util.Scanner;

class Lampada {
    private String tipo;
    private int voltagem;
    private String cor;
    private String marca;
    private double preco;
    private double potencia;
    private boolean status; // true se acesa, false se apagada

    public Lampada(String tipo, int voltagem, String cor, String marca, double preco, double potencia) {
        this.tipo = tipo;
        this.voltagem = voltagem;
        this.cor = cor;
        this.marca = marca;
        this.preco = preco;
        this.potencia = potencia;
        this.status = false; 
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public boolean isAcesa() {
        return status;
    }

    public void ascender() {
        if (!status) {
            System.out.println("Lâmpada acesa.");
            status = true;
        } else {
            System.out.println("Lâmpada já está acesa.");
        }
    }

    public void apagar() {
        if (status) {
            System.out.println("Lâmpada apagada.");
            status = false;
        } else {
            System.out.println("Lâmpada já está apagada.");
        }
    }

    @Override
    public String toString() {
        return "Lampada [tipo=" + tipo + ", voltagem=" + voltagem + ", cor=" + cor + ", marca=" + marca + ", preco="
                + preco + ", potencia=" + potencia + ", status=" + status + "]";
    }
}

class LampadaTesteVetor {
    private static final int MAX_LAMPADAS = 30;
    private Lampada[] vetorLampadas;
    private int quantidadeLampadas;

    public LampadaTesteVetor() {
        this.vetorLampadas = new Lampada[MAX_LAMPADAS];
        this.quantidadeLampadas = 0;
    }

    public void cadastrarLampada(Lampada lampada) {
        if (quantidadeLampadas < MAX_LAMPADAS) {
            vetorLampadas[quantidadeLampadas++] = lampada;
            System.out.println("Lâmpada cadastrada com sucesso!");
        } else {
            System.out.println("Limite máximo de lâmpadas atingido. Não foi possível cadastrar.");
        }
    }

    public void exibirTodasLampadas() {
        System.out.println("\nTodas as Lâmpadas Cadastradas:");
        for (int i = 0; i < quantidadeLampadas; i++) {
            System.out.println(vetorLampadas[i]);
        }
    }

    public void exibirQuantidadeLampadas() {
        System.out.println("\nQuantidade de Lâmpadas Cadastradas: " + quantidadeLampadas);
    }

    public void consultarQuantidadePorPotencia(double potenciaConsulta) {
        int quantidadePorPotencia = 0;
        for (int i = 0; i < quantidadeLampadas; i++) {
            if (vetorLampadas[i].getPotencia() == potenciaConsulta) {
                quantidadePorPotencia++;
            }
        }
        System.out.println("Quantidade de Lâmpadas de potência " + potenciaConsulta + ": " + quantidadePorPotencia);
    }

    public void exibirLampadasComPrecoMenorQueMedia() {
        double precoTotal = 0;
        for (int i = 0; i < quantidadeLampadas; i++) {
            precoTotal += vetorLampadas[i].getPreco();
        }
        double precoMedio = quantidadeLampadas > 0 ? precoTotal / quantidadeLampadas : 0;

        System.out.println("\nLâmpadas com preço menor que o preço médio:");
        for (int i = 0; i < quantidadeLampadas; i++) {
            if (vetorLampadas[i].getPreco() < precoMedio) {
                System.out.println(vetorLampadas[i]);
            }
        }
    }

    public void exibirQuantidadeAcesasApagadas() {
        int quantidadeAcesas = 0;
        int quantidadeApagadas = 0;
        for (int i = 0; i < quantidadeLampadas; i++) {
            if (vetorLampadas[i].isAcesa()) {
                quantidadeAcesas++;
            } else {
                quantidadeApagadas++;
            }
        }
        System.out.println("\nQuantidade de Lâmpadas Acesas: " + quantidadeAcesas);
        System.out.println("Quantidade de Lâmpadas Apagadas: " + quantidadeApagadas);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Lâmpada");
            System.out.println("2 - Exibir Todas as Lâmpadas");
            System.out.println("3 - Exibir Quantidade de Lâmpadas Cadastradas");
            System.out.println("4 - Consultar Quantidade de Lâmpadas por Potência");
            System.out.println("5 - Exibir Dados das Lâmpadas com Preço Menor que o Preço Médio");
            System.out.println("6 - Exibir Quantidade de Lâmpadas Acesas e Apagadas");
            System.out.println("0 - Sair");

            try {
                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        cadastrarLampada(criarLampada(scanner));
                        break;
                    case 2:
                        exibirTodasLampadas();
                        break;
                    case 3:
                        exibirQuantidadeLampadas();
                        break;
                    case 4:
                        System.out.print("Digite a potência para consultar: ");
                        double potenciaConsulta = scanner.nextDouble();
                        scanner.nextLine(); 
                        consultarQuantidadePorPotencia(potenciaConsulta);
                        break;
                    case 5:
                        exibirLampadasComPrecoMenorQueMedia();
                        break;
                    case 6:
                        exibirQuantidadeAcesasApagadas();
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

    private Lampada criarLampada(Scanner scanner) {
        System.out.print("Digite o tipo da lâmpada: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite a voltagem da lâmpada: ");
        int voltagem = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a cor da lâmpada: ");
        String cor = scanner.nextLine();
        System.out.print("Digite a marca da lâmpada: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o preço da lâmpada: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Digite a potência da lâmpada: ");
        double potencia = scanner.nextDouble();
        scanner.nextLine(); 

        return new Lampada(tipo, voltagem, cor, marca, preco, potencia);
    }
}

public class Main {
    public static void main(String[] args) {
        LampadaTesteVetor programa = new LampadaTesteVetor();
        programa.menu();
    }
}
