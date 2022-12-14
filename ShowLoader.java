// --== CS400 Project One W3 ==--
// Name: Mojtaba Javid
// Role: Data Wrangler
// CSL Username: mojtaba
// Email: javid2@wisc.edu
// Lecture #: 002 @1:00pm

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

	/**
     * This method loads the list of shows described within a CSV file.
     * @param filepath is relative to executable's working directory
     * @return a list of show objects that were read from specified file
     */
	@Override
	public List<IShow> loadShows(String filepath) throws FileNotFoundException {
		List<IShow> ShowsList = new ArrayList<IShow>();
		try {
			File shows = new File(filepath);
			BufferedReader br = new BufferedReader(new FileReader(shows));
			br.readLine(); //omitting the fist line being the headers
			
			Queue<String> showRows = this.fileRows(br);
			while(!showRows.isEmpty()) {
				ShowsList.add(this.ShowObject(showRows.poll()));}
			
		} catch (IOException e) {
			throw new FileNotFoundException ("file not found");}
		
		
		return ShowsList;
	}

	/**
     * helper method
     * reads each line and adds them into a queue for easier access
     * @param BufferedReader of the specified file
     * @return a queue of each row of the file as an string
     */
	private Queue<String> fileRows(BufferedReader br) throws IOException {
		String row;
		Queue<String> rows = new ArrayDeque<String>();
		while((row = br.readLine()) != null) {
			rows.add(row);}
		
		return rows;
	}
	
	/**
     * helper method
     * takes a row string and transforms it into a show object
     * @param string of a show detail, obtained from the file
     * @return a show object
     */
	protected Show ShowObject(String s) {
		if(s == null || s.equals("")) return null;
		String S = s.substring(s.indexOf(',', s.indexOf(',')+1)+1);
		String[] show = S.split(",");
		if(show == null || show.length<10) return null;
		
		int l =0;
		while(show.length-l > 10){
			for(int i=0; i<show.length; i++) {
				if(show[i].contains("\"")) {
					show[i]= show[i].concat("," + show[i+1]);
					for(int j = i+1; j<show.length-1; j++) {
						show[j]=show[j+1];
						show[show.length-1]=null;
					}
					l++;
					break;}
			}
			
		}
		
		for(int i=0; i<show.length; i++) {
			if(show[i] != null && !show[i].equals("") && show[i].charAt(0) == '"') {
				show[i] = show[i].substring(1, show[i].length()-1);}}
		
		String provider ="";
		
		String N=null;
		if(show[5].equals("1")) {
			N = "Netflix";
			provider = provider + N;
		}
		String H=null;
		if(show[6].equals("1")) {
			H = ", Hulu";
			provider = provider + H;
		}
		String P=null;
		if(show[7].equals("1")) {
			P = ", Prime Video";
			provider = provider + P;
		}
		String D=null;
		if(show[8].equals("1")) {
			D = ", Disney+";
			provider = provider + D;
		}
		
		return new Show(show[0], Integer.parseInt(show[1]), Integer.parseInt(show[4].substring(0, show[4].indexOf("/"))), provider);
	}
}
