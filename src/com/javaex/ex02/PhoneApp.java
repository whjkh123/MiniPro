package com.javaex.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		List<Person> person = new ArrayList<Person>();

		PhoneDB pDB = new PhoneDB();

		pDB.readPhoneDB(person);

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

				for (int i = 0; i < person.size(); i++) {
					person.get(i).showInfo(i + 1);
				}

				System.out.println("[현재 등록된 회원수: " + person.size() + "명]");
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

				pDB.writePhoneDB(person);

				System.out.println("[등록되었습니다.]");
				System.out.println("");
			} else if (str.equals("3")) {
				System.out.println("<3.삭제>");

				System.out.print(">번호: ");
				int num = sc.nextInt();

				person.remove(num);
				sc.nextLine();

				pDB.writePhoneDB(person);

				System.out.println("[삭제되었습니다.]");
				System.out.println("");
			} else if (str.equals("4")) {
				System.out.println("<4.검색>");

				System.out.print(">검색: ");
				String name = sc.nextLine();

				int cnt = 0;

				for (int i = 0; i < person.size(); i++) {
					if (person.get(i).getName().contains(name)) {
						person.get(i).showInfo(i + 1);
						cnt++;
					}
				}

				System.out.println("[" + cnt + "명 검색되었습니다.]");
				System.out.println("");
			} else {
				System.out.println("[다시 입력해주세요.]");
				System.out.println("");
			}
		}

		sc.close();
	}
}
