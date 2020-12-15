package com.javaex.ex02;

import java.util.List;
import java.util.Scanner;

public class PhoneView {

	Scanner sc = new Scanner(System.in);

	public void title() {
		System.out.println("*****************************************");
		System.out.println("*	      전화번호 관리 프로그램	    	*");
		System.out.println("*****************************************");
	}

	public void start() {
		System.out.println("1.리스트\t" + "2.등록\t" + "3.삭제\t" + "4.검색\t" + "5.종료");
		System.out.println("-----------------------------------------");
		System.out.print(">메뉴번호: ");
	}

	public void end() {
		System.out.println("************************************");
		System.out.println("*             감사합니다.             *");
		System.out.println("************************************");
	}

	public void list(List<Person> person) {
		for (int i = 0; i < person.size(); i++) {
			person.get(i).showInfo(i + 1);
		}

		System.out.println("[현재 등록된 회원수: " + person.size() + "명]");
		System.out.println("");
	}

	public void insert(List<Person> person) {
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
	}

	public void delete(List<Person> person) {
		System.out.print(">번호: ");
		int num = sc.nextInt();

		person.remove(num);
		sc.nextLine();

		System.out.println("[삭제되었습니다.]");
		System.out.println("");
	}

	public void search(List<Person> person) {
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
	}

	public void error() {
		System.out.println("[다시 입력해주세요.]");
		System.out.println("");
	}

}
