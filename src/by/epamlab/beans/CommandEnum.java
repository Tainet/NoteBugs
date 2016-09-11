package by.epamlab.beans;

import by.epamlab.command.DeleteUserCommand;
import by.epamlab.command.EditPasswordCommand;
import by.epamlab.command.EditPasswordPageCommand;
import by.epamlab.command.EditUserCommand;
import by.epamlab.command.EditUserPageCommand;
import by.epamlab.command.LoginCommand;
import by.epamlab.command.LogoutCommand;
import by.epamlab.command.MainCommand;
import by.epamlab.command.NextUsersPageCommand;
import by.epamlab.command.PreviousUsersPageCommand;
import by.epamlab.command.Registration2Command;
import by.epamlab.command.RegistrationCommand;
import by.epamlab.command.RegistrationPageCommand;
import by.epamlab.command.UsersListPageCommand;
import by.epamlab.controller.ActionCommand;

public enum CommandEnum {
	LOGIN {{
			this.command = new LoginCommand();
		}},
	LOGOUT {{
		this.command = new LogoutCommand();
	}},
	MAIN {{
		this.command = new MainCommand();
	}},
	REGISTRATION {{
		this.command = new RegistrationCommand();
	}},
	REGISTRATION2 {{
		this.command = new Registration2Command();
	}},
	REGISTRATION_PAGE {{
		this.command = new RegistrationPageCommand();
	}},
	USERS_LIST_PAGE {{
		this.command = new UsersListPageCommand();
	}},
	NEXT_USERS_PAGE {{
		this.command = new NextUsersPageCommand();
	}},
	PREVIOUS_USERS_PAGE {{
		this.command = new PreviousUsersPageCommand();
	}},
	EDIT_USER_PAGE {{
		this.command = new EditUserPageCommand();
	}},
	EDIT_USER {{
		this.command = new EditUserCommand();
	}},
	EDIT_PASSWORD_PAGE {{
		this.command = new EditPasswordPageCommand();
	}},
	EDIT_PASSWORD {{
		this.command = new EditPasswordCommand();
	}},
	DELETE_USER {{
		this.command = new DeleteUserCommand();
	}}
;
		ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
