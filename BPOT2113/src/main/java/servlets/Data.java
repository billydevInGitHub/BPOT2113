package servlets;

public interface Data {

	  public String getType();
	  
	  public String getName();

	  public String getLabel();
	  
	  public String getURL();
	  
	  public int getWidth();
	  
	  public String getAlign();
	  
	  public String format() throws Exception;
}
