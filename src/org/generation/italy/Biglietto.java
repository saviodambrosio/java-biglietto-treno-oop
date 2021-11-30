package org.generation.italy;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Biglietto {
	
	////// LAVORO SVOLTO NELLA SALA ROOM 1 ///////
	
	//costanti
	static final BigDecimal COSTO_KM = new BigDecimal("0.21");
	static final BigDecimal SCONTO_OVER = new BigDecimal("0.6");
	static final BigDecimal SCONTO_UNDER = new BigDecimal("0.8");
	static final int NORMAL = 30;
	static final int FLESSIBILE = 90;
	
	//attributi
	private int km;
	private int age;
	private LocalDate date;
	private boolean flessibile;
	
	//costruttore
	public Biglietto(int km,int age) throws Exception{
		this.date = date.now();
		this.flessibile = flessibile;
		this.km = km;
		this.age = age;
		if (!isValidkm() || !isValidage()) {
			throw new Exception("Inserisci un valore valido");
		}
	}
	
	private boolean isValidkm() {
		if(km<=0 || km > 10000) {
			return false;
		}else {
			return true;
		}
	}
	
	private boolean isValidage() {
		if(age<=0 || age>150) {
			return false;
		}else {
			return true;
		}
	}
	
	private BigDecimal calcolasconto() {
		if(age < 18) {
			return SCONTO_UNDER.multiply(COSTO_KM);	
		}else if(age>=65) {
			return SCONTO_OVER.multiply(COSTO_KM);
		}else {
			return COSTO_KM;
		}
	}
	
	public BigDecimal calcolaPrezzo() {
		if (flessibile) {
		return calcolasconto().multiply(BigDecimal.valueOf(km).multiply(BigDecimal.valueOf(1.10)));
		}
		return calcolasconto().multiply(BigDecimal.valueOf(km));
	}
	
	public LocalDate calcolaDataScadenza() {
		if (flessibile) {
			return date.plusDays(FLESSIBILE);
			
		}else {
			return date.plusDays(NORMAL);
		}
	}
	
	
	
	
}
