package Funcionalidades;

import Entidades.Emprestimo;
import Entidades.Membro;
import Enumerados.EstadoEmprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Funcionalidades.MostrarLivrosDisponiveis;


public class EmprestimoDeLivros {
    public static void realizarEmprestimo(Emprestimo emprestimo, Membro membro) throws ParseException {
        MostrarLivrosDisponiveis mostrar = new MostrarLivrosDisponiveis();
    }
}
