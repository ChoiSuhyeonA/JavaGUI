package ����;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxFrame  extends JFrame implements ItemListener
{   
   public JPanel pan = new JPanel();
   String fruits[] = { "���", "��", "ü��" };
   public JRadioButton cb[] = new JRadioButton[fruits.length];
   
   String imageName[] = { "image/apple.png", "image/pear.jpg", "image/cherry.png" };
   public ImageIcon image[] = new ImageIcon[fruits.length];
   
   public JLabel totalSum = new JLabel("�հ�");
   public JLabel fruitsImage = new JLabel("���� �̹���");
   
   public JButton before = new JButton("before");
   public JButton after = new JButton("after");

   int sum=0;
   int selected=0;
   int num=0;   
   
   public int cost[]= {1000,2000,4000};
   
   public CheckBoxFrame() 
   {
      this.setSize(270,200);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ButtonGroup bg = new ButtonGroup();
      for (int i=0; i<fruits.length; i++) 
       {
         image[i] = new ImageIcon(imageName[i]);
           cb[i] = new JRadioButton(fruits[i]);
           cb[i].setBorderPainted(true); //��ư �׵θ� ����
           cb[i].addItemListener(this); //�������� ������
           bg.add(cb[i]);
           pan.add(cb[i]);           
       }
      after.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            if(e.getSource()==after)
            {
               if(selected==0)
               {
                  selected=1;
                  cb[selected].setSelected(true);
               }
               else if(selected==1)
               {
                  selected=2;
                  cb[selected].setSelected(true);
               }
               else if(selected==2)
               {
                  selected=0;
                  cb[selected].setSelected(true);
               }
            }
         }
      });
      before.addActionListener(new ActionListener() 
      {
          @Override
         public void actionPerformed(ActionEvent e) 
         {
            if(e.getSource()==before)
            {
               if(selected==0)
               {
                  selected=2;
                  cb[selected].setSelected(true);
               }
               else if(selected==1)
               {
                  selected=0;
                  cb[selected].setSelected(true);
               }
               else if(selected==2)
               {
                  selected=1;
                  cb[selected].setSelected(true);
               }
            }
            
         }
      });
       pan.add(totalSum);
      pan.add(fruitsImage);
      pan.add(before);
      pan.add(after);
       this.add(pan);
     
       
       this.setTitle("üũ�ڽ� ������");
       this.setVisible(true);  
   }
   public static void main(String[] args)
   {
      new CheckBoxFrame();
   }

   @Override
   public void itemStateChanged(ItemEvent e) 
   {
      if(e.getStateChange()==ItemEvent.SELECTED)
      {
         num =1;
      }
      if(e.getStateChange()==ItemEvent.DESELECTED)
      {
         num=-1;
      }
      for(int i=0; i<fruits.length;i++)
      {
         if(e.getItem()==cb[i])
         {
            sum += num*cost[i];
            totalSum.setText("�հ�:"+ sum+ "��");
            fruitsImage.setIcon(image[i]);
         }
      }
   }
   
   
}