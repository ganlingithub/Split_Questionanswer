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
        //for???????????????????????????
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='['){
                //5??????????????? answer?????????answer???id???title???type
                String[] result=new String[5];
                result[0]=cnt+"";
                sbf.setLength(0);
                /////////////////////??????answer
                //??????[
                i++;
                while(i<str.length()&&str.charAt(i)!=']'){
                    //???????????????????????????|
                    if(str.charAt(i)==','&&i>0&&str.charAt(i-1)=='}'){
                        sbf.append('|');
                    }else if(str.charAt(i)!='{'&&str.charAt(i)!='}'){
                        sbf.append(str.charAt(i));
                    }
                    i++;
                }
                //??????"],"
                i+=2;
                //??????answer???result
                result[1]=sbf.toString();
                //sbf??????
                sbf.setLength(0);
                ///////////////////////??????id
                while(i<str.length()&&str.charAt(i)!='='){
                    i++;
                }
                //??????=
                i++;
                while(i<str.length()&&str.charAt(i)!=','){
                    sbf.append(str.charAt(i));
                    i++;
                }
                //??????id???result
                result[2]=sbf.toString();
                //sbf??????
                sbf.setLength(0);
                //????????????
                i++;
                /////////////////////??????title
                while(i<str.length()&&str.charAt(i)!='='){
                    i++;
                }
                //??????=
                i++;
                while(i<str.length()&&str.charAt(i)!=','){
                    sbf.append(str.charAt(i));
                    i++;
                }
                //??????title???result
                result[3]=sbf.toString();
                //sbf??????
                sbf.setLength(0);
                //????????????
                i++;
                //////////////////??????type
                while(i<str.length()&&str.charAt(i)!='='){
                    i++;
                }
                //??????=
                i++;
                while(i<str.length()&&str.charAt(i)!='}'){
                    sbf.append(str.charAt(i));
                    i++;
                }
                //??????type???result
                result[4]=sbf.toString();
                //sbf??????
                sbf.setLength(0);
                //????????????????????????
                for(int j=0;j<5;j++){
                    ret.add(result[j]);
                    //System.out.println(result[j]);
                }
                cnt++;
            }
        }
        int len=ret.size();
        //System.out.println(len);
        //????????????????????????
        for (int i = 0; i < len; i+=5) {
            if(i+4<len){
                //6?????????????????????????????? answer?????????answer???id???title???type
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
