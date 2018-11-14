
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int randomFill(){
        Random rand = new Random();
        return rand.nextInt();
    }
    private static int[] randomArr(int num){
        int[] arr = new int[num];
        for(int i=0;i<arr.length;i++) {
            arr[i] = randomFill();
        }
        return arr;
    }
    static void processUserInput(Scanner scanner) {
        System.out.print("Введите длину массива(целое неотрицательное число): ");
        int num = scanner.nextInt();
        System.out.print("Введите используемый Алгоритм (Bubble,Selection или Quicksort): ");
        String str = scanner.next();
        int[] arr = randomArr(num);
        //альтернативное короткое представление if-сегмента:
          /*AbstractSort a = (AbstractSort) Class.forName(str).newInstance();
          a.performSort(arr1);
          System.out.println("Чтение из массива: "+a.getReadCount());
          System.out.println("Запись в массив: "+a.getWriteCount());*/
        a: while (true) switch (str) {
            case "Bubble":
                System.out.println("Выбрана \"сортировка Пузырьком\"");
                AbstractSort Bub = new Bubble();
                Bub.performSort(arr);
                System.out.println("Количество операций:");
                System.out.println("Чтение из массива: " + Bub.getReadCount());
                System.out.println("Запись в массив: " + Bub.getWriteCount());
                break a;
            case "Selection":
                System.out.println("Выбрана \"сортировка Выбором\"");
                AbstractSort Sel = new Selection();
                Sel.performSort(arr);
                System.out.println("Количество операций:");
                System.out.println("Чтение из массива: " + Sel.getReadCount());
                System.out.println("Запись в массив: " + Sel.getWriteCount());
                break a;
            case "Quicksort":
                System.out.println("Выбрана \"Быстрая сортировка, сортировка Хоара\"");
                AbstractSort Q = new Quicksort();
                Q.performSort(arr);
                System.out.println("Количество операций:");
                System.out.println("Чтение из массива: " + Q.getReadCount());
                System.out.println("Запись в массив: " + Q.getWriteCount());
                break a;
            default:
                System.out.print("Неверный ввод, попробуйте еще раз: ");
                str = scanner.next();
        }
        //System.in.read();
    }

    public static void main(String[] args) {
        processUserInput(new Scanner(System.in));

    }
}
