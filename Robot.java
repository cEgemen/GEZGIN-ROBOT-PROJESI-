import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Robot {
     
	int x;
	int y;
	int mod=-1;
	static int syc=0;
	static int step=0;
	boolean firstSteps=false;
	Stack<Izgara> hafıza=new Stack<Izgara>();
	ArrayList<Izgara> gecilenYerler= new ArrayList<Izgara>();
	LinkedList<Izgara> shortest = new LinkedList<Izgara>();
	ArrayList<Integer> finis = new ArrayList<Integer>();
	ArrayList<Integer> start= new ArrayList<Integer>();
	public Robot()
	{
		
	}
	public Robot(int x ,int y)
	{
		this.x=x;
		this.y=y;
	}
public void mod(int current_x,int current_y,int end_x,int end_y)
{
	int x = current_x-end_x;
	int y=current_y-end_y;
   if((x>0 && y>0) || (x==0 && y>0))
	{
		//sol-yukarı-asagı-sag;
		this.mod=1;
	}
	else if((x>0 && y<0) || (x==0 && y<0))
	{
		//sag-yukarı-asagı-sol;
		this.mod=2;
	}
	else if((x<0 && y>0) || (x<0 && y==0))
	{
		//asagı-sol-sag-yukarı;
		this.mod=3;
	}
	else if((x<0 && y<0) || (x>0 && y==0))
	{
		//asagı-sag-sol-yukarı
		this.mod=4;
	}
}
public void move2(Izgara[][] ı , int start_x,int start_y,int end_x,int end_y)
{ 
	if(this.shortest.size()!=0)
	{
		if(x==start_x && y==start_y)
		{
			System.out.println("giris");
			ı[x][y].visited=true;
			ı[x][y].seem=true;
			ı[x][y].setVisible(true);
			 this.start.add(start_x);
			  this.start.add(start_y);
			  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
				{
					ı[x-1][y].setVisible(true);
					   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
					   if(ı[x-1][y].engel instanceof EngelT1)
						{
						   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x-1][y].engel instanceof EngelT2)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x-1][y].engel instanceof EngelT3)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x-1][y].seem=true;
				}
				if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
				{
					ı[x][y-1].setVisible(true);
					   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
					   if(ı[x][y-1].engel instanceof EngelT1)
						{
						   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y-1].engel instanceof EngelT2)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y-1].engel instanceof EngelT3)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y-1].seem=true;
							   
				}
				if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
				{
					ı[x+1][y].setVisible(true);
					   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
					   if(ı[x+1][y].engel instanceof EngelT1)
						{
						   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x+1][y].engel instanceof EngelT2)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x+1][y].engel instanceof EngelT3)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x+1][y].seem=true;
				}
				if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
				{
					ı[x][y+1].setVisible(true);
					   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
					   if(ı[x][y+1].engel instanceof EngelT1)
						{
						   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y+1].engel instanceof EngelT2)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y+1].engel instanceof EngelT3)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y+1].seem=true;
				}
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				System.out.println("ilk eleman hafızada");
	                         hafıza.push(ı[x][y]);			
			}
			new Uygulama().step();
		}
		while(true) {
	    if(this.shortest.get(syc).visited==true)
	    {
	    	syc++;
	    }
	    else {
	    	this.x=this.shortest.get(syc).x;
	    	this.y=this.shortest.get(syc).y;
	    	ı[this.x][this.y].visited=true;
			ı[this.x][this.y].seem=true;
			ı[this.x][this.y].setVisible(true);
			  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
				{
					ı[x-1][y].setVisible(true);
					   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
					   if(ı[x-1][y].engel instanceof EngelT1)
						{
						   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x-1][y].engel instanceof EngelT2)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x-1][y].engel instanceof EngelT3)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x-1][y].seem=true;
				}
				if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
				{
					ı[x][y-1].setVisible(true);
					   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
					   if(ı[x][y-1].engel instanceof EngelT1)
						{
						   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y-1].engel instanceof EngelT2)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y-1].engel instanceof EngelT3)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y-1].seem=true;
							   
				}
				if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
				{
					ı[x+1][y].setVisible(true);
					   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
					   if(ı[x+1][y].engel instanceof EngelT1)
						{
						   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x+1][y].engel instanceof EngelT2)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x+1][y].engel instanceof EngelT3)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x+1][y].seem=true;
				}
				if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
				{
					ı[x][y+1].setVisible(true);
					   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
					   if(ı[x][y+1].engel instanceof EngelT1)
						{
						   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y+1].engel instanceof EngelT2)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y+1].engel instanceof EngelT3)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y+1].seem=true;
				}
				if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
				{
					System.out.println("ilk eleman hafızada");
		                         hafıza.push(ı[x][y]);			
				}
			new Uygulama().step();
			syc++;
			break;
	    }
	}  
	}
	else if(this.gecilenYerler.size()!=0  && syc<this.gecilenYerler.size() && this.firstSteps==false)
	{
		System.out.println("else if giris");
		System.out.println("syc"+syc);
		if(x==start_x && y==start_y)
		{
			System.out.println("giris");
			ı[x][y].visited=true;
			ı[x][y].seem=true;
			ı[x][y].setVisible(true);
			 this.start.add(start_x);
			  this.start.add(start_y);
			  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
				{
					ı[x-1][y].setVisible(true);
					   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
					   if(ı[x-1][y].engel instanceof EngelT1)
						{
						   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x-1][y].engel instanceof EngelT2)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x-1][y].engel instanceof EngelT3)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x-1][y].seem=true;
				}
				if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
				{
					ı[x][y-1].setVisible(true);
					   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
					   if(ı[x][y-1].engel instanceof EngelT1)
						{
						   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y-1].engel instanceof EngelT2)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y-1].engel instanceof EngelT3)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y-1].seem=true;
							   
				}
				if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
				{
					ı[x+1][y].setVisible(true);
					   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
					   if(ı[x+1][y].engel instanceof EngelT1)
						{
						   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x+1][y].engel instanceof EngelT2)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x+1][y].engel instanceof EngelT3)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x+1][y].seem=true;
				}
				if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
				{
					ı[x][y+1].setVisible(true);
					   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
					   if(ı[x][y+1].engel instanceof EngelT1)
						{
						   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y+1].engel instanceof EngelT2)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y+1].engel instanceof EngelT3)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y+1].seem=true;
				}
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				System.out.println("ilk eleman hafızada");
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			new Uygulama().step();
		}
		while(true)
		{
			System.out.println("syc="+syc);
			  if(this.gecilenYerler.get(syc).visited==true )
			    {
			    	syc++;
			    	break;
			    }
			    else {
			    	this.x=this.gecilenYerler.get(syc).x;
			    	this.y=this.gecilenYerler.get(syc).y;
			    	ı[this.x][this.y].visited=true;
					ı[this.x][this.y].seem=true;
					ı[this.x][this.y].setVisible(true);
					  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
						{
							ı[x-1][y].setVisible(true);
							   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
							   if(ı[x-1][y].engel instanceof EngelT1)
								{
								   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x-1][y].engel instanceof EngelT2)
								{
									   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x-1][y].engel instanceof EngelT3)
								{
									   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x-1][y].seem=true;
						}
						if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
						{
							ı[x][y-1].setVisible(true);
							   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
							   if(ı[x][y-1].engel instanceof EngelT1)
								{
								   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x][y-1].engel instanceof EngelT2)
								{
									   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x][y-1].engel instanceof EngelT3)
								{
									   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x][y-1].seem=true;
									   
						}
						if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
						{
							ı[x+1][y].setVisible(true);
							   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
							   if(ı[x+1][y].engel instanceof EngelT1)
								{
								   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x+1][y].engel instanceof EngelT2)
								{
									   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x+1][y].engel instanceof EngelT3)
								{
									   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x+1][y].seem=true;
						}
						if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
						{
							ı[x][y+1].setVisible(true);
							   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
							   if(ı[x][y+1].engel instanceof EngelT1)
								{
								   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x][y+1].engel instanceof EngelT2)
								{
									   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x][y+1].engel instanceof EngelT3)
								{
									   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x][y+1].seem=true;
						}
						if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
						{
							System.out.println("ilk eleman hafızada");
				                         hafıza.push(ı[x][y]);			
						}
					new Uygulama().step();
					step++;
					syc++;
					System.out.println("syc="+syc);
					break;
			    }
		}
	}
		else {
		this.firstSteps=true;
	if(x==start_x && y==start_y)
	{
		System.out.println("giris");
		ı[x][y].visited=true;
		ı[x][y].seem=true;
		ı[x][y].setVisible(true);
		this.start.add(start_x);
		this.start.add(start_y);
		  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}
		if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
		{
			System.out.println("ilk eleman hafızada");
                         hafıza.push(ı[x][y]);			
		}
		step++;
		if(this.gecilenYerler.size()+1==step)
		{
			this.gecilenYerler.add(ı[x][y]);
			System.out.println("add");
		}
		new Uygulama().step();
		this.mod(this.x,this.y,end_x, end_y);
		System.out.println("baslangıc mod:"+mod);
	}                             
   switch(mod)	 
   {
   case 1:
	   //sol-yukarı-asagı-sag
		System.out.println("mod1(sol-yukarı-asagı-sag):"+mod);
	   if((y-1)>=0 && ı[x][y-1].visited==false && ı[x][y-1].engel.engelOn==false)
	   {
		   this.y=this.y-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}
		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else if((x-1)>=0 && ı[x-1][y].visited==false && ı[x-1][y].engel.engelOn==false)
	   {
		   this.x=this.x-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}
			   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
				step++;
				if(this.gecilenYerler.size()+1==step)
				{
					this.gecilenYerler.add(ı[x][y]);
					System.out.println("add");
				}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else if((x+1)<=ı.length-1 && ı[x+1][y].visited==false && ı[x+1][y].engel.engelOn==false)
	   {
		   this.x=this.x+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}
				   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
					step++;
					if(this.gecilenYerler.size()+1==step)
					{
						this.gecilenYerler.add(ı[x][y]);
						System.out.println("add");
					}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else if((y+1)<=ı.length-1 && ı[x-1][y].visited==false && ı[x-1][y].engel.engelOn==false)
	   {
		   this.y=this.y+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else
		{
			System.out.println("Gidilecek bir yer yok geri dönülüyor");
			if(hafıza.size()==0)
			{
				System.out.println("Stack boş sistem kapatıldı");
				System.exit(0);
			}
			Izgara ız = hafıza.pop();
			this.x=ız.x;
			this.y=ız.y;
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				           
		                     hafıza.push(ı[x][y]);			
			}
			this.mod(this.x,this.y,end_x,end_y);
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
		}
	   break;
	   
   case 2:
	   //sag-yukarı-asagı-sol
		System.out.println("mod2(sag-yukarı-asagı-sol):"+mod);
	   if((y+1)<=ı.length-1 && ı[x][y+1].visited==false && ı[x][y+1].engel.engelOn==false)
	   {
		   this.y=this.y+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else if((x-1)>=0 && ı[x-1][y].visited==false && ı[x-1][y].engel.engelOn==false)
	   {
		   this.x=this.x-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}	   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else if((x+1)<=ı.length-1 && ı[x+1][y].visited==false && ı[x+1][y].engel.engelOn==false)
	   {
		   this.x=this.x+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}	   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else  if((y-1)>=0 && ı[x][y-1].visited==false && ı[x][y-1].engel.engelOn==false)
	   {
		   this.y=this.y-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}	   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else
		{
			System.out.println("Gidilecek bir yer yok geri dönülüyor");
			if(hafıza.size()==0)
			{
				System.out.println("Stack boş sistem kapatıldı");
				System.exit(0);
			}
			Izgara ız = hafıza.pop();
			this.x=ız.x;
			this.y=ız.y;
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				           
		                     hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			this.mod(this.x,this.y,end_x,end_y);
		}
	   break;
	   
   case 3:
	   //asagı-sol-sag-yukarı
		System.out.println("mod3(asagı-sol-sag-yukarı):"+mod);
	   if((x+1)<=ı.length-1 && ı[x+1][y].visited==false && ı[x+1][y].engel.engelOn==false)
	   {
		   this.x=this.x+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}	   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else  if((y-1)>=0 && ı[x][y-1].visited==false && ı[x][y-1].engel.engelOn==false)
	   {
		   this.y=this.y-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else  if((y+1)<=ı.length-1 && ı[x][y+1].visited==false && ı[x][y+1].engel.engelOn==false)
	   {
		   this.y=this.y+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else if((x-1)>=0 && ı[x-1][y].visited==false && ı[x-1][y].engel.engelOn==false)
	   {
		   this.x=this.x-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else
		{
			System.out.println("Gidilecek bir yer yok geri dönülüyor");
			if(hafıza.size()==0)
			{
				System.out.println("Stack boş sistem kapatıldı");
				System.exit(0);
			}
			Izgara ız = hafıza.pop();
			this.x=ız.x;
			this.y=ız.y;
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				           
		                     hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			this.mod(this.x,this.y,end_x,end_y);
		}
	   break;
   case 4:	 
	   //asagı-sag-sol-yukarı
		System.out.println("mod4(asagı-sag-sol-yukarı):"+mod);
	   if((x+1)<=ı.length-1 && ı[x+1][y].visited==false && ı[x+1][y].engel.engelOn==false)
	   {
		   this.x=this.x+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else  if((y+1)<=ı.length-1 && ı[x][y+1].visited==false && ı[x][y+1].engel.engelOn==false)
	   {
		   this.y=this.y+1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else  if((y-1)>=0 && ı[x][y-1].visited==false && ı[x][y-1].engel.engelOn==false)
	   {
		   this.y=this.y-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}	   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else if((x-1)>=0 && ı[x-1][y].visited==false && ı[x-1][y].engel.engelOn==false)
	   {
		   this.x=this.x-1;
		   ı[x][y].visited=true;
		   ı[x][y].seem=true;
			ı[x][y].setVisible(true);
		   if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}		   if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			new Uygulama().step();
			this.mod(this.x,this.y,end_x,end_y);
	   }
	   else
		{
			System.out.println("Gidilecek bir yer yok geri dönülüyor");
			if(hafıza.size()==0)
			{
				System.out.println("Stack boş sistem kapatıldı");
				System.exit(0);
			}
			Izgara ız = hafıza.pop();
			this.x=ız.x;
			this.y=ız.y;
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				           
		                     hafıza.push(ı[x][y]);			
			}
			step++;
			if(this.gecilenYerler.size()+1==step)
			{
				this.gecilenYerler.add(ı[x][y]);
				System.out.println("add");
			}
			this.mod(this.x,this.y,end_x,end_y);
		}
	break;   
   }
	}
}
public void move(Izgara[][] ı,int start_x,int start_y)	
{
	if(this.shortest.size()!=0)
	{
		if(x==start_x && y==start_y)
		{
			System.out.println("giris");
			ı[x][y].visited=true;
			ı[x][y].seem=true;
			ı[x][y].setVisible(true);
			 this.start.add(start_x);
			  this.start.add(start_y);
			  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
				{
					ı[x-1][y].setVisible(true);
					   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
					   if(ı[x-1][y].engel instanceof EngelT1)
						{
						   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x-1][y].engel instanceof EngelT2)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x-1][y].engel instanceof EngelT3)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x-1][y].seem=true;
				}
				if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
				{
					ı[x][y-1].setVisible(true);
					   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
					   if(ı[x][y-1].engel instanceof EngelT1)
						{
						   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y-1].engel instanceof EngelT2)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y-1].engel instanceof EngelT3)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y-1].seem=true;
							   
				}
				if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
				{
					ı[x+1][y].setVisible(true);
					   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
					   if(ı[x+1][y].engel instanceof EngelT1)
						{
						   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x+1][y].engel instanceof EngelT2)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x+1][y].engel instanceof EngelT3)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x+1][y].seem=true;
				}
				if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
				{
					ı[x][y+1].setVisible(true);
					   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
					   if(ı[x][y+1].engel instanceof EngelT1)
						{
						   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y+1].engel instanceof EngelT2)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y+1].engel instanceof EngelT3)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y+1].seem=true;
				}
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				System.out.println("ilk eleman hafızada");
	                         hafıza.push(ı[x][y]);			
			}
			new Uygulama().step();
		}
		while(true) {
	    if(this.shortest.get(syc).visited==true)
	    {
	    	syc++;
	    }
	    else {
	    	this.x=this.shortest.get(syc).x;
	    	this.y=this.shortest.get(syc).y;
	    	ı[this.x][this.y].visited=true;
			ı[this.x][this.y].seem=true;
			ı[this.x][this.y].setVisible(true);
			  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
				{
					ı[x-1][y].setVisible(true); 
					   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
					   if(ı[x-1][y].engel instanceof EngelT1)
						{
						   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x-1][y].engel instanceof EngelT2)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x-1][y].engel instanceof EngelT3)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x-1][y].seem=true;
				}
				if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
				{
					ı[x][y-1].setVisible(true);
					   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
					   if(ı[x][y-1].engel instanceof EngelT1)
						{
						   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y-1].engel instanceof EngelT2)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y-1].engel instanceof EngelT3)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y-1].seem=true;
							   
				}
				if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
				{
					ı[x+1][y].setVisible(true);
					   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
					   if(ı[x+1][y].engel instanceof EngelT1)
						{
						   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x+1][y].engel instanceof EngelT2)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x+1][y].engel instanceof EngelT3)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x+1][y].seem=true;
				}
				if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
				{
					ı[x][y+1].setVisible(true);
					   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
					   if(ı[x][y+1].engel instanceof EngelT1)
						{
						   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y+1].engel instanceof EngelT2)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y+1].engel instanceof EngelT3)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y+1].seem=true;
				}
				if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
				{
					System.out.println("ilk eleman hafızada");
		                         hafıza.push(ı[x][y]);			
				}
			new Uygulama().step();
			syc++;
			break;
	    }
	}  
	
	}
	else if(this.gecilenYerler.size()!=0  && syc<this.gecilenYerler.size() && this.firstSteps==false)
	{
		System.out.println("else if giris");
		System.out.println("syc1="+syc);
		if(x==start_x && y==start_y)
		{
			System.out.println("giris");
			ı[x][y].visited=true;
			ı[x][y].seem=true;
			ı[x][y].setVisible(true);
			 this.start.add(start_x);
			  this.start.add(start_y);
			  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
				{
					ı[x-1][y].setVisible(true);
					   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
					   if(ı[x-1][y].engel instanceof EngelT1)
						{
						   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x-1][y].engel instanceof EngelT2)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x-1][y].engel instanceof EngelT3)
						{
							   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x-1][y].seem=true;
				}
				if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
				{
					ı[x][y-1].setVisible(true);
					   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
					   if(ı[x][y-1].engel instanceof EngelT1)
						{
						   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y-1].engel instanceof EngelT2)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y-1].engel instanceof EngelT3)
						{
							   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y-1].seem=true;
							   
				}
				if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
				{
					ı[x+1][y].setVisible(true);
					   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
					   if(ı[x+1][y].engel instanceof EngelT1)
						{
						   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x+1][y].engel instanceof EngelT2)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x+1][y].engel instanceof EngelT3)
						{
							   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x+1][y].seem=true;
				}
				if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
				{
					ı[x][y+1].setVisible(true);
					   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
					   if(ı[x][y+1].engel instanceof EngelT1)
						{
						   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
						}
						else if(ı[x][y+1].engel instanceof EngelT2)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
						}
						else if(ı[x][y+1].engel instanceof EngelT3)
						{
							   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
						}   
						else 
						{
							   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
						}
					   ı[x][y+1].seem=true;
				}
			if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
			{
				System.out.println("ilk eleman hafızada");
	                         hafıza.push(ı[x][y]);			
			}
			step++;
			new Uygulama().step();
		}
		while(true)
		{
			System.out.println("syc2="+syc);
			  if(this.gecilenYerler.get(syc).visited==true )
			    {
			    	syc++;
			    	break;
			    }
			    else {
			    	this.x=this.gecilenYerler.get(syc).x;
			    	this.y=this.gecilenYerler.get(syc).y;
			    	ı[this.x][this.y].visited=true;
					ı[this.x][this.y].seem=true;
					ı[this.x][this.y].setVisible(true);
					  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
						{
							ı[x-1][y].setVisible(true);
							   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
							   if(ı[x-1][y].engel instanceof EngelT1)
								{
								   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x-1][y].engel instanceof EngelT2)
								{
									   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x-1][y].engel instanceof EngelT3)
								{
									   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x-1][y].seem=true;
						}
						if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
						{
							ı[x][y-1].setVisible(true);
							   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
							   if(ı[x][y-1].engel instanceof EngelT1)
								{
								   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x][y-1].engel instanceof EngelT2)
								{
									   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x][y-1].engel instanceof EngelT3)
								{
									   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x][y-1].seem=true;
									   
						}
						if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
						{
							ı[x+1][y].setVisible(true);
							   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
							   if(ı[x+1][y].engel instanceof EngelT1)
								{
								   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x+1][y].engel instanceof EngelT2)
								{
									   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x+1][y].engel instanceof EngelT3)
								{
									   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x+1][y].seem=true;
						}
						if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
						{
							ı[x][y+1].setVisible(true);
							   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
							   if(ı[x][y+1].engel instanceof EngelT1)
								{
								   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
								}
								else if(ı[x][y+1].engel instanceof EngelT2)
								{
									   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
								}
								else if(ı[x][y+1].engel instanceof EngelT3)
								{
									   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
								}   
								else 
								{
									   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
								}
							   ı[x][y+1].seem=true;
						}
						if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
						{
							System.out.println("ilk eleman hafızada");
				                         hafıza.push(ı[x][y]);			
						}
					new Uygulama().step();
					step++;
					syc++;
					System.out.println("syc3="+syc);
					break;
			    }
		}
	}
	else {
		this.firstSteps=true;
	if(x==start_x && y==start_y)
	{
		System.out.println("giris");
		ı[x][y].visited=true;
		ı[x][y].seem=true;
		ı[x][y].setVisible(true);
		 this.start.add(start_x);
		  this.start.add(start_y);
		  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
			{
				ı[x-1][y].setVisible(true);
				   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
				   if(ı[x-1][y].engel instanceof EngelT1)
					{
					   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x-1][y].engel instanceof EngelT2)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x-1][y].engel instanceof EngelT3)
					{
						   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x-1][y].seem=true;
			}
			if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
			{
				ı[x][y-1].setVisible(true);
				   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
				   if(ı[x][y-1].engel instanceof EngelT1)
					{
					   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y-1].engel instanceof EngelT2)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y-1].engel instanceof EngelT3)
					{
						   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y-1].seem=true;
						   
			}
			if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
			{
				ı[x+1][y].setVisible(true);
				   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
				   if(ı[x+1][y].engel instanceof EngelT1)
					{
					   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x+1][y].engel instanceof EngelT2)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x+1][y].engel instanceof EngelT3)
					{
						   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x+1][y].seem=true;
			}
			if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
			{
				ı[x][y+1].setVisible(true);
				   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
				   if(ı[x][y+1].engel instanceof EngelT1)
					{
					   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
					}
					else if(ı[x][y+1].engel instanceof EngelT2)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
					}
					else if(ı[x][y+1].engel instanceof EngelT3)
					{
						   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
					}   
					else 
					{
						   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
					}
				   ı[x][y+1].seem=true;
			}
		if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
		{
			System.out.println("ilk eleman hafızada");
                         hafıza.push(ı[x][y]);			
		}
		step++;
		if(this.gecilenYerler.size()+1==step)
		{
			this.gecilenYerler.add(ı[x][y]);
		}
		new Uygulama().step();
	}
