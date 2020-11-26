import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class ClassePrincipal {



    public static void main(String[] args) throws IOException {

        HashMap<Integer, Livro> livros = new HashMap<>();
        HashMap<Integer, Cliente> clientes = new HashMap<>();

        ClasseMetodos.carregaLivros(livros);
        ClasseMetodos.carregaClientes(clientes);

        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Livros\n2 - Clientes\n3 - Empréstimos\n9 - Fim\n", "Biblioteca da Dona Lúcia",JOptionPane.INFORMATION_MESSAGE));
            switch (opc) {
                case 1:
                    menuLivros(livros);
                    break;
                case 2:
                    menuClientes(clientes);
                    break;
                case 3:
                    menuEmprestimos();
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        } while (opc != 9);
    }

    public static void menuLivros(HashMap<Integer, Livro> livros) throws IOException {
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Livro\n2 - Pesquisar Livro\n3 - Editar Livro\n4 - Deletar Livro\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc){
                case 1:
                    ClasseMetodos.criaLivro(livros);
                    break;
                case 2:
                    ClasseMetodos.pesquisaLivro(livros);
                    break;
                case 3:
                    ClasseMetodos.editaLivro(livros);
                    break;
                case 4:
                    ClasseMetodos.deletaLivro(livros);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while (opc != 9);

    }

    public static void menuClientes(HashMap<Integer, Cliente> clientes) throws IOException {
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Cliente\n2 - Pesquisar Cliente\n3 - Editar Cliente\n4 - Deletar Cliente\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc){
                case 1:
                    ClasseMetodos.criaCliente(clientes);
                    break;
                case 2:
                    ClasseMetodos.pesquisaCliente(clientes);
                    break;
                case 3:
                    ClasseMetodos.editaCliente(clientes);
                    break;
                case 4:
                    ClasseMetodos.deletaCliente(clientes);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while (opc != 9);
    }

    public static void menuEmprestimos(){
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Livro\n2 - Editar Livro\n3 - Deletar Livro\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc){
                case 1:
                    //ClasseMetodos.novoEmprestimo();
                    break;
                case 2:
                    //ClasseMetodos.consultarEmprestimo();
                    break;
                case 3:
                    //ClasseMetodos.devolucao();
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while (opc != 9);
    }
}
