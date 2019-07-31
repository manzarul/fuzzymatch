package fuzzy.search;

import java.util.ArrayList;
import java.util.List;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

public class XdropFuzzy {
	
	public static List<String> getNameList () {
		List<String> names = new ArrayList<String>();
		names.add("amit");
		names.add("Manjur");
		names.add("Mpanzarul");
		names.add("manzarulhaq");
		names.add("amit");
		names.add("manjajurl");
		names.add("Zanzarul");
		names.add("manzarul haque");
		names.add("ManzarulHaque");
		names.add("haqueManzarul45");
		names.add("manmeet");
		names.add("Manzhrol");
		names.add("Manzhar");
		names.add("manjar");
		names.add("equahluraznam");
		names.add("haquemanzarul");
		names.add("HaqueManzarul");
		names.add("manjoor");
		return names;
	}
	
	
	public static void match (String name, List<String> names) {
	 List<ExtractedResult> results	= FuzzySearch.extractAll(name, names);
	 for (int i =0 ; i< results.size() ;i++) {
		 ExtractedResult  extractedResult = results.get(i);
		 System.out.println(extractedResult.getScore() + " " + extractedResult.getString());
	 }
	}
	
	public static void extractOne (String name, List<String> names) {
		ExtractedResult result = FuzzySearch.extractOne(name, names);
		System.out.println(result.getScore() + " " + result.getString());
	}
	
	
	
	public static void main(String[] args) {
		match("m",getNameList());
	}

}
