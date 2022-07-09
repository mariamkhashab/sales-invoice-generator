/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class header {
    
    private int id;
    private Date date;
    private String customer;
    private double total;
    private ArrayList<line> lines;

    public header(int id, Date date, String customer,ArrayList<line> lines) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.lines = lines;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        total=0;
        for (line l: this.lines)
        {
        total+= l.getTotal();
        }
        
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<line> lines) {
        this.lines = lines;
    }

    
    
}
