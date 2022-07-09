/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.header;
import model.line;
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
            {
                try {
                    try {
                        loadFile();
                    } catch (ParseException ex) {
                        Logger.getLogger(actionHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(actionHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
        int choice = this.gui.getHeadersTable().getSelectedRow();
        if (choice != -1)
        {
            header selectedHeader = this.gui.getHeadersList().get(choice);
            ArrayList<line> myLines= selectedHeader.getLines();
            this.gui.setLinesList(myLines);
            
            this.gui.getHeaderID().setText(String.valueOf(selectedHeader.getId()));
            this.gui.getHeaderDate().setText(String.valueOf(selectedHeader.getDate()));
            this.gui.getHeaderCust().setText(selectedHeader.getCustomer());
            this.gui.getHeaderTotal().setText(String.valueOf(selectedHeader.getTotal()));
        }
    }

    private void saveFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void loadFile() throws IOException, ParseException {
      JFileChooser f = new JFileChooser();
      int choice = f.showOpenDialog(this.gui);
      if (choice == JFileChooser.APPROVE_OPTION)
      {
      File headerFile = f.getSelectedFile();
      Path headerPath = Paths.get(headerFile.getAbsolutePath());
      ArrayList<header> headersList = new ArrayList<>();
      List<String> headers = Files.readAllLines(headerPath);
      
      for (String headerStr : headers)
      {
      String[] components = headerStr.split(",");
      int id = Integer.parseInt(components[0]);
      Date date = new SimpleDateFormat("dd-MM-yyyy").parse(components[1]);
      String name = components[2];
      header temp = new header(id,date,name);
      headersList.add(temp);
     
      }
     this.gui.setHeadersList(headersList);
      choice = f.showOpenDialog(this.gui);
        if (choice == JFileChooser.APPROVE_OPTION)
        {
        File linesFile = f.getSelectedFile();
        Path linePath = Paths.get(linesFile.getAbsolutePath());
        ArrayList<line> linesList = new ArrayList<>();
        List<String> lines = Files.readAllLines(linePath);
      for (String lineStr : lines)
        {
        String[] components = lineStr.split(",");
        int id = Integer.parseInt(components[0]);
        String item = components[1];
        double price = Double.parseDouble(components[2]);
        int count = Integer.parseInt(components[3]);
        header tempHeader = header.getHeaderByID(headersList, id);
        line myLine = new line(tempHeader,item,price,count);
        tempHeader.getLines().add(myLine);
        linesList.add(myLine);
        }
      this.gui.setLinesList(linesList);
      
      }
    }
    }

    private void getNewInvoice() {
        this.headerDialog = new newHeader(this.gui);
        System.out.println( this.headerDialog );
        this.headerDialog.setVisible(true);


    }

    private void deleteInvoice() {
        int choice = this.gui.getHeadersTable().getSelectedRow();
        if (choice != -1)
        {
        ArrayList<header> tempHeaderList = new ArrayList<header>();
        this.gui.getHeadersList().remove(choice);
        tempHeaderList = this.gui.getHeadersList();
        this.gui.setHeadersList(tempHeaderList);
        this.gui.setLinesList(new ArrayList<>());
        this.gui.getHeaderID().setText("");
        this.gui.getHeaderDate().setText("");
        this.gui.getHeaderCust().setText("");
        this.gui.getHeaderTotal().setText("");

        
        }
    }

    private void getNewLine() {
        this.lineDialog = new newLine(this.gui);
        this.lineDialog.setVisible(true);
    }

    private void deleteLine() {
        int choice = this.gui.getLinesTable().getSelectedRow();
        if (choice != -1)
        {
            this.gui.getLinesList().remove(choice);
            ArrayList<line> tempLineList = this.gui.getLinesList();
            this.gui.setLinesList(tempLineList);
            this.gui.getHeaderTableModel().fireTableDataChanged();
            this.gui.getLineTableModel().fireTableDataChanged();
            this.gui.getHeadersTable().setRowSelectionInterval(choice, choice);
            }
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
