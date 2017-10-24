package com.example.dellll.xiaoyi.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/19/019.
 */

public class ClassBean {

    /**
     * code : 200
     * datas : {"class_list":[{"commis_rate":"0","gc_description":"","gc_id":"1037","gc_keywords":"","gc_name":"虚拟充值","gc_parent_id":"0","gc_sort":"255","gc_title":"","gc_virtual":"1","image":"http://169.254.133.48/data/upload/mobile/category/05015383410379550.png","show_type":"1","text":"充值/游戏/票务","type_id":"0","type_name":""}]}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<ClassListBean> class_list;

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * commis_rate : 0
             * gc_description :
             * gc_id : 1037
             * gc_keywords :
             * gc_name : 虚拟充值
             * gc_parent_id : 0
             * gc_sort : 255
             * gc_title :
             * gc_virtual : 1
             * image : http://169.254.133.48/data/upload/mobile/category/05015383410379550.png
             * show_type : 1
             * text : 充值/游戏/票务
             * type_id : 0
             * type_name :
             */

            private String commis_rate;
            private String gc_description;
            private String gc_id;
            private String gc_keywords;
            private String gc_name;
            private String gc_parent_id;
            private String gc_sort;
            private String gc_title;
            private String gc_virtual;
            private String image;
            private String show_type;
            private String text;
            private String type_id;
            private String type_name;

            public String getCommis_rate() {
                return commis_rate;
            }

            public void setCommis_rate(String commis_rate) {
                this.commis_rate = commis_rate;
            }

            public String getGc_description() {
                return gc_description;
            }

            public void setGc_description(String gc_description) {
                this.gc_description = gc_description;
            }

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_keywords() {
                return gc_keywords;
            }

            public void setGc_keywords(String gc_keywords) {
                this.gc_keywords = gc_keywords;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }

            public String getGc_parent_id() {
                return gc_parent_id;
            }

            public void setGc_parent_id(String gc_parent_id) {
                this.gc_parent_id = gc_parent_id;
            }

            public String getGc_sort() {
                return gc_sort;
            }

            public void setGc_sort(String gc_sort) {
                this.gc_sort = gc_sort;
            }

            public String getGc_title() {
                return gc_title;
            }

            public void setGc_title(String gc_title) {
                this.gc_title = gc_title;
            }

            public String getGc_virtual() {
                return gc_virtual;
            }

            public void setGc_virtual(String gc_virtual) {
                this.gc_virtual = gc_virtual;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getShow_type() {
                return show_type;
            }

            public void setShow_type(String show_type) {
                this.show_type = show_type;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }
        }
    }
}
