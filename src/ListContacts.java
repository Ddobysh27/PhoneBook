import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@XmlRootElement(name = "listContact")
@XmlAccessorType(XmlAccessType.FIELD)

public class ListContacts {
  @XmlElementWrapper(name = "persons")
  @XmlElement(name = "person")
  private List<Person> persons = new ArrayList<>();

  public ListContacts() {

  }

  public ListContacts(List<Person> persons) {
    this.persons = persons;
  }

  //нужно создать интерфейс ввода в конструктор Person
  public void addPerson(Person person){
    this.persons.add(person);
  }

  //при вызове метода коллекция сортируется по имени
  public void sortCatalogName(){
    Comparator<Person> pComp = (Comparator<Person>) new PersonNameComparator();
    TreeSet<Person> sortedList = new TreeSet(pComp);
    sortedList.addAll(this.persons);
  }

  //метод возвращает Person по FIO String, т.е. после вызова засунуть найденного Person.toString в sout
  //если объекта не найден, то возвращает null
  //if (person == null) sout  "Записи нет в базе"
  public Person searchPerson (String fio){
    for (Person person : persons){
      if(person.getFullName().equals(fio)){
        return person;
      }
    }
    return null;
  }







  public List<Person> getPersons() {
    return persons;
  }




  @Override
  public String toString() {
    return "ListContacts{" +
            "persons=" + persons +
            '}';
  }
}
