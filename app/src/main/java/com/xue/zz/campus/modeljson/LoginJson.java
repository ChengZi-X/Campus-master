package com.xue.zz.campus.modeljson;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */

public class LoginJson {
    private String res;
    private String mes;
    private List<Login> data;
    public List<Login> getData() {
        return data;
    }
    public void setData(List<Login> data) {
        this.data = data;
    }
    public String getRes() {
        return res;
    }
    public void setRes(String res) {
        this.res = res;
    }
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
    public class Login {
        public String id;
        public String tact;//烹饪手法
        public String main;
        public String title;
        public String litpic;//图片
        public String author;
        public String body;
        public String date;//兑换的时间
        public String phnum;
        public String smscode;
        public String password;
        public String userid;
        public String tname;//真实姓名
        public String meal_litpic;//套餐的图片
        public String mealinfo;//套餐介绍
        public String group_title;
        public String group_text;
        public String group_id;
        public String nickname;
        public String headimg;//圈子列表图片
        public String new_pic;
        // 餐厅列表
        public String res_id; // 餐厅ID
        public String res_img; // 餐厅图片
        public String res_name; // 餐厅名称
        public String res_intro;// 餐厅介绍
        // 餐厅列表里面对应的菜单
        public String menu_id; // 菜单ID
        public String dish; // 菜名
        public String intro; // 菜品简介
        public double price; // 价格
        public double discount; // 折扣
        public double pack; // 打包费
        public int num; // 数量
        public String tempNum = "0";//临时数量
        public String mealname; // 套餐的名字
        public String dosing;//手法 //配料
        public String salnum; // 售量
        public float once;//分量
        public String htinfo;//资讯分类
        public String form;
        public String group_time;//获得圈子的时间
        public String stuid;
        public String phone;
        public String address;//送餐地址
        public String address_item;//我的地址
        public String sex;
        public String tel;
        public String reply_num;
        public String reply_time;//获取圈子时间
        public String text;//获取圈子内容
        public String integral;//积分
        public String balance;//金钱
        public String ccode;//领取编号
        public String like_id;//个人喜好//口味
        public String p_id;//评论对象id
        public String reply_time1;
        public String total;
        public String diner_time;
        public String add_time;
        public String flag;
        public String codepic;
        public String dis_id;//带单库ID

        public String foodma;//主要食材
        public String hate_menu;//菜单库id
        public String sch_name;//热门学校
        public String ordername;//订单名称
        public String name;//送餐员名字
        public String resid;//送餐账号ID
        public String online;//送餐员在线状态（1离线状态  2在线状态）
        public String sev_tel;//客服电话
        public String copyright;//版权信息
        public String hate;//厌恶
        public String school;//用户输入的学校
        public String qq;//用户输入的QQ
        public String wechat;//用户输入的微信
        public String email;//用户输入的邮箱
        public String birth;//用户的生日
        public String prefer;//口味标签
        public String food;//食材标签
        public String ifmeal;//判断是否是套餐
        public String value;//营养价值
        public String efficacy;//功效
        public String ban;//禁忌
        public String top;//顶置
        public int ifkeep;//是否被收藏（1为已被收藏  0为没有被收藏）
        //优惠券
        public String usrcpid;//用户优惠券ID
        public String uid;//用户ID
        public String cpid;//优惠券id
        public int state;//使用状态（1为已经使用0为未使用）
        public String amount;//优惠券面额
        public String confine;//优惠券使用条件
        public String etime;//优惠券过期时间
        public int ch;//优惠券使用（1为默认使用的优惠券）
        public String discounts;//折扣价钱
        //菜单分类
        public String typename;//分类名称

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTact() {
            return tact;
        }

