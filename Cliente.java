public class Cliente {
    
    int id;
    String nome;
    String email;
    int cpf;
    int telefone;

    public Cliente(){
        this(-1,"","",-1,-1);
    }

    public Cliente(int id, String nome, String email, int cpf, int telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    /*
    public void setId(int id){ this.id = id; }
    public int getId(){ return this.id; }
    public void setNome(String nome){ this.nome = nome; }
    public String getNome(){ return this.nome; }
    public void setEmail(String email){ this.email = email; }
    public String getEmail(){ return this.email; }
    public void setCpf(int cpf){ this.cpf = cpf; }
    public int getCpf(){ return this.cpf; }
    public void setTelefone(int telefone){ this.telefone = telefone; }
    public int getTelefone(){ return this.telefone; }
    */
}
