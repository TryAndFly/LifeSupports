package com.example.lifesupport.Information;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lifesupport.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Information> arrayList = new ArrayList();
    private ListView listView;
    private Information information;
    private InfoSQLite infoSQLite;
    public SQLiteDatabase helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_layout);
        listView = (ListView)findViewById(R.id.InfoListView);
        infoSQLite = new InfoSQLite(this);
        helper = infoSQLite.getReadableDatabase();

        setAdapters(1);

//       initArrayList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //查看详细信息
                Intent intent = new Intent(MainActivity.this,InformationActivity.class);
                intent.putExtra("extra_data",arrayList.get(i).getId()+"");
                startActivity(intent);
            }
        });
    }
    public void change(View view){
        switch (view.getId()){
            case R.id.type1:
                setAdapters(1);
                break;
            case R.id.type2:
                setAdapters(2);
                break;
            case R.id.type3:
                setAdapters(3);
                break;
            case R.id.type4:
                setAdapters(4);
                break;
            case R.id.type5:
                setAdapters(5);
                break;
            default:
                break;
        }
    }
    //初始化
    public void initArrayList(){
        ContentValues contentValues = new ContentValues();
        contentValues.put("imageId",R.drawable.tou1);
        contentValues.put("title","FIFA排名：国足跌至亚洲第10 12强赛对手包揽亚洲前3");
        contentValues.put("text","北京时间7月14日，FIFA官网更新了最新一期的国家队排名。国足的世界排名仍然停留在第81位，但亚洲排名已经被12强赛的同组对手卡塔尔超越，\n" +
                "        滑落至亚洲第10，亚洲前3球队被伊朗、韩国和乌兹别克斯坦包揽，这3支球队都是国足12强赛的同组对手。\n" +
                "        本计分时段，中国国家队进行了2场国际A级比赛，分别是6月3日在秦皇岛4-2击败特立尼达和多巴哥，另一场比赛在大连则是0-1小负哈萨克斯坦\n" +
                "        。经过一系列复杂公式计算后，国足的积分为422分，比上一期少了1分。\n" +
                "世界排名，国足继续排在第81位，这是国足连续4期在这一排名上停留。\n" +
                "        但亚洲排名却由上一期的第9滑落至第10，超越国足的恰恰是12强赛的同组对手卡塔尔，卡塔尔本期的世界排名上升了5位，来到第79位。\n" +
                "\n" +
                "        亚洲球队中，伊朗的世界排名仍位列第39位，与上期持平，亚洲继续高居第1，韩国的世界排名提升2位，由第50位升至第48位，亚洲方面继续稳居第2把交椅。\n" +
                "        乌兹别克斯坦的世界排名大涨10位，从第66位升至第56位，取代日本成为新的亚洲第3，日本的世界排名掉至第57，亚洲排名下降至第4。\n" +
                "\n" +
                "        其他亚洲球队，澳大利亚世界排名第59（亚洲第5）、沙特世界排名第65（亚洲第6）、阿联酋世界排名第74（亚洲第7）、约旦世界排名第78（亚洲第8）。\n" +
                "        伊拉克世界排名第99（亚洲第11）、叙利亚世界排名第104（亚洲第12）。在12强赛同组对手中，国足的排名仅高过叙利亚。\n");
        contentValues.put("type",1);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tou2);
        contentValues.put("title","这个机构，总会在大是大非时站出来 ");
        contentValues.put("text","继中国外交部和中国政府相继对南海非法仲裁庭的“裁决”发表声明后，\n" +
                "         7月14日，全国人大外事委员会也发布了一份声明，表明全国人大外事委对于这一事件的态度。\n" +
                "\n" +
                "         政知圈（微信ID：wepolitics）发现，让中国政府和全国人大外事委都站出来发表声明的事件可并不算多。据政知圈（微信ID：wepolitics）不完全统计，从上世纪80年代末到现在，\n" +
                "         全国人大外事委至少发布过9次声明，都是在大是大非的时刻。\n" +
                "一条小鱼干也不能少\n" +
                "全国人大外事委的声明中首先表态，委员会坚定支持外交部和中国政府的声明立场。\n" +
                "“中国对南海诸岛，包括东沙群岛、西沙群岛、中沙群岛、南沙群岛拥有主权。中国南海诸岛拥有内水、领海、毗连区、专属经济区和大陆架。\n" +
                "中国在南海拥有历史性权利。任何国家、组织和机构都无权否定中国在南海的领土主权和海洋权益。”\n" +
                "\n" +
                "换句现在流行的话说，南海自古以来就是中国的，如今也是，里面的海带和小鱼干一条也不能少。\n" +
                "\n" +
                "声明总结称，应菲律宾单方面请求建立的南海仲裁案仲裁庭，对有关事项不具有管辖权。\n" +
                "其无视南海的历史和基本事实，曲解和滥用《公约》赋予的权力，自行扩权、越权并对案件实体问题进行审理，\n" +
                "违反包括《公约》在内的国际法和国际仲裁的一般法理，所作的裁决是无效的。中国不承认仲裁庭的裁决。\n" +
                "大是大非之时\n" +
                "政知圈（微信ID：wepolitics）前面说过，\n" +
                "能让全国人大外事委发表声明的事情并不太多。其中大多涉及中国国家利益，且矛头直指日本和美国。\n" +
                "\n" +
                "在此之前，最近一次发表声明是在2013年，全国人大外事委就日本众议院通过决议要求我撤销东海防空识别区事发表声明。\n" +
                "2012年9月11日，外事委员会就日本政府宣布“购买”钓鱼岛及其部分附属岛屿发表声明。");
        contentValues.put("type",1);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tou3);
        contentValues.put("title","被误读的蒙古国，未来可能是另一个富庶的中东！");
        contentValues.put("text","从北京到乌兰巴托，1400余公里。随着13日\n" +
                "李克强总理开启对蒙古国的正式访问，中国领导人的外访也调成了“蒙古国时间”。\n" +
                "此访意义“不一般”，这是克强总理今年首访，也是任内首次访问蒙古国。\n" +
                "\n" +
                "当谈起蒙古国时我们能谈些什么，大多数人恐怕还是会说草原、骏马、蒙古包，最多还有那首KTV经典曲目《乌兰巴托的夜》和那段中世纪的历史。\n" +
                "除此之外，贫困、封闭、不发达，却是当下蒙古国的代名词。一直以来对于中国，蒙古国就像一个“熟悉的陌生人”存在。\n" +
                "事实上，对于这个近邻中的近邻，我们实在了解得太少。\n" +
                "总理的出访，也让这个国家短时间内有了不小热度。\n" +
                "政知道（微信ID：upolitics)专门采访了前驻蒙古国大使高树茂，听听这位老大使怎么说中国人对蒙古国那些“常识性”的误解\n" +
                "。\n" +
                "误解一：蒙古国穷得一塌糊涂！\n" +
                "——人均GDP并不低，只是贫富差距大，资源堪比中东\n" +
                "蒙古到底穷不穷，先看看下面的一些数据。\n" +
                "\n" +
                "以1991年颁布《财产私有化法》开始，蒙古经历了以政治自由化、经济私有化为主要特征的过渡阶段，\n" +
                "据估计，前苏联解体后的四年里，蒙古的人均国民收入至少倒退了15年。此后一直到2009年，近20年间，蒙古国经济都处于调整期，以应对这一重创。\n" +
                "说起来，蒙古国的经济支柱并非是农牧业，而是采矿。而蒙古国的矿产又有三宝，\n" +
                "分别是媒、铜和金。数据显示，采矿业对于蒙古国GDP的贡献率一直都在30%以上。\n" +
                "正是这一原因，蒙古国也迎来了经济奇迹。2011年蒙古国GDP同比增长17.3%。不过，近几年蒙古国经济增长放缓，2014GDP增速为7.8%。");
        contentValues.put("type",1);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tou4);
        contentValues.put("title","专家反对缩短中小学学制：不符合规律，作家莫言“无知无畏”");
        contentValues.put("text","7月13日下午，21世纪教育研究院在京召开“基础教育学制改革研讨会”，与会教育专家一致对作家莫言提出的“缩短基础教育学制”表示反对\n" +
                "。他们承认莫言做过调研，但认为其观点缺乏理论支撑与科学依据。\n" +
                "与会专家认为，基础教育学制12年，这是世界通行的基础教育学制，是培育一个孩子身心成熟的必要时间，世界上没有一个国家提出基础教育学制要缩短。\n" +
                "学制长短并不是最重要的，更重要的是如何划分学段、如何衔接各学段。\n" +
                "“莫言无知无畏敢说，不懂教育”\n" +
                "关于12学制的质疑一直存在。今年两会期间，著名作家、诺贝尔文学奖得主莫言曾建议“将12年学制改成10年一贯制”。\n" +
                "他的建议得到了众多网友支持。他们认为，在应试教育环境下，学制太长浪费时间，高三、初三就是复习，小学5年上完也没问题。\n" +
                "然而，一些业内教育专家对此并不认同。王本中曾任北师大附属实验中学校长，现为中国教育学会高中教育专业委员会名誉理事长，他此次研讨会上反驳道：“一年高考复习，一年中考复习，说这都是浪费，10年就可以学完。\n" +
                "应试教育有两个关键词‘高厉害’、‘强选拔’，其实不管是改成10年，9年、8年也好，哪怕你改成6年，也会有两年照样是复习应试。”\n" +
                "王本中对澎湃新闻笑称：“莫言无知无畏，敢说，但其实不懂教育。”");
        contentValues.put("type",1);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tou5);
        contentValues.put("title","菲律宾想把仲裁案塞进李克强参加的这个会 中国不答应");
        contentValues.put("text","据BBC中文网7月14日报道，菲律宾外交部14日发表声明称，敦促中国“尊重”南海仲裁案的裁决结果。这是7月12日南海仲裁结果出炉后，菲律宾方面作出的最明确的一次表态。\n" +
                "菲方外交部声明，“亚赛外长将在亚欧会议的议程范围内讨论菲律宾对于中国南海问题和平且有规可循的处理方法，各方需要尊重近日的裁决。”\n" +
                "此前，菲律宾新任外交部长佩费克托·亚赛（Perfecto Yasay）在最初就仲裁结果发表评论时称，“菲律宾尊重这个里程碑性的裁决”，并呼吁各方克制。菲律宾外交部长亚赛\n" +
                "报道称，亚赛将在周五（7月15日）起出席在蒙古举行的亚欧会议（Asia-Europe Meeting，ASEM），中国国务院总理李克强也将代表中国出席。菲律宾方面表示，将以开放态度和中国讨论如何执行南海仲裁案裁决结果的问题。\n" +
                "不过，中国已经表明，亚欧会议不是讨论南海问题的适当场合，该议题也不在会议议程之内。\n" +
                "亚欧峰会的与会方包括亚洲和欧洲多个国家，包括在南海主权争议当中其他声称拥有部分主权的越南、马来西亚等国。\n" +
                "另据法新社消息，亚赛在裁决后一天曾在一个电台访问中表示，菲律宾将会寻求以和平方式逐步实现裁决的决定。“我们持开放的态度，愿意确保我们将会和中国进行双边会谈，讨论如何执行仲裁庭的决定。”\n" +
                "而据美媒13日报道，菲律宾总统发言人阿贝拉透露，在认真研读南海仲裁裁决之前，菲律宾政府不会发表任何公开声明。\n" +
                "菲律宾南海案首席顾问、现任最高法院大法官哈尔德勒萨则强调，\n" +
                "政府应当“根据其政治和外交目标”谨慎处理与中国在此事上的关系。菲律宾新任总统杜特尔特也曾在他的首次内阁会议中表示，他不会因应仲裁结果高调行事。");
        contentValues.put("type",1);
        helper.insert("tb_information",null,contentValues);

        contentValues.put("imageId",R.drawable.tui1);
        contentValues.put("title","美国将台湾当“棋子”耍 蔡英文看懂了吗？");
        contentValues.put("text","美国活生生地给两岸上了一课：什么叫做“强权就是法律”。古有秦国赵高“指鹿为马”，今有美国强权“视岛为礁”；美国也给蔡英文当局上了一课：什么叫做战略棋子。\n" +
                "“我本将心向明月，奈何明月照沟渠”不就是蔡英文当局倾美日的写照吗？\n" +
                "蔡英文在520的谈话中，明白地表示在安全上要站在美日“价值同盟”的一边，在谈论南海议题上，\n" +
                "把“尊重国际法及海洋法公约”挂在嘴边，所有的南海主张，包括自由航行、和平解决争端，也几乎与美国主张如出一辙\n" +
                "。蔡英文却完全没有想到，在美国眼中，她的表态其实是多余的，美国有自己的战略构想与步骤。主张“亲美”的马英九也没有想到，\n" +
                "他的所有证明“太平岛是岛非礁”的行为在美国眼中也不具任何意义。\n" +
                "美国为了创造其国家利益，维持其在东亚的霸权，台湾哪一个政党执政对其不会有太大的差别。为何仲裁法庭敢于“视岛为礁”？\n" +
                "从美国的南海战略来看，美国不会相信两岸任何一个政府。或许目前蔡当局愿意配合美国而不与大陆合作，但是未来的“政府”未必如此，\n" +
                "因而釜底抽薪之道，就是将南海最大的太平岛判成礁，让南海内所有其他岛礁均也仅能为礁，未来即使两岸合作，也只能在“礁”的基础上合作，\n" +
                "这完全不妨害美国所有“航行自由”与经济开发的权利。\n" +
                "美国的目的很清楚，利用菲律宾及仲裁法庭瓦解两岸在U型线的历史性权益，增加未来北京与其他声索国谈判的困难。\n" +
                "相关声索国必然会引用仲裁法庭的裁决，作为未来与北京谈判的基础，弱化大陆在南海行为的正当性。如果不是因为此次裁决有过多的斧凿之痕，荒谬地“指鹿为马、视岛为礁”，\n" +
                "民进党或许会选择噤声并乐观其成，但是由于美国采取“从法律上一次斩草除根”的策略，反而暴露出仲裁结果的无理与粗暴。逼得民进党不得不收回先前的说法，\n" +
                "公开反对“指岛为礁”，派出军舰了。\n" +
                "蔡当局面对这个裁决有其困境，一方面要顾及台湾的民意，另一方面又不能完全得罪美国，使得民进党当局的反应没有真正面对问题。");
        contentValues.put("type",2);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tui2);
        contentValues.put("title","你觉得重大疾病和意外离你有多远？还不重视");
        contentValues.put("text","65种重疾：确诊后立即赔付，与社保无冲突。\n" +
                "          35种特定疾病：原位癌、早期肝硬化都能赔。\n" +
                "          5种少儿特定疾病：额外多含5种少儿多发疾病。\n" +
                "被保人发生35种早期重疾、轻症，剩余保费全免，保障责任不受任何影响。\n" +
                "交费10年即可保障20年；也可选择交费5、10、15、20年保障至80岁。\n" +
                "保险合同有效期内，如合同累积有现金价值，最高可按合同现价的80%申请借款，为您解决燃眉之急。\n" +
                "满期最高128%返还实际所交保费，即便发生少儿及特定疾病理赔，依然享受满期生存收益。\n" +
                "保险有效期内不幸身故，不论疾病还是意外都赔付。\n" +
                "为客户提供完整的重疾解决方案， 从拨入客服电话那一刻起，即有服务人员协调安排专家门诊诊治、入住医院手术治疗、主动跟进理赔需求。\n" +
                "无需发票，一经确诊一次性赔付，与社保无冲突，不影响社保报销。");
        contentValues.put("type",2);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tui3);
        contentValues.put("title","女孩独自给马儿喂食，打完电话回来的妈妈肠子都悔青了。");
        contentValues.put("text","在国外，很多家长都喜欢带自己的小孩子到动物园或牧场与动物来个亲密接触，让孩子在大自然中学习更多，\n" +
                "但是在户外与动物接触的时候一定要非常注意安全，因为不管多么温顺的动物也会存在一定的攻击性。\n" +
                "就像以上这对母女，母亲带着小女儿在牧场上喂食马儿的时候就出了意外。女儿在一边手拿着胡萝卜放到马儿的嘴边喂食，\n" +
                "而母亲就在不远处打电话，忽然听到女儿的尖叫声，吓得母亲赶紧跑过去。\n" +
                "因为不知道发生什么事，母亲紧张地查看女儿看看是哪里受伤，当女儿告诉母亲手指痛的时候，母亲一看就差点晕过去了，女儿的大拇指没有了\n" +
                "原来是小女儿在喂食马儿的时候，其中一匹棕色的马儿忽然失控了，不小心将女儿的大拇指给咬断。\n" +
                "这样的事情是比较少发生，毕竟马儿的性格还是比较温和，很少会主动攻击人类，而这次的事件纯属意外\n" +
                "幸好小女儿很坚强，没有被这次的事故影响到往后的学习生活，一样保持着乐观向上的态度。另外家长在带小孩子出去游玩的时候一定要非常留神\n" +
                "，因为很多时候的事故都是发生在家长疏忽的一瞬间而造成孩子的终身遗憾");
        contentValues.put("type",2);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tui4);
        contentValues.put("title","南海研究院院长：这是一场被操纵的政治闹剧");
        contentValues.put("text","在菲律宾单方面提起的“南海仲裁案”临时仲裁庭公布所谓裁决后，国内权威机构和专家纷纷发声，表明一致立场。\n" +
                "          13日，中国南海研究院院长吴士存教授，受邀出席由光明日报社举办的光明讲坛，对南海问题进行了讲解分析。\n" +
                "    1、“裁决”既出乎意料，又在意料之中\n" +
                "对于这份长达500多页所谓的裁决，吴士存认为“既出乎意料，又在意料之中”。\n" +
                "“出乎意料，是因为临时仲裁庭将菲律宾提出的15项诉求几乎照单全收，而对中国在南海的领土主权和海洋权益近乎全盘否定，完全背离了其应有的公道和正义的角色。”\n" +
                "“意料之中，是因为去年10月29日的管辖权和可受理性裁决已经表明，仲裁庭一边倒地支持菲律宾的非法主张，已沦为美、日等域外国家在南海与中国进行地缘政治博弈和挑战我国在南海固有权利及合法主张的工具。”吴士存说。\n" +
                "    2、拒绝执行国际裁决，美国带头且上榜最多\n" +
                "所谓裁决公布后，中国政府表明不接受、不承认这一非法裁决，这一裁决对中方没有拘束力，也不可能否定中国在南海的领土主权和海洋权益。\n" +
                "吴士存表示，裁决否定中国南沙群岛海洋地物的岛屿地位及其群岛整体性主张，否定中国在南海的历史性权利，这种擅自越权和扩权裁决，不仅无视《联合国海洋法公约》（以下简称《公约》）顾及和保护缔约国主权的基本前提，而且完全背离了《公约》促进和平解决争端的宗旨，严重损害了《公约》的完整性和权威性。\n" +
                "据美国学者统计，从1946年国际法院成立到2004年的近60年间，国际法院所做判决的“不被执行率”高达44%，而带有强制管辖性质案件的执行率只有33%，其中，美国曾参与的国际司法案件包括：“美国驻德黑兰外交和领事人员案”（美国诉伊朗），“在尼加拉瓜境内及针对尼加拉瓜的军事与准军事活动案”（尼加拉瓜诉美国），“拉格朗”（德国诉美国）案，及“阿韦纳和其他墨西哥国民”（墨西哥诉美国）案。其中前两个案件，当事国完全没有遵守国际法院的判决；后两个案件，当事国没有完全遵守国际法院的判决。\n" +
                "南海仲裁案临时仲裁庭与位于海牙联合国系统的国际法院毫无关系，临时仲裁庭根本不是国际法庭，而是一个政治操作的结果。吴士存说：“从这个意义上讲，中国不接受不公正的裁决，不执行对中国本来就没有约束力的非法裁决，既非开创了什么‘恶劣先例’，更谈不上无视国际法和挑战国际秩序。”\n" +
                "   3、这是一场被操纵的政治闹剧\n" +
                "“大国借机谋势、小国伺机谋利、大小国联合应对中国。”吴士存说，“菲方的诉讼请求虽然被巧妙包装成《公约》的解释和适用范围，但其本质仍是领土和海域划界争议。领土争议不属于《公约》调整的范畴，而海洋划界已由中国政府在2006年声明中排除。”\n" +
                "中菲自1995年到2011年达成的数个共识文件，都确定了中菲之间的领土争议和海洋划界争议应通过友好协商和谈判解决。基于约定必须遵守的国际法原则，菲方的诉求不仅违背了其做出的承诺，也违反了国际法。\n" +
                "“所谓南海仲裁案已不是纯粹的法律问题，菲方背后有某些西方大国的操纵。在仲裁结果公布之前，就有一些大国开始利用各种渠道向国际社会释放信息，要求中国执行裁决。”吴士存说，“似乎这些国家已预知仲裁结果，至少已经知道裁决将不利于中国，唯恐中国不执行裁决。因此，仲裁结果显然已被有关国家预先设计过。”\n" +
                "此前，外交部副部长刘振民指出，这个仲裁庭的组成实际上是一个政治操作的产物。仲裁庭是由5名仲裁员组成，除了菲律宾自己指定的仲裁员，其他4名仲裁员是由国际海洋法法庭时任庭长、日本籍法官柳井俊二先生指定的，这个仲裁庭的组成完全是由他操纵。\n" +
                "   4、中国对南海诸岛的主权具有充分的历史和法理依据\n" +
                "历史上，中国最早发现、命名、开发南海诸岛，长期、和平、有效地对南海诸岛及相关海域实施行政管辖，建立了对南海诸岛的主权和相关海洋权益。\n" +
                "吴士存特别提到了海南渔民使用的大约起源于明代早期的多个版本《更路簿》，记载了前往西、南沙各岛礁捕鱼的航向航程、物资特产等，中国拥有南海诸岛主权和历史性权利的确凿证据。\n" +
                "二战期间，日本一度非法侵占我国南海诸岛，并将南海诸岛更名为“新南群岛”，划归台湾总督府高雄州高雄市管辖。1945年二战结束之后，根据1943年的《开罗宣言》和1945年的《波茨坦公告》的有关规定，中国政府于1946年恢复对南海诸岛行使主权。\n" +
                "“《公约》虽然没有对历史性权利作十分明确的界定，但也没有否定历史性权利的存在，而且，《公约》的宗旨包含了对历史性权利的尊重。”\n" +
                "吴士存说，仲裁的闹剧虽然已落下帷幕，但因裁决给南海和平稳定投下的“阴影”短时间内恐难以消除。但无论如何，中国政府绝不会放弃千百年来中国通过先占、开发经营和管辖南海诸岛及相关水域获得的领土主权和海洋权益。");
        contentValues.put("type",2);
        helper.insert("tb_information",null,contentValues);
        contentValues.put("imageId",R.drawable.tui5);
        contentValues.put("title","小粗腿也有春天，哦不，夏天");
        contentValues.put("text","一到夏天，全世界的姑娘都在关心同一个问题：你说，我的腿粗不粗，粗还是不粗~我发现，无论是胖妞还是瘦妞，都觉得自己的腿不够细。\n" +
                "当然，也有不少姑娘腿上是真有肉。毕竟国情摆在这里，亚洲女生以梨型身材居多，肉肉更爱往下半身长。说起来可能有点得罪人。\n" +
                "我并不觉得筷子腿很好看，毕竟我自己以前是筷子腿的时候，还整天琢磨着怎么不胖腰腹而胖在腿上就好了。后来大腿因为久坐和运动量不够变粗了，才知道惨。\n" +
                "穿个铅笔裤都被莫妮卡问怎么大腿比小腿粗那么多！总算知道腿粗的烦恼~\n" +
                "腿粗腿细不是最关键，关键在于不匀称。而腿上的肉想要减下来，也不是一天两天的事。\n" +
                "还好，我们还可以通过穿衣搭配来扬长避短（对，我已经淘汰了那条铅笔裤）今天就一起来讨论下怎么穿对衣服，拯救小粗腿。\n" +
                "\n" +
                "大腿粗\n" +
                "身边腿粗的姑娘大部分是大腿粗，顺带胯骨也比较宽，就是我们常说的梨型身材。以前专门写过一篇，梨型身材怎么穿，戳蓝字可温习。\n" +
                "\n" +
                "对大腿粗PP大的同学来说，要多穿裙子少穿裤子。\n" +
                "刘亦菲参加活动最爱穿的就是各种裙子，尤其是长度在膝盖上一点的长度。");
        contentValues.put("type",2);
        helper.insert("tb_information",null,contentValues);

        contentValues.put("imageId",R.mipmap.ic_launcher);
        contentValues.put("title","从前有座庙");
        contentValues.put("text","山上有座庙，庙里有个老和尚，一个和尚有水喝，两个和尚抬水喝，三个和尚没水喝");
        contentValues.put("type",3);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);

        contentValues.put("imageId",R.mipmap.ic_launcher);
        contentValues.put("title","从前有座黄亦成");
        contentValues.put("text","山上有座庙，庙里有个老和尚，一个和尚有水喝，两个和尚抬水喝，三个和尚没水喝");
        contentValues.put("type",4);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);

        contentValues.put("imageId",R.mipmap.ic_launcher);
        contentValues.put("title","从前有座黄日天");
        contentValues.put("text","山上有座庙，庙里有个老和尚，一个和尚有水喝，两个和尚抬水喝，三个和尚没水喝");
        contentValues.put("type",5);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
        helper.insert("tb_information",null,contentValues);
    }
    public void setAdapters(Integer types){

        arrayList.clear();
        Cursor cursor = helper.query("tb_information",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Integer type = Integer.parseInt(cursor.getString(4));
            if (type != types)continue;
            Integer id = Integer.parseInt(cursor.getString(0));
            Integer imageId=Integer.parseInt(cursor.getString(1));
            String title =cursor.getString(2);
            String text =cursor.getString(3);
            information = new Information(id,imageId,title,text);
            arrayList.add(information);
        }
        cursor.close();
        //设置适配器
        InformationAdapter informationAdapter = new InformationAdapter(MainActivity.this,arrayList);
        listView.setAdapter(informationAdapter);
    }
}
