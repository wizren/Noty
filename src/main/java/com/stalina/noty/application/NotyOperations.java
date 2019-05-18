package com.stalina.noty.application;

import java.time.LocalDateTime;

import static com.stalina.noty.application.NotyMain.Base;
import static com.stalina.noty.application.NotyMain.chooseAction;

public class NotyOperations {

    public static void addNotification(Notyfication notification) {
        Base.Current.add(notification);
        System.out.println("\n Задача добавлена! \n");
        chooseAction();
    }

    public static void printNotyfication(Notyfication notification) {
        System.out.println("<<" + notification.Name + ">> \n Описание:  "
                + notification.Descrption + "\n Дедлайн: " + notification.Deadline +
                "\n Приоритет: " + notification.Priotity + "\n");
    }

    public static void editNotification(int index, String Name) {
        Base.Current.get(index).Name = Name;
        System.out.println("\n Задача изменена: \n");
        printNotyfication(Base.Current.get(index));

    }

    public static void editNotification(int index, String Description, int check) {
        Base.Current.get(index).Name = Description;
        System.out.println("\n Задача изменена: \n");
        printNotyfication(Base.Current.get(index));

    }

    public static void editNotification(int index, LocalDateTime DeadLine) {
        Base.Current.get(index).Deadline = DeadLine;
        System.out.println("\n Задача изменена: \n");
        printNotyfication(Base.Current.get(index));

    }

    public static void editNotification(int index, int Priority) {
        Base.Current.get(index).Priotity = Priority;
        System.out.println("\n Задача изменена: \n");
        printNotyfication(Base.Current.get(index));

    }


    public static void showAllCurrentNotifications() {
        if (!Base.Current.isEmpty()) {
            for (int i = 0; i < Base.Current.size(); i++) {
                System.out.println(i + 1 + ". <<" + Base.Current.get(i).Name + ">> \n Описание:  "
                        + Base.Current.get(i).Descrption + "\n Дедлайн: " + Base.Current.get(i).Deadline +
                        "\n Приоритет: " + Base.Current.get(i).Priotity + "\n");
            }
        } else {
            System.out.println("Список задач пуст! \n");
        }
        System.out.println("\n");
    }

    public static void showArchive() {
        if (!Base.Archive.isEmpty()) {
            for (int i = 0; i < Base.Archive.size(); i++) {
                System.out.println(i + 1 + ". <<" + Base.Archive.get(i).Name + ">> \n Описание:  "
                        + Base.Archive.get(i).Descrption + "\n Дедлайн: " + Base.Archive.get(i).Deadline +
                        "\n Приоритет: " + Base.Archive.get(i).Priotity + "\n");
            }
        } else {
            System.out.println("Архив задач пуст! \n");
        }
        System.out.println("\n");
    }

    public static void removeNotification(int index) {
        Base.Archive.add(Base.Current.get(index));
        Base.Current.remove(index);
        System.out.println("\n Задача удалена!\n");
    }

    public static void addToTheWall() {
        //stas napishi tut))))))))))))))))))))))))))
    }
}
