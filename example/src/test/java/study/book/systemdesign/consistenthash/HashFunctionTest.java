package study.book.systemdesign.consistenthash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashFunctionTest {

    @Test
    @DisplayName("100개 String Hash하기")
    void hashTest(){
        HashFunction hashFunction = new MD5Hash();
        for(int i=0; i < 100; i++){
            System.out.println(hashFunction.hash("data_"+i));
        }
    }

    private static class MD5Hash implements HashFunction {
        MessageDigest instance;

        public MD5Hash() {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
        }

        @Override
        public long hash(String key) {
            instance.reset();
            instance.update(key.getBytes());
            byte[] digest = instance.digest();

            long h = 0;
            for (int i = 0; i < 4; i++) {
                h <<= 8;
                h |= ((int) digest[i]) & 0xFF;
            }
            return h;
        }
    }
}
