import java.util.*;
class WordFindingAlg 
{
    Scanner s = new Scanner (System.in) ;
    char charr [][] ;
    String sol [][] ;
    int x[] = { -1,-1,-1, 0, 0, 1, 1, 1 } ; 
    int y[] = { -1, 0, 1,-1, 1,-1, 0, 1 } ; 
    int now = 0; 
    String words [] ; 
    int r = 0; 
    int c = 0;
    int nr=0,nc=0;
    String fw = "" ;
    int l = 0;
    int d[] ;String temp = "";
    int fx[];
    int fy[];
    void inpit()
    {
        System.out.println("Enter number of Rows.");
        r = s.nextInt();
        System.out.println("Enter number of Columns.");
        c = s.nextInt();
        
        charr = new char [r][c];
        sol = new String [r][c];
        for(int i = 0 ; i<r ; i++)
        {   System.out.println("Enter all character in row "+ (i+1) +" as a single string.");
             temp = s.next();
             temp = temp.toUpperCase();
            for(int j = 0 ; j<c ; j++)
            {
            
             charr[i][j] = temp.charAt(j); 
            }
        }
        
        System.out.println("Enter number of words you want to find.");
        now = s.nextInt();
        fx = new int [now];
        fy = new int [now];
        d  = new int [now];
        words = new String [now];
        for (int i = 0 ; i<now ; i++)
        {System.out.println("Enter word number "+ (i+1) +" to find.");
         words[i] = s.next();
         words[i] = words[i].toUpperCase();
         words[i] = words[i].replaceAll(" ","");
        }
    }
    
    
    void find()
    {        
      for(int m = 0 ; m < now ; m++)
       {
        for(int i = 0 ; i < r ; i++)
         {
          for (int j = 0 ; j < c ; j++)
           {if( charr[i][j] == words[m].charAt(0))
             {l = words[m].length();
              for (int h=1 ; h<=8 ; h++)
               {fw = "";nr=i;nc=j;
                for(int k=0 ; k<l ; k++)
                 {
                   if(nr < 0 || nc < 0 || nr >= r || nc >= c)
                   {break;}
                   if(charr[nr][nc] != words[m].charAt(k))
                   {break;}
                   fw = fw + charr [nr][nc];
                   nr += x[h-1]; nc +=y[h-1];
                 }
                if(fw.equals(words[m]))
                 {fx[m] = i ; fy[m] = j ; d[m] = h ; break;}
               }
              if(fw.equals(words[m]))
               break;
             }
           }
           if(fw.equals(words[m]))
           break;
         }
         if(fw.equals(words[m]))
           continue;
       }
    }
    
    void output()
    {
        for(int i = 0 ; i<r ; i++)
        {   for(int j = 0 ; j<c ; j++)
            { System.out.print(charr[i][j] + " ");
            }System.out.println();
        }
        
        for(int m = 0 ; m < now ; m++)
        {
         if(d[m] == 1)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written towards top left corner.");
         else if(d[m] == 2)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written upwards.");
         else if(d[m] == 3)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written towards top right corner.");
         else if(d[m] == 4)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written towards left.");
         else if(d[m] == 5)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written towards right.");
         else if(d[m] == 6)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written towards bottom left corner.");
         else if(d[m] == 7)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written downwards.");
         else if(d[m] == 8)
         System.out.println("First character of word "+ words[m] +" is on row "+ (fx[m]+1) +" and column "+ (fy[m]+1) +" and it is written towards bottom right corner.");
         else 
         System.out.println("Word "+ words[m] +" is not present in the grid.");

        }
    }
    
    void main()
    {inpit();
     find();
     output();
    }
}