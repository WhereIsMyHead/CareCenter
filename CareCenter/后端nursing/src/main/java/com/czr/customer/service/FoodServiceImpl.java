package com.czr.customer.service;

import com.czr.customer.model.FoodCustomer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.czr.customer.mapper.FoodMapper;
import com.czr.customer.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

//    /**
//     * 查询列表
//     * @param currPage
//     * @return
//     */
//    @Override
//    public PageInfo<Food> list(Integer currPage, Food food) {
//        if(currPage == null) currPage = 1;
//        //设置从第几页查询N条
//        PageHelper.startPage(currPage, 10);
//        //分页查询
//        PageInfo<Food> pageInfo = new PageInfo<>(foodMapper.selectAll(food));
//        return pageInfo;
//    }

    public List<Food> selectAll(){
        return foodMapper.selectAll();
    }

    public List<Food> selectSpecify(Food food)
    {
        return foodMapper.selectSpecify(food);
    }

    public List<Food> selectById(List<Integer> id){
        List<Food> res=new ArrayList<>();
        Food food=new Food();
        for(int i=0;i<id.size();i++)
        {
            food.setId(id.get(i));
            res.addAll(foodMapper.selectSpecify(food));
        }
        return res;
    }
    /**
     *  新增
     * @param food
     */
    @Override
    public void add(Food food) {
        this.foodMapper.insert(food);
        System.out.println(food);
        //保存文档
//        bookRepository.save(book);

    }

    @Override
    public void updateByPrimaryKey(Food food)
    {
        this.foodMapper.updateByPrimaryKey(food);
    }

//    /** CacheEvict   删除,从缓存中删除相关的key-value,用来标注在需要清除缓存元素的方法或类上
//     *
//     * @param id
//     */
//    @Override
//    @CacheEvict(value="book",key="#id")
//    public void del(Integer id) {
//        bookMapper.deleteByPrimaryKey(id);
//        bookRepository.deleteById(id);
//    }

//    /**
//     * Cacheable如果缓存没有值,则执行方法并缓存数据,如果缓存有值,则从缓存中获取值
//     * value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
//     * key：缓存的key，默认为空，同上
//     * 根据主键加载
//     * @param id
//     * @return
//     */
//    @Override
//    @Cacheable(value="book",key="#id",unless="#result == null")
//    public Food get(Integer id) {
//        System.out.println("进get");
//        return bookMapper.selectByPrimaryKey(id);
//    }

//    /**
//     * CachePut保证方法被调用，又希望结果被缓存。
//     *与@Cacheable区别在于是否每次都调用方法，常用于更新
//     * @param book
//     */
//    @Override
//    @CachePut(value="book",key="#book.id")
//    public Food update(Food book) {
//        bookMapper.updateByPrimaryKey(book);
//        //修改文档
//        bookRepository.save(book);
//         return book;
//    }

    @Override
    @CachePut(value="food",key="#food.id")
    public void delFood(Food food) {
        foodMapper.delFood(food);
//        return foodMapper.selectByPrimaryKey(book.getId());
    }



//    public Page<Food> search(Integer currPage, String keyword){
//        //构建查询条件
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        //添加分词查询
//        queryBuilder.withQuery(QueryBuilders.multiMatchQuery(keyword,"bname","author"));
//        //分页(ES从第0页开始查)
//        queryBuilder.withPageable(PageRequest.of(currPage-1,5));
//        //搜索
//        Page<Food> page = bookRepository.search(queryBuilder.build());
//        return page;
//    }



//    public PageInfo<Food> searchHighlight(Integer currPage, String keyword){
//
//        Pageable pageable = PageRequest.of(currPage-1,5);
//
//        //构建查询条件
//        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
//        //添加分词查询
//        queryBuilder.should(QueryBuilders.multiMatchQuery(keyword,"bname","author"));
//
//        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(queryBuilder)
//                //设置高亮字段显示的样式
//                .withHighlightFields(
//                        new HighlightBuilder.Field("bname").preTags("<em style='color:red'>").postTags("</em>"),
//                        new HighlightBuilder.Field("author").preTags("<em style='color:red'>").postTags("</em>")
//                 )
//                .withPageable(pageable)
//                .build();
//
//        //实施查询，注意：这里的泛型最后和 elasticsearch 中的字段对应
//        Page<Food> bookPage = elasticsearchTemplate.queryForPage(searchQuery, Food.class, new SearchResultMapper() {
//            @Override
//            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
//                List<Food> bookVoList = new ArrayList<>();
//                //命中记录
//                SearchHits hits = response.getHits();
//                for (SearchHit hit : hits){
//                    if (hits.totalHits <= 0){
//                        return null;
//                    }
//                    Food bookVo = new Food();
//                    bookVo.setId((Integer)hit.getSourceAsMap().get("id"));
//                    bookVo.setBname(String.valueOf(hit.getSourceAsMap().get("bname")));
//                    bookVo.setAuthor(String.valueOf(hit.getSourceAsMap().get("author")));
//                    bookVo.setPicture(String.valueOf(hit.getSourceAsMap().get("picture")));
//                    bookVo.setPubDate(new Date((Long)(hit.getSourceAsMap().get("pubDate"))));
//
//                    //设置高亮（若对应字段有高亮的话）
//                    setHighLight(hit, "bname", bookVo);
//                    setHighLight(hit, "author", bookVo);
//
//                    bookVoList.add(bookVo);
//                }
//
//                return new AggregatedPageImpl<>((List<T>)bookVoList);
//            }
//        });
//        Page<Food> pages = this.search(currPage,keyword);
//        PageInfo<Food> pageInfo = new PageInfo<>();
//        pageInfo.setList(bookPage.getContent());
//        pageInfo.setTotal(pages.getTotalElements());
//        pageInfo.setPageSize(pages.getSize());
//        return pageInfo;
//    }
//
//
//
//
//    /**
//     * 设置高亮
//     * @param hit 命中记录
//     * @param filed 字段
//     * @param object 待赋值对象
//     */
//    private static void setHighLight(SearchHit hit, String filed, Object object){
//        //获取对应的高亮域
//        Map<String, HighlightField> highlightFields = hit.getHighlightFields();
//        HighlightField highlightField = highlightFields.get(filed);
//        if (highlightField != null){
//            //取得定义的高亮标签
//            String highLightMessage = highlightField.fragments()[0].toString();
//            // 反射调用set方法将高亮内容设置进去
//            try {
//                String setMethodName = parSetMethodName(filed);
//                Class<?> Clazz = object.getClass();
//                Method setMethod = Clazz.getMethod(setMethodName, String.class);
//                setMethod.invoke(object, highLightMessage);
//            } catch (Exception e) {
//                System.out.println("反射报错"+e);
//            }
//        }
//    }
//
//    /**
//     * 根据字段名，获取Set方法名
//     * @param fieldName 字段名
//     * @return  Set方法名
//     */
//    private static String parSetMethodName(String fieldName){
//        if (fieldName==null || fieldName.equals("")){
//            return null;
//        }
//        int startIndex = 0;
//        if (fieldName.charAt(0) == '_'){
//            startIndex = 1;
//        }
//        return "set" + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
//                + fieldName.substring(startIndex + 1);
//    }
}
