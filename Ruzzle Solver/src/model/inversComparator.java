package model;

import java.util.Comparator;

public class inversComparator<T> implements Comparator<String> {

	

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.length()==o2.length()){
			return (o1.compareTo(o2));
		}
		return (o1.length()-o2.length());
	}

}
