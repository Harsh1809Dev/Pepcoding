public class Client{
    public static void main(String[] args) throws Exception{
        Stack st = new Stack();
        for(int i = 0; i < 10 ; i++)
            st.push(i * 10 + 1);
        System.out.println(st);
    }
}
