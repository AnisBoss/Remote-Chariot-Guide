import java.awt.* ;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


class Server extends JFrame {
public Server (){
	this.setTitle("Server");
	this.setBounds(10,10,500,400);
	this.setVisible(true);
			new MouseClickExample(this);
}

public static void main (String [] args )
{
Server server  = new Server ();
}

}