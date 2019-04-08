import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phoneNumber")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber {
  @XmlElement(name = "number")
  private Integer number;

  public PhoneNumber (Integer number){
    this.number = number;
  }

  public PhoneNumber(){

  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "PhoneNumber{" +
            "number=" + number +
            '}';
  }
}
