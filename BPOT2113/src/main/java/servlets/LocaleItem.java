package servlets;

import java.util.Locale;

public class LocaleItem implements LocaleInterface {
	
    private int m_iLocaleID;

    private String m_strLocaleName;

    private LanguageItem m_objLanguageItem;

    private CountryItem m_objCountryItem;

    private Locale m_objLocale;
	

	@Override
	public int getLocaleID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLocaleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LanguageInterface getLanguageItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryInterface getCountryItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
