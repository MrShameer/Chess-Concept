import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

class piece{
	int code;
	Icon p;
	boolean taken;
	boolean place;
/*	int up[]=new int[8],down[]=new int[8],left[]=new int[8],right[]=new int[8];
	int dup[]=new int[8],ddown[]=new int[8],dleft[]=new int[8],dright[]=new int[8];
	int newp[]=new int[8];
	int n=0,i=0;*/
	piece(boolean taken, Icon p, int code){
		this.taken=taken;
		this.p=p;
		this.code=code;
	}

	Icon icon(){
		return p;
	}
/*
	void move(){
		for(int i=0;i<8;i++){
			newp[i]=-1;
			up[i]=-1;
			down[i]=-1;
			left[i]=-1;
			right[i]=-1;
			dup[i]=-1;
			ddown[i]=-1;
			dleft[i]=-1;
			dright[i]=-1;
		}
	}

	void rook(int b){
		move();
		i=0;
		n=b;
		while(n!=b%8){
			n=n-8;
			up[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n<64){
			n=n+8;
			down[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n>(b/8*8)){
			n=n-1;
			left[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n<(b/8*8+7)){
			n=n+1;
			right[i]=n;
			i++;
		}
	}

	void knight(int b){
		move();
		if(b<8){
			newp[4]=b+8-2;
			newp[5]=b+8*2-1;
			newp[6]=b+8*2+1;
			newp[7]=b+8+2;
			return;
		}
		if(b>55){
			newp[1]=b-8*2-1;
			newp[3]=b-8-2;
		}
		if(b%8!=0){
			newp[1]=b-8*2-1;
			newp[3]=b-8-2;
			newp[4]=b+8-2;
			newp[5]=b+8*2-1;
		}
		if(b%8!=7){
			newp[0]=b-8*2+1;
			newp[2]=b-8+2;
			newp[6]=b+8*2+1;
			newp[7]=b+8+2;
		}
		for(int i=0;i<8;i++){
			if(newp[i]>8*8 || newp[i]<0)
				newp[i]=-1;
		}
	}

	void bishop(int b){
		move();
		n=b;
		i=0;
		while(n%8!=0 && n>8){
			n=n-9;
			dup[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n%8!=7 && n>7){
			n=n-7;
			dright[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n%8!=0 && n<64){
			n=n+7;
			dleft[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n%8!=7 && n<64){
			n=n+9;
			ddown[i]=n;
			i++;
		}
	}

	void queen(int b){
		move();
		i=0;
		n=b;
		while(n!=b%8){
			n=n-8;
			up[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n<64){
			n=n+8;
			down[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n>(b/8*8)){
			n=n-1;
			left[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n<(b/8*8+7)){
			n=n+1;
			right[i]=n;
			i++;
		}

		n=b;
		i=0;
		while(n%8!=0 && n>8){
			n=n-9;
			dup[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n%8!=7 && n>7){
			n=n-7;
			dright[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n%8!=0 && n<64){
			n=n+7;
			dleft[i]=n;
			i++;
		}
		i=0;
		n=b;
		while(n%8!=7 && n<64){
			n=n+9;
			ddown[i]=n;
			i++;
		}
	}

	void king(int b){
		move();
		if(b%8!=0){
			newp[0]=b+8;
			newp[1]=b-8;
			newp[3]=b-9;
			newp[4]=b-1;
			newp[5]=b+7;
		}
		if(b%8!=7){
			newp[0]=b+8;
			newp[1]=b-8;
			newp[2]=b-7;
			newp[6]=b+1;
			newp[7]=b+9;
		}
		for(int i=0;i<8;i++){
			if(newp[i]>8*8 || newp[i]<0)
				newp[i]=-1;
		}
	}

	int mepawn(int b){
		if(b-8<8)
			return 100;
		return 1;
	}

	int opawn(int b){
		if(b+8>55)
			return 100;
		return 1;
	}
	*/
	/*piece(){
		for(int i=0;i<8*8;i++){
			taken[i]=false;
		}

		for(int i=0;i<8*2;i++){
			taken[i]=true;
			taken[8*6+i]=true;
		}
	}*/


}