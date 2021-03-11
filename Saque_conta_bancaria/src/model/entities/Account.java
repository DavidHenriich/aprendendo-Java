package model.entities;

import model.exceptions.DepositException;
import model.exceptions.LimitException;
import model.exceptions.WithdrawException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() throws LimitException {
		if(withdrawLimit < 0) {
			throw new LimitException("o limite de saque deve ser um valor positivo.");			
		}
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws LimitException {
		if(withdrawLimit < 0) {
			throw new LimitException("o limite de saque deve ser um valor positivo.");			
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) throws DepositException {
		if(amount < 0) {
			throw new DepositException("Valor invalido para deposito.");
		}
		balance += amount;
	}

	public void withdraw(Double amount) throws WithdrawException {
		if(amount < 0) {
			throw new WithdrawException("valor de saque deve ser positivo.");
		}
		
		if(amount > withdrawLimit) {
			throw new WithdrawException("valor excede o limite de retirada.");
		}
		
		if(balance < amount) {
			throw new WithdrawException("saldo insuficiente.");
		}
		balance -= amount;
	}
	
}
