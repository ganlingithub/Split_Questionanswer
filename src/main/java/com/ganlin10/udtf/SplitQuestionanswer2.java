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

public class SplitQuestionanswer2 extends GenericUDTF {
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
        fieldNames.add("col7");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col8");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col9");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col10");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col11");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col12");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col13");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col14");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col15");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col16");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("col17");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    @Override
    public void process(Object[] args) throws HiveException {
        String str = args[0].toString();
        StringBuffer sbf = new StringBuffer();
        ArrayList<String> ret=new ArrayList<>();
        int cnt=1;
        //for循环内每次解析一个
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='['){
                //4个依次保存 answer序号、answer、id、title、type
                String result[]=new String[5];
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
        //加入答案总数、 answer序号、C_name、C_id、M_columnId、M_rowName、M_columnName、M_rowId、S_score、S_name、S_id、rowidx、rowcnt、answer、id、title、type
        for (int i = 0; i < len; i+=5) {
            if(i+4<len){
                String result[]=new String[17];
                //System.out.println(ret.get(i));
                result[0]=len/5+"";
                result[1]=ret.get(i);
                result[13]=ret.get(i+1);
                result[14]=ret.get(i+2);
                result[15]=ret.get(i+3);
                result[16]=ret.get(i+4);
                if (result[16].equals("MatrixSingle")) {
                    //columnId=o-791-moNOX1, rowName=浏览购物网站, columnName=4分, rowId=o-341-LGD2gc| columnId=o-66-MeF5Y9, rowName=旅游产品购买（机票、酒店等）, columnName=2分, rowId=o-648-jJdmI0| columnId=o-66-MeF5Y9, rowName=看电视剧/电影等, columnName=2分, rowId=o-578-4cWFhc| columnId=o-570-Nhetwm, rowName=听音乐, columnName=3分, rowId=o-834-sz1qpa| columnId=o-66-MeF5Y9, rowName=打游戏, columnName=2分, rowId=o-922-U8LXPF| columnId=o-30-UVWpoY, rowName=社交聊天(非工作状态), columnName=5次-频率非常高, rowId=o-148-hXCzwl| columnId=o-791-moNOX1, rowName=新闻资讯, columnName=4分, rowId=o-718-22MEvu| columnId=o-570-Nhetwm, rowName=外卖美食, columnName=3分, rowId=o-763-rV8mXK| columnId=o-66-MeF5Y9, rowName=亲子育儿, columnName=2分, rowId=o-626-ThZwMP
                    String[] result_ = result[13].split("\\|");
                    int len1=result_.length;
                    result[2]="";
                    result[3]="";
                    result[8]="";
                    result[9]="";
                    result[10]="";
                    for (int j = 0; j < result_.length; ++j) {
                        result[11] = j+1+"";
                        result[12] = len1+"";
                        result[4] = result_[j].split(", ")[0].split("=")[1];
                        result[5] = result_[j].split(", ")[1].split("=")[1];
                        result[6] = result_[j].split(", ")[2].split("=")[1];
                        result[7] = result_[j].split(", ")[3].split("=")[1];
                        forward(result);
                    }
                } else if (result[16].equals("SingleChoice")) {//name=听说过, id=o-634-WSVrLv
                    result[2] = result[13].split(", ")[0].split("=")[1];
                    result[3] = result[13].split(", ")[1].split("=")[1];
                    result[4]="";
                    result[5]="";
                    result[6]="";
                    result[7]="";
                    result[8]="";
                    result[9]="";
                    result[10]="";
                    result[11] = "1";
                    result[12] = "1";
                    forward(result);
                } else if (result[16].equals("MultipleChoice")) {//加入answername、answerid、id、title、type
//name=IT数码专门网站（中关村在线、手机之家等）, id=o-480-J0V8VJ| name=电商平台（京东、苏宁易购等）, id=o-694-eZ1coI
                    String[] result_ = result[13].split("\\|");
                    int len1=result_.length;
                    result[4]="";
                    result[5]="";
                    result[6]="";
                    result[7]="";
                    result[8]="";
                    result[9]="";
                    result[10]="";
                    for (int j = 0; j < result_.length; ++j) {
                        result[11] = j+1+"";
                        result[12] = len1+"";
                        result[2] = result_[j].split(", ")[0].split("=")[1];
                        result[3] = result_[j].split(", ")[1].split("=")[1];
                        forward(result);
                    }
                }else if(result[16].equals("ScoreQuestion")){//{answer=[{score=4, name=, id=o-56-CebhpBRI}], id=q-176-NXBoQQYU, title=您对京东PLUS会员的整体满意度是？【打分题】, type=ScoreQuestion}
                    result[2] = "";
                    result[3] = "";
                    result[4] = "";
                    result[5] = "";
                    result[6] = "";
                    result[7] = "";
                    result[8] = result[13].split(", ")[0].split("=")[1];
                    if(result[13].split(", ")[1].split("=").length==2){
                        result[9] = result[13].split(", ")[1].split("=")[1];
                    }else{
                        result[9] ="";
                    }
                    result[10] = result[13].split(", ")[2].split("=")[1];
                    result[11] = "1";
                    result[12] = "1";
                    forward(result);
                }
            }else{
                break;
            }
        }
    }

    @Override
    public void close() throws HiveException {

    }
}
