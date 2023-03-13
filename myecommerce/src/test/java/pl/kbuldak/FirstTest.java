package pl.kbuldak;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    void myFirstTest(){
        assert true == true;
    }

    @Test
    void my2ndTest(){
        String name = "jakub";
        String hello = String.format("Hello %s", name);
        assert hello.equals("Hello jakub");
    }
    @Test
    void baseTestSchema(){
        //Arrange //Input
        //Act     //Call/Interaction
        //Assert  //Output
    }
}
