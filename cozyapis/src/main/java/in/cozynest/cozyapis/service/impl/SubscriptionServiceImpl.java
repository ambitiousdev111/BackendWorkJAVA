package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;
import java.util.Date;

import in.cozynest.cozyapis.dao.ISubscriptionDao;
import in.cozynest.cozyapis.dao.impl.SubscriptionDaoImpl;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.model.Subscription;
import in.cozynest.cozyapis.model.Transaction;
import in.cozynest.cozyapis.model.Transaction.PaymentType;
import in.cozynest.cozyapis.model.Transaction.TransactionType;
import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.model.UserWallet;
import in.cozynest.cozyapis.service.ISubscriptionService;

public class SubscriptionServiceImpl implements ISubscriptionService {

	ISubscriptionDao subscriptionDao = new SubscriptionDaoImpl();

	public boolean exists(int pk) {
		return subscriptionDao.exists(pk);
	}

	public long count() {
		return subscriptionDao.count();
	}

	public Subscription create(Subscription subscription) {
		return subscriptionDao.create(subscription);
	}

	public Subscription createNewSubscription(Subscription subscription) {

		Subscription newSubscription = subscriptionDao.create(subscription);
		
		UserWallet userWallet = new UserWalletServiceImpl()
				.findByUserId(subscription.getOrder().getUser().getId());
		if(userWallet == null)
			throw new InternalServerErrorException("Unable to add subscription : User not found");

		if (userWallet.getAmount() >= 0) {
			double deductedAmount = 0;
			if (userWallet.getAmount() >= subscription.getSubscriptionPlan().getPakage().getCost()) {
				userWallet.setAmount(userWallet.getAmount() - subscription.getSubscriptionPlan().getPakage().getCost());
				deductedAmount = subscription.getSubscriptionPlan().getPakage().getCost();
				userWallet = new UserWalletServiceImpl().update(userWallet);
				if(userWallet == null)
					throw new InternalServerErrorException("Unable to deduct from wallet");
				Transaction transaction = new Transaction();
				transaction.setAmount(deductedAmount);
				transaction.setDate(new Date());
				transaction.setOrder(newSubscription.getOrder());
				transaction.setPaymentType(PaymentType.WALLET);
				transaction.setTransactionType(TransactionType.CREDIT);
				transaction.setRemark("Transaction for orderId : " + newSubscription.getOrder().getId());

				if ((new TransactionServiceImpl().create(transaction)) == null)
					throw new InternalServerErrorException("Unable to add transaction for subscription id :"
							+ newSubscription.getId() + " and orderId :" + newSubscription.getOrder().getId());

			} else {
				userWallet.setAmount(0);
				deductedAmount = userWallet.getAmount();
				userWallet = new UserWalletServiceImpl().update(userWallet);
				if(userWallet == null)
					throw new InternalServerErrorException("Unable to deduct from wallet");
				Transaction transaction = new Transaction();
				transaction.setAmount(deductedAmount);
				transaction.setDate(new Date());
				transaction.setOrder(newSubscription.getOrder());
				transaction.setPaymentType(PaymentType.WALLET);
				transaction.setTransactionType(TransactionType.CREDIT);
				transaction.setRemark("Transaction for orderId : " + newSubscription.getOrder().getId());

				if ((new TransactionServiceImpl().create(transaction)) == null)
					throw new InternalServerErrorException("Unable to add transaction for subscription id :"
							+ newSubscription.getId() + " and orderId :" + newSubscription.getOrder().getId());

				Transaction transaction1 = new Transaction();
				transaction1.setAmount(subscription.getSubscriptionPlan().getPakage().getCost() - deductedAmount);
				transaction1.setDate(new Date());
				transaction1.setOrder(newSubscription.getOrder());
				transaction1.setPaymentType(PaymentType.COD);
				transaction1.setTransactionType(TransactionType.CREDIT);
				transaction1.setRemark("Transaction for orderId : " + newSubscription.getOrder().getId());

				if ((new TransactionServiceImpl().create(transaction1)) == null)
					throw new InternalServerErrorException("Unable to add transaction for subscription id :"
							+ newSubscription.getId() + " and orderId :" + newSubscription.getOrder().getId());

			}

		} else {
			Transaction transaction = new Transaction();
			transaction.setAmount(newSubscription.getSubscriptionPlan().getPakage().getCost());
			transaction.setDate(new Date());
			transaction.setOrder(newSubscription.getOrder());
			transaction.setPaymentType(PaymentType.COD);
			transaction.setTransactionType(TransactionType.CREDIT);
			transaction.setRemark("Transaction for orderId : " + newSubscription.getOrder().getId());

			if ((new TransactionServiceImpl().create(transaction)) == null)
				throw new InternalServerErrorException("Unable to add transaction for subscription id :"
						+ newSubscription.getId() + " and orderId :" + newSubscription.getOrder().getId());
		}
		return newSubscription;

	}

	public Subscription update(Subscription subscription) {
		return subscriptionDao.update(subscription);
	}

	public void delete(Subscription subscription) {
		subscriptionDao.delete(subscription);
	}

	public ArrayList<Subscription> findAll() {
		return subscriptionDao.findAll();
	}

	public Subscription findById(int id) {
		return subscriptionDao.findById(id);
	}

	public ArrayList<Subscription> findByStatus(String status) {
		return subscriptionDao.findByStatus(status);
	}

	public ArrayList<Subscription> findByStartDate(String startDate) {
		return subscriptionDao.findByStartDate(startDate);
	}

	public ArrayList<Subscription> findByEndDate(String endDate) {
		return subscriptionDao.findByEndDate(endDate);
	}

	public ArrayList<Subscription> findByPlanType(String planType) {
		return subscriptionDao.findByPlanType(planType);
	}

	public ArrayList<Subscription> findByUserId(int userId) {
		return subscriptionDao.findByUserId(userId);
	}

	public ArrayList<Subscription> findByGeneratedUserId(String generatedUserId) {
		return subscriptionDao.findByGeneratedUserId(generatedUserId);
	}
	
	public ArrayList<Subscription> findByPhone(String phone) {
		return subscriptionDao.findByPhone(phone);
	}

	public ArrayList<Subscription> findByOrderId(int orderId) {
		return subscriptionDao.findByOrderId(orderId);
	}

	public ArrayList<Subscription> findTodaysDeliveriesByCurrentDateAndCurrentShift(String date,
			String subscriptionShift, String cancelShift) {
		return subscriptionDao.findTodaysDeliveriesByCurrentDateAndCurrentShift(date, subscriptionShift, cancelShift);
	}

	@Override
	public ArrayList<User> findByEndDateAndEndShift(String endDate, String endShift) {
		return subscriptionDao.findByEndDateAndEndShift(endDate, endShift);
	}

	@Override
	public ArrayList<Subscription> findByPlanDuration(String planDuration) {
		return subscriptionDao.findByPlanDuration(planDuration);
	}

}