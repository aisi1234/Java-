package com.hasee.server.basic;

import java.io.IOException;

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

public class XMLTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		//3.编写处理器
		//4.加载文档Document注册处理器
		PHander hander = new PHander();
		//5.解析
		parser.parse(Thread.currentThread().getContextClassLoader().
				getResourceAsStream("com/hasee/server/basic/p1.xml"), hander);
		
	}
}

class PHander extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("-----解析文档开始-----");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"-->解析开始");
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length).trim();
		if(str.length() > 0) System.out.println(str);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"-->结束");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("-----解析文档结束-----");
	}
}
