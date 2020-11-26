import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClassePrincipal {



    public static void main(String[] args) throws IOException {

        ArrayList<Livro> livros = new ArrayList();
        ArrayList<Cliente> clientes = new ArrayList();

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

    public static void menuLivros(ArrayList<Livro> livros){
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Livro\n2 - Pesquisar Livro\n3 - Editar Livro\n4 - Deletar Livro\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc){
                case 1:
                    ClasseMetodos.criaLivro(livros);
                    break;
                case 2:
                    //ClasseMetodos.pesquisaLivro();
                    break;
                case 3:
                    //ClasseMetodos.editaLivro();
                    break;
                case 4:
                    //ClasseMetodos.deletaLivro();
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while (opc != 9);

    }

    public static void menuClientes(ArrayList<Cliente> clientes){
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo Cliente\n2 - Pesquisar Cliente\n3 - Editar Cliente\n4 - Deletar Cliente\n9 - Voltar\n", "Biblioteca da Dona Lúcia", JOptionPane.INFORMATION_MESSAGE));
            switch (opc){
                case 1:
                    //ClasseMetodos.criaCliente();
                    break;
                case 2:
                    //ClasseMetodos.pesquisaCliente();
                    break;
                case 3:
                    //ClasseMetodos.editaCliente();
                    break;
                case 4:
                    //ClasseMetodos.deletaCliente();
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
