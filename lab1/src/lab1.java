
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
public class lab1 {
	 // �������� �����, ���� �������� ������ ����� �������� ���� �������� �����
    //�����, �� ������� �� �� �����. �������- ������� � 5 �� 11 �� ������� � 18 �� 9.
	//����� ��������- 9,10,11
    public static void getCommonElements(int[] arr1, int[] arr2) {
        ArrayList list = new ArrayList();// ��������� ����� ArrayList ��� ������  list
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);//����� ����� add
                }
            }
        }
        System.out.print(list);
    }
        //������� �����, ���� �������� �������� �� �������� � ����� int[] , �� ����� ����� ��������,
        //��������� ����������� 23. ����� ��� ��������� �������� ������� �����������, �� ��������� ������ ������.
    public static void getRemove(int[] array,int deletelement)
    {
  
        int[] tmp = new int[array.length];//��������� ����� ��� ��� ����� ������� �������� � �����
        int j=0;//���������� ��������� ������ ���������� � ����� �����
        for (int i=0;i<array.length;i++) {
            if (array[i] == deletelement) {
                continue;
            }
            tmp[j] = array[i];//��������� ������� � ����� ����� tmp 
            j++;//����������� ������ ��� ������� ��� ������
        }
        int[] result = new int[j];
        //�������� tmp � result � ������� �������
      System.arraycopy(tmp, 0, result, 0, j);//��������� �������� ���� �� �������
        
      //����� ���������� Arrays �������� ��� � String
      System.out.println(Arrays.toString(result));
    }
    
  //������� �����, ���� ������ �������� ���� String, �� ���� � ���� ����� ���������
    //(����� ����, �� �������� ��������� � ������ �������� - �������  ������)
    //����� ������� ��������� �������� , ���� �� �������� ������� ����� ���������,
    //���� �� �������� � ������, ������� ������ ����� "". ������� ��� �������� "qwertyolo"
    //��������� ���� "olo".
   


    public static String getLongestPalindrome( String input) {
        int rightIndex = 0, leftIndex = 0;
        String currentPalindrome = "", longestPalindrome = "";
        //���������� ������ ����� ������ � ���������
        for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
            leftIndex= centerIndex - 1;//������ �� ���� ������ ��� centerIndex
            rightIndex = centerIndex + 1;//������ �� ���� ������ ��� centerIndex
            while (leftIndex >= 0 && rightIndex < input.length()) {
                if (input.charAt(leftIndex) != input.charAt(rightIndex))
                {
                    break;
                }
                currentPalindrome = input.substring(leftIndex, rightIndex + 1);//���������� ��������� ������ ��������� �������� 
                longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
                leftIndex--;//���� ������ �� ������� ������ 
                rightIndex++;
            }
        }
        return longestPalindrome;
    }
   // ������� �����, ���� �������� �� ���� �������� ����� ����������, � ��������� ����� � ��������,
  //  ��� ��������� ������� �� ���������. ��������� - �� ���� ������ ����� -= ����� = �� ����� �������� =shastia=
   
    public static String transliterate(String message){
        char[] abcCyr =   {' ','�','�','�','�','�','�','�', '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�', '�','�', '�','�','�','�','�','�', '�','�','�','�','�','�','�','�','�', '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�', '�', '�','�', '�','�','�','�','�','�','�','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String[] abcLat = {" ","a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch", "","i", "","e","ju","ia","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            for (int x = 0; x < abcCyr.length; x++ ) {
                if (message.charAt(i) == abcCyr[x]) {
                    builder.append(abcLat[x]);
                }
            }
        }
        return builder.toString();
    }
  //������� �����, ���� ������ �������� String � ������ "11.01.21" �� ������� ������� �� �
    //������� ���� �� ���� ����.
    // �� ������ ���������, �� � ������ ���� ���� ���� ������� ���.
    public static int daysBetween(Date cal1,Date cal2){
        return (int)( (cal1.getTime() - cal2.getTime()) / (1000 * 60 * 60 * 24));
}
	public static void main(String[] args) {
		 // �������� �����, ���� �������� ������ ����� �������� ���� �������� �����
	    //�����, �� ������� �� �� �����. �������- ������� � 5 �� 11 �� ������� � 18 �� 9.
		//����� ��������- 9,10,11
      int[] arr1 = new int[]{5,6,7,8,9,10,11,};
      int[] arr2 = new int[]{9,10,35,11,12,13,14,15,16,17,18,};
      getCommonElements(arr1,arr2);
    //������� �����, ���� �������� �������� �� �������� � ����� int[] , �� ����� ����� ��������,
      //��������� ����������� 23. ����� ��� ��������� �������� ������� �����������, �� ��������� ������ ������.
      int[] array=new int[]{4,7,11,9,2};
      int deletelement = 4;
      getRemove(array,deletelement);
      
      String str = "qwertyolo";
      String longestPali = getLongestPalindrome(str);
      System.out.println("String: " + str);
      System.out.println("Longest Palindrome: " + longestPali);
      String test1 = "�����";
      System.out.println("toTranslit(test) = " + transliterate(test1));
      Calendar cal1 = new GregorianCalendar();
      Calendar cal2 = new GregorianCalendar();
     cal1.set(2020, 3, 21); 
      cal2.set(2021, 1, 1);
      System.out.println("Days= "+daysBetween(cal1.getTime(),cal2.getTime()));
      
	}

}

