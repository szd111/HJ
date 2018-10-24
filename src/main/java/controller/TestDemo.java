package controller;

import java.io.*;

public class TestDemo {
    public static void main (String args[]) throws Exception {
        //Read("src/main/resources/tree/tree1","src/main/resources/tree/tree11");
        //Read("src/main/resources/tree/test","src/main/resources/tree/tree22");
        Read("src/main/resources/tree/tree3","src/main/resources/tree/tree33");
       // Read("src/main/resources/tree/tree4","src/main/resources/tree/tree44");

    }
    public static void Read(String oldPath,String newPath) throws Exception{
        File file = new File(oldPath);
        BufferedReader br=new BufferedReader(new FileReader(file));
        System.out.println(br.readLine());
        String s=null;
        String str[],strRight[],strLeft[];
        String strNew = null;
        while((s=br.readLine())!=null){
            str=s.split("#");
            if(str[0]=="null"){
                continue;
            }
            strRight=str[0].split("\\ ");
            strLeft=str[1].split("\\ ");
            if(strRight.length>1&&strLeft.length>1) {
                strNew=strRight[1]+" "+strRight[1]+"#"+strLeft[strLeft.length-1]+" "+strLeft[strLeft.length-1];
                System.out.println(strNew);
                strNew+="\n";
                Write(newPath,strNew);
            }
        }
        br.close();
    }

    public static void Write(String path,String data) throws IOException{
        File file=new File(path);
        Writer write=new FileWriter(file,true);
        write.write(data);
        write.close();
    }
}

