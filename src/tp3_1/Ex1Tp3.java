package tp3_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import javax.swing.border.Border;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.event.*;

public class Ex1Tp3 {
	public static void main(String[] args) { 

		 EventQueue.invokeLater(new Runnable() { 
			public void run() { 
				Ex1  f = new Ex1 ("Ex1");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(610,650);
				f.setVisible(true);  
			}
		 }); 
		}
}

class Ex1 extends JFrame{
	
	int x,y,x1,y1,x2,y2;	
	
	private JLabel l1,l2,l3,l4;
	private JPanel p,rp;
	private Pan jp;
	Border raisedbevel, loweredbevel, compound;
	private Image fond;
	private Image []im=new Image[10];
	
	private int pos1,pos2,numclic=0;
	
	public int[] ordre={10,9,1,2,4,2,7,6,5,10,3,3,8,9,1,8,6,5,4,7};
	
	private boolean[] trouve={false,false,false,false,false,false,false,false,false,false,
	false,false,false,false,false,false,false,false,false,false};
	
	private int nbcoupdcv=0,nbcoup=0;
	
	
	GridBagConstraints gbc= new GridBagConstraints();
	
	public boolean kiemtra(int so,int[]tmp) {
		boolean a=false;
		for(int i=0;i<tmp.length;i++) {
			if(tmp[i]==so)a=true;
		}
		return a;
	}
	
