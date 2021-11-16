package com.ganlin10.udtf;

import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) {
        //String str = "{answer=[{name=听说过, id=o-634-WSVrLv}], id=q-864-e4LM8l, title=请问，     您是否知道5G？【单选题】, type=SingleChoice},{answer=[{name=5G网速有多快, id=o-486-mhZUzL}, {name=已上市的5G手机, id=o-478-uThViW}, {name=5G有哪些应用场景, id=o-409-lc4G8x}, {name=三大运营商11月份公布的最新5G资费情况, id=o-322-W9m2yR}], id=q-490-Ny9lgj, title=请问您     听说过/浏览过5G哪些内容【多选题】, type=MultipleChoice},{answer=[{name=云AR（增强现实）/VR（虚拟现实）, id=o-868-eaC5Ie}, {name=车联网（如自动驾驶、远控驾驶、编队行驶等）, id=o-986-9M5MRn}, {name=无线医疗（如远程诊断、远程手术、远程医疗监控等）, id=o-868-EeGsQy}, {name=智能家居, id=o-310-fCTKmL}, {name=无线家庭娱乐（如超高清的8K视频和云游戏等）, id=o-768-tz23Dt}, {name=联网无人机，用于专业巡检和安防, id=o-607-vPXW1y}, {name=智慧城市（如AI全方位视频监控）, id=o-818-DWQh2e}], id=q-602-HiRJ7s, title=以下关于     5G网络的未来应用，您知道哪些？【多选题】, type=MultipleChoice},{answer=[{name=苹果/iPhone, id=o-527-FdlYeT}], id=q-261-UBgV7N, title=您目前     最常用的手机是哪个品牌的？【单选题】, type=SingleChoice},{answer=[{name=4G手机, id=o-170-6POozt}], id=q-726-6HBqbh, title=请问     这台手机是5G手机还是4G手机呢？【单选题】, type=SingleChoice},{answer=[{name=1年~2年, id=o-749-lYjMrS}], id=q-669-STokFK, title=这部最常用的手机，您     购买多久了？【单选题】, type=SingleChoice},{answer=[{name=5000-5999元, id=o-217-pT2LNe}], id=q-266-sbA2bd, title=请问您购买该手机时的     价格是多少钱呢？【单选题】, type=SingleChoice},{answer=[{name=没感觉，不会因为5G网络和手机而刻意去更换, id=o-19-G7JNrx}], id=q-496-81OTxo, title=请问以下     哪个选项符合您对5G手机的态度？【单选题】, type=SingleChoice},{answer=[{name=1年~2年, id=o-524-hsg1NC}], id=q-633-EbuKVS, title=请问     您打算什么时候更换5G手机呢？【单选题】, type=SingleChoice},{answer=[{name=4000-4999元, id=o-354-7Z9Stt}], id=q-400-rsV73l, title=请问     您打算花多少钱购买5G手机？【单选题】, type=SingleChoice},{answer=[{name=500元以内, id=o-434-y3jt14}], id=q-395-sSRMeg, title=同等配置下，     5G手机比4G手机贵多少钱，您会     优先考虑使用5G手机？【单选题】, type=SingleChoice},{answer=[{name=1001-1250元, id=o-217-lUD0vT}], id=q-657-TL8Tqv, title=未来购买手机，     超过多少您就不考虑5G手机，而是     继续使用/购买4G手机？【单选题】, type=SingleChoice},{answer=[{name=苹果/iPhone, id=o-410-LrVBoI}], id=q-161-oIMi8w, title=您未来     最有可能购买哪个品牌的5G手机？【单选题】, type=SingleChoice},{answer=[{name=7分, id=o-705-zwGeXK}], id=q-42-M0xUCl, title=请问，当周围有     亲朋好友想要换手机时，您有多大可能性推荐这个品牌？请用0-10分打分，10分代表非常可能，0分代表肯定不可能【单选题】, type=SingleChoice},{answer=[{name=华为, id=o-490-koWnYL}], id=q-608-PS393j, title=除了您刚才选的那个品牌，     您未来还有可能选择哪个品牌的5G手机？【单选题】, type=SingleChoice},{answer=[{name=8分, id=o-752-UV5n3f}], id=q-823-2wNIU9, title=当周围有亲朋好友想要换手机时，     您有多大可能性推荐这个品牌？请用0-10分打分，10分代表非常可能，0分代表肯定不可能【单选题】, type=SingleChoice},{answer=[{name=价格保护, id=o-164-5YmRBi}, {name=手机售卖平台的5G打卡活动，每日打卡连续领奖励, id=o-319-65Swu1}], id=q-132-kI8Hnk, title=请问     哪种手机服务及产品能     吸引和增加您购买5G手机的可能性？【可多选】, type=MultipleChoice},{answer=[{name=小家电, id=o-155-QzBSQG}], id=q-976-UtpESD, title=如果     购买5G手机可以附赠一起其他产品，以下     哪种产品是您会优先考虑的？【多选题】, type=MultipleChoice},{answer=[{name=京东, id=o-677-AQQYeO}], id=q-381-dK6gmP, title=如果购买     5G手机，     您更倾向于在哪儿购买？【单选题】, type=SingleChoice},{answer=[{name=IT数码专门网站（中关村在线、手机之家等）, id=o-480-J0V8VJ}, {name=电商平台（京东、苏宁易购等）, id=o-694-eZ1coI}], id=q-621-503mRb, title=购买5G手机前，     您会通过哪些途径去了解5G手机的相关信息？【多选题】, type=MultipleChoice},{answer=[{name=中国移动, id=o-739-Qkgb9X}], id=q-912-ZI0B4Q, title=您     当前主要在用哪个运营商的手机号卡？【单选题】, type=SingleChoice},{answer=[{name=中国移动, id=o-516-WCOosJ}], id=q-399-KrC6DK, title=未来您会优先选择使用哪个运营商的5G网络？【单选题】, type=SingleChoice},{answer=[{name=50元以内, id=o-725-vQGmFh}], id=q-770-b6I6Hc, title=请问您目前     每月的话费、流量及套餐费用一共大概是多少元？如果有多个手机号，请统计总体的费用【单选题】, type=SingleChoice},{answer=[{name=有点可能, id=o-618-4vNU5q}], id=q-681-Wju8EA, title=如果     未来不换号就可以在电信、移动和联通中自由     选择其中一家的5G网络服务，您     选择其他运营商的可能性有多大？【单选题】, type=SingleChoice},{groups=[{columnId=o-517-OLO3Dc, rowName=手机是时尚饰品, columnName=5分, rowId=o-562-gxqZVJ}, {columnId=o-517-OLO3Dc, rowName=我希望手机满足基本用途，无需太多功能, columnName=5分, rowId=o-782-W07T8b}, {columnId=o-517-OLO3Dc, rowName=国产品牌的技术/性能不比国外的差, columnName=5分, rowId=o-880-Wn3qyO}, {columnId=o-517-OLO3Dc, rowName=手机是我学习/工作的帮手, columnName=5分, rowId=o-307-TgKBul}, {columnId=o-455-nqXZLN, rowName=我经常了解手机的最新专业评测, columnName=6分, rowId=o-872-US4stC}], id=q-6-prYrPz, title=下面是一些对手机的态度的描述，请问     您对每个句子的同意程度如何？请用1-7分进行打分，7分表示非常同意，1分表示非常不同意【每行单选】, type=MatrixSingle},{groups=[{columnId=o-791-moNOX1, rowName=浏览购物网站, columnName=4分, rowId=o-341-LGD2gc}, {columnId=o-66-MeF5Y9, rowName=旅游产品购买（机票、酒店等）, columnName=2分, rowId=o-648-jJdmI0}, {columnId=o-66-MeF5Y9, rowName=看电视剧/电影等, columnName=2分, rowId=o-578-4cWFhc}, {columnId=o-570-Nhetwm, rowName=听音乐, columnName=3分, rowId=o-834-sz1qpa}, {columnId=o-66-MeF5Y9, rowName=打游戏, columnName=2分, rowId=o-922-U8LXPF}, {columnId=o-30-UVWpoY, rowName=社交聊天(非工作状态), columnName=5次-频率非常高, rowId=o-148-hXCzwl}, {columnId=o-791-moNOX1, rowName=新闻资讯, columnName=4分, rowId=o-718-22MEvu}, {columnId=o-570-Nhetwm, rowName=外卖美食, columnName=3分, rowId=o-763-rV8mXK}, {columnId=o-66-MeF5Y9, rowName=亲子育儿, columnName=2分, rowId=o-626-ThZwMP}], id=q-224-ehGwGt, title=请问您日常通过手机从事如下行为的     频率如何？请用1-5分进行打分，5分表示使用频率非常高，每天多次，1分表示从来不用【每行单选】, type=MatrixSingle},{answer=[{name=男, id=o-5-PX2Dqg}], id=q-644-THo0wN, title=请问您的     性别是？【单选】, type=SingleChoice},{answer=[{name=35-39岁, id=o-839-IAwHta}], id=q-25-Bj4Lff, title=请问您的     年龄是？【单选】, type=SingleChoice},{answer=[{name=云南, id=o-84-8WXoZX}], id=q-565-MReRNa, title=请问您目前所     居住的省份是【单选】, type=SingleChoice},{answer=[{name=玉溪市, id=o-379-pfjkT0}], id=q-864-6KuBtZ, title=请问您目前居住在哪个城市？【单选】, type=SingleChoice},{answer=[{name=大学(专科及本科), id=o-202-TFVK5c}], id=q-423-pTbMcq, title=请选择您的     受教育程度【单选题】, type=SingleChoice},{answer=[{name=专业人士(如医生/ 律师/ 会计/ 建筑师/教师/ 护士/保险代理人等), id=o-852-nbzRpa}], id=q-266-ftJQc1, title=请问您的     职业是？【单选】, type=SingleChoice},{answer=[{name=5001-8000元, id=o-505-SrjNgG}], id=q-349-cM4plc, title=请问您目前的     月收入处于哪个水平？这里包括但不限于您的工资、炒股/基金、房租等各类收入【单选】, type=SingleChoice}";
        //String str="{answer=[{name=听说过, id=o-634-WSVrLv}], id=q-864-e4LM8l, title=请问，     您是否知道5G？【单选题】, type=SingleChoice}";
        //String str="{groups=[{columnId=o-517-OLO3Dc, rowName=手机是时尚饰品, columnName=5分, rowId=o-562-gxqZVJ}, {columnId=o-517-OLO3Dc, rowName=我希望手机满足基本用途，无需太多功能, columnName=5分, rowId=o-782-W07T8b}, {columnId=o-517-OLO3Dc, rowName=国产品牌的技术/性能不比国外的差, columnName=5分, rowId=o-880-Wn3qyO}, {columnId=o-517-OLO3Dc, rowName=手机是我学习/工作的帮手, columnName=5分, rowId=o-307-TgKBul}, {columnId=o-455-nqXZLN, rowName=我经常了解手机的最新专业评测, columnName=6分, rowId=o-872-US4stC}], id=q-6-prYrPz, title=下面是一些对手机的态度的描述，请问     您对每个句子的同意程度如何？请用1-7分进行打分，7分表示非常同意，1分表示非常不同意【每行单选】, type=MatrixSingle}";
        //String str="{answer=[{score=4, name=, id=o-56-CebhpBRI}], id=q-176-NXBoQQYU, title=您对京东PLUS会员的整体满意度是？【打分题】, type=ScoreQuestion},{answer=[{name=权益优惠力度大  , id=o-316-ktY93EAN}, {name=与类似产品相比，权益设计有特色, id=o-722-65YfWWtw}], id=q-845-0CQT1HsV, title=您对京东PLUS会员满意的原因是？【多选题】, type=MultipleChoice}";
        String str = "{answer=[{score=1, name=, id=o-56-CebhpBRI}], id=q-176-NXBoQQYU, title=您对京东PLUS会员的整体满意度是？【打分题】, type=ScoreQuestion},{answer=[{name=其他，请注明什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?, id=o-648-jcEaFSWa}, {name=权益使用过程不顺畅、不方便 , id=o-892-FQGNX8fL}, {name=会员产品使用体验不好（如开通/续费、会员频道页设计、省钱计算等） , id=o-99-0OyrbK56}], id=q-56-zxM5hu5h, title=您对京东PLUS会员的不满意的原因/认为待改善之处是？【多选题】, type=MultipleChoice},{answer=[{name=其他，请注明什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?, id=o-705-UA7I5ufY}, {name=对老会员不友好 , id=o-32-xjNxp9yy}], id=q-544-0NZlRJRr, title=在会员产品的使用上，您是否遇到过以下问题？【多选题】, type=MultipleChoice},{answer=[{name=生活特权（免费领吃喝玩乐福利） , id=o-973-NDG5fkgy}, {name=PLUS会员店商品 , id=o-387-b0lpLAEj}, {name=100元券礼包 / PLUS专享券 , id=o-125-e9mRTbul}, {name=服饰9折券 , id=o-792-92ikxLam}, {name=运费券（每月30元运费券） , id=o-807-zqHaqDN8}, {name=PLUS专享价 , id=o-440-McwYwG0c}], id=q-996-6iUqkrkw, title=您听说过以下哪些京东PLUS会员权益呢？【多选题】, type=MultipleChoice},{answer=[{name=免费上门退换货 , id=o-856-sOt9bZ1E}, {name=其他，请注明 什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?, id=o-270-7FdBOH0f}], id=q-439-0TGcn4l2, title=您曾经使用过以下哪些PLUS会员权益呢？【多选题】, type=MultipleChoice},{groups=[{columnId=o-752-9vTmACUH, rowName=免费上门退换货 , columnName=1-非常不满意, rowId=o-856-sOt9bZ1E}, {columnId=o-752-9vTmACUH, rowName=什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?, columnName=1-非常不满意, rowId=o-270-7FdBOH0f}], id=q-701-d3cZZYii, title=您对以下京东PLUS会员各项权益的满意度如何？请分别作答。【矩阵题】, type=MatrixSingle},{answer=[{name=其他，请注明 什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?, id=o-151-fY0JemQd}], id=q-479-50dDLdUy, title=对于PLUS会员可享受的 &quot;PLUS会员店商品&quot; 权益，您是否遇到过以下问题？ 【多选题】 , type=MultipleChoice},{answer=[{name=其他，请注明 什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?, id=o-820-AxSSQqe6}], id=q-296-FwDB6IyV, title=对于PLUS会员“免费上门退换货”权益，您是否遇到过以下问题？ 【多选题】 , type=MultipleChoice},{answer=[{name=什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?}], id=q-649-FCStWZWx, title=对于京东PLUS会员的体验，您还有什么其他反馈/建议想要告诉我们吗？【开放题】, type=InputQuestion}";
        //String str="{answer=[{name=其他，请注明什么热爱环游记什么城城，哪个我能参加？plus充值充到上限，人家都能开开心心参加活动,我呢?, id=o-648-jcEaFSWa}, {name=权益使用过程不顺畅、不方便 , id=o-892-FQGNX8fL}, {name=会员产品使用体验不好（如开通/续费、会员频道页设计、省钱计算等） , id=o-99-0OyrbK56}], id=q-56-zxM5hu5h, title=您对京东PLUS会员的不满意的原因/认为待改善之处是？【多选题】, type=MultipleChoice}";
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
                        //forward(result);
                        System.out.println("--------------");
                        for(int z=0;z<17;z++){
                            System.out.println(result[z]);
                        }
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
                    System.out.println("--------------");
                    for(int j=0;j<17;j++){
                        System.out.println(result[j]);
                    }
//forward(result);
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
                        //forward(result);
                        System.out.println("--------------");
                        for(int z=0;z<17;z++){
                            System.out.println(result[z]);
                        }
                    }
                }else if(result[16].equals("ScoreQuestion")){//{answer=[{score=4, name=, id=o-56-CebhpBRI}], id=q-176-NXBoQQYU, title=您对京东PLUS会员的整体满意度是？【打分题】, type=ScoreQuestion}
                    result[2] = "";
                    result[3] = "";
                    result[4] = "";
                    result[5] = "";
                    result[6] = "";
                    result[7] = "";
                    result[8] = result[13].split(",")[0].split("=")[1];
                    if(result[13].split(", ")[1].split("=").length==2){
                        result[9] = result[13].split(", ")[1].split("=")[1];
                    }else{
                        result[9] ="";
                    }
                    result[10] = result[13].split(", ")[2].split("=")[1];
                    result[11] = "1";
                    result[12] = "1";
                    System.out.println("--------------");
                    for(int j=0;j<17;j++){
                        System.out.println(result[j]);
                    }
                }
            }else{
                break;
            }
        }
    }
}
