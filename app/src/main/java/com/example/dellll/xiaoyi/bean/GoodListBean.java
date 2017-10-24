package com.example.dellll.xiaoyi.bean;

import com.example.dellll.xiaoyi.Activity.Goods;

import java.util.List;

/**
 * Created by peng on 2017/10/20.
 * 商品列表请求下来的数据
 */

public class GoodListBean extends BaseBean{

    /**
     * datas : {"goods_list":[{"evaluation_count":"0","evaluation_good_star":"5","goods_id":"100009","goods_image":"1_04752627958339099.jpg","goods_image_url":"http://169.254.133.48/data/upload/shop/store/goods/1/1_04752627958339099_360.jpg","goods_jingle":"【雅欧国际】：所有商品全新原装正品　　","goods_marketprice":"52800.00","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":"42800.00","goods_salenum":"1","group_flag":true,"have_gift":"0","is_fcode":"0","is_own_shop":"1","is_presell":"0","is_virtual":"0","sole_flag":false,"store_id":"1","store_name":"好商城V5","xianshi_flag":false}]}
     * hasmore : false
     * page_total : 1
     */

    private DatasBean datas;
    private boolean hasmore;
    private int page_total;

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public static class DatasBean {
        private List<GoodsListBean> goods_list;




        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {
            /**
             * evaluation_count : 0
             * evaluation_good_star : 5
             * goods_id : 100009
             * goods_image : 1_04752627958339099.jpg
             * goods_image_url : http://169.254.133.48/data/upload/shop/store/goods/1/1_04752627958339099_360.jpg
             * goods_jingle : 【雅欧国际】：所有商品全新原装正品　　
             * goods_marketprice : 52800.00
             * goods_name : 劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品
             * goods_price : 42800.00
             * goods_salenum : 1
             * group_flag : true
             * have_gift : 0
             * is_fcode : 0
             * is_own_shop : 1
             * is_presell : 0
             * is_virtual : 0
             * sole_flag : false
             * store_id : 1
             * store_name : 好商城V5
             * xianshi_flag : false
             */

            private String evaluation_count;
            private String evaluation_good_star;
            private String goods_id;
            private String goods_image;
            private String goods_image_url;
            private String goods_jingle;
            private String goods_marketprice;
            private String goods_name;
            private String goods_price;
            private String goods_salenum;
            private boolean group_flag;
            private String have_gift;
            private String is_fcode;
            private String is_own_shop;
            private String is_presell;
            private String is_virtual;
            private boolean sole_flag;
            private String store_id;
            private String store_name;
            private boolean xianshi_flag;

            public String getEvaluation_count() {
                return evaluation_count;
            }

            public void setEvaluation_count(String evaluation_count) {
                this.evaluation_count = evaluation_count;
            }

            public String getEvaluation_good_star() {
                return evaluation_good_star;
            }

            public void setEvaluation_good_star(String evaluation_good_star) {
                this.evaluation_good_star = evaluation_good_star;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }

            public String getGoods_jingle() {
                return goods_jingle;
            }

            public void setGoods_jingle(String goods_jingle) {
                this.goods_jingle = goods_jingle;
            }

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(String goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public boolean isGroup_flag() {
                return group_flag;
            }

            public void setGroup_flag(boolean group_flag) {
                this.group_flag = group_flag;
            }

            public String getHave_gift() {
                return have_gift;
            }

            public void setHave_gift(String have_gift) {
                this.have_gift = have_gift;
            }

            public String getIs_fcode() {
                return is_fcode;
            }

            public void setIs_fcode(String is_fcode) {
                this.is_fcode = is_fcode;
            }

            public String getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(String is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public String getIs_presell() {
                return is_presell;
            }

            public void setIs_presell(String is_presell) {
                this.is_presell = is_presell;
            }

            public String getIs_virtual() {
                return is_virtual;
            }

            public void setIs_virtual(String is_virtual) {
                this.is_virtual = is_virtual;
            }

            public boolean isSole_flag() {
                return sole_flag;
            }

            public void setSole_flag(boolean sole_flag) {
                this.sole_flag = sole_flag;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public boolean isXianshi_flag() {
                return xianshi_flag;
            }

            public void setXianshi_flag(boolean xianshi_flag) {
                this.xianshi_flag = xianshi_flag;
            }
        }
    }
}
