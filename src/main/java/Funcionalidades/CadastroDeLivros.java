package Funcionalidades;

import Entidades.Livro;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class CadastroDeLivros {
    Scanner entrada = new Scanner(System.in);


    public void CadastrarLivro(Livro livro) throws ParseException {



        System.out.println("Digite o nome do livro: ");
        String titulo = entrada.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = entrada.nextLine();

        System.out.println("Digite o genero do livro: ");
        String genero = entrada.nextLine();

        System.out.println("Digite o ISBN do livro(Apenas Números): ");
        Integer isbn = entrada.nextInt();

        EntityManagerFactory EntidadeDeGerenciamentoDeFabrica = Persistence.createEntityManagerFactory("Funcionalidades");
        EntityManager GerenciadorDeEntidade = EntidadeDeGerenciamentoDeFabrica.createEntityManager();

        TypedQuery<Livro> query = GerenciadorDeEntidade.createQuery("SELECT livro FROM Livro livro WHERE livro.isbn = :isbn", Livro.class);
        query.setParameter("isbn", isbn);

        List<Livro> livrosExistentes = query.getResultList();

        if (!livrosExistentes.isEmpty()) {
            System.out.println("Já tem um livro com esse ISBN cadastrado no banco de dados");
            return;
        }

        System.out.println("Digite a quantidade de livros que deseja cadastrar: ");
        int quantidade = entrada.nextInt();

        entrada.nextLine();

        System.out.println("Digite a data de publicação");
        String dataPublicacaoString = entrada.nextLine();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPublicacao = formatoData.parse(dataPublicacaoString);


        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setIsbn(isbn);
        livro.setQuantidade(quantidade);
        livro.setDataPublicacao(dataPublicacao);

        System.out.println();

        GerenciadorDeEntidade.getTransaction().begin();
        GerenciadorDeEntidade.persist(livro);
        GerenciadorDeEntidade.getTransaction().commit();

        System.out.println("O livro foi cadastrado com sucesso!");

    }
}
