
	import java.awt.Container;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import java.util.Random;
	import java.util.Timer;
	import java.util.TimerTask;
	import java.awt.Color;
	import javax.swing.*;
	import java.awt.*;
	import java.util.*;

	public class LuckyDraw extends JFrame implements ActionListener 
	{
	   Timer timer = new Timer();

	   private boolean isRunning = false;

	   private int winningNumber;

	   private int winningNo;

	   private String nameOfRow;
	 
	   private JLabel youReady = new JLabel("Are you ready?" , SwingConstants.CENTER);

	   private JLabel wellAreYou = new JLabel("Press the button to begin lucky draw" , SwingConstants.CENTER);

	   private JButton startJButton = new JButton("ROLL!");

	   private JButton stopJButton = new JButton("Stop");
	 
	   String[] rows = {"A", "B", "C" , "D", " E" , "F", "G", "H", "J", "K", "L", "M", "N", "O", "P","Q","R", "S", "T", "U", "V"};

	   Random forRows = new Random();

	   Random numberPool = new Random();

	   Panel b1 = new Panel();

	   Panel b2 = new Panel();

	   public LuckyDraw()
	   {
	      setTitle("Manchester Mnight");

	      Container contents = getContentPane();

	      contents.setLayout(new GridLayout(5,5));

	      //contents.setBackground(new Color(2, 0 , 0));

	      startJButton.setMargin(new Insets(20, 40, 20, 40));

	      stopJButton.setMargin(new Insets(20, 40, 20, 40));
	      
	      //startJButton.setBackground(Color.blue);
	      
	      //stopJButton.setBackground(Color.blue);
	      
	      wellAreYou.setPreferredSize(new Dimension(20,20));

	      youReady.setFont (youReady.getFont ().deriveFont (64.0f));
	      
	      wellAreYou.setFont (youReady.getFont ().deriveFont (64.0f));
	      
	      JLabel picture = new JLabel(new ImageIcon(new ImageIcon("fb_header_1_.jpg").getImage().getScaledInstance(800, 300, Image.SCALE_DEFAULT)));
	      
	      //ImageIcon imageIcon = new ImageIcon(new ImageIcon("fb_header_1_.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

	      contents.add(picture);
	      
	      b1.add(startJButton);
	  
	      b2.add(stopJButton);

	      contents.add(wellAreYou);
	      contents.add(youReady);

	      contents.add(b1);

	      contents.add(b2);

	      startJButton.addActionListener(this);

	      stopJButton.addActionListener(this);

	      setDefaultCloseOperation(EXIT_ON_CLOSE);

	      pack();

	  }//LuckyDraw

	  public void actionPerformed(ActionEvent event)
	  {
	     if(event.getSource() == startJButton)
	     {
	        if(!isRunning)
	        {
	           isRunning = true;
	 
	           wellAreYou.setText("And the winner is....");

	           timer.scheduleAtFixedRate(new TimerTask() 
	           {
	             @Override
	             public void run() 
	             {
	                nameOfRow = rows[forRows.nextInt(rows.length)];
	                whatIf(nameOfRow);
	                youReady.setText("" + nameOfRow + "," + winningNumber);
	                // Your database code here
	             }
	          }, 100, 100);
	              
	              

	        }//if
	        
	        if(isRunning)
	        {
		           isRunning = false;
	   	 
	   	           wellAreYou.setText("And the winner is....");
	   	           
	   	           timer.scheduleAtFixedRate(new TimerTask() 
	   	           {
	   	             @Override
	   	             public void run() 
	   	             {
	   	                nameOfRow = rows[forRows.nextInt(rows.length)];
	   	                whatIf(nameOfRow);
	   	                youReady.setText("" + nameOfRow + "," + winningNumber);
	   	                // Your database code here
	   	             }
	   	          }, 100, 100);
	        }//if       
	      }//if
	 
	     
	    if(event.getSource() == stopJButton) 
	    {
	        timer.cancel();
	        timer.purge();
	        timer = new Timer();
	        wellAreYou.setText("Congratulations seat");
	        nameOfRow = rows[forRows.nextInt(rows.length)];
	        whatIf(nameOfRow);
	        winningNo = winningNumber;
	        youReady.setText("" + nameOfRow + winningNumber + "!");
	        
	    }//if

	  }//action

	  public void whatIf(String argument)
	  {

	     if(argument == "A" || argument == "G" || argument == "U")
	     {
	        do
	        {
	           winningNumber = numberPool.nextInt(22);

	        }while(winningNumber == 0 || winningNumber == 1 || winningNumber == 2);
	          
	     }//A

	     if(argument == "B" || argument == "H" || argument == "J" || argument == "K" || argument == "L" || argument == "M" || argument == "N" || argument == "P" || argument == "O" || argument == "Q" || argument == "R" || argument == "S" || argument == "T")
	     {
	       do
	       { 
	          winningNumber = numberPool.nextInt(23);
	       }while(winningNumber == 0 || winningNumber == 1);
	     }//A

	     if(argument == "C" || argument == "D" || argument == "E")
	     {
	        do
	        {
	          winningNumber = numberPool.nextInt(24);
	        }while(winningNumber == 0);
	     }//A


	  }//whatIf



	   public static void main(String[] args)
	   {
	      LuckyDraw theLuckyDraw = new LuckyDraw();
	      theLuckyDraw.setSize(500,500);
	      theLuckyDraw.setVisible(true);

	   }//main

	}//class
