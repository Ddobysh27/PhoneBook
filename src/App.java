import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
  //FrontEnd
  public static void main(String[] args) {
    ListContacts listContacts = new ListContacts();
    Menu menu = new Menu();
    menu.addEntry(new MenuEntry("Добавить контакт") {
      @Override
      public void run() {
        try {
          Scanner scanner = new Scanner(System.in);
          ArrayList<Integer> phoneNumber = new ArrayList();
          System.out.println("Сколько у пользователя номеров?");
          int countOfNumbers = Integer.parseInt(scanner.nextLine());
          for (int i = 1; i <= countOfNumbers; i++) {
            System.out.println("Ведите номер " + i);
            phoneNumber.add(Integer.parseInt(scanner.nextLine()));
          }
          System.out.println("Введите ФИО пользователя");
          String fullName = scanner.nextLine();
          System.out.println("Введите дату рождения");
          String dateOfBurth = scanner.nextLine();
          System.out.println("Введите адрес");
          String adress = scanner.nextLine();
          Date date = new Date();
          String timeOfReg = date.toString();
          Person person = new Person(fullName, dateOfBurth, phoneNumber, adress, timeOfReg);
          listContacts.addPerson(person);
          System.out.println("Добавлен пользователь\n" + person.toString());
        } catch (Exception e) {
          System.out.println("Ошибка в addPerson " + e.getMessage());
          e.printStackTrace();
        }

      }
    });

    menu.addEntry(new MenuEntry("Удалить контакт") {
      @Override
      public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО пользователя: ");
        String fName = scanner.nextLine();
        Person deletedPerson = listContacts.searchPerson(fName);
        if (deletedPerson!= null){
          System.out.println("Контакт удалён: ");
          System.out.println(deletedPerson.toString());
          listContacts.deletePerson(fName);
        }else System.out.println("Запись не удалена ");
      }
    });

    menu.addEntry(new MenuEntry("Поиск контакта") {
      @Override
      public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО пользователя");
        String fName = scanner.nextLine();
        Person searchedPerson = listContacts.searchPerson(fName);
        if (searchedPerson != null){
          System.out.println(searchedPerson.toString());
        }else System.out.println("Запись не обнаружена ");
      }
    });

    menu.addEntry(new MenuEntry("Сортировка записей") {
      @Override
      public void run() {
        listContacts.sortCatalogName();
        System.out.println("\n Отсортированный список - " + listContacts.toString());
      }
    });

    menu.addEntry(new MenuEntry("Прочитать из файла xml") {
      @Override
      public void run() {
        Reader reader = new Reader();
        try {
          listContacts.setPersons( reader.read());
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("Прочитать из файла run");
      }
    });

    menu.addEntry(new MenuEntry("Записать в файл xml") {
      @Override
      public void run() {
        Writer writer = new Writer();
        writer.write(listContacts);
        System.out.println("Записать в файл xml");
      }
    });

    menu.addEntry(new MenuEntry("SHOW") {
      @Override
      public void run() {
        System.out.println(listContacts.toString());
      }
    });

    menu.run();
  }


}
