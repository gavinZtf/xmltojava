package com.ztf.start;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import com.ztf.entity.Customer;

public class JAXBExample {
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

			String xmlString = "";
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			StringWriter sw = new StringWriter();
	        jaxbMarshaller.marshal(customer, sw);
	        xmlString = sw.toString();
	        System.out.println(xmlString);
	        
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}