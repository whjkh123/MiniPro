package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws Exception {

		Reader fr = new FileReader("C:\\javaStudy\\workspace\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		List<Person> person = new ArrayList<Person>();

		Scanner sc = new Scanner(System.in);

		System.out.println("*****************************************");
		System.out.println("*	      전화번호 관리 프로그램	    	*");
		System.out.println("*****************************************");

		while (true) {
			System.out.println("1.리스트\t" + "2.등록\t" + "3.삭제\t" + "4.검색\t" + "5.종료");
			System.out.println("-----------------------------------------");
			System.out.print(">메뉴번호: ");

			String str = sc.nextLine();

			if (str.equals("5")) {
				System.out.println("************************************");
				System.out.println("*             감사합니다.             *");
				System.out.println("************************************");
				break;
			} else if (str.equals("1")) {
				System.out.println("<1.리스트>");

				while (true) {
					String s = br.readLine();

					if (s == null) {
						break;
					}
					// ","를 기준으로 데이터 입력 data[0](name) "," data[1](hp) "," data[2](company)
					String data[] = s.split(",");
					person.add(new Person(data[0], data[1], data[2]));
				}

				for (int i = 0; i < person.size(); i++) {
					person.get(i).showInfo(i + 1);
				}
				System.out.println("");
			} else if (str.equals("2")) {
				System.out.println("<2.등록>");

				System.out.print(">이름: ");
				String name = sc.nextLine();
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				System.out.print(">회사전화: ");
				String company = sc.nextLine();

				Person pData = new Person(name, hp, company);

				person.add(pData);

				System.out.println("[등록되었습니다.]");
				System.out.println("");
			} else if (str.equals("3")) {
				System.out.println("<3.삭제>");

				System.out.print(">번호: ");
				int num = sc.nextInt();

				person.remove(num);
				sc.nextLine();// Scanner 버그 대책

				System.out.println("[삭제되었습니다.]");
				System.out.println("");
			} else if (str.equals("4")) {
				System.out.println("<4.검색>");

				System.out.print(">이름: ");
				String name = sc.nextLine();

				for (int i = 0; i < person.size(); i++) {
					// 문자열.contains("찾을 문자열") > 한 문자열이 특정 문자열을 포함하고 있는지 확일할 때 사용
					// >> 포함 여부만을 true, false로 반환
					if (person.get(i).getName().contains(name)) {
						person.get(i).showInfo(i + 1);
					}
				}
				System.out.println("[검색이 완료되었습니다.]");
				System.out.println("");
			} else {
				System.out.println("[다시 입력해주세요.]");
				System.out.println("");
			}
		}
		br.close();
		sc.close();
	}
}
