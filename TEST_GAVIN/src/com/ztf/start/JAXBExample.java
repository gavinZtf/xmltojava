package com.ztf.start;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import com.ztf.entity.Customer;

public class JAXBExample {
	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);

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