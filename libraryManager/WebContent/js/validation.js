window.onload = function(e) {
	var loginField = $('[name=login]').first();
	var passwordField = $('[name=password]').first();
	console.log('keyup3');
	loginField.keyup(function(e) {		
		var loginField = $('[name=login]').first();
		var loginValue = loginField.val();
		var pattern = /^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$/;
		if(loginValue && pattern.test(loginValue)) {
			loginField.attr('style', 'background:green');
		} else {
			loginField.attr('style', 'background:red');
		}
	});
	passwordField.keyup(function(e) {		
		var passwordField = $('[name=password]').first();
		var passwordValue = passwordField.val();
		var pattern = /^((?=.*\d))(?=.*[A-Z])(?=.*[a-z])\w{8,30}$/;
		if(passwordValue && pattern.test(passwordValue)) {
			passwordField.attr('style', 'background:green');
		} else {
			passwordField.attr('style', 'background:red');
		}
	});
	console.log(loginField.change);
}

