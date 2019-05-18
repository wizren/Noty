package com.stalina.noty;

import com.stalina.noty.application.NotyMain;
import com.stalina.noty.application.NotyOperations;
import com.stalina.noty.application.Notyfication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class NotyOperationsTest {
    static NotyOperations TestNoty = new NotyOperations();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    static Notyfication task1 = new Notyfication(LocalDateTime.parse("2019-10-10 10:10", formatter), "ТестЗадача1", "Описание", 0);
    static Notyfication task2 = new Notyfication(LocalDateTime.parse("2019-11-10 14:10", formatter), "ТестЗадача2", "Описание2", 1);


    @BeforeAll
    static void testAddNotification()
    {
       TestNoty.addNotification(task1);
       TestNoty.addNotification(task2);
       assertEquals(2, NotyMain.Base.Current.size());
    }

    @Test
    void testRemoveNotification()
    {
        TestNoty.removeNotification(0);
        assertEquals(1,  NotyMain.Base.Current.size());
    }

    @Test
    void testEditNotification()
    {
        TestNoty.editNotification(0, "ТестЗадачаНовая");
        assertEquals("ТестЗадачаНовая",  NotyMain.Base.Current.get(0).Name);
        TestNoty.editNotification(0, "Новое описание", 0);
        assertEquals("Новое описание", NotyMain.Base.Current.get(0).Descrption);
        TestNoty.editNotification(0, LocalDateTime.parse("2019-10-17 10:10", formatter));
        assertEquals( LocalDateTime.parse("2019-10-17 10:10", formatter),  NotyMain.Base.Current.get(0).Deadline);
        TestNoty.editNotification(0, LocalDateTime.parse("2019-10-17 10:10", formatter));
        assertEquals( LocalDateTime.parse("2019-10-17 10:10", formatter),  NotyMain.Base.Current.get(0).Deadline);
        TestNoty.editNotification(0, 2);
        assertEquals(2,  NotyMain.Base.Current.get(0).Priotity);
    }


}