public class Usuario {
    String nome;
    int idade;
    String email;



    public Usuario(String nome, int idade, String email){
this.nome = nome;
this.idade = idade;
this.email = email;
    }


    public String toString(){
        return "Nome: " + nome + "\nIdade: " + idade + "\nEmail: " + email;
    }



}
