package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by ${aimimi2015} on 2017/6/13.
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {


    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    private CategoryMapper categoryMapper;

    public ServerResponse addCategory(String categoryName, Integer parentId) {


        if (parentId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.creatByErrorMessage("添加品类参数错误");
        }
        Category category = new Category();
        //System.out.println(categoryName);传过来时乱码了
        //categoryName=new String(categoryName.getBytes());
        System.out.println(categoryName);

        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);//这个分类是可用的

        int rowCount = categoryMapper.insert(category);
        if (rowCount > 0) {
            return ServerResponse.creatBySuccess("添加品类成功");
        }
        return ServerResponse.creatByErrorMessage("添加品类失败");
    }

    public ServerResponse updateCategoryName(Integer categoryId, String categoryName){
        if (categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.creatByErrorMessage("更新品类参数错误");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (rowCount > 0) {
            return ServerResponse.creatBySuccessMessage("更新品类的名字成功");
        }
        return ServerResponse.creatByErrorMessage("更新品类的名字失败");
    }

    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId){
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        //CollectionUtils.isEmpty技能判断是不是为null,还能判断是不是[]空集合
        if (CollectionUtils.isEmpty(categoryList)){
            logger.info("===未找到当前分类的子分类===");
        }
        return ServerResponse.creatBySuccess(categoryList);
    }

    /**
     * 递归查询本节点的id及孩子节点的id
     *
     * @param categoryId the category id
     * @return the server response
     */
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId){

        Set<Category> categorySet = Sets.newHashSet();
        findChildrenCategory(categorySet,categoryId);

        List<Integer> categoryIdList = Lists.newArrayList();
        if (categoryId!=null){
            for (Category categoryItem:categorySet){
              categoryIdList.add(categoryItem.getId());
            }
        }
        return ServerResponse.creatBySuccess(categoryIdList);

    }

    //递归算法,算出子节点
    private Set<Category> findChildrenCategory(Set<Category> categorySet,Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category!=null){
            categorySet.add(category);
        }
        //查找子节点。递归算法一定要有一个退出的条件   如果查找子节点categoryList为空，那么下面的for循环就进不去了
        //mybatis返回的categoryList没有结果也不会是null,不用非空判断
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for (Category categoryItem :categoryList){
            findChildrenCategory(categorySet,categoryItem.getId());
        }
        return categorySet;

    }


}

