import java.awt.* ;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

class Client extends JFrame {
public int x;
public int y;
int i=0;
int x1 ;
int y1;
boolean f ;
public void recv() {

	ServerSocket providerSocket;

	Socket connection = null;
	DataOutputStream out;
	DataInputStream in;
	String message="" ;
	String message1="" ;

	try{	

			
			providerSocket = new ServerSocket(2003);
			connection = providerSocket.accept();
		
			out = new DataOutputStream(connection.getOutputStream());
			out.flush();
			in = new DataInputStream(connection.getInputStream());
					
					 message = (String)in.readUTF();	
					 
					message1 = (String)in.readUTF();
					
				in.close();
				out.close();
				providerSocket.close();
				connection.close();
					
					}
				catch(IOException ioException){
			ioException.printStackTrace();
		}
					 this.x = Integer.parseInt(message);
					 this.y = Integer.parseInt(message1);
					
}


    public void paint(Graphics g) 
    {	
    	  f = true ;
    	 g.fillRect(200,200,60,10);
    	      	Rectangle rect1 = new Rectangle(200,200,60,10);
    	recv(); 
    	
  		super.paintComponents(g);

  		 try {
 Image img = ImageIO.read(new File("chariot.png"));
 if (i>0) {
     while (this.x1!=this.x || this.y1!=this.y){
     	super.paintComponents(g);
     	g.fillRect(200,200,60,10);
     	    	     	Rectangle rect2 = new Rectangle(this.x1,this.y1,40,32);

     	    	      	if (rect1.intersects(rect2))
     	    	      		{
     	    	      			this.x=this.x1 ;
     	    	      			this.y=this.y1 ; 
     	    	      			 g.drawImage(img, this.x1, this.y1, this);
     	    	      			 f=false;
     							System.out.println("Le Chariot a frappe un obstacle ");
     }
     else {
   
       	if (this.x1>this.x)
     		this.x1--;
     	else if (this.x1<this.x)
      		this.x1++;
      	if (this.y1>this.y)
      		this.y1--;
      	else if (this.y1<this.y) 
      		this.y1++;

      g.drawImage(img, this.x1, this.y1, this);

      try {

        Thread.sleep(3);

      } catch (InterruptedException e) {

        e.printStackTrace();

      }
      
  }
  }   
  }
  else {
  	g.drawImage(img, this.x, this.y, this);
  	i++;

  }
    } catch (IOException e) {

      e.printStackTrace();

 


    } 
    if (f)
   {this.x1=this.x;
    this.y1 = this.y ;}
    else {
    	if (this.x>=160 && this.y>=190)
    	{this.x1++;
    	this.y1++;
    	}
    	else {
    		this.x1--;
    	this.y1--;
    	
    	}
f =true ;

    }
    System.out.println("Le Client a recu la nouvelle position  ");
    }

	public Client (){

		this.setTitle("Client");
		this.setBounds(10,10,500,400);
		this.setVisible(true);
		while(true)

		this.repaint();
		}

		public static void main(String[] args) {
		
		Client c= new Client();
		
		
			


		}
		


	}
