
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BubbleWBTest {
    private AbstractSort Bub=new Bubble();
    private int[] data1={5,3,1,2,2,1,0};
    private int[] Expected_Output1={0,1,1,2,2,3,5};
    private int[] data2={-1,0,1,-1,2};
    private int[] Expected_Output2={-1,-1,0,1,2};
    private int[] data3={5,4,3,2,1,0};
    private int[] Expected_Output3={0,1,2,3,4,5};
    private int[] data4={0,1,2,3,4,5};
    private int[] Expected_Output4={0,1,2,3,4,5};



    @Before
    public void ClearCounter() {
        Bubble.comparison_inside_counter=0;
        Bubble.WriteCount=0;
    }
    @After
    public void ClearCounterAgain() {
        Bubble.comparison_inside_counter=0;
        Bubble.WriteCount=0;
    }

    @Test
    public void performSort0() {
        Bub.performSort(data1);
        assertTrue(Arrays.equals(data1, Expected_Output1));
        assertTrue(Bubble.comparison_inside_counter<=(data1.length-1)*data1.length);
        assertTrue(Bub.getWriteCount()/2<=(data1.length-1)*(data1.length/2));
    }

    @Test
    public void performSort1() {
        Bub.performSort(data2);
        assertTrue(Arrays.equals(data2, Expected_Output2));
        assertTrue(Bubble.comparison_inside_counter<=(data2.length-1)*data2.length);
        assertTrue(Bub.getWriteCount()/2<=(data2.length-1)*(data2.length/2));
    }
    @Test
    public void performSort2() {
        Bub.performSort(data3);
        //System.out.println(Bubble.comparison_inside_counter);
        assertTrue(Arrays.equals(data3, Expected_Output3));
        assertTrue(Bubble.comparison_inside_counter<=(data3.length-1)*data3.length);
        assertEquals(Bub.getWriteCount() / 2, (data3.length - 1) * (data3.length / 2));
    }
    @Test
    public void performSort3() {
        Bub.performSort(data4);
        //System.out.println(Bubble.comparison_inside_counter);
        //System.out.println(Bub.getWriteCount());
        assertTrue(Arrays.equals(data4, Expected_Output4));
        assertTrue(Bubble.comparison_inside_counter<=(data4.length-1)*data4.length);
        assertEquals(0, Bub.getWriteCount() / 2);
    }


}