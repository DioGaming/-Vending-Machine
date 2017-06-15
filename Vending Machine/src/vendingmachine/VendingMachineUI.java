/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;
/*
 * @author http://www.twitch.tv/diomondplaysgames
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Math;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VendingMachineUI extends javax.swing.JFrame {
    //money and coins
    double money = 0;
    double coins = 0;
    
    //products
    double GB_cost = 1.15;
    double CLIF_cost = 2.00;
    double cheetos_cost = 2.50;
    double KK_cost = 1.50;
    double cookie_cost = 1.00;
    double doritos_cost = 2.50;
    double lays_cost = 2.50;
    double nuts_cost = 0.75;
    double pretzel_cost = 0.60;
    double ruffles_cost = 2.50;
    double skittles_cost = 1.20;
    double twix_cost = 2.00;
    
    //recievable coins
    double coinsRC = 0;
    int nickelRC = 0;
    int dimeRC = 0;
    int quarterRC = 0;
    int loonieRC = 0;
    int toonieRC = 0;
    
    //button disable
    double btnDisabled = 0;
    
    //till
    int nickelTill;
    int dimeTill;
    int quarterTill;
    int loonieTill;
    int toonieTill;
    
    //inventory
    int cheetosINV;
    int cookieINV;
    int granolabarINV;
    int clifINV;
    int doritosINV;
    int nutsINV;
    int pretzelINV;
    int rufflesINV;
    int laysINV;
    int skittlesINV;
    int twixINV;
    int kitkatINV;
    
    
    public VendingMachineUI() {
        initComponents();
    }
        
    public void readerTill(){
        File bank = new File("Till.txt");
        
        try {
            Scanner scan = new Scanner(bank);
            
            int nickelBank = scan.nextInt();
            int dimeBank = scan.nextInt();
            int quarterBank = scan.nextInt();
            int loonieBank = scan.nextInt();
            int toonieBank = scan.nextInt();
            
            nickelTill = nickelBank;
            dimeTill = dimeBank;
            quarterTill = quarterBank;
            loonieTill = loonieBank;
            toonieTill = toonieBank;
        }catch(FileNotFoundException ex){
            System.out.printf("Something Went Wrong", ex);
        }
    }
    
    public void readerINV(){
        File Inventory = new File ("Inventory.txt");
        
        try {
            Scanner scan = new Scanner(Inventory);
            
            int cheetosInventory = scan.nextInt();
            int cookieInventory = scan.nextInt();
            int granolabarInventory = scan.nextInt();
            int clifInventory = scan.nextInt();
            int doritosInventory = scan.nextInt();
            int nutsInventory = scan.nextInt();
            int pretzelInventory = scan.nextInt();
            int rufflesInventory = scan.nextInt();
            int laysInventory = scan.nextInt();
            int skittlesInventory = scan.nextInt();
            int twixInventory = scan.nextInt();
            int kitkatInventory = scan.nextInt();
            
            cheetosINV = cheetosInventory;
            cookieINV = cookieInventory;
            granolabarINV = granolabarInventory;
            clifINV = clifInventory;
            doritosINV = doritosInventory;
            nutsINV = nutsInventory;
            pretzelINV = pretzelInventory;
            rufflesINV = rufflesInventory;
            laysINV = laysInventory;
            skittlesINV = skittlesInventory;
            twixINV = twixInventory;
            kitkatINV = kitkatInventory;
        }catch(FileNotFoundException ex){
            System.out.printf("Something Went Wrong", ex);
        }
    }
    
    public void changeCalc() {
    //calculator for coins 
    coins = Double.parseDouble(nickel.getText());
    coins = Double.parseDouble(dime.getText());
    coins = Double.parseDouble(quarter.getText());
    coins = Double.parseDouble(loonie.getText());
    coins = Double.parseDouble(toonie.getText());
    
    moneyOP.setText(Double.toString(coins));
}
    public void coinCalc(){
        //adding numbers to change recieved
        coinsRC = Double.parseDouble(changeOP.getText());
        
        while (coinsRC >= 2.00 && toonieTill > 0){
            toonieRC += 1;
            coinsRC -= 2.00;
            toonieTill -= 1;
        }
        
        while (coinsRC >= 1.00 && loonieTill > 0){
            loonieRC += 1;
            coinsRC -= 1.00;
            loonieTill -= 1;
        }
        
        while (coinsRC >= 0.25 && quarterTill > 0){
            quarterRC += 1;
            coinsRC -= 0.25;
            quarterTill -= 1;
        }
         
        while (coinsRC >= 0.10 && dimeTill > 0){
            dimeRC += 1;
            coinsRC -= 0.10;
            dimeTill -= 1;
        }
          
        while (coinsRC >= 0.05 && nickelTill > 0){
            nickelRC += 1;
            coinsRC -= 0.05;
            nickelTill -= 1;
        }
        
        //adding coin counting integers to label
        toonieOP.setText(Integer.toString(toonieRC));
        loonieOP.setText(Integer.toString(loonieRC));
        quarterOP.setText(Integer.toString(quarterRC));
        dimeOP.setText(Integer.toString(dimeRC));
        nickelOP.setText(Integer.toString(nickelRC));
}
    public void coinbtnDisable(){
        btnDisabled = Double.parseDouble(moneyOP.getText());
        
        if (btnDisabled >= 10){
            nickel.setEnabled(false);
            dime.setEnabled(false);
            quarter.setEnabled(false);
            loonie.setEnabled(false);
            toonie.setEnabled(false);
        }
    }
    
    public void inventoryUpdate(){
        
        if (GB.isSelected()) {
            
            granolabarINV -= 1;
            
        }else if (CLIF.isSelected()){

            clifINV -= 1;
            
        }else if (cheetos.isSelected()){

            cheetosINV -= 1;
            
        }else if (cookie.isSelected()){

            cookieINV -= 1;
            
        }else if (doritos.isSelected()){

            doritosINV -=1;
            
        }else if (KK.isSelected()){

            kitkatINV -=1;
            
        }else if (lays.isSelected()){

            laysINV -=1;
            
        }else if (nuts.isSelected()){

            nutsINV -= 1;
            
        }else if (pretzel.isSelected()){

            pretzelINV -=1;
            
        }else if (ruffles.isSelected()){

            rufflesINV -= 1;
            
        }else if (skittles.isSelected()){

            skittlesINV -= 1;
                    
        }else if (twix.isSelected()){

            twixINV -= 1;
            
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton2 = new javax.swing.JRadioButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cheetos = new javax.swing.JRadioButton();
        cookie = new javax.swing.JRadioButton();
        GB = new javax.swing.JRadioButton();
        CLIF = new javax.swing.JRadioButton();
        doritos = new javax.swing.JRadioButton();
        nuts = new javax.swing.JRadioButton();
        pretzel = new javax.swing.JRadioButton();
        ruffles = new javax.swing.JRadioButton();
        lays = new javax.swing.JRadioButton();
        skittles = new javax.swing.JRadioButton();
        twix = new javax.swing.JRadioButton();
        KK = new javax.swing.JRadioButton();
        cancel = new javax.swing.JButton();
        buy = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        moneyOP = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        changeOP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        nickel = new javax.swing.JButton();
        dime = new javax.swing.JButton();
        quarter = new javax.swing.JButton();
        loonie = new javax.swing.JButton();
        toonie = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        nickelOP = new javax.swing.JLabel();
        dimeOP = new javax.swing.JLabel();
        quarterOP = new javax.swing.JLabel();
        loonieOP = new javax.swing.JLabel();
        toonieOP = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        jRadioButton2.setText("jRadioButton2");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(898, 615));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Vending Machine");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Please Choose A Food");
        jLabel2.setPreferredSize(new java.awt.Dimension(260, 30));

        cheetos.setText("Cheetos Puffs");
        cheetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheetosActionPerformed(evt);
            }
        });

        cookie.setText("Chocolate Chip Cookie");
        cookie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cookieActionPerformed(evt);
            }
        });

        GB.setText("Quaker Granola Bar");
        GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GBActionPerformed(evt);
            }
        });

        CLIF.setText("CLIF Bar");
        CLIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLIFActionPerformed(evt);
            }
        });

        doritos.setText("Doritos");
        doritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doritosActionPerformed(evt);
            }
        });

        nuts.setText("Roasted Peanuts");
        nuts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutsActionPerformed(evt);
            }
        });

        pretzel.setText("Mini Pretzels");
        pretzel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pretzelActionPerformed(evt);
            }
        });

        ruffles.setText("Ruffles All Dressed");
        ruffles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rufflesActionPerformed(evt);
            }
        });

        lays.setText("Lays Original");
        lays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laysActionPerformed(evt);
            }
        });

        skittles.setText("Skittles");
        skittles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skittlesActionPerformed(evt);
            }
        });

        twix.setText("Twix");
        twix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twixActionPerformed(evt);
            }
        });

        KK.setText("Kit Kat");
        KK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KKActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        buy.setText("Purchase");
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });

        clear.setText("Clear Selection");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jLabel3.setText("$2.50");

        jLabel4.setText("$1.00");

        jLabel5.setText("$1.15");

        jLabel6.setText("$2.00");

        jLabel7.setText("$2.50");

        jLabel8.setText("$0.75");

        jLabel9.setText("$0.60");

        jLabel10.setText("$2.50");

        jLabel11.setText("$2.50");

        jLabel12.setText("$1.25");

        jLabel13.setText("$2.00");

        jLabel14.setText("$1.50");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Inserted Money:");

        moneyOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyOPActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Change:");

        changeOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOPActionPerformed(evt);
            }
        });

        jLabel17.setText("$");

        jLabel18.setText("$");

        nickel.setText("Nickel");
        nickel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickelActionPerformed(evt);
            }
        });

        dime.setText("Dime");
        dime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimeActionPerformed(evt);
            }
        });

        quarter.setText("Quarter");
        quarter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterActionPerformed(evt);
            }
        });

        loonie.setText("Loonie");
        loonie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loonieActionPerformed(evt);
            }
        });

        toonie.setText("Toonie");
        toonie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toonieActionPerformed(evt);
            }
        });

        jLabel19.setText("$0.05");

        jLabel20.setText("$0.10");

        jLabel21.setText("$0.25");

        jLabel22.setText("$1.00");

        jLabel23.setText("$2.00");

        nickelOP.setText("0");

        dimeOP.setText("0");

        quarterOP.setText("0");

        loonieOP.setText("0");

        toonieOP.setText("0");

        jLabel24.setText("Nickels Recieved");

        jLabel29.setText("Dimes Recieved");

        jLabel30.setText("Quarters Recieved");

        jLabel31.setText("Loonies Recieved");

        jLabel32.setText("Toonies Recieved");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(skittles)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel12))
                            .addComponent(pretzel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CLIF)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel6))
                            .addComponent(cheetos))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(twix)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ruffles)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(doritos)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cookie)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel4)))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lays)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(KK)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(GB)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nuts)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel8))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15))
                                    .addGap(50, 50, 50)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(moneyOP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(changeOP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(cancel)
                        .addGap(20, 20, 20)
                        .addComponent(clear)
                        .addGap(20, 20, 20)
                        .addComponent(buy))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nickel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quarter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loonie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toonie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dimeOP)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quarterOP)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel30))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loonieOP)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(toonieOP)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nickelOP)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel24)))))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moneyOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(changeOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cheetos)
                    .addComponent(cookie)
                    .addComponent(GB)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CLIF)
                    .addComponent(doritos)
                    .addComponent(nuts)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pretzel)
                    .addComponent(ruffles)
                    .addComponent(lays)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KK)
                    .addComponent(twix)
                    .addComponent(skittles)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickel)
                    .addComponent(jLabel19)
                    .addComponent(nickelOP)
                    .addComponent(jLabel24))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(dime)
                    .addComponent(dimeOP)
                    .addComponent(jLabel29))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(quarter)
                    .addComponent(quarterOP)
                    .addComponent(jLabel30))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loonie)
                    .addComponent(jLabel22)
                    .addComponent(loonieOP)
                    .addComponent(jLabel31))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toonie)
                    .addComponent(jLabel23)
                    .addComponent(toonieOP)
                    .addComponent(jLabel32))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(buy)
                    .addComponent(clear))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GBActionPerformed
        //Select Only One
        
        if (GB.isSelected()) {
            CLIF.setSelected(false);
            KK.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_GBActionPerformed

    private void CLIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLIFActionPerformed
        //Set Only One
        if (CLIF.isSelected()){
            GB.setSelected(false);
            KK.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_CLIFActionPerformed

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed
        //Purchase and give change
        money = Double.parseDouble(moneyOP.getText());
        
        if (GB.isSelected()){
            money = money - GB_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(CLIF.isSelected()){
            money = money - CLIF_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(cheetos.isSelected()){
            money = money - cheetos_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(KK.isSelected()){
            money = money - KK_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(cookie.isSelected()){
            money = money - cookie_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(doritos.isSelected()){
            money = money - doritos_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(lays.isSelected()){
            money = money - lays_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(nuts.isSelected()){
            money = money - nuts_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(pretzel.isSelected()){
            money = money - pretzel_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(ruffles.isSelected()){
            money = money - ruffles_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(skittles.isSelected()){
            money = money - skittles_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }else if(twix.isSelected()){
            money = money - twix_cost;
            money *= 100;
            money = Math.round(money);
            money = money / 100;
            changeOP.setText(Double.toString(money));
        }
        
        //if money is less than zero or more than ten will result in error.
        if (money < 0 || money > 10){
            changeOP.setText("ERROR");
        }else{
            changeOP.setText(Double.toString(money));
        }
        
        nickel.setEnabled(false);
        dime.setEnabled(false);
        quarter.setEnabled(false);
        loonie.setEnabled(false);
        toonie.setEnabled(false);
       
        coinCalc();
        inventoryUpdate();
    }//GEN-LAST:event_buyActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        //Exit The GUI
        File Bank = new File("Till.txt");
        
        int nickelLog = nickelTill;
        int dimeLog = dimeTill;
        int quarterLog = quarterTill;
        int loonieLog = loonieTill;
        int toonieLog = toonieTill;
        
        try (PrintWriter write = new PrintWriter(Bank)){
            
            write.println(toonieLog);
            write.println(loonieLog);
            write.println(quarterLog);
            write.println(dimeLog);
            write.println(nickelLog);
            write.close();
        }catch (FileNotFoundException ex){
            System.out.printf("Something resulted in an Error.", ex);
        }
        
        File Inventory = new File("Inventory.txt");
        
        int cheetosLog = cheetosINV;
        int cookieLog = cookieINV;
        int granolabarLog = granolabarINV;
        int clifLog = clifINV;
        int doritosLog = doritosINV;
        int nutsLog = nutsINV;
        int pretzelLog = pretzelINV;
        int rufflesLog = rufflesINV;
        int laysLog = laysINV;
        int skittlesLog = skittlesINV;
        int twixLog = twixINV;
        int kitkatLog = kitkatINV;
        
        try (PrintWriter write = new PrintWriter(Bank)){
            
            write.println(cheetosLog);
            write.println(cookieLog);
            write.println(granolabarLog);
            write.println(clifLog);
            write.println(doritosLog);
            write.println(nutsLog);
            write.println(pretzelLog);
            write.println(rufflesLog);
            write.println(laysLog);
            write.println(skittlesLog);
            write.println(twixLog);
            write.println(kitkatLog);
            write.close();
        }catch (FileNotFoundException ex){
            System.out.printf("Something resulted in an Error.", ex);
        }
        
        System.exit(0);
    }//GEN-LAST:event_cancelActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        //Clear all selections and textfields
        CLIF.setSelected(false);
        GB.setSelected(false);
        KK.setSelected(false);
        cheetos.setSelected(false);
        cookie.setSelected(false);
        doritos.setSelected(false);
        lays.setSelected(false);
        nuts.setSelected(false);
        pretzel.setSelected(false);
        ruffles.setSelected(false);
        skittles.setSelected(false);
        twix.setSelected(false);
        
        moneyOP.setText(" ");
        changeOP.setText(" ");
        
        nickelOP.setText("0");
        dimeOP.setText("0");
        quarterOP.setText("0");
        loonieOP.setText("0");
        toonieOP.setText("0");
        
        nickel.setEnabled(true);
        dime.setEnabled(true);
        quarter.setEnabled(true);
        loonie.setEnabled(true);
        toonie.setEnabled(true);
        
        coins = 0;
    }//GEN-LAST:event_clearActionPerformed

    private void cheetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheetosActionPerformed
        //Set Only One
        if (cheetos.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            KK.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_cheetosActionPerformed

    private void cookieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cookieActionPerformed
        //Set Only One
        if (cookie.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            KK.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_cookieActionPerformed

    private void doritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doritosActionPerformed
        //Set Only One
        if (doritos.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            KK.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_doritosActionPerformed

    private void KKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KKActionPerformed
        //Set Only One
        if (KK.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_KKActionPerformed

    private void laysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laysActionPerformed
        //Set Only One
        if (lays.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            KK.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_laysActionPerformed

    private void nutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutsActionPerformed
        //Set Only One
        if (nuts.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            KK.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_nutsActionPerformed

    private void pretzelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pretzelActionPerformed
        //Set Only One
        if (pretzel.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            KK.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_pretzelActionPerformed

    private void rufflesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rufflesActionPerformed
        //Set Only One
        if (ruffles.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            KK.setSelected(false);
            skittles.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_rufflesActionPerformed

    private void skittlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skittlesActionPerformed
        //Set Only One
        if (skittles.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            KK.setSelected(false);
            twix.setSelected(false);
        }
    }//GEN-LAST:event_skittlesActionPerformed

    private void twixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twixActionPerformed
        //Set Only One
        if (twix.isSelected()){
            GB.setSelected(false);
            CLIF.setSelected(false);
            cheetos.setSelected(false);
            cookie.setSelected(false);
            doritos.setSelected(false);
            lays.setSelected(false);
            nuts.setSelected(false);
            pretzel.setSelected(false);
            ruffles.setSelected(false);
            skittles.setSelected(false);
            KK.setSelected(false);
        }
    }//GEN-LAST:event_twixActionPerformed

    private void moneyOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyOPActionPerformed
        //don't change
    }//GEN-LAST:event_moneyOPActionPerformed

    private void changeOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeOPActionPerformed
        //don't change
    }//GEN-LAST:event_changeOPActionPerformed

    private void quarterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterActionPerformed
        //add $0.25
        coins += 25;
        moneyOP.setText(Double.toString(coins / 100));
        quarterTill += 1;
        
        coinbtnDisable();
    }//GEN-LAST:event_quarterActionPerformed

    private void nickelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickelActionPerformed
        //add $0.05
        coins += 5;
        moneyOP.setText(Double.toString(coins / 100));
        nickelTill += 1;
        
        coinbtnDisable();
    }//GEN-LAST:event_nickelActionPerformed

    private void dimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimeActionPerformed
        //add $0.10
        coins += 10;
        moneyOP.setText(Double.toString(coins / 100));
        dimeTill += 1;
        
        coinbtnDisable();
    }//GEN-LAST:event_dimeActionPerformed

    private void loonieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loonieActionPerformed
        //add $1.00
        coins += 100;
        moneyOP.setText(Double.toString(coins / 100));
        loonieTill += 1;
        
        coinbtnDisable();
    }//GEN-LAST:event_loonieActionPerformed

    private void toonieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toonieActionPerformed
        //add $2.00
        coins += 200;
        moneyOP.setText(Double.toString(coins / 100));
        toonieTill += 1;
        
        coinbtnDisable();
    }//GEN-LAST:event_toonieActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendingMachineUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendingMachineUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CLIF;
    private javax.swing.JRadioButton GB;
    private javax.swing.JRadioButton KK;
    private javax.swing.JButton buy;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField changeOP;
    private javax.swing.JRadioButton cheetos;
    private javax.swing.JButton clear;
    private javax.swing.JRadioButton cookie;
    private javax.swing.JButton dime;
    private javax.swing.JLabel dimeOP;
    private javax.swing.JRadioButton doritos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JRadioButton lays;
    private javax.swing.JButton loonie;
    private javax.swing.JLabel loonieOP;
    private javax.swing.JTextField moneyOP;
    private javax.swing.JButton nickel;
    private javax.swing.JLabel nickelOP;
    private javax.swing.JRadioButton nuts;
    private javax.swing.JRadioButton pretzel;
    private javax.swing.JButton quarter;
    private javax.swing.JLabel quarterOP;
    private javax.swing.JRadioButton ruffles;
    private javax.swing.JRadioButton skittles;
    private javax.swing.JButton toonie;
    private javax.swing.JLabel toonieOP;
    private javax.swing.JRadioButton twix;
    // End of variables declaration//GEN-END:variables
}