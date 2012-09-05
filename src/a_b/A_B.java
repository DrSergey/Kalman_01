/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a_b;

//import java.swing.
//import java.awt.*;;
/**
 *
 * @author Sergy
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class A_B extends JFrame {

   private GraphPanel g;
   public A_B()
   {
      Vector<Double> d = new Vector<Double>();
      // Заполняем вектор данными - например для функции
      double t = 0;
      while(t<=2*Math.PI) {
        double s = t*t;//Math.tan(t);
        d.add(new Double(s));
        t += 0.888;
      }
      g = new GraphPanel(d);
      getContentPane().add(g);
      setBounds(1, 1, 900, 900);
   }
    /**
     * @param args the command line arguments
     */
    
  public static void main(String[] args) {
          // TODO code application logic here
      A_B t = new A_B();
      t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      t.setVisible(true);      
    }
  class GraphPanel extends JPanel
{
   private Vector<Double> data;
   public GraphPanel(Vector<Double> data)
   {
      this.data = data;
   }
        @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      // Знаем, что максимальная ширина графика - 2*PI
      // максимальная высота = 1, минимальная = -1
      // Вычисляем коэффициенты
      double Kx = getWidth()/(2*Math.PI);
      //JOptionPane.showInputDialog((int)Kx);
      double Ky = getHeight()/2.0;
      double xo = -1;
      double yo = -1;
      double x = 0;
      for(Iterator<Double> it=data.iterator(); it.hasNext(); ) {
         double y = it.next().doubleValue();
         // Рисование начинаем для второй точки
         if(xo>=0.0) {
            int x1 = (int) (xo*Kx);
            int x2 = (int) (x*Kx);
            // Учитываем, что координаты идут сверху вниз и максимальное число = 1
            int y1 = (int) (getHeight()-(yo+1)*Ky);
            int y2 = (int) (getHeight()-(y+1)*Ky);
            g.drawLine(x1, y1, x2, y2);
         }
         
         xo = x;
         yo = y;
         x += 0.1;
      }
   }
  }
}
