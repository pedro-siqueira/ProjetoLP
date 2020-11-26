import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClasseMetodos {

    public static void carregaLivros(HashMap<Integer, Livro> livros) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Livros.txt"));
        String line;
        while ((line  = br.readLine()) != null){
            String[] proxLivro = line.split(",");
            Livro temp = new Livro(Integer.parseInt(proxLivro[0]), proxLivro[1], proxLivro[2], Boolean.parseBoolean(proxLivro[3]));
            livros.put(temp.id, temp);
        }
        br.close();
    }

    public static void carregaClientes(HashMap<Integer, Cliente> clientes) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Clientes.txt"));
        String line;
        while ((line = br.readLine()) != null){
            String[] proxCliente = line.split(",");
            Cliente temp = new Cliente(Integer.parseInt(proxCliente[0]), proxCliente[1], proxCliente[2], proxCliente[3], proxCliente[4]);
            clientes.put(temp.id, temp);
        }
        br.close();
    }

    public static void criaLivro(HashMap<Integer, Livro> livros) throws IOException {
        BookCount.incrementa();
        int id = BookCount.getLast();
        String nome = JOptionPane.showInputDialog("Qual é o nome do livro?");
        String autor = JOptionPane.showInputDialog("Qual o nome do autor do livro?");

        livros.put(id, new Livro(id,nome,autor,false));
    }

    public static void mostraLivro(Livro livro){
        JOptionPane.showMessageDialog(null, ("ID: "+livro.id+"\nNome: "+livro.nome+"\nAutor: "+livro.autor+"\nStatus: "+(livro.emprestado?"Emprestado":"Disponível")));
    }

    public static void pesquisaLivro(HashMap<Integer, Livro> livros){
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Pesquisar livro por:\n1 - ID\n2 - Nome\n3 - Autor\n9 - Volta"));
            switch (opc){
                case 1:
                    int procuraId = Integer.parseInt(JOptionPane.showInputDialog("Qual ID deseja procurar?"));
                    mostraLivro(livros.get(procuraId));
                    break;
                case 2:
                    String procuraNome = JOptionPane.showInputDialog("Por qual nome deseja procurar?");
                    for (Map.Entry<Integer, Livro> livro : livros.entrySet()) {
                        if (!procuraNome.equals("") && livro.getValue().nome.contains(procuraNome)) { mostraLivro(livro.getValue()); }
                    }
                    break;
                case 3:
                    String procuraAutor = JOptionPane.showInputDialog("Por qual autor deseja procurar?");
                    for (Map.Entry<Integer, Livro> livro : livros.entrySet()) {
                        if (!procuraAutor.equals("") && livro.getValue().autor.contains(procuraAutor)) { mostraLivro(livro.getValue()); }
                    }
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção Inválida.");
                    break;
            }
        }while(opc!=9);
    }

    public static void editaLivro(HashMap<Integer, Livro> livros) {
        int editaId = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do livro que deseja editar?"));
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Que campo deseja editar do livro?\n1 - Nome: " + livros.get(editaId).nome + "\n2 - Autor: " + livros.get(editaId).autor+"\n9 - Voltar"));
            switch (opc) {
                case 1:
                    livros.get(editaId).nome = JOptionPane.showInputDialog("Qual deseja que seja o novo nome?");
                    break;
                case 2:
                    livros.get(editaId).autor = JOptionPane.showInputDialog("Qual deseja que seja o novo autor?");
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while(opc!=9);
    }

    public static void deletaLivro(HashMap<Integer, Livro> livros){
        int deletaId = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do livro que deseja deletar?"));
        mostraLivro(livros.get(deletaId));
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o livro este livro?", "AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            livros.remove(deletaId);
        }
    }

    public static void criaCliente(HashMap<Integer, Cliente> clientes) throws IOException {
        ClientCount.incrementa();
        int id = ClientCount.getLast();
        String nome = JOptionPane.showInputDialog("Qual é o nome do cliente?");
        String email = JOptionPane.showInputDialog("Qual o email do cliente?");
        String cpf = JOptionPane.showInputDialog("Qual o CPF do cliente?");
        String telefone = JOptionPane.showInputDialog("Qual o telefone do cliente?");

        clientes.put(id, new Cliente(id,nome,email,cpf,telefone));
    }

    public static void mostraCliente(Cliente cliente){
        JOptionPane.showMessageDialog(null, ("ID: "+cliente.id+"\nNome: "+cliente.nome+"\nE-Mail: "+cliente.email+"\nCPF: "+cliente.cpf+"\nTelefone: "+cliente.telefone));
    }

    public static void pesquisaCliente(HashMap<Integer, Cliente> clientes){
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Pesquisar cliente por:\n1 - ID\n2 - Nome\n3 - Email\n4 - CPF\n5 - Telefone\n9 - Volta"));
            switch (opc){
                case 1:
                    int procuraId = Integer.parseInt(JOptionPane.showInputDialog("Qual ID deseja procurar?"));
                    mostraCliente(clientes.get(procuraId));
                    break;
                case 2:
                    String procuraNome = JOptionPane.showInputDialog("Por qual nome deseja procurar?");
                    for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
                        if (!procuraNome.equals("") && cliente.getValue().nome.contains(procuraNome)) { mostraCliente(cliente.getValue()); }
                    }
                    break;
                case 3:
                    String procuraEmail = JOptionPane.showInputDialog("Por qual email deseja procurar?");
                    for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
                        if (!procuraEmail.equals("") && cliente.getValue().email.contains(procuraEmail)) { mostraCliente(cliente.getValue()); }
                    }
                    break;
                case 4:
                    String procuraCpf = JOptionPane.showInputDialog("Por qual cpf deseja procurar?");
                    for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
                        if (!procuraCpf.equals("") && cliente.getValue().cpf.contains(procuraCpf)) { mostraCliente(cliente.getValue()); }
                    }
                    break;
                case 5:
                    String procuraTelefone = JOptionPane.showInputDialog("Por qual telefone deseja procurar?");
                    for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
                        if (!procuraTelefone.equals("") && cliente.getValue().telefone.contains(procuraTelefone)) { mostraCliente(cliente.getValue()); }
                    }
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção Inválida.");
                    break;
            }
        }while(opc!=9);
    }

    public static void editaCliente(HashMap<Integer, Cliente> clientes) {
        int editaId = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do cliente que deseja editar?"));
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Que campo deseja editar do cliente?\n1 - Nome: " + clientes.get(editaId).nome + "\n2 - Email: " + clientes.get(editaId).email+"\n3 - CPF: "+clientes.get(editaId).cpf+"\n4 - Telefone: "+clientes.get(editaId).telefone+"\n9 - Voltar"));
            switch (opc) {
                case 1:
                    clientes.get(editaId).nome = JOptionPane.showInputDialog("Qual deseja que seja o novo nome?");
                    break;
                case 2:
                    clientes.get(editaId).email = JOptionPane.showInputDialog("Qual deseja que seja o novo email?");
                    break;
                case 3:
                    clientes.get(editaId).cpf = JOptionPane.showInputDialog("Qual deseja que seja o novo CPF?");
                    break;
                case 4:
                    clientes.get(editaId).telefone = JOptionPane.showInputDialog("Qual deseja que seja o novo telefone?");
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }while(opc!=9);
    }

    public static void deletaCliente(HashMap<Integer, Cliente> clientes){
        int deletaId = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do cliente que deseja deletar?"));
        mostraCliente(clientes.get(deletaId));
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este cliente?", "AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            clientes.remove(deletaId);
        }
    }


}