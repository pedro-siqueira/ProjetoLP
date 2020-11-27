import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

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

    public static void escreveLivros(HashMap<Integer, Livro> livros) throws IOException {
        File livrosFile = new File("Livros.txt");
        FileWriter fw = new FileWriter(livrosFile);
        PrintWriter escreve = new PrintWriter(fw);

        for (Map.Entry<Integer, Livro> livro : livros.entrySet()) {
            String linha = (livro.getValue().id+","+livro.getValue().nome+","+livro.getValue().autor+","+livro.getValue().emprestado);
            escreve.println(linha);
        }
        escreve.close();
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

    public static void escreveClientes(HashMap<Integer, Cliente> clientes) throws IOException {
        File clientesFile = new File("Clientes.txt");
        FileWriter fw = new FileWriter(clientesFile);
        PrintWriter escreve = new PrintWriter(fw);

        for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
            String linha = (cliente.getValue().id+","+cliente.getValue().nome+","+cliente.getValue().email+","+cliente.getValue().cpf+","+cliente.getValue().telefone);
            escreve.println(linha);
        }
        escreve.close();
    }

    public static void carregaEmprestimos(HashMap<Integer, Emprestimo> emprestimos) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Emprestimos.txt"));
        String line;
        while ((line = br.readLine()) != null){
            String[] proxEmprestimo = line.split(",");
            Emprestimo temp = new Emprestimo(Integer.parseInt(proxEmprestimo[0]), Integer.parseInt(proxEmprestimo[1]), Integer.parseInt(proxEmprestimo[2]), proxEmprestimo[3], proxEmprestimo[4]);
            emprestimos.put(temp.id, temp);
        }
        br.close();
    }

    public static void escreveEmprestimos(HashMap<Integer, Emprestimo> emprestimos) throws IOException {
        File emprestimosFile = new File("Emprestimos.txt");
        FileWriter fw = new FileWriter(emprestimosFile);
        PrintWriter escreve = new PrintWriter(fw);

        for (Map.Entry<Integer, Emprestimo> emprestimo : emprestimos.entrySet()) {
            String linha = (emprestimo.getValue().id+","+emprestimo.getValue().idLivro+","+emprestimo.getValue().idCliente+","+emprestimo.getValue().dataEmprestimo+","+emprestimo.getValue().dataRetorno);
            escreve.println(linha);
        }
        escreve.close();
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

    public static void mostraEmprestimo(HashMap<Integer, Livro> livros, HashMap<Integer, Cliente> clientes, Emprestimo emprestimo) {
        JOptionPane.showMessageDialog(null,("Empréstimo ID: "+emprestimo.id+"\n\nCliente\nID: "+clientes.get(emprestimo.idCliente).id+"\nNome: "+clientes.get(emprestimo.idCliente).nome)+"\n\nLivro\nNome: "+livros.get(emprestimo.idLivro).nome+"\nAutor: "+livros.get(emprestimo.idLivro).autor+"\n\nData do Empréstimo: "+emprestimo.dataEmprestimo+"\nData do Retorno: "+emprestimo.dataRetorno);
    }

    public static void novoEmprestimo(HashMap<Integer, Livro> livros, HashMap<Integer, Cliente> clientes, HashMap<Integer, Emprestimo> emprestimos){
        int clienteId = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do cliente?"));
        int livroId = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do livro?"));
        Calendar calendar = Calendar.getInstance();
        if (JOptionPane.showConfirmDialog(null, ("Você confirma esse empréstimo?\n\nCliente: " + clientes.get(clienteId).nome + "\n\nLivro: " + livros.get(livroId).nome + "\nAutor: " + livros.get(livroId).autor), "AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            emprestimos.put(emprestimos.size()+1, new Emprestimo(emprestimos.size()+1, clienteId, livroId, calendar.getTime().toString(), "Emprestado"));
        }
    }

    public static void consultaEmprestimo(HashMap<Integer, Livro> livros, HashMap<Integer, Cliente> clientes, HashMap<Integer, Emprestimo> emprestimos){
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Deseja consultar empréstimos por: \n1 - ID do Livro\n2 - ID do Cliente\n9 - Voltar"));
            switch (opc){
                case 1:
                    int procuraIdLivro = Integer.parseInt(JOptionPane.showInputDialog("Deseja consultar pelo ID de qual livro?"));
                    int ativosLivro = Integer.parseInt(JOptionPane.showInputDialog("Deseja consultar apenas empréstimos ativos?\n1 - Sim"));
                    for (Map.Entry<Integer, Emprestimo> emprestimo : emprestimos.entrySet()) {
                        if (procuraIdLivro == emprestimo.getValue().idLivro) {
                            if ((ativosLivro == 1) && (emprestimo.getValue().dataRetorno.equals("Emprestado"))) {
                                mostraEmprestimo(livros, clientes, emprestimo.getValue());
                            } else if (ativosLivro != 1) {
                                mostraEmprestimo(livros, clientes, emprestimo.getValue());
                            }
                        }
                    }
                    break;
                case 2:
                    int procuraIdCliente = Integer.parseInt(JOptionPane.showInputDialog("Deseja consultar pelo ID de qual cliente?"));
                    int ativosCliente = Integer.parseInt(JOptionPane.showInputDialog("Deseja consultar apenas empréstimos ativos?\n1 - Sim"));
                    for (Map.Entry<Integer, Emprestimo> emprestimo : emprestimos.entrySet()) {
                        if (procuraIdCliente == emprestimo.getValue().idCliente) {
                            if ((ativosCliente == 1) && (emprestimo.getValue().dataRetorno.equals("Emprestado"))) {
                                mostraEmprestimo(livros, clientes, emprestimo.getValue());
                            } else if (ativosCliente != 1) {
                                mostraEmprestimo(livros, clientes, emprestimo.getValue());
                            }
                        }
                    }
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção Inválida");
            }
        }while(opc!=9);
    }

    public static void devolucao(HashMap<Integer, Livro> livros, HashMap<Integer, Cliente> clientes, HashMap<Integer, Emprestimo> emprestimos){
        Calendar calendar = Calendar.getInstance();
        int idDevolucao = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do emprestimo?"));
        if (JOptionPane.showConfirmDialog(null, ("Você confirma essa devolução?\n\nCliente: " + clientes.get(emprestimos.get(idDevolucao).idCliente).nome + "\n\nLivro: " + livros.get(emprestimos.get(idDevolucao).idLivro).nome + "\nAutor: " + livros.get(emprestimos.get(idDevolucao).idLivro).autor), "AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            emprestimos.get(idDevolucao).dataRetorno = calendar.getTime().toString();
        }
    }


}