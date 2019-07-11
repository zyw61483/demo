package com.example.demo.thread;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ThreadTest
 *
 * @author: zhaoyiwei
 * @date: 2019/7/11 11:45
 */
@Slf4j
public class ThreadTest {

    private String targetReg = "<img id=\"bigImg\" src=\"(.*?)\" width=\"960\" height=\"600\">";
    private String listReg = "src(s)?=\"(.*?)\"";
    private String url = "http://desk.zol.com.cn/bizhi/7601_94380_2.html";
    private ExecutorService threadPool;

    @Before
    public void before() {
        threadPool = Executors.newFixedThreadPool(5);
    }

    @Test
    public void futureTest() throws IOException, ExecutionException, InterruptedException {
        HtmlPage htmlPage = new HtmlPage(url, listReg, null);
        htmlPage.init();
        List<String> result = htmlPage.getTargetDatas();

        ArrayList<Future<Boolean>> list = Lists.newArrayList();
        for (int i = 0; i < result.size(); i++) {
            String targetData = result.get(i);
            int name = i;
            log.info("html targetData:{}", targetData);
            Future<Boolean> future = threadPool.submit(() -> {
                try {
                    HtmlPage picPage = new HtmlPage(targetData, null, null);
                    HttpEntity entity = picPage.getEntity();
                    StringBuffer content = picPage.getContent();
                    File dic = new File("/pic");
                    if(!dic.exists()){
                        dic.mkdir();
                    }
                    File file = new File("/pic/" + name + ".jpg");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream out = new FileOutputStream(file);
                    InputStream in = entity.getContent();
                    byte[] buffer = new byte[4096];
                    int readLength = 0;
                    while ((readLength = in.read(buffer)) > 0) {
                        byte[] bytes = new byte[readLength];
                        System.arraycopy(buffer, 0, bytes, 0, readLength);
                        out.write(bytes);
                    }
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    log.error("download error", e);
                    return false;
                }
                return true;
            });
            list.add(future);
        }
        Thread.sleep(5000l);

    }

    @Data
    @AllArgsConstructor
    class HtmlPage {
        private String url;
        private String reg;
        private StringBuffer content;


        public void init() throws IOException {
            HttpGet httpGet = new HttpGet(this.url);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            this.content = new StringBuffer(EntityUtils.toString(response.getEntity()));
//            log.info("html content:{}", this.content);
        }

        public HttpEntity getEntity() throws IOException {
            HttpGet httpGet = new HttpGet(this.url);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return response.getEntity();
        }

        public String getTargetData() {
            String result = "not found";
            Pattern r = Pattern.compile(this.reg);
            Matcher m = r.matcher(this.content);
            if (m.find()) {
                result = m.group(1);
            }
            return result;
        }

        public List<String> getTargetDatas() {
            List<String> result = Lists.newArrayList();
            Pattern r = Pattern.compile(this.reg);
            Matcher m = r.matcher(this.content);
            while (m.find()) {
                String url = m.group(2);
                if (url.endsWith(".jpg")) {
                    result.add(url);
                }
            }
            return result;
        }
    }

}
