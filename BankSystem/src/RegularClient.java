
public class RegularClient extends Client {

	public RegularClient() {
		super(0.05f);
	}

	@Override
	public String toString() {
		return "RegularClient [" + super.toString();
	}

	@Override
	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		return this.getId() - o.getId();
	}

}
