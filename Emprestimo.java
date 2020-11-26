import java.util.Calendar;

public class Emprestimo {
    int id;
    String nomeCliente;
    String nomeLivro;
    Calendar dataEmprestimo;
    Calendar dataRetorno;

    public Emprestimo(int id, String nomeCliente, String nomeLivro, Calendar dataEmprestimo, Calendar dataRetorno) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeLivro = nomeLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetorno = dataRetorno;
    }
}