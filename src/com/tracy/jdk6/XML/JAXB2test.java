/**
 * 
 */
package com.tracy.jdk6.XML;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author tracy.lu

 * @date:2012-7-6 下午2:49:29
 * @version :
 *
 */
public class JAXB2test {
	
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Person.class);
		//下面代码演示将对象转变为xml
		Marshaller m=context.createMarshaller();
		Address address = new Address("China", "Beijing", "Beijing", "ShangDi West", "100080");
	    Person p = new Person(Calendar.getInstance(), "JAXB2", address, Gender.MALE, "SW");
	    FileWriter fw = new FileWriter("person.xml");
	    m.marshal(p, fw);
	    //下面代码演示将上面生成的xml转换为对象
	    FileReader fr = new FileReader("person.xml");
	    Unmarshaller um = context.createUnmarshaller();
	    Person p2 = (Person) um.unmarshal(fr);
	    System.out.println("Country:" + p2.getAddress().getCountry());
	}
	
@XmlRootElement
//表示person是一个根元素
static class Person{
	 @XmlElement
	Calendar birthday;//birthday将作为person的子元素
	 @XmlElement
	String name;//name将作为person的的一个属性
	
	public Address getAddress(){
		return address;
	}
	 @XmlElement
	Address address;//address将作为person的子元素
	 @XmlElement
	Gender gender;//gender将作为person的子元素
	 @XmlElement
	String job; //job将作为person的子元素
	
	public Person(){
	}
	
	 public Person(Calendar birthDay, String name, Address address, Gender gender, String job) {
         this.birthday = birthDay;
         this.name = name;
         this.address = address;
         this.gender = gender;
         this.job = job;
}
}
enum Gender {
    MALE(true), FEMALE(false);
    private boolean value;



    Gender(boolean _value) {
              value = _value;
    }
}
static class Address{
	@XmlAttribute
	String country;
	@XmlElement
	String state;
	@XmlElement
	String city;
	@XmlElement
	String street;
	String zipcode;//由于没有添加@XmlElement,所以该元素不会出现在输出的xml中
	
	public Address(){
		
	}
	public Address(String country,String state,String city,String street,String zipcode){
		this.country=country;
		this.city=city;
		this.state=state;
		this.street=street;
	}
	
	public String getCountry(){
		return country;
	}
	
}


}