ArrayList<Integer> yonList = new ArrayList<Integer>();	
int yon=(int)(Math.random()*4);	
System.out.println("yon:"+yon);
yonList.add(yon);
	while(yonList.size()<=4)
	{
		System.out.println("yonList.size()1:"+yonList.size());
		switch(yon)
		{
		case 0:
			if((x+1<=ı.length-1) && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false)
			{
				System.out.println("case:0");
				this.x=this.x+1;
				ı[x][y].visited=true;
				ı[x][y].seem=true;
				ı[x][y].setVisible(true);
				  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
					{
						ı[x-1][y].setVisible(true);
						   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
						   if(ı[x-1][y].engel instanceof EngelT1)
							{
							   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x-1][y].engel instanceof EngelT2)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x-1][y].engel instanceof EngelT3)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x-1][y].seem=true;
					}
					if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
					{
						ı[x][y-1].setVisible(true);
						   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
						   if(ı[x][y-1].engel instanceof EngelT1)
							{
							   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y-1].engel instanceof EngelT2)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y-1].engel instanceof EngelT3)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y-1].seem=true;
								   
					}
					if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
					{
						ı[x+1][y].setVisible(true);
						   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
						   if(ı[x+1][y].engel instanceof EngelT1)
							{
							   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x+1][y].engel instanceof EngelT2)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x+1][y].engel instanceof EngelT3)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x+1][y].seem=true;
					}
					if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
					{
						ı[x][y+1].setVisible(true);
						   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
						   if(ı[x][y+1].engel instanceof EngelT1)
							{
							   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y+1].engel instanceof EngelT2)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y+1].engel instanceof EngelT3)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y+1].seem=true;
					}
				if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
				{
					           
			                     hafıza.push(ı[x][y]);			
				}
				step++;
				if(this.gecilenYerler.size()+1==step)
				{
					this.gecilenYerler.add(ı[x][y]);
					System.out.println("add");
				}
				new Uygulama().step();
				return;
			}
			break;
		case 1:
			if((y+1<=ı[1].length-1) && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false)
			{
				System.out.println("case:1");
				this.y=this.y+1;
				ı[x][y].visited=true;
				ı[x][y].seem=true;
				ı[x][y].setVisible(true);
				  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
					{
						ı[x-1][y].setVisible(true);
						   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
						   if(ı[x-1][y].engel instanceof EngelT1)
							{
							   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x-1][y].engel instanceof EngelT2)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x-1][y].engel instanceof EngelT3)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x-1][y].seem=true;
					}
					if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
					{
						ı[x][y-1].setVisible(true);
						   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
						   if(ı[x][y-1].engel instanceof EngelT1)
							{
							   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y-1].engel instanceof EngelT2)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y-1].engel instanceof EngelT3)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y-1].seem=true;
								   
					}
					if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
					{
						ı[x+1][y].setVisible(true);
						   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
						   if(ı[x+1][y].engel instanceof EngelT1)
							{
							   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x+1][y].engel instanceof EngelT2)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x+1][y].engel instanceof EngelT3)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x+1][y].seem=true;
					}
					if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
					{
						ı[x][y+1].setVisible(true);
						   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
						   if(ı[x][y+1].engel instanceof EngelT1)
							{
							   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y+1].engel instanceof EngelT2)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y+1].engel instanceof EngelT3)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y+1].seem=true;
					}
				if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
				{
					           
			                     hafıza.push(ı[x][y]);			
				}
				step++;
				if(this.gecilenYerler.size()+1==step)
				{
					this.gecilenYerler.add(ı[x][y]);
					System.out.println("add");

				}
				new Uygulama().step();
				return;
			}
			break;
		case 2:
			if((x-1>=0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false)
			{
				System.out.println("case:2");
				this.x=this.x-1;
				ı[x][y].visited=true;
				ı[x][y].seem=true;
				ı[x][y].setVisible(true);
				  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
					{
						ı[x-1][y].setVisible(true);
						   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
						   if(ı[x-1][y].engel instanceof EngelT1)
							{
							   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x-1][y].engel instanceof EngelT2)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x-1][y].engel instanceof EngelT3)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x-1][y].seem=true;
					}
					if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
					{
						ı[x][y-1].setVisible(true);
						   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
						   if(ı[x][y-1].engel instanceof EngelT1)
							{
							   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y-1].engel instanceof EngelT2)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y-1].engel instanceof EngelT3)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y-1].seem=true;
								   
					}
					if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
					{
						ı[x+1][y].setVisible(true);
						   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
						   if(ı[x+1][y].engel instanceof EngelT1)
							{
							   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x+1][y].engel instanceof EngelT2)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x+1][y].engel instanceof EngelT3)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x+1][y].seem=true;
					}
					if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
					{
						ı[x][y+1].setVisible(true);
						   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
						   if(ı[x][y+1].engel instanceof EngelT1)
							{
							   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y+1].engel instanceof EngelT2)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y+1].engel instanceof EngelT3)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y+1].seem=true;
					}
				if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
				{
					           
			                     hafıza.push(ı[x][y]);			
				}
				step++;
				if(this.gecilenYerler.size()+1==step)
				{
					this.gecilenYerler.add(ı[x][y]);
					System.out.println("add");

				}
				new Uygulama().step();
				return;
			}
			break;
	
		case 3:
			if((y-1>=0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false)
			{
				System.out.println("case:3");
				this.y=this.y-1;
				ı[x][y].visited=true;
				ı[x][y].seem=true;
				ı[x][y].setVisible(true);
				  if((x-1>=0) && ı[x-1][y].visited==false && ı[x-1][y].seem==false)
					{
						ı[x-1][y].setVisible(true);
						   ı[x-1][y].setIcon(new ImageIcon(ı[x-1][y].engel.setIcon(ı[x-1][y].engel)));
						   if(ı[x-1][y].engel instanceof EngelT1)
							{
							   ı[x-1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x-1][y].engel instanceof EngelT2)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x-1][y].engel instanceof EngelT3)
							{
								   ı[x-1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x-1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x-1][y].seem=true;
					}
					if((y-1>=0) && ı[x][y-1].visited==false && ı[x][y-1].seem==false)
					{
						ı[x][y-1].setVisible(true);
						   ı[x][y-1].setIcon(new ImageIcon(ı[x][y-1].engel.setIcon(ı[x][y-1].engel)));
						   if(ı[x][y-1].engel instanceof EngelT1)
							{
							   ı[x][y-1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y-1].engel instanceof EngelT2)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y-1].engel instanceof EngelT3)
							{
								   ı[x][y-1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y-1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y-1].seem=true;
								   
					}
					if((x+1<=ı.length-1) && ı[x+1][y].visited==false && ı[x+1][y].seem==false)
					{
						ı[x+1][y].setVisible(true);
						   ı[x+1][y].setIcon(new ImageIcon(ı[x+1][y].engel.setIcon(ı[x+1][y].engel)));
						   if(ı[x+1][y].engel instanceof EngelT1)
							{
							   ı[x+1][y].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x+1][y].engel instanceof EngelT2)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x+1][y].engel instanceof EngelT3)
							{
								   ı[x+1][y].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x+1][y].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x+1][y].seem=true;
					}
					if((y+1<=ı.length-1) && ı[x][y+1].visited==false && ı[x][y+1].seem==false)
					{
						ı[x][y+1].setVisible(true);
						   ı[x][y+1].setIcon(new ImageIcon(ı[x][y+1].engel.setIcon(ı[x][y+1].engel)));
						   if(ı[x][y+1].engel instanceof EngelT1)
							{
							   ı[x][y+1].setBackground(new java.awt.Color(160,82,45));
							}
							else if(ı[x][y+1].engel instanceof EngelT2)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(102,102,102));
							}
							else if(ı[x][y+1].engel instanceof EngelT3)
							{
								   ı[x][y+1].setBackground(new java.awt.Color(220,20,60));
							}   
							else 
							{
								   ı[x][y+1].setBackground(new java.awt.Color(119,136,153));
							}
						   ı[x][y+1].seem=true;
					}
				if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
				{
					           
			                     hafıza.push(ı[x][y]);			
				}
				step++;
				if(this.gecilenYerler.size()+1==step)
				{
					this.gecilenYerler.add(ı[x][y]);
					System.out.println("add");

				}
				new Uygulama().step();
				return;
			}
			break;
		}
	yon =(int)(Math.random()*4);
