public class Calculator {
    public DoMath toOperation(String op){
        DoMath res;
        switch (op) {
            case "+": res= (x1,x2)-> x1+x2;
                break;
            case "-": res= (x1,x2)->x1-x2;
                break;
            case "*": res= (x1,x2)->x1*x2;
                break;
            case "/": res= (x1,x2)->x2==0?Double.POSITIVE_INFINITY:x1/x2;
                break;
            default: res= (x1,x2)->Double.MIN_VALUE;
        }
        return res;
    }

    public Double compute(Double n1, Double n2, String op){
        DoMath calc = toOperation(op);
        return calc.compute(n1,n2);
    }
}
