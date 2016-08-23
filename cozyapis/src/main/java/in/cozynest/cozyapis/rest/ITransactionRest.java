package in.cozynest.cozyapis.rest;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.Transaction;

public interface ITransactionRest {
	
	public ArrayList<Transaction> findAll();
	
	public Transaction findById(int id);
}