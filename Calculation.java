/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphdemo;
import java.text.DecimalFormat;

/**
 *
 * @author angeliquerivera
 */
public abstract class Calculation {
 
    protected static final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    
    protected abstract double calculate();
    
}

