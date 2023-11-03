import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EngelT1 extends Engel{
    
	EngelT1()	
	{
		super();
	}
	EngelT1(Integer tip)	
	{
		super(tip);
	}
  public void model(ArrayList<Izgara> list)
  {
	  
	 for(Izgara ı : list)
	 {
		 EngelT1 e=new EngelT1(1);
		 e.engelOn=true;
		 ı.engel=e;
	 }
	  
  }
 public Image setIcon()
 {
	 return new ImageIcon(this.getClass().getResource("/wall1.png")).getImage();
 }
}
