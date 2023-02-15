import java.util.*;
class diffDays{
    public int diferenca(String A, String B){
        int x=0,a1,b1,a2,b2,a3,b3;
        a3= 1000*Character.getNumericValue(A.charAt(6)) + 100*Character.getNumericValue(A.charAt(7)) 
        + 10*Character.getNumericValue(A.charAt(8)) + Character.getNumericValue(A.charAt(9));
        b3= 1000*Character.getNumericValue(B.charAt(6)) + 100*Character.getNumericValue(B.charAt(7)) 
        + 10*Character.getNumericValue(B.charAt(8)) + Character.getNumericValue(B.charAt(9));
        int i,j=a3;
        a2= 10*Character.getNumericValue(A.charAt(0)) + Character.getNumericValue(A.charAt(1));
        b2= 10*Character.getNumericValue(B.charAt(0)) + Character.getNumericValue(B.charAt(1));

        a1= 10*Character.getNumericValue(A.charAt(3)) + Character.getNumericValue(A.charAt(4));
        b1= 10*Character.getNumericValue(B.charAt(3)) + Character.getNumericValue(B.charAt(4));
        if(a3%4!=0){
            if(a1==1){
                a1=0;
            }
            else if(a1==2){
                a1=31;
            }
            else if(a1<=7){
                if(a1%2==1){
                    a1=(a1-a1/2-1)*31 + 28 + (a1/2-1)*30;
                }
                else{
                    a1=(a1*31)/2 + 28 + (a1/2-2)*30; 
                }
            }
            else{
                if(a1%2==0){
                    a1=((a1-7)-(a1-7)/2-1)*31 + 212 + ((a1-7)/2)*30;
                }
                else{
                    a1=((a1-7)*31)/2 + 212 + ((a1-7)/2-1)*30; 
                }
            }
        }
        else{
            if(a1==1){
                a1=0;
            }
            else if(a1==2){
                a1=31;
            }
            else if(a1<=7){
                if(a1%2==1){
                    a1=(a1-a1/2-1)*31 + 29 + (a1/2-1)*30;
                }
                else{
                    a1=(a1*31)/2 + 29 + (a1/2-2)*30; 
                }
            }
            else{
                if(a1%2==0){
                    a1=((a1-7)-(a1-7)/2-1)*31 + 213 + ((a1-7)/2)*30;
                }
                else{
                    a1=((a1-7)*31)/2 + 213 + ((a1-7)/2-1)*30; 
                }
            }
        }
        if(b3%4!=0){
            if(b1==1){
                b1=0;
            }
            else if(b1==2){
                b1=31;
            }
            else if(b1<=7){
                if(b1%2==1){
                    b1=(b1-b1/2-1)*31 + 28 + (b1/2-1)*30;
                }
                else{
                    b1=(b1*31)/2 + 28 + (b1/2-2)*30; 
                }
            }
            else{
                if(b1%2==0){
                    b1=((b1-7)-(b1-7)/2-1)*31 + 212 + ((b1-7)/2)*30;
                }
                else{
                    b1=((b1-7)*31)/2 + 212 + ((b1-7)/2-1)*30; 
                }
            }
        }
        else{
            if(b1==1){
                b1=0;
            }
            else if(b1==2){
                b1=31;
            }
            else if(b1<=7){
                if(b1%2==1){
                    b1=(b1-b1/2-1)*31 + 29 + (b1/2-1)*30;
                }
                else{
                    b1=(b1*31)/2 + 29 + (b1/2-2)*30; 
                }
            }
            else{
                if(b1%2==0){
                    b1=((b1-7)-(b1-7)/2-1)*31 + 213 + ((b1-7)/2)*30;
                }
                else{
                    b1=((b1-7)*31)/2 + 213 + ((b1-7)/2-1)*30; 
                }
            }
        }
        x=b2+b1-a2-a1;
        for(i=0;i<3;i++){
            if(j%4==0){
                x++;
                x=x+(b3-j-1)/4;
                break;
            }
            j=j++;
        }
        if(i==3){
            x=x+(b3-a3)/4;
        }
        x=x+(b3-a3)*365;
        return x;
    }
}
public class bInvest {
    public static void main(String args[] ){
        Scanner sc = new Scanner (System.in);
        String data1,data2;
        System.out.println("Insert here the first date:");
        data1=sc.nextLine();
        System.out.println("Insert here the second one:");
        data2=sc.nextLine();
        diffDays df = new diffDays();
        System.out.println(df.diferenca(data1, data2));
    }
}
