/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.persistence;

/**
 *
 * @author 2133832
 */
public class ChillParkNotFoundException extends Exception{

    public ChillParkNotFoundException(String message) {
        super(message);
    }

    public ChillParkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}