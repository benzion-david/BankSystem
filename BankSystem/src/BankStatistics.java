
public class BankStatistics {
	public static int countMembers() {
		System.out.println("The number of clients in the bank is : ");
		return BankSystem.getInstance().getClients().size();
	}

	public static double getBalance() {
		System.out.println("The total balance is");
		return BankSystem.getInstance().getClients().stream().mapToDouble(c -> c.getAccount().getBalance()).sum();
	}

	public static Client getRichestClient() {
		System.out.println("The richest client is : ");
		return BankSystem.getInstance().richestClient();
	}

	public static Client getPoorestClient() {
		System.out.println("The poorest client is : ");
		return BankSystem.getInstance().poorestClient();
	}

}
