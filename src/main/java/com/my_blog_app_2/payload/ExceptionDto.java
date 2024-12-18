package com.my_blog_app_2.payload;

import java.util.Date;

public class ExceptionDto {
    private Date date;
    private String messsage;
    private String description;

    public ExceptionDto(Date date, String messsage, String description) {
        this.date = date;
        this.messsage = messsage;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
