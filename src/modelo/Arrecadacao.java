package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Arrecadacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDate data;
	private double total;
	
	public Arrecadacao (String dataString) {


		// Formatter para o formato "dd/MM/yyyy"
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parsing da string para obter um objeto LocalDate
        LocalDate dataFormatada = LocalDate.parse(dataString, formatter);

		this.data = dataFormatada;
		this.total = 0.0;
	}
	
	public Arrecadacao () {}
	
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	// Methods
	@Override
	public String toString() {
		return "Arrecadacao [data=" + data + ", total=R$" + total + "]";
	}
	
	
	
	
}
