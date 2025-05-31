package System;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private HashMap<String, String> usersList;
    private ArrayList<String> route;

    public User() {
        this.usersList = new HashMap<>();
        this.route = new ArrayList<>();
    }

    public void createAccount(String newUser, String newPass) {
        this.usersList.put(newUser, newPass);
        System.out.println("Usuário criado com sucesso! Por favor faça o login.");
    }

    public boolean login(String user, String password) {
        if (usersList.containsKey(user)) {
            if (usersList.get(user).equals(password)) {
                System.out.println("Bem-vindo(a), " + user + "!");
                return true;
            } else {
                System.out.println("Senha incorreta.");
                return false;
            }
        } else {
            System.out.println("Usuário não encontrado.");
            return false;
        }
    }

    public HashMap<String, String> getUsersList() {
        return this.usersList;
    }

    public void addRoute(String origin, String destination) {
        Route userRoute = new Route();
        userRoute.setRoute(origin, destination);

        route.add(userRoute.getOrigin());
        route.add(userRoute.getDestination());
        System.out.println("Rota criada!");
    }
}