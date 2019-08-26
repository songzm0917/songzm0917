package com.songzm.rediscache.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@Builder
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //@Id
    //@GeneratedValue(generator = "JDBC")
    private Long id;
    private String name;
    private String password;
    private String loginAddress;
    private Long gradeId;



}