package web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CrawlingService {

	@RequestMapping("/home")
	public String submit() {
		return "crawling";
	}
	
	@RequestMapping(value = "/transfer", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String transfer(@RequestBody ArrayList<String> arr) {
		System.out.println(arr);
		return "확인 완료";
	}
	@RequestMapping(value = "/se"
			+ "nd", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String sendHtml(@RequestBody String url) {
		String html = null;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			String text = doc.html();
			String cutText = text.substring(text.indexOf("<body"), text.indexOf("</body")+7);
			System.out.println("============================="+text.indexOf("</body>")+"===============");
			System.out.println(cutText);
			html = text;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return html;
	}
	
	
}
