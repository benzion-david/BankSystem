import java.sql.Date;

public class deleteException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date timeStamp;

	public deleteException(String messege, Date timeStamp, int clientID, String clientName, double balance) {
		super(messege);
		this.timeStamp = timeStamp;
	}

}
