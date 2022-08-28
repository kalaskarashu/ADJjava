package model;

public class Account {
double amount;
int id;

public Account(double amount, int id) {
	super();
	this.amount = amount;
	this.id = id;
}

public Account() {
	// TODO Auto-generated constructor stub
}




public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public void setWithdrawn(double a1)
{
	this.amount=this.amount-a1;
}
public void setDeposite(double a1,double a2)
{
	this.amount=a1+a2;
}

public void setId(int i) {
	// TODO Auto-generated method stub
	
}

public int getId() {
	// TODO Auto-generated method stub
	return 0;
}

}
