import java.util.Scanner;

public class gg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist[] playlists = new Playlist[6];
        Album[] albums = new Album[8];
        Artista[] artistas = new Artista[5];
        int numPlaylists = 0;
        int numAlbums = 0;
        int numArtistas = 0;

        boolean encerrarPrograma = false;
        while (!encerrarPrograma) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    listarPlaylists(playlists, numPlaylists);
                    break;
                case 2:
                    listarAlbums(albums, numAlbums);
                    break;
                case 3:
                    listarArtistas(artistas, numArtistas);
                    break;
                case 4:
                    if (numPlaylists < 6) {
                        playlists[numPlaylists] = cadastrarPlaylist(scanner);
                        numPlaylists++;
                    } else {
                        System.out.println("Erro: número máximo de playlists atingido!");
                    }
                    break;
                case 5:
                    if (numAlbums < 8) {
                        albums[numAlbums] = cadastrarAlbum(scanner);
                        numAlbums++;
                    } else {
                        System.out.println("Erro: número máximo de álbuns atingido!");
                    }
                    break;
                case 6:
                    int plano = escolherPlano(scanner);
                    double valorPlano = calcularValorPlano(plano);
                    String formaPagamento = escolherFormaPagamento(scanner);
                    double valorFinal = calcularValorFinal(valorPlano, formaPagamento);
                    exibirDetalhesCompra(plano, valorPlano, formaPagamento, valorFinal);
                    break;
                case 7:
                    encerrarPrograma = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1 - Listar Playlists");
        System.out.println("2 - Listar Álbuns");
        System.out.println("3 - Listar Artistas");
        System.out.println("4 - Cadastrar uma nova Playlist");
        System.out.println("5 - Cadastrar um novo Álbum");
        System.out.println("6 - Escolher Plano");
        System.out.println("7 - Encerrar o Programa");
        System.out.println("Digite a opção desejada:");
    }

    public static void listarPlaylists(Playlist[] playlists, int numPlaylists) {
        System.out.println("Playlist1");
        System.out.println("Playlist2");
        System.out.println("Playlist3");
        System.out.println("Playlist4");
        System.out.println("Playlist5");
        for (int i = 0; i < numPlaylists; i++) {
            System.out.println(playlists[i].getNome());
        }
    }

    public static void listarAlbums(Album[] albums, int numAlbums) {
        System.out.println(" Álbum 1");
        System.out.println(" Álbum 2 ");
        System.out.println(" Álbum 3");
        System.out.println(" Álbum 4 ");
        System.out.println(" Álbum 5 ");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i].getNome());
        }
    }

    public static void listarArtistas(Artista[] artistas, int numArtistas) {
        System.out.println("Artista 1");
        System.out.println("Artista 2");
        System.out.println("Artista 3");
        System.out.println("Artista 4");
        System.out.println("Artista 5");
        for (int i = 0; i < numArtistas; i++) {
            System.out.println(artistas[i].getNome());
        }
    }

    public static Playlist cadastrarPlaylist(Scanner scanner) {
        System.out.println("Digite o nome da Playlist:");
        String nome = scanner.nextLine();
        return new Playlist(nome);
    }

    public static Album cadastrarAlbum(Scanner scanner) {
        System.out.println("Digite o nome do Álbum:");
        String nome = scanner.nextLine();
        return new Album(nome);
    }

    public static int escolherPlano(Scanner scanner) {
        System.out.println("=== Escolha do Plano ===");
        System.out.println("1 - Plano Basic (R$9,90)");
        System.out.println("2 - Plano Duo (R$13,99)");
        System.out.println("3 - Plano Silver (R$15,00)");
        System.out.println("4 - Plano Premium (R$18,75)");
        System.out.println("5 - Finalizar Compra");
        System.out.println("Digite o número do plano desejado:");
        return scanner.nextInt();
    }

    public static double calcularValorPlano(int plano) {
        double valorPlano;
        switch (plano) {
            case 1:
                valorPlano = 9.90;
                break;
            case 2:
                valorPlano = 13.99;
                break;
            case 3:
                valorPlano = 15.00;
                break;
            case 4:
                valorPlano = 18.75;
                break;
            default:
                valorPlano = 0.00;
                break;
        }
        return valorPlano;
    }

    public static String escolherFormaPagamento(Scanner scanner) {
        System.out.println("=== Escolha da Forma de Pagamento ===");
        System.out.println("1 - PIX");
        System.out.println("2 - Transferência Bancária");
        System.out.println("3 - Cartão de Crédito");
        System.out.println("4 - Cartão de Débito");
        System.out.println("Digite o número da forma de pagamento desejada:");
        int formaPagamento = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        String formaPagamentoString;
        switch (formaPagamento) {
            case 1:
                formaPagamentoString = "PIX";
                break;
            case 2:
                formaPagamentoString = "Transferência Bancária";
                break;
            case 3:
                formaPagamentoString = "Cartão de Crédito";
                break;
            case 4:
                formaPagamentoString = "Cartão de Débito";
                break;
            default:
                formaPagamentoString = "Forma de pagamento inválida";
                break;
        }
        return formaPagamentoString;
    }

    public static double calcularValorFinal(double valorPlano, String formaPagamento) {
        if (formaPagamento.equals("PIX") || formaPagamento.equals("Cartão de Débito")) {
            valorPlano -= (valorPlano * 0.05);
        } else if (formaPagamento.equals("Cartão de Crédito")) {
            valorPlano += (valorPlano * 0.1);
        }
        return valorPlano;
    }

    public static void exibirDetalhesCompra(int plano, double valorPlano, String formaPagamento, double valorFinal) {
        System.out.println("=== Detalhes da Compra ===");
        System.out.println("Plano escolhido: " + plano);
        System.out.println("Forma de pagamento: " + formaPagamento);
        System.out.println("Valor a ser pago: R$" + valorFinal);
    }
}

class Playlist {
    private String nome;

    public Playlist(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Album {
    private String nome;

    public Album(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Artista {
    private String nome;

    public Artista(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

