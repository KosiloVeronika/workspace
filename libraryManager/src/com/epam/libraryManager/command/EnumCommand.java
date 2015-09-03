package com.epam.libraryManager.command;

public enum EnumCommand {
	LOGIN {
		{
			this.command = new LoginCommand();
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