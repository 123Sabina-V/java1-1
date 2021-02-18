
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
public class lab1 {
	 // Розробіть метод, який дозволяє знайти спільні елементи двох діапазонів цілих
    //чисел, та вивести їх на екран. Приклад- діапазон з 5 до 11 та діапазон з 18 до 9.
	//Спільні елементи- 9,10,11
    public static void getCommonElements(int[] arr1, int[] arr2) {
        ArrayList list = new ArrayList();// экземпляр класа ArrayList под именем  list
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);//через метод add
                }
            }
        }
        System.out.print(list);
    }
        //Створіть метод, який дозволяє видаляти всі елементи в масиві int[] , які мають певне значення,
        //наприклад дорівнюються 23. Масив без видалених елементів повинен повертатися, як результат роботи методу.
    public static void getRemove(int[] array,int deletelement)
    {
  
        int[] tmp = new int[array.length];//временный масив как тот масив который приходит в метод
        int j=0;//количество элементов котрые добавились в новый масив
        for (int i=0;i<array.length;i++) {
            if (array[i] == deletelement) {
                continue;
            }
            tmp[j] = array[i];//добавляем елемент в новый масив tmp 
            j++;//увеличиваем потому что позиция уже занята
        }
        int[] result = new int[j];
        //копируем tmp в result с нулевой позиции
      System.arraycopy(tmp, 0, result, 0, j);//копіювання елементів зліва від індексу
        
      //через библиотеку Arrays приволим все в String
      System.out.println(Arrays.toString(result));
    }
    
  //Створіть метод, який приймає параметр типу String, та шукає у його складі паліндроми
    //(рядки букв, які однаково читаються у любому напрямку - приклад  йцууцй)
    //Метод повинен повертати паліндром , який має найбільшу довжину серед знайдених,
    //якщо не знайдено ні одного, повертає пустий рядок "". Приклад при параметрі "qwertyolo"
    //результат буде "olo".
   


    public static String getLongestPalindrome( String input) {
        int rightIndex = 0, leftIndex = 0;
        String currentPalindrome = "", longestPalindrome = "";
        //выбирается индекс между первым и последним
        for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
            leftIndex= centerIndex - 1;//индекс на один меньше чем centerIndex
            rightIndex = centerIndex + 1;//индекс на один больше чем centerIndex
            while (leftIndex >= 0 && rightIndex < input.length()) {
                if (input.charAt(leftIndex) != input.charAt(rightIndex))
                {
                    break;
                }
                currentPalindrome = input.substring(leftIndex, rightIndex + 1);//рисваиваем подстроку котрая равняется символом 
                longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
                leftIndex--;//идем искать на единицу больше 
                rightIndex++;
            }
        }
        return longestPalindrome;
    }
   // Створіть метод, який дозволяє на вхід прийняти слово українською, а повернути слово в латиницу,
  //  яке приблизно звучить як українське. Наприклад - на вхід подаємо слово -= щастя = на виході отримуємо =shastia=
   
    public static String transliterate(String message){
        char[] abcCyr =   {' ','а','б','в','г','д','е','ё', 'ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц','ч', 'ш','щ','ъ','ы','ь','э', 'ю','я','А','Б','В','Г','Д','Е','Ё', 'Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х', 'Ц', 'Ч','Ш', 'Щ','Ъ','Ы','Ь','Э','Ю','Я','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
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
  //Створіть метод, який приймає параметр String у форматі "11.01.21" та повертає кількість діб з
    //початку року до цієї дати.
    // Ви повинні врахувати, що у лютому може бути різна кількість дат.
    public static int daysBetween(Date cal1,Date cal2){
        return (int)( (cal1.getTime() - cal2.getTime()) / (1000 * 60 * 60 * 24));
}
	public static void main(String[] args) {
		 // Розробіть метод, який дозволяє знайти спільні елементи двох діапазонів цілих
	    //чисел, та вивести їх на екран. Приклад- діапазон з 5 до 11 та діапазон з 18 до 9.
		//Спільні елементи- 9,10,11
      int[] arr1 = new int[]{5,6,7,8,9,10,11,};
      int[] arr2 = new int[]{9,10,35,11,12,13,14,15,16,17,18,};
      getCommonElements(arr1,arr2);
    //Створіть метод, який дозволяє видаляти всі елементи в масиві int[] , які мають певне значення,
      //наприклад дорівнюються 23. Масив без видалених елементів повинен повертатися, як результат роботи методу.
      int[] array=new int[]{4,7,11,9,2};
      int deletelement = 4;
      getRemove(array,deletelement);
      
      String str = "qwertyolo";
      String longestPali = getLongestPalindrome(str);
      System.out.println("String: " + str);
      System.out.println("Longest Palindrome: " + longestPali);
      String test1 = "Щастя";
      System.out.println("toTranslit(test) = " + transliterate(test1));
      Calendar cal1 = new GregorianCalendar();
      Calendar cal2 = new GregorianCalendar();
     cal1.set(2020, 3, 21); 
      cal2.set(2021, 1, 1);
      System.out.println("Days= "+daysBetween(cal1.getTime(),cal2.getTime()));
      
	}

}

