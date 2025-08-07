package Model;


import java.time.LocalDate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Transaction1 {
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Tid;
private int Tamount;
private String TType;
private int TotalAmount;
public int getTotalAmount() {
	return TotalAmount;
}
public void setTotalAmount(int totalAmount) {
	TotalAmount = totalAmount;
}
private LocalDate date;
public int getTid() {
	return Tid;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public void setTid(int tid) {
	Tid = tid;
}
public int getTamount() {
	return Tamount;
}
public void setTamount(int tamount) {
	Tamount = tamount;
}
public String getTType() {
	return TType;
}
public void setTType(String tType) {
	TType = tType;
}

}
