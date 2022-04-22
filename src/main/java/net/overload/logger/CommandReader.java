package net.overload.logger;

import java.util.Scanner;

import net.overload.utils.StaticsFunctions;
import net.overload.utils.StaticsVariables;
import net.overload.utils.Utils;

public class CommandReader extends Thread {
	public Boolean running = true;

	public void run() {
		Scanner reader = new Scanner(System.in);
		while (true) {
			try {
				String cmd = reader.nextLine();
				String[] arg = cmd.split(" ");
				if (arg[0].startsWith("exit") || arg[0].startsWith("stop") || arg[0].startsWith("end")) {
					new Log(LogLevel.WARNING, "Slave is stoping. All servers will be closed soon.").send();
					System.exit(0);
				} else if (arg[0].startsWith("newvoid")) {
					StaticsFunctions.newVoid();
				} else if (arg[0].startsWith("newwe")) {
					StaticsFunctions.newWE();
				} else if (arg[0].startsWith("new")) {
					if(arg[1] == null)
						new Log(LogLevel.ERROR, "Command syntax error : new <file>").send();
					else {
						Utils.startServerFromFile(arg[1]);
					}
				} else {
					new Log(LogLevel.ERROR, "Commande not found!").send();
					new Log().line();
				}
			} catch (Exception e) {
				new Log(LogLevel.ERROR, "Unable to process command.").send();
				if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
				if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			}
			
			
			if (!this.running) {
				reader.close();
				return;
			}
		}
	}
}
