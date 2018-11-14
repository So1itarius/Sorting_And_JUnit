
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainBBTest {

    @Test
    @DisplayName("ValidInput")
    void main() {
        String input1 = "11\n"+"Selection\n";
        Main.processUserInput(new Scanner(input1));

        String input2 = "5\n"+"Bubble\n";
        Main.processUserInput(new Scanner(input2));

        String input3 = "20\n"+"Quicksort\n";
        Main.processUserInput(new Scanner(input3));
    }
    @Test
    @DisplayName("Existence of methods")//Аналогично для остальных сортировок
    void Bubble(){
        AbstractSort Bub = new Bubble();
        boolean ReadCountExists = false;
        boolean WriteCountExists = false;
        boolean performSortExists = false;

        Method[] methods = Bub.getClass().getMethods();
        for (Method m : methods) {
            switch (m.getName()) {
                case "getReadCount":
                    ReadCountExists = true;
                    break;
                case "getWriteCount":
                    WriteCountExists = true;
                    break;
                case "performSort":
                    performSortExists = true;
                    break;
            }
        }
        boolean finalReadCountExists = ReadCountExists;
        boolean finalWriteCountExists = WriteCountExists;
        boolean finalPerformSortExists = performSortExists;
        assertAll("Methods",
                () ->assertTrue(finalReadCountExists) ,
                () ->assertTrue(finalWriteCountExists),
                () ->assertTrue(finalPerformSortExists)
        );

    }
    @Test
    void testCreateTempFile() throws NegativeArraySizeException {
        String input = "-1\n"+"Selection\n";
        Throwable thrown = assertThrows(NegativeArraySizeException.class, () -> Main.processUserInput(new Scanner(input)));
        assertNotNull(thrown.getMessage());
    }
}