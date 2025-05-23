package System;

public class Route {
    private String origin;
    private String destination;

    public boolean setRoute(String origin, String destination) {
        if (origin == null || destination == null) {
            System.out.println("Erro: Preencha a origem e o seu destino.");
            return false;
        }
        this.origin = origin;
        this.destination = destination;
        return true;
    }
    
    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
       return this.destination;
    }
}
