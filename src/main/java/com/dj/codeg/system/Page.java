package com.dj.codeg.system;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page<T> {
    Integer pageSize = 1;
    Long total = 0L;
    List<T> list = new ArrayList<>();
}
