import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
/**
 * Write a description of class Telefono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Telefono
{
    
    private static final int ESPACIO = 10;
    private static final String MENSAJE_LLAMADA = "¡¡ LLAMANDO !!";
    // instance variables - replace the example below with your own
    private JFrame telefono;
    private JTextField display;
    private String numTelefono;

    /**
     * Constructor for objects of class Telefono
     */
    public Telefono()
    {
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
}
