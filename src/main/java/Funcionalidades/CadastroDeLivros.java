package Funcionalidades;

import Entidades.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class CadastroDeLivros {
    Scanner entrada = new Scanner(System.in);


    public void CadastrarLivro(Livro livro) throws ParseException {

        EntityManagerFactory EntidadeDeGerenciamentoDeFabrica = Persistence.createEntityManagerFactory("Funcionalidades");
        EntityManager GerenciadorDeEntidade = EntidadeDeGerenciamentoDeFabrica.createEntityManager();

        System.out.println("Digite o nome do livro: ");
        String titulo = entrada.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = entrada.nextLine();


        System.out.println("Digite o genero do livro: ");
        String genero = entrada.nextLine();

        System.out.println("Digite a quantidade de livros que deseja cadastrar: ");
        int quantidade = entrada.nextInt();

        System.out.println("Digite a data de publicação");
        String dataPublicacao = entrada.nextLine();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date data01 = formatoData.parse(dataPublicacao);


        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setQuantidade(quantidade);
        livro.setDataPublicacao(data01);

        System.out.println();

        GerenciadorDeEntidade.getTransaction().begin();
        GerenciadorDeEntidade.persist(livro);
        GerenciadorDeEntidade.getTransaction().commit();

        System.out.println("O livro foi cadastrado com sucesso!");

    }

}
