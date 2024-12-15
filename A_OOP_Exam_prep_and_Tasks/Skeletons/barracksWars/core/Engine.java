package barracksWars.core;

import barracksWars.core.commands.AddCommand;
import barracksWars.core.commands.FightCommand;
import barracksWars.core.commands.ReportCommand;
import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {


	private CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {
		this.commandInterpreter=commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				Executable executable=commandInterpreter.interpretCommand(data,commandName);
				String result=executable.execute();
//				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
//	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
//		String result;
//		switch (commandName) {
//			case "add":
//				AddCommand addCommand=new AddCommand(data,repository,unitFactory);
//				result=addCommand.execute();
////				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				ReportCommand reportCommand=new ReportCommand(data,repository,unitFactory);
//				result=reportCommand.execute();
////				result = this.reportCommand(data);
//				break;
//			case "fight":
//				FightCommand fightCommand=new FightCommand(data,repository,unitFactory);
//				result = fightCommand.execute();
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
//		return result;
//	}
//
//	private String reportCommand(String[] data) {
//		String output = this.repository.getStatistics();
//		return output;
//	}
//
//	private String addUnitCommand(String[] data) {
//		String unitType = data[1];//
//		Unit unitToAdd = this.unitFactory.createUnit(unitType);
//			this.repository.addUnit(unitToAdd);
//		String output = unitType + " added!";
//		return output;
//	}
	

}
