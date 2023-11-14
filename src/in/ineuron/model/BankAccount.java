package in.ineuron.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class BankAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accNo;
	
	private String accName; 
	private Double accBal; 
	private String accType; 
	
	@CreationTimestamp
	private LocalDateTime opeingDate; 
	
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	@Version
	private Integer count;
	
	public BankAccount() {
		System.out.println("Bank Account Objectis Instantiated...");
	}	
	
	
	public Long getAccNo() {
		return accNo;
	}

	public String getAccName() {
		return accName;
	}

	public Double getAccBal() {
		return accBal;
	}

	public String getAccType() {
		return accType;
	}

	public LocalDateTime getOpeingDate() {
		return opeingDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public Integer getCount() {
		return count;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public void setAccBal(Double accBal) {
		this.accBal = accBal;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setOpeingDate(LocalDateTime opeingDate) {
		this.opeingDate = opeingDate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accName=" + accName + ", accBal=" + accBal + ", accType=" + accType
				+ ", opeingDate=" + opeingDate + ", lastUpdate=" + lastUpdate + ", count=" + count + "]";
	}

}
