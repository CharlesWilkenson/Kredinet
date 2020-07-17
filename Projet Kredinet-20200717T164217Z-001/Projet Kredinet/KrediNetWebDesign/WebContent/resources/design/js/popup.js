/**
 * 
 */
function initDialog() {
 $("#idOfDialogPlaceHolder").dialog({
     modal: true,
     buttons: {
            SomeButton: function () {
                $("#justAButton").click();
            },
            Close: function () {
                $(this).dialog("close");
            }
     },
 });
}