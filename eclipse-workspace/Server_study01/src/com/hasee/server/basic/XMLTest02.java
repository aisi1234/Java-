package com.hasee.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 熟悉SAX解析流程
 * 1.获取解析工厂
 * 2.从解析工厂获取解析器
 * 3.编写处理器
 * 4.加载文档Document注册处理器
 * @author HASEE
 *
 */

public class XMLTest02 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		//3.编写处理器
		//4.加载文档Document注册处理器
		PersonHander hander = new PersonHander();
		//5.解析
		parser.parse(Thread.currentThread().getContextClassLoader().
				getResourceAsStream("com/hasee/server/basic/p1.xml"), hander);
		//获取数据
		List<Person> list = hander.getList();
		for(Person person:list) {
			System.out.println(person.getName()+"-->"+person.getAge());
		}
	}
}

class PersonHander extends DefaultHandler{
	
	List<Person> list;
	Person p;
	
	private String tag;
	
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("-----解析文档开始-----");
		list = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println(qName+"-->解析开始");
		if(qName.equals("person")) p = new Person();
		tag = qName;
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length).trim();
		if(null != tag) {
			if(str.length()>0) {
				if(tag.equals("name")) p.setName(str);
				if(tag.equals("age")) p.setAge(Integer.valueOf(str));
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println(qName+"-->结束");
		tag = null;
		if(qName.equals("person")) {
			//System.out.println(p.getName()+"***"+p.getAge());
			list.add(p);
		}
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("-----解析文档结束-----");
	}

	public List<Person> getList() {
		return list;
	}
}

class Person{
	private String name;
	private int age;
	
	public Person() {}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
