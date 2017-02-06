import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PaintCommands {

	public static void main(String... arg) {
		System.out.println("==========Reading commands with NIO and java 8=========");
		Path path = Paths.get("data/commands.csv");
		try {
			List<Command> commands = Files.lines(path).skip(1).map(s->{
															String[] values = s.split(",");
															return new Command(Integer.valueOf(values[0]), 
																		Integer.valueOf(values[1]), 
																		CommandMode.parseCommandMode(values[2]), 
																		Colour.parseColour(values[3]), 
																		"myCanvas");
															}).collect(Collectors.toList());
			commands.forEach(Command::execute);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}