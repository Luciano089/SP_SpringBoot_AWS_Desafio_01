package Funcionalidades;

import Entidades.Emprestimo;
import Entidades.Livro;
import Entidades.Membro;
import Enumerados.EstadoEmprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import Funcionalidades.EmprestimoDeLivros;

import java.sql.Date;
import java.time.LocalDate;


import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class DevolucaoDeLivros {
    Scanner entrada = new Scanner(System.in);

    public void devolverLivro() {
        EntityManagerFactory EntidadeDeGerenciamentoDeFabrica = Persistence.createEntityManagerFactory("Funcionalidades");
        EntityManager GerenciadorDeEntidade = EntidadeDeGerenciamentoDeFabrica.createEntityManager();

        System.out.println("Digite o nome do membro que está devolvendo o livro: ");
        String nomeMembro = entrada.nextLine();

        System.out.println("Digite o ISBN do livro que deseja devolver: ");
        int isbn = entrada.nextInt();

        TypedQuery<Emprestimo> query = GerenciadorDeEntidade.createQuery(
                "SELECT emprestimo FROM Emprestimo emprestimo " +
                        "WHERE emprestimo.livro.isbn = :isbn " +
                        "AND emprestimo.membro.nome = :nome " +
                        "AND emprestimo.estado = :estado",
                Emprestimo.class);
        query.setParameter("isbn", isbn);
        query.setParameter("nome", nomeMembro);
        query.setParameter("estado", EstadoEmprestimo.ATIVO);

        List<Emprestimo> emprestimos = query.getResultList();


        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo ativo encontrado para este membro e livro");
            return;
        }

        Emprestimo emprestimo = emprestimos.get(0);


        LocalDate dataPrevistaDevolucao = emprestimo.getDataEmprestimo().plusDays(7);
        LocalDate dataAtual = LocalDate.of(2024, 10, 10);
        emprestimo.setEstado(EstadoEmprestimo.DEVOLVIDO);


//       long diasDeAtraso = java.time.temporal.ChronoUnit.DAYS.between(dataPrevistaDevolucao, LocalDate.now()); aqui você usa para testar

        long diasDeAtraso = java.time.temporal.ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataAtual);

        double multa = 0.0;
        if (diasDeAtraso > 0) {
            multa = diasDeAtraso * 5.00;
            System.out.println("A devolução está atrasada em " + diasDeAtraso + " dias");
            System.out.printf("A multa por atraso é de R$%.2f.%n", multa);
        } else {
            System.out.println("Devolução dentro do prazo.");
        }

        Livro livro = emprestimo.getLivro();

        GerenciadorDeEntidade.getTransaction().begin();
        emprestimo.setEstado(EstadoEmprestimo.DEVOLVIDO);
        livro.setQuantidade(livro.getQuantidade() + 1);
        GerenciadorDeEntidade.merge(emprestimo);
        GerenciadorDeEntidade.merge(livro);
        GerenciadorDeEntidade.getTransaction().commit();

        System.out.println("Livro devolvido com sucesso");


    }
}
