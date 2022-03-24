package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    static Repository repo = new Repository();
    static Manager manager = new Manager(repo);
    private static final String LED = "Ленинград";
    private static final String GOJ = "Горький";
    private static final String KUF = "Куйбышев";
    private static final String OGZ = "Орджоникидзе";
    private static final String FRU = "Фрунзе";

    static Ticket first = new Ticket(1937, 4884, LED, GOJ, 144);
    static Ticket second = new Ticket(2050, 488, KUF, OGZ, 80);
    static Ticket third = new Ticket(7692, 31972, FRU, KUF, 453);
    static Ticket fourth = new Ticket(4777, 11744, OGZ, GOJ, 121);


    @BeforeAll
    static void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
    }

    @Test
    public void shouldFindByNumber() {
        Ticket[] expected = {fourth};
        assertArrayEquals(expected, manager.findAll(OGZ, GOJ));
    }

    @Test
    public void shouldFindByAnotherNumber() {
        Ticket[] expected = {second};
        assertArrayEquals(expected, manager.findAll(KUF, OGZ));
    }

    @Test
    public void shouldShowAllOffers() {
        Ticket[] expected = {second, first, fourth, third};
        assertArrayEquals(expected, manager.findAllOffers());
    }

//    @Test
//    public void shouldSortByLowerPrice() {
//        Ticket[] expected = {first, second, third, fourth};
//        Ticket[] actual = {second, first, fourth, third};
//        Arrays.sort(actual);
//        assertArrayEquals(expected, actual);
//    }
}
