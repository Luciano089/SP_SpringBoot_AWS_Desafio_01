package Funcionalidades;

import Entidades.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CadastroDeAutores {
    Scanner entrada = new Scanner(System.in);

    public void CadastrarAutor(Autor autor) throws ParseException {
        EntityManagerFactory fabricaDeGerenciadorDeEntidades = Persistence.createEntityManagerFactory("Funcionalidades");
        EntityManager GerenciadorDeEntidades = fabricaDeGerenciadorDeEntidades.createEntityManager();

        System.out.println("Digite o nome do autor: ");
        String nome = entrada.nextLine();

        TypedQuery<Autor> query = GerenciadorDeEntidades.createQuery("SELECT autor FROM Autor autor WHERE autor.nome = :nome", Autor.class);
        query.setParameter("nome", nome);
        List<Autor> autoresExistentes = query.getResultList();

        if (!autoresExistentes.isEmpty()) {
            System.out.println("O autor já existe no sistema");
            return;
        }

        System.out.println("Digite a Nacionalidade do autor: ");
        String nacionalidade = entrada.nextLine();


        System.out.println("Digite a biografia do autor: ");
        String biografia = entrada.nextLine();


        System.out.println("Digite a data de nascimento: ");
        String dataNascimentoString = entrada.nextLine();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = formatoData.parse(dataNascimentoString);

        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        autor.setBiografia(biografia);
        autor.setDataNascimento(dataNascimento);

        GerenciadorDeEntidades.getTransaction().begin();
        GerenciadorDeEntidades.persist(autor);
        GerenciadorDeEntidades.getTransaction().commit();

        System.out.println("O autor foi cadastrado");
    }
}
