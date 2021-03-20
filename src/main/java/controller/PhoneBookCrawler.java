package controller;

import entity.PhoneBook;

import java.util.Map;
import java.util.Optional;

public class PhoneBookCrawler {

    /**
     * Implements findPhoneByName() method of PhoneBook
     * @param name
     * @return Returns name if found else punishes
     */
    public Optional findPhoneByNameAndPunishIfNothingFound(String name)
    {
        PhoneBook phoneBook = new PhoneBook();
        Optional result = phoneBook.findPhoneByName(name);

        return (result.isPresent()) ? Optional.of(result.get()) : Optional.of("Punish");
    }

    /**
     * Implements findPhoneByName() method of PhoneBook
     * @param name
     * @return Returns name if found else returns PhoneBook
     */
    public Optional findPhoneByNameAndPrintPhoneBookIfNothingFound(String name)
    {
        PhoneBook phoneBook = new PhoneBook();
        Optional result = phoneBook.findPhoneByName(name);

        return (result.isPresent()) ? Optional.of(result.get()) : Optional.of(phoneBook);
    }

    /**
     * Implements findPhoneByName() method of PhoneBook using Streams
     * @param name
     * @return Returns name if found else punishes
     */
    public Optional findPhoneByNameAndPunishIfNothingFoundUsingStreams(String name)
    {
        PhoneBook phoneBook = new PhoneBook();
        Optional result = phoneBook.getPhoneBook().entrySet().stream()
                .filter(e -> name.equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();

        return (result.isPresent()) ? Optional.of(result.get()) : Optional.of("Punish");
    }

    /**
     * Implements findPhoneByName() method of PhoneBook using Streams
     * @param name
     * @return Returns name if found else returns PhoneBook
     */
    public Optional findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreams(String name)
    {
        PhoneBook phoneBook = new PhoneBook();
        Optional result = phoneBook.getPhoneBook().entrySet().stream()
                .filter(e -> name.equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();

        return (result.isPresent()) ? Optional.of(result.get()) : Optional.of(phoneBook);
    }

    /**
     * Implements findNameByPhoneNumber() method of PhoneBook
     * @param name
     * @param phone
     * @return Returns name if found else returns empty
     */
    public Optional findPhoneNumberByNameOrNameByPhoneNumber(String name, long phone)
    {
        PhoneBook phoneBook = new PhoneBook();
        Optional result = phoneBook.findNameByPhoneNumber(name, phone);

        return (result.isPresent()) ? Optional.of(result.get()) : Optional.empty();
    }

    public static void main(String[] args) {
        PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler();

        //Exercise 2
        Optional phone = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Mohit");
        System.out.println(phone.get());

        //Exercise 3
        Optional phone2 = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Ravi");
        System.out.println(phone2.get().toString());

        //Exercise 5
        Optional phone3 = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Mohit");
        System.out.println(phone3.get());

        //Exercise 6
        Optional phone4 = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreams("Ravi");
        System.out.println(phone4.get().toString());

        //Exercise 7
        Optional phone7 = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Mohit",
                8447507369L);
        if(phone7.isPresent())
        {
            System.out.println(phone7.get());
        }
        else
        {
            System.out.println("Not Found!");
        }
    }
}
