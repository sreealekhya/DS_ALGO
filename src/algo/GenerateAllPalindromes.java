package algo;


public class GenerateAllPalindromes {

    public static void main(String[] args) {
        GenerateAllPalindromes generateAllPalindromes = new GenerateAllPalindromes();
        generateAllPalindromes.generatePalindromes(999);


    }

    void generatePalindromes(int n) {
        for(int j=0;j<2;j++) {
            int i =1;
            int num ;
            while((num = createPalindrome(i,10,j%2)) < n) {
                System.out.println(num);
                i++;
            }

        }
    }

    int createPalindrome(int input, int mod, int isOdd) {
        int palin = input;
        int n = input;

        if(isOdd == 1)
            n /= mod;

        while(n>0) {
            palin = palin*mod + (n%mod);
            n /= mod;
        }

        return palin;

    }


}
