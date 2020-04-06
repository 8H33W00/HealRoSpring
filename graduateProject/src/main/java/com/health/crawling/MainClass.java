package com.health.crawling;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class MainClass {
	public static void main(String[] args) throws IOException {
		String url = "http://www.hospitalmaps.or.kr/hm/frHospital/hospital_list_1.jsp?s_mid=010100&s_addr_1=Seoul&s_hosp_gb_cd=01";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements containers = doc.select("#DIV_LIST > table > tbody > tr");
		int cnt = 1;
		for(org.jsoup.nodes.Element container : containers) {
			System.out.println(cnt++);
			
//			System.out.println(container);
			Elements imgCon = container.select("img");
//			System.out.println(imgCon);
			String rawImg = imgCon.attr("abs:src");
			System.out.println(rawImg);
			
			Elements nameCon = container.select("");
		}
	}
}
