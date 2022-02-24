import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShowLoader implements IShowLoader{

	@Override
	public List<IShow> loadShows(String filepath) throws FileNotFoundException {
		List<IShow> ShowsList = new ArrayList<IShow>();
		try {
			File shows = new File("filepath");
			BufferedReader br = new BufferedReader(new FileReader(shows));
			br.readLine();
			
			Queue<String> showRows = fileRows(br);
			while(!showRows.isEmpty()) {
				ShowsList.add(ShowObject(showRows.poll()));}
			
		} catch (IOException e) {
			throw new FileNotFoundException ("file not found");}
		
		
		return ShowsList;
	}

	private Queue<String> fileRows(BufferedReader br) throws IOException {
		String row;
		Queue<String> rows = new ArrayDeque<String>();
		while((row = br.readLine()) != null) {
			rows.add(row);}
		
		return rows;
	}
	
	private Show ShowObject(String s) {
		String S = s.substring(s.indexOf(',', s.indexOf(',')+1)+1);
		String[] show = S.split(",");
		if(show.length > 10) {
			for(int i=0; i<show.length; i++) {
				if(show[i].contains("\"")) {
					show[i]= show[i].concat(show[i+1]);
					for(int j = i; j<show.length-1; j++) {
						show[j]=show[j+1];
						show[show.length-1]=null;
					}
					break;}
			}
		}
		
		for(int i=0; i<show.length; i++) {
			if(show[i].charAt(0) == '"') {
				show[i] = show[i].substring(1, show[i].length()-2);}}
		
		String N=null;
		if(show[5].equals("1")) N = "Netflix, ";
		String H=null;
		if(show[6].equals("1")) H = "Hulu, ";
		String P=null;
		if(show[7].equals("1")) P = "Prime Video, ";
		String D=null;
		if(show[8].equals("1")) D = "Disney+";

		String provider = N + H + P + D;
		return new Show(show[0], Integer.parseInt(show[1]), Integer.parseInt(show[4]), provider);
	}
}
