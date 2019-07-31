package fuzzy.search;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.intuit.fuzzymatcher.domain.Document;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.ElementType;
import com.intuit.fuzzymatcher.domain.Match;

/**
 * Unit test for simple App.
 */

public class AppTest
{
  @Test 
  public void nameMatch_1Test () {
	  Document  doc = new Document.Builder("0").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("manzarul").createElement()).createDocument();
	  List<Match<Document>> list = App.match(doc, App.getDocList());
	  assertEquals(list.size(), 7);
	  
   }	
	
  
  @Test 
  public void nameMatc_2hTest () {
	  Document  doc = new Document.Builder("0").addElement(new Element.Builder().setType(ElementType.TEXT).setValue("manzarulHaque").createElement()).createDocument();
	  List<Match<Document>> list = App.match(doc, App.getDocList());
	  assertEquals(list.size(), 7);
	  
   }
  
}
