package System;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteSystem {
    private HashMap<String, ArrayList<String>> driverRoutes;

    public RouteSystem() {
        this.driverRoutes = new HashMap<>();
    }

    public void addDriverRoute(String driver, ArrayList<String> route) {
        if (route != null) {
            this.driverRoutes.computeIfAbsent(driver, k -> new ArrayList<>()).addAll(route);
            System.out.println("Sua rota registrada!");
        }
        System.out.println("Você não tem rota definida.");
    }

    public void showRoutes() {
        for (HashMap.Entry<String, ArrayList<String>> entry : driverRoutes.entrySet()) {
            System.out.println("Motorista: " + entry.getKey());
            System.out.print("Rotas:");
            for (String route : entry.getValue()) {
                System.out.println(" - " + route);
            }
        }
    }

}