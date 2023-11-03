import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Engel {

	public Integer engelTip;
	public boolean engelOn;
	public ArrayList<ArrayList<Izgara>> tip3 = new ArrayList<ArrayList<Izgara>>();
	public ArrayList<ArrayList<Izgara>> tip2 = new ArrayList<ArrayList<Izgara>>();
	public ArrayList<Izgara> tip1 = new ArrayList<Izgara>();

public Engel()
{
	this.engelTip=0;
	this.engelOn=false;
}
public Engel(Integer engelTip)
{
	this.engelTip=engelTip;
}
public void engelAlan1(Izgara[][] ı)
{
	for(int i=1;i<ı.length-1;i++)
	{
		for(int j=1;j<ı[1].length-1;j++)
		{
			if(ı[i][j].engel.engelTip==1)
			{
				tip1.add(ı[i][j]);
			}
		}
	}
	System.out.println("tip1 alan sayısı: "+tip1.size());

}
public void engelAlan2(Izgara[][] ı)
{
	for(int i=1;i<ı.length-1;i++)
	{
		ArrayList<Izgara> z = new ArrayList<Izgara>();
		for(int j=1;j<ı[1].length-1;j++)
		{
			if(ı[i][j].engel.engelTip==2 && ı[i][j].engelAlan==false)
			{
				ı[i][j].engelAlan=true;
				z.add(ı[i][j]);
				ı[i+1][j].engelAlan=true;
				z.add(ı[i+1][j]);
				ı[i][j+1].engelAlan=true;
				z.add(ı[i][j+1]);
				ı[i+1][j+1].engelAlan=true;
				z.add(ı[i+1][j+1]);
				tip2.add(z);
			}
		}
	}
	
	System.out.println("tip2 alan sayısı: "+tip2.size());
	
}
public void engelAlan3(Izgara[][] ı)
{
	for(int i=1;i<ı.length-1;i++)
	{
		ArrayList<Izgara> z = new ArrayList<Izgara>();
		for(int j=1;j<ı[1].length-1;j++)
		{
			if(ı[i][j].engel.engelTip==3 && ı[i][j].engelAlan==false)
			{
				ı[i][j].engelAlan=true;
				z.add(ı[i][j]);
				ı[i][j+1].engelAlan=true;
				z.add(ı[i][j+1]);
				ı[i][j+2].engelAlan=true;
				z.add(ı[i][j+2]);
				ı[i+1][j].engelAlan=true;
				z.add(ı[i+1][j]);
				ı[i+1][j+1].engelAlan=true;
				z.add(ı[i+1][j+1]);
				ı[i+1][j+2].engelAlan=true;
				z.add(ı[i+1][j+2]);
				ı[i+2][j].engelAlan=true;
				z.add(ı[i+2][j]);
				ı[i+2][j+1].engelAlan=true;
				z.add(ı[i+2][j+1]);
				ı[i+2][j+2].engelAlan=true;
				z.add(ı[i+2][j+2]);
				tip3.add(z);
			}
		}
	}
	
	System.out.println("tip3 alan sayısı: "+tip3.size());
}

public Image setIcon(Engel engel)
{
	if(engel instanceof EngelT1)
	{
		return new EngelT1().setIcon();
	}
	else if(engel instanceof EngelT2)
	{
		return new EngelT2().setIcon();
	}
	else if(engel instanceof EngelT3)
	{
		return new EngelT3().setIcon();
	}
	return new ImageIcon(this.getClass().getResource("/way.png")).getImage();
}

}
