$(document).ready(function($) {
	var myVar;
  $('#mostrar-nav').on('click', function () {
      $('#menu').toggleClass('mostrar');
      $('#loading').show();
      $('#loading').delay(1000).hide(500);
    })
});

	

    function myFunction(x) {
    	x.classList.toggle("change");
    }