package com.t02;

import java.io.*;

public class CopyDorF {

    public static void copyFolder(File srcFile, File destFile){

        if(srcFile.isDirectory()){

            File newFolder = new File(destFile, srcFile.getName());

            if(!newFolder.exists()){
                newFolder.mkdir();
            }

            File[] files = srcFile.listFiles();

            for(File file:files){
                copyFolder(file,newFolder);
            }
            
        }else {
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile,newFile);
        }

    }

    public static void copyFile(File srcFile, File destFile){

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))) {

            int len;

            byte[] bys =new byte[1024];

            while((len=bis.read(bys))!=-1){
                bos.write(bys,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {

        File srcFile = new File("D:\\itcast");
        File destFile = new File("F:\\");

        copyFolder(srcFile,destFile);

    }
}
