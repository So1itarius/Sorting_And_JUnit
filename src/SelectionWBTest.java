
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectionWBTest {

    private AbstractSort Sel=new Selection();
    private int[] arr;

    private static int randomFill(){
        Random rand = new Random();
        return rand.nextInt();
    }
    private static int randomLength(){
        Random rand = new Random();
        return 2+rand.nextInt(98);
    }

    @BeforeEach
    void RandCondition() {
        Selection.comparison_inside_counter=0;
        Selection.WriteCount=0;
        arr = new int[randomLength()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = randomFill();
        }
    }
    @RepeatedTest(100)
    @Test
    void performSort() {
        //System.out.println(arr.length);
        Sel.performSort(arr);
        //Assert.assertTrue(Arrays.equals(data2, Expected_Output2));
        //System.out.println(Selection.comparison_inside_counter);
        assertTrue(Selection.comparison_inside_counter<=(arr.length*arr.length)-1);
        assertTrue(Sel.getWriteCount()/2<=(arr.length-1));

    }
    @AfterEach
    void ClearCounter() {
        Selection.comparison_inside_counter=0;
        Selection.WriteCount=0;
    }

}