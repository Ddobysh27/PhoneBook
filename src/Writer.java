import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class Writer {
  public void write(ListContacts listContacts){
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
