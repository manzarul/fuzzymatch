package fuzzy.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.Document;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.ElementType;
import com.intuit.fuzzymatcher.domain.Match;

/**
 * main class to run fuzzy match.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	 Document  doc = new Document.Builder("0").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("m").createElement()).setThreshold(0.4).createDocument();
    	match(doc, getDocList());
        
       
      
       }
    /**
    * if we need to match non english words then set value as follow 
    * .setValue(URLEncoder.encode("manzarul","UTF-8")
    */
	
    
    public static List<Document> getDocList () {
    	 List<Document> docList = new ArrayList<Document>();
         docList.add(new Document.Builder("1").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Manzarul").createElement()).createDocument());
         docList.add(new Document.Builder("2").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Manzaruhlaque").createElement()).createDocument());
         docList.add(new Document.Builder("3").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Haque").createElement()).createDocument());
         docList.add(new Document.Builder("4").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Monzarul").createElement()).createDocument());
         docList.add(new Document.Builder("5").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Manzhrol").createElement()).createDocument());
         docList.add(new Document.Builder("6").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Manmmet").createElement()).createDocument());
         docList.add(new Document.Builder("7").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Manzhar").createElement()).createDocument());
         docList.add(new Document.Builder("8").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("manzar").createElement()).createDocument());
         docList.add(new Document.Builder("9").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("manjar").createElement()).createDocument());
         docList.add(new Document.Builder("10").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("zanjoor").createElement()).createDocument());
         docList.add(new Document.Builder("11").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Manzaruhaque").createElement()).createDocument());
         docList.add(new Document.Builder("12").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Stephen Wilkson").createElement()).createDocument());
         docList.add(new Document.Builder("13").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("John Pierre").createElement()).createDocument());
         docList.add(new Document.Builder("14").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Wilson, Stephen").createElement()).createDocument());
         docList.add(new Document.Builder("15").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Pierre john").createElement()).createDocument());
         docList.add(new Document.Builder("16").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("Stephen Kilsman wilkson").createElement()).createDocument());
         return docList;
       }
    
    
    
	public static List<Match<Document>> match(Document doc, List<Document> docList) {
		MatchService matchService = new MatchService();
		Map<Document, List<Match<Document>>> map = matchService.applyMatch(doc, docList);
		Iterator<Entry<Document, List<Match<Document>>>> itr = map.entrySet().iterator();
		List<Match<Document>> matchList = null;
		while (itr.hasNext()) {
			System.out.println("count-----------");
			Entry<Document, List<Match<Document>>> entry = itr.next();
			matchList = entry.getValue();
			for (int i = 0; i < matchList.size(); i++) {
				Match<Document> matchDoc = matchList.get(i);
				System.err.println(matchDoc + "==  " + matchDoc.getMatchedWith().getKey());
			}
		}
		return matchList;
	}   
    
  }
