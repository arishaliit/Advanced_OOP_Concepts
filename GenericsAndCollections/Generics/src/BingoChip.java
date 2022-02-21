public class BingoChip<V,S> {
    V var1;
    S var2;

    public BingoChip(V var1, S var2){
        this.var1 = var1;
        this.var2 = var2;
    }

    public String toString(){
        return "Chip:"+var1+"-"+var2;
    }
}

