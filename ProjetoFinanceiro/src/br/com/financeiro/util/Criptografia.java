package br.com.financeiro.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *Método que criptografa uma String em MD5
 * @author HELDER
 */
public class Criptografia {
    
    public String md5(String senha){      
        
          try{
                MessageDigest md = MessageDigest.getInstance("MD5");  

                md.update(senha.getBytes());  
                BigInteger hash = new BigInteger(1, md.digest());  
                senha = hash.toString(16);                  
            }catch(NoSuchAlgorithmException ns){
                System.out.println(ns.getMessage() + "Falha ao criptografar senha");
            }            
        return senha;
    }
}
