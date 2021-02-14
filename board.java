import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

class board extends JFrame implements ActionListener{
	Icon kingB = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\king-B.png");
	Icon queenB = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\queen-B.png");
	Icon bishopB = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\bishop-B.png");
	Icon knightB = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\knight-B.png");
	Icon rookB = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\rook-B.png");
	Icon pawnB = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\pawn-B.png");

	Icon kingW = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\king-W.png");
	Icon queenW = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\queen-W.png");
	Icon bishopW = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\bishop-W.png");
	Icon knightW = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\knight-W.png");
	Icon rookW = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\rook-W.png");
	Icon pawnW = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\pawn-W.png");

	Icon put = new ImageIcon(System.getProperty("user.dir")+"\\PiecesIcon\\put.png");

	piece p[]=new piece[8*8];
	move m=new move();
	int select,s,c=0;
	int [] arr = new int[8*8];
	JButton w = new JButton("White");
	JButton b = new JButton("Black");
	JToggleButton box [] = new JToggleButton[8*8];
	JFrame f = new JFrame("Chess");
	JPanel board = new JPanel(new GridLayout(8,8,-1,-1));
	JPanel menu = new JPanel(new GridLayout(4,2,10,10));

	void board(){
		board.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		menu.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		int d=1;
		s=0;c=0;
		for (int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				//final JButton box = new JButton();
				box[i*8+j] = new JToggleButton();
				box[i*8+j].setBorderPainted(false);
				box[i*8+j].setFocusPainted(false);
				box[i*8+j].setEnabled(false);
				p[i*8+j]=new piece(false,null,0);
				arr[i*8+j]=-1;
				//m[i*8+j]=new move();
				if(j%2==d)
					box[i*8+j].setBackground(Color.DARK_GRAY);
				else
					box[i*8+j].setBackground(Color.LIGHT_GRAY);
				box[i*8+j].addActionListener(this);
				board.add(box[i*8+j]);
			}
			d=i%2;
		}
		f.add(board);
		f.setSize(800,600);
		f.setVisible(true);
		
	}
	void menu(){
		menu.setPreferredSize(new Dimension(200, 300));
		f.add(menu,BorderLayout.EAST);
		menu.add(w);
		menu.add(b);
		w.setBorderPainted(false);
		w.setForeground(Color.WHITE);
		w.setBackground(Color.LIGHT_GRAY);

		b.setBorderPainted(false);
		b.setForeground(Color.WHITE);
		b.setBackground(Color.DARK_GRAY);

		w.addActionListener(this);
		b.addActionListener(this);
	}

	void setup(int c){
		s=0;
		board.removeAll();
		board();
		f.repaint();
		box[c*(c-1)].setIcon(rookB);
		box[c*8-1].setIcon(rookB);
		box[c%2*8*7].setIcon(rookW);
		box[c%2*8*7+7].setIcon(rookW);

		box[c*(c-1)+1].setIcon(knightB);
		box[c*8-2].setIcon(knightB);
		box[c%2*8*7+1].setIcon(knightW);
		box[c%2*8*7+6].setIcon(knightW);

		box[c*(c-1)+2].setIcon(bishopB);
		box[c*8-3].setIcon(bishopB);
		box[c%2*8*7+2].setIcon(bishopW);
		box[c%2*8*7+5].setIcon(bishopW);

		box[(c*(c-1))+4-c%2].setIcon(queenB);
		box[(c%2*8*7)+4-c%2].setIcon(queenW);

		box[(c*(c-1))+3+c%2].setIcon(kingB);
		box[(c%2*8*7)+3+c%2].setIcon(kingW);

		p[c*(c-1)]=new piece(true,rookB,(int)(1.0/7.0*c+6.0/7.0));
		p[c*8-1]=new piece(true,rookB,(int)(1.0/7.0*c+6.0/7.0));
		p[c%2*8*7]=new piece(true,rookW,(int)(-1.0/7.0*c+15.0/7.0));
		p[c%2*8*7+7]=new piece(true,rookW,(int)(-1.0/7.0*c+15.0/7.0));

		p[c*(c-1)+1]=new piece(true,knightB,(int)(1.0/7.0*c+6.0/7.0)+2);
		p[c*8-2]=new piece(true,knightB,(int)(1.0/7.0*c+6.0/7.0)+2);
		p[c%2*8*7+1]=new piece(true,knightW,(int)(-1.0/7.0*c+15.0/7.0)+2);
		p[c%2*8*7+6]=new piece(true,knightW,(int)(-1.0/7.0*c+15.0/7.0)+2);

		p[c*(c-1)+2]=new piece(true,bishopB,(int)(1.0/7.0*c+6.0/7.0)+4);
		p[c*8-3]=new piece(true,bishopB,(int)(1.0/7.0*c+6.0/7.0)+4);
		p[c%2*8*7+2]=new piece(true,bishopW,(int)(-1.0/7.0*c+15.0/7.0)+4);
		p[c%2*8*7+5]=new piece(true,bishopW,(int)(-1.0/7.0*c+15.0/7.0)+4);

		p[(c*(c-1))+4-c%2]=new piece(true,queenB,(int)(1.0/7.0*c+6.0/7.0)+6);
		p[(c%2*8*7)+4-c%2]=new piece(true,queenW,(int)(-1.0/7.0*c+15.0/7.0)+6);

		p[(c*(c-1))+3+c%2]=new piece(true,kingB,(int)(1.0/7.0*c+6.0/7.0)+8);
		p[(c%2*8*7)+3+c%2]=new piece(true,kingW,(int)(-1.0/7.0*c+15.0/7.0)+8);

		for(int i=0;i<8;i++){
			box[(int)(40.0/7.0*c+16.0/7.0+i)].setIcon(pawnB);
			box[(int)((-40.0/7.0)*c+(376.0/7.0)+i)].setIcon(pawnW);
			p[(int)(40.0/7.0*c+16.0/7.0+i)]=new piece(true,pawnB,(int)(1.0/7.0*c+6.0/7.0)+10);
			p[(int)((-40.0/7.0)*c+(376.0/7.0)+i)]=new piece(true,pawnW,(int)(-1.0/7.0*c+15.0/7.0)+10);
		}

		for(int i=0;i<8*2;i++){
			box[i].setEnabled(true);
			box[8*6+i].setEnabled(true);
		}
	}

