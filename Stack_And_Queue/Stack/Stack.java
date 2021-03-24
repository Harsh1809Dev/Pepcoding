public class Stack{
    protected int[] arr = null;
    protected int capacity = 0;
    protected int size = 0;
    protected int tos = -1;

    Stack(){
        initialize_variables(10);
    }

    Stack(int n){
        initialize_variables(n);
    }

    protected void initialize_variables(int capacity){
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.tos = -1;
    }

    public int size_(){
        return this.size;
    }

    public boolean is_empty(){
        return tos == -1;
    }

    //exceptions=========================================================
    private void over_flow_exception() throws Exception{
        if(this.capacity == this.size)
            throw new Exception("Stack Already Full");
    }

    private void under_flow_exception() throws Exception{
        if(this.tos == -1){
            throw new Exception("Stack Already Empty");
        }
    }

    //to_string==========================================================
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.arr[i]);
            if (i != this.size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    //basic_functions====================================================
    protected void push_(int data){
        arr[++tos] = data;
        this.size ++;
    }

    public void push(int data) throws Exception{
        over_flow_exception();
        push_(data);
    }

    public int pop() throws Exception{
        under_flow_exception();
        return pop_();
    }

    protected int pop_(){
        int ele = arr[tos];
        arr[tos--] = 0;
        this.size--;
        return ele;
    }

    public int peek() throws Exception{
        under_flow_exception();
        return peek_();
    }

    protected int peek_(){
        return arr[tos];
    }
}