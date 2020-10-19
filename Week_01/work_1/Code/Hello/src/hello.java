public class hello {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int sum = a+b;
        for(int i = 0 ; i<b;i++){
            if(i == 2){
                System.out.println("i = 2");
                break;
            }else {
                System.out.println("当前i值为"+i+"  sum的值为"+sum);
            }
        }

    }
}
