
package chatting.application;

import java.awt.Color;
import javax.swing.* ;
import javax.swing.border.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.* ;
//import java.util.EventListener;
import java.text.* ;
import java.net.* ;
import java.io.* ;



public class Server   implements ActionListener {
//public class Server  extends JFrame {
    
    JTextField text ;
    JPanel a1 ;
    static Box verticle = Box.createVerticalBox() ;
    static JFrame f1 = new JFrame() ;
    static DataOutputStream dout ;
    Server() {
         
        System.out.println("Server Class") ;
      f1.setLayout(null) ;
       //create frame
       JPanel p1 = new JPanel() ;
       p1.setBackground(new Color(7,94,84)) ; //set background 
       p1.setBounds(0,0,450 ,70); // you have to tell position of frame since setLayout(null)
       p1.setLayout(null) ;
      f1.add(p1) ;  // add panel to the frame
       
       
       // ImageIcon used to put image to frame
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png")) ;
      Image i2 = i1.getImage().getScaledInstance(25 ,25 , Image.SCALE_DEFAULT) ;
      ImageIcon i3 = new ImageIcon(i2) ;
      JLabel back = new JLabel(i3) ;
      back.setBounds(5,20,25,25);
      p1.add(back) ;
      
      
      // Once we clicked on that arrow we should leave / the system -> thats why add action Listner
      back.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked(MouseEvent e) {
              System.exit(0);
          }
      });
      
      
      
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png")) ;
      Image i5 = i4.getImage().getScaledInstance(50 ,50 , Image.SCALE_DEFAULT) ;
      ImageIcon i6 = new ImageIcon(i5) ;
      JLabel profile = new JLabel(i6) ;
      profile.setBounds(40,10,50,50);
      p1.add(profile) ;
       
      
      
      ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png")) ;
      Image i8 = i7.getImage().getScaledInstance(30 ,30 , Image.SCALE_DEFAULT) ;
      ImageIcon i9 = new ImageIcon(i8) ;
      JLabel video = new JLabel(i9) ;
      video.setBounds(300,20,30,30);
      p1.add(video) ;
      
      
      ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png")) ;
      Image i11 = i10.getImage().getScaledInstance(35 ,30 , Image.SCALE_DEFAULT) ;
      ImageIcon i12 = new ImageIcon(i11) ;
      JLabel phone = new JLabel(i12) ;
      phone.setBounds(360,20,35,30);
      p1.add(phone) ;
      
      
      ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png")) ;
      Image i14 = i13.getImage().getScaledInstance(10 ,25 , Image.SCALE_DEFAULT) ;
      ImageIcon i15 = new ImageIcon(i14) ;
      JLabel threeDot = new JLabel(i15) ;
      threeDot.setBounds(420,20,10,25);
      p1.add(threeDot) ;
       
      
      
      JLabel name = new JLabel("Siddhiki") ;
      name.setBounds(110 , 15 ,100 ,18);
      name.setForeground(Color.WHITE) ;
      name.setFont(new Font("SAN_SERIF" ,Font.BOLD ,18)) ;
      p1.add(name) ;
      
      
      JLabel status = new JLabel("Active Now") ;
      status.setBounds(110 , 35 ,100 ,18);
      status.setForeground(Color.WHITE) ;
      status.setFont(new Font("SAN_SERIF" ,Font.BOLD ,14)) ;
      p1.add(status) ;
      
       
      
     
      // creating new Panel P1 
      
      a1 = new JPanel() ;
    
      a1.setBounds(5, 75 , 440 , 570);
      f1.add(a1) ;
      
      text = new JTextField() ;
      text.setBounds(5 , 655 , 310 ,40) ;
      text.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16)) ;
      f1.add(text) ;
      
      
      JButton send = new JButton("SEND") ;
      send.setBounds(320 , 655, 123, 40);
      send.setBackground(new Color(7,94,84)) ; 
      send.setForeground(Color.white) ;
      send.addActionListener(this) ;
      send.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16)) ;
      f1.add(send) ;
      
      
       f1.setSize(450 ,700) ;
       f1.setLocation(200 , 50) ;
       f1.setUndecorated(true) ;
//       
//       
//       
       f1.getContentPane().setBackground(Color.WHITE); 
//       
//       
       f1.setVisible(true) ;
//       
//       
//           
    }
    
    
   
    
      @Override
        public void actionPerformed(ActionEvent ae){
       
       try {
            String out = text.getText() ; // get text from message box
            
            
            JPanel p2 = formatLabel(out) ;
            
            
            
            a1.setLayout(new BorderLayout()) ;
            
            
            JPanel right = new JPanel(new BorderLayout()) ;
            right.add(p2 , BorderLayout.LINE_END) ;
            
            verticle.add(right) ; // right panel add into box in coloumn order
            verticle.add(Box.createVerticalStrut(15)) ; //distance between two verticle
            
            a1.add(verticle ,BorderLayout.PAGE_START) ;
            
         
            
            dout.writeUTF(out) ;
            text.setText("");
            f1.repaint() ;
            f1.invalidate() ;
            f1.validate() ;
        } catch(Exception e){
             
                e.printStackTrace();
 
         }

            
        }

        
   public static JPanel formatLabel(String out) {
        
        JPanel panel = new JPanel() ;
        panel.setLayout(new BoxLayout(panel , BoxLayout.Y_AXIS));
        JLabel output = new JLabel("<html><p style = \"width:150px\"> " +out+ " </p></html>")  ;
        output.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        output.setBackground(new Color(37 , 211 , 102)) ;
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
     
        panel.add(output) ;
        return panel ;
    }

   
   public  static void fun1() {
       
       System.out.println("Fun1");
           try{
           
           
           // why pass this 6001 port here ;
           ServerSocket skt = new ServerSocket(6001) ; 
           
           while(true) {
            Socket  s =  skt.accept() ;
            
            DataInputStream din = new DataInputStream(s.getInputStream()) ;
             dout = new DataOutputStream(s.getOutputStream()) ;
            
            while(true) {
                String ss = din.readUTF() ;
                JPanel msg  = formatLabel(ss);
                JPanel pp = new JPanel(new BorderLayout()) ;
                pp.add(msg , BorderLayout.LINE_START) ;
                verticle.add(pp) ;
                f1.validate() ;
                
            }
           
           }
       }catch(IOException e) {
       }
           
            
   }
    
   
   public static void main(String[]args) {
       
       
     new Server() ;
     fun1();

   } 
}
