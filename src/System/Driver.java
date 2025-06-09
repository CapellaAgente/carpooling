package System;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends User {
    ArrayList<String> carInfo;

    public Driver() {
        super();
        this.carInfo = new ArrayList<>();
    }

    public void createAccount(String newUser, String newPass, String nome) {
        super.createAccount(newUser, newPass, nome); // Reutiliza a lógica do pai

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
    }

 
    public Viagem oferecerViagem(String partida, String destino, double preco, int vagas) {
        Viagem novaViagem = new Viagem(this, partida, destino, preco, vagas);
        System.out.println("Viagem para " + destino + " oferecida com sucesso!");
        return novaViagem;
    }
    
    public ArrayList<String> getCarInfo() {
        return this.carInfo;
    }
}