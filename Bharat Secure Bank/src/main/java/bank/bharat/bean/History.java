package bank.bharat.bean;

import java.sql.Date;

public class History {

	String txn_id, sender_acc,reciver_acc,txn_type,description,status;
	double amount;
	Date date;
	
	public History() {
		
	}

	public String getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}

	public String getSender_acc() {
		return sender_acc;
	}

	public void setSender_acc(String sender_acc) {
		this.sender_acc = sender_acc;
	}

	public String getReciver_acc() {
		return reciver_acc;
	}

	public void setReciver_acc(String reciver_acc) {
		this.reciver_acc = reciver_acc;
	}

	public String getTxn_type() {
		return txn_type;
	}

	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [txn_id=" + txn_id + ", sender_acc=" + sender_acc + ", reciver_acc=" + reciver_acc
				+ ", txn_type=" + txn_type + ", description=" + description + ", status=" + status + ", amount="
				+ amount + ", date=" + date + "]";
	}
	
	
	
}
