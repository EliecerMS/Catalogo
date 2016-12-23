$(document).ready(function($) {
	$('#mostrar-nav').on('click', function () {
	  var myVar;
      $('#menu').toggleClass('mostrar');
      $('#loading').show();
      $('#loading').delay(1000).hide(500);
     // document.getElementById('#divred').style.display = "block";
     myVar = setTimeout(showPage, 1000);
    })
});

function showPage() {
    document.getElementById("divred").display.style = "block";
  }

    function myFunction(x) {
    	x.classList.toggle("change");
    }