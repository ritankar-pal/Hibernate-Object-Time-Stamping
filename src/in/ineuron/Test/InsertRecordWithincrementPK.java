package in.ineuron.Test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;


public class InsertRecordWithincrementPK {

	public static void main(String[] args) {
		
		Session session = null; 
		Transaction transaction = null;
		boolean flag = false;
		Long id = null;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				 transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				BankAccount account = new BankAccount();
				account.setAccName("Varun");
				account.setAccBal(6589745.500);
				account.setAccType("savings");
				
				id = (Long)session.save(account);
				flag = true;
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
				System.out.println("Object Inserted to the database with the PK ID:: " + id);
			}
			else {
				transaction.rollback();
				System.out.println("Object failed to Insert...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
