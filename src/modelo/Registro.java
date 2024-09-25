package modelo;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
public class Registro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDateTime datahora;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Veiculo veiculo;
	private String tipo; // entrada ou saida do veiculo
	
	public Registro(Veiculo veiculo,String tipo) {
		this.veiculo = veiculo;
		this.tipo = tipo;
		this.datahora = LocalDateTime.now(); 
	}
	public Registro() {}
	
	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	// Methods
	
	@Override
	public String toString() {
		return "Registro [id=" + id + ", datahora=" + datahora + ", veiculo=" + veiculo.getPlaca() + ", tipo=" + tipo + "] \n ";
	}
	
	
	
	
}
