package servlets;


public interface LocaleInterface {

	  public int getLocaleID();
	  
	  public String getLocaleName();
	  
	  public LanguageInterface getLanguageItem();

	  public CountryInterface getCountryItem();
}
