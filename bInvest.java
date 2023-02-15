import java.util.*;
class diffDays1{ //This class will give me the value we are looking for.
    public int mtod(int month){ //Responsible for converting the month in the dates to an equivalent number of days.
        if(month==1){ //If it's January then we don't need to add extra days.
            month=0;
        }
        else if(month==2){ // After January you add extra days for each month before.
            month=31;
        }
        else if(month <=7){
            if(month %2==1){
                month=(month-month/2-1)*31 + 28 + (month/2-1)*30;
            }
            else{
                month=(month*31)/2 + 28 + (month/2-2)*30; 
            }
        }
        else{
            if(month%2==0){
                month=((month-7)-(month-7)/2-1)*31 + 212 + ((month-7)/2)*30;
            }
            else{
                month=((month-7)*31)/2 + 212 + ((month-7)/2-1)*30; 
            }
        }
        return month;
    }
    public int diferenca(String A, String B){ //Here we get the main value.
        int Total=0,monthA,monthB,dayA,dayB,yearA,yearB,mA,mB;
        // From lines 31 to 43 is just getting the numeric values of the dates from the strings.
        yearA= 1000*Character.getNumericValue(A.charAt(6)) + 100*Character.getNumericValue(A.charAt(7)) 
        + 10*Character.getNumericValue(A.charAt(8)) + Character.getNumericValue(A.charAt(9));

        yearB= 1000*Character.getNumericValue(B.charAt(6)) + 100*Character.getNumericValue(B.charAt(7)) 
        + 10*Character.getNumericValue(B.charAt(8)) + Character.getNumericValue(B.charAt(9));

        dayA= 10*Character.getNumericValue(A.charAt(0)) + Character.getNumericValue(A.charAt(1));

        dayB= 10*Character.getNumericValue(B.charAt(0)) + Character.getNumericValue(B.charAt(1));

        monthA= 10*Character.getNumericValue(A.charAt(3)) + Character.getNumericValue(A.charAt(4));

        monthB= 10*Character.getNumericValue(B.charAt(3)) + Character.getNumericValue(B.charAt(4));
        int j=yearA;
        mA = monthA;
        mB = monthB;
        monthA=mtod(monthA);
        monthB=mtod(monthB);
        if(yearA%4==0 && mA>2){ // This takes into account the leap year in the number of days in the month of the date.
            monthA++;
        }
        if(yearB%4==0 && mB>2){
            monthB++;
        }
        Total=dayB+monthB-dayA-monthA;
        if(yearB-yearA>2){
            while(j<3+yearA){ // Takes into account all the extra leap year days from the beggining year to the final.
                if(j%4==0){
                    Total++;
                    Total=Total+(yearB-j-1)/4;
                    break;
                }
                j++;
            }
        }
        else{
            while(j<=yearB){ // Takes into account all the extra leap year days from the beggining year to the final.
                if(j%4==0){
                    Total++;
                    break;
                }
                j++;
            }
        }           
        if(j==3+yearA || j==yearB+1){
            Total=Total+(yearB-yearA)/4;
        }
        Total=Total+(yearB-yearA)*365;
        return Total;
    }
}
public class bInvest {
    public static void main(String args[] ){
        Scanner sc = new Scanner (System.in);
        String date1,date2;
        System.out.println("Insert here the first date:");
        date1=sc.nextLine();
        System.out.println("Insert here the second one:");
        date2=sc.nextLine();
        diffDays1 df = new diffDays1();
        System.out.println(df.diferenca(date1, date2));
        sc.close();
    }
}
