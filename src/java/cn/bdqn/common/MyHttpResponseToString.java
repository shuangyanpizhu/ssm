package cn.bdqn.common;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 陶林洋
 * @create 2017/11/23 21:27
 */
public class MyHttpResponseToString
{
    public String charset;

    public MyHttpResponseToString(String charset)
    {
        this.charset = charset;
    }

    public String responseToString(HttpResponse response) throws IOException {
        return EntityUtils.toString(response.getEntity() , this.charset);
    }

}

