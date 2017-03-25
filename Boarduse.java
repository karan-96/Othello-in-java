import java.util.Scanner;

public class Boarduse {
	public static void game()
	{
		Scanner s=new Scanner(System.in);
		Board b=new Board();
		System.out.println("enter name of firstplayer");
		String fname=s.nextLine();
		System.out.println("enter your symbol");
		char fsymbol=s.nextLine().charAt(0);
		b.P1=new Player(fname,fsymbol);
		System.out.println("enter name of secondplayer");
		String sname=s.nextLine();
		char ssymbol=getsecondplayer(); 
		
		
		while(b.P1.symbol==ssymbol)
		{
		
			System.out.println("try other symbol");
			ssymbol=getsecondplayer();
		}
		 b.P2=new Player(sname,ssymbol);
		
		
		while(b.moveavailable(b.P1)||b.moveavailable(b.P2))
		{
			if(b.moveavailable(b.P1))
			{ 
				System.out.println(b.moveavailable(b.P1));
				System.out.println("turn :"+b.P1.name);
				Pair p=getxy();
				while(!b.checkmove(p.x, p.y, b.P1))
				{
				
					System.out.println("invalid coordinates");
					 p=getxy();
				}
				b.print();
				
			}
			if(b.moveavailable(b.P2))
			{ 
				System.out.println(b.moveavailable(b.P2));
				System.out.println("turn :"+b.P2.name);
				Pair p=getxy();
				while(!b.checkmove(p.x, p.y, b.P2))
				{
				
					System.out.println("invalid coordinates");
					 p=getxy();
				}
				b.print();
				
			}
			
		}
int countP1=0; int countP2=0;
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(b.board[i][j]==b.P1.symbol)
				{
					countP1+=1;
				}
				else if(b.board[i][j]==b.P2.symbol)
				{
					countP2+=1;
				}
				
				
				
				
			}
			
		}
		if(countP1<countP2)
		{
			System.out.println("winnner : "+b.P2.name);
		}
		else if(countP1>countP2)
		{
			System.out.println("winnner : "+b.P1.name);
		}
		else
		{
			System.out.println("draw");
			
			
		}

		
		
		
	}
	public static Pair getxy()
	{ 
		Scanner s=new Scanner(System.in);
		System.out.println("enter x coordinate");
		int x=s.nextInt();
		System.out.println("enter y coordinate");
		int y=s.nextInt();
		Pair p=new Pair();
		p.x=x;
		p.y=y;
		return p;
	}
	public static char getsecondplayer()
	{

		Scanner s=new Scanner(System.in);


		System.out.println("enter your symbol");
		char ssymbol=s.nextLine().charAt(0);
	
		return ssymbol;
	}
	/*public static Pair count(char fsymbol,char ssymbol,Board b)
	{
		
		Pair P=new Pair();
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(b.board[i][j]==fsymbol);
				{
					P.x+=1;
				}
				 if(b.board[i][j]==ssymbol);
				{
					P.y+=1;
				}
				
				
			}
			
		}
		return P;

	}*/
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game();

	}

}
