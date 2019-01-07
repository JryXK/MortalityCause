package project;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Help {
	ADT[] cause = new ADT[136];

	public static ADT[] getRisk(ADT[] a) {
		ADT[] out = new ADT[136];
		Boolean[] check = new Boolean[136];
		int index = 0;
		for (int i = 0; i < 136; i++) {
			check[i] = false;
		}

		for (int i = 0; i < a.length; i++) {
			if (check[RWRF.getIndex(a[i].getCause())] == false) {
				out[index] = a[i];
				index++;
				check[RWRF.getIndex(a[i].getCause())] = true;
			}
		}
		return out;
	}

	public static LinkedList<Integer>[] getPaths(Graph[] d) {
		LinkedList<Integer>[] pathArray = new LinkedList[d.length];
		int endpoint = 135;
		LinkedList<Integer> max;
		for (int i = 0; i < d.length; i++) {
			BFS tem = new BFS(d[i], RWRF.getStartPoint(i));
			max = new LinkedList<Integer>();
			for (int j = 0; j < 136; j++) {
				if (tem.marked()[j] == true)
					max.add(j);
			}
			pathArray[i] = max;
		}
		return pathArray;
	}
	
	

	public static void main(String[] args) {
		RWRF.load();
		Graph[] D = RWRF.getGraph();
		readFile.load();
		Data.setUp();

		Search a = new Search(25, "Male".toUpperCase(), 0);
		ADT[] aaa = a.getSeq();
		LinkedList<Integer>[] blabla = Help.getPaths(D);
		for(int k = 0; k < blabla.length; k++) {
			//System.out.println(blabla[k].toString());
		}

		Sort.sortMerge(aaa, aaa.length);
		ADT[] list136 = Help.getRisk(aaa);
		for (int j = 0; j < 136; j++) {
			System.out.println(list136[j]);
		}
	}

}
