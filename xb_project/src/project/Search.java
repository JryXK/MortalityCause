package project;

public class Search {
	ADT[] searchSeq;

	public Search(int age, String gender, int unit) {
		if (unit == 0) {
			if (age == 0) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge1()[1][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge1()[1][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge1()[1][0];
			} else if (age > 0 && age < 90) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge1()[(age / 5)+2][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge1()[(age / 5)+2][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge1()[(age / 5)+2][0];
			} else if (age > 90) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge1()[20][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge1()[20][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge1()[20][0];
			} else if (age == -1) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge1()[0][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge1()[0][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge1()[0][0];
			}
		}else if (unit == 1) {
			if (age == 0) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge2()[1][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge2()[1][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge2()[1][0];
			} else if (age > 0 && age < 90) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge2()[(age / 5)+2][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge2()[(age / 5)+2][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge2()[(age / 5)+2][0];
			} else if (age > 90) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge2()[20][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge2()[20][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge2()[20][0];
			} else if (age == -1) {
				if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
					this.searchSeq = Data.returnAge2()[0][1];
				else if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
					this.searchSeq = Data.returnAge2()[0][2];
				else if (gender.charAt(0) == 'B' || gender.charAt(0) == 'b')
					this.searchSeq = Data.returnAge2()[0][0];
			}
		}
	}

	public ADT[] getSeq() {
		return this.searchSeq;
	}

	public static void main(String[] args) {
		Data.setUp();
		ADT[][][] store = Data.returnAge1();
		System.out.println(Data.returnAge1()[3][1][2]);
		System.out.println(Data.returnAge1()[13][1][2]);
		System.out.println(Data.returnAge2()[13][1][2]);
		System.out.println(Data.returnAge2()[3][1][2]);
	}

	// public ADT[] getResult() {

	// }
}
