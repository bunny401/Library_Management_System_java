package libraryProject;

import java.io.Serializable;

public class BooksParameters implements Serializable {
	  /**
	 * 
	 *  
	 */
	public String book_id;
	public String bname;
	public String genre;
	public String price;
	private static final long serialVersionUID = 1L;
	
	public BooksParameters(String bookid, String bname2, String genre2, String price2) {
		
		book_id = bookid;
		bname = bname2;
        genre = genre2;
        price = price2;
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.bname = name;
		 
	}

	public void setgenre(String gen) {
		this.genre = gen;
		 
	}
	public void setprice(String pric) {
		this.price = pric;
		 
	}
	
	

}
