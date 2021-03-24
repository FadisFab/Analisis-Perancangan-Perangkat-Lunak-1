/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author Fadill
 */
// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RatePanel extends JPanel
{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
//Combo box to choose the currency change
    JComboBox rateList = new JComboBox();
//Generate
    JButton toResult = new JButton();
//Text field to put a certain amount of value
    JTextField textField = new JTextField(10);
    
// ------------------------------------------------------------
// Sets up a panel to convert cost from one of 6 currencies
// into U.S. Dollars. The panel contains a heading, a text
// field for the cost of the item, a combo box for selecting
// the currency, and a label to display the result.
// ------------------------------------------------------------
    public RatePanel ()
    {
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        add (title);
        setPreferredSize(new Dimension(750,500));
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
            "European Euro", "Canadian Dollar",
            "Japanese Yen", "Australian Dollar",
            "Indian Rupee", "Mexican Peso"};
        
        //Currency Rate
        rate = new double [] {0.0, 1.2103, 0.7351,
            0.0091, 0.6969, 0.0222, 0.0880};
        //ComboBox Settings
        rateList.setModel(new DefaultComboBoxModel(currencyName));//input currency to combo box
        rateList.addActionListener(new ComboListener());
        
        add(textField);
        add(rateList);
        //Generate the result(exchange rate) - Belum working
        JButton toResult = new JButton("Check The Result");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toResult);
        this.add(buttonPanel, "South");
        
        
        result = new JLabel (" ------------ ");
        add (result);
    }
// ******************************************************
// Represents an action listener for the combo box.
// ******************************************************
    private class ComboListener implements ActionListener
    {
        
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        
        public void actionPerformed (ActionEvent event)
        {
            int index = rateList.getSelectedIndex();
            double amount = Double.parseDouble(textField.getText());
            
            result.setText ( +amount + currencyName[index] +
                    " = " + rate[index]*amount + " U.S. Dollars");
        }
    }
}