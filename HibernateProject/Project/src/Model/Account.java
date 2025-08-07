package Model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Account {
	@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private int accid;
private int accno;
private String Name;
private int amount;
@OneToMany(cascade=CascadeType.ALL)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
private Set<Transaction1> TL=new HashSet<>();
private int Adharno;
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public Set<Transaction1> getTL() {
	return TL;
}
public void setTL(Set<Transaction1> tL) {
	TL = tL;
}

public int getAccid() {
	return accid;
}
public void setAccid(int accid) {
	this.accid = accid;
}
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getAdharno() {
	return Adharno;
}
public void setAdharno(int adharno) {
	Adharno = adharno;
}


}
