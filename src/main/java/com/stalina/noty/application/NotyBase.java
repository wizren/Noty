package com.stalina.noty.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NotyBase implements Serializable {
    public List<Notyfication> Archive;
    public List<Notyfication> Current;

    NotyBase() {
        Archive = new ArrayList<>();
        Current = new ArrayList<>();
    }
}
