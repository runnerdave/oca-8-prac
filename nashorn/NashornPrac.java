import javax.script.*;
import java.nio.file.*;
import java.nio.*;
import java.io.*;

public class NashornPrac {
	private void runJs(String js) throws ScriptException { 
		ScriptEngineManager manager = new ScriptEngineManager(); 
		ScriptEngine engine = manager.getEngineByName("nashorn"); 
		System.out.println(engine.eval(js));
	}

	public static void main(String[] args) throws ScriptException, IOException { 
		Path path = Paths.get(args[0]);
		Reader reader = Files.newBufferedReader(path);
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		System.out.println(engine.eval(reader)); 
	}
	
}