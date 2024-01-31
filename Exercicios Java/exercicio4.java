import java.util.InputMismatchException;
import java.util.Scanner;

public class VerificaAprovacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            double nota1 = obterNota(scanner, "Digite a primeira nota: ");
            double nota2 = obterNota(scanner, "Digite a segunda nota: ");
            double nota3 = obterNota(scanner, "Digite a terceira nota: ");
            double nota4 = obterNota(scanner, "Digite a quarta nota: ");

            double media = (nota1 + nota2 + nota3 + nota4) / 4;

            if (validarNotas(nota1, nota2, nota3, nota4)) {
                if (media >= 7.0) {
                    System.out.println("Parabéns! Você foi aprovado. Média: " + media);
                } else {
                    double notaRecuperacao = obterNota(scanner, "Digite a nota da recuperação: ");

                    if (validarNotaRecuperacao(notaRecuperacao)) {
                        double novaMedia = (media + notaRecuperacao) / 2;

                        if (novaMedia >= 7.0) {
                            System.out.println("Parabéns! Você foi aprovado na recuperação. Nova média: " + novaMedia);
                        } else {
                            System.out.println("Infelizmente, você não foi aprovado. Nova média: " + novaMedia);
                        }
                    } else {
                        System.out.println("Erro: A nota de recuperação deve estar entre 0 e 10.");
                    }
                }
            } else {
                System.out.println("Erro: As notas devem estar entre 0 e 10.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir um número válido.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static double obterNota(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double nota = scanner.nextDouble();
                if (validarNota(nota)) {
                    return nota;
                } else {
                    System.out.println("Erro: A nota deve estar entre 0 e 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de inserir um número válido.");
                scanner.nextLine(); 
            }
        }
    }

    private static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }

    private static boolean validarNotaRecuperacao(double notaRecuperacao) {
        return notaRecuperacao >= 0 && notaRecuperacao <= 10;
    }

    private static boolean validarNotas(double... notas) {
        for (double nota : notas) {
            if (!validarNota(nota)) {
                return false;
            }
        }
        return true;
    }
}
