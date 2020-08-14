package web.crawling.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	public ArrayList<String> resultCrawling(String url, String selectors){
		ArrayList<String> resultSelectors = new ArrayList<String>();
		try {
			Document doc = Jsoup.connect(url).get();
			Elements resultLinks = doc.select(selectors);
			for (Element element : resultLinks) {
				resultSelectors.add(element.text());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSelectors;
	}
	
	public String selectors() {
		ArrayList<String> getSelectors = new ArrayList<String>();
		String selectors = "";
		for (int i = 0; i < getSelectors.size(); i++) {
			if(i == 0) {
				selectors = getSelectors.get(i);
			}else {
				selectors = selectors +" " + getSelectors.get(i); 
			}
		}
		return selectors;
	}
}
