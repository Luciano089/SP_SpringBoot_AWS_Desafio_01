package Entidades;

import Enumerados.EstadoEmprestimo;
import java.time.LocalDate;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne
    private Livro livro;

    @ManyToOne
    private Membro membro;

    @Enumerated(EnumType.STRING)
    private EstadoEmprestimo estado;

    private LocalDate dataEmprestimo;
    private Date dataDevolucao;
    private double multa;


    public Emprestimo(Livro livro, LocalDate dataEmprestimo, Date dataDevolucao, EstadoEmprestimo estado, double multa) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.estado = estado;
        this.multa = multa;
    }

    public Emprestimo() {

    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public EstadoEmprestimo getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmprestimo estado) {
        this.estado = estado;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
