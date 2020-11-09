public class VowelCount {
    public static void main(String[] args) {
        int count = getCount("abracadabra");
        System.out.println(count);
    }

    public static int getCount(String str) {
        int vowelsCount = 0;

        for(int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if(c == 'a' || c  == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowelsCount++;
            }
        }
        return vowelsCount;
    }
}
