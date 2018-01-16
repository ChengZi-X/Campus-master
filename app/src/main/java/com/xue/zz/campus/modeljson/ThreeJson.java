package com.xue.zz.campus.modeljson;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */

public class ThreeJson {
    private String res;
    private int total;
    private String mes;
    private List<ThreeList> data;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public List<ThreeList> getData() {
        return data;
    }

    public void setData(List<ThreeList> data) {
        this.data = data;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public class ThreeList {
        private String group_title;
        private String group_text;
        private String group_time;
        private String headimg;

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getGroup_time() {
            return group_time;
        }

        public void setGroup_time(String group_time) {
            this.group_time = group_time;
        }

        public String getGroup_text() {
            return group_text;
        }

        public void setGroup_text(String group_text) {
            this.group_text = group_text;
        }

        public String getGroup_title() {
            return group_title;
        }

        public void setGroup_title(String group_title) {
            this.group_title = group_title;
        }


    }

}
