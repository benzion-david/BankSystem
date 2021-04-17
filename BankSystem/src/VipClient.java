
public class VipClient extends Client {

	public VipClient() {
		super(0.1f);

	}

	@Override
	public String toString() {
		return "VipClient [" + super.toString();
	}

	@Override
	public int compareTo(Client other) {
		// TODO Auto-generated method stub
		return this.getId() - other.getId();
	}

}
