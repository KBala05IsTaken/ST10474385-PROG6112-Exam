/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp.question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class ProductAppGUI extends JFrame
{
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    
    private ProductCalculations objPC = new ProductCalculations();
    
    public ProductAppGUI() 
    {
        setTitle("Product App");
        setSize(500, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        createMenu();
        createForm();
    }
    
    private void createMenu() 
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processProduct());
        clearItem.addActionListener(e -> clearForm());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }
    
    private void createForm() 
    {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;

        inputPanel.add(new JLabel("Customer Name:"), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;

        inputPanel.add(new JLabel("Select Product:"), gbc);

        cmbProduct = new JComboBox<>( new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        inputPanel.add(cmbProduct, gbc);

        
        txtPrice = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        inputPanel.add(txtPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;

        inputPanel.add(
            new JLabel("Enter Price:"), gbc
        );

        txtPrice = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        inputPanel.add(txtPrice, gbc);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
    
    private void processProduct() {

        try {
            
            String Product = cmbProduct.getSelectedItem().toString();
            String Customer = (txtCustomerName.getText().trim());

            double productPrice = Double.parseDouble(txtPrice.getText().trim()
            );

            

            // Format the report.
            String report =
                "MOVIE TICKET REPORT\n"
                + "************************************\n"
                + "Customer Name: " + Customer + "\n"
                  
                + "VAT: R "
                + String.format(Locale.US, "%.1f",tPrice) + "\n"
                + "Comission: " + numberOfTickets + "\n"
                + "Total: R "
                + String.format(Locale.US, "%.1f", Price) + "\n"
                + "************************************";

            // Save the report to a text file.
            saveReport(report);

        } catch (NumberFormatException e) {

            // Display an error for invalid numerical input.
            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number of tickets "
                + "and ticket price.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void saveReport(String report) 
    {
        try 
        {
            FileWriter writer = new FileWriter("data.txt");

            writer.write(report);
            writer.close();
            JOptionPane.showMessageDialog(
                this,
                "Data log successfully saved "
                + "to data.txt",
                "File Saved",
                JOptionPane.INFORMATION_MESSAGE
            );

        } 
            catch (IOException e) 
        {
            JOptionPane.showMessageDialog(
                this,
                "Error saving data log: " + e.getMessage(),
                "File Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void clearForm() 
    {
        cmbProduct.setSelectedIndex(0);
        txtCustomerName.setText("");
        txtPrice.setText("");
    }
}
