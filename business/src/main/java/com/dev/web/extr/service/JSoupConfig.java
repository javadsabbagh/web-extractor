package com.dev.web.extr.service;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p>
 *          Creation Date: 2016/06/17
 * @since 1.0.0
 */
public class JSoupConfig<T> {

    private String parsingUrl;
    private String outerHtmlTag;
    private String htmlPage;
    private Class<T> htmlMapClass;

    private JSoupConfig(String parsingUrl, String htmlPage, String outerHtmlTag, Class<T> htmlMapClass){
        this.parsingUrl=parsingUrl;
        this.outerHtmlTag=outerHtmlTag;
        this.htmlMapClass=htmlMapClass;
        this.htmlPage = htmlPage;
    }

    public String getParsingUrl() {
        return parsingUrl;
    }

    /**
     * example: <div class="info">
     * @return
     */
    public String getOuterHtmlTag() {
        return outerHtmlTag;
    }

    public Class<T> getHtmlMapClass() {
        return htmlMapClass;
    }

    public String getHtmlPage() {
        return htmlPage;
    }

    public static class JSoupConfigBuilder<T>{
        private String parsingUrl;
        private String outerHtmlTag;
        private String htmlPage;
        private Class<T> htmlMapClass;

        public JSoupConfigBuilder(Class<T> htmlMapClass){
              this.htmlMapClass = htmlMapClass;
        }

        public JSoupConfigBuilder withParsingUrl(String parsingUrl){
            this.parsingUrl = parsingUrl;
            return this;
        }

        public JSoupConfigBuilder withOuterHtmlTag(String outerHtmlTag){
            this.outerHtmlTag = outerHtmlTag;
            return this;
        }

        public JSoupConfigBuilder withFulHtmlString(String htmlPage){
            this.htmlPage = htmlPage;
            return this;
        }

        public JSoupConfig<T> build(){
            return new JSoupConfig<>(parsingUrl, htmlPage, outerHtmlTag, htmlMapClass);
        }

    }
}
