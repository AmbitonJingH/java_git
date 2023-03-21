public class randomLetter {
    public static void main(String[] args) {
        char a;
        a = (char) ((Math.random() * 26) + 65);
        System.out.println(a);
    }
}
