package libraryProject;

import java.io.Serializable;

public class issueBooksParam implements Serializable {

      
		public String username;
		public String bid;
		public String period;
		public String issued_date;
		private static final long serialVersionUID = 1L;
		
		public issueBooksParam(String _username, String _bid, String _period, String _issued_date) {
			
			username = _username;
			bid = _bid;
			period = _period;
			issued_date=_issued_date;
			// TODO Auto-generated constructor stub
		}

		
		
		

	}
