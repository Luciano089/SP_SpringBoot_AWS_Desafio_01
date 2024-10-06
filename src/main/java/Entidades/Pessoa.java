package Entidades;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {

   private String nome;

   public Pessoa(String name){
      this.nome = name;
   }

   public Pessoa(){};

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }
}
