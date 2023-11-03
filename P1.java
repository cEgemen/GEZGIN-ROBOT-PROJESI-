import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;

public class P1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	public JPanel panel,p1,p2;
	public JLabel l4 ;
	public JLabel l1;
    public Izgara ı ;
    public ArrayList<Integer> deger= new ArrayList<Integer>();
    boolean click1=true;
    boolean on=true,on2=false,on3=true,on4=true,on5=true;
    public int giris=0;
    public int current_x=0,current_y=0;
    public int x1=-1,y1=-1,x2=-1,y2=-1;
	public Timer time;
    public Robot robot;	
    public Engel en ;
    public JLabel l6; 
	
  
   public void randomLoc(Izgara[][] ı)
   {
	  
	    x1=(int)(Math.random()*ı.length-1);
	    y1=(int)(Math.random()*ı[1].length-1);
	    x2=(int)(Math.random()*ı.length-1);
	    y2=(int)(Math.random()*ı[1].length-1);
	 while(true)   
	 {
		 if(ı[x1][y1].engel.engelOn==false && ı[x2][y2].engel.engelOn==false && x1!=x2 && y1!=y2 )
		 {
			return;
		 }
		 x1=(int)(Math.random()*ı.length);
		    y1=(int)(Math.random()*ı[1].length);
		    x2=(int)(Math.random()*ı.length);
		    y2=(int)(Math.random()*ı[1].length);
		 
	 }
	   
	   
   }
   public void visible()
   {
	   this.setVisible(false);
   }
	public P1() {
		 time =new Timer(1000,this);
		 robot =new Robot();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 581);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 798, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ön = new JLabel("");
		ön.setIcon(new ImageIcon("C:\\Users\\Abra\\Desktop\\Prolablar\\Prolab4\\images\\back.jpg"));
		ön.setBounds(24, 69, 718, 415);
		panel.add(ön);
	    
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(221, 160, 221));
		panel_1.setBounds(798, 0, 171, 544);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 l1 = new JLabel("0");
		l1.setBackground(new Color(255, 255, 255));
		l1.setBounds(111, 59, 52, 26);
		panel_1.add(l1);
		
		JButton b3 =new JButton("Sımule");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(giris==0)
				{
					JOptionPane.showMessageDialog(panel,"Izgara Oluşturulmadı");
					return;
				}
				if(on==false)
				{
					time.stop();
					on=true;
					on5= true;
					for(int i=1;i<ı.desen.length-1;i++)
					{
						for(int j=1;j<ı.desen[1].length-1;j++)
						{
							 ı.desen[i][j].setVisible(false);
							ı.desen[i][j].visited=false;
							ı.desen[i][j].seem=false;
							ı.desen[i][j].setBackground(null);
							ı.desen[i][j].setIcon(null);
						}
					}
					new Uygulama().res();
					new Uygulama().res(l1);
					new Uygulama().res(l4);
					new Uygulama().res(l6);
					current_x=x1;
					current_y=y1;	
					if(robot.shortest.size()!=0 || robot.gecilenYerler.size()!=0) {
				     robot.settings2(x1,y1);
					}
					else {
						robot.settings1(x1,y1);
					}
					robot.firstSteps=false;
				}
				else {
					for(int i=0;i<ı.desen.length;i++)
					{
						for(int j=0;j<ı.desen[1].length;j++)
						{
							 ı.desen[i][j].setVisible(false);
							ı.desen[i][j].visited=false;
							ı.desen[i][j].seem=false;
							ı.desen[i][j].setBackground(null);
							ı.desen[i][j].setIcon(null);
						}
					}
					new Uygulama().res();
					new Uygulama().res(l1);
					new Uygulama().res(l4);
					new Uygulama().res(l6);
			         robot.settings2(x1,y1);
			 		System.out.println("robot.syc"+robot.syc);
			         if(robot.gecilenYerler.size()!=0)
			         {
			        	 robot.firstSteps=false;
			         }
					on5=true;
				}
				if(on5==true) {
					giris++;
			  long start = System.currentTimeMillis();
			  while(ı.desen[x2][y2].visited==false)	
			  { 
				  robot.move(ı.desen,x1,y1);
				  System.out.println("robot.gezilenYol.size()"+robot.gecilenYerler.size());
				  if(ı.desen[x2][y2].visited==true)
				  {
						robot.finis.add(x2);
						robot.finis.add(y2);
				  }
			  }
			  if(robot.firstSteps==true)
			  robot.firstSteps=false;
			  for (int i=0;i<ı.desen.length;i++)
			  {
				  for(int j=0;j<ı.desen[1].length;j++)
				  {
					  if((i==x1 && j==y1) || (i==x2 && j==y2))
						{
							 ı.desen[i][j].setVisible(true);
							ı.desen[i][j].setIcon(null);
							ı.desen[i][j].setBackground(Color.pink);
							continue;
						}
					  if(ı.desen[i][j].visited==true)
						{    	
							 ı.desen[i][j].setVisible(true);
								ı.desen[i][j].setIcon(null);
								ı.desen[i][j].setBackground(new Color(255,255,204));
						}
				  }
			  }
			  if(robot.shortest.size()==0) {
					robot.shortestPath(ı.desen);
			  }
					 for(int i=0;i<robot.shortest.size();i++)
					    {
					    	if((robot.shortest.get(i).x==x1 && robot.shortest.get(i).y==y1) || (robot.shortest.get(i).x==x2 && robot.shortest.get(i).y==y2))
					    	{
					    	   ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
					    	   ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(Color.pink);
										}
					    	else
					    	{
					    		 ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
						    	   ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(new Color(0,255,51));
					    	}
					    }			
			  
			  long end =System.currentTimeMillis();
			  new Uygulama().gecenSure(start, end,l4);
			  new Uygulama().update(l1);
			  new Uygulama().update(l6,robot.shortest.size());
			  System.out.println("robot.gezilenYol.size()"+robot.gecilenYerler.size());
			  try(FileWriter writer=new FileWriter("Kayıt.txt",true))
				{
				   writer.write("------------------------------------------------------------------------------------------\n");			   
					   writer.write("KAYIT\n");
				   writer.write("Geçilen tüm yerler:\n");
				   for(Izgara tmp : robot.gecilenYerler)
				   {
					   writer.write("["+tmp.x+","+tmp.y+"]-");
				   }
				   writer.write("\n");
				   writer.write("En kısa Yol:\n");
				   for(Izgara tmp:robot.shortest)
				   {
					   writer.write("["+tmp.x+","+tmp.y+"]-");
				   }
				   writer.write("\n");
				   writer.write("Gezilen Toplam Alan:"+Uygulama.adım+"\n");
				   writer.write("En kısa Yol Adım Sayısı:"+robot.shortest.size()+"\n");
				   writer.write("Geçen Süre:"+Uygulama.süre+"\n");
				   writer.write("------------------------------------------------------------------------------------------\n");			   
				} catch (IOException e1) {
					System.out.println("Dosya acılamadı");
				}
			  
			  
			  on3=true;
			  on5=false;
			}
			}
		});
		b3.setBackground(new Color(135, 206, 235));
		b3.setForeground(new Color(0, 0, 0));
		b3.setBounds(0, 485, 119, 39);
		Image i3 =new ImageIcon(this.getClass().getResource("/sim.png")).getImage();
		b3.setIcon(new ImageIcon(i3));
		panel_1.add(b3);
		
		JButton b2 = new JButton("Çalıştır");
		b2.setBackground(new Color(60, 179, 113));
		b2.setBounds(0, 436, 119, 39);
		Image i2 =new ImageIcon(this.getClass().getResource("/s2.png")).getImage();
		b2.setIcon(new ImageIcon(i2));
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		if(on==true)
		{
			if(giris==0)
			{
			JOptionPane.showMessageDialog(panel,"Izgara Oluşturulmadı");	
			}
			else {
			time.start();
		  on = false;
			}
			}
		else
		{
	 		System.out.println("on==true");
			time.stop();
			on=true;
		}
			
			}	
		});
		panel_1.add(b2);
		
		JButton b1 = new JButton("Yapı");
		b1.setBackground(new Color(255, 255, 0));
		b1.setBounds(0, 379, 119, 47);
		Image i1 = new ImageIcon(this.getClass().getResource("/b.png")).getImage();
		b1.setIcon(new ImageIcon(i1));
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x=0;
				int y=0;
				ı =new Izgara();
				if(on==false)
				{
					time.stop();
					current_x=x1;
					current_y=y1;
				robot.settings1(x1,y1);
				robot.firstSteps=true;
					on=true;
				}
				if(giris==0) {
				panel.remove(ön);
				panel.setLayout(new BorderLayout());
				panel.setBackground(Color.white);
				giris++;
				}
				if(click1==true) {
					if(on2==true)
					{
						panel.remove(p2);
					}
					 p1=new JPanel();
		            panel.add(p1);
			//	ı.read("C:\\Users\\Abra\\Desktop\\t1.txt",ı);
				ı.read("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt",ı);

				System.out.println("row:"+ı.row +" col:"+ı.col);
				ı.desen=new Izgara[ı.row+2][ı.col+2];
				System.out.println("ı.desen.lenght:"+ı.desen.length);
				ı.build(ı);
				 en =new Engel();
				 en.engelAlan1(ı.desen);
					System.out.println("tip1 lenght:"+en.tip1.size());
				 en.engelAlan2(ı.desen);
					System.out.println("tip2 lenght"+en.tip2.size());
				 en.engelAlan3(ı.desen);
					System.out.println("tip3 lenght:"+en.tip3.size());
				 new EngelT1().model(en.tip1);
				 new EngelT2().model(en.tip2);			 
				 new EngelT3().model(en.tip3);
				 randomLoc(ı.desen);
				System.out.println("x1:"+x1+" y1:"+y1+" x2:"+x2+" y2:"+y2);
				current_x=x1;
				current_y=y1;
				   robot.settings1(x1,y1);
				   robot.firstSteps=true;
					//robot2.settings1(x1,y1);
					new Uygulama().res();
					new Uygulama().res(l1);
					new Uygulama().res(l4);
					new Uygulama().res(l6);
				x=ı.row+2;
				y=ı.col+2;
				p1.setLayout(new GridLayout(x,y));
				for (int i=0;i<x;i++)
				{
				 for (int j=0;j<y;j++)
				 {
					 
					 p1.add(ı.desen[i][j]);
				 }
				}
				ı.desen(ı);
				 p1.updateUI();
				click1=false;
				giris++;
				on3=true;
				}
				else {
					panel.remove(p1);
					 p2=new JPanel();
		            panel.add(p2);
				//	ı.read("C:\\Users\\Abra\\Desktop\\t2.txt",ı);
						ı.read(" http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt",ı);
					System.out.println("row:"+ı.row +" col:"+ı.col);
					ı.desen=new Izgara[ı.row+2][ı.col+2];
					System.out.println("ı.desen.lenght:"+ı.desen.length);
					ı.build(ı);
					
					 en =new Engel();
					 en.engelAlan1(ı.desen);
					 en.engelAlan2(ı.desen);
					 en.engelAlan3(ı.desen);
					 new EngelT1().model(en.tip1);
					 new EngelT2().model(en.tip2);
					 new EngelT3().model(en.tip3);
					 randomLoc(ı.desen);
					System.out.println("x1:"+x1+" y1:"+y1+" x2:"+x2+" y2:"+y2);
					current_x=x1;
					current_y=y1;
				    robot.settings1(x1,y1);
				    robot.firstSteps=true;
				//	robot2.settings1(x1,y1);
						new Uygulama().res();
						new Uygulama().res(l1);
						new Uygulama().res(l4);
						new Uygulama().res(l6);
					ı.desen(ı);
					x=ı.row+2;
					y=ı.col+2;
					p2.setLayout(new GridLayout(x,y));
					for (int i=0;i<x;i++)
					{
					 for (int j=0;j<y;j++)
					 {
						 p2.add(ı.desen[i][j]);
					 }
					}
					p2.updateUI();
					click1=true;
	                on2=true;
	                on3=true;
					}
			}	
		});
		panel_1.add(b1);
		
		JLabel lblNewLabel = new JLabel("Toplam Adım :");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 56, 101, 33);
		panel_1.add(lblNewLabel);
		
		
		JButton b4 = new JButton();
		b4.setBackground(new Color(210, 105, 30));
		b4.setBounds(129, 459, 32, 39);
		Image i4 =new ImageIcon(this.getClass().getResource("/door.png")).getImage();
		b4.setIcon(new ImageIcon(i4));
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(on==false)
				{
					time.stop();
				}
				visible();
				Main m = new Main();
			}
		});
		panel_1.add(b4);
		
		JLabel l3 = new JLabel("Geçen Saniye:");
		l3.setHorizontalAlignment(SwingConstants.RIGHT);
		l3.setBounds(0, 10, 101, 36);
		panel_1.add(l3);
		
		 l4 = new JLabel("0");
		l4.setBounds(111, 15, 52, 26);
		panel_1.add(l4);
		
		JButton b5 = new JButton("");
		b5.setBounds(129, 402, 32, 47);
		Image ii =new ImageIcon(this.getClass().getResource("/eyes.png")).getImage();
		b5.setIcon(new ImageIcon(ii));
		b5.setBackground(new java.awt.Color(51,204,255));
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(giris==0)
				{
					JOptionPane.showMessageDialog(panel,"Izgara Oluşturlmadı");
					return;
				}
				if(on3==true)
				{
					for(int i=0;i<ı.desen.length;i++)
					 {
						 for(int j=0;j<ı.desen.length;j++)
						 {
							 if((i==x1 && j==y1) || (i==x2 && j==y2))
							 {
								 ı.desen[i][j].setVisible(true);
								 ı.desen[i][j].setBackground(Color.pink);
								 ı.desen[i][j].setIcon(null);
							 }
							 if(ı.desen[i][j].engel.engelTip==1 && ı.desen[i][j].engel.engelOn==true)
							 
							 {
								 ı.desen[i][j].setVisible(true);
								 Image i1 = new ImageIcon(this.getClass().getResource("/wall1.png")).getImage();
								 ı.desen[i][j].setIcon(new ImageIcon(i1));
								 ı.desen[i][j].setBackground(new java.awt.Color(160,82,45));
							 }
							 else if(ı.desen[i][j].engel.engelTip==2 && ı.desen[i][j].engel.engelOn==true)
								 
							 {
								 ı.desen[i][j].setVisible(true);
								 Image i1 = new ImageIcon(this.getClass().getResource("/wall2.png")).getImage();
								 ı.desen[i][j].setIcon(new ImageIcon(i1));
								 ı.desen[i][j].setBackground(new java.awt.Color(102,102,102));
							 }
							 else if(ı.desen[i][j].engel.engelTip==3 && ı.desen[i][j].engel.engelOn==true)
								 
							 {
								 ı.desen[i][j].setVisible(true);
								 Image i1 = new ImageIcon(this.getClass().getResource("/wall3.png")).getImage();
								 ı.desen[i][j].setIcon(new ImageIcon(i1));
								 ı.desen[i][j].setBackground(new java.awt.Color(220,20,60));
							 }
						 }
					 }
					
					on3=false;
				}
				else {
					for(int i=0;i<ı.desen.length;i++)
					 {
						 for(int j=0;j<ı.desen.length;j++)
						 {
							 if((i==x1 && j==y1 && ı.desen[i][j].visited==false) || (i==x2 && j==y2 && ı.desen[i][j].visited==false))
							 {
								 ı.desen[i][j].setBackground(null);
								 ı.desen[i][j].setIcon(null);
								 ı.desen[i][j].setVisible(false);

							 }
							 
							 if(ı.desen[i][j].engel.engelTip==1 && ı.desen[i][j].engel.engelOn==true && ı.desen[i][j].seem==false)
							 
							 {
								 ı.desen[i][j].setVisible(false);
								 ı.desen[i][j].setIcon(null);
								 ı.desen[i][j].setBackground(null);
							 }
							 else if(ı.desen[i][j].engel.engelTip==2 && ı.desen[i][j].engel.engelOn==true && ı.desen[i][j].seem==false)
								 
							 {
								 ı.desen[i][j].setVisible(false);
								 ı.desen[i][j].setIcon(null);
								 ı.desen[i][j].setBackground(null);
							 }
							 else if(ı.desen[i][j].engel.engelTip==3 && ı.desen[i][j].engel.engelOn==true && ı.desen[i][j].seem==false)
								 
							 {
								 ı.desen[i][j].setVisible(false);
								 ı.desen[i][j].setIcon(null);
								 ı.desen[i][j].setBackground(null);

							 }
						 }
					 }
					on3=true;
				}
			}
			
			
		});
		panel_1.add(b5);
		
		JLabel l5 = new JLabel("Min Adım:");
		l5.setHorizontalAlignment(SwingConstants.RIGHT);
		l5.setBounds(0, 109, 101, 26);
		panel_1.add(l5);
		
	     l6 = new JLabel("0");
		l6.setBounds(111, 112, 50, 20);
		panel_1.add(l6);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(on5==false)	
	{
		for (int i=0;i<ı.desen.length;i++)
		{
			for(int j=0;j<ı.desen[1].length;j++)
			{
				 ı.desen[i][j].setVisible(false);
				ı.desen[i][j].setBackground(null);
				ı.desen[i][j].setIcon(null);
				ı.desen[i][j].visited=false;
				ı.desen[i][j].seem=false;
			}
		}
		new Uygulama().res();
		new Uygulama().res(l1);
		new Uygulama().res(l4);
		current_x=x1;
		current_y=y1;
		if(robot.shortest.size()!=0 || robot.gecilenYerler.size()!=0)
		{
			robot.settings2(x1,y1);
		}
		else {
			robot.settings1(x1,y1);
		}
		on5=true;
	}
	if(ı.desen[x2][y2].visited==true)
	{
		robot.finis.add(x2);
		robot.finis.add(y2);
		System.out.println("x2="+x2+" y2="+y2);
		JOptionPane.showMessageDialog(panel,"Tebrikler Cıkısı "+Uygulama.adım+" Adımda Buldunuz");
		int x =JOptionPane.showConfirmDialog(panel,"Kısa Yolu İster misiniz?","?", JOptionPane.YES_NO_OPTION);
		if(x==JOptionPane.YES_OPTION)
		{
			robot.shortestPath(ı.desen);
			for(int i=0;i<robot.shortest.size();i++)
			{
				System.out.print("["+robot.shortest.get(i).x+","+robot.shortest.get(i).y+"]");
				if((robot.shortest.get(i).x==x1 && robot.shortest.get(i).y==y1) || (robot.shortest.get(i).x==x2 && robot.shortest.get(i).y==y2))
				{
					ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setVisible(true);
					ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
					ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(Color.PINK);
				}
				else
				{
					ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setVisible(true);
					ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
					ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(new Color(0,255,51));
				}
			}
			new Uygulama().update(l6,robot.shortest.size());
		}
		int y =JOptionPane.showConfirmDialog(panel,"Bastan Baslamak Ister misiniz?","?", JOptionPane.YES_NO_OPTION);
		if(y==JOptionPane.YES_OPTION)
		{
			for ( int i=0;i<ı.desen.length;i++)
			{
				for(int j=0;j<ı.desen[1].length;j++)
				{
			                ı.desen[i][j].setVisible(false);
			        	     ı.desen[i][j].visited=false;
			        	     ı.desen[i][j].seem=false;
			        		 ı.desen[i][j].setIcon(null);
			        		 ı.desen[i][j].setBackground(null);
				}
			}
			new Uygulama().res();
			new Uygulama().res(l1);
			new Uygulama().res(l4);
			current_x=x1;
			current_y=y1;
			robot.settings2(x1,y1);
		}
		else {
			time.stop();
			robot.firstSteps=false;
  		     on=true;
			return;
		}
	}
   Image ıcon = new ImageIcon(this.getClass().getResource("/robot.png")).getImage();   
   ı.desen[current_x][current_y].setIcon(null);
   if(current_x==x1 && current_y==y1)
   {
	   ı.desen[current_x][current_y].setBackground(Color.pink);
   }
   else {
   ı.desen[current_x][current_y].setBackground(new Color(255,255,204));
   }
   robot.move(ı.desen,x1,y1);	
   current_x=robot.x;
   current_y=robot.y;
   ı.desen[current_x][current_y].setIcon(new ImageIcon(ıcon));		
   if(current_x==x2 && current_y==y2)
   {
	   ı.desen[current_x][current_y].setBackground(Color.pink);
   }
   else {
   ı.desen[current_x][current_y].setBackground(new Color(255,255,204));
   }
	 new Uygulama().update(l1);

	}
	}

