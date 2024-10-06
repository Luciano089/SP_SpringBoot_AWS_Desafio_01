package Entidades;

import Enumerados.EstadoEmprestimo;

import java.util.Date;

public class Emprestimo {
    String livro;
    String dataEmprestimo;
    Date dataDevolucao;
    EstadoEmprestimo estado;
    double multa;

    public Emprestimo(String livro, String dataEmprestimo, Date dataDevolucao, EstadoEmprestimo estado, double multa) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.estado = estado;
        this.multa = multa;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
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
