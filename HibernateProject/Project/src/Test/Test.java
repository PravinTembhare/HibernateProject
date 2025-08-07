package Test;

import java.util.Scanner;

import Model.SBI;

public class Test {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	boolean t=true;
	SBI s=new SBI();
	do {
System.out.println("Enter what do you want to do ");
System.out.println("1.Create Account  2.DepositAmount 3.widthrowAmount  4.DelateAcouint 5.Seedtail  6.CheckBalance  7.NO");
int c=sc.nextInt();
if(c==1) {
	s.CreateAccount();
}else if(c==2) {
	s.DepositAmount();
}else if(c==3) {
	s.WidthrowAmount();
}else if(c==4) {
	s.DeleateAccount();
}else if(c==5) {
	s.SeeDetails();
}else if(c==6) {
	s.CheckBalance();
}else if(c==7) {
	t=false;
}else {
	System.out.println("Put proper input");
}



	}while(t==true);
	System.out.println("Thank you");
}
}
