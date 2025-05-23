import java.util.Scanner;

import System.Driver;
import System.Route;
import System.User;

public class App {
    public static void main(String[] args) throws Exception {
    boolean running = true;
    User user = new User();
    Scanner scanner = new Scanner(System.in);

    while (running != false) {
        System.out.println("========= APP DE CARONAS =========");
        System.out.println("""
                O que deseja fazer:
                [1] Fazer Login
                [2] Fazer Cadastro
                [3] Sair
                """);

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("""
                Você está cadastrado como:
                [1] Passageiro
                [2] Motorista
                """);

                int userRole = scanner.nextInt();
   
                System.out.println("Informe seu login e senha: ");
                switch (userRole) {
                    case 1: 
                        System.out.print("Usuário: ");
                        String username = scanner.next();

                        System.out.print("Senha: ");
                        String password = scanner.next();

                        boolean loginUser = user.login(username, password);
                        
                        if (!loginUser) {
                            System.out.println("Tente novamente.");
                            continue;
                        }
                        break;
                    
                    case 2:
                        Driver driver = new Driver();
                       
                        System.out.print("Usuário: ");
                        String drivername = scanner.next();

                        System.out.print("Senha: ");
                        String driverpass = scanner.next();

                        boolean loginDriver = driver.login(drivername, driverpass);
                        if (!loginDriver) {
                            System.out.println("Tente novamente.");
                            continue;
                        }
                        int status = 0;
                        Route route = new Route();
                        while (loginDriver) {
                            if (status == 0) {
                                System.out.println("Status: Indisponível");
                                System.out.println("Para onde vai?");
                                System.out.print("Partida: ");
                                String origin = scanner.next();
                                System.out.println("Destino: ");
                                String destination = scanner.next();

                                boolean routeConfig = route.setRoute(origin, destination);
                                if (!routeConfig) {
                                    System.out.println("Tente novamente");
                                    continue;
                                }
                            }
                        }
                        break;

                    default:
                        continue;
                }
                break;
            case 2:
                System.out.println("""
                        Você gostaria de dar caronas ou receber caronas?
                        [1] Motorista
                        [2] Passageiro
                        """);
                int signInChoice = scanner.nextInt();
                System.out.println("Crie um usuário e uma senha:");
                switch (signInChoice) {
                    case 1:
                        Driver driver = new Driver();

                        System.out.print("Usuário: ");
                        String drivername = scanner.next();

                        System.out.print("Senha: ");
                        String driverpass = scanner.next();

                        driver.createAccount(drivername, driverpass);
                        continue;
                    
                    case 2:
                    
                        System.out.print("Usuário: ");
                        String username = scanner.next();

                        System.out.print("Senha: ");
                        String password = scanner.next();

                        user.createAccount(username, password);
                        continue;

                    default:
                        continue;
                }

                case 3:
                    System.out.println("Saindo...");
                    running = false;
                    break;
            default:
            running = false;
            break;
            }
        }
        scanner.close();
    }
}

