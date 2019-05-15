package com.stalina.noty.application;

import java.time.LocalDate;

class Notification {
    public LocalDate Deadline;
    public String Name;
    public String Descrption;
    public int Priotity = 0;

    Notification(LocalDate deadline, String name, String descrption, int priotity) {
        Deadline = deadline;
        Name = name;
        Descrption = descrption;
        Priotity = priotity;
    }
}
