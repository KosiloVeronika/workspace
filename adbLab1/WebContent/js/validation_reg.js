window.onload = function(e) {
	var loginField = $('[name=username]').first();
	var passwordField = $('[name=password]').first();
	var emailField = $('[name=mail]').first();
	emailField.keyup(function(e){
		var emailField = $('[name=mail]').first();
		var emailValue = emailField.val();
		var pattern = /^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$/;
		if(emailValue && pattern.test(emailValue)) {
			emailFeeld.attr('style', 'background:#77ff33');
		} else {
			emailField.attr('style', 'background:red');
		}
	});
	console.log('keyup3');
	loginField.keyup(function(e) {		
		var loginField = $('[name=username]').first();
		var loginValue = loginField.val();
		var pattern = /^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$/;
		if(loginValue && pattern.test(loginValue)) {
			loginField.attr('style', 'background:#77ff33');
		} else {
			loginField.attr('style', 'background:red');
		}
	});
	passwordField.keyup(function(e) {		
		var passwordField = $('[name=password]').first();
		var passwordValue = passwordField.val();
		var pattern = /^((?=.*\d))(?=.*[A-Z])(?=.*[a-z])\w{8,30}$/;
		if(passwordValue && pattern.test(passwordValue)) {
			
			passwordField.attr('style', 'background:#77ff33');
		} else {
			passwordField.attr('style', 'background:red');
		}
	});
	console.log(loginField.change);
}