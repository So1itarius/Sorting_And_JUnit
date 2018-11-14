public class Bubble implements AbstractSort  {
    private static int ReadCount=0;
    static int WriteCount=0;
    static int comparison_inside_counter=0;

    @Override
    public void performSort(int[] data) {
        for(int i = data.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                comparison_inside_counter++;
                if( data[j] > data[j+1] ){
                     int tmp = data[j];
                     data[j] = data[j+1];
                     data[j+1] = tmp;
                     ReadCount+=4;
                     WriteCount+=2;
                }
                else {ReadCount+=2;}
            }
        }
    }

    @Override
    public int getReadCount() {
        return ReadCount;
    }

    @Override
    public int getWriteCount() {
        //return ReadCount/2;
        return WriteCount;
    }
}
