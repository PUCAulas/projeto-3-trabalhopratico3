package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Livro> livros = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Dados iniciais
        livros.add(new Livro("Livro A", "Autor A", 2000, 3));
        livros.add(new Livro("Livro B", "Autor B", 2005, 2));
        usuarios.add(new Usuario("Usuário 1", "1"));
        usuarios.add(new Usuario("Usuário 2", "2"));

        int opcao;
        do {
            System.out.println("\nMenu da Biblioteca");
            System.out.println("1. Listar Livros");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Empréstimo de Livro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarLivros();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void listarLivros() {
        System.out.println("\nLivros Disponíveis:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    private static void listarUsuarios() {
        System.out.println("\nUsuários:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void realizarEmprestimo() {
        System.out.println("\nRealizar Empréstimo");
        System.out.print("ID do Usuário: ");
        String idUsuario = scanner.next();
        System.out.print("Título do Livro: ");
        String tituloLivro = scanner.next();

        Livro livroEscolhido = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                livroEscolhido = livro;
                break;
            }
        }

        if (livroEscolhido != null && livroEscolhido.verificarDisponibilidade()) {
            livroEscolhido.emprestar();
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }
}
