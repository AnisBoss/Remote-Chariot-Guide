import java.awt.* ;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;

	class MouseClickExample extends  Frame {
		Server f ;
	   public MouseClickExample( Server f){
	    
	     this.f =f;
	     f.addMouseListener( new MouseClick() );     
	   }

	   
	}
	class MouseClick implements MouseListener {
		public Server f ;


		   
	   public void mousePressed(MouseEvent e) {};
	   public void mouseReleased(MouseEvent e) {};
	   public void mouseEntered(MouseEvent e) {};
	   public void mouseExited(MouseEvent e) {};
	  public void mouseDragged(MouseEvent e) {};
	  public void mouseClicked(MouseEvent e)  {
	   	
       String message ="";
	      String message1 ="";
	      Socket requestSocket;
		  DataOutputStream out = null;
	      message = new Integer(e.getX()).toString();

	      message1 = new Integer(e.getY()).toString();
	
	    try {
	    	requestSocket = new Socket("localhost", 2003);
 		out = new DataOutputStream(requestSocket.getOutputStream());
		out.flush();
		
			out.writeUTF(message);
			out.writeUTF(message1);
			out.flush();
			out.close();
			requestSocket.close();
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	     
	   }
	      
	  
	}
