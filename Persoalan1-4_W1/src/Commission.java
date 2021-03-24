/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fadill
 */
public class Commission extends Hourly {
 public double total_sales;
 public double com_rate;

 public Commission (String eName, String eAddress, String ePhone, 
                    String socSecNumber, double rate, double rate_com){   
 super (eName, eAddress, ePhone, socSecNumber, rate);
 com_rate = rate_com;
 }
 public void addSales(double add_sales){
 total_sales += add_sales;
 }
 @Override
 public double pay (){
     double payment = super.pay() + (total_sales * com_rate);
     total_sales = 0;
     return payment;
 }
 @Override
 public String toString(){
     String result = super.toString();
     result += "\nTotal Sales :" + total_sales;
     return result;
 }
}
