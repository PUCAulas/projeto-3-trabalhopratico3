package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Classe principal que contém o menu
public class SistemaBiblioteca {
	private Map<String, ItemBiblioteca> acervo;
    private List<Usuario> usuarios;
    private Scanner scanner;

    public SistemaBiblioteca() {
        this.acervo = new HashMap<>();
        this.usuarios = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
   

    public void adicionarItem(ItemBiblioteca item) {
        acervo.put(item.titulo, item);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------ Menu Principal ------");
            System.out.println("1. Gerenciar Itens");
            System.out.println("2. Gerenciar Usuários");
            System.out.println("3. Pesquisar Itens");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Emitir Relatórios");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuGerenciarItens();  // Requisito b
                    break;
                case 2:
                    menuGerenciarUsuarios();  // Requisito b
                    break;
                case 3:
                    menuPesquisarItens();  // Requisito c
                    break;
                case 4:
                    realizarEmprestimo();  // Requisito d
                    break;
                case 5:
                    emitirRelatorios();  // Requisito e
                    break;
                case 0:
                    System.out.println("/Saindo do sistema. Até logo!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    //Opções de gerenciamento de itens (cadastrar, editar e listar)
    private void menuGerenciarItens() {
    	Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------ Menu de Gerenciamento de Itens ------");
            System.out.println("1. Cadastrar Item");
            System.out.println("2. Editar Item");
            System.out.println("3. Listar Itens");
            System.out.println("0. Voltar ao Menu Principal");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNovoItem();
                    break;
                case 2:
                    editarItem();
                    break;
                case 3:
                    listarItens();
                    break;
                case 0:
                    return;  // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    //Lógica para cadastrar novo item
    private void cadastrarNovoItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Cadastro de Novo Item ------");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ano de Publicação: ");
        int anoPublicacao = scanner.nextInt();

        System.out.print("É emprestável? (true/false): ");
        boolean emprestavel = scanner.nextBoolean();

        System.out.print("Quantidade de Exemplares: ");
        int quantidadeExemplares = scanner.nextInt();

        System.out.println("Selecione o Tipo de Item:");
        System.out.println("1. Livro");
        System.out.println("2. Tese");
        System.out.println("3. CD");
        System.out.println("4. DVD");
        System.out.println("5. Revista");
        
        System.out.print("Escolha uma opção: ");
        int tipoItem = scanner.nextInt();

        ItemBiblioteca novoItem = null;

        switch (tipoItem) {
            case 1:
                novoItem = new Livro(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
                break;
            case 2:
                novoItem = new Tese(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
                break;
            case 3:
                novoItem = new CD(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
                break;
            case 4:
                novoItem = new DVD(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
                break;
            case 5:
                novoItem = new Revista(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
                break;
            default:
                System.out.println("Opção inválida. Item não cadastrado.");
                return;
        }

        // Adicionar o novo item ao acervo
        adicionarItem(novoItem);

        System.out.println("Item cadastrado com sucesso!");
    }

    //Lógica para editar item
    private void editarItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Edição de Item ------");
        System.out.print("Informe o título do item que deseja editar: ");
        String titulo = scanner.nextLine();

        ItemBiblioteca item = buscarItemPorTitulo(titulo);

        if (item == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        System.out.println("Item encontrado. Informações atuais:");
        System.out.println(item);

        System.out.println("Informe os novos dados (ou pressione Enter para manter os dados atuais):");

        System.out.print("Novo Título: ");
        String novoTitulo = scanner.nextLine();
        if (!novoTitulo.isEmpty()) {
            item.setTitulo(novoTitulo);
        }

        System.out.print("Novo Autor: ");
        String novoAutor = scanner.nextLine();
        if (!novoAutor.isEmpty()) {
            item.setAutor(novoAutor);
        }

        System.out.print("Novo Ano de Publicação: ");
        String novoAno = scanner.nextLine();
        if (!novoAno.isEmpty()) {
            try {
                int novoAnoInt = Integer.parseInt(novoAno);
                item.setAnoPublicacao(novoAnoInt);
            } catch (NumberFormatException e) {
                System.out.println("Ano de publicação inválido. O ano não foi alterado.");
            }
        }

        // Se o item for emprestável, permite editar esses atributos
        if (item instanceof Emprestavel) {
            Emprestavel emprestavelItem = (Emprestavel) item;

            System.out.print("É emprestável? (true/false): ");
            String novoEmprestavel = scanner.nextLine();
            if (!novoEmprestavel.isEmpty()) {
                emprestavelItem.setEmprestavel(Boolean.parseBoolean(novoEmprestavel));
            }

            System.out.print("Nova Quantidade de Exemplares: ");
            String novaQuantidadeExemplares = scanner.nextLine();
            if (!novaQuantidadeExemplares.isEmpty()) {
                try {
                    int novaQuantidadeExemplaresInt = Integer.parseInt(novaQuantidadeExemplares);
                    emprestavelItem.setQuantidadeExemplares(novaQuantidadeExemplaresInt);
                } catch (NumberFormatException e) {
                    System.out.println("Quantidade de exemplares inválida. A quantidade não foi alterada.");
                }
            }
        }

        System.out.println("Edição concluída. Novas informações:");
        System.out.println(item);
    }

    private ItemBiblioteca buscarItemPorTitulo(String titulo) {
        return acervo.get(titulo);
    }

    //Lógica para listar itens
    private void listarItens() {
        System.out.println("------ Lista de Itens no Acervo ------");
        for (ItemBiblioteca item : acervo.values()) {
            System.out.println(item);
        }
        System.out.println("-------------------------------------");
    }

    private void menuGerenciarUsuarios() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n------ Menu Gerenciar Usuários ------");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Editar Usuário");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    editarUsuario();
                    break;
                case 3:
                    removerUsuario();
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

   //Lógica para cadastrar usuário
    private void cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        // Verificar se o usuário já existe
        boolean usuarioExistente = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                usuarioExistente = true;
                break;
            }
        }

        if (usuarioExistente) {
            System.out.println("Usuário já cadastrado.");
        } else {
            Usuario novoUsuario = new Usuario(nome);
            usuarios.add(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        }
    }

    //Lógica para editar usuário
    private void editarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do usuário que deseja editar: ");
        String nomeUsuario = scanner.nextLine();

        // Verificar se o usuário existe
        Usuario usuarioExistente = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                usuarioExistente = usuario;
                break;
            }
        }

        if (usuarioExistente == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            // Exibir informações atuais do usuário
            System.out.println("Informações atuais do usuário:");
            System.out.println(usuarioExistente);

            // Solicitar novas informações ao usuário
            System.out.print("Novo nome do usuário: ");
            String novoNome = scanner.nextLine();
            usuarioExistente.setNome(novoNome);

            // Exibir mensagem de sucesso
            System.out.println("Usuário editado com sucesso!");
        }
    }

    //Lógica para remover o usuário
    private void removerUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do usuário que deseja remover: ");
        String nomeUsuario = scanner.nextLine();

        // Verificar se o usuário existe
        Usuario usuarioExistente = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                usuarioExistente = usuario;
                break;
            }
        }

        if (usuarioExistente == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            // Remover o usuário da lista
            usuarios.remove(usuarioExistente);
            System.out.println("Usuário removido com sucesso!");
        }
    }

    
    //Lógica para listar usuários
    private void listarUsuarios() {
        System.out.println("------ Lista de Usuários ------");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
        System.out.println("------------------------------");
    }

    private void menuPesquisarItens() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n------ Menu Pesquisar Itens ------");
            System.out.println("1. Por Título");
            System.out.println("2. Por Autor");
            System.out.println("3. Por Ano");
            System.out.println("4. Por Tipo");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    pesquisarPorTitulo();
                    break;
                case 2:
                    pesquisarPorAutor();
                    break;
                case 3:
                    pesquisarPorAno();
                    break;
                case 4:
                    pesquisarPorTipo();
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    //Pesquisa item por título
    private void pesquisarPorTitulo() {
        System.out.print("Digite o título para pesquisa: ");
        String titulo = scanner.nextLine();

        System.out.println("\n------ Resultados da Pesquisa por Título ------");
        for (ItemBiblioteca item : acervo.values()) {
            if (item.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println(item);
            }
        }
    }

    //Pesquisa item por autor
    private void pesquisarPorAutor() {
        System.out.print("Digite o autor para pesquisa: ");
        String autor = scanner.nextLine();

        System.out.println("\n------ Resultados da Pesquisa por Autor ------");
        for (ItemBiblioteca item : acervo.values()) {
            if (item instanceof Livro) {
                Livro livro = (Livro) item;
                // Certifique-se de que a classe Livro tenha o método getAutor()
                if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                    System.out.println(item);
                }
            }
        }
    }
    
    //Pesquisa item por ano
    private void pesquisarPorAno() {
        System.out.print("Digite o ano para pesquisa: ");
        int ano = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do scanner

        System.out.println("\n------ Resultados da Pesquisa por Ano ------");
        for (ItemBiblioteca item : acervo.values()) {
            if (item.getAnoPublicacao() == ano) {
                System.out.println(item);
            }
        }
    }

    
    //Pesquisa item por tipo
    private void pesquisarPorTipo() {
        System.out.print("Digite o tipo para pesquisa (livro, tese, cd, dvd, revista): ");
        String tipo = scanner.nextLine().toLowerCase();

        System.out.println("\n------ Resultados da Pesquisa por Tipo ------");
        for (ItemBiblioteca item : acervo.values()) {
            if (item.getTipo().toLowerCase().equals(tipo)) {
                System.out.println(item);
            }
        }
    }

    // Lógica para realizar empréstimos
    private void realizarEmprestimo() {
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuario = buscarUsuarioPorNome(nomeUsuario);

        if (usuario != null && usuario.podePegarEmprestado()) {
            exibirItensDisponiveis();

            System.out.print("Digite o nome do item que deseja emprestar: ");
            String nomeItem = scanner.nextLine();

            ItemBiblioteca item = buscarItemPorNome(nomeItem);

            if (item != null && item instanceof Emprestavel) {
                Emprestavel emprestavel = (Emprestavel) item;

                if (emprestavel.podeSerEmprestado()) {
                    usuario.adicionarItemEmprestado(item);
                    emprestavel.emprestar();

                    System.out.println("Empréstimo realizado com sucesso!");
                } else {
                    System.out.println("O item não está disponível para empréstimo.");
                }
            } else {
                System.out.println("Item não encontrado ou não é emprestável.");
            }
        } else {
            System.out.println("Usuário não encontrado ou não pode pegar mais empréstimos.");
        }
    }

    // Item é buscado por nome
    private ItemBiblioteca buscarItemPorNome(String nomeItem) {
        for (ItemBiblioteca item : acervo.values()) {
            if (item.getTitulo().equalsIgnoreCase(nomeItem)) {
                return item;
            }
        }
        return null; // Retorna null se o item não for encontrado
    }

    private Usuario buscarUsuarioPorNome(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    
    //Exibe lista de itens disponíveis
    private void exibirItensDisponiveis() {
        System.out.println("\n------ Itens Disponíveis para Empréstimo ------");
        for (ItemBiblioteca item : acervo.values()) {
            if (item instanceof Emprestavel) {
                Emprestavel emprestavel = (Emprestavel) item;
                if (emprestavel.podeSerEmprestado()) {
                    System.out.println(item);
                }
            }
        }
    }

    //Lógica para emitir relatórios
    private void emitirRelatorios() {
        System.out.println("Escolha a opção de relatório:");
        System.out.println("1. Relatório por item");
        System.out.println("2. Relatório por usuário");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

        switch (opcao) {
            case 1:
                relatorioPorItem();
                break;
            case 2:
                relatorioPorUsuario();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    // Lógica para emitir relatório por item
    private void relatorioPorItem() {
        System.out.println("------ Relatório por Item ------");

        List<ItemBiblioteca> itensOrdenadosPorAno = new ArrayList<>(acervo.values());
        itensOrdenadosPorAno.sort(Comparator.comparingInt(ItemBiblioteca::getAnoPublicacao));

        for (ItemBiblioteca item : itensOrdenadosPorAno) {
            System.out.println(item + " - Quantidade de empréstimos: " + item.getQuantidadeEmprestimos());
        }
    }

    // Lógica para emitir relatório por usuário
    private void relatorioPorUsuario() {

        System.out.println("------ Relatório por Usuário ------");

        List<Usuario> usuariosOrdenadosPorNome = new ArrayList<>(usuarios);
        usuariosOrdenadosPorNome.sort(Comparator.comparing(Usuario::getNome));

        for (Usuario usuario : usuariosOrdenadosPorNome) {
            System.out.println(usuario + " - Itens emprestados: " + usuario.getItensEmprestados());
        }
    }

    public static void main(String[] args) {
    	SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Populando o acervo com 3 objetos de cada tipo para teste (Requisito b)
        sistema.adicionarItem(new Livro("Livro 1", "Autor 1", 2000, true, 3));
        sistema.adicionarItem(new Livro("Livro 2", "Autor 2", 2010, true, 3));
        sistema.adicionarItem(new Livro("Livro 3", "Autor 3", 2020, true, 3));

        sistema.adicionarItem(new Tese("Tese 1", "Autor 4", 2015, false, 3));
        sistema.adicionarItem(new Tese("Tese 2", "Autor 5", 2005, false, 3));
        sistema.adicionarItem(new Tese("Tese 3", "Autor 6", 2018, false, 3));

        sistema.adicionarItem(new CD("CD 1", "Artista 1", 2012, true, 3));
        sistema.adicionarItem(new CD("CD 2", "Artista 2", 2008, true, 3));
        sistema.adicionarItem(new CD("CD 3", "Artista 3", 2019, true, 3));

        sistema.adicionarItem(new DVD("DVD 1", "Diretor 1", 2011, true, 3));
        sistema.adicionarItem(new DVD("DVD 2", "Diretor 2", 2007, true, 3));
        sistema.adicionarItem(new DVD("DVD 3", "Diretor 3", 2022, true, 3));

        sistema.adicionarItem(new Revista("Revista 1", "Editor 1", 2014, true, 3));
        sistema.adicionarItem(new Revista("Revista 2", "Editor 2", 2009, true, 3));
        sistema.adicionarItem(new Revista("Revista 3", "Editor 3", 2017, true, 3));

        // Populando o sistema com 3 usuários para teste (Requisito b)
        sistema.adicionarUsuario(new Usuario("Usuario 1"));
        sistema.adicionarUsuario(new Usuario("Usuario 2"));
        sistema.adicionarUsuario(new Usuario("Usuario 3"));

        // Inicializando o menu principal
        sistema.menuPrincipal();
    }
}
