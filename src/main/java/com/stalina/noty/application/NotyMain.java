package com.stalina.noty.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.stalina.noty.application.NotyOperations.*;

public class NotyMain {
    public static NotyBase Base = new NotyBase();
    public static boolean isFirst = true;

    public static void main(String[] args) {
        chooseAction();
    }

    public static void chooseAction() {
        Scanner input = new Scanner(System.in);
        byte action;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime Deadline;
        String Name;
        String Description;
        int type, Priority;
        Priority = 0;
        if (isFirst) {
            System.out.println("Добро пожаловать в Noty!\n");
            isFirst = false;
        }
        System.out.println("Выберите действие:\n 0 — посмотреть все задачи"
                + "\n 1 — добавить задачу \n 2 — удалить задачу"
                + " \n 3 — редактировать задачу \n 4 — добавить задачу на стену"
                + "\n 5 — посмотреть архив задач \n 6 — выйти\n");
        action = input.nextByte();
        switch (action) {
            case 0:
                showAllCurrentNotifications();
                chooseAction();
                break;
            case 1:
                System.out.println("Введите задачу: ");
                Name = input.nextLine();
                System.out.println("Введите дедлайн в формате yyyy-MM-dd HH:mm: ");
                try {
                    Deadline = LocalDateTime.parse(input.nextLine(), formatter);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Некорректный параметр");
                }
                System.out.println("Введите описание задачи: ");
                try {
                    Description = input.nextLine();
                } catch (Exception e) {
                    throw new IllegalArgumentException("Некорректный параметр");
                }
                System.out.println("Введите приоритет задачи (0, 1, 2): ");
                try {
                    Priority = input.nextInt();
                } catch (Exception e) {
                    throw new IllegalArgumentException("Некорректный параметр");
                }
                addNotification(new Notyfication(Deadline, Name, Description, Priority));
                chooseAction();
                break;
            case 2:
                int index;
                System.out.println("Введите номер задачи, которую нужно удалить: ");
                showAllCurrentNotifications();
                try {
                    index = input.nextInt() - 1;
                } catch (Exception e) {
                    throw new IllegalArgumentException("Некорректный параметр");
                }
                removeNotification(index);
                chooseAction();
                break;
            case 3:
                System.out.println("Выберите, какую задачу редактировать, и введите её номер: ");
                showAllCurrentNotifications();
                try {
                    index = input.nextInt() - 1;
                } catch (Exception e) {
                    throw new IllegalArgumentException("Некорректный параметр");
                }
                System.out.println("\n 0 — изменить название \n 1 — изменить дедлайн \n 2 — изменить описание \n 3 — изменить приоритет \n ");
                type = input.nextInt();
                if (type == 0) {
                    System.out.println("Введите новое название задачи: ");
                    try {
                        Name = input.nextLine();
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Некорректный параметр");
                    }
                    editNotification(index, Name);
                } else if (type == 1) {
                    System.out.println("Введите новый дедлайн в формате yyyy-MM-dd HH:mm:  ");
                    try {
                        Deadline = LocalDateTime.parse(input.nextLine(), formatter);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Некорректный параметр");
                    }
                    editNotification(index, Deadline);
                } else if (type == 2) {
                    System.out.println("Введите новое описание:  ");
                    try {
                        Description = input.nextLine();
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Некорректный параметр");
                    }
                    editNotification(index, Description, 0);
                } else if (type == 3) {
                    System.out.println("Введите новый приоритет(0, 1, 2):  ");
                    try {
                        Priority = input.nextInt();
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Некорректный параметр");
                    }
                    editNotification(index, Priority);
                } else {
                    throw new IllegalArgumentException("Некорректная команда!");
                }
                chooseAction();
                break;
            case 4:
                addToTheWall();
                chooseAction();
                break;
            case 5:
                showArchive();
                chooseAction();
                break;
            case 6:
                System.exit(0);
            default:
                throw new IllegalArgumentException("Некорректная команда!");
        }

    }

}


