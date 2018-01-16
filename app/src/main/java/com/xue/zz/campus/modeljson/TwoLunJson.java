package com.xue.zz.campus.modeljson;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class TwoLunJson {
    public String res;
    public String mes;
    public List<TwoLun> data;

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

    public List<TwoLun> getData() {
        return data;
    }

    public void setData(List<TwoLun> data) {
        this.data = data;
    }

    public class TwoLun {
        public String id;//获得图片id
        public String htinfo;// 获得资讯分类
        public String date;//获得时间
        public String body;//获得内容
        public String author;//获得作者
        public String form;//获得来源
        public String title;//获得资讯标题
        public String litpic;//获得图片url

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHtinfo() {
            return htinfo;
        }

        public void setHtinfo(String htinfo) {
            this.htinfo = htinfo;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getForm() {
            return form;
        }

        public void setForm(String form) {
            this.form = form;
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

    }

}
