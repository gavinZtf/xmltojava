package com.ztf.convert;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.ztf.newentity.Person;
import com.ztf.newentity.PhoneNumber;

/**
 * 主要测试利用XStream 来对xml和java对象之间来进行转化
 * @author ztf
 *
 */
public class TestNewEntity {

	public static void main(String[] args) {
		XStream xstream = new XStream();
//		XStream xstream = new XStream(new DomDriver()); // does not require XPP3 library
//		XStream xstream = new XStream(new StaxDriver()); // does not require XPP3 library starting with Java 6
		
		xstream.alias("person", Person.class);
		xstream.alias("phonenumber", PhoneNumber.class);
		
		Person joe = new Person("Joe", "Walnes");
		joe.setPhone(new PhoneNumber(123, "1234-456"));
		joe.setFax(new PhoneNumber(123, "9999-999"));
		
		String xml = xstream.toXML(joe);
		System.out.println(xml);
		
		Person newJoe = (Person)xstream.fromXML(xml);
		System.out.println(newJoe.getFirstname());
	}
}
