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

		PhoneView pV = new PhoneView();

		pV.title();

		while (true) {

			pV.start();

			String str = sc.nextLine();

			if (str.equals("5")) {
				pV.end();
				break;
			} else if (str.equals("1")) {
				System.out.println("<1.리스트>");

				pV.list(person);
			} else if (str.equals("2")) {
				System.out.println("<2.등록>");

				pV.insert(person);

				pDB.writePhoneDB(person);

			} else if (str.equals("3")) {
				System.out.println("<3.삭제>");

				pV.delete(person);

				pDB.writePhoneDB(person);

			} else if (str.equals("4")) {
				System.out.println("<4.검색>");

				pV.search(person);
			} else {
				pV.error();
			}
		}

		sc.close();
	}
}
