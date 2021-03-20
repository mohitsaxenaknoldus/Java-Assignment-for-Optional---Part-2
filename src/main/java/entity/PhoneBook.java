package entity;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBook {
    private Map<String, Long> phoneBook = Stream.of(new Object[][] {
            { "Mohit", 8447507369L },
            { "Nitin", 1234567890L },
            { "Kiran", 1122334455L },
            { "Sakshi", 1112223330L },
            { "Shivani", 1111222233L },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Long) data[1]));

    public Map<String, Long> getPhoneBook() {
        return phoneBook;
    }

    /**
     * Overridden toString() for PhoneBook
     * @return
     */
    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    /**
     * Method to find phone number using name
     * @param name
     * @return
     */
    public Optional findPhoneByName(String name)
    {
        return (phoneBook.containsKey(name)) ? Optional.of(phoneBook.get(name)) : Optional.empty();
    }

    /**
     * Method to find name using phone number
     * @param name
     * @param phone
     * @return
     */
    public Optional findNameByPhoneNumber(String name, long phone)
    {
        Optional result = phoneBook.entrySet().stream()
                .filter(e -> name.equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();

        return (result.isPresent()) ? result : phoneBook.entrySet().stream()
                .filter(e -> phone == e.getValue())
                .map(Map.Entry::getValue)
                .findFirst();
    }
}
