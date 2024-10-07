package Funcionalidades;

import Entidades.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MostrarLivrosDisponiveis {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Funcionalidades");

    public static void listarLivrosDisponiveis() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        List<Livro> livrosDisponiveis = entityManager.createQuery("SELECT livro FROM Livro livro WHERE livro.quantidade > 0", Livro.class).getResultList();

        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Não há livros disponíveis para empréstimo");
        } else {
            System.out.println("Livros disponíveis para empréstimo:");
            for (Livro livro : livrosDisponiveis) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Gênero: " + livro.getGenero());
                System.out.println("Quantidade disponível: " + livro.getQuantidade());
            }
        }
    }
}

