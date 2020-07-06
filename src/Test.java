public class Test {
    public static void main(String[] args) {
        System.out.println(method("i am good"));

    }

    static public String method(String s){
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < ss.length; k++) {
            StringBuffer temp = new StringBuffer();
            if(k == ss.length-1){
                temp.append(ss[k]).reverse();
                sb.append(temp);
            }else {
                temp.append(ss[k]).reverse();
                sb.append(temp);
                sb.append(" ");
            }
        }
        return sb.reverse().toString();

    }
}
