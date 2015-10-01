package com.bsuir.adbLab1.command;

public enum CommandEnum {

	LOGIN {
		{
			//this.command = new LoginCommand();
		}
	},
	LOCALE {
		{
			//this.command = new ChangeLocaleCommand();
		}
	},
	REGISTRATION {
		{
			//this.command = new RegistrationCommand();
		}
	},
	LOGOUT {
		{
			//this.command = new LogoutCommand();
		}
	};
	ICommand command;
	public ICommand getCurrentCommand() {
		return command;
	}
}
