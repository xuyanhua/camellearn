package com.yanhua.camel.examples.file;

import java.io.*;

/**
 * @author xuyanhua
 * @description:
 * @date 2018/8/27 上午11:13
 */
public class FileTest {
    public static void main(String[] args) {
        File inDir = new File("./inDir");
        File outDir = new File("./outDir");

        outDir.mkdirs();
        File[] files = inDir.listFiles();
        for (File file : files) {
            if (file.canRead()) {
                String name = file.getName();
                String dist = "./outDir" + File.separator + name;
                copyFile(file, new File(dist));
            }

        }
    }

    public static void copyFile(File src, File dist) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            byte[] buffer = new byte[(int) src.length()];
            in.read(buffer);
            if (!dist.exists()) {
                dist.createNewFile();
            }
            out = new FileOutputStream(dist);
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
