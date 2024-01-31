import java.util.InputMismatchException;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
    }
}

class LivroLivraria extends Livro {
    private double preco;

    public LivroLivraria(String titulo, String autor, double preco) {
        super(titulo, autor);
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Preço: R$" + preco);
    }
}

class LivroBiblioteca extends Livro {
    private boolean disponivel;

    public LivroBiblioteca(String titulo, String autor) {
        super(titulo, autor);
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Disponível na biblioteca: " + (disponivel ? "Sim" : "Não"));
    }

    public void emprestarLivro() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }

    public void devolverLivro() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Este livro já está disponível na biblioteca.");
        }
    }
}

public class ProgramaLivros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            LivroLivraria livroLivraria = criarLivroLivraria(scanner);
            LivroBiblioteca livroBiblioteca = criarLivroBiblioteca(scanner);

            System.out.println("\nInformações do Livro na Livraria:");
            livroLivraria.exibirInformacoes();

            System.out.println("\nInformações do Livro na Biblioteca:");
            livroBiblioteca.exibirInformacoes();

            System.out.println("\nAções na Biblioteca:");
            livroBiblioteca.emprestarLivro();
            livroBiblioteca.devolverLivro();
            livroBiblioteca.devolverLivro();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir um valor numérico quando necessário.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static LivroLivraria criarLivroLivraria(Scanner scanner) {
        System.out.println("Digite as informações do livro na livraria:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Preço: R$");

        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        return new LivroLivraria(titulo, autor, preco);
    }

    private static LivroBiblioteca criarLivroBiblioteca(Scanner scanner) {
        System.out.println("\nDigite as informações do livro na biblioteca:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");

        return new LivroBiblioteca(titulo, scanner.nextLine());
    }
}