        public void setTact(String tact) {
            this.tact = tact;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLitpic() {
            return litpic;
        }

        public void setLitpic(String litpic) {
            this.litpic = litpic;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPhnum() {
            return phnum;
        }

        public void setPhnum(String phnum) {
            this.phnum = phnum;
        }

        public String getSmscode() {
            return smscode;
        }

        public void setSmscode(String smscode) {
            this.smscode = smscode;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getMeal_litpic() {
            return meal_litpic;
        }

        public void setMeal_litpic(String meal_litpic) {
            this.meal_litpic = meal_litpic;
        }

        public String getMealinfo() {
            return mealinfo;
        }

        public void setMealinfo(String mealinfo) {
            this.mealinfo = mealinfo;
        }

        public String getGroup_title() {
            return group_title;
        }

        public void setGroup_title(String group_title) {
            this.group_title = group_title;
        }

        public String getGroup_text() {
            return group_text;
        }

        public void setGroup_text(String group_text) {
            this.group_text = group_text;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getNew_pic() {
            return new_pic;
        }

        public void setNew_pic(String new_pic) {
            this.new_pic = new_pic;
        }

        public String getRes_id() {
            return res_id;
        }

        public void setRes_id(String res_id) {
            this.res_id = res_id;
        }

        public String getRes_img() {
            return res_img;
        }

        public void setRes_img(String res_img) {
            this.res_img = res_img;
        }

        public String getRes_name() {
            return res_name;
        }

        public void setRes_name(String res_name) {
            this.res_name = res_name;
        }

        public String getRes_intro() {
            return res_intro;
        }

        public void setRes_intro(String res_intro) {
            this.res_intro = res_intro;
        }

        public String getMenu_id() {
            return menu_id;
        }

        public void setMenu_id(String menu_id) {
            this.menu_id = menu_id;
        }

        public String getDish() {
            return dish;
        }

        public void setDish(String dish) {
            this.dish = dish;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getPack() {
            return pack;
        }

        public void setPack(double pack) {
            this.pack = pack;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getTempNum() {
            return tempNum;
        }

        public void setTempNum(String tempNum) {
            this.tempNum = tempNum;
        }

        public String getMealname() {
            return mealname;
        }

        public void setMealname(String mealname) {
            this.mealname = mealname;
        }

        public String getDosing() {
            return dosing;
        }

        public void setDosing(String dosing) {
            this.dosing = dosing;
        }

        public String getSalnum() {
            return salnum;
        }

        public void setSalnum(String salnum) {
            this.salnum = salnum;
        }

        public float getOnce() {
            return once;
        }

        public void setOnce(float once) {
            this.once = once;
        }

        public String getHtinfo() {
            return htinfo;
        }

        public void setHtinfo(String htinfo) {
            this.htinfo = htinfo;
        }

        public String getForm() {
            return form;
        }

        public void setForm(String form) {
            this.form = form;
        }

        public String getGroup_time() {
            return group_time;
        }

        public void setGroup_time(String group_time) {
            this.group_time = group_time;
        }

        public String getStuid() {
            return stuid;
        }

        public void setStuid(String stuid) {
            this.stuid = stuid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress_item() {
            return address_item;
        }

        public void setAddress_item(String address_item) {
            this.address_item = address_item;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getReply_num() {
            return reply_num;
        }

        public void setReply_num(String reply_num) {
            this.reply_num = reply_num;
        }

        public String getReply_time() {
            return reply_time;
        }

        public void setReply_time(String reply_time) {
            this.reply_time = reply_time;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getCcode() {
            return ccode;
        }

        public void setCcode(String ccode) {
            this.ccode = ccode;
        }

        public String getLike_id() {
            return like_id;
        }

        public void setLike_id(String like_id) {
            this.like_id = like_id;
        }

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }

        public String getReply_time1() {
            return reply_time1;
        }

        public void setReply_time1(String reply_time1) {
            this.reply_time1 = reply_time1;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getDiner_time() {
            return diner_time;
        }

        public void setDiner_time(String diner_time) {
            this.diner_time = diner_time;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getCodepic() {
            return codepic;
        }

        public void setCodepic(String codepic) {
            this.codepic = codepic;
        }

        public String getDis_id() {
            return dis_id;
        }

        public void setDis_id(String dis_id) {
            this.dis_id = dis_id;
        }

        public String getFoodma() {
            return foodma;
        }

        public void setFoodma(String foodma) {
            this.foodma = foodma;
        }

        public String getHate_menu() {
            return hate_menu;
        }

        public void setHate_menu(String hate_menu) {
            this.hate_menu = hate_menu;
        }

        public String getSch_name() {
            return sch_name;
        }

        public void setSch_name(String sch_name) {
            this.sch_name = sch_name;
        }

        public String getOrdername() {
            return ordername;
        }

        public void setOrdername(String ordername) {
            this.ordername = ordername;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResid() {
            return resid;
        }

        public void setResid(String resid) {
            this.resid = resid;
        }

        public String getOnline() {
            return online;
        }

        public void setOnline(String online) {
            this.online = online;
        }

        public String getSev_tel() {
            return sev_tel;
        }

        public void setSev_tel(String sev_tel) {
            this.sev_tel = sev_tel;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getHate() {
            return hate;
        }

        public void setHate(String hate) {
            this.hate = hate;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getPrefer() {
            return prefer;
        }

        public void setPrefer(String prefer) {
            this.prefer = prefer;
        }

        public String getFood() {
            return food;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public String getIfmeal() {
            return ifmeal;
        }

        public void setIfmeal(String ifmeal) {
            this.ifmeal = ifmeal;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getEfficacy() {
            return efficacy;
        }

        public void setEfficacy(String efficacy) {
            this.efficacy = efficacy;
        }

        public String getBan() {
            return ban;
        }

        public void setBan(String ban) {
            this.ban = ban;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public int getIfkeep() {
            return ifkeep;
        }

        public void setIfkeep(int ifkeep) {
            this.ifkeep = ifkeep;
        }

        public String getUsrcpid() {
            return usrcpid;
        }

        public void setUsrcpid(String usrcpid) {
            this.usrcpid = usrcpid;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getCpid() {
            return cpid;
        }

        public void setCpid(String cpid) {
            this.cpid = cpid;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getConfine() {
            return confine;
        }

        public void setConfine(String confine) {
            this.confine = confine;
        }

        public String getEtime() {
            return etime;
        }

        public void setEtime(String etime) {
            this.etime = etime;
        }

        public int getCh() {
            return ch;
        }

        public void setCh(int ch) {
            this.ch = ch;
        }

        public String getDiscounts() {
            return discounts;
        }

        public void setDiscounts(String discounts) {
            this.discounts = discounts;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }
    }
}
