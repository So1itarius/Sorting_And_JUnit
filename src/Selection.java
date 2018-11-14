public class Selection implements AbstractSort {
    private static int ReadCount=0;
    static int WriteCount=0;
    static int comparison_inside_counter=0;

    @Override
    public void performSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int min_i = i;
            ReadCount++;
            for (int j = i+1; j < data.length; j++) {
                comparison_inside_counter++;
                if (data[j] < min) {
                    min = data[j];
                    min_i = j;
                    ReadCount+=2;
                }
                else {ReadCount++;}
            }
            if (i != min_i) {
                //comparison_inside_counter++;
                int tmp = data[i];
                data[i] = data[min_i];
                data[min_i] = tmp;
                ReadCount+=2;
                WriteCount+=2;
            }
        }
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
