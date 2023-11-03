import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EngelT3 extends Engel{

	
EngelT3()	
{
	super();
}
EngelT3(Integer tip)	
{
	super(tip);
}
public void model(ArrayList<ArrayList<Izgara>> list)
{
	int syc=0;
	for(ArrayList<Izgara> ı : list)
	{
		syc=(int)(Math.random()*5);
		if(syc==0)
		{
			EngelT3 e = new EngelT3(3);
			e.engelOn=true;
			ı.get(0).engel=e;
			EngelT3 e2 = new EngelT3(3);
			e2.engelOn=true;
			ı.get(3).engel=e2;
			EngelT3 e3 = new EngelT3(3);
			e3.engelOn=true;
			ı.get(6).engel=e3;
		}
		else if(syc==1)
		{
			EngelT3 e = new EngelT3(3);
			e.engelOn=true;
			ı.get(0).engel=e;
			EngelT3 e2 = new EngelT3(3);
			e2.engelOn=true;
			ı.get(3).engel=e2;
			EngelT3 e4 = new EngelT3(3);
			e4.engelOn=true;
			ı.get(4).engel=e4;
			EngelT3 e3 = new EngelT3(3);
			e3.engelOn=true;
			ı.get(6).engel=e3;
		}
		else if(syc==2)
		{
			EngelT3 e = new EngelT3(3);
			e.engelOn=true;
			ı.get(6).engel=e;
			EngelT3 e2 = new EngelT3(3);
			e2.engelOn=true;
			ı.get(7).engel=e2;
			EngelT3 e4 = new EngelT3(3);
			e4.engelOn=true;
			ı.get(8).engel=e4;
			EngelT3 e3 = new EngelT3(3);
			e3.engelOn=true;
			ı.get(5).engel=e3;
			
		}
		else if(syc==3)
		{
			EngelT3 e = new EngelT3(3);
			e.engelOn=true;
			ı.get(6).engel=e;
			EngelT3 e2 = new EngelT3(3);
			e2.engelOn=true;
			ı.get(7).engel=e2;
			EngelT3 e3 = new EngelT3(3);
			e3.engelOn=true;
			ı.get(8).engel=e3;
			EngelT3 e4 = new EngelT3(3);
			e4.engelOn=true;
			ı.get(5).engel=e4;
			EngelT3 e5 = new EngelT3(3);
			e5.engelOn=true;
			ı.get(6).engel=e5;
			EngelT3 e6 = new EngelT3(3);
			e6.engelOn=true;
			ı.get(7).engel=e6;
			EngelT3 e7 = new EngelT3(3);
			e7.engelOn=true;
			ı.get(8).engel=e7;
			EngelT3 e8 = new EngelT3(3);
			e8.engelOn=true;
			ı.get(5).engel=e8;
		}
		else if(syc==4)
		{
			EngelT3 e = new EngelT3(3);
			e.engelOn=true;
			ı.get(1).engel=e;
			EngelT3 e2 = new EngelT3(3);
			e2.engelOn=true;
			ı.get(4).engel=e2;
			EngelT3 e3 = new EngelT3(3);
			e3.engelOn=true;
			ı.get(7).engel=e3;
		}
	}
}

public Image setIcon() {
	return new ImageIcon(this.getClass().getResource("/wall3.png")).getImage();
}


}
