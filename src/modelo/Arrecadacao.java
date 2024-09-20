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
	private String data;
	private double total;
	
	public Arrecadacao (String dataString) {
		this.data = dataString;
		this.total = 0.0;
	}
	
	public Arrecadacao () {}
	
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
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
