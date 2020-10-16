package servlets;

public abstract class StatusMessage {

	  /**
	   * Gets the messageType attribute of the StatusMessage object
	   *
	   * @return    The messageType value
	   */
	  public int getMessageType() {
	    return m_iMessageType;
	  }

	  /**
	   * Gets the message attribute of the StatusMessage object
	   *
	   * @return    The message value
	   */
	  public String getMessage() {
	    return m_strMessage;
	  }

	  /**
	   * Description of the Field
	   */
	  protected int m_iMessageType;

	  /**
	   * Description of the Field
	   */
	  protected String m_strMessage;

	  /**
	   * Description of the Field
	   */
	  public final static int MSG_TYPE_INFO = 0;

	  /**
	   * Description of the Field
	   */
	  public final static int MSG_TYPE_ERROR = 1;
	
}
