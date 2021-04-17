
public class BankUtils {
	public static void setBankClients(BankSystem bank, int numClients) {
		while (bank.getClients().size() < numClients) {
			bank.getClients().add(new RegularClient());
			bank.getClients().add(new VipClient());
		}
	}
}
