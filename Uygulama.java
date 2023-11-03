import javax.swing.JLabel;

public class Uygulama {
public  static Integer adım=0;
public static double süre=0;
public static void step()
{
	adım++;
}
public void update(JLabel l)
{
	l.setText(Integer.toString(adım));
}
public void update(JLabel l,Integer adım)
{
	l.setText(Integer.toString(adım));
}
public void gecenSure(long start,long end,JLabel l)
{
    double total=(double)(end-start);
	System.out.println("total:"+total);
	Double sn =total/1000;
	süre=sn;
	System.out.println("sn:"+sn);
	l.setText(Double.toString(sn));	
}
public void res(JLabel l)
{
	l.setText("0");	
}	
public void res( )
{
	adım=0;
}
}
