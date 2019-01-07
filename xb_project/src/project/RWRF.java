package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import edu.princeton.cs.algs4.Bag;

public class RWRF { // read and write risk factor.
	private static Map<String, List<Integer>> list = new TreeMap<String, List<Integer>>();// Map Cause name -> list of
																							// boolean value for risk
																							// factor
	private static Map<String, Integer> cause = new TreeMap<String, Integer>();// cause name to cause index
	private static Map<Integer, String> index = new TreeMap<Integer, String>();// cause index to cause name
	private static String[] riskFactors = new String[26];// list of risk factor
	private static int countV = 0;
	private static String[] content;
	private static int[] startpoint;

	public static void load() {
		content = new String[136];
		startpoint = new int[26];
		try {
			File f = new File("data/riskFactors.csv");
			BufferedReader br = new BufferedReader(new FileReader(f));
			// String cause = "";
			String line = br.readLine();
			for (int i = 0; i < 26; i++) {
				// System.out.println(line.split(",")[i + 1]);
				riskFactors[i] = line.split(",")[i + 1];
			}
			while ((line = br.readLine()) != null) {
				content[countV] = line;
				countV++;
			}
			// cause = line.split(", ")[0];
			br.close();
			String key = "";
			countV = 0;
			br = new BufferedReader(new FileReader(f));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				key = getCause(line);
				List<Integer> l = new ArrayList<Integer>();
				for (int i = 0; i < 26; i++) {
					l.add(Integer.parseInt(getRank(line, i + 1)));
				}
				list.putIfAbsent(key, l);
				cause.putIfAbsent(key, countV);
				index.putIfAbsent(countV, key);
				countV++;
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function aims to return a adjacency list corresponding to the input RF
	 * index. In the map structure, the first Integer is the index of the mortality
	 * cause the second parameter ArrayList<Integer> is a sequence of mortality
	 * causes that the first parameter connects to.
	 */

	public static Graph[] getGraph() {
		Graph[] D = new Graph[26];
		for (int i = 0; i < 26; i++) {
			Graph dd = new Graph(136);
			dd = generate(i);
			D[i] = dd;
		}
		return D;
	}

	public static Graph generate(int j) {
		int[] data = new int[136];
		Graph d = new Graph(136);
		for (int i = 0; i < content.length; i++)
			data[i] = Integer.parseInt(content[i].split(",")[j + 1]);

		// LinkedList<Integer> adj = new LinkedList<Integer>();
		int pre = 0;
		int curr;
		int count = 0;
		for (int i = 0; i < content.length; i++) {
			curr = i;
			if (data[i] == 1) {
				count++;
				if (count > 1) {
					d.addEdge(curr, pre);
					d.addEdge(pre, curr);
				}
				if(data[pre] != 1) {
					startpoint[j] = curr; 
				}
				pre = curr;
			}
		}

		return d;
	}

	private static String getCause(String line) {
		return line.split(",")[0];
	}

	private static String getRank(String line, int i) {
		return line.split(",")[i];
	}

	public static Map<String, List<Integer>> getList() {
		return list;
	}

	public static Integer getIndex(String key) {
		return cause.get(key);
	}
	
	public static Set<String> causeList(){
		return cause.keySet();
	}

	public static String getCause(int i) {
		return index.get(i);
	}

	public static String[] getRF() {
		return riskFactors;
	}

	public static Iterable<String> getCauses() {
		return list.keySet();
	}
	
	public static int getStartPoint(int i) {
		return startpoint[i];
	}

	public static void main(String[] args) {
		RWRF.load();
		for (String w : RWRF.getCauses()) {
			System.out.println(w);
		}
		Graph[] D = new Graph[26];
		D = RWRF.getGraph();
		/*for (int i = 2; i < 138; i++) {
			LinkedList<Integer> a = generate(0).adj(i - 2);
			System.out.println(i + "   " + a.toString());
		}
		
		for (int i = 0; i < 26; i++) {
			Graph dd = new Graph(136);
			dd = generate(i);
			D[i] = dd;
		}
		for (int i = 2; i < 138; i++) {
			LinkedList<Integer> a = D[5].adj(i - 2);
			System.out.println(i + "   " + a.toString());
		}*/
		for(int i = 0; i < startpoint.length; i++) {
			System.out.println(startpoint[i]);
		}
	}
}
