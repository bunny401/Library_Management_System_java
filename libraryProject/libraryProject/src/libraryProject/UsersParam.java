package libraryProject;

import java.io.Serializable;

public class UsersParam implements Serializable {
		  /**
		 * 
		 *  
		 */
	public String name;
		public String username;
		public String password;
		public String role_;
		 
		private static final long serialVersionUID = 1L;
		
		public UsersParam(String namee,String uname, String pass, String role) {
			name=namee;
			username = uname;
			password = pass;
	        role_ = role;
	        
		}

		
}
