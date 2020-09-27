function fncMenu(val) { 
		document.getElementById("menu").action = val;
		document.getElementById("menu").submit();
}

function editFunc(id) {
    document.getElementById('author'+id).readOnly = false;
    document.getElementById('publisher'+id).readOnly = false;

    document.getElementById('edit'+id).style.visibility = 'hidden';
    document.getElementById('save'+id).style.visibility = 'visible';
    document.getElementById('cancel'+id).style.visibility = 'visible';
    document.getElementById('delete'+id).style.visibility = 'hidden';
    
    disableAllOtherButtons(id);
};

function disableAllOtherButtons(id){
	$(':button').prop('disabled', true);
	document.getElementById('save'+id).disabled = false;
    document.getElementById('cancel'+id).disabled = false;
};

function saveFunc(id) {
	document.getElementById("prodform"+id).action = '/updatebook';
	document.getElementById("prodform"+id).submit();
 }; 
 
 function deleteFunc(id) {
		document.getElementById("prodform"+id).action = '/deletebook';
		document.getElementById("prodform"+id).submit();
};

function cancelFunc(id) {
	document.getElementById('author'+id).readOnly = true;
    document.getElementById('publisher'+id).readOnly = true;

    document.getElementById('edit'+id).style.visibility = 'visible';
    document.getElementById('save'+id).style.visibility = 'hidden';
    document.getElementById('cancel'+id).style.visibility = 'hidden';
    document.getElementById('delete'+id).style.visibility = 'visible';

    $(':button').prop('disabled', false);
}; 
	
	
	
	