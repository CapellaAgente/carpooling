package System;

import java.util.HashMap;

public class User {

    private String nome;
    private Endereco endereco;
    private HashMap<String, String> usersList;

    public User() {
        this.usersList = new HashMap<>();
    }

    public void createAccount(String newUser, String newPass, String nome) {
        this.usersList.put(newUser, newPass);
        this.nome = nome;
        System.out.println("Usuário criado com sucesso! Por favor faça o login.");
    }

    public boolean login(String user, String password) {
        if (usersList.containsKey(user) && usersList.get(user).equals(password)) {
            System.out.println("Bem-vindo(a), " + this.nome + "!");
            return true;
        }
        return false;
    }
    
    // Getters e Setters para os novos campos
    public String getNome() { return nome; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public boolean reservarVaga(Viagem viagem) {
        if (viagem.adicionarPassageiro(this)) {
            System.out.println("Reserva confirmada na viagem para " + viagem.getDestino() + "!");
            return true;
        } else {
            System.out.println("Não foi possível reservar. Viagem lotada.");
            return false;
        }
    }
}