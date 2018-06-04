import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author HuaQi.Yang
 * @date 2017年7月12日
 */
public class HttpClientTest {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建httppost
        HttpGet http = new HttpGet("http://eureka.client:8750/eureka/client/hello");
        try {
            while (true) {
                long tmp = System.currentTimeMillis();
                System.out.println("执行请求");
                CloseableHttpResponse response = httpClient.execute(http);
                System.out.println(response.getStatusLine().getStatusCode());
                while (System.currentTimeMillis() - tmp <= 500) {
//					System.out.println("--");
                }
                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("请求结束");
            }
        } catch (IOException e) {
            System.out.println("异常");
            e.printStackTrace();
        }
    }
}
