package System;

public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String cidade, String estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    @Override
    public String toString() {
        if (rua == null || rua.isEmpty()) {
            return "Nenhum endereço cadastrado.";
        }
        return String.format("%s, %s - %s, CEP: %s", rua, cidade, estado, cep);
    }
}
