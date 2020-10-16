package servlets;

public class LanguageItem implements LanguageInterface {
	
	  private String m_strLanguageID="EN";
	  private String m_strLanguageName="English";
	  private String m_strLanguageCode="EN";

	@Override
	public String getLanguageID() {
		// TODO Auto-generated method stub
		return m_strLanguageID;
	}

	@Override
	public String getLanguageName() {
		// TODO Auto-generated method stub
		return m_strLanguageName;
	}

	@Override
	public String getLanguageCode() {
		// TODO Auto-generated method stub
		return m_strLanguageCode;
	}

}
