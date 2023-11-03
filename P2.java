import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.apache.commons.lang3.time.StopWatch;
public class P2 extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JPanel p1 ;
	private JPanel p2 ;
	private JPanel panel;
	private JLabel l1;
	private JLabel l2;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JLabel l3;
	private JLabel l4;
	private Izgara ı;
	private int giris=0;
	private boolean on1=true,giris1=true,on2=true,on3=true,on4=true;
	private JLabel l5;
	private Timer timer;
	private  Robot robot ;
	private int current_x=1,current_y=0;
	private JLabel l7;
	private JLabel l8;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public void visible()
	{
		this.setVisible(false);
	}
	public P2() {
		timer = new Timer(1000,this);
		 robot = new Robot(1,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1200,800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		 panel.setBackground(new Color(0, 0, 0));
		 panel.setBorder(null);
		panel.setBounds(41, 20, 919, 733);
		contentPane.add(panel);
		panel.setLayout(null);
		
	    l5 = new JLabel();
		l5.setBounds(157, 206, 574, 384);
		Image i6 = new ImageIcon(this.getClass().getResource("/maze1.jpg")).getImage();
		l5.setIcon(new ImageIcon(i6));
		panel.add(l5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(970, 20, 187, 733);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 l1 = new JLabel(" Süre :");
		l1.setHorizontalAlignment(SwingConstants.RIGHT);
		l1.setBounds(2, 12, 95, 28);
		panel_1.add(l1);
		
		 l2 = new JLabel("0");
		l2.setHorizontalAlignment(SwingConstants.LEFT);
		l2.setBounds(107, 15, 70, 23);
		panel_1.add(l2);
		
		 b3 = new JButton("Simule");
		b3.setBounds(0, 632, 117, 40);
		Image i3 = new ImageIcon(this.getClass().getResource("/sim.png")).getImage();
		b3.setIcon(new ImageIcon(i3));
		b3.setBackground(new Color(135, 206, 235));
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		if(on1==true)
		{
			JOptionPane.showMessageDialog(panel,"Izgara Oluşturlumadı");
		     return;
		}
		if(on3==false)
		{
			timer.stop();
			for(int i=0;i<ı.desen.length;i++)
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
			new Uygulama().res(l4);
			new Uygulama().res(l2);
			new Uygulama().res(l8);
            new Uygulama().res();		
            if(robot.shortest.size()!=0 || robot.gecilenYerler.size()!=0)
            {
            	robot.settings2(1,0);
            }
            else {
            	robot.settings1(1,0);
            }
            robot.firstSteps=false;
			on4=true;
			on3=true;
		}
		else {
			for(int i=0;i<ı.desen.length;i++)
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
			 robot.settings2(1,0);
		 		System.out.println("robot.syc"+robot.syc);
		         if(robot.gecilenYerler.size()!=0)
		         {
		        	 robot.firstSteps=false;
		         }
			new Uygulama().res(l4);
			new Uygulama().res(l2);
			new Uygulama().res(l8);
			new Uygulama().res();
			on4=true;
		}
		if(on4==true) {
		long start=System.currentTimeMillis();
		while(ı.desen[ı.desen.length-2][ı.desen[1].length-1].visited==false)
		{
          robot.move2(ı.desen,1,0,ı.desen.length-2,ı.desen.length-1);
          if(ı.desen[ı.desen.length-2][ı.desen[1].length-1].visited==true)
          {
        	  robot.finis.add(ı.desen.length-2);
        	  robot.finis.add(ı.desen.length-1);
          }
		}
		if(robot.firstSteps==true)
			  robot.firstSteps=false;
		 for (int i=0;i<ı.desen.length;i++)
		  {
			  for(int j=0;j<ı.desen[1].length;j++)
			  {
				  if((i==1 && j==0) || (i==ı.desen.length-2 && j==ı.desen.length-1))
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
	if(robot.shortest.size()==0){	 
		robot.shortestPath(ı.desen);
	}
		for ( int i=0; i<robot.shortest.size();i++)
		{
			if((robot.shortest.get(i).x==1 && robot.shortest.get(i).y==0) || robot.shortest.get(i).x==ı.desen.length-2 && robot.shortest.get(i).y==ı.desen.length-1)
			{
				ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setVisible(true);
				ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
				ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(Color.pink);
			}
			else
			{
				ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setVisible(true);
				ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
				ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(new Color(102,0,153));
			}
			
		}
		
 long end = System.currentTimeMillis();
      new Uygulama().gecenSure(start,end,l2);
	  new Uygulama().update(l4);
	  new Uygulama().update(l8,robot.shortest.size());
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
	  on4=false;
	  on2=true;
			}
			}
		});
		panel_1.add(b3);
		
		 b2 = new JButton("Çalıştır");
		b2.setBounds(0, 582, 117, 40);
		Image i4 = new ImageIcon(this.getClass().getResource("/s2.png")).getImage();
		b2.setIcon(new ImageIcon(i4));
		b2.setBackground(new Color(60, 179, 113));
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                if(on3==true)
                {
                if(on1==true)
                {
                JOptionPane.showMessageDialog(panel,"Izgara Oluşturulmadı");
                }
                else {
                	timer.start();
                	on3=false;
                }
                }
                else {
                	timer.stop();
                	on3=true;
                }
				
			}
		});
		panel_1.add(b2);
		
		 b1 = new JButton("Map");
		b1.setBounds(0, 532, 117, 40);
		Image i5 =new ImageIcon(this.getClass().getResource("/change.png")).getImage();
		b1.setIcon(new ImageIcon(i5));
		b1.setBackground(Color.orange);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(on3==false)
				{
					timer.stop();
					current_x=1;
					current_y=0;
					robot.settings1(1,0);
					robot.firstSteps=true;
					on3=true;
				}
				if(on1==true)
				{
				panel.remove(l5);
				panel.setBackground(new Color(220, 220, 220));
			    panel.setLayout(new BorderLayout());
			    on1=false;
				}
				if(giris1==true) {
					if(giris==1) {
						panel.remove(p2);
					}
					ı=new Izgara();
				    p1=new JPanel();
                   String r = JOptionPane.showInputDialog(panel,"Lütfen Labirentin Satır Sayısını Giriniz:");
                   String c = JOptionPane.showInputDialog(panel,"Lütgen Labirentin Sütün Sayısını Giriniz:");
                   ı.row=Integer.parseInt(r);
                   ı.col=Integer.parseInt(c);
                   System.out.println("Girilen row:"+ı.row +" Girilen col:"+ı.col);
                   p1.setLayout(new GridLayout(ı.row,ı.col));
				    panel.add(p1);
				    ı.desen= new Izgara[ı.row][ı.col];
				    ı.creat(ı,p1);
				    ı.desen[1][0].engel=new Engel(0);
				    ı.desen[1][0].engel.engelOn=false;
				    ı.desen[1][0].setBackground(null);
				   while(true)
				    {
				    	System.out.println("döngü");
				     ı.Maze(ı.desen,1,0);
				     ı.fillMaze(ı.desen);
				     if(ı.desen[ı.desen.length-2][ı.desen[1].length-2].engel.engelOn==false)
				     {
				    	 break;
				     }
				    }
				 
				    Engel engel = new Engel();
				    engel.engelAlan1(ı.desen);
				    new EngelT1().model(engel.tip1);
					ı.desen(ı);
				    p1.updateUI();
				    current_x=1;
				    current_y=0;
				   robot.settings1(1,0);
					robot.firstSteps=true;
					new Uygulama().res();
					new Uygulama().res(l2);
					new Uygulama().res(l4);
					new Uygulama().res(l8);
				    giris=0;
				    giris1=false;
					on2=true;
				}
				else {
					panel.remove(p1);
					p2 =new JPanel();
					ı = new Izgara();
					 String r = JOptionPane.showInputDialog(panel,"Lütfen Labirentin Satır Sayısını Giriniz:");
	                   String c = JOptionPane.showInputDialog(panel,"Lütgen Labirentin Sütün Sayısını Giriniz:");
	                   ı.row=Integer.parseInt(r);
	                   ı.col=Integer.parseInt(c);
	                   System.out.println("Girilen row:"+ı.row +" Girilen col:"+ı.col);
					p2.setLayout(new GridLayout(ı.row,ı.col));
					panel.add(p2);
					ı.desen = new Izgara[ı.row][ı.col];
					ı.creat(ı,p2);
					  ı.desen[1][0].engel=new Engel(0);
					    ı.desen[1][0].engel.engelOn=false;
					    ı.desen[1][0].setBackground(null);
					    while(true)
					   {
					    	System.out.println("döngü");
					     ı.Maze(ı.desen,1,0);
					     ı.fillMaze(ı.desen);
					     if(ı.desen[ı.desen.length-2][ı.desen[1].length-2].engel.engelOn==false)
					     {
					    	 break;
					     }
					    }
					     
					  
					    Engel engel = new Engel();
					    engel.engelAlan1(ı.desen);
					    new EngelT1().model(engel.tip1);
					ı.desen(ı);
					p2.updateUI();
					 current_x=1;
					    current_y=0;
					   robot.settings1(1,0);
						robot.firstSteps=true;
						new Uygulama().res();
						new Uygulama().res(l2);
						new Uygulama().res(l4);
						new Uygulama().res(l8);

					giris=1;
					giris1=true;
					on2=true;
				}
			}	
			
		});
		panel_1.add(b1);
		
		 b4 = new JButton("");
		b4.setBounds(148, 544, 39, 55);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(on3==false)
				{
					timer.stop();
				}
                visible();
				Main m = new Main();
			}
			
		});
		Image i1 = new ImageIcon(this.getClass().getResource("/door.png")).getImage();
		b4.setIcon(new ImageIcon(i1));
		b4.setBackground(new java.awt.Color(210,105,30));
		panel_1.add(b4);
		
		b5 = new JButton("");
		b5.setBounds(148, 611, 39, 55);
		Image i2 = new ImageIcon(this.getClass().getResource("/eyes.png")).getImage();
		b5.setIcon(new ImageIcon(i2));
		b5.setBackground(new java.awt.Color(51,204,255));
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(on1==true)
				{
					JOptionPane.showMessageDialog(panel,"Izgara Oluşturulmadı");
					return;
				}
             if(on2==true)   
             {
            	 for(int i=0;i<ı.desen.length;i++)
            	 {
            		 for (int j=0;j<ı.desen[1].length;j++)
            		 {
            			 if((i==1 && j==0) || (i==ı.desen.length-2 && j==ı.desen[1].length-1))
            			 {
            				 ı.desen[i][j].setVisible(true);
            				 ı.desen[i][j].setBackground(Color.pink);
            				 ı.desen[i][j].setIcon(null);
            			 }
            			 if(ı.desen[i][j].engel.engelOn==true && ı.desen[i][j].seem==false)
            			 {
            				 ı.desen[i][j].setVisible(true);
            				 ı.desen[i][j].setIcon(new ImageIcon(ı.desen[i][j].engel.setIcon(ı.desen[i][j].engel)));
            				 ı.desen[i][j].setBackground(new java.awt.Color(160,82,45));
            			 }
            		 }
            	 }
            	 on2=false;
             }
             else {
            	 for (int i=0; i<ı.desen.length;i++)
            	 {
            		 for(int j=0;j<ı.desen[1].length;j++)
            		 {
            			 if((i==1 && j==0 && ı.desen[i][j].visited==false) || (i==ı.desen.length-2 && j==ı.desen[1].length-1 && ı.desen[i][j].visited==false))
            			 {
            				 ı.desen[i][j].setVisible(false);
            				 ı.desen[i][j].setBackground(null);
            				 ı.desen[i][j].setIcon(null);
            			 }
            			 if(ı.desen[i][j].engel.engelOn==true && ı.desen[i][j].seem==false)
            			 {
            				 ı.desen[i][j].setVisible(false);
            				 ı.desen[i][j].setIcon(null);
            				 ı.desen[i][j].setBackground(null);
            			 }
            			 
            		 }
            	 }
            	 on2=true;
             }
				
			}
		});
		panel_1.add(b5);
		
		l3 = new JLabel("Adım Sayısı:");
		l3.setHorizontalAlignment(SwingConstants.RIGHT);
		l3.setBounds(10, 74, 87, 28);
		panel_1.add(l3);
		
		l4 = new JLabel("0");
		l4.setBounds(107, 74, 70, 28);
		panel_1.add(l4);
		
		l7 = new JLabel("Min Adım:");
		l7.setHorizontalAlignment(SwingConstants.RIGHT);
		l7.setBounds(2, 130, 95, 28);
		panel_1.add(l7);
		
		l8 = new JLabel("0");
		l8.setBounds(107, 133, 70, 23);
		panel_1.add(l8);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(on4==false)
		{
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
			current_x=1;
			current_y=0;
			if(robot.shortest.size()!=0 || robot.gecilenYerler.size()!=0)
			{
				robot.settings2(1,0);
			}
			else{
				robot.settings1(1,0);
			}
			new Uygulama().res(l2);
			new Uygulama().res(l4);
			new Uygulama().res();   
			on4=true;
		}
		else {
		if(ı.desen[ı.desen.length-2][ı.desen[1].length-1].visited==true)
		{
			JOptionPane.showMessageDialog(panel,"Tebrikler Cıkısa Ulastınız ve "+Uygulama.adım+" adımda ulaştınız");
			int y = JOptionPane.showConfirmDialog(panel,"Kısa Yolu İster misiniz?","?", JOptionPane.YES_NO_OPTION);
			if(y==JOptionPane.YES_OPTION)
			{
				robot.shortestPath(ı.desen);
				for ( int i=0; i<robot.shortest.size();i++)
				{
					if((robot.shortest.get(i).x==1 && robot.shortest.get(i).y==0) || robot.shortest.get(i).x==ı.desen.length-2 && robot.shortest.get(i).y==ı.desen.length-1)
					{
						ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setVisible(true);
						ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
						ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(Color.pink);
					}
					else
					{
						ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setVisible(true);
						ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setIcon(null);
						ı.desen[robot.shortest.get(i).x][robot.shortest.get(i).y].setBackground(new Color(102,0,153));
					}
					
				}
				new Uygulama().update(l8,robot.shortest.size());
			}
			int x = JOptionPane.showConfirmDialog(panel,"Bastan Baslamak İster misiniz?","?", JOptionPane.YES_NO_OPTION);
			if(x==JOptionPane.YES_OPTION)
			{
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
				robot.settings2(1,0);
				current_x=1;
				current_y=0;
				new Uygulama().res(l2);
				new Uygulama().res(l4);
				new Uygulama().res();
			}
			else {
				timer.stop();
				on3=true;
				robot.firstSteps=false;
				return;
			}
		}
		}
		Image icon = new ImageIcon(this.getClass().getResource("/robot.png")).getImage();
		ı.desen[current_x][current_y].setIcon(null);
		if(current_x==1 && current_y==0)
		{
			ı.desen[current_x][current_y].setBackground(Color.pink);
		}
		else {
		ı.desen[current_x][current_y].setBackground(new Color(255,255,204));
		}
	     robot.move2(ı.desen,1,0,ı.desen.length-2,ı.desen.length-1);
	     current_x=robot.x;
	     current_y=robot.y;
	     ı.desen[current_x][current_y].setIcon(new ImageIcon(icon));
	     if(current_x==ı.desen.length-2 && current_y==ı.desen[1].length-1)
			{
				ı.desen[current_x][current_y].setBackground(Color.pink);
				robot.finis.add(current_x);
				robot.finis.add(current_y);
			}
			else {
			ı.desen[current_x][current_y].setBackground(new Color(255,255,204));
			}			 new Uygulama().update(l4);
	}
}
	

