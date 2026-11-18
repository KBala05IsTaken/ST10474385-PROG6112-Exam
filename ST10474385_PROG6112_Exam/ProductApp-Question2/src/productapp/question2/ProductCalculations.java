/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp.question2;

/**
 *
 * @author KhanyisaB
 */
public class ProductCalculations implements IProductCalculations 
{
    private double Vat;
    private double Commission;
    private double Total;

    // Constructor to initialise the ticket information.
    public ProductCalculations(double Vat, double Comission,double Total) 
    {
        this.Vat = Vat;
        this.Commission = Comission;
        this.Total = Total;
    }

    // Returns the movie name.
    public double GetVat() {
        return Vat;
    }

    // Returns the number of tickets.
    public double GetComission() {
        return Commission;
    }

    // Returns the ticket price.
    public double GetTotal() {
        return Total;
    }
}
