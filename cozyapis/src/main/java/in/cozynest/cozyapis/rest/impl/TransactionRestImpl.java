package in.cozynest.cozyapis.rest.impl;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.Transaction;
import in.cozynest.cozyapis.rest.ITransactionRest;
import in.cozynest.cozyapis.service.ITransactionService;
import in.cozynest.cozyapis.service.impl.TransactionServiceImpl;

@Path("transaction")
@Produces ("application/json")	
public class TransactionRestImpl implements ITransactionRest {

	ITransactionService transactionService = new TransactionServiceImpl();	

	@GET
	@Path("findall")
	@Override
	public ArrayList<Transaction> findAll() {
		ArrayList<Transaction> transactions = transactionService.findAll();
		if(transactions==null)
			throw new NotFoundException("No records found");	
		return transactions;
	}

	@GET
	@Path("findbyid/{id}")
	@Override
	public Transaction findById(@PathParam("id") int id) {
		Transaction transaction = transactionService.findById(id);
		if(transaction==null)
			throw new NotFoundException("No records found with this id");	
		return transaction;
	}

}