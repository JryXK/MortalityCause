package project;

public class Sort {
	private static ADT[] aux;
	
	/**
	 * merge sort using Comparable, initial call of merge sort.
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge(ADT[] x, int n){
		aux = new ADT[n];
		sort(x, 0, n-1);
	}

	/**
	 * Helper function to recursively divides input in half and combine sorted halves
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param low - lowest index
	 * @param high - highest index
	 */
	private static void sort(ADT[] x, int low, int high){
		
		if (high <= low)
			return;
		int mid = low + (high - low) / 2;
		
		sort(x, low, mid);
		sort(x, mid + 1, high);
		merge(x, low, mid, high);
	}

	/**
	 * Helper function to sort array
	 * @param x - the input array containing jobs that need to be sorted.
	 */
	private static void merge(ADT[] x, int low, int mid, int high){

		int left = low, right = mid + 1;
		
		for (int i = low; i <= high; i++){
			aux[i] = x[i];
		}
		
		for (int i = low; i <= high; i++){
			if (left > mid)
				x[i] = aux[right++];
			else if (right > high)
				x[i] = aux[left++];
			else if (aux[right].compareTo(aux[left]) > 0)
				x[i] = aux[right++];
			else
				x[i] = aux[left++];
		}
	}

}
