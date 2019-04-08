import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparator<Person>{
  @XmlElement(name = "fullName")
  String fullName;
  @XmlElement(name = "dateOfBurth")
  String dateOfBurth;
  @XmlElementWrapper(name = "phoneNumbers")
  @XmlElement(name = "phoneNumber")
  ArrayList<Integer> phoneNumbers = new ArrayList<>();
  @XmlElement(name = "adress")
  String adress;
  @XmlElement(name = "timeOfReg")
  String timeOfReg;

  public Person() {
  }

  public String getFullName() {
    return fullName;
  }

  public String getDateOfBurth() {
    return dateOfBurth;
  }

  public ArrayList<Integer> getPhoneNumbers() {
    return phoneNumbers;
  }

  public String getAdress() {
    return adress;
  }

  public String getTimeOfReg() {
    return timeOfReg;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setDateOfBurth(String dateOfBurth) {
    this.dateOfBurth = dateOfBurth;
  }

  public void setPhoneNumbers(ArrayList<Integer> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public void setTimeOfReg(String timeOfReg) {
    this.timeOfReg = timeOfReg;
  }

  public Person(String fullName, String dateOfBurth, ArrayList<Integer> phoneNumbers, String adress, String timeOfReg) {
    this.fullName = fullName;
    this.dateOfBurth = dateOfBurth;
    this.phoneNumbers = phoneNumbers;
    this.adress = adress;
    this.timeOfReg = timeOfReg;
  }

  public String toString() {
    String toStr = "";
    return toStr = "ФИО :" + getFullName() + "\n Дата рождения " + getDateOfBurth() + "\n Номера телефона: " + getPhoneNumbers().toString() + "\n Адрес :" + getAdress() + "\n Время регистрации :" + getTimeOfReg();
  }
  public int compare(Person a, Person b) {
    return a.getFullName().compareTo(b.getFullName());
  }
}