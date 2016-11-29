$(document).ready(function($) {
			
			$('#urllink').bind('input', function() {
			    $('#preview').attr('src', $(this).val()); //concatinate path if required
			});
			
			$("#urllink").keyup(function () {
			        var value = $(this).val();
			        $("#url").val(value);
			});

		});