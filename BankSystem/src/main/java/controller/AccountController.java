package controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

class insufficientBalanceException extends RuntimeException
{
	public insufficientBalanceException()
	{

	}
	public insufficientBalanceException(String str)
	{
		super(str);
	}

}

@Entity
@Table (name="bank")
public class AccountController {
@Id
@Column(name="Id")
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
@Column(name="amount")	
double amount;
public AccountController() {
	// TODO Auto-generated constructor stub
}

public AccountController(double amount) {
	super();
	this.amount = amount;
}

public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

@Override
public String toString() {
	return "AccountController [Balance=" + amount + "]";
}
public double setDeposite(double amount)
{
 return	this.amount=this.amount+amount;
}
public void setWithdrawn(double amount)
{
	if(amount>this.amount)
	{
		 throw new insufficientBalanceException("Insufficient Balance:"+this.amount); 
	}
	else
	{
		 this.amount=this.amount-amount;
	}
}


}
