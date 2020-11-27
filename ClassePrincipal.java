import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class ClassePrincipal {



    public static void main(String[] args) throws IOException {

        HashMap<Integer, Livro> livros = new HashMap<>();
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        HashMap<Integer, Emprestimo> emprestimos = new HashMap<>();

        ClasseMetodos.carregaLivros(livros);
        ClasseMetodos.carregaClientes(clientes);
        ClasseMetodos.carregaEmprestimos(emprestimos);

        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Livros\n2 - Clientes\n3 - Empréstimos\n9 - Fim\n", "Biblioteca da Dona Lúcia",JOptionPane.INFORMATION_MESSAGE));
            switch (opc) {
                case 1 -> menuLivros(livros);
                case 2 -> menuClientes(clientes);
                case 3 -> menuEmprestimos(livros, clientes, emprestimos);
                case 9 -> {
                    ClasseMetodos.escreveLivros(livros);
                    ClasseMetodos.escreveClientes(clientes);
                }
                default -> JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        } while (opc != 9);
    }

    public static void menuLivros(HashMap<Integer, Livro> livros) throws IOException {
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Livro\n2 - Pesquisar Livro\n3 - Editar Livro\n4 - Deletar Livro\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc) {
                case 1 -> ClasseMetodos.criaLivro(livros);
                case 2 -> ClasseMetodos.pesquisaLivro(livros);
                case 3 -> ClasseMetodos.editaLivro(livros);
                case 4 -> ClasseMetodos.deletaLivro(livros);
                case 9 -> ClasseMetodos.escreveLivros(livros);
                default -> JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while (opc != 9);

    }

    public static void menuClientes(HashMap<Integer, Cliente> clientes) throws IOException {
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Cliente\n2 - Pesquisar Cliente\n3 - Editar Cliente\n4 - Deletar Cliente\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc) {
                case 1 -> ClasseMetodos.criaCliente(clientes);
                case 2 -> ClasseMetodos.pesquisaCliente(clientes);
                case 3 -> ClasseMetodos.editaCliente(clientes);
                case 4 -> ClasseMetodos.deletaCliente(clientes);
                case 9 -> ClasseMetodos.escreveClientes(clientes);
                default -> JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while (opc != 9);
    }

    public static void menuEmprestimos(HashMap<Integer, Livro> livros, HashMap<Integer, Cliente> clientes, HashMap<Integer, Emprestimo> emprestimos) throws IOException {
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Empréstimo\n2 - Consultar Empréstimo\n3 - Nova Devolução\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc) {
                case 1 -> ClasseMetodos.novoEmprestimo(livros, clientes, emprestimos);
                case 2 -> ClasseMetodos.consultaEmprestimo(livros, clientes, emprestimos);
                case 3 -> ClasseMetodos.devolucao(livros, clientes, emprestimos);
                case 9 -> ClasseMetodos.escreveEmprestimos(emprestimos);
                default -> JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while (opc != 9);
    }
}
