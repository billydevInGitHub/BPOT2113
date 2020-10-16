
<form name="SignOnCtlr" action="SignOnCtlr" method="post" autocomplete="off">
	<input type="hidden" name="FORGOT_PASSWORD" value="FALSE">
  <table width="450" border="1" cellpadding="0" hspace="0" vspace="0" cellspacing="0" align="left">
    <tr>
      <td colspan="4" align="left"></td>
    </tr>


          <tr >
            <td align="left">&nbsp;</td>
            <td align="left"><font >User ID</font></td>
            <td align="left">
              <input type="text" name="UserId" value="SYS_USER1" size="" maxlength="">
            </td>
            <td width="10" align="left">&nbsp;</td>
          </tr>
          <tr >
            <td>&nbsp;</td>
            <td align="left"><font >Password</font></td>
            <td align="left">
              <input type="password" name="Password" size="" maxlength="">
            </td>
            <td align="left" width="10">&nbsp;</td>
          </tr>

		  <tr >
            <td>&nbsp;</td>
            <td align="right"></td>
            <td align="left">
              <a href="javascript:forgotPassword()">
              	<font ></font></a>
            </td>
            <td align="left" width="10">&nbsp;</td>
          </tr>

          <tr>
            <td colspan="4"><img src="images/spacer.gif" height="15"></td>
          </tr>
          <tr>
            <td colspan="4">
              <input type="image" name="login" border="0" src="images/login.gif"><img src="images/spacer.gif" width="15">
            </td>
          </tr>

          <tr> 
            <td colspan="4"><img src="images/spacer.gif" height="15"></td>
          </tr>
          <td colspan="4"> 
           
          </td>

        </table>

</form>
<script language="JavaScript">
<!--
document.SIGNONCTLR.UserId.focus();

function forgotPassword()
{
	document.forms[0].elements['FORGOT_PASSWORD'].value = 'TRUE';
	document.forms[0].submit();
}
//-->
</script>

