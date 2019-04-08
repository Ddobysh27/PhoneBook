import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Test {
  ArrayList<Integer> numbers = new ArrayList();

  public void addNumbers() {
    numbers.add(123);
    numbers.add(12345);
  }

  public void Test() {
    Person person1 = new Person("Full name1",
            "Date Of Burth1",
            numbers, "adress1",
            "time1");
    Person person2 = new Person("Full name2",
            "Date Of Burth2",
            numbers, "adress2",
            "time2");

    ListContacts listContacts = new ListContacts();
    listContacts.addPerson(person1);
    listContacts.addPerson(person2);

    //Person person = new Person()
    try {
      // marshall to XML
      JAXBContext context = JAXBContext.newInstance(ListContacts.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(listContacts, System.out);
      marshaller.marshal(listContacts,  new FileOutputStream("marsh.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}


