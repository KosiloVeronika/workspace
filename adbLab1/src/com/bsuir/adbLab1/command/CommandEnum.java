package com.bsuir.adbLab1.command;

public enum CommandEnum {

	ADD{
		{
			this.command = new AddCommand();
		}
	},
	ADD_PAGE{
		{
			this.command = new PageAddCommand();
		}
	},
	CHANGE_PAGE{
		{
			this.command = new PageChangeCommand();
		}
	},
	DELETE {
		{
			this.command = new DeleteCommand();
		}
	},
	CHANGE {
		{
			this.command = new ChangeCommand();
		}
	},
	SHOW {
		{
			this.command = new ShowCommand();					
		}
	};
	ICommand command;
	public ICommand getCurrentCommand() {
		return command;
	}
}
