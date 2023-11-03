import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EngelT2 extends Engel{

	EngelT2()	
	{
		super();
	}
	EngelT2(Integer tip)	
	{
		super(tip);
	}
	public void model(ArrayList<ArrayList<Izgara>> list )
	{
		int syc;
			for(ArrayList<Izgara> ı : list)
			{
				 syc=(int)(Math.random()*4);
		              if(syc==0)       	 
		              {
		            	  EngelT2 e =new EngelT2(2);
		            	  ı.get(0).engel=e;
		            	  ı.get(0).engel.engelOn=true;
		            	  EngelT2 e2 =new EngelT2(2);
		            	  ı.get(1).engel=e2;
		            	  ı.get(1).engel.engelOn=true;
		            	  EngelT2 e3 =new EngelT2(2);
		            	  ı.get(2).engel=e3;
		            	  ı.get(2).engel.engelOn=true;
		              }
		              else if(syc==1)
		              {
		            	  EngelT2 e =new EngelT2(2);
		            	  ı.get(3).engel=e;
		            	  ı.get(3).engel.engelOn=true;
		            	  EngelT2 e2 =new EngelT2(2);
		            	  ı.get(1).engel=e2;
		            	  ı.get(1).engel.engelOn=true;
		            	  EngelT2 e3 =new EngelT2(2);
		            	  ı.get(2).engel=e3;
		            	  ı.get(2).engel.engelOn=true;
		              }
		              else if(syc==2)
		              {
		            	  EngelT2 e =new EngelT2(2);
		            	  ı.get(0).engel=e;
		            	  ı.get(0).engel.engelOn=true;
		            	  EngelT2 e2 =new EngelT2(2);
		            	  ı.get(2).engel=e2;
		            	  ı.get(2).engel.engelOn=true;
		            	  
		              }
		              else if(syc==3)
		              {
		            	  EngelT2 e =new EngelT2(2);
		            	  ı.get(1).engel=e;
		            	  ı.get(1).engel.engelOn=true;
		            	  EngelT2 e2 =new EngelT2(2);
		            	  ı.get(3).engel=e2;
		            	  ı.get(3).engel.engelOn=true;

		              }
		              
		}
	}
	
	public Image setIcon()
	{
		return new ImageIcon(this.getClass().getResource("/wall2.png")).getImage();
	}
}
