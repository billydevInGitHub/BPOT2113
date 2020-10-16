/*
 *  NOTICE:
 *  THIS MATERIAL CONTAINS TRADE SECRETS THAT BELONGS TO ALLTEL INFORMATION
 *  SERVICES, INC. AND IS LICENSED BY AN AGREEMENT. ANY UNAUTHORIZED ACCESS,
 *  USE, DUPLICATION, OR DISCLOSURE IS UNLAWFUL.
 *
 *  COPYRIGHT (C) 2000
 *  BY
 *  ALLTEL INFORMATION SERVICES
 *  ONE ALLTEL CENTER
 *  PO BOX 1622
 *  ALPHARETTA, GA 30009-1622
 *
 * MODULE: SignOnData
 * DESCRIPTION:
 * AUTHOR: User Garage, Nelson Nittala
 * DATE:  June 21, 2000
 * HISTORY:
 */
package servlets;

public class SignOnData implements java.io.Serializable {
    /**
     * Default Constructor.
     *
     * @author    npn260, User Garage
     */
    public SignOnData() {
        m_strPrevUserId = "";
        m_iNoOfAttempts = 0;
    }

    /**
     *  Mutator for m_iNoOfAttempts
     *
     * @param  iNoOfAttempts  A int of SignOn No Of Attempts
     * @since                 Release 4.0
     */
    public void setNoOfAttempts(int iNoOfAttempts) {
        m_iNoOfAttempts = iNoOfAttempts;
    }

    /**
     *  Accessor for m_iNoOfAttempts
     *
     * @return    int of m_iNoOfAttempts
     * @since     Release 4.0
     */
    public int getiNoOfAttempts() {
        return m_iNoOfAttempts;
    }

    /**
     * @param  strPrevUserId  The new prevUserId value
     * @since                 Release 4.0
     */
    public void setPrevUserId(String strPrevUserId) {
        m_strPrevUserId = strPrevUserId;
    }

    /**
     * @return    String of Link Prev Acct Nbr
     * @since     Release 4.0
     */
    public String getPrevUserId() {
        return m_strPrevUserId;
    }

    /**
     *  private member data used to store SignOn User Id
     */
    private String m_strPrevUserId;

    /**
     *  private member data used to store SignOn Number of Attempts
     */
    private int m_iNoOfAttempts;
}
/*
 *  $Header: /Billydev080107/MyCVS/AP_MiniEbill/src/com/billydev/meb/security/servlets/SignOnData.java,v 1.1 2014/06/28 22:12:18 bli Exp $
 *  $Log: SignOnData.java,v $
 *  Revision 1.1  2014/06/28 22:12:18  bli
 *  Make a user login logic
 *
 *  Revision 1.3  2004/04/13 21:50:43  gromman
 *  Convert file format to DOS
 *
 *  Revision 1.2  2004/01/22 21:31:23  krozinsk
 *  Connection fix and some cleanup
 *
 *  Revision 1.1.1.1  2003/12/17 17:48:44  ebilldev
 *  Create eB3
 *
 *  Revision 1.1  2003/01/02 13:41:25  rdow
 *  *** empty log message ***
 *
 *  Revision 1.1.1.1  2002/12/13 22:45:10  rdow
 *  no message
 *
 *  Revision 1.3  2002/07/11 20:46:21  rdow
 *  Cleanup, use (and close) PreparedStatement, simplify logic, reduce duplicate code.
 *
 *  Revision 1.2  2002/05/08 18:05:59  gromman
 *  Reformat with jefactory - PrettyPrinter.java
 *
 *  Revision 1.1.1.1  2002/03/13 18:54:54  blomquist
 *  no message
 *
 *  Revision 1.2  2001/11/14 22:56:22  rdow
 *  MTS base from Rhapsody module.
 *
 *  Revision 1.1.1.1  2001/08/22 22:51:58  rdow
 *  no message
 *
 */
