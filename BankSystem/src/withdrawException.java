import java.sql.Date;

public class withdrawException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date timeStamp;

	public withdrawException(String messege, Date timeStamp, int clientID, String clientName, double balance) {
		super(messege);
		this.timeStamp = timeStamp;
	}
}
