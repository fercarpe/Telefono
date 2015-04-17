import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.util.Stack;
import javax.swing.JTextField;

/**
 * Write a description of class Telefono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Telefono 
{
    // instance variables - replace the example below with your own
     private static final String VERSION = "Version 0.1";
    private static final int ESPACIO = 10;
    
    private JFrame ventana;
    private JPanel contenido;
    private JTextField display;
    private JPanel botonera;
    
    //gridlayout
    
    /**
     * Constructor for objects of class Telefono
     */
    public Telefono()
    {
        
        crearTelefono();
    }
    
    private void crearTelefono()
    {
         
        
        ventana = new JFrame("Telefono");
        
        contenido = (JPanel)ventana.getContentPane();
        contenido.setLayout (new BorderLayout(ESPACIO, ESPACIO));
        contenido.setBorder(new EmptyBorder(ESPACIO,ESPACIO,ESPACIO,ESPACIO));
        
        display = new JTextField();
        contenido.add(display, BorderLayout.NORTH);
        
        crearBotonera();
        contenido.add(botonera,BorderLayout.CENTER);
        
        ventana.pack();
        ventana.setVisible(true);   
        
        
    }
    
    private void crearBotonera()
    {
        
        botonera = new JPanel();
        botonera.setLayout(new GridLayout(5,3,ESPACIO,ESPACIO));
        
        agregarBotonNumero("1");
        agregarBotonNumero("2");
        agregarBotonNumero("3");
        
        agregarBotonNumero("4");
        agregarBotonNumero("5");
        agregarBotonNumero("6");
        
        agregarBotonNumero("7");
        agregarBotonNumero("8");
        agregarBotonNumero("9");
        
        agregarBotonBorrar("B");
        agregarBotonNumero("0");
        
  
        
        
    }
    
    private void agregarBotonNumero(final String num)
    {
        JButton boton = new JButton(num);
        botonera.add(boton);
        boton.setToolTipText("Marca el " + num);
        boton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) { 
                String numero = display.getText();
                display.setText(numero + num);
            
            }
        }
        );
        
    }
    
    private void agregarBotonBorrar(final String num)
    {
               JButton boton = new JButton(num);
        botonera.add(boton);
        boton.setToolTipText("Borra el ultimo numero");
        boton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) { 
                String numero = display.getText();
                if(numero.length() > 0){
                    String nuevoNum = numero.substring(0,(numero.length()-1));
                    display.setText(nuevoNum);  
                }
            }
        }
        );
    }

   
}
