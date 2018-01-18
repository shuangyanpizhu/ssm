package com.store.utils;



import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
/**
 * @author  陶林洋
 * @create 2018/1/15 10:02
 */
public class MyHttpUtils
{
    public static CloseableHttpClient createHttpClient()
    {
        CloseableHttpClient closeableHttpClient = null;
        try {
            //HttpHead httpHead = null;
            TrustStrategy trustStrategy = null;
            SSLContext sslContext = null;
            X509HostnameVerifier x509HostnameVerifier = null;
            LayeredConnectionSocketFactory sslConnectionSocketFactory = null;
            Registry<ConnectionSocketFactory> registry = null;
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;
            RequestConfig requestConfig = null;

            trustStrategy = new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] xcs, String authType) throws CertificateException {
                    return true;
                }
            };

            sslContext = SSLContexts
                    .custom()
                    .useSSL()
                    .loadTrustMaterial(null, trustStrategy)
                    .setSecureRandom(new SecureRandom())
                    .build();

            x509HostnameVerifier = new X509HostnameVerifier() {
                public void verify(String host, SSLSocket ssl) throws IOException {
                    //do nothing
                }

                public void verify(String host, X509Certificate cert) throws SSLException {
                    //do nothing                                                            //do nothing
                }

                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                    //do nothing
                }

                public boolean verify(String string, SSLSession ssls) {
                    return true;
                }
            };

            //either one works
            //LayeredConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, x509HostnameVerifier);

            registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslConnectionSocketFactory)
                    .build();

            poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);

            requestConfig = RequestConfig
                    .custom()
                    .setConnectTimeout(5000)            //5 seconds
                    .setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000)
                    .build();

            closeableHttpClient = HttpClientBuilder
                    .create()
                    .setDefaultRequestConfig(requestConfig)
                    .setSslcontext(sslContext)
                    .setHostnameVerifier(x509HostnameVerifier)
                    .setSSLSocketFactory(sslConnectionSocketFactory)
                    .setConnectionManager(poolingHttpClientConnectionManager)
                    .build();

        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {

            noSuchAlgorithmException.printStackTrace();

        } catch (KeyStoreException keyStoreException) {

            keyStoreException.printStackTrace();
        } catch (KeyManagementException keyManagementException) {
            keyManagementException.printStackTrace();

        }
        return closeableHttpClient;
    }

    /**
     * 发出http请求，但不返回任何结果
     * @param httpClient
     * @param url
     */
    public static void sendForGetNoResponse(HttpClient httpClient , String url)
    {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            httpGet.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发出http请求并返回结果
     * @param httpClient
     * @param url
     */
    public static String sendForGetAndReturnResponse(HttpClient httpClient , String url , MyHttpResponseToString responseToString)
    {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = null;
        String html = "";
        try {
            response = httpClient.execute(httpGet);
            html = responseToString.responseToString(response);
            httpGet.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }
}
