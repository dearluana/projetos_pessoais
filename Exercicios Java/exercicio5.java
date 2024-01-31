class VeiculoAVenda {
    private String tipo;
    private int ano;
    private double precoDeVenda;

    public VeiculoAVenda(String tipo, int ano, double precoDeVenda) {
        this.tipo = tipo;
        this.ano = ano;
        this.precoDeVenda = precoDeVenda;
    }
    public String getTipo() {
        return tipo;
    }

    public int getAno() {
        return ano;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }
}

class AutomovelAVenda extends VeiculoAVenda {
    public AutomovelAVenda(int ano, double precoDeVenda) {
        super("Automóvel", ano, precoDeVenda);
    }
}

class MotocicletaAVenda extends VeiculoAVenda {
    public MotocicletaAVenda(int ano, double precoDeVenda) {
        super("Motocicleta", ano, precoDeVenda);
    }
}

public class ProgramaVeiculos {
    public static void main(String[] args) {
        VeiculoAVenda veiculo1 = new VeiculoAVenda("Veículo Genérico", 2022, 30000.0);
        AutomovelAVenda automovel1 = new AutomovelAVenda(2021, 50000.0);
        MotocicletaAVenda motocicleta1 = new MotocicletaAVenda(2020, 15000.0);

        exibirInformacoes(veiculo1);
        exibirInformacoes(automovel1);
        exibirInformacoes(motocicleta1);
    }

    public static void exibirInformacoes(VeiculoAVenda veiculo) {
        System.out.println("Tipo: " + veiculo.getTipo());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Preço de Venda: R$" + veiculo.getPrecoDeVenda());
        System.out.println("-----");
    }
}
