package crawlingTest;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class crawlingTest {

	public static void main(String[] args) throws IOException {
		String site_1 = "https://finance.naver.com/item/main.nhn?code=";
		String[] company = {"012690","005930","005380","011000","000660"};
		String[] company_name = { "모나리자", "삼성전자", "현대차", "진원생명과학", "sk하이닉스"};
		// 배열돌리기
		for (int i = 0; i < company.length; i++) {
		Connection con = Jsoup.connect(site_1 + company[i]); //사이트와 연결한다
		Document doc = con.get();
		String date = doc.select("em.date").text(); // 날짜 갖고오기
		System.out.println(date.substring(0, 10)); // 0~9 인덱스 추출
		System.out.println("회사명 : " + company_name[i]); //회사이름 배열 출력
		System.out.println("오늘가 : " + doc.select("span.blind").get(12).text());
		System.out.println("전일 : " + doc.select("span.blind").get(15).text());
		System.out.println("시가 : " + doc.select("span.blind").get(19).text());
		//System.out.println(doc.select("td.first").text());
		System.out.println("------------------------------");
		}
	}
}
