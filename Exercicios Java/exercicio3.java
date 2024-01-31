public class ContaBancariaSimplificada {
    private String nomeDoCorrentista;
    private double saldo;
    private boolean contaEspecial;

    public ContaBancariaSimplificada() {
    }

    public void abreConta(String nome, double saldoInicial, boolean especial) {
        this.nomeDoCorrentista = nome;
        this.saldo = saldoInicial;
        this.contaEspecial = especial;
    }

    public void abreContaSimples(String nome) {
        this.nomeDoCorrentista = nome;
        this.saldo = 0;
        this.contaEspecial = false;
    }

    public void deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Erro: Valor de depósito inválido.");
        }
    }

    public void retira(double valor) {
        if (valor > 0) {
            if (contaEspecial || (saldo - valor >= 0)) {
                this.saldo -= valor;
                System.out.println("Retirada de R$" + valor + " realizada com sucesso.");
            } else {
                System.out.println("Erro: Saldo insuficiente para a retirada.");
            }
        } else {
            System.out.println("Erro: Valor de retirada inválido.");
        }
    }

    public void transfere(ContaBancariaSimplificada destinatario, double valor) {
        if (valor > 0) {
            if (contaEspecial || (saldo - valor >= 0)) {
                this.saldo -= valor;
                destinatario.deposita(valor);
                System.out.println("Transferência de R$" + valor + " realizada com sucesso para " +
                        destinatario.getNomeDoCorrentista() + ".");
            } else {
                System.out.println("Erro: Saldo insuficiente para a transferência.");
            }
        } else {
            System.out.println("Erro: Valor de transferência inválido.");
        }
    }

    public void mostraDados() {
        String statusConta = contaEspecial ? "Sim" : "Não";
        System.out.println("Conta:\n\tNome do Correntista: " + this.nomeDoCorrentista +
                "\n\tSaldo: R$" + this.saldo + "\n\tConta Especial? " + statusConta);
    }

    public boolean isContaEspecial() {
        return contaEspecial;
    }

    public String getNomeDoCorrentista() {
        return nomeDoCorrentista;
    }

    public double getSaldo() {
        return saldo;
    }
}
