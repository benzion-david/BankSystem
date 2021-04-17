
public abstract class Client extends Person implements Comparable<Client> {
	private float interestRate;
	private Account account;

	public Client(float interestRate) {
		super();
		this.interestRate = interestRate;
		setAccount(new Account());
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return " [interestRate=" + interestRate + ", account=" + account + " " + super.toString() + "]";
	}

}
