package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class PhoneDB {

	public void readPhoneDB(List<Person> person) throws Exception {

		Reader fr = new FileReader("C:\\javaStudy\\workspace\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String s = br.readLine();

			if (s == null) {
				break;
			}
			String data[] = s.split(",");
			person.add(new Person(data[0], data[1], data[2]));
		}

		br.close();
	}

	public void writePhoneDB(List<Person> person) throws Exception {

		Writer fw = new FileWriter("C:\\javaStudy\\workspace\\PhoneDBtest.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < person.size(); i++) {
			bw.write(person.get(i).getName() + ", " + person.get(i).getHp() + ", " + person.get(i).getCompany());
			bw.newLine();
		}

		bw.close();
	}
}
