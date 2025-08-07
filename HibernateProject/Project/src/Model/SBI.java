package Model;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Interface1.BankF;
import Model.Account;

public  class SBI implements BankF {
	public void CreateAccount() {
		Session s=HibernateUtil.getSessionFactory().openSession();
	Account a=new Account();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Account for your account Number");
	a.setAccno(sc.nextInt());
	System.out.println("Enter the your name");
	a.setName(sc.next()+sc.nextLine());
	System.out.println("Enter the Adhar Number");
	a.setAdharno(sc.nextInt());
	System.out.println("Enter the Account Amount");
	a.setAmount(sc.nextInt());
	String hql="from Account where Adharno=?1";
	Query<Account> r=s.createQuery(hql,Account.class);
	r.setParameter(1, a.getAdharno());
	
	Account a1=null;
	try {
		 a1=r.getSingleResult();
	}catch(Exception e) {
		
	}
	
	if(a1!=null) {
		System.out.println("Account is already exist");
	}else {
	s.persist(a);
	s.beginTransaction().commit();
	
	s.close();
	}
}
	
	public void DepositAmount() {
	Session s=HibernateUtil.getSessionFactory().openSession();
	Transaction t=s.beginTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Account No");
	int accno=sc.nextInt();
	System.out.println("Enter the amount do you want deposit");
	int amount=sc.nextInt();
	String hql="from Account where accno=?1";
	Query<Account> r=s.createQuery(hql,Account.class);
	r.setParameter(1,accno);
	r.setCacheable(true);
	Account a=r.getSingleResult();
	if(a!=null) {
	a.setAmount(a.getAmount()+amount);
	System.out.println("____________________________________");
	System.out.println("Trasaction is successfull");
	
	
	Transaction1 T1=new Transaction1();
	T1.setTamount(amount);
	T1.setTotalAmount(a.getAmount());
	T1.setTType("Deposit");
	System.out.println("Enter the date");
	String sd=sc.next()+sc.nextLine();
	LocalDate d=LocalDate.parse(sd);
	T1.setDate(d);
	a.getTL().add(T1);
	s.persist(T1);
	t.commit();
	}else {
		System.out.println("Your account is not presente");
	}
	s.close();

}
	
	
	
	public void SeeDetails() {
	Scanner sc=new Scanner(System.in);
	Session s=HibernateUtil.getSessionFactory().openSession();
	System.out.println("Enter the account no");
	int accno=sc.nextInt();
	String hql="from Account where accno=?1";
	Query<Account> r=s.createQuery(hql,Account.class);
	r.setParameter(1, accno);
	r.setCacheable(true);
	Account a=r.getSingleResult();
	if(a!=null) {
	System.out.println(a.getName());
	System.out.println(a.getAdharno());
	System.out.println(a.getAmount());
	System.out.println(a.getAccid());
	System.out.println(a.getAccno());
	for(Transaction1 t:a.getTL()) {
		System.out.println("____________________________________");
		System.out.println(t.getDate()+" Date");
		System.out.println(t.getTotalAmount()+" TotalAmount");
		System.out.println(t.getTamount()+" Amounte");
		System.out.println(t.getTType()+" Type");
		System.out.println(t.getTid()+" Id");
		System.out.println("____________________________________");
	}
	}else {
		System.out.println("Your acount is not present");
	}
	s.close();
}
	
	
	
public void CheckBalance() {
	
	Scanner sc=new Scanner(System.in);
	Session s=HibernateUtil.getSessionFactory().openSession();
	System.out.println("Enter the account no");
	int accno=sc.nextInt();
	String hql="from Account where accno=?1";
	Query<Account> r=s.createQuery(hql,Account.class);
	r.setParameter(1, accno);
	r.setCacheable(true);
	Account a=r.getSingleResult();
	if(a!=null) {
		System.out.println("Your balance is "+a.getAmount());
	}else {
		System.out.println("your account is not present");
	}
	s.close();	
	
}






public void DeleateAccount() {
	Session s=HibernateUtil.getSessionFactory().openSession();
	Transaction t=s.beginTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Account No You want to deleate");
	int accno=sc.nextInt();
	String hql="from Account where accno=?1";
	Query<Account> r=s.createQuery(hql,Account.class);
	r.setParameter(1,accno);
	r.setCacheable(true);
	Account a=r.getSingleResult();
	if(a!=null) {
		s.remove(a);
		t.commit();
	}else {
		
	}
	s.close();
	
}
public void WidthrowAmount() {
	Session s=HibernateUtil.getSessionFactory().openSession();
	Transaction t=s.beginTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Account No");
	int accno=sc.nextInt();
	String hql="from Account where accno=?1";
	Query<Account> r=s.createQuery(hql,Account.class);
	r.setParameter(1,accno);
	r.setCacheable(true);
	Account a=r.getSingleResult();
	if(a!=null) {
	
	System.out.println("Enter the amount do you want widthrow");
	int amount=sc.nextInt();
	if(amount<a.getAmount()) {
		
		a.setAmount(a.getAmount()-amount);
		System.out.println("____________________________________");
		System.out.println("Trasaction is successfull");

		Transaction1 T2=new Transaction1();
		T2.setTamount(amount);
		T2.setTotalAmount(a.getAmount());
		T2.setTType("Widthrow");
		System.out.println("Enter the date");
		String sd=sc.next()+sc.nextLine();
		LocalDate d=LocalDate.parse(sd);
		T2.setDate(d);
		a.getTL().add(T2);
		s.persist(T2);
		t.commit();	
		
		
		
	}else {
		System.out.println("You dont have sufficient amount");
	}
	
	
	
	}else {
		System.out.println("Your account is not present");
	}
	
	s.close();
	
}


}
