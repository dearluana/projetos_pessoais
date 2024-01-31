import java.util.InputMismatchException;

class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

enum Estatuto {
    ALUNO_ESPECIAL,
    TEMPO_PARCIAL,
    TEMPO_INTEGRAL
}

class Estudante extends Pessoa {
    private Estatuto estatuto;
    private double media;

    public Estudante(String nome, Estatuto estatuto, double media) {
        super(nome);
        this.estatuto = estatuto;
        this.media = media;
    }

    public Estatuto getEstatuto() {
        return estatuto;
    }

    public void setEstatuto(Estatuto estatuto) {
        this.estatuto = estatuto;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        if (media >= 0 && media <= 10) {
            this.media = media;
        } else {
            throw new IllegalArgumentException("A média deve estar no intervalo de 0 a 10.");
        }
    }
}

enum CategoriaEmpregado {
    DOCENTE,
    DISCENTE
}

enum CargoDocente {
    DEMONSTRADOR,
    MONITOR,
    PROFESSOR
}

enum CargoDiscente {
    ESCRITORIO,
    MANUTENCAO
}

class Empregado extends Pessoa {
    private CategoriaEmpregado categoria;
    private double salario;

    public Empregado(String nome, CategoriaEmpregado categoria, double salario) {
        super(nome);
        this.categoria = categoria;
        this.salario = salario;
    }

    public CategoriaEmpregado getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEmpregado categoria) {
        this.categoria = categoria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            throw new IllegalArgumentException("O salário não pode ser negativo.");
        }
    }
}

class Docente extends Empregado {
    private CargoDocente cargo;

    public Docente(String nome, CargoDocente cargo, double salario) {
        super(nome, CategoriaEmpregado.DOCENTE, salario);
        this.cargo = cargo;
    }

    public CargoDocente getCargo() {
        return cargo;
    }

    public void setCargo(CargoDocente cargo) {
        this.cargo = cargo;
    }
}

class Discente extends Empregado {
    private CargoDiscente cargo;

    public Discente(String nome, CargoDiscente cargo, double salario) {
        super(nome, CategoriaEmpregado.DISCENTE, salario);
        this.cargo = cargo;
    }

    public CargoDiscente getCargo() {
        return cargo;
    }

    public void setCargo(CargoDiscente cargo) {
        this.cargo = cargo;
    }
}

public class Universidade {
    public static void main(String[] args) {
        try {
            Estudante estudante = new Estudante("João", Estatuto.TEMPO_INTEGRAL, 8.5);
            estudante.setMedia(9.0);

            Empregado empregado = new Empregado("Maria", CategoriaEmpregado.DOCENTE, 5000.0);
            empregado.setSalario(5500.0);

            Docente docente = new Docente("Carlos", CargoDocente.PROFESSOR, 6000.0);
            docente.setSalario(6500.0);

            Discente discente = new Discente("Ana", CargoDiscente.ESCRITORIO, 4000.0);
            discente.setSalario(4500.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada: Certifique-se de inserir um valor numérico quando necessário.");
        }
    }
}
