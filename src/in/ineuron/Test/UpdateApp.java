package in.ineuron.Test;
import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;


public class UpdateApp {

	public static void main(String[] args) {
		
		Session session = null; 
		Transaction transaction = null;
		Long id = 1L;
		boolean flag = false;
		BankAccount account = null;
		
		try {
			session = HibernateUtil.getSession();
			account = session.get(BankAccount.class, id);
			
			System.out.println("Account Before Updation:: " + account);
			
			if(session != null)
				transaction = session.beginTransaction();	
			
			if(transaction != null) {
				if(account != null) {
					account.setAccBal(account.getAccBal() + 10000);
					
					session.update(account);
					flag = true;
				}
				else {
					System.out.println("Record Not Available for the given id:: " + id);
					System.exit(0);
				}
			}
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {			
			
			if(flag) {
				transaction.commit();
				System.out.println("Object Updated to the Database...");
				System.out.println("Account Openeing Date:: " + account.getOpeingDate());
				System.out.println("Account Last Modified:: " + account.getLastUpdate());
				System.out.println("Account Modified:: " + account.getCount() + " times.");
			}
			else {
				transaction.rollback();
				System.out.println("Object Failed to Update...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
