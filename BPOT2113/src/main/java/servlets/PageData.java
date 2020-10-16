package servlets;

import java.io.Serializable;
import java.util.HashMap;

public class PageData implements Serializable {
	
	  private User user;
	private HashMap hmPageData;

	public PageData(User user, String strPageName) {
		    this.user = user;
		    hmPageData = new HashMap();
		    hmPageData.put("pageName", strPageName);
		}

	  public String getPageName() {
		    return (String)hmPageData.get("pageName");
		  }
	  
	  public Data getData(String strName) {
		    return (Data)hmPageData.get(strName);
		  }

	  public void putData(String strName, Data value) {
		    if (value != null) {
		      hmPageData.put(strName, value);
		    }
	  }
	  
	  public Object getValue(String strName) {
		    return hmPageData.get(strName);
		  }
	  
	  public void putValue(String strName, Object value) {
		    if (value != null) {
		      hmPageData.put(strName, value);
		    }
		  }
	  
}
