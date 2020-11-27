import java.util.Calendar;

public class Emprestimo {
    int id;
    int idCliente;
    int idLivro;
    String dataEmprestimo;
    String dataRetorno;

    Emprestimo(int id, int idCliente, int idLivro, String dataEmprestimo, String dataRetorno) {
        this.id = id;
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetorno = dataRetorno;
    }

}