import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ShowLoader implements IShowLoader{

	@Override
	public List<IShow> loadShows(String filepath) throws FileNotFoundException {
		try {
		File shows = new File("filepath");
		BufferedReader br = new BufferedReader(new FileReader(shows));
			br.readLine();
		} catch (IOException e) {
			throw new FileNotFoundException ("file not found");
		}
		
		return null;
	}

	private String[] fileRows(File f, BufferedReader br) {
		return null;
	}
	
	private Show ShowObject(String s) {
		return null;
	}
}
