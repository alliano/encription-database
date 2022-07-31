package com.databaseconverter.models.entities;

import java.io.Serializable;

import org.hibernate.annotations.ColumnTransformer;

import com.databaseconverter.converter.StringAttrConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

public @Setter @Getter @Table(name =  "userdetail") @Entity class UserDetail implements Serializable {

   private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

   private @Column(length = 50,nullable = false) String name;

   /**
    * untuk annotasi @ColumnTransformer(write="",read="")
    * ini sepeuhnya di handle sama database nya jadi haru tau function untuk encrypt dan bcrypt di database tersebut
    * dalam hal ini menggunkan fungsi dari mysql 
    * keuntungan memnggunakan ini tidakperlu menulis baris kode yang panjang tapi harus mengetahui fungsi dari database
    * yang digunakan
    */

   private @Column(name = "email",nullable = false, unique = true) @ColumnTransformer(write = "HEX(AES_ENCRYPT(?,'cibakutenseuciha'))",read = "AES_DECRYPT(UNHEX(email),'cibakutenseuciha')") String email;

   /**
    * untuk annotasi @Convert(converter = "")
    * ini sepenuhnya di handle sama jpa jadi ga pusing lagi mikirim function decrypt dan encrypt di database nya nameun 
    * kekurangan dari ini adalah kita perlu meng implementasi suatu interface senggia kita akan menuliskan
    * kode yang lumayan pajang
    */
   private @Column(nullable = false,unique = true) @Convert(converter = StringAttrConverter.class) String cardNumber;

   private @Column(length = 10,nullable = false) String expayert;
}
