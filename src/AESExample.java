import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESExample {

    private static final String ALGORITHM = "AES";  //알고리즘 상수 선언
    private static final String KEY = "열쇠입니다";  //키 상수 선언

    public static void main(String[] args) throws Exception {
        String originalString = "안녕하세요 평문입니다";  //암호화 할 평문 문자열 선언
        byte[] originalBytes = originalString.getBytes();   //암호화하기 전 평문 데이터를 byte 배열로 변환

        // 키 생성
        byte[] keyBytes = KEY.getBytes();   //KEY 문자열을 byte 배열로 변환한 keyBytes 생성
        SecretKeySpec secretKey = new SecretKeySpec("1234567890123456".getBytes(), "AES");  // 비밀 키 생성

        // 암호화
        Cipher cipher = Cipher.getInstance(ALGORITHM);  //암호화에 사용할 알고리즘(AES) 지정
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);    //암호화 모드로 초기화
        byte[] encryptedBytes = cipher.doFinal(originalBytes);  //암호화 수행
        String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);  //인코딩하여 변수에 저장
        System.out.println("암호화 : " + encryptedString);    //암호화 결과 콘솔에 출력

        // 복호화
        cipher.init(Cipher.DECRYPT_MODE, secretKey);    //복호화 모드로 초기화
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedString));  //디코딩 하여 복호화 수행
        String decryptedString = new String(decryptedBytes);    //복호화 결과 변수에 저장
        System.out.println("복호화 : " + decryptedString);    //복호화 결과 콘솔에 출력
    }
}
