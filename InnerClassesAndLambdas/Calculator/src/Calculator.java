public class Calculator {
    public DoMath toOperation(String op){
        DoMath res;
        switch (op) {
            case "+": res= /* TODO */
Use a lambda expression to set "res" to the correct function.
                break;
            case "-": r/* TODO */
Use a lambda expression to set "res" to the correct function.-x2;
                break;
            case "*/* TODO */
Use a lambda expression to set "res" to the correct function.->x1*x2;
                break;
            cas/* TODO */
Use a lambda expression to set "res" to the correct function. You must account for divisions by zero as specified in the instructions.INITY:x1/x2;
                break;
          /* TODO */
In the default value, the res function should return the minimun possible value.ouble.MIN_VALUE;
        }
        return res;
    }

    public Double compute(Double n1, Double n2, String op){
      /* TODO */
set calc to the correct function calling the method above.toOperation(op);/* TODO */
return the result of calc.compute with the numbers given..compute(n1,n2);
    }
}
