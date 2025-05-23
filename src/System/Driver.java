package System;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends User {
    User user;
    Route route;
    ArrayList<String> carInfo;

    public Driver() {
        this.carInfo = new ArrayList<>();
    }

    public void createAccount(String newUser, String newPass) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe os dados do carro: ");
        System.out.print("Modelo: ");
        String model = scanner.next();

        System.out.print("Marca: ");
        String brand = scanner.next();

        System.out.print("Placa: ");
        String plate = scanner.next();

        this.carInfo.add(model);
        this.carInfo.add(brand);
        this.carInfo.add(plate);

        System.out.println("Carro adicionado com sucesso!");

        scanner.close();

        super.createAccount(newUser, newPass);
    }

    public boolean login(String user, String password) {
        return super.login(user, password);
    }

    public ArrayList<String> getCarInfo() {
        return this.carInfo;
    }
}