System.out.println("yon2:"+yon);
	if(yonList.size()<4) {
		System.out.println("yonList.size()2:"+yonList.size());
	while(true)
	{
		int syc=0;
	   for(int i=0;i<yonList.size();i++)
	   {
		   if(yonList.get(i)==yon)
		   {
			   syc++;
		   }
	   }
	   if(syc==0)
	   {
		   yonList.add(yon);
		   break;
	   }
		yon =(int)(Math.random()*4);
		System.out.println("yon3:"+yon);
	}
	}
	else
	{
		System.out.println("Gidilecek bir yer yok geri dönülüyor");
		if(hafıza.size()==0)
		{
			System.out.println("Stack boş sistem kapatıldı");
			System.exit(0);
		}
		Izgara ız = hafıza.pop();
		this.x=ız.x;
		this.y=ız.y;
		if(( (y+1)!=ı[1].length && ı[x][y+1].engel.engelOn==false && ı[x][y+1].visited==false) || (!((y-1)<0) && ı[x][y-1].engel.engelOn==false && ı[x][y-1].visited==false) || ((x+1)!=ı[1].length && ı[x+1][y].engel.engelOn==false && ı[x+1][y].visited==false) || (!((x-1)<0) && ı[x-1][y].engel.engelOn==false && ı[x-1][y].visited==false))
		{
			           
	                     hafıza.push(ı[x][y]);			
		}
		step++;
		if(this.gecilenYerler.size()+1==step)
		{
			this.gecilenYerler.add(ı[x][y]);
			System.out.println("add");
		}
		return;
	}
	}
	}
}

