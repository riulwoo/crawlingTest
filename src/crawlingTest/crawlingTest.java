package crawlingTest;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class crawlingTest {

	public static void main(String[] args) throws IOException {
		String site_1 = "https://finance.naver.com/item/main.nhn?code=";
		String[] company = {"012690","005930","005380","011000","000660"};
		String[] company_name = { "�𳪸���", "�Ｚ����", "������", "�����������", "sk���̴н�"};
		// �迭������
		for (int i = 0; i < company.length; i++) {
		Connection con = Jsoup.connect(site_1 + company[i]); //����Ʈ�� �����Ѵ�
		Document doc = con.get();
		String date = doc.select("em.date").text(); // ��¥ �������
		System.out.println(date.substring(0, 10)); // 0~9 �ε��� ����
		System.out.println("ȸ��� : " + company_name[i]); //ȸ���̸� �迭 ���
		System.out.println("���ð� : " + doc.select("span.blind").get(12).text());
		System.out.println("���� : " + doc.select("span.blind").get(15).text());
		System.out.println("�ð� : " + doc.select("span.blind").get(19).text());
		//System.out.println(doc.select("td.first").text());
		System.out.println("------------------------------");
		}
	}
}
