
public class Board {
	char[][] board;
	Player P1;
	Player P2;
	private final static int xDir[]={0,1,1,1,0,-1,-1,-1};//{0,1,1,1,0,-1,-1,-1};
	private final static int yDir[]={1,1,0,-1,-1,-1,0,1};//{1,1,0,-1,-1,-1,0,1}
	/*{0,0,1,1,1,-1,-1,-1}
	{-1,-1,0,1,-1,0,-1,1}*/
	
	Board()
	{
		board=new char[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				board[i][j]='x';
				
			}
		}
		board[1][1]='w';
		board[1][2]='b';
		board[2][1]='b';
		board[2][2]='w';
	}
	public boolean checkmove(int x,int y,Player p)
	{
		if(x<0||x>3||y<0||y>3||board[x][y]!='x')
		{
			return false;
		}
		boolean flag=false;
		for(int i=0;i<xDir.length;i++)
		{
			int StepX=xDir[i];
			int StepY=yDir[i];
			int currentX=x+StepX;
			int currentY=y+StepY;
			int count=0;
			while(currentX>=0&&currentX<4&&currentY>=0&&currentY<4)
			{
				if(board[currentX][currentY]=='x')
				{
					break;
				}
				else if(board[currentX][currentY]!=p.symbol)
				{
					count++;
					currentX+=StepX;
					currentY+=StepY;
				}
				else
				{
					if(count==0)
					{
						break;
					}
					else
					{
						for(int j=0;j<=count;j++)
						{
							flag=true;
							
							currentX-=StepX;
							currentY-=StepY;
							board[currentX][currentY]=p.symbol;
						}
						break;
					}
					
				}
			}
		}
		return flag;
		

}
	public boolean checkmove1(int x,int y,Player p)
	{
		if(x<0||x>3||y<0||y>3||board[x][y]!='x')
		{
			return false;
		}
		
		for(int i=0;i<xDir.length;i++)
		{
			int StepX=xDir[i];
			int StepY=yDir[i];
			int currentX=x+StepX;
			int currentY=y+StepY;
			int count=0;
			while(currentX>=0&&currentX<4&&currentY>=0&&currentY<4)
			{
				if(board[currentX][currentY]=='x')
				{
					break;
				}
				else if(board[currentX][currentY]!=p.symbol)
				{
					count++;
					currentX+=StepX;
					currentY+=StepY;
				}
				else
				{
					if(count==0)
					{
						break;
					}
					else
					{
						return true;
					}
					
				}
			}
		}
		return false;
		

}
	public boolean moveavailable(Player P) {

boolean flag=false;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
					flag=checkmove1(i, j, P);
					
						if(flag==true)
						{
							return true;
						}
			
			}
		}
		return false;
	}


	/*public boolean isempty() {

		 
		 
		 for(int i=0;i<4;i++)
		 {
			 for(int j=0;j<4;j++)
			 {
			 if(board[i][j]=='x')
			 {
				return true;
			 }
			 }
		 }
		 
		return false;

		
	}*/
	public  void count(Player P1,Player P2)
	{
		
		Pair P=new Pair();
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(board[i][j]==P1.symbol);
				{
					P.x+=1;
				}
				 if(board[i][j]==P2.symbol);
				{
					P.y+=1;
				}
				
				
			}
			
		}
		if(P.x<P.y)
		{
			System.out.println("winnner : "+P2.name);
		}
		else if(P.x>P.y)
		{
			System.out.println("winnner : "+P1.name);
		}
		else
		{
			System.out.println("draw");
			
			
		}

	}
	
	public void print() {
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(board[i][j]);
				
			}
			System.out.println();
		}
		
	}
	
}

