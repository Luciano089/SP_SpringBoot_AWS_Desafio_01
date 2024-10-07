import Entidades.*;
import Funcionalidades.CadastroDeAutores;
import Funcionalidades.CadastroDeLivros;
import Funcionalidades.ExibirMenu;
import Funcionalidades.CadastroDeMembros;
import Funcionalidades.EmprestimoDeLivros;
import Funcionalidades.MostrarLivrosDisponiveis;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        ExibirMenu exibir = new ExibirMenu();
        exibir.exibirMenu();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                CadastroDeLivros cadastroDeLivros = new CadastroDeLivros();
                cadastroDeLivros.CadastrarLivro(new Livro());
                break;
            case 2:
                CadastroDeAutores cadastroDeAutores = new CadastroDeAutores();
                cadastroDeAutores.CadastrarAutor(new Autor());
                break;
            case 3:
                CadastroDeMembros cadastroDeMembros = new CadastroDeMembros();
                cadastroDeMembros.cadastrarMembro(new Membro());
                break;
            case 4:
                EmprestimoDeLivros emprestimoDeLivros = new EmprestimoDeLivros();
                emprestimoDeLivros.realizarEmprestimo(new Emprestimo());
                break;
        }

    }


}
