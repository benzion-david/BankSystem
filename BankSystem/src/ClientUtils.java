
public class ClientUtils {
	public static void setClientDetails(BankSystem bank) {
		for (Client client : bank.getClients()) {
			client.setName(String.valueOf(client.getId()));
			client.setAge(BenziUtils.randIntBetween(16, 120));

		}
	}

}
