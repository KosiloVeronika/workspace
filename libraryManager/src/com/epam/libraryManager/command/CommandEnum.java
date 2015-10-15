package com.epam.libraryManager.command;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	ADD {
		{
			this.command = new OrderCommand();
		}
	},
	SHOW_ORDERS {
		{
			this.command = new ShowOrderCommand();
		}
	},
	SHOW_ALL_BOOKS {
		{
			this.command = new ShowAllBooksCommand();
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
	ICommand command;
	public ICommand getCurrentCommand() {
		return command;
	}
}
