package com.zhuopeng.desigh_model.Structural.adapter.example_JDKIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 12:41 2020/2/14 0014
 */
public class Test {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("D:/README.TXT"); // FileInputStream extends InputStream
            InputStreamReader isr = new InputStreamReader(fis);         // InputStreamReader extends Reader
            BufferedReader br = new BufferedReader(isr);                // BufferedReader extends Reader
            //从字节流到字符流
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
