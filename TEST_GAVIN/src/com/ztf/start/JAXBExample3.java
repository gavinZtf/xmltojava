package com.ztf.start;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.StringUtils;

import com.ztf.entity.Customer;

public class JAXBExample3 {

	public static <T> String convertToXml(T source, Class<T> clazz) throws JAXBException {
		String result;
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		QName qName = new QName(StringUtils.uncapitalize(clazz.getSimpleName()));
		JAXBElement<T> root = new JAXBElement<T>(qName, clazz, source);
		jaxbMarshaller.marshal(root, sw);
		result = sw.toString();
		return result;
	}

	public static <T> T createObjectFromXmlString(String xml, Class clazz) throws JAXBException, IOException {

		T value = null;
		StringReader reader = new StringReader(xml);
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<T> rootElement = jaxbUnmarshaller.unmarshal(new StreamSource(reader), clazz);
		value = rootElement.getValue();
		return value;
	}

	public static void main(String[] args) {
		
//		ArrayList<String> numberList = new ArrayList<String>();
//	    numberList.add("01942652579");
//	    numberList.add("01762752801");
//	    numberList.add("8800545");
//
//		Customer customer = new Customer();
//		customer.setId(100);
//		customer.setName("mkyong");
//		customer.setAge(29);
//		customer.setAddress("Dhaka, Bangladesh");
//		customer.setMobileNo(numberList);
//		
//		try {
//			String convertToXml = convertToXml(customer, Customer.class);
//			System.out.println(convertToXml);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		sb.append("<customer id=\"100\">");
		sb.append("<address>Dhaka, Bangladesh</address>");
		sb.append("<age>29</age>");
		sb.append("<mobileNo>01942652579</mobileNo>");
		sb.append("<mobileNo>01762752801</mobileNo>");
		sb.append("<mobileNo>8800545</mobileNo>");
		sb.append("<name>mkyong</name>");
		sb.append("</customer>");
		
		try {
			Customer c = createObjectFromXmlString(sb.toString(), Customer.class);
			System.out.println(c.getMobileNo());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
