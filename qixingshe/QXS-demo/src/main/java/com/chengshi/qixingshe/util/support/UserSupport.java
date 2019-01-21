package com.chengshi.qixingshe.util.support;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-05 10:02
 */
@Data
public class UserSupport {
    private Date fDate;
    private Date tDate;
    private String nickname;

    public UserSupport(Date fDate, Date tDate, String nickname) {
        this.fDate = fDate;
        this.tDate = tDate;
        this.nickname = nickname;
    }
    public UserSupport(String fDate, String tDate, String nickname) {
        setfDate(fDate);
        settDate(tDate);
        this.nickname = nickname;
    }

    public void setfDate(String date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fDate=format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void settDate(String date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.tDate=format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }
}