	public Ex1(String titre) {
		super(titre);
		
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound = BorderFactory.createCompoundBorder(raisedbevel,loweredbevel);
		
		jp=new Pan();
		jp.setSize(605,485);
		jp.repaint();
		add(jp);
		
		PanDraw jpd=new PanDraw();
		jpd.setSize(605,485);
		jpd.addMouseListener( new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				x=e.getX();
				y=e.getY();
				if(!trouve[x/120+y/120*5]) {
					numclic+=1;
					jpd.repaint();
				}
				}
				});
		add(jpd);
		
		p=new JPanel(new GridBagLayout());		
		
		l1=new JLabel("Nombre de coups:                         ");
		
		JPanel pl2=new JPanel();
		pl2.setPreferredSize(new Dimension(34,34));;
		l2=new JLabel("0");
		pl2.add(l2);
		
		l3=new JLabel("Nombre de paires découvertes:");
		
		JPanel pl4=new JPanel();
		pl4.setPreferredSize(new Dimension(34,34));;
		l4=new JLabel("0");
		pl4.add(l4);
		
		l1.setBorder(compound);
		pl2.setBorder(compound);
		l3.setBorder(compound);
		pl4.setBorder(compound);
		
		pl2.setBackground(Color.blue);
		pl4.setBackground(Color.blue);
		
		l1.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l2.setForeground(Color.white);
		l4.setForeground(Color.white);
		
		gbc.insets = new Insets(0,0,20,15);
		gbc.ipady=10;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth= 1;
		p.add(l1,gbc);
		
		gbc.ipady=0;
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		p.add(pl2,gbc);
		
		gbc.ipady=10;
		gbc.gridwidth= 1;
		p.add(l3,gbc);
		
		gbc.ipady=0;
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		p.add(pl4,gbc);
		
		
		add(p,BorderLayout.SOUTH);
	}
	
	class Pan extends JPanel{
		Pan() {
			try{
				fond = ImageIO.read(new File("fond.png"));
				im[0]=ImageIO.read(new File("im1.png"));
				im[1]=ImageIO.read(new File("im2.png"));
				im[2]=ImageIO.read(new File("im3.png"));
				im[3]=ImageIO.read(new File("im4.png"));
				im[4]=ImageIO.read(new File("im5.png"));
				im[5]=ImageIO.read(new File("im6.png"));
				im[6]=ImageIO.read(new File("im7.png"));
				im[7]=ImageIO.read(new File("im8.png"));
				im[8]=ImageIO.read(new File("im9.png"));
				im[9]=ImageIO.read(new File("im10.png"));
			} 
			catch(Exception e){};
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i=0;i<4;i++) {
				for(int j=0;j<5;j++) {
					g.drawImage(fond, j*120,i*120,this);
				}
			}
		}
	}
	
	class PanDraw extends JPanel{
		public void paintComponent(Graphics g) {
			int xnorme=x/120;
			int ynorme=y/120;
			if(numclic==1){
				if(!trouve[xnorme+ynorme*5]) {
					g.drawImage(im[ordre[xnorme+ynorme*5]-1],xnorme*120,ynorme*120,this);
					pos1=ordre[xnorme+ynorme*5]-1;
					x1=xnorme;
					y1=ynorme;
					trouve[x1+y1*5]=true;
				}
				else numclic-=1;
			}
			if(numclic==2){
				if(!trouve[xnorme+ynorme*5]) {
				g.drawImage(im[ordre[xnorme+ynorme*5]-1],xnorme*120,ynorme*120,this);
				pos2=ordre[xnorme+ynorme*5]-1;
				x2=xnorme;
				y2=ynorme;
				trouve[x2+y2*5]=true;
				if(pos1==pos2) {
					nbcoupdcv+=1;
					l4.setText(""+nbcoupdcv);
				}
				nbcoup+=1;
				l2.setText(""+nbcoup);
				}
				else numclic-=1;
				
				if(nbcoupdcv==10) {
					fini();
				}
			}
			
			if (numclic==3) {
				if(pos1!=pos2) {
					trouve[x1+y1*5]=false;
					trouve[x2+y2*5]=false;
					g.drawImage(fond,x1*120,y1*120,this);
					g.drawImage(fond,x2*120,y2*120,this);
					if(!trouve[xnorme+ynorme*5]) {
					g.drawImage(im[ordre[xnorme+ynorme*5]-1],xnorme*120,ynorme*120,this);
					pos1=ordre[xnorme+ynorme*5]-1;
					x1=xnorme;
					y1=ynorme;
					trouve[x1+y1*5]=true;
					numclic=1;
					}
					else numclic-=1;
				}
				else {
					if(!trouve[xnorme+ynorme*5]) {
					g.drawImage(im[ordre[xnorme+ynorme*5]-1],xnorme*120,ynorme*120,this);
					pos1=ordre[xnorme+ynorme*5]-1;
					x1=xnorme;
					y1=ynorme;
					trouve[x1+y1*5]=true;
					numclic=1;
					}
					else numclic-=1;
				}
			}
		}
	}
	
	public void fini() {
		remove(p);
		
		rp=new JPanel(new GridBagLayout());
		JLabel rplb=new JLabel("Vous avez gagné en "+nbcoup+" coups. Voulez-vous rejouer?   ");
		rplb.setForeground(Color.blue);
		rplb.setBorder(compound);
		
		JButton btoui=new JButton("Oui ");
		
		btoui.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				EventQueue.invokeLater(new Runnable() { 
					public void run() { 
						Ex1  f = new Ex1 ("Ex1");
						
						int[]ordre2=new int[20];
						
						Random rd = new Random();
						Vector v = new Vector();
				        int iNew = 0;
				        for (int i = 0; i < 20;  ) {
				            iNew = rd.nextInt(20);
				            if (!v.contains(iNew)){
				                i++;
				                v.add(iNew);
				                ordre2[i-1]=ordre[iNew];
				            }
				        }
				                
						f.ordre=ordre2;
						f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f.setSize(610,650);
						f.setVisible(true);  
					}
				 }); 
			}
		});
		
		
		JButton btnon=new JButton("Non");
		btnon.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		
		gbc.ipady=40;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy=1;
		gbc.ipadx=10;
		gbc.gridheight=3;
		gbc.gridwidth=1;
		rp.add(rplb,gbc);
		
		gbc.ipady=0;
		gbc.ipadx=50;
		gbc.gridy=1;
		gbc.gridheight=1;
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		rp.add(btoui,gbc);
		
		gbc.gridy=3;
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		rp.add(btnon,gbc);
		
		
		add(rp,BorderLayout.SOUTH);
		validate();
		repaint();
	}
}
