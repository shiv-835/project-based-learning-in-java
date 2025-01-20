public class CharacterCounter {
    public static void main(String[] args) {
        String s = "Hello World 42!!!!";
        int lowerCount = 0;
        int upperCount = 0;
        int spaceCount = 0;
        int numCount = 0;
        int specialCount = 0;

        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)){
                lowerCount++;
            } else if (Character.isUpperCase(ch)){
                upperCount++;
            } else if (Character.isSpaceChar(ch)){
                spaceCount++;
            } else if (Character.isDigit(ch)){
                numCount++;
            } else {
                specialCount++;
            }
        }

        System.out.println("Lowercase Characters:" + lowerCount);
        System.out.println("Uppercase Characters:" + upperCount);
        System.out.println("Spaces:" + spaceCount);
        System.out.println("Numbers:" + numCount);
        System.out.println("Special Characters:" + specialCount);
    }
}
