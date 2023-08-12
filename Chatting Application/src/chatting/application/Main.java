/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatting.application;

import java.awt.Color;
import java.awt.Image;
import java.io.DataOutputStream;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tejas
 */
public class Main extends JFrame {
    
   
//    static JFrame f1 = new JFrame() ;
    
    Main() {
         
        System.out.println("Server Class") ;
      setLayout(null) ;
       //create frame
       JPanel p1 = new JPanel() ;
       p1.setBackground(new Color(7,94,84)) ; //set background 
       p1.setBounds(0,0,450 ,70); // you have to tell position of frame since setLayout(null)
       p1.setLayout(null) ;
      add(p1) ;  // add panel to the frame
       
       
       // ImageIcon used to put image to frame
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png")) ;
      Image i2 = i1.getImage().getScaledInstance(25 ,25 , Image.SCALE_DEFAULT) ;
      ImageIcon i3 = new ImageIcon(i2) ;
      JLabel back = new JLabel(i3) ;
      back.setBounds(5,20,25,25);
      p1.add(back) ;
      
      
      
      
      
       setSize(450 ,700) ;
       setLocation(200 , 50) ;
      setUndecorated(false) ;
//       
//       
//       
       getContentPane().setBackground(Color.WHITE); 
//       
//       
       setVisible(true) ;
}
    
    public static void main(String[]args) {
       new Main() ;
    }
    
}
