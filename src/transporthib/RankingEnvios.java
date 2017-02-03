package transporthib;

public class RankingEnvios {
    private String nameCity;
    private long envios;

    public RankingEnvios() {
    }
    
    
    public RankingEnvios(String nameCity, long envios) {
        this.nameCity = nameCity;
        this.envios = envios;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public long getEnvios() {
        return envios;
    }

    public void setEnvios(long envios) {
        this.envios = envios;
    }

    @Override
    public String toString() {
        return nameCity + " - " + envios;
    }
    
    
}
