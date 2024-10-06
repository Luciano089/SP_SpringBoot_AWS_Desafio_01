package Entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Autor extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataNascimento;
    private String nacionalidade;
    private String biografia;

    public Autor(String nome, String nacionalidade, String biografia, Date dataNascimento) {
        super(nome);
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
        this.dataNascimento = dataNascimento;
    }

    public Autor() {
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
}

