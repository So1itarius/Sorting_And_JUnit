import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class QuicksortWBTest {

    private AbstractSort Q=new Quicksort();
    private int[] data1={5,3,1,2,2,1,0};
    private int[] Expected_Output1={0,1,1,2,2,3,5};


    @BeforeEach
    void ClearCounter() {
        Quicksort.WriteCount=0;
        Quicksort.ReadCount=0;
        Quicksort.startIndex=0;
        Quicksort.endIndex=0;
    }


    @Test
    @DisplayName("╯°□°）╯")
    void performSort() {
        Q.performSort(data1);
        assertIterableEquals(asList(data1[0],data1[4],data1[6]), asList(Expected_Output1[0],Expected_Output1[4],Expected_Output1[6]));
    }

    @Test
    @DisplayName("AfterEachTest")
    void NullTest() {
        Q.performSort(data1);
        assertAll("Counters",
                () ->assertEquals(17, Quicksort.ReadCount) ,
                () ->assertEquals(1, Quicksort.endIndex)
        );
    }

    @AfterEach
    void ClearCounterAgain() {
        Quicksort.WriteCount=0;
        Quicksort.ReadCount=0;
        Quicksort.startIndex=0;
        Quicksort.endIndex=0;
    }
}