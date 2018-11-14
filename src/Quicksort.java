import java.util.Arrays;

public class Quicksort implements AbstractSort {
    static int startIndex=0;
    static int endIndex=0;
    static int ReadCount=0;
    static int WriteCount=0;

    @Override
    public void performSort(int[] data) {
        if (endIndex==0){endIndex=data.length-1;}
        if (data.length == 0 || startIndex >= endIndex)
            return;

        // выбрать опорный элемент
        int middle = startIndex + (endIndex - startIndex) / 2;
        int opora = data[middle];ReadCount++;

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = startIndex, j = endIndex;
        while (i <= j) {
            while (data[i] < opora) {
                i++;ReadCount++;
            }
            while (data[j] > opora) {
                j--;ReadCount++;
            }
            if (i <= j) {//меняем местами
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;ReadCount+=2;
                j--;WriteCount+=2;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (startIndex < j){
            endIndex=j; performSort(data);}

        if (endIndex > i){
            startIndex=i; performSort(data);}
    }

    @Override
    public int getReadCount() {
        return ReadCount;
    }

    @Override
    public int getWriteCount() {
        return  WriteCount;
    }
}
