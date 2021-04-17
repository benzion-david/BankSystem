import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BankSystem {
	// private List<Client> clients = new ArrayList<>();

	private static BankSystem instance = null;
	private InterestTask task;
	private Set<Client> clients = new TreeSet<Client>();
	public static Scanner scanner = new Scanner(System.in);

	private BankSystem() {
		new Thread(task).start();
	}

	public static BankSystem getInstance() {
		if (instance == null) {
			synchronized (BankSystem.class) {
				if (instance == null) {
					instance = new BankSystem();
				}
			}

		}
		return instance;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void printClients() {
		for (Client client : clients) {
			System.out.println(client);
		}
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public void addClient() {
		String clientType;
		System.out.println("For regularclient press R , For vipclient press V");
		clientType = scanner.next();
		if (clientType.equals("R")) {
			addClient(new RegularClient());
		} else {
			addClient(new VipClient());
		}
		System.out.println("client added successfully");
		clients.forEach(System.out::println);
		// ShowMenu();

	}

	public void deleteClient(int id) throws Exception {
		for (Client client : clients) {
			if (client.getId() == id) {
				if (client.getAccount().getBalance() < 0) {
					throw new Exception();
				}
				clients.remove(client);
			}
		}
	}

	public void withDraw(double amount, int id) {
		for (Client client : clients) {
			if (client.getId() == id) {
				client.getAccount().setBalance(client.getAccount().getBalance() - amount);
			}
		}
	}

	public void deposite(double amount, int id) {
		for (Client client : clients) {
			if (client.getId() == id) {
				client.getAccount().setBalance(client.getAccount().getBalance() + amount);
			}
		}
	}

	public Client richestClient() {
		return BankSystem.getInstance().getClients().stream().max(new Comparator<Client>() {
			@Override
			public int compare(Client o1, Client o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getAccount().getBalance() - o2.getAccount().getBalance());
			}
		}).get();
	}

	public Client poorestClient() {
		return BankSystem.getInstance().getClients().stream().min(new Comparator<Client>() {
			@Override
			public int compare(Client o1, Client o2) {
				return (int) (o1.getAccount().getBalance() - o2.getAccount().getBalance());
			}
		}).get();
	}

	public void ShowMenu() {
		System.out.println("Choose 1 to : Add Client");
		System.out.println("Choose 2 to : Delete Client");
		System.out.println("Choose 3 to : Withdraw");
		System.out.println("Choose 4 to : Deposit");
		System.out.println("Choose 5 to : Show all clients");
		System.out.println("Choose 6 to : Wealthiest");
		System.out.println("Choose 7 to : Poorest client");
		System.out.println("Choose 8 to : Show bank resources");
		System.out.println("Choose 9 to : Exit");
	}

	public void startSystem() throws Exception {
		int input = 0;
		while (input != 9) {
			ShowMenu();
			input = scanner.nextInt();
			actions(input);
		}
	}

	private void actions(int input) throws Exception {
		try {
			switch (input) {
			case 1:
				addClient();
				break;
			case 2:
				System.out.println("Enter client's ID for deletion:");
				int id_todelete = scanner.nextInt();
				deleteClient(id_todelete);
				break;
			case 3:
				System.out.println("Please  enter id ");
				int id_towithdraw = scanner.nextInt();
				System.out.println("Please enter amount to deposite");
				double amount = scanner.nextDouble();
				withDraw(amount, id_towithdraw);
				break;
			case 4:
				System.out.println("Please  enter id ");
				int id_deposite = scanner.nextInt();
				System.out.println("Please enter amount to deposite");
				double amount_2 = scanner.nextDouble();
				deposite(amount_2, id_deposite);
				break;
			case 5:
				System.out.println("All the clients sorted by balance : ");
				BankSystem.getInstance().getClients().stream().sorted(new Comparator<Client>() {
					@Override
					public int compare(Client o1, Client o2) {
						return (int) (o1.getAccount().getBalance() - o2.getAccount().getBalance());
					}
				}).forEach(System.out::println);
				break;
			case 6:
				System.out.println("The richest client is : ");
				System.out.println(richestClient().toString());
				break;
			case 7:
				System.out.println("The poorest is : ");
				System.out.println(poorestClient().toString());
				break;
			case 8:
				System.out.println("The total balance is");
				System.out.println(BankSystem.getInstance().getClients().stream()
						.mapToDouble(c -> c.getAccount().getBalance()).sum());
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void endSystem() {
		System.out.println("Bye Bye");
	}

}
