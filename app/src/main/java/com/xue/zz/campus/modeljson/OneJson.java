package com.xue.zz.campus.modeljson;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class OneJson {
    private String res;
    private int total;
    private String mes;

    private List<OneList> data;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public List<OneList> getData() {
        return data;
    }

    public void setData(List<OneList> data) {
        this.data = data;
    }

    public class OneList {
        private String res_id;//ID
        private String res_name;//餐厅名字
        private String res_intro;//餐厅内容
        private String res_img;//餐厅图片

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

        public String getRes_intro() {
            return res_intro;
        }

        public void setRes_intro(String res_intro) {
            this.res_intro = res_intro;
        }

        public String getRes_name() {
            return res_name;
        }

        public void setRes_name(String res_name) {
            this.res_name = res_name;
        }
    }
}