//	void 

	public void actionPerformed(ActionEvent e) throws NullPointerException{
		if(e.getSource()==w){
			setup(1);
		}
		if(e.getSource()==b){
			setup(8);
		}

		for(int i=0;i<8*8;i++){
			if(box[i].isSelected()&&p[i].taken){
				clear();
				select=i;
				off();
				s++;
				if(p[i].code==2||p[i].code==1){
					m.rook(i);
					move(m.up);
					move(m.right);
					move(m.left);
					move(m.down);
				}
				else if(p[i].code==12){
					m.mepawn(i);
					move(m.newp);
				}
			}
		}

		if(!box[select].isSelected()&&s>0){
			clear();
		}

		for(int i=0;i<8*8;i++){
			if(box[i].isSelected()&&p[i].place){
				System.out.print("dfsg");
				box[i].setIcon((ImageIcon)box[select].getIcon());
				box[select].setIcon(null);
				box[i].setSelected(false);
				box[select].setSelected(false);
				p[i]=p[select];
				for(int j=0;j<8*8;j++){
					if(arr[j]==i)
						arr[j]=select;
				}
				p[select]=new piece(false,null,0);
				System.out.print(p[i].place);
				clear();
			}
		}
	}

	void move(int [] a){
		for(int n : a){
			if(n!=-1&&p[n].taken==false){
				box[n].setIcon(put);
				box[n].setEnabled(true);
				p[n].place=true;
				arr[c]=n;
				c++;
			}
			else
				break;
		}
	}

	void clear(){
		for(int n : arr){
			if(n!=-1){
				box[n].setIcon(null);
				p[n].place=false;
				box[n].setEnabled(false);
			}
		}
		for(int i=0;i<8*8;i++){
			if(p[i].taken)
				box[i].setEnabled(true);
			arr[i]=-1;
		}
		c=0;
	}

	void off(){
		for(int i=0;i<8*8;i++){
			if(i!=select && !p[i].place){
				box[i].setEnabled(false);
			}
		}
	}

	/*void on(){
		for(int i=0;i<8*8;i++){
			box[i].setEnabled(false);
			if(p[i].taken)
				box[i].setEnabled(true);
		}
	}*/
}