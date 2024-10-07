package Funcionalidades;

import Entidades.Emprestimo;
import Entidades.Livro;
import Entidades.Membro;
import Enumerados.EstadoEmprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class EmprestimoDeLivros {
    Scanner entrada = new Scanner(System.in);


    public void realizarEmprestimo(Emprestimo emprestimo) throws ParseException {
        EntityManagerFactory EntidadeDeGerenciamentoDeFabrica = Persistence.createEntityManagerFactory("Funcionalidades");
        EntityManager GerenciadorDeEntidade = EntidadeDeGerenciamentoDeFabrica.createEntityManager();


        List<Livro> livrosDisponiveis = GerenciadorDeEntidade.createQuery("SELECT livro FROM Livro livro WHERE livro.quantidade > 0", Livro.class).getResultList();

        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Não há livros disponíveis para empréstimo");
            return;
        } else {
            System.out.println("Livros disponíveis para empréstimo:");
            for (Livro livro : livrosDisponiveis) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Gênero: " + livro.getGenero());
                System.out.println("Quantidade disponível: " + livro.getQuantidade() + "\n");
            }
            System.out.println("Digite o isbn do livro que você deseja pegar emprestado: ");
            int isbn = entrada.nextInt();

            entrada.nextLine();

            System.out.println("Digite o nome do membro que está realizando o emprestimo: ");
            String nomeMembro = entrada.nextLine();

            TypedQuery<Membro> query = GerenciadorDeEntidade.createQuery("SELECT m FROM Membro m WHERE m.nome = :nome", Membro.class);
            query.setParameter("nome", nomeMembro);
            List<Membro> membros = query.getResultList();

            Membro membro = membros.get(0);

            Livro livro = GerenciadorDeEntidade.find(Livro.class, isbn);
            if (livro == null || livro.getQuantidade() <= 0) {
                System.out.println("Livro não encontrado ou indisponível.");
                GerenciadorDeEntidade.close();
                EntidadeDeGerenciamentoDeFabrica.close();
                return;
            }

            emprestimo.setLivro(livro);
            emprestimo.setMembro(membro);
            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setEstado(EstadoEmprestimo.ATIVO);

            GerenciadorDeEntidade.getTransaction().begin();
            GerenciadorDeEntidade.persist(emprestimo);
            GerenciadorDeEntidade.getTransaction().commit();
        }
    }
}
