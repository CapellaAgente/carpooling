package System;

import java.util.ArrayList;
import java.util.List;

public class Viagem {
    private Driver motorista;
    private String partida;
    private String destino;
    private double preco;
    private int vagasDisponiveis;
    private List<User> passageiros;

    public Viagem(Driver motorista, String partida, String destino, double preco, int vagas) {
        this.motorista = motorista;
        this.partida = partida;
        this.destino = destino;
        this.preco = preco;
        this.vagasDisponiveis = vagas;
        this.passageiros = new ArrayList<>();
    }

    // Getters para acessar as informações da viagem
    public Driver getMotorista() { return motorista; }
    public String getPartida() { return partida; }
    public String getDestino() { return destino; }
    public double getPreco() { return preco; }
    public int getVagasDisponiveis() { return vagasDisponiveis; }
    public List<User> getPassageiros() { return passageiros; }

    
    public boolean adicionarPassageiro(User passageiro) {
        if (vagasDisponiveis > 0) {
            this.passageiros.add(passageiro);
            this.vagasDisponiveis--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Motorista: %s | Partida: %s | Destino: %s | Preço: R$%.2f | Vagas: %d",
                motorista.getNome(), partida, destino, preco, vagasDisponiveis);
    }
}
