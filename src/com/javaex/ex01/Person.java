package com.javaex.ex01;

public class Person {

	private String name, hp, company;

	public Person() {
		super();
	}

	public Person(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void draw(int i) {
		System.out.println(i + ". " + name + "\t" + hp + "\t" + company);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
}
