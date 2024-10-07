package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import Entidades.Emprestimo;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

@Entity
public class Membro extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private String telefone;
    private String email;
    private Date dataAssociacao;

    @OneToMany(mappedBy = "membro")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Membro(String nome, String endereco, String telefone, String email, Date dataAssociacao) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataAssociacao = dataAssociacao;
    }

    public Membro() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(Date dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }
}
