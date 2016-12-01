$(document).ready(function($) {
  $('#mostrar-nav').on('click', function () {
      $('#menu').toggleClass('mostrar');
      $('#loading').show();
      $('#loading').delay(3000).hide(500);
      $('#results').show();
    })
});

    function myFunction(x) {
    x.classList.toggle("change");
  }