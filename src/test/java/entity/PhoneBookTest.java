package entity;

import java.util.Optional;

import static org.junit.Assert.*;

public class PhoneBookTest {

    private PhoneBook phoneBook = new PhoneBook();

    @org.junit.Test
    public void findPhoneByName() {
        assertEquals(phoneBook.findPhoneByName("Mohit"), Optional.of(8447507369L));
    }

    @org.junit.Test
    public void findNameByPhoneNumber() {
        assertEquals(phoneBook.findNameByPhoneNumber("Mohit", 8447507369L), Optional.of(8447507369L));
    }
}