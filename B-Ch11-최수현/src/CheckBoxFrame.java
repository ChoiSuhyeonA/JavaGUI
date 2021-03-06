import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class CheckBoxFrame extends JFrame implements ItemListener{
   
   String fruits[] = {"사과", "배", "체리"};
   public int cost[] = {1000, 2000, 4000};
   String imageName[] = {
         "image/apple.png",
         "image/pear.jpg",
         "image/cherry.png"
   };
   
//   public JCheckBox cb[] = new JCheckBox[fruits.length];
   public JRadioButton cb[] = new JRadioButton[fruits.length];
   public JPanel pan = new JPanel();
   public ImageIcon image[] = new ImageIcon[fruits.length];

   public JLabel totalSum = new JLabel("합계");
   public JLabel fruitImage = new JLabel("과일 이미지");
   
   public JButton before = new JButton("Before");
   public JButton after = new JButton("After");
   
   public int sum = 0;
   public int selected = 0;
   
//   public ImageIcon image[] = {
//         new ImageIcon("image/apple.png"),
//         new ImageIcon("image/pear.jpg"),
//         new ImageIcon("image/cherry.png"),
//   };

   
   public CheckBoxFrame() {
      this.setSize(270, 200);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      ButtonGroup bg = new ButtonGroup();
      
      for(int i=0; i<fruits.length; i++) {
         image[i] = new ImageIcon(imageName[i]);
//         cb[i] = new JCheckBox(fruits[i], image[i]);
//         cb[i] = new JCheckBox(fruits[i]);
//         cb[i] = new JRadioButton(fruits[i], image[i]);
         cb[i] = new JRadioButton(fruits[i]);
         cb[i].setBorderPainted(true);
         cb[i].addItemListener(this);
         bg.add(cb[i]);
         pan.add(cb[i]);
      }
      

      
      cb[0].setSelectedIcon(new ImageIcon("image/apple_selected.jpg"));
      
      pan.add(totalSum);
      pan.add(fruitImage);
      
      pan.add(before);
      pan.add(after);
      
		before.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected --; // 이미지 번호 감소. 이전 이미지
				selected += fruits.length;	// currentId가 음수가 될 수 있기 때문에 4를 더함
				selected %= fruits.length; // 4 가 넘는 것을 막기 위해 이미지 개수로 나머지 구함
				cb[selected].setSelected(true);
				fruitImage.setIcon(image[selected]); // 이미지 레이블에 이미지 변경
				
			}
		});
		after.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected ++; // 이미지 번호 증가. 이전 이미지
				selected += fruits.length;	// currentId가 음수가 될 수 있기 때문에 4를 더함
				selected %= fruits.length; // 4 가 넘는 것을 막기 위해 이미지 개수로 나머지 구함
				cb[selected].setSelected(true);
				fruitImage.setIcon(image[selected]); // 이미지 레이블에 이미지 변경
				
			}
		});
      
      this.add(pan);
      this.setTitle("체크박스 프레임");
      this.setVisible(true);
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new CheckBoxFrame();
   }
   @Override
   public void itemStateChanged(ItemEvent e) {
      // TODO Auto-generated method stub
      if (e.getStateChange() == ItemEvent.SELECTED) {
         selected = 1;  
      }
      if(e.getStateChange() == ItemEvent.DESELECTED) {
          selected = -1;
       }         
      if(e.getItem() == cb[0]) {
         sum += selected*cost[0];
         totalSum.setText("합계 : "+ sum + "원");
         fruitImage.setIcon(image[0]);
      }
      if(e.getItem() == cb[1]) {
         sum += selected*cost[1];
         totalSum.setText("합계 : "+ sum + "원");
         fruitImage.setIcon(image[1]);
      }
      if(e.getItem() == cb[2]) {
         sum += selected*cost[2];
         totalSum.setText("합계 : "+ sum + "원");
         fruitImage.setIcon(image[2]);
      }
      
      
      
//      if (e.getItem() == cb[0]) { //사과 누른 것
//         if (e.getStateChange() == ItemEvent.SELECTED) {
//            sum += 1000;
//            totalSum.setText("합계 : "+ sum + "원");
//         }
//         if (e.getStateChange() == ItemEvent.DESELECTED) {//사과 누른것 취소 
//            sum -= 1000;
//            totalSum.setText("합계 : "+ sum + "원");
//         }
//      }
//      
//      if (e.getItem() == cb[1]) { //배 누른 것
//         if (e.getStateChange() == ItemEvent.SELECTED) {
//            sum += 2000;
//            totalSum.setText("합계 : "+ sum + "원");
//         }
//         if (e.getStateChange() == ItemEvent.DESELECTED) {//배 누른것 취소 
//            sum -= 2000;
//            totalSum.setText("합계 : "+ sum + "원");
//         }
//      }
//      
//      if (e.getItem() == cb[2]) { //체리 누른 것
//         if (e.getStateChange() == ItemEvent.SELECTED) {
//            sum += 3000;
//            totalSum.setText("합계 : "+ sum + "원");
//         }
//         if (e.getStateChange() == ItemEvent.DESELECTED) {//체리 누른것 취소 
//            sum -= 3000;
//            totalSum.setText("합계 : "+ sum + "원");
//         }
//      }
      
   }

}