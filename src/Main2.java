import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.*;

public class Main2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList();
    ListContacts listContacts = new ListContacts();
    printMenu(listContacts);
  }

  public static ListContacts getListCont (ListContacts listContacts){
    return listContacts;
   }

  public static void printMenu(ListContacts spravochnik) {
    ArrayList personList =
            new ArrayList(spravochnik.getPersons());
    Scanner scanner = new Scanner(System.in);
    System.out.println("" +
            "\n Выберите пункт меню " +
            "\n 1. Добавить контакт " +
            "\n 2. Удалить контакт " +
            "\n 3. Поиск контакта " +
            "\n 4. Сортировка записей " +
            "\n 5. Прочитать из файла " +
            "\n 6. Записать в файл " +
            "\n 7. Выход");
    try {
      int x = Integer.parseInt(scanner.next());
      if (x > 0 && x < 8) {
        switch (x) {
          case 1:
            addPerson(personList);
            printMenu(spravochnik);
            break;
          case 2:
            deletePerson(spravochnik);

          case 3:
            searchPerson(personList);
            printMenu(spravochnik);
          case 4:
           // sortList(personList);
            printMenu(spravochnik);
          case 5:
            inputList();
            printMenu(spravochnik);
          case 6:
            outputList(spravochnik);
            printMenu(spravochnik);
          case 7:
            System.exit(0);
        }
      } else {
        System.out.println("Вы ввели неверное число");
        printMenu(spravochnik);
      }
    } catch (Exception e) {
      System.out.println("Ошибка в main " + e.getMessage());
      e.printStackTrace();
      printMenu(spravochnik);
    }
  }

  public static void inputList() {

  }

  public static void outputList(ListContacts listContacts) {
    try {
      // marshall to XML
      //listContacts.toString();
      JAXBContext context = JAXBContext.newInstance(ListContacts.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(listContacts, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  public static void sortList(ArrayList personList) {
    Comparator<Person> pComp =
            (Comparator<Person>) new PersonNameComparator();
    TreeSet<Person> sortedList = new TreeSet(pComp);
    sortedList.addAll(personList);
    System.out.println("\n Отсортированный список - " + sortedList.toString());
  }

  public static void addPerson(ArrayList personList1) {
    try {
      char YN;
      Scanner scanner = new Scanner(System.in);
      String fullName;
      String dateOfBurth;
      ArrayList<Integer> phoneNumber = new ArrayList();
      String adress;
      String timeOfReg;
      System.out.println("Сколько у пользователя номеров?");
      int countOfNumbers = Integer.parseInt(scanner.nextLine());
      for (int i = 1; i <= countOfNumbers; i++) {
        System.out.println("Ведите номер " + i);
        phoneNumber.add(Integer.parseInt(scanner.nextLine()));
      }
      System.out.println("Введите ФИО пользователя");
      fullName = scanner.nextLine();
      System.out.println("Введите дату рождения");
      dateOfBurth = scanner.nextLine();
      System.out.println("Введите адрес");
      adress = scanner.nextLine();
      Date date = new Date();
      timeOfReg = date.toString();
      Person person = new Person(fullName,dateOfBurth, phoneNumber, adress,timeOfReg);

//////     // listContacts.addPerson(person);
      //personList1.addAll(listContacts.getPersons());
      System.out.println("Добавлен пользователь\n" + personList1.toString());
    } catch (Exception e) {
      System.out.println("Ошибка в addPerson " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void deletePerson(ListContacts listContacts) {
    String fName;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList(listContacts.getPersons());

    System.out.println("Введите ФИО пользователя");
    fName = scanner.nextLine();
    for (Person person : personList) {
      if (person.getFullName().equals(fName)) {
        personList.remove(person);
        System.out.println("\nУдалён пользователь \n" + person.toString());
        printMenu(listContacts);
      } else System.out.println("Записи нет в базе");
    }
  }

  public static void searchPerson(ArrayList<Person> personList) {
    String fName;
    Scanner scanner = new Scanner(System.in);
    if (personList.size() > 0) {
      System.out.println("Введите ФИО пользователя ");
      fName = scanner.nextLine();
      for (Person person : personList) {
        if (person.getFullName().equals(fName)) {
          System.out.println(person.toString());
        } else System.out.println("Записи нет в базе ");
      }
    } else {
      System.out.println("База пуста");
    }
  }

}
