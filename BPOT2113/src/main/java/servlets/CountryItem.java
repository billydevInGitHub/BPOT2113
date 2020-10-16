package servlets;

public class CountryItem implements CountryInterface {
	
	  private String m_countryID="CA";
	  private String m_countryName="Canada";

	@Override
	public String getCountryID() {
		// TODO Auto-generated method stub
		return m_countryID;
	}

	@Override
	public String getCountryName() {
		// TODO Auto-generated method stub
		return m_countryName;
	}

}
