/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.myGUI;
import view.newHeader;
import view.newLine;

/**
 *
 * @author Lenovo
 */
public class actionHandler implements ActionListener ,ListSelectionListener{

    private myGUI gui;
    private newHeader headerDialog;
    private newLine lineDialog;

    public actionHandler(myGUI gui) {
        this.gui = gui;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "Save File":
                saveFile();
                break;
            case "Load File":
                loadFile();
                break;
            case "New Invoice":
                getNewInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;  
            case "New Line":
                getNewLine();
                break;
            case "Delete Line":
                deleteLine();
                break;
            case "OK Header":
                postNewInvoice();
                break;
            case "Cancel Header":
                cancelNewHeader();
                break;  
            case "OK Line":
                postNewLine();
                break;
            case "Cancel Line":
                cancelNewLine();
                break;     
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void saveFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void loadFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void getNewInvoice() {
        this.headerDialog = new newHeader(this.gui);
        System.out.println( this.headerDialog );
        this.headerDialog.setVisible(true);


    }

    private void deleteInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void getNewLine() {
        this.lineDialog = new newLine(this.gui);
        this.lineDialog.setVisible(true);
    }

    private void deleteLine() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void postNewInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cancelNewHeader() {
        this.headerDialog.setVisible(false);
        this.headerDialog.dispose();
        this.headerDialog = null;
    }

    private void postNewLine() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cancelNewLine() {
        this.lineDialog.setVisible(false);
        this.lineDialog.dispose();
        this.lineDialog = null;    }
    
}
