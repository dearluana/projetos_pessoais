import java.text.DateFormatSymbols;
import java.util.InputMismatchException;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean validarData(int dia, int mes, int ano) {
        if (ano < 1) {
            return false;
        }

        if (mes < 1 || mes > 12) {
            return false;
        }

        int[] diasPorMes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int maxDias = diasPorMes[mes];

        // Verificar se o ano é bissexto
        if (mes == 2 && anoBissexto(ano)) {
            maxDias = 29;
        }

        return dia >= 1 && dia <= maxDias;
    }

    // Método para verificar se o ano é bissexto
    private boolean anoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%02d/%s/%d", dia, obterNomeMes(), ano);
    }

    // Método para obter o nome do mês
    private String obterNomeMes() {
        return new DateFormatSymbols().getMonths()[mes - 1];
    }

    public static void main(String[] args) {
        try {
            Data data = new Data();
            data.setDia(5);
            data.setMes(3);
            data.setAno(2015);

            if (data.validarData(data.getDia(), data.getMes(), data.getAno())) {
                System.out.println("Data válida: " + data);
            } else {
                System.out.println("Data inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir um valor numérico quando necessário.");
        }
    }
}
