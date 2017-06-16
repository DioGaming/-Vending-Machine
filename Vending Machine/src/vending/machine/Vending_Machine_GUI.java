package vending.machine;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.Math;
import java.util.Timer;//I don't think these are even needed but I'll keep them


/**
 *
 * @author Richard Lam
 * 
 * Also credit to Mehtab and Yash
 */
public class Vending_Machine_GUI extends javax.swing.JFrame {
    
    //The till
    int nickel_count = 0;
    int dime_count = 0;
    int quarter_count = 0;
    int loonie_count = 0;
    int toonie_count = 0;
    
    //The inventory
    int ginger_stock = 0;
    int orange_stock = 0;
    int ice_stock = 0;
    int coke_stock = 0;
    int peach_stock = 0;
    int rootbeer_stock = 0;
    
    //Money to be added to the till after an order
    int toonie_pend = 0;
    int loonie_pend = 0;
    int quarter_pend = 0;
    int dime_pend = 0;
    int nickel_pend = 0;
    
    //other money related things
    double money_count = 0;
    double cost_count = 0;
    double money_display = money_count / 100;
    double cost_display = cost_count / 100;

    //drinks counting
    int ginger_count = 0;
    int orange_count = 0;
    int tea_count = 0;
    int coke_count = 0;
    int peach_count = 0;
    int root_count = 0;
    
    //change
    double change = 0;
    int return_nickel = 0;
    int return_dime = 0;
    int return_quarter = 0;
    int return_loonie = 0;
    int return_toonie = 0;
    
    //Timer for display
    public void confirmation() {
        confirmations.setText(" ");
    }
    
    
    public Vending_Machine_GUI() {
        initComponents();
        reader_till();
        reader_food();
    }
    
    public void reader_till(){
        File till = new File("till.txt");
        
        try {
            Scanner scan = new Scanner(till);
            
            int toonie_bank = scan.nextInt();
            int loonie_bank = scan.nextInt();
            int quarter_bank = scan.nextInt();
            int dime_bank = scan.nextInt();
            int nickel_bank = scan.nextInt();
            
            toonie_count = toonie_bank;
            loonie_count = loonie_bank;
            quarter_count = quarter_bank;
            dime_count = dime_bank;
            nickel_count = nickel_bank;
        } catch(FileNotFoundException ex) {
            System.out.printf("Something went horribly wrong.", ex);
        }
    }
    
    public void reader_food(){
        File food = new File("inventory.txt");
        
        try {
            Scanner scan = new Scanner(food);
            
            int ginger_bank = scan.nextInt();
            int orange_bank = scan.nextInt();
            int ice_bank = scan.nextInt();
            int coke_bank = scan.nextInt();
            int peach_bank = scan.nextInt();
            int rootbeer_bank = scan.nextInt();
            
            ginger_stock = ginger_bank;
            orange_stock = orange_bank;
            ice_stock = ice_bank;
            coke_stock = coke_bank;
            peach_stock = peach_bank;
            rootbeer_stock = rootbeer_bank;
        } catch(FileNotFoundException ex) {
            System.out.printf("Something went horribly wrong food.", ex);
        }
    }
    
