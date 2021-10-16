package com.dj.codeg.system;

import lombok.Data;

@Data
public class PageForm {

    String words;

    int pageSize;

    int pageNum;

    String sortBy = "createdAt";
    boolean sortDesc = true;
}
