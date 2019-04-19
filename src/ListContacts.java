import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "listContact")
@XmlAccessorType(XmlAccessType.FIELD)

public class ListContacts{
  @XmlElementWrapper(name = "persons")
  @XmlElement(name = "person")
  private List<Person> persons = new ArrayList<Person>();

  public ListContacts() {

  }

  public ListContacts(List<Person> persons) {
    this.persons = persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }


  //нужно создать интерфейс ввода в конструктор Person
  public void addPerson(Person person){
    this.persons.add(person);
  }

  //при вызове метода коллекция сортируется по имени
  public void sortCatalogName(){
    Collections.sort(persons);
    /*Comparator<Person> pComp = (Comparator<Person>) new PersonNameComparator();
    TreeSet<Person> sortedList = new TreeSet(pComp);
    sortedList.addAll(this.persons);*/
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

  //возвращает true если персона найдена и удалена
  //false если не удалена
  public Person deletePerson(String fio){
    if(searchPerson(fio) != null){
        persons.remove(searchPerson(fio));
      return searchPerson(fio);
    } else return null;

  }


  public List<Person> getPersons() {
    return persons;
  }

  @Override
  public String toString() {
    return "\nListContacts{\n" +
            "persons=" + persons +
            '}';
  }
}