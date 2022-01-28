package libraryProject;

import java.io.Serializable;

public class ReturnBookParam implements Serializable {

    
	public String username;
	public String bid;
	public String period;
	public String issued_date;
	public String return_date;
	public String Fine;
	private static final long serialVersionUID = 1L;
	
	public ReturnBookParam(String _username, String _bid, String _period, String _issued_date, String _return_date, String _Fine) {
		
		username = _username;
		bid = _bid;
		period = _period;
		issued_date=_issued_date;
		return_date = _return_date;
		Fine =_Fine;
		// TODO Auto-generated constructor stub
	}


}
