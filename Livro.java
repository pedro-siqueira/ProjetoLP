public class Livro {
    int id;
    String nome;
    String autor;
    boolean emprestado;


    Livro(){
        this(-1, "", "", false);
    }

    Livro(int id, String nome, String autor, boolean emprestado){
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.emprestado = emprestado;
    }
/*
    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }
    public String getNome(){ return this.nome; }
    public void setNome(String nome){ this.nome = nome; }
    public String getAutor(){ return this.autor; }
    public void setAutor(String autor){ this.autor = autor; }
    public boolean getEmprestado() { return this.emprestado; }
    public void setEmprestado(boolean emprestado){ this.emprestado = emprestado; }
*/
}