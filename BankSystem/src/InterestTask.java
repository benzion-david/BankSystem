
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class InterestTask implements Runnable {
	private Set<Client> clients = new TreeSet<>();

	private static boolean killThread = false;

	public InterestTask(Set<Client> clients) {
		this.clients = clients;
	}

	@Override
	public void run() { // TODO ASK KOBI WHY CAN'T WE SURROUND INSIDE WITH TRY & CATCH?
		System.out.println(Thread.currentThread().getClass().getSimpleName() + " STARTED");
		while (!killThread) {
			try {
				Thread.sleep(1000 * 60 * 60 * 24); // KOBI, FEEL FREE TO COMMENT THIS LINE FOR TESTING!
//				Thread.sleep(15000); // KOBI, FEEL FREE TO UNCOMMENT THIS LINE FOR TESTING!
				updateClientsBalancesForThread(clients);
				System.out.println("ALL CLIENTS BALANCES UPDATED DUE TO INTEREST TASK");
				System.out.println("PRINTING CLIENTS AFTER UPDATING BALANCES");
				BankSystem.getInstance().printClients();
				System.out.println(Thread.currentThread().getClass().getSimpleName() + " WENT TO SLEEP");
				System.out.println(new Date());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void updateClientsBalancesForThread(Set<Client> clients)
			throws deleteException, withdrawException, Exception {
		for (Client c : clients) {
			double currBalance = c.getAccount().getBalance();
			double interestToDouble = c.getInterestRate();
			c.getAccount().setBalance(currBalance + (currBalance * interestToDouble / 100));
		}
	}

	public static void stop() {
		killThread = true;
	}
}