package az.ingress.bankapp.service.impl;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

 //@SpringBootTest integration test ucundur
@ExtendWith(MockitoExtension.class) //unit test ucun
class CalculatorTest {


    @InjectMocks
    private Calculator calculator;

//    @Before() -> Junit 4 den gelir



     // junit 5 den
//     @BeforeEach()
//     void setup2(){
//         System.out.println("beforeEach");
//     }
    @Test
    void givenParametrsReturnSucces() {

//  arange
        int a=8;
        int b =2;
        double expect =4;
// act
        var multiple = calculator.multiple(a, b);

        Assertions.assertEquals(expect,multiple);


    }
     class Calculate{
         int cem(int a,int b){
             return a+b;
         }
         int bol(int a,int b){
             return a/b;
         }
     }

     @Test

     void aricmeticExceptionw(){
         Calculate calculate=new Calculate();
         int a=10;
         int b=0;

         //  int expected=20;

         //act

         Executable executable=()-> calculate.bol(a,b);

         Assertions.assertThrows(ArithmeticException.class,executable);

     }

     @Test

     void aricmeticException(){
         int a=10;
         int b=0;

         int expected=20;

         //act

         Executable executable=()-> calculator.multiple(12,0);

         Assertions.assertThrows(ArithmeticException.class,executable);

     }

 }