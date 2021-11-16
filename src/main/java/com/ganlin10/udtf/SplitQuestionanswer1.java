package com.ganlin10.udtf;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;

public class SplitQuestionanswer1 extends GenericUDTF {
    @Override
    public StructObjectInspector initialize(ObjectInspector[] args) throws UDFArgumentException {
        if (args.length != 1) {
            throw new UDFArgumentLengthException("ExplodeMap takes only one argument");
        }
        if (args[0].getCategory() != ObjectInspector.Category.PRIMITIVE) {
            throw new UDFArgumentException("ExplodeMap takes string as a parameter");
        }

        ArrayList<String> fieldNames = new ArrayList<String>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();
        fieldNames.add("col1");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col2");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col3");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col4");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col5");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col6");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    @Override
    public void process(Object[] args) throws HiveException {
        String str = args[0].toString();
        StringBuffer sbf=new StringBuffer();
        ArrayList<String> ret=new ArrayList<>();
        int cnt=1;
        //for循环内每次解析一个
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='['){
                //5个依次保存 answer序号、answer、id、title、type
                String[] result=new String[5];
                result[0]=cnt+"";
                sbf.setLength(0);
                /////////////////////解析answer
                //跳过[
                i++;
                while(i<str.length()&&str.charAt(i)!=']'){
                    //调整多答案分隔符为|
                    if(str.charAt(i)==','&&i>0&&str.charAt(i-1)=='}'){
                        sbf.append('|');
                    }else if(str.charAt(i)!='{'&&str.charAt(i)!='}'){
                        sbf.append(str.charAt(i));
                    }
                    i++;
                }
                //跳过"],"
                i+=2;
                //加入answer到result
                result[1]=sbf.toString();
                //sbf清空
                sbf.setLength(0);
                ///////////////////////解析id
                while(i<str.length()&&str.charAt(i)!='='){
                    i++;
                }
                //跳过=
                i++;
                while(i<str.length()&&str.charAt(i)!=','){
                    sbf.append(str.charAt(i));
                    i++;
                }
                //加入id到result
                result[2]=sbf.toString();
                //sbf清空
                sbf.setLength(0);
                //跳过逗号
                i++;
                /////////////////////解析title
                while(i<str.length()&&str.charAt(i)!='='){
                    i++;
                }
                //跳过=
                i++;
                while(i<str.length()&&str.charAt(i)!=','){
                    sbf.append(str.charAt(i));
                    i++;
                }
                //加入title到result
                result[3]=sbf.toString();
                //sbf清空
                sbf.setLength(0);
                //跳过逗号
                i++;
                //////////////////解析type
                while(i<str.length()&&str.charAt(i)!='='){
                    i++;
                }
                //跳过=
                i++;
                while(i<str.length()&&str.charAt(i)!='}'){
                    sbf.append(str.charAt(i));
                    i++;
                }
                //加入type到result
                result[4]=sbf.toString();
                //sbf清空
                sbf.setLength(0);
                //加入到返回结果中
                for(int j=0;j<5;j++){
                    ret.add(result[j]);
                    //System.out.println(result[j]);
                }
                cnt++;
            }
        }
        int len=ret.size();
        //System.out.println(len);
        //增加统计答案数目
        for (int i = 0; i < len; i+=5) {
            if(i+4<len){
                //6个依次保存答案总数、 answer序号、answer、id、title、type
                String[] result=new String[6];
                //System.out.println(ret.get(i));
                result[0]=len/5+"";
                result[1]=ret.get(i);
                result[2]=ret.get(i+1);
                result[3]=ret.get(i+2);
                result[4]=ret.get(i+3);
                result[5]=ret.get(i+4);
                forward(result);
                //System.out.println("--------------");
                //for(int j=0;j<6;j++){
                //    System.out.println(result[j]);
                //}
            }else{
                break;
            }
        }
    }

    @Override
    public void close() throws HiveException {

    }
}
