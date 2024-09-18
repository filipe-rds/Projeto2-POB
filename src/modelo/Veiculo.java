package modelo;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class Veiculo {
	
	@Id
	private String placa;
	
	@OneToMany(mappedBy="veiculo",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private ArrayList <Registro> registros =  new ArrayList<>();
	
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

	public ArrayList<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(ArrayList<Registro> registros) {
		this.registros = registros;
	}
	
	// Methods
	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", registros=" + registros + "] \n" ;
	}

	
	
}
