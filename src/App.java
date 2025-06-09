import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import System.Driver;
import System.Endereco;
import System.User;
import System.Viagem;

public class App {
    static HashMap<String, User> userDatabase = new HashMap<>();
    static ArrayList<Viagem> viagensDisponiveis = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n========= APP DE CARONAS =========");
            System.out.println("[1] Fazer Login\n[2] Fazer Cadastro\n[3] Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> fazerLogin();
                case 2 -> fazerCadastro();
                case 3 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
        System.out.println("Saindo...");
    }

    public static void fazerCadastro() {
        System.out.println("Você quer se cadastrar como [1] Motorista ou [2] Passageiro?");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Crie um nome de usuário: ");
        String username = scanner.nextLine();
        if (userDatabase.containsKey(username)) {
            System.out.println("Erro: Nome de usuário já existe.");
            return;
        }
        System.out.print("Crie uma senha: ");
        String password = scanner.nextLine();
        System.out.print("Qual o seu nome completo? ");
        String nomeCompleto = scanner.nextLine();

        if (tipoUsuario == 1) {
            Driver driver = new Driver();
            driver.createAccount(username, password, nomeCompleto);
            userDatabase.put(username, driver);
        } else {
            User user = new User();
            user.createAccount(username, password, nomeCompleto);
            userDatabase.put(username, user);
        }
    }

    public static void fazerLogin() {
        System.out.print("Usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        User user = userDatabase.get(username);
        if (user != null && user.login(username, password)) {
      
            if (user instanceof Driver) {
                menuMotorista((Driver) user);
            } else {
                menuPassageiro(user);
            }
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
    }

    // Menu de ações para o Motorista.
    public static void menuMotorista(Driver driver) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Menu do Motorista ---");
            System.out.println("[1] Oferecer Nova Viagem");
            System.out.println("[2] Ver Minhas Viagens Oferecidas");
            System.out.println("[3] Cadastrar/Atualizar Endereço");
            System.out.println("[4] Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Local de partida: ");
                    String partida = scanner.nextLine();
                    System.out.print("Local de destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Preço da corrida (Ex: 25,50): ");
                    double preco = scanner.nextDouble();
                    System.out.print("Número de vagas: ");
                    int vagas = scanner.nextInt();
                    scanner.nextLine();
                    
                    Viagem novaViagem = driver.oferecerViagem(partida, destino, preco, vagas);
                    viagensDisponiveis.add(novaViagem);
                    break;
                case 2:
                    System.out.println("\n-- Suas Viagens --");
                    viagensDisponiveis.stream()
                        .filter(v -> v.getMotorista().equals(driver))
                        .forEach(System.out::println);
                    break;
                case 3:
                    cadastrarEndereco(driver);
                    break;
                case 4:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Menu de ações para o Passageiro.
    public static void menuPassageiro(User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Menu do Passageiro ---");
            System.out.println("[1] Procurar Carona");
            System.out.println("[2] Cadastrar/Atualizar Endereço");
            System.out.println("[3] Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n-- Viagens Disponíveis --");
                    if (viagensDisponiveis.isEmpty() || viagensDisponiveis.stream().allMatch(v -> v.getVagasDisponiveis() == 0)) {
                        System.out.println("Nenhuma viagem disponível no momento.");
                        break;
                    }
                    
                    for (int i = 0; i < viagensDisponiveis.size(); i++) {
                        if (viagensDisponiveis.get(i).getVagasDisponiveis() > 0) {
                            System.out.println("[" + (i + 1) + "] " + viagensDisponiveis.get(i));
                        }
                    }
                    
                    System.out.print("Escolha o número da viagem que deseja reservar: ");
                    int viagemIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (viagemIndex >= 0 && viagemIndex < viagensDisponiveis.size()) {
                        user.reservarVaga(viagensDisponiveis.get(viagemIndex));
                    } else {
                        System.out.println("Seleção inválida.");
                    }
                    break;
                case 2:
                    cadastrarEndereco(user);
                    break;
                case 3:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Função para cadastrar endereço de qualquer usuário.
    public static void cadastrarEndereco(User user) {
        System.out.println("\n-- Cadastro de Endereço --");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        user.setEndereco(new Endereco(rua, cidade, estado, cep));
        System.out.println("Endereço atualizado com sucesso!");
        System.out.println("Seu endereço: " + user.getEndereco());
    }
}