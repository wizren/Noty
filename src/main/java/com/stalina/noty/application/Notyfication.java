package com.stalina.noty.application;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Notyfication {
    public LocalDateTime Deadline;
    public String Name;
    public String Descrption;
    public int Priotity = 0;

    public Notyfication(LocalDateTime deadline, String name, String description, int priority) {
        Deadline = deadline;
        Name = name;
        Descrption = description;
        Priotity = priority;
    }
}