public void shortestPath(Izgara[][ ] ı)
{
	if(this.start.get(0)==this.finis.get(0) && this.start.get(1)==this.finis.get(1))
	{
		return;
	}
	for (int i=0;i<ı.length;i++)
	{
		for(int j=0;j<ı[1].length;j++)
		{
			if((ı[i][j].visited==true || ı[i][j].seem==true) && ı[i][j].engel.engelOn==false)
			{
				 ı[i][j].distance=(int)(1e9);
			     ı[i][j].parent=null;	 
			}
		}
	}
	Queue <Izgara> q =new LinkedList<Izgara>();
	Izgara src = ı[this.start.get(0)][this.start.get(1)];
	System.out.println("src.x="+src.x+" src.y="+src.y);
	src.distance=0;
	q.add(src);
	Izgara dest = null;
	Izgara p;
	while(!q.isEmpty())
	{
			p = q.peek();
			System.out.println("p.x="+p.x+" p.y="+p.y);
			q.remove();
		System.out.println("queue.size()="+q.size());
		if(p.x==this.finis.get(0) && p.y==this.finis.get(1))
		{
			dest=p;
			break;
		}
		int syc=0;
		while(syc<4)
		{
			if(syc==0) {
			if(p.x-1>=0 && ı[p.x-1][p.y].seem==true && ı[p.x-1][p.y].engel.engelOn==false && p.distance+1<ı[p.x-1][p.y].distance)	{
			Izgara p2=ı[p.x-1][p.y];
		     p2.distance=p.distance+1;
			 	System.out.println("p2.x="+p2.x+" p2.y="+p2.y+" distance="+p2.distance);
		     p2.parent=p;
			q.add(p2);
			System.out.println("queue.size()="+q.size());

			}
			}
			if(syc==1)
			{
				if(p.y-1>=0 && ı[p.x][p.y-1].seem==true && ı[p.x][p.y-1].engel.engelOn==false && p.distance+1<ı[p.x][p.y-1].distance)	{
					Izgara p2=ı[p.x][p.y-1];
				     p2.distance=p.distance+1;
					 	System.out.println("p2.x="+p2.x+" p2.y="+p2.y+" distance="+p2.distance);
				     p2.parent=p;
					q.add(p2);
					System.out.println("queue.size()="+q.size());

					}				
			}
			if(syc==2)
			{
				if(p.x+1<=ı.length-1 && ı[p.x+1][p.y].seem==true && ı[p.x+1][p.y].engel.engelOn==false && p.distance+1<ı[p.x+1][p.y].distance)	{
					Izgara p2=ı[p.x+1][p.y];
				     p2.distance=p.distance+1;
					 	System.out.println("p2.x="+p2.x+" p2.y="+p2.y+" distance="+p2.distance);
				     p2.parent=p;
					q.add(p2);
					System.out.println("queue.size()="+q.size());

					}				
			}
			if(syc==3)
			{
				if(p.y+1<=ı[1].length-1 && ı[p.x][p.y+1].seem==true && ı[p.x][p.y+1].engel.engelOn==false && p.distance+1<ı[p.x][p.y+1].distance)	{
					Izgara p2=ı[p.x][p.y+1];
				     p2.distance=p.distance+1;
					 	System.out.println("p2.x="+p2.x+" p2.y="+p2.y+" distance="+p2.distance);
				     p2.parent=p;
					q.add(p2);
					System.out.println("queue.size()="+q.size());

					}
			}
			syc++;
		}
		}
		if(dest==null)
		{
			return;
		}
		else {
	p=dest;
			do {		
				this.shortest.addFirst(p);
			}
			while((p=p.parent)!=null);
	}
	
}
public void settings1(int x , int y)
{
	this.x=x;
	this.y=y;
	this.syc=0;
	this.step=0;
	this.hafıza=new Stack<Izgara> ();
	this.finis=new ArrayList<Integer>();
	this.start=new ArrayList<Integer>();
	this.shortest=new LinkedList<Izgara>();
	this.gecilenYerler=new ArrayList<Izgara>();
}
public void settings2(int x ,int y)
{
	this.x=x;
	this.y=y;
	this.syc=0;
	this.step=0;
	this.hafıza=new Stack<Izgara> ();
	this.finis=new ArrayList<Integer>();
	this.start=new ArrayList<Integer>();
}


}
