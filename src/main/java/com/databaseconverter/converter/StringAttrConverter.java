package com.databaseconverter.converter;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import jakarta.persistence.AttributeConverter;

public class StringAttrConverter implements AttributeConverter<String,String> {


   private final String AES = "AES"; // ini untuk algoritma yang digunakan

   private final byte[] encriptionKey = "cibakutenseuciha".getBytes();

   private final Cipher encriptCipher; // ini untuk excription

   private final Cipher decryptCipher; // ini untuk deciptrion
   
   /**
    * ini untuk meng konfigurasu object encriptionCipher dan decriptCipher
    * untuk menentukan algoritma yang digunakan dalam kasus ini menggunkaan algoritma AES
    * @Author alliano
    * @throws Exception
    */
   public StringAttrConverter() throws Exception {

         Key key = new SecretKeySpec(encriptionKey, AES);

         encriptCipher = Cipher.getInstance(AES);

         encriptCipher.init(Cipher.ENCRYPT_MODE,key);

         decryptCipher = Cipher.getInstance(AES);

         decryptCipher.init(Cipher.DECRYPT_MODE, key);
   }

   /**
    * ini untuk proses encription nya
    */
   @Override
   public String convertToDatabaseColumn(String attribute) {

      try{

         return Base64.getEncoder().encodeToString(encriptCipher.doFinal(attribute.getBytes()));

      }catch(Exception exception){

         throw new IllegalArgumentException(exception.getMessage());
      }
   }

   /**
    * ini untuk proses decription nya
    */
   @Override
   public String convertToEntityAttribute(String dbData) {
     
      try {

         return new String(decryptCipher.doFinal(Base64.getDecoder().decode(dbData)));

      } catch (Exception e) {

         throw new IllegalArgumentException(e);
      }
   }
   
}
