package controller;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PhoneBookCrawlerTest {

    private PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler();

    @Test
    public void findPhoneByNameAndPunishIfNothingFound() {
        assertEquals(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Mohit"), Optional.of(8447507369l));
    }

    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFound() {
        assertEquals(phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Mohit"), Optional.of(8447507369l));
    }

    @Test
    public void findPhoneByNameAndPunishIfNothingFoundUsingStreams() {
        assertEquals(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Mohit"), Optional.of(8447507369l));
    }

    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreams() {
        assertEquals(phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreams("Mohit"), Optional.of(8447507369l));
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber() {
        assertEquals(phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Mohit", 8447507369L), Optional.of(8447507369l));
    }
}