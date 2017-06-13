package com.ztf.start;


/**
 * 
 * 很好的另一种转换方式（ByteArrayOutputStream）
 * 
 * 
 */
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.ztf.entity.Customer;

public class JAXBExample2 {

	/**
	 * Using ByteArrayOutputStream
	 * 
	 * @param object
	 * @return
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * @throws SOAPException
	 * @throws TransformerException
	 */
	public static String printObjectToXML(final Object object) throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, SOAPException, TransformerException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(baos);
		xmlEncoder.writeObject(object);
		xmlEncoder.close();

		String xml = baos.toString();
		System.out.println(xml);

		return xml.toString();
	}
	
	public static void main(String[] args) {
		ArrayList<String> numberList = new ArrayList<String>();
	    numberList.add("01942652579");
	    numberList.add("01762752801");
	    numberList.add("8800545");

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);
		customer.setAddress("Dhaka, Bangladesh");
		customer.setMobileNo(numberList);
		
		try {
			printObjectToXML(customer);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
