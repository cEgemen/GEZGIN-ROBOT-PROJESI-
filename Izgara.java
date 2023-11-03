import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Izgara extends JButton {

	public  int x=0;
	public int y=0;
	public int row=0;
	public int col=0;
	public Izgara[] [] desen;
	public ArrayList<String>  d = new ArrayList<String>();
    public boolean visited=false;
    public boolean seem=false;
    public Engel engel;
    public int deger=0;
    public boolean engelAlan=false;
    public int distance=0;
    public Izgara parent=null;
	public Izgara()
	{
	
	}
	public Izgara(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public void read(String s , Izgara ı)
	{
		int syc=0;
		URL url=null;
		URLConnection u=null;
		try {
			 url =new URL(s);
			  u=url.openConnection();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    try(BufferedReader bf =new BufferedReader(new InputStreamReader(u.getInputStream()))){
	    	String line;
	    	while ((line=bf.readLine())!=null)
	    	{
	    		String st=line;
	    	  d.add(st);
	         syc++;
	    	}
	    	this.col=syc;
	     this.row=d.get(0).toCharArray().length;
	    	
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	    public void build(Izgara ı)
	    {
	    	for(int i=0;i<ı.row+2;i++)
	    	{
	    		char [] arr =null;
	    		if(i!=0 && i!=row+1)
	    		{
	    			arr=ı.d.get(i-1).toCharArray();
	    			for (int k=0;k<ı.d.get(i-1).toCharArray().length;k++)
	    			{
	    				System.out.print(ı.d.get(i-1).toCharArray()[k]);
	    			}
	    			System.out.println();
	    		}
	    		for(int j=0;j<ı.col+2;j++)
	    		{
	    			if(i==0 || j==0)
	    			{
	    				Izgara ız =new Izgara();
	    				ız.setVisible(false);
	    				ız.x=i;
	    			//	ız.y=y;
	    				ız.y=j;
	    			Engel e =new EngelT1(1);
	    			e.engelOn=true;
	    			ız.engel=e;
	    			    ız.seem=false;
	    				ı.desen[i][j]=ız;
	    			}
	    			else if(i==row+1 || j==col+1)
	    			{
	    				Izgara ız =new Izgara();
	    				ız.setVisible(false);
	    				ız.x=i;
	    				//ız.y=y;
	    				ız.y=j;
	    				Engel e =new EngelT1(1);
		    			e.engelOn=true;
		    			ız.engel=e;
	    			    ız.seem=false;
	    				ı.desen[i][j]=ız;
	    			}
	    			else
	    			{
	    				Izgara ız =new Izgara();
	    				ız.setVisible(false);
	    				ız.x=i;
	    				ız.y=j;
	    				Engel e ;
	    				if((int)arr[j-1]<4) {
	    				  e=new Engel((int)arr[j-1]);	
	    				}
	    				else {
	    				 e = new Engel((int)arr[j-1]-48);
	    				}
	    				ız.engel=e;		
	    				ı.desen[i][j]=ız;
	    			}
	    		}
	    	}
	    }
	public void creat(Izgara ı,JPanel panel)
	{
        for (int i=0;i<ı.row;i++)
        {
        	for(int j=0;j<ı.col;j++)
        	{
        		Izgara ız = new Izgara(i,j);
        		ız.setVisible(false);
        		Engel e = new EngelT1(1);
        		e.engelOn=true;
        		ız.engel=e;
        		ı.desen[i][j]=ız;
        		panel.add(ı.desen[i][j]);
        	}
        }
	}
	public void Maze(Izgara[][] ı,int sx,int sy){
		Integer [] arr =this.random();
		for(int i=0;i<arr.length;i++)
		{
			switch(arr[i]) {
			case 1:
				if(((sy+2)>=ı[1].length-1) ){
					if((sy+1==ı[1].length-1 || sy+1==ı[1].length-2))
					{
						 ı[sx][sy+1].engel=new Engel(0);
	                      ı[sx][sy+1].engel.engelOn=false;
	                      ı[sx][sy+1].setBackground(null);
					}
					continue;
				}
				if(ı[sx][sy+2].engel.engelOn!=false)
               {
                      ı[sx][sy+2].engel=new Engel(0);
                      ı[sx][sy+2].engel.engelOn=false;
                      ı[sx][sy+2].setBackground(null);
                      ı[sx][sy+1].engel=new Engel(0);
                      ı[sx][sy+1].engel.engelOn=false;
                      ı[sx][sy+1].setBackground(null);
                      Maze(ı,sx,sy+2);
               }
				break;
			case 2:	
				if(((sx+2)>=ı.length-1) ){
					if((sx+1==ı[1].length-1 || sx+1==ı[1].length-2) )
					{
						 ı[sx+1][sy].engel=new Engel(0);
	                      ı[sx+1][sy].engel.engelOn=false;
	                      ı[sx+1][sy].setBackground(null);
					}
					continue;
				}
				if(ı[sx+2][sy].engel.engelOn!=false)
               {
                      ı[sx+2][sy].engel=new Engel(0);
                      ı[sx+2][sy].engel.engelOn=false;
                      ı[sx+2][sy].setBackground(null);
                      ı[sx+1][sy].engel=new Engel(0);
                      ı[sx+1][sy].engel.engelOn=false;
                      ı[sx+1][sy].setBackground(null);
                      Maze(ı,sx+2,sy);
               }
				break;
			case 3:
				if(((sx-2)<=0) ){
					if((sx-1==0 || sx-1==1 ))
					{
						 ı[sx-1][sy].engel=new Engel(0);
	                      ı[sx-1][sy].engel.engelOn=false;
	                      ı[sx-1][sy].setBackground(null);
					}
					continue;
				}
				if(ı[sx-2][sy].engel.engelOn!=false)
               {
                      ı[sx-2][sy].engel=new Engel(0);
                      ı[sx-2][sy].engel.engelOn=false;
                      ı[sx-2][sy].setBackground(null);
                      ı[sx-1][sy].engel=new Engel(0);
                      ı[sx-1][sy].engel.engelOn=false;
                      ı[sx-1][sy].setBackground(null);
                      Maze(ı,sx-2,sy);
               }
				break;
			case 4:
				if(((sy-2)<=0) ){
					if((sy-1==0 || sy-1==1))
					{
						 ı[sx][sy-1].engel=new Engel(0);
	                      ı[sx][sy-1].engel.engelOn=false;
	                      ı[sx][sy-1].setBackground(null);
					}
					continue;
				}
				if(ı[sx][sy-2].engel.engelOn!=false)
               {
                      ı[sx][sy-2].engel=new Engel(0);
                      ı[sx][sy-2].engel.engelOn=false;
                      ı[sx][sy-2].setBackground(null);
                      ı[sx][sy-1].engel=new Engel(0);
                      ı[sx][sy-1].engel.engelOn=false;
                      ı[sx][sy-1].setBackground(null);
                      Maze(ı,sx,sy-2);
               }
				break;
			}
		}
			
		
	}
	public void fillMaze(Izgara[][] ı)
	{
		for (int i=0;i<ı.length;i++)
		{
			for(int j=0;j<ı[1].length;j++)
			{
				if(i==0 || j==0)
				{
					if(i==1 && j==0) {
					   ı[i][j].engel=new Engel(0);
						ı[i][j].engel.engelOn=false;
					}
					else {
					ı[i][j].engel=new EngelT1(1);
					ı[i][j].engel.engelOn=true;
					}
				}
				if(i==ı.length-1 || j==ı[1].length-1)
				{
				if(i==ı.length-2)
				{
					ı[i][j].engel=new Engel(0);
					ı[i][j].engel.engelOn=false;
				}
				else {
					ı[i][j].engel=new EngelT1(1);
					ı[i][j].engel.engelOn=true;
				}
				}
			}
			
		}
	}
	public  Integer[] random()
	{
		ArrayList<Integer> random = new ArrayList<Integer>();  
		for(int i=1;i<=4;i++)
		{
			random.add(i);
		}
		Collections.shuffle(random);
		Integer [] tmp = new Integer [4];
		Integer[] tmp2 = random.toArray(tmp);
		return tmp2;
	}
	public void desen(Izgara ı)
	{
		for (int i=0;i<ı.desen.length;i++)
		{
			System.out.println("------------------------------------------------------------");
			for (int j=0;j<ı.desen[1].length;j++)
			{
				System.out.print("| "+ı.desen[i][j].engel.engelTip);
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------");

	}
	public void desen2(Izgara ı)
	{
		for (int i=0;i<ı.desen.length;i++)
		{
			System.out.println("------------------------------------------------------------");
			for (int j=0;j<ı.desen[1].length;j++)
			{
				System.out.print("| "+ı.desen[i][j].distance);
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------");

	}
}
