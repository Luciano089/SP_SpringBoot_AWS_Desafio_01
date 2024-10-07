package Funcionalidades;

import Entidades.Membro;
import Enumerados.EstadoEmprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CadastroDeMembros {
     Scanner entrada = new Scanner(System.in);

    public void cadastrarMembro(Membro membro) throws ParseException {

        EntityManagerFactory EntidadeDeGerenciamentoDeFabrica = Persistence.createEntityManagerFactory("Funcionalidades");
        EntityManager GerenciadorDeEntidade = EntidadeDeGerenciamentoDeFabrica.createEntityManager();

        System.out.println("Digite o nome do membro: ");
        String nome = entrada.nextLine();

        System.out.println("Digite o endereço do membro: ");
        String endereco = entrada.nextLine();


        System.out.println("Digite o telefone do membro: ");
        String telefone = entrada.nextLine();

        System.out.println("Digite a email do membro: ");
        String email = entrada.nextLine();

        System.out.println("Digite a data de associação do membro (dd/MM/yyyy): ");
        String dataAssociacaoString = entrada.nextLine();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAssociacao = formatoData.parse(dataAssociacaoString);


        membro.setNome(nome);
        membro.setEmail(email);
        membro.setTelefone(telefone);
        membro.setDataAssociacao(dataAssociacao);
        membro.setEndereco(endereco);
        GerenciadorDeEntidade.getTransaction().begin();
        GerenciadorDeEntidade.persist(membro);
        GerenciadorDeEntidade.getTransaction().commit();

        System.out.println("Membro cadastrado com sucesso");

    }
}
