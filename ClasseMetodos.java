import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ClasseMetodos {

    public static ArrayList<Livro> carregaLivros(ArrayList<Livro> livros) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Livros.txt"));
        String line;
        while ((line  = br.readLine()) != null){
            String[] proxLivro = line.split(",");
            Livro temp = new Livro(Integer.parseInt(proxLivro[0]), proxLivro[1], proxLivro[2], Boolean.parseBoolean(proxLivro[3]));
            livros.add(temp);
        }
        br.close();
        return livros;
    }

    public static ArrayList<Cliente> carregaClientes(ArrayList<Cliente> clientes) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Clientes.txt"));
        String line;
        while ((line = br.readLine()) != null){
            String[] proxCliente = line.split(",");
            Cliente temp = new Cliente(Integer.parseInt(proxCliente[0]), proxCliente[1], proxCliente[2], Integer.parseInt(proxCliente[3]), Integer.parseInt(proxCliente[4]));
            clientes.add(temp);
        }
        br.close();
        return clientes;
    }

    public static void criaLivro(ArrayList<Livro> livros){
        int id = livros.size()+1;
        String nome = JOptionPane.showInputDialog("Qual é o nome do livro?");
        String autor = JOptionPane.showInputDialog("Qual o nome do autor do livro?");

        livros.add(new Livro(id,nome,autor,false));
    }

}