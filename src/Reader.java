import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Reader {
  public List read() throws Exception {
    try {
      JAXBContext jc = JAXBContext.newInstance(ListContacts.class);
      Unmarshaller u = jc.createUnmarshaller();
      FileReader reader = new FileReader("marsh.xml");
      ListContacts listContacts = (ListContacts) u.unmarshal(reader);
      System.out.println(listContacts);
      return listContacts.getPersons();
    } catch (JAXBException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}