    public void changecalc() {
        //The math has to be done in cents
        change = money_count - cost_count;
        double change_display = change;
        
        while (change >= 200 && toonie_count > 0) {
            change -= 200;
            return_toonie += 1;
            toonie_count -= 1;
        }
        while (change >= 100 && loonie_count > 0) {
            return_loonie += 1;
            change -= 100;
            toonie_count -= 1;
        }
        while (change >= 25 && quarter_count > 0) {
            return_quarter += 1;
            change -= 25;
            quarter_count -= 1;
        }
        while (change >= 10 && dime_count > 0) {
            return_dime += 1;
            change -= 10;
            dime_count -= 1;
        } 
        while (change >= 5 && nickel_count > 0) {
            return_nickel += 1;
            change -= 5;
            nickel_count -= 1;
        }
        
        if (toonie_count <= 0 && loonie_count <= 0 && quarter_count <= 0 && dime_count <= 0 && nickel_count <= 0) {
            machine_error.setText("ERROR MADE");
            restart_pls.setText("SHUT DOWN MACHINE");
            new_order.setEnabled(false);
        } else {
        confirmations.setText("Money given: $" + (change_display / 100));
        toonie_given.setText("Toonies: " + Integer.toString(return_toonie));
        loonie_given.setText("Loonies: " + Integer.toString(return_loonie));
        quarter_given.setText("Quarters: " + Integer.toString(return_quarter));
        dime_given.setText("Dimes: " + Integer.toString(return_dime));
        nickel_given.setText("Nickels: " + Integer.toString(return_nickel));
        order_again.setText("Please click the order button.");
        }
        
        //disabling every button to prevent a little bit of breaking
        //drink buttons
        ginger_ale.setEnabled(false);
        orange_juice.setEnabled(false);
        ice_tea.setEnabled(false);
        cocacola.setEnabled(false);
        peach.setEnabled(false);
        root_beer.setEnabled(false);
        
        //money buttons
        toonie.setEnabled(false);
        loonie.setEnabled(false);
        quarter.setEnabled(false);
        dime.setEnabled(false);
        nickel.setEnabled(false);
        checkout.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ginger_ale = new javax.swing.JButton();
        orange_juice = new javax.swing.JButton();
        ice_tea = new javax.swing.JButton();
        ginger_tally = new javax.swing.JLabel();
        orange_tally = new javax.swing.JLabel();
        tea_tally = new javax.swing.JLabel();
        new_order = new javax.swing.JButton();
        nickel = new javax.swing.JButton();
        dime = new javax.swing.JButton();
        quarter = new javax.swing.JButton();
        loonie = new javax.swing.JButton();
        toonie = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        money_tally = new javax.swing.JLabel();
        cost_tally = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkout = new javax.swing.JButton();
        toonie_given = new javax.swing.JLabel();
        loonie_given = new javax.swing.JLabel();
        quarter_given = new javax.swing.JLabel();
        dime_given = new javax.swing.JLabel();
        nickel_given = new javax.swing.JLabel();
        confirmations = new javax.swing.JLabel();
        order_again = new javax.swing.JLabel();
        cocacola = new javax.swing.JButton();
        coke_tally = new javax.swing.JLabel();
        peach = new javax.swing.JButton();
        peach_tally = new javax.swing.JLabel();
        root_beer = new javax.swing.JButton();
        root_tally = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        machine_error = new javax.swing.JLabel();
        restart_pls = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Drinks Machine");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 255), 5, true));
        jLabel1.setName(""); // NOI18N

        ginger_ale.setBackground(new java.awt.Color(244, 200, 123));
        ginger_ale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ginger_ale.setText("Ginger Ale");
        ginger_ale.setBorder(null);
        ginger_ale.setMaximumSize(new java.awt.Dimension(80, 25));
        ginger_ale.setMinimumSize(new java.awt.Dimension(80, 25));
        ginger_ale.setName("dreadrum"); // NOI18N
        ginger_ale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ginger_aleActionPerformed(evt);
            }
        });

        orange_juice.setBackground(new java.awt.Color(255, 123, 0));
        orange_juice.setText("Orange Juice");
        orange_juice.setMaximumSize(new java.awt.Dimension(80, 25));
        orange_juice.setMinimumSize(new java.awt.Dimension(80, 25));
        orange_juice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orange_juiceActionPerformed(evt);
            }
        });

        ice_tea.setBackground(new java.awt.Color(0, 255, 255));
        ice_tea.setText("Ice Tea");
        ice_tea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ice_teaActionPerformed(evt);
            }
        });

        ginger_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ginger_tally.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ginger_tally.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));
        ginger_tally.setFocusable(false);
        ginger_tally.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orange_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        orange_tally.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orange_tally.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));
        orange_tally.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        tea_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tea_tally.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tea_tally.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));

        new_order.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        new_order.setText("New Order");
        new_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_orderActionPerformed(evt);
            }
        });

        nickel.setText("$0.05");
        nickel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickelActionPerformed(evt);
            }
        });

        dime.setText("$0.10");
        dime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimeActionPerformed(evt);
            }
        });

        quarter.setText("$0.25");
        quarter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterActionPerformed(evt);
            }
        });

        loonie.setText("$1.00");
        loonie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loonieActionPerformed(evt);
            }
        });

        toonie.setText("$2.00");
        toonie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toonieActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("$");

        money_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        money_tally.setText("0");
        money_tally.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 0), 2, true));

        cost_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cost_tally.setText("0");
        cost_tally.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 0), 2, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Purchase Amount");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("$");

        checkout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkout.setText("Buy");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });

        confirmations.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cocacola.setBackground(new java.awt.Color(204, 0, 0));
        cocacola.setText("Coca Cola");
        cocacola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocacolaActionPerformed(evt);
            }
        });

        coke_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        coke_tally.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coke_tally.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));

        peach.setBackground(new java.awt.Color(255, 153, 102));
        peach.setText("Peach Juice");
        peach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peachActionPerformed(evt);
            }
        });

        peach_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        peach_tally.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        peach_tally.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));

        root_beer.setBackground(new java.awt.Color(131, 67, 2));
        root_beer.setText("Root Beer");
        root_beer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                root_beerActionPerformed(evt);
            }
        });

        root_tally.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        root_tally.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        root_tally.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));

        close.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        close.setForeground(new java.awt.Color(204, 0, 0));
        close.setText("Shut Down");
        close.setBorder(null);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        machine_error.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        machine_error.setForeground(new java.awt.Color(204, 0, 0));
        machine_error.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        restart_pls.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        restart_pls.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(new_order, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(root_beer, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(root_tally, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(peach, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(peach_tally, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(orange_juice, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(ginger_ale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(orange_tally, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(ginger_tally, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ice_tea, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(tea_tally, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cocacola, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(coke_tally, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(machine_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(restart_pls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(order_again, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nickel_given, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(dime_given, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quarter_given, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loonie_given, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toonie_given, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cost_tally, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(money_tally, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(nickel, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                                    .addComponent(quarter, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                                                .addComponent(toonie, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(loonie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                                .addComponent(dime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel5)))
                                .addGap(10, 10, 10)))))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(new_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nickel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dime, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ginger_ale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ginger_tally, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(orange_juice, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(orange_tally, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ice_tea, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(tea_tally, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cocacola, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(coke_tally, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peach_tally, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peach, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(root_beer, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(root_tally, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(machine_error, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(restart_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quarter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loonie, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toonie, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(money_tally, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cost_tally, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(60, 60, 60)
                        .addComponent(confirmations, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toonie_given, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loonie_given, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quarter_given, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dime_given, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nickel_given, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_again, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ginger_aleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ginger_aleActionPerformed
        if (ginger_stock <= 0) {
            ginger_ale.setEnabled(false);
        } else {
        ginger_count += 1;
        ginger_stock -= 1;
        cost_count += 200;
        ginger_tally.setText(Integer.toString(ginger_count));
        cost_tally.setText(Double.toString(cost_count / 100));
        }
    }//GEN-LAST:event_ginger_aleActionPerformed

    private void orange_juiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orange_juiceActionPerformed
        if (orange_stock <= 0) {
            orange_juice.setEnabled(false);
        } else {
        orange_count += 1;
        orange_stock -= 1;
        cost_count += 150;
        orange_tally.setText(Integer.toString(orange_count));
        cost_tally.setText(Double.toString(cost_count / 100));
        }
    }//GEN-LAST:event_orange_juiceActionPerformed

    private void new_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_orderActionPerformed
        //drinks
        ginger_tally.setText(" ");
        orange_tally.setText(" ");
        tea_tally.setText(" ");
        coke_tally.setText(" ");
        peach_tally.setText(" ");
        root_tally.setText(" ");
        ginger_count = 0;
        orange_count = 0;
        tea_count = 0;
        coke_count = 0;
        peach_count = 0;
        root_count = 0;
        
        //add to the till
        toonie_count += toonie_pend;
        loonie_count += loonie_pend;
        quarter_count += quarter_pend;
        dime_count += dime_pend;
        nickel_count += nickel_pend;
        
        //money
        nickel_pend = 0;
        dime_pend = 0;
        quarter_pend = 0;
        loonie_pend = 0;
        toonie_pend = 0;
        money_count = 0;
        money_tally.setText("0");
        cost_count = 0;
        cost_tally.setText("0");
        confirmations.setText(" ");
        toonie_given.setText(" ");
        loonie_given.setText(" ");
        quarter_given.setText(" ");
        dime_given.setText(" ");
        nickel_given.setText(" ");
        order_again.setText(" ");
        change = 0;
        return_nickel = 0;
        return_dime = 0;
        return_quarter = 0;
        return_loonie = 0;
        return_toonie = 0;
        
        //buttons enabling
        ginger_ale.setEnabled(true);
        orange_juice.setEnabled(true);
        ice_tea.setEnabled(true);
        cocacola.setEnabled(true);
        peach.setEnabled(true);
        root_beer.setEnabled(true);
        toonie.setEnabled(true);
        loonie.setEnabled(true);
        quarter.setEnabled(true);
        dime.setEnabled(true);
        nickel.setEnabled(true);
        checkout.setEnabled(true);
    }//GEN-LAST:event_new_orderActionPerformed

    private void ice_teaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ice_teaActionPerformed
        if (ice_stock <= 0) {
            ice_tea.setEnabled(false);
        } else {
        tea_count += 1;
        ice_stock -= 1;
        cost_count += 175;
        tea_tally.setText(Integer.toString(tea_count));
        cost_tally.setText(Double.toString(cost_count / 100));
        }
    }//GEN-LAST:event_ice_teaActionPerformed

    private void nickelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickelActionPerformed
        nickel_pend += 1;
        money_count += 5;
        money_tally.setText(Double.toString(money_count / 100));
    }//GEN-LAST:event_nickelActionPerformed

    private void dimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimeActionPerformed
        dime_pend += 1;
        money_count += 10;
        money_tally.setText(Double.toString(money_count / 100));
    }//GEN-LAST:event_dimeActionPerformed

    private void quarterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterActionPerformed
        quarter_pend += 1;
        money_count += 25;
        money_tally.setText(Double.toString(money_count / 100));
    }//GEN-LAST:event_quarterActionPerformed

    private void loonieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loonieActionPerformed
        loonie_pend += 1;
        money_count += 100;
        money_tally.setText(Double.toString(money_count / 100));
    }//GEN-LAST:event_loonieActionPerformed

    private void toonieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toonieActionPerformed
        toonie_pend += 1;
        money_count += 200;
        money_tally.setText(Double.toString(money_count / 100));
    }//GEN-LAST:event_toonieActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        if (money_count - cost_count < 0) {
            confirmations.setText("Not enough money!");
        } else if (money_count - cost_count >= 0) {
            changecalc();
        }
    }//GEN-LAST:event_checkoutActionPerformed

    private void cocacolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cocacolaActionPerformed
        if (coke_stock <= 0) {
            cocacola.setEnabled(false);
        } else {
        coke_count += 1;
        coke_stock -= 1;
        cost_count += 180;
        coke_tally.setText(Integer.toString(coke_count));
        cost_tally.setText(Double.toString(cost_count / 100));
        }
    }//GEN-LAST:event_cocacolaActionPerformed

    private void peachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peachActionPerformed
        if (peach_stock <= 0) {
            peach.setEnabled(false);
        } else {
        peach_count += 1;
        peach_stock -= 1;
        cost_count += 210;
        peach_tally.setText(Integer.toString(peach_count));
        cost_tally.setText(Double.toString(cost_count / 100));
        }
    }//GEN-LAST:event_peachActionPerformed

    private void root_beerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_root_beerActionPerformed
        if (rootbeer_stock <= 0) {
            root_beer.setEnabled(false);
        } else {
        root_count += 1;
        rootbeer_stock -= 1;
        cost_count += 195;
        root_tally.setText(Integer.toString(root_count));
        cost_tally.setText(Double.toString(cost_count / 100));
        }
    }//GEN-LAST:event_root_beerActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed

        
        File till = new File("till.txt");
        
        //add to the till
        toonie_count += toonie_pend;
        loonie_count += loonie_pend;
        quarter_count += quarter_pend;
        dime_count += dime_pend;
        nickel_count += nickel_pend;
        
        //remove the pending coins
        nickel_pend = 0;
        dime_pend = 0;
        quarter_pend = 0;
        loonie_pend = 0;
        toonie_pend = 0;
        
        int toonie_write = toonie_count;
        int loonie_write = loonie_count;
        int quarter_write = quarter_count;
        int dime_write = dime_count;
        int nickel_write = nickel_count;
        
        try (PrintWriter write = new PrintWriter(till)) {
            
            write.println(toonie_write);
            write.println(loonie_write);
            write.println(quarter_write);
            write.println(dime_write);
            write.println(nickel_write);
            write.close();
            /*
            the file has the coins in this order:
            toonies
            loonies
            quarters
            dime
            nickel
            */
        } catch (IOException ex) {
            System.out.printf("Something went horribly wrong.", ex);
        }
        
        //Inventory file here
        File food = new File("inventory.txt");
        
        int ginger_write = ginger_stock;
        int orange_write = orange_stock;
        int ice_write = ice_stock;
        int coke_write = coke_stock;
        int peach_write = peach_stock;
        int rootbeer_write = rootbeer_stock;
        
        try (PrintWriter write = new PrintWriter(food)) {
            
            write.println(ginger_write);
            write.println(orange_write);
            write.println(ice_write);
            write.println(coke_write);
            write.println(peach_write);
            write.println(rootbeer_write);
            write.close();
            
        } catch (IOException ex) {
            System.out.printf("Something went horribly wrong food.", ex);
        }
        
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vending_Machine_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vending_Machine_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vending_Machine_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vending_Machine_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Vending_Machine_GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkout;
    private javax.swing.JButton close;
    private javax.swing.JButton cocacola;
    private javax.swing.JLabel coke_tally;
    private javax.swing.JLabel confirmations;
    private javax.swing.JLabel cost_tally;
    private javax.swing.JButton dime;
    private javax.swing.JLabel dime_given;
    private javax.swing.JButton ginger_ale;
    private javax.swing.JLabel ginger_tally;
    private javax.swing.JButton ice_tea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton loonie;
    private javax.swing.JLabel loonie_given;
    private javax.swing.JLabel machine_error;
    private javax.swing.JLabel money_tally;
    private javax.swing.JButton new_order;
    private javax.swing.JButton nickel;
    private javax.swing.JLabel nickel_given;
    private javax.swing.JButton orange_juice;
    private javax.swing.JLabel orange_tally;
    private javax.swing.JLabel order_again;
    private javax.swing.JButton peach;
    private javax.swing.JLabel peach_tally;
    private javax.swing.JButton quarter;
    private javax.swing.JLabel quarter_given;
    private javax.swing.JLabel restart_pls;
    private javax.swing.JButton root_beer;
    private javax.swing.JLabel root_tally;
    private javax.swing.JLabel tea_tally;
    private javax.swing.JButton toonie;
    private javax.swing.JLabel toonie_given;
    // End of variables declaration//GEN-END:variables

    
    
}
