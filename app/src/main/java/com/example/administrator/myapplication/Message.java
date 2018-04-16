package com.example.administrator.myapplication;

public class Message {
    private String msg_type,msg_people,msg_time;
    int page,size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_people() {
        return msg_people;
    }

    public void setMsg_people(String msg_people) {
        this.msg_people = msg_people;
    }

    public String getMsg_time() {
        return msg_time;
    }

    public void setMsg_time(String msg_time) {
        this.msg_time = msg_time;
    }

    @Override
    public String toString() {
        return msg_type;
    }
}
