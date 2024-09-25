package modelo;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
public class Veiculo {

    @Id
    private String placa;

    @OneToMany(mappedBy="veiculo", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Registro> registros = new ArrayList<>();

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo() {}

    // Getters and Setters

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    // Methods
    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", registros=" + registros + "] \n" ;
    }
}