package Algorithms;

public class AllStackPops {
    public static void orderList(Stack<String> stack,String result,String input){
        //利用对象克隆的方法，先把栈复制下来以免操作后影响下面
        Stack<String> temp=(Stack<String>)stack.clone();
        String subStr=input.substring(0,1);
        input=input.substring(1);
        temp.push(subStr);
        if(input.length()==0){
            while(!temp.isEmpty()){
                result+=temp.pop().toString();
            }
            System.out.println(result);
        }
        else{
            orderList(temp,result,input);
            while(!temp.isEmpty()){
                result+=temp.pop();
                orderList(temp,result,input);
            }
        }
    }
}
