package srujan.algos.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCombinations {
	
	public List<List<String>> allSubsets(String str)
	{
		List<List<String>> finalList = new ArrayList<>();
		if(str==null ||str.length()==0)return finalList;
		if(str.length()==1) {
			ArrayList<String> single =new ArrayList<String>();
			single.add(str);
			finalList.add(single);
			finalList.add(new ArrayList<String>());
			return finalList;
		}
		List<List<String>> childList = allSubsets( str.substring(1));
		String myself = str.substring(0, 1);
		for(List<String> list:childList )
		{
			finalList.add( list);
			ArrayList<String>  amendList = new ArrayList<String>();
			amendList.addAll(list);
			amendList.add(myself);
			finalList.add(amendList);
		}
		
		return finalList;
	}
	
	public ArrayList<ArrayList<Integer>> permuations(int[] array)
	{
		Arrays.asList(array);
		return null;
	}
	
	public static void main(String[] args)
	{
		StringCombinations s = new StringCombinations();
		System.out.println(s.allSubsets("A"));
	}

}
