import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
<<<<<<< HEAD
=======
import javax.swing.event.*;
import javax.swing.border.*;
>>>>>>> 917aadd868a0d52f63558fcee4c506249af66490
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
<<<<<<< HEAD
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.util.Stack;
import javax.swing.JTextField;

=======
>>>>>>> 917aadd868a0d52f63558fcee4c506249af66490
/**
 * Write a description of class Telefono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
<<<<<<< HEAD
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
    
=======
public class Telefono
{
    
    private static final int ESPACIO = 10;
    private static final String MENSAJE_LLAMADA = "¡¡ LLAMANDO !!";
    // instance variables - replace the example below with your own
    private JFrame telefono;
    private JTextField display;
    private String numTelefono;

>>>>>>> 917aadd868a0d52f63558fcee4c506249af66490
    /**
     * Constructor for objects of class Telefono
     */
    public Telefono()
    {
<<<<<<< HEAD
        
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

   
=======
        construirVentana();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        telefono.setLocation(d.width/2 - telefono.getWidth()/2, d.height/2 - telefono.getHeight()/2);
        telefono.setVisible(true);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    private void construirVentana()
    {
        telefono = new JFrame();
        
        JPanel contenidoVentana = (JPanel)telefono.getContentPane();
        contenidoVentana.setLayout (new BorderLayout(ESPACIO, ESPACIO));
        contenidoVentana.setBorder (new EmptyBorder(ESPACIO, ESPACIO, ESPACIO, ESPACIO));
        
        display = new JTextField();
        contenidoVentana.add (display, BorderLayout.NORTH);
        
        JPanel panelBotones = new JPanel (new GridLayout(5, 3, ESPACIO, ESPACIO));
        
        agregarBotonNumero(panelBotones, "1");
        agregarBotonNumero(panelBotones, "2");
        agregarBotonNumero(panelBotones, "3");
        
        agregarBotonNumero(panelBotones, "4");
        agregarBotonNumero(panelBotones, "5");
        agregarBotonNumero(panelBotones, "6");
        
        agregarBotonNumero(panelBotones, "7");
        agregarBotonNumero(panelBotones, "8");
        agregarBotonNumero(panelBotones, "9");
        
        agregarBotonBorrar(panelBotones, "B");
        agregarBotonNumero(panelBotones, "0");
        agregarBotonLimpiar(panelBotones, "L");
        
        agregarBotonRepetir(panelBotones, "R");
        agregarBotonLlamar(panelBotones, "LL");
        agregarBotonCerrar(panelBotones, "C");
        
        contenidoVentana.add (panelBotones, BorderLayout.CENTER);
        
        telefono.pack();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void agregarBoton(JPanel panel, String texto)
    {
        JButton boton = new JButton(texto);
        panel.add(boton);
    }
    
    private void agregarBotonNumero(Container panel, String texto)
    {
        JButton boton = new JButton(texto);
        panel.add(boton);
        boton.setToolTipText ("marca el " + texto);
        boton.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent evento)
            {
                numTelefono = display.getText();
                if (!numTelefono.equals (MENSAJE_LLAMADA)){
                    display.setText (numTelefono + evento.getActionCommand());
                }
            }
        });
    }
    
    private void agregarBotonBorrar(Container panel, String texto)
    {
        JButton boton = new JButton(texto);
        panel.add(boton);
        boton.setToolTipText ("Borra el ultimo digito");
        boton.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent evento)
            {
                numTelefono = display.getText();
                if (!numTelefono.equals (MENSAJE_LLAMADA) && numTelefono.length() > 0 ){
                    display.setText (numTelefono.substring(0, numTelefono.length()-1));
                }
            }
        });

    }
    
    private void agregarBotonCerrar(Container panel, String texto)
    {
        JButton boton = new JButton(texto);
        panel.add(boton);
        boton.setToolTipText ("Cierra el telefono");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });

    }
    
    private void agregarBotonLlamar(Container panel, String texto)
    {
        JButton boton = new JButton(texto);
        panel.add(boton);
        boton.setToolTipText ("Llama por telefono");
        boton.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent evento)
            {
                numTelefono = display.getText();
                if (numTelefono.length() > 0 ){
                    display.setText (MENSAJE_LLAMADA);
                }
            }
        });

    }
    
    private void agregarBotonLimpiar(Container panel, String texto)
    {
        JButton boton = new JButton(texto);
        panel.add(boton);
        boton.setToolTipText ("Limpia el display");
        boton.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent evento)
            {
                if (numTelefono.length() > 0 ){
                    display.setText ("");
                }
            }
        });

    }
    
    private void agregarBotonRepetir(Container panel, String texto)
    {
        JButton boton = new JButton(texto);
        panel.add(boton);
        boton.setToolTipText ("Repite el ultimo digito");
        boton.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent evento)
            {
                if (numTelefono.length() > 0 ){
                    display.setText (numTelefono);
                }
            }
        });

    }
>>>>>>> 917aadd868a0d52f63558fcee4c506249af66490
}
