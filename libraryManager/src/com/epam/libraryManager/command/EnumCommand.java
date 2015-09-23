package com.epam.libraryManager.command;

public enum EnumCommand {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOCALE {
		{
			this.command = new ChangeLocaleCommand();
		}
	},
	REGISTRATION {
		{
			this.command = new RegistrationCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	};
	InterfaceCommand command;
	public InterfaceCommand getCurrentCommand() {
		return command;
	}
}
