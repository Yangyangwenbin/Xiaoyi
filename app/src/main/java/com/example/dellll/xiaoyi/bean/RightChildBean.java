package com.example.dellll.xiaoyi.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/20/020.
 */

public class RightChildBean {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"4","gc_name":"女装"}]}
     */

    private int code;
    private RightBean.DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RightBean.DatasBean getDatas() {
        return datas;
    }

    public void setDatas(RightBean.DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<RightBean.DatasBean.ClassListBean> class_list;

        public List<RightBean.DatasBean.ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<RightBean.DatasBean.ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 4
             * gc_name : 女装
             */

            private String gc_id;
            private String gc_name;

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }
        }
    }
}
