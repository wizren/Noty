package com.stalina.noty.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class NotyBase implements Serializable {
    List<Notification> Archive;
    List<Notification> Current;

    NotyBase() {
        Archive = new ArrayList<>(16);
        Current = new ArrayList<>(16);
    }
}
