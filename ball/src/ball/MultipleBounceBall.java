package ball;
import java.awt.*;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.*; 
public class MultipleBounceBall 
{
 private Frame f=new Frame("������Ϸ");
 Random rand=new Random();
 //����Ŀ����Լ��߶�
 private final int TABLE_WIDTH=300;
 private final int TABLE_HEIGHT=400;
 //���ĵĿ����Լ��߶��Լ�ˮƽλ�á���ֱλ��
 private final int RACKET_WIDTH=60;
 private final int RACKET_HEIGHT=20;
 private int racketX=rand.nextInt(24)*10;
 private int racketY=300;
 //С��Ĵ�С�������ٶȡ�����
 private final int BALL_SIZE=16;
 private int ySpeed=1;
 private double xyRate=1;
 private int xSpeed=(int)(xyRate*ySpeed);
 private int ballX=rand.nextInt(284);
 private int ballY=1;
 //��������
 private MyCanvas tableArea=new MyCanvas();
 //����ʱ����
 Timer timer;
 //��Ϸ�Ƿ���������
 private boolean isLose=false;
 //������Ϸ�ȼ�
 private int time_times=1;
 public void init(){
  tableArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
  f.add(tableArea);
  //������̼�����
  KeyAdapter keyProcessor=new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke){
    if(ke.getKeyCode()==KeyEvent.VK_LEFT){
     if(racketX>0)
      racketX-=10;
    }
    if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
     if(racketX<TABLE_WIDTH-RACKET_WIDTH)
      racketX+=10;
    }
   }
 
  };
  f.addKeyListener(keyProcessor);
  //tableArea.addKeyListener(keyProcessor);
  ActionListener taskPerformer=evt->
  {
   //С��������߿���ұ߿�
   if(ballX<=0||ballX>=TABLE_WIDTH-BALL_SIZE){
    xSpeed=-xSpeed;
   }
   if(ballY>racketY-BALL_SIZE&&(ballX<racketX||ballX>racketX+RACKET_WIDTH-BALL_SIZE)){
    timer.stop();
    isLose=true;
    tableArea.repaint();
   }else if(ballY<=0||(ballY>=racketY-BALL_SIZE&&ballX>racketX&&ballX<=racketX+RACKET_WIDTH)){
    ySpeed=-ySpeed;
   }
   ballY+=ySpeed;
   ballX+=xSpeed;
   tableArea.repaint();
   if((xSpeed<10&&xSpeed>-10)&&(ySpeed<10&&ySpeed>-10)){
    time_times++;
   }
   if(time_times==10){
    if(xSpeed>0){
     xSpeed++;
    }else{
     xSpeed--;
    }
    if(ySpeed>0){
     ySpeed++;
    }else{
     ySpeed--;
    }
    time_times-=10;
    System.out.println(xSpeed+" "+ySpeed);
   }
  };
  timer=new Timer(100,taskPerformer);
  timer.start();
  f.pack();
  f.setVisible(true);
 }
 class MyCanvas extends Canvas
 {
  public void paint(Graphics g){
   if(isLose){
    g.setColor(new Color(255,0,0));
    g.setFont(new Font("Times",Font.BOLD,30));
    g.drawString("��Ϸ����",50,200);
   }else{
    g.setColor(new Color(240,240,80));
    g.fillOval(ballX,ballY,BALL_SIZE,BALL_SIZE);
    g.setColor(new Color(80,80,200));
    g.fillRect(racketX,racketY,RACKET_WIDTH,RACKET_HEIGHT);
   }
  }
 }
 public static void main(String[] args) 
 {
  new MultipleBounceBall().init();
 }
} 