package com.bwie.test.liuhaifeng20171118.model.bean;

import java.util.List;

/**
 * 刘海峰.11:07
 */

public class News {
    private HeaderBean header;
    private List<DataBean> data;

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class HeaderBean {
        /**
         * pagesize : 20
         * last : page_10.json
         * pre : page_1.json
         * next : page_2.json
         * totalsize : 186
         * first : page_1.json
         * totalpage : 10
         */

        private int pagesize;
        private String last;
        private String pre;
        private String next;
        private int totalsize;
        private String first;
        private int totalpage;

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getPre() {
            return pre;
        }

        public void setPre(String pre) {
            this.pre = pre;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public int getTotalsize() {
            return totalsize;
        }

        public void setTotalsize(int totalsize) {
            this.totalsize = totalsize;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }
    }

    public static class DataBean {
        /**
         * summary :
         * img : http://mnews.gw.com.cn/wap/style/data/news/txs/images/1510358537754.jpg
         * advTypeShare :
         * url : http://mnews.gw.com.cn/wap/data/news/txs/2017/11/239715.json
         * countid : 20009
         * id : 239715
         * title : 【环球】道指终结八周连涨走势 迅雷收涨近40%
         * otime : 2017-11-11 08:02:40
         * source :
         * views : 1085
         * resType : 置顶
         */

        private String summary;
        private String img;
        private String advTypeShare;
        private String url;
        private int countid;
        private String id;
        private String title;
        private String otime;
        private String source;
        private String views;
        private String resType;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getAdvTypeShare() {
            return advTypeShare;
        }

        public void setAdvTypeShare(String advTypeShare) {
            this.advTypeShare = advTypeShare;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getCountid() {
            return countid;
        }

        public void setCountid(int countid) {
            this.countid = countid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOtime() {
            return otime;
        }

        public void setOtime(String otime) {
            this.otime = otime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getResType() {
            return resType;
        }

        public void setResType(String resType) {
            this.resType = resType;
        }
    }
}
