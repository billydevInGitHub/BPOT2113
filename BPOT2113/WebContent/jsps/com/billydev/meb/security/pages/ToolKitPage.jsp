<jsp:useBean id="SessionDataManager" scope="session" class="com.billydev.meb.security.servlets.SessionDataManager" />
<%
	com.billydev.meb.security.servlets.PageData pageData =SessionDataManager.getPageData();
	String userID=(String)pageData.getValue("userID");	 
%>	

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">First</a></li>
		<li><a href="#tabs-2">Second</a></li>
		<li><a href="#tabs-3">Third</a></li>
	</ul>
	<div id="tabs-1">   
	
 <table>
    <tr>
      <td colspan="4" align="left"></td>
    </tr>
        <tr>
      <td colspan="4"></td>
     </tr>
      <tr>
        <td colspan="4" height="15">
         
        </td>
      </tr>

          <tr>
            <td colspan="4">Toolkit </td>
          </tr>
          <tr>
            <td colspan="4"><%="Welcome to our site ..."+userID+"!"%></td>
          </tr>
          <tr>
          <td colspan="4"> 
            <a href="UserMaintenanceCtlr">User Maintenance</a>
          </td>
          </tr>
  </table></div>
	<div id="tabs-2"><table><tr><td>test tab2222222222222222222222222222222222222222222222222222222222222222222222.</td></tr></table></div>
	<div id="tabs-3">test tab3333333333333333333333333333333333333333333333333333333333333333333333.</div>
</div>

<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script>

$( "#accordion" ).accordion();

var availableTags = [
	"ActionScript",
	"AppleScript",
	"Asp",
	"BASIC",
	"C",
	"C++",
	"Clojure",
	"COBOL",
	"ColdFusion",
	"Erlang",
	"Fortran",
	"Groovy",
	"Haskell",
	"Java",
	"JavaScript",
	"Lisp",
	"Perl",
	"PHP",
	"Python",
	"Ruby",
	"Scala",
	"Scheme"
];
$( "#autocomplete" ).autocomplete({
	source: availableTags
});



$( "#button" ).button();
$( "#radioset" ).buttonset();



$( "#tabs" ).tabs();


$( "#dialog" ).dialog({
	autoOpen: false,
	width: 400,
	buttons: [
		{
			text: "Ok",
			click: function() {
				$( this ).dialog( "close" );
			}
		},
		{
			text: "Cancel",
			click: function() {
				$( this ).dialog( "close" );
			}
		}
	]
});

// Link to open the dialog
$( "#dialog-link" ).click(function( event ) {
	$( "#dialog" ).dialog( "open" );
	event.preventDefault();
});



$( "#datepicker" ).datepicker({
	inline: true
});



$( "#slider" ).slider({
	range: true,
	values: [ 17, 67 ]
});



$( "#progressbar" ).progressbar({
	value: 20
});



$( "#spinner" ).spinner();



$( "#menu" ).menu();



$( "#tooltip" ).tooltip();



$( "#selectmenu" ).selectmenu();


// Hover states on the static widgets
$( "#dialog-link, #icons li" ).hover(
	function() {
		$( this ).addClass( "ui-state-hover" );
	},
	function() {
		$( this ).removeClass( "ui-state-hover" );
	}
);
</script>