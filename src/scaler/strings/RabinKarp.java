package scaler.strings;

public class RabinKarp {
    public static void main(String[] args) {
        int p = 10;
        int mod = (int)(1e9+7);
        String str = "abcababac";
        String pattern = "aba";
        int patternLen = pattern.length();
        long[] powerof29 = new long[pattern.length()];
        powerof29[0] = 1;
        for(int i =1 ; i < powerof29.length ;i ++)
        {
            powerof29[i] = ((p * powerof29[i-1]) % mod);
        }

        long hash = 0L;
        long windowHash = 0L;
        for(int i = pattern.length() - 1 ; i >= 0 ; i--)
        {
           int ascii = pattern.charAt(i) - 'a' + 1;
           long powerRaised = powerof29[patternLen - 1 - i];
           hash += ((ascii * powerRaised) % mod);

           ascii = str.charAt(i) - 'a' + 1;
           windowHash += ((ascii * powerRaised) % mod);
        }

        System.out.println(hash);
        System.out.println(windowHash);

        int count = 0;
        if(hash == windowHash) count++;
        for(int i =  patternLen ; i < str.length() ; i++)
        {
            int ascii = str.charAt(i - patternLen) - 'a' + 1;
            long powerRaised = powerof29[patternLen - 1];
            windowHash -= ((ascii  * powerRaised) % mod);

            windowHash = ( windowHash * p ) % mod;
            ascii = str.charAt(i) - 'a' + 1;
            windowHash += ascii;
            if(windowHash == hash)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